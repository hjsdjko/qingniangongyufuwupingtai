package com.entity.view;

import com.entity.FangwuTousuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 房屋投诉
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fangwu_tousu")
public class FangwuTousuView extends FangwuTousuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 投诉类型的值
		*/
		private String fangwuTousuValue;
		/**
		* 是否处理的值
		*/
		private String fangwuTousuChuliValue;



		//级联表 fangwu
			/**
			* 房屋 的 商家
			*/
			private Integer fangwuShangjiaId;
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
				* 房屋类型的值
				*/
				private String fangwuValue;
			/**
			* 房屋朝向
			*/
			private Integer fangwuChaoxiangTypes;
				/**
				* 房屋朝向的值
				*/
				private String fangwuChaoxiangValue;
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
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer fangwuDelete;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 账户状态
			*/
			private Integer yonghuShiyongTypes;
				/**
				* 账户状态的值
				*/
				private String yonghuShiyongValue;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public FangwuTousuView() {

	}

	public FangwuTousuView(FangwuTousuEntity fangwuTousuEntity) {
		try {
			BeanUtils.copyProperties(this, fangwuTousuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 投诉类型的值
			*/
			public String getFangwuTousuValue() {
				return fangwuTousuValue;
			}
			/**
			* 设置： 投诉类型的值
			*/
			public void setFangwuTousuValue(String fangwuTousuValue) {
				this.fangwuTousuValue = fangwuTousuValue;
			}
			/**
			* 获取： 是否处理的值
			*/
			public String getFangwuTousuChuliValue() {
				return fangwuTousuChuliValue;
			}
			/**
			* 设置： 是否处理的值
			*/
			public void setFangwuTousuChuliValue(String fangwuTousuChuliValue) {
				this.fangwuTousuChuliValue = fangwuTousuChuliValue;
			}
















				//级联表的get和set fangwu

					/**
					* 获取：房屋 的 商家
					*/
					public Integer getFangwuShangjiaId() {
						return fangwuShangjiaId;
					}
					/**
					* 设置：房屋 的 商家
					*/
					public void setFangwuShangjiaId(Integer fangwuShangjiaId) {
						this.fangwuShangjiaId = fangwuShangjiaId;
					}


					/**
					* 获取： 房屋名称
					*/
					public String getFangwuName() {
						return fangwuName;
					}
					/**
					* 设置： 房屋名称
					*/
					public void setFangwuName(String fangwuName) {
						this.fangwuName = fangwuName;
					}

					/**
					* 获取： 房屋编号
					*/
					public String getFangwuUuidNumber() {
						return fangwuUuidNumber;
					}
					/**
					* 设置： 房屋编号
					*/
					public void setFangwuUuidNumber(String fangwuUuidNumber) {
						this.fangwuUuidNumber = fangwuUuidNumber;
					}

					/**
					* 获取： 房屋照片
					*/
					public String getFangwuPhoto() {
						return fangwuPhoto;
					}
					/**
					* 设置： 房屋照片
					*/
					public void setFangwuPhoto(String fangwuPhoto) {
						this.fangwuPhoto = fangwuPhoto;
					}

					/**
					* 获取： 所在小区
					*/
					public String getFangwuXiaoqu() {
						return fangwuXiaoqu;
					}
					/**
					* 设置： 所在小区
					*/
					public void setFangwuXiaoqu(String fangwuXiaoqu) {
						this.fangwuXiaoqu = fangwuXiaoqu;
					}

					/**
					* 获取： 详细地址
					*/
					public String getFangwuAddress() {
						return fangwuAddress;
					}
					/**
					* 设置： 详细地址
					*/
					public void setFangwuAddress(String fangwuAddress) {
						this.fangwuAddress = fangwuAddress;
					}

					/**
					* 获取： 房屋类型
					*/
					public Integer getFangwuTypes() {
						return fangwuTypes;
					}
					/**
					* 设置： 房屋类型
					*/
					public void setFangwuTypes(Integer fangwuTypes) {
						this.fangwuTypes = fangwuTypes;
					}


						/**
						* 获取： 房屋类型的值
						*/
						public String getFangwuValue() {
							return fangwuValue;
						}
						/**
						* 设置： 房屋类型的值
						*/
						public void setFangwuValue(String fangwuValue) {
							this.fangwuValue = fangwuValue;
						}

					/**
					* 获取： 房屋朝向
					*/
					public Integer getFangwuChaoxiangTypes() {
						return fangwuChaoxiangTypes;
					}
					/**
					* 设置： 房屋朝向
					*/
					public void setFangwuChaoxiangTypes(Integer fangwuChaoxiangTypes) {
						this.fangwuChaoxiangTypes = fangwuChaoxiangTypes;
					}


						/**
						* 获取： 房屋朝向的值
						*/
						public String getFangwuChaoxiangValue() {
							return fangwuChaoxiangValue;
						}
						/**
						* 设置： 房屋朝向的值
						*/
						public void setFangwuChaoxiangValue(String fangwuChaoxiangValue) {
							this.fangwuChaoxiangValue = fangwuChaoxiangValue;
						}

					/**
					* 获取： 平米
					*/
					public String getFangwuPingmi() {
						return fangwuPingmi;
					}
					/**
					* 设置： 平米
					*/
					public void setFangwuPingmi(String fangwuPingmi) {
						this.fangwuPingmi = fangwuPingmi;
					}

					/**
					* 获取： 房屋原价
					*/
					public Double getFangwuOldMoney() {
						return fangwuOldMoney;
					}
					/**
					* 设置： 房屋原价
					*/
					public void setFangwuOldMoney(Double fangwuOldMoney) {
						this.fangwuOldMoney = fangwuOldMoney;
					}

					/**
					* 获取： 房屋现价/月
					*/
					public Double getFangwuNewMoney() {
						return fangwuNewMoney;
					}
					/**
					* 设置： 房屋现价/月
					*/
					public void setFangwuNewMoney(Double fangwuNewMoney) {
						this.fangwuNewMoney = fangwuNewMoney;
					}

					/**
					* 获取： 房屋热度
					*/
					public Integer getFangwuClicknum() {
						return fangwuClicknum;
					}
					/**
					* 设置： 房屋热度
					*/
					public void setFangwuClicknum(Integer fangwuClicknum) {
						this.fangwuClicknum = fangwuClicknum;
					}

					/**
					* 获取： 房屋详细介绍
					*/
					public String getFangwuContent() {
						return fangwuContent;
					}
					/**
					* 设置： 房屋详细介绍
					*/
					public void setFangwuContent(String fangwuContent) {
						this.fangwuContent = fangwuContent;
					}

					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getFangwuDelete() {
						return fangwuDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setFangwuDelete(Integer fangwuDelete) {
						this.fangwuDelete = fangwuDelete;
					}
















				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 账户状态
					*/
					public Integer getYonghuShiyongTypes() {
						return yonghuShiyongTypes;
					}
					/**
					* 设置： 账户状态
					*/
					public void setYonghuShiyongTypes(Integer yonghuShiyongTypes) {
						this.yonghuShiyongTypes = yonghuShiyongTypes;
					}


						/**
						* 获取： 账户状态的值
						*/
						public String getYonghuShiyongValue() {
							return yonghuShiyongValue;
						}
						/**
						* 设置： 账户状态的值
						*/
						public void setYonghuShiyongValue(String yonghuShiyongValue) {
							this.yonghuShiyongValue = yonghuShiyongValue;
						}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}






}
