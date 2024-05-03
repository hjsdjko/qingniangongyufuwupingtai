package com.entity.model;

import com.entity.FangwuTousuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房屋投诉
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangwuTousuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 房屋
     */
    private Integer fangwuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 房屋投诉编号
     */
    private String fangwuTousuUuidNumber;


    /**
     * 投诉标题
     */
    private String fangwuTousuName;


    /**
     * 投诉类型
     */
    private Integer fangwuTousuTypes;


    /**
     * 投诉详情
     */
    private String fangwuTousuContent;


    /**
     * 投诉时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 是否处理
     */
    private Integer fangwuTousuChuliTypes;


    /**
     * 处理结果
     */
    private String fangwuTousuChuliContent;


    /**
     * 逻辑删除
     */
    private Integer fangwuTousuDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：房屋
	 */
    public Integer getFangwuId() {
        return fangwuId;
    }


    /**
	 * 设置：房屋
	 */
    public void setFangwuId(Integer fangwuId) {
        this.fangwuId = fangwuId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：房屋投诉编号
	 */
    public String getFangwuTousuUuidNumber() {
        return fangwuTousuUuidNumber;
    }


    /**
	 * 设置：房屋投诉编号
	 */
    public void setFangwuTousuUuidNumber(String fangwuTousuUuidNumber) {
        this.fangwuTousuUuidNumber = fangwuTousuUuidNumber;
    }
    /**
	 * 获取：投诉标题
	 */
    public String getFangwuTousuName() {
        return fangwuTousuName;
    }


    /**
	 * 设置：投诉标题
	 */
    public void setFangwuTousuName(String fangwuTousuName) {
        this.fangwuTousuName = fangwuTousuName;
    }
    /**
	 * 获取：投诉类型
	 */
    public Integer getFangwuTousuTypes() {
        return fangwuTousuTypes;
    }


    /**
	 * 设置：投诉类型
	 */
    public void setFangwuTousuTypes(Integer fangwuTousuTypes) {
        this.fangwuTousuTypes = fangwuTousuTypes;
    }
    /**
	 * 获取：投诉详情
	 */
    public String getFangwuTousuContent() {
        return fangwuTousuContent;
    }


    /**
	 * 设置：投诉详情
	 */
    public void setFangwuTousuContent(String fangwuTousuContent) {
        this.fangwuTousuContent = fangwuTousuContent;
    }
    /**
	 * 获取：投诉时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：投诉时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：是否处理
	 */
    public Integer getFangwuTousuChuliTypes() {
        return fangwuTousuChuliTypes;
    }


    /**
	 * 设置：是否处理
	 */
    public void setFangwuTousuChuliTypes(Integer fangwuTousuChuliTypes) {
        this.fangwuTousuChuliTypes = fangwuTousuChuliTypes;
    }
    /**
	 * 获取：处理结果
	 */
    public String getFangwuTousuChuliContent() {
        return fangwuTousuChuliContent;
    }


    /**
	 * 设置：处理结果
	 */
    public void setFangwuTousuChuliContent(String fangwuTousuChuliContent) {
        this.fangwuTousuChuliContent = fangwuTousuChuliContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFangwuTousuDelete() {
        return fangwuTousuDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setFangwuTousuDelete(Integer fangwuTousuDelete) {
        this.fangwuTousuDelete = fangwuTousuDelete;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
