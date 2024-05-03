package com.entity.vo;

import com.entity.FangwuOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 预约看房
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangwu_order")
public class FangwuOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
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
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
