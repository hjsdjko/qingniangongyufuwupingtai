package com.entity.model;

import com.entity.FangwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房屋
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 商家
     */
    private Integer shangjiaId;


    /**
     * 房屋名称
     */
    private String fangwuName;


    /**
     * 房屋编号
     */
    private String fangwuUuidNumber;


    /**
     * 房屋照片
     */
    private String fangwuPhoto;


    /**
     * 所在小区
     */
    private String fangwuXiaoqu;


    /**
     * 详细地址
     */
    private String fangwuAddress;


    /**
     * 房屋类型
     */
    private Integer fangwuTypes;


    /**
     * 房屋朝向
     */
    private Integer fangwuChaoxiangTypes;


    /**
     * 平米
     */
    private String fangwuPingmi;


    /**
     * 房屋原价
     */
    private Double fangwuOldMoney;


    /**
     * 房屋现价/月
     */
    private Double fangwuNewMoney;


    /**
     * 房屋热度
     */
    private Integer fangwuClicknum;


    /**
     * 房屋详细介绍
     */
    private String fangwuContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer fangwuDelete;


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
	 * 获取：商家
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 设置：商家
	 */
    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 获取：房屋名称
	 */
    public String getFangwuName() {
        return fangwuName;
    }


    /**
	 * 设置：房屋名称
	 */
    public void setFangwuName(String fangwuName) {
        this.fangwuName = fangwuName;
    }
    /**
	 * 获取：房屋编号
	 */
    public String getFangwuUuidNumber() {
        return fangwuUuidNumber;
    }


    /**
	 * 设置：房屋编号
	 */
    public void setFangwuUuidNumber(String fangwuUuidNumber) {
        this.fangwuUuidNumber = fangwuUuidNumber;
    }
    /**
	 * 获取：房屋照片
	 */
    public String getFangwuPhoto() {
        return fangwuPhoto;
    }


    /**
	 * 设置：房屋照片
	 */
    public void setFangwuPhoto(String fangwuPhoto) {
        this.fangwuPhoto = fangwuPhoto;
    }
    /**
	 * 获取：所在小区
	 */
    public String getFangwuXiaoqu() {
        return fangwuXiaoqu;
    }


    /**
	 * 设置：所在小区
	 */
    public void setFangwuXiaoqu(String fangwuXiaoqu) {
        this.fangwuXiaoqu = fangwuXiaoqu;
    }
    /**
	 * 获取：详细地址
	 */
    public String getFangwuAddress() {
        return fangwuAddress;
    }


    /**
	 * 设置：详细地址
	 */
    public void setFangwuAddress(String fangwuAddress) {
        this.fangwuAddress = fangwuAddress;
    }
    /**
	 * 获取：房屋类型
	 */
    public Integer getFangwuTypes() {
        return fangwuTypes;
    }


    /**
	 * 设置：房屋类型
	 */
    public void setFangwuTypes(Integer fangwuTypes) {
        this.fangwuTypes = fangwuTypes;
    }
    /**
	 * 获取：房屋朝向
	 */
    public Integer getFangwuChaoxiangTypes() {
        return fangwuChaoxiangTypes;
    }


    /**
	 * 设置：房屋朝向
	 */
    public void setFangwuChaoxiangTypes(Integer fangwuChaoxiangTypes) {
        this.fangwuChaoxiangTypes = fangwuChaoxiangTypes;
    }
    /**
	 * 获取：平米
	 */
    public String getFangwuPingmi() {
        return fangwuPingmi;
    }


    /**
	 * 设置：平米
	 */
    public void setFangwuPingmi(String fangwuPingmi) {
        this.fangwuPingmi = fangwuPingmi;
    }
    /**
	 * 获取：房屋原价
	 */
    public Double getFangwuOldMoney() {
        return fangwuOldMoney;
    }


    /**
	 * 设置：房屋原价
	 */
    public void setFangwuOldMoney(Double fangwuOldMoney) {
        this.fangwuOldMoney = fangwuOldMoney;
    }
    /**
	 * 获取：房屋现价/月
	 */
    public Double getFangwuNewMoney() {
        return fangwuNewMoney;
    }


    /**
	 * 设置：房屋现价/月
	 */
    public void setFangwuNewMoney(Double fangwuNewMoney) {
        this.fangwuNewMoney = fangwuNewMoney;
    }
    /**
	 * 获取：房屋热度
	 */
    public Integer getFangwuClicknum() {
        return fangwuClicknum;
    }


    /**
	 * 设置：房屋热度
	 */
    public void setFangwuClicknum(Integer fangwuClicknum) {
        this.fangwuClicknum = fangwuClicknum;
    }
    /**
	 * 获取：房屋详细介绍
	 */
    public String getFangwuContent() {
        return fangwuContent;
    }


    /**
	 * 设置：房屋详细介绍
	 */
    public void setFangwuContent(String fangwuContent) {
        this.fangwuContent = fangwuContent;
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
    public Integer getFangwuDelete() {
        return fangwuDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setFangwuDelete(Integer fangwuDelete) {
        this.fangwuDelete = fangwuDelete;
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
