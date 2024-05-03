package com.entity.model;

import com.entity.BokeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 博客
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BokeModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 博客名称
     */
    private String bokeName;


    /**
     * 博客编号
     */
    private String bokeUuidNumber;


    /**
     * 博客照片
     */
    private String bokePhoto;


    /**
     * 博客类型
     */
    private Integer bokeTypes;


    /**
     * 博客热度
     */
    private Integer bokeClicknum;


    /**
     * 博客内容
     */
    private String bokeContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer bokeDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：博客名称
	 */
    public String getBokeName() {
        return bokeName;
    }


    /**
	 * 设置：博客名称
	 */
    public void setBokeName(String bokeName) {
        this.bokeName = bokeName;
    }
    /**
	 * 获取：博客编号
	 */
    public String getBokeUuidNumber() {
        return bokeUuidNumber;
    }


    /**
	 * 设置：博客编号
	 */
    public void setBokeUuidNumber(String bokeUuidNumber) {
        this.bokeUuidNumber = bokeUuidNumber;
    }
    /**
	 * 获取：博客照片
	 */
    public String getBokePhoto() {
        return bokePhoto;
    }


    /**
	 * 设置：博客照片
	 */
    public void setBokePhoto(String bokePhoto) {
        this.bokePhoto = bokePhoto;
    }
    /**
	 * 获取：博客类型
	 */
    public Integer getBokeTypes() {
        return bokeTypes;
    }


    /**
	 * 设置：博客类型
	 */
    public void setBokeTypes(Integer bokeTypes) {
        this.bokeTypes = bokeTypes;
    }
    /**
	 * 获取：博客热度
	 */
    public Integer getBokeClicknum() {
        return bokeClicknum;
    }


    /**
	 * 设置：博客热度
	 */
    public void setBokeClicknum(Integer bokeClicknum) {
        this.bokeClicknum = bokeClicknum;
    }
    /**
	 * 获取：博客内容
	 */
    public String getBokeContent() {
        return bokeContent;
    }


    /**
	 * 设置：博客内容
	 */
    public void setBokeContent(String bokeContent) {
        this.bokeContent = bokeContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getBokeDelete() {
        return bokeDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setBokeDelete(Integer bokeDelete) {
        this.bokeDelete = bokeDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
