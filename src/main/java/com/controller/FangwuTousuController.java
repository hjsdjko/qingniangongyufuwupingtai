
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 房屋投诉
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fangwuTousu")
public class FangwuTousuController {
    private static final Logger logger = LoggerFactory.getLogger(FangwuTousuController.class);

    @Autowired
    private FangwuTousuService fangwuTousuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private FangwuService fangwuService;
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
        params.put("fangwuTousuDeleteStart",1);params.put("fangwuTousuDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = fangwuTousuService.queryPage(params);

        //字典表数据转换
        List<FangwuTousuView> list =(List<FangwuTousuView>)page.getList();
        for(FangwuTousuView c:list){
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
        FangwuTousuEntity fangwuTousu = fangwuTousuService.selectById(id);
        if(fangwuTousu !=null){
            //entity转view
            FangwuTousuView view = new FangwuTousuView();
            BeanUtils.copyProperties( fangwuTousu , view );//把实体数据重构到view中

                //级联表
                FangwuEntity fangwu = fangwuService.selectById(fangwuTousu.getFangwuId());
                if(fangwu != null){
                    BeanUtils.copyProperties( fangwu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangwuId(fangwu.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(fangwuTousu.getYonghuId());
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
    public R save(@RequestBody FangwuTousuEntity fangwuTousu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangwuTousu:{}",this.getClass().getName(),fangwuTousu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            fangwuTousu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<FangwuTousuEntity> queryWrapper = new EntityWrapper<FangwuTousuEntity>()
            .eq("fangwu_id", fangwuTousu.getFangwuId())
            .eq("yonghu_id", fangwuTousu.getYonghuId())
            .eq("fangwu_tousu_uuid_number", fangwuTousu.getFangwuTousuUuidNumber())
            .eq("fangwu_tousu_name", fangwuTousu.getFangwuTousuName())
            .eq("fangwu_tousu_types", fangwuTousu.getFangwuTousuTypes())
            .eq("fangwu_tousu_chuli_types", fangwuTousu.getFangwuTousuChuliTypes())
            .eq("fangwu_tousu_delete", fangwuTousu.getFangwuTousuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangwuTousuEntity fangwuTousuEntity = fangwuTousuService.selectOne(queryWrapper);
        if(fangwuTousuEntity==null){
            fangwuTousu.setInsertTime(new Date());
            fangwuTousu.setFangwuTousuDelete(1);
            fangwuTousu.setCreateTime(new Date());
            fangwuTousuService.insert(fangwuTousu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangwuTousuEntity fangwuTousu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fangwuTousu:{}",this.getClass().getName(),fangwuTousu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            fangwuTousu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<FangwuTousuEntity> queryWrapper = new EntityWrapper<FangwuTousuEntity>()
            .notIn("id",fangwuTousu.getId())
            .andNew()
            .eq("fangwu_id", fangwuTousu.getFangwuId())
            .eq("yonghu_id", fangwuTousu.getYonghuId())
            .eq("fangwu_tousu_uuid_number", fangwuTousu.getFangwuTousuUuidNumber())
            .eq("fangwu_tousu_name", fangwuTousu.getFangwuTousuName())
            .eq("fangwu_tousu_types", fangwuTousu.getFangwuTousuTypes())
            .eq("fangwu_tousu_chuli_types", fangwuTousu.getFangwuTousuChuliTypes())
            .eq("fangwu_tousu_delete", fangwuTousu.getFangwuTousuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangwuTousuEntity fangwuTousuEntity = fangwuTousuService.selectOne(queryWrapper);
        if(fangwuTousuEntity==null){
            fangwuTousuService.updateById(fangwuTousu);//根据id更新
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
        ArrayList<FangwuTousuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            FangwuTousuEntity fangwuTousuEntity = new FangwuTousuEntity();
            fangwuTousuEntity.setId(id);
            fangwuTousuEntity.setFangwuTousuDelete(2);
            list.add(fangwuTousuEntity);
        }
        if(list != null && list.size() >0){
            fangwuTousuService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<FangwuTousuEntity> fangwuTousuList = new ArrayList<>();//上传的东西
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
                            FangwuTousuEntity fangwuTousuEntity = new FangwuTousuEntity();
//                            fangwuTousuEntity.setFangwuId(Integer.valueOf(data.get(0)));   //房屋 要改的
//                            fangwuTousuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            fangwuTousuEntity.setFangwuTousuUuidNumber(data.get(0));                    //房屋投诉编号 要改的
//                            fangwuTousuEntity.setFangwuTousuName(data.get(0));                    //投诉标题 要改的
//                            fangwuTousuEntity.setFangwuTousuTypes(Integer.valueOf(data.get(0)));   //投诉类型 要改的
//                            fangwuTousuEntity.setFangwuTousuContent("");//详情和图片
//                            fangwuTousuEntity.setInsertTime(date);//时间
//                            fangwuTousuEntity.setFangwuTousuChuliTypes(Integer.valueOf(data.get(0)));   //是否处理 要改的
//                            fangwuTousuEntity.setFangwuTousuChuliContent("");//详情和图片
//                            fangwuTousuEntity.setFangwuTousuDelete(1);//逻辑删除字段
//                            fangwuTousuEntity.setCreateTime(date);//时间
                            fangwuTousuList.add(fangwuTousuEntity);


                            //把要查询是否重复的字段放入map中
                                //房屋投诉编号
                                if(seachFields.containsKey("fangwuTousuUuidNumber")){
                                    List<String> fangwuTousuUuidNumber = seachFields.get("fangwuTousuUuidNumber");
                                    fangwuTousuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> fangwuTousuUuidNumber = new ArrayList<>();
                                    fangwuTousuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("fangwuTousuUuidNumber",fangwuTousuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //房屋投诉编号
                        List<FangwuTousuEntity> fangwuTousuEntities_fangwuTousuUuidNumber = fangwuTousuService.selectList(new EntityWrapper<FangwuTousuEntity>().in("fangwu_tousu_uuid_number", seachFields.get("fangwuTousuUuidNumber")).eq("fangwu_tousu_delete", 1));
                        if(fangwuTousuEntities_fangwuTousuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FangwuTousuEntity s:fangwuTousuEntities_fangwuTousuUuidNumber){
                                repeatFields.add(s.getFangwuTousuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [房屋投诉编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        fangwuTousuService.insertBatch(fangwuTousuList);
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
        PageUtils page = fangwuTousuService.queryPage(params);

        //字典表数据转换
        List<FangwuTousuView> list =(List<FangwuTousuView>)page.getList();
        for(FangwuTousuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangwuTousuEntity fangwuTousu = fangwuTousuService.selectById(id);
            if(fangwuTousu !=null){


                //entity转view
                FangwuTousuView view = new FangwuTousuView();
                BeanUtils.copyProperties( fangwuTousu , view );//把实体数据重构到view中

                //级联表
                    FangwuEntity fangwu = fangwuService.selectById(fangwuTousu.getFangwuId());
                if(fangwu != null){
                    BeanUtils.copyProperties( fangwu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangwuId(fangwu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(fangwuTousu.getYonghuId());
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
    public R add(@RequestBody FangwuTousuEntity fangwuTousu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fangwuTousu:{}",this.getClass().getName(),fangwuTousu.toString());
        Wrapper<FangwuTousuEntity> queryWrapper = new EntityWrapper<FangwuTousuEntity>()
            .eq("fangwu_id", fangwuTousu.getFangwuId())
            .eq("yonghu_id", fangwuTousu.getYonghuId())
            .eq("fangwu_tousu_uuid_number", fangwuTousu.getFangwuTousuUuidNumber())
            .eq("fangwu_tousu_name", fangwuTousu.getFangwuTousuName())
            .eq("fangwu_tousu_types", fangwuTousu.getFangwuTousuTypes())
            .eq("fangwu_tousu_chuli_types", fangwuTousu.getFangwuTousuChuliTypes())
            .eq("fangwu_tousu_delete", fangwuTousu.getFangwuTousuDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangwuTousuEntity fangwuTousuEntity = fangwuTousuService.selectOne(queryWrapper);
        if(fangwuTousuEntity==null){
            fangwuTousu.setFangwuTousuChuliTypes(1);
            fangwuTousu.setInsertTime(new Date());
            fangwuTousu.setFangwuTousuDelete(1);
            fangwuTousu.setCreateTime(new Date());
        fangwuTousuService.insert(fangwuTousu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
