package com.entity.vo;

import com.entity.FangwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 房屋
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangwu")
public class FangwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 商家
     */

    @TableField(value = "shangjia_id")
    private Integer shangjiaId;


    /**
     * 房屋名称
     */

    @TableField(value = "fangwu_name")
    private String fangwuName;


    /**
     * 房屋编号
     */

    @TableField(value = "fangwu_uuid_number")
    private String fangwuUuidNumber;


    /**
     * 房屋照片
     */

    @TableField(value = "fangwu_photo")
    private String fangwuPhoto;


    /**
     * 所在小区
     */

    @TableField(value = "fangwu_xiaoqu")
    private String fangwuXiaoqu;


    /**
     * 详细地址
     */

    @TableField(value = "fangwu_address")
    private String fangwuAddress;


    /**
     * 房屋类型
     */

    @TableField(value = "fangwu_types")
    private Integer fangwuTypes;


    /**
     * 房屋朝向
     */

    @TableField(value = "fangwu_chaoxiang_types")
    private Integer fangwuChaoxiangTypes;


    /**
     * 平米
     */

    @TableField(value = "fangwu_pingmi")
    private String fangwuPingmi;


    /**
     * 房屋原价
     */

    @TableField(value = "fangwu_old_money")
    private Double fangwuOldMoney;


    /**
     * 房屋现价/月
     */

    @TableField(value = "fangwu_new_money")
    private Double fangwuNewMoney;


    /**
     * 房屋热度
     */

    @TableField(value = "fangwu_clicknum")
    private Integer fangwuClicknum;


    /**
     * 房屋详细介绍
     */

    @TableField(value = "fangwu_content")
    private String fangwuContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "fangwu_delete")
    private Integer fangwuDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：商家
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 获取：商家
	 */

    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 设置：房屋名称
	 */
    public String getFangwuName() {
        return fangwuName;
    }


    /**
	 * 获取：房屋名称
	 */

    public void setFangwuName(String fangwuName) {
        this.fangwuName = fangwuName;
    }
    /**
	 * 设置：房屋编号
	 */
    public String getFangwuUuidNumber() {
        return fangwuUuidNumber;
    }


    /**
	 * 获取：房屋编号
	 */

    public void setFangwuUuidNumber(String fangwuUuidNumber) {
        this.fangwuUuidNumber = fangwuUuidNumber;
    }
    /**
	 * 设置：房屋照片
	 */
    public String getFangwuPhoto() {
        return fangwuPhoto;
    }


    /**
	 * 获取：房屋照片
	 */

    public void setFangwuPhoto(String fangwuPhoto) {
        this.fangwuPhoto = fangwuPhoto;
    }
    /**
	 * 设置：所在小区
	 */
    public String getFangwuXiaoqu() {
        return fangwuXiaoqu;
    }


    /**
	 * 获取：所在小区
	 */

    public void setFangwuXiaoqu(String fangwuXiaoqu) {
        this.fangwuXiaoqu = fangwuXiaoqu;
    }
    /**
	 * 设置：详细地址
	 */
    public String getFangwuAddress() {
        return fangwuAddress;
    }


    /**
	 * 获取：详细地址
	 */

    public void setFangwuAddress(String fangwuAddress) {
        this.fangwuAddress = fangwuAddress;
    }
    /**
	 * 设置：房屋类型
	 */
    public Integer getFangwuTypes() {
        return fangwuTypes;
    }


    /**
	 * 获取：房屋类型
	 */

    public void setFangwuTypes(Integer fangwuTypes) {
        this.fangwuTypes = fangwuTypes;
    }
    /**
	 * 设置：房屋朝向
	 */
    public Integer getFangwuChaoxiangTypes() {
        return fangwuChaoxiangTypes;
    }


    /**
	 * 获取：房屋朝向
	 */

    public void setFangwuChaoxiangTypes(Integer fangwuChaoxiangTypes) {
        this.fangwuChaoxiangTypes = fangwuChaoxiangTypes;
    }
    /**
	 * 设置：平米
	 */
    public String getFangwuPingmi() {
        return fangwuPingmi;
    }


    /**
	 * 获取：平米
	 */

    public void setFangwuPingmi(String fangwuPingmi) {
        this.fangwuPingmi = fangwuPingmi;
    }
    /**
	 * 设置：房屋原价
	 */
    public Double getFangwuOldMoney() {
        return fangwuOldMoney;
    }


    /**
	 * 获取：房屋原价
	 */

    public void setFangwuOldMoney(Double fangwuOldMoney) {
        this.fangwuOldMoney = fangwuOldMoney;
    }
    /**
	 * 设置：房屋现价/月
	 */
    public Double getFangwuNewMoney() {
        return fangwuNewMoney;
    }


    /**
	 * 获取：房屋现价/月
	 */

    public void setFangwuNewMoney(Double fangwuNewMoney) {
        this.fangwuNewMoney = fangwuNewMoney;
    }
    /**
	 * 设置：房屋热度
	 */
    public Integer getFangwuClicknum() {
        return fangwuClicknum;
    }


    /**
	 * 获取：房屋热度
	 */

    public void setFangwuClicknum(Integer fangwuClicknum) {
        this.fangwuClicknum = fangwuClicknum;
    }
    /**
	 * 设置：房屋详细介绍
	 */
    public String getFangwuContent() {
        return fangwuContent;
    }


    /**
	 * 获取：房屋详细介绍
	 */

    public void setFangwuContent(String fangwuContent) {
        this.fangwuContent = fangwuContent;
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
    public Integer getFangwuDelete() {
        return fangwuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setFangwuDelete(Integer fangwuDelete) {
        this.fangwuDelete = fangwuDelete;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
