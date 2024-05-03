package com.dao;

import com.entity.FangwuTousuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangwuTousuView;

/**
 * 房屋投诉 Dao 接口
 *
 * @author 
 */
public interface FangwuTousuDao extends BaseMapper<FangwuTousuEntity> {

   List<FangwuTousuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
