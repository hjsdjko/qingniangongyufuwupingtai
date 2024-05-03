package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 预约看房
 *
 * @author 
 * @email
 */
@TableName("fangwu_order")
public class FangwuOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangwuOrderEntity() {

	}

	public FangwuOrderEntity(T t) {
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
     * 看房编号
     */
    @TableField(value = "fangwu_order_uuid_number")

    private String fangwuOrderUuidNumber;


    /**
     * 房屋
     */
    @TableField(value = "fangwu_id")

    private Integer fangwuId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 申请看房时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "yuyue_time")

    private Date yuyueTime;


    /**
     * 预约状态
     */
    @TableField(value = "fangwu_order_yesno_types")

    private Integer fangwuOrderYesnoTypes;


    /**
     * 审核意见
     */
    @TableField(value = "fangwu_order_yesno_text")

    private String fangwuOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "fangwu_order_shenhe_time")

    private Date fangwuOrderShenheTime;


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
	 * 设置：看房编号
	 */
    public String getFangwuOrderUuidNumber() {
        return fangwuOrderUuidNumber;
    }
    /**
	 * 获取：看房编号
	 */

    public void setFangwuOrderUuidNumber(String fangwuOrderUuidNumber) {
        this.fangwuOrderUuidNumber = fangwuOrderUuidNumber;
    }
    /**
	 * 设置：房屋
	 */
    public Integer getFangwuId() {
        return fangwuId;
    }
    /**
	 * 获取：房屋
	 */

    public void setFangwuId(Integer fangwuId) {
        this.fangwuId = fangwuId;
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
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：申请看房时间
	 */
    public Date getYuyueTime() {
        return yuyueTime;
    }
    /**
	 * 获取：申请看房时间
	 */

    public void setYuyueTime(Date yuyueTime) {
        this.yuyueTime = yuyueTime;
    }
    /**
	 * 设置：预约状态
	 */
    public Integer getFangwuOrderYesnoTypes() {
        return fangwuOrderYesnoTypes;
    }
    /**
	 * 获取：预约状态
	 */

    public void setFangwuOrderYesnoTypes(Integer fangwuOrderYesnoTypes) {
        this.fangwuOrderYesnoTypes = fangwuOrderYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getFangwuOrderYesnoText() {
        return fangwuOrderYesnoText;
    }
    /**
	 * 获取：审核意见
	 */

    public void setFangwuOrderYesnoText(String fangwuOrderYesnoText) {
        this.fangwuOrderYesnoText = fangwuOrderYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getFangwuOrderShenheTime() {
        return fangwuOrderShenheTime;
    }
    /**
	 * 获取：审核时间
	 */

    public void setFangwuOrderShenheTime(Date fangwuOrderShenheTime) {
        this.fangwuOrderShenheTime = fangwuOrderShenheTime;
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
        return "FangwuOrder{" +
            "id=" + id +
            ", fangwuOrderUuidNumber=" + fangwuOrderUuidNumber +
            ", fangwuId=" + fangwuId +
            ", yonghuId=" + yonghuId +
            ", insertTime=" + insertTime +
            ", yuyueTime=" + yuyueTime +
            ", fangwuOrderYesnoTypes=" + fangwuOrderYesnoTypes +
            ", fangwuOrderYesnoText=" + fangwuOrderYesnoText +
            ", fangwuOrderShenheTime=" + fangwuOrderShenheTime +
            ", createTime=" + createTime +
        "}";
    }
}
