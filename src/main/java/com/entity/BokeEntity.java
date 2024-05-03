package com.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * 博客
 *
 * @author 
 * @email
 */
@TableName("boke")
public class BokeEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BokeEntity() {

	}

	public BokeEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 博客名称
     */
    @TableField(value = "boke_name")

    private String bokeName;


    /**
     * 博客编号
     */
    @TableField(value = "boke_uuid_number")

    private String bokeUuidNumber;


    /**
     * 博客照片
     */
    @TableField(value = "boke_photo")

    private String bokePhoto;


    /**
     * 博客类型
     */
    @TableField(value = "boke_types")

    private Integer bokeTypes;


    /**
     * 博客热度
     */
    @TableField(value = "boke_clicknum")

    private Integer bokeClicknum;


    /**
     * 博客内容
     */
    @TableField(value = "boke_content")

    private String bokeContent;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "boke_delete")

    private Integer bokeDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：博客名称
	 */
    public String getBokeName() {
        return bokeName;
    }
    /**
	 * 获取：博客名称
	 */

    public void setBokeName(String bokeName) {
        this.bokeName = bokeName;
    }
    /**
	 * 设置：博客编号
	 */
    public String getBokeUuidNumber() {
        return bokeUuidNumber;
    }
    /**
	 * 获取：博客编号
	 */

    public void setBokeUuidNumber(String bokeUuidNumber) {
        this.bokeUuidNumber = bokeUuidNumber;
    }
    /**
	 * 设置：博客照片
	 */
    public String getBokePhoto() {
        return bokePhoto;
    }
    /**
	 * 获取：博客照片
	 */

    public void setBokePhoto(String bokePhoto) {
        this.bokePhoto = bokePhoto;
    }
    /**
	 * 设置：博客类型
	 */
    public Integer getBokeTypes() {
        return bokeTypes;
    }
    /**
	 * 获取：博客类型
	 */

    public void setBokeTypes(Integer bokeTypes) {
        this.bokeTypes = bokeTypes;
    }
    /**
	 * 设置：博客热度
	 */
    public Integer getBokeClicknum() {
        return bokeClicknum;
    }
    /**
	 * 获取：博客热度
	 */

    public void setBokeClicknum(Integer bokeClicknum) {
        this.bokeClicknum = bokeClicknum;
    }
    /**
	 * 设置：博客内容
	 */
    public String getBokeContent() {
        return bokeContent;
    }
    /**
	 * 获取：博客内容
	 */

    public void setBokeContent(String bokeContent) {
        this.bokeContent = bokeContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getBokeDelete() {
        return bokeDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setBokeDelete(Integer bokeDelete) {
        this.bokeDelete = bokeDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Boke{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", bokeName=" + bokeName +
            ", bokeUuidNumber=" + bokeUuidNumber +
            ", bokePhoto=" + bokePhoto +
            ", bokeTypes=" + bokeTypes +
            ", bokeClicknum=" + bokeClicknum +
            ", bokeContent=" + bokeContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", bokeDelete=" + bokeDelete +
            ", createTime=" + createTime +
        "}";
    }
}
