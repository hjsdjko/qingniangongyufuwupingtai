
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.BokeEntity;
import com.entity.YonghuEntity;
import com.entity.view.BokeView;
import com.service.BokeService;
import com.service.DictionaryService;
import com.service.TokenService;
import com.service.YonghuService;
import com.utils.PageUtils;
import com.utils.PoiUtil;
import com.utils.R;
import com.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 博客
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/boke")
public class BokeController {
    private static final Logger logger = LoggerFactory.getLogger(BokeController.class);

    @Autowired
    private BokeService bokeService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("商家".equals(role))
            params.put("shangjiaId",request.getSession().getAttribute("userId"));
        params.put("bokeDeleteStart",1);params.put("bokeDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = bokeService.queryPage(params);

        //字典表数据转换
        List<BokeView> list =(List<BokeView>)page.getList();
        for(BokeView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BokeEntity boke = bokeService.selectById(id);
        if(boke !=null){
            //entity转view
            BokeView view = new BokeView();
            BeanUtils.copyProperties( boke , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(boke.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody BokeEntity boke, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,boke:{}",this.getClass().getName(),boke.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            boke.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<BokeEntity> queryWrapper = new EntityWrapper<BokeEntity>()
            .eq("yonghu_id", boke.getYonghuId())
            .eq("boke_name", boke.getBokeName())
            .eq("boke_uuid_number", boke.getBokeUuidNumber())
            .eq("boke_types", boke.getBokeTypes())
            .eq("boke_clicknum", boke.getBokeClicknum())
            .eq("shangxia_types", boke.getShangxiaTypes())
            .eq("boke_delete", boke.getBokeDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BokeEntity bokeEntity = bokeService.selectOne(queryWrapper);
        if(bokeEntity==null){
            boke.setBokeClicknum(1);
            boke.setShangxiaTypes(2);
            boke.setBokeDelete(1);
            boke.setCreateTime(new Date());
            bokeService.insert(boke);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BokeEntity boke, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,boke:{}",this.getClass().getName(),boke.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            boke.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<BokeEntity> queryWrapper = new EntityWrapper<BokeEntity>()
            .notIn("id",boke.getId())
            .andNew()
            .eq("yonghu_id", boke.getYonghuId())
            .eq("boke_name", boke.getBokeName())
            .eq("boke_uuid_number", boke.getBokeUuidNumber())
            .eq("boke_types", boke.getBokeTypes())
            .eq("boke_clicknum", boke.getBokeClicknum())
            .eq("shangxia_types", boke.getShangxiaTypes())
            .eq("boke_delete", boke.getBokeDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BokeEntity bokeEntity = bokeService.selectOne(queryWrapper);
        if("".equals(boke.getBokePhoto()) || "null".equals(boke.getBokePhoto())){
                boke.setBokePhoto(null);
        }
        if(bokeEntity==null){
            bokeService.updateById(boke);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<BokeEntity> list = new ArrayList<>();
        for(Integer id:ids){
            BokeEntity bokeEntity = new BokeEntity();
            bokeEntity.setId(id);
            bokeEntity.setBokeDelete(2);
            list.add(bokeEntity);
        }
        if(list != null && list.size() >0){
            bokeService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save(String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<BokeEntity> bokeList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            BokeEntity bokeEntity = new BokeEntity();
//                            bokeEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            bokeEntity.setBokeName(data.get(0));                    //博客名称 要改的
//                            bokeEntity.setBokeUuidNumber(data.get(0));                    //博客编号 要改的
//                            bokeEntity.setBokePhoto("");//详情和图片
//                            bokeEntity.setBokeTypes(Integer.valueOf(data.get(0)));   //博客类型 要改的
//                            bokeEntity.setBokeClicknum(Integer.valueOf(data.get(0)));   //博客热度 要改的
//                            bokeEntity.setBokeContent("");//详情和图片
//                            bokeEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            bokeEntity.setBokeDelete(1);//逻辑删除字段
//                            bokeEntity.setCreateTime(date);//时间
                            bokeList.add(bokeEntity);


                            //把要查询是否重复的字段放入map中
                                //博客编号
                                if(seachFields.containsKey("bokeUuidNumber")){
                                    List<String> bokeUuidNumber = seachFields.get("bokeUuidNumber");
                                    bokeUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> bokeUuidNumber = new ArrayList<>();
                                    bokeUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("bokeUuidNumber",bokeUuidNumber);
                                }
                        }

                        //查询是否重复
                         //博客编号
                        List<BokeEntity> bokeEntities_bokeUuidNumber = bokeService.selectList(new EntityWrapper<BokeEntity>().in("boke_uuid_number", seachFields.get("bokeUuidNumber")).eq("boke_delete", 1));
                        if(bokeEntities_bokeUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BokeEntity s:bokeEntities_bokeUuidNumber){
                                repeatFields.add(s.getBokeUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [博客编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        bokeService.insertBatch(bokeList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = bokeService.queryPage(params);

        //字典表数据转换
        List<BokeView> list =(List<BokeView>)page.getList();
        for(BokeView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BokeEntity boke = bokeService.selectById(id);
            if(boke !=null){

                //点击数量加1
                boke.setBokeClicknum(boke.getBokeClicknum()+1);
                bokeService.updateById(boke);

                //entity转view
                BokeView view = new BokeView();
                BeanUtils.copyProperties( boke , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(boke.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody BokeEntity boke, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,boke:{}",this.getClass().getName(),boke.toString());
        Wrapper<BokeEntity> queryWrapper = new EntityWrapper<BokeEntity>()
            .eq("yonghu_id", boke.getYonghuId())
            .eq("boke_name", boke.getBokeName())
            .eq("boke_uuid_number", boke.getBokeUuidNumber())
            .eq("boke_types", boke.getBokeTypes())
            .eq("boke_clicknum", boke.getBokeClicknum())
            .eq("shangxia_types", boke.getShangxiaTypes())
            .eq("boke_delete", boke.getBokeDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BokeEntity bokeEntity = bokeService.selectOne(queryWrapper);
        if(bokeEntity==null){
            boke.setBokeDelete(1);
            boke.setCreateTime(new Date());
        bokeService.insert(boke);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
