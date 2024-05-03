package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.BokeEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 博客
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("boke")
public class BokeView extends BokeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 博客类型的值
		*/
		private String bokeValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



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

	public BokeView() {

	}

	public BokeView(BokeEntity bokeEntity) {
		try {
			BeanUtils.copyProperties(this, bokeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 博客类型的值
			*/
			public String getBokeValue() {
				return bokeValue;
			}
			/**
			* 设置： 博客类型的值
			*/
			public void setBokeValue(String bokeValue) {
				this.bokeValue = bokeValue;
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
