package com.entity.view;

import com.entity.FangwuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 房屋
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fangwu")
public class FangwuView extends FangwuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 房屋类型的值
		*/
		private String fangwuValue;
		/**
		* 房屋朝向的值
		*/
		private String fangwuChaoxiangValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



		//级联表 shangjia
			/**
			* 商家名称
			*/
			private String shangjiaName;
			/**
			* 联系方式
			*/
			private String shangjiaPhone;
			/**
			* 邮箱
			*/
			private String shangjiaEmail;
			/**
			* 商家照片
			*/
			private String shangjiaPhoto;
			/**
			* 商家信用类型
			*/
			private Integer shangjiaXingjiTypes;
				/**
				* 商家信用类型的值
				*/
				private String shangjiaXingjiValue;
			/**
			* 账户状态
			*/
			private Integer shangjiaShiyongTypes;
				/**
				* 账户状态的值
				*/
				private String shangjiaShiyongValue;
			/**
			* 商家简介
			*/
			private String shangjiaContent;
			/**
			* 逻辑删除
			*/
			private Integer shangjiaDelete;

	public FangwuView() {

	}

	public FangwuView(FangwuEntity fangwuEntity) {
		try {
			BeanUtils.copyProperties(this, fangwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
























				//级联表的get和set shangjia

					/**
					* 获取： 商家名称
					*/
					public String getShangjiaName() {
						return shangjiaName;
					}
					/**
					* 设置： 商家名称
					*/
					public void setShangjiaName(String shangjiaName) {
						this.shangjiaName = shangjiaName;
					}

					/**
					* 获取： 联系方式
					*/
					public String getShangjiaPhone() {
						return shangjiaPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setShangjiaPhone(String shangjiaPhone) {
						this.shangjiaPhone = shangjiaPhone;
					}

					/**
					* 获取： 邮箱
					*/
					public String getShangjiaEmail() {
						return shangjiaEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setShangjiaEmail(String shangjiaEmail) {
						this.shangjiaEmail = shangjiaEmail;
					}

					/**
					* 获取： 商家照片
					*/
					public String getShangjiaPhoto() {
						return shangjiaPhoto;
					}
					/**
					* 设置： 商家照片
					*/
					public void setShangjiaPhoto(String shangjiaPhoto) {
						this.shangjiaPhoto = shangjiaPhoto;
					}

					/**
					* 获取： 商家信用类型
					*/
					public Integer getShangjiaXingjiTypes() {
						return shangjiaXingjiTypes;
					}
					/**
					* 设置： 商家信用类型
					*/
					public void setShangjiaXingjiTypes(Integer shangjiaXingjiTypes) {
						this.shangjiaXingjiTypes = shangjiaXingjiTypes;
					}


						/**
						* 获取： 商家信用类型的值
						*/
						public String getShangjiaXingjiValue() {
							return shangjiaXingjiValue;
						}
						/**
						* 设置： 商家信用类型的值
						*/
						public void setShangjiaXingjiValue(String shangjiaXingjiValue) {
							this.shangjiaXingjiValue = shangjiaXingjiValue;
						}

					/**
					* 获取： 账户状态
					*/
					public Integer getShangjiaShiyongTypes() {
						return shangjiaShiyongTypes;
					}
					/**
					* 设置： 账户状态
					*/
					public void setShangjiaShiyongTypes(Integer shangjiaShiyongTypes) {
						this.shangjiaShiyongTypes = shangjiaShiyongTypes;
					}


						/**
						* 获取： 账户状态的值
						*/
						public String getShangjiaShiyongValue() {
							return shangjiaShiyongValue;
						}
						/**
						* 设置： 账户状态的值
						*/
						public void setShangjiaShiyongValue(String shangjiaShiyongValue) {
							this.shangjiaShiyongValue = shangjiaShiyongValue;
						}

					/**
					* 获取： 商家简介
					*/
					public String getShangjiaContent() {
						return shangjiaContent;
					}
					/**
					* 设置： 商家简介
					*/
					public void setShangjiaContent(String shangjiaContent) {
						this.shangjiaContent = shangjiaContent;
					}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getShangjiaDelete() {
						return shangjiaDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setShangjiaDelete(Integer shangjiaDelete) {
						this.shangjiaDelete = shangjiaDelete;
					}


}
