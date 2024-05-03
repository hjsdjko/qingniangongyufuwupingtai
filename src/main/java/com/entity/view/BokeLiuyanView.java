package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.BokeLiuyanEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 博客留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("boke_liuyan")
public class BokeLiuyanView extends BokeLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 boke
			/**
			* 博客 的 用户
			*/
			private Integer bokeYonghuId;
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
				* 博客类型的值
				*/
				private String bokeValue;
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
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer bokeDelete;

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

	public BokeLiuyanView() {

	}

	public BokeLiuyanView(BokeLiuyanEntity bokeLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, bokeLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







				//级联表的get和set boke

					/**
					* 获取：博客 的 用户
					*/
					public Integer getBokeYonghuId() {
						return bokeYonghuId;
					}
					/**
					* 设置：博客 的 用户
					*/
					public void setBokeYonghuId(Integer bokeYonghuId) {
						this.bokeYonghuId = bokeYonghuId;
					}


					/**
					* 获取： 博客名称
					*/
					public String getBokeName() {
						return bokeName;
					}
					/**
					* 设置： 博客名称
					*/
					public void setBokeName(String bokeName) {
						this.bokeName = bokeName;
					}

					/**
					* 获取： 博客编号
					*/
					public String getBokeUuidNumber() {
						return bokeUuidNumber;
					}
					/**
					* 设置： 博客编号
					*/
					public void setBokeUuidNumber(String bokeUuidNumber) {
						this.bokeUuidNumber = bokeUuidNumber;
					}

					/**
					* 获取： 博客照片
					*/
					public String getBokePhoto() {
						return bokePhoto;
					}
					/**
					* 设置： 博客照片
					*/
					public void setBokePhoto(String bokePhoto) {
						this.bokePhoto = bokePhoto;
					}

					/**
					* 获取： 博客类型
					*/
					public Integer getBokeTypes() {
						return bokeTypes;
					}
					/**
					* 设置： 博客类型
					*/
					public void setBokeTypes(Integer bokeTypes) {
						this.bokeTypes = bokeTypes;
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
					* 获取： 博客热度
					*/
					public Integer getBokeClicknum() {
						return bokeClicknum;
					}
					/**
					* 设置： 博客热度
					*/
					public void setBokeClicknum(Integer bokeClicknum) {
						this.bokeClicknum = bokeClicknum;
					}

					/**
					* 获取： 博客内容
					*/
					public String getBokeContent() {
						return bokeContent;
					}
					/**
					* 设置： 博客内容
					*/
					public void setBokeContent(String bokeContent) {
						this.bokeContent = bokeContent;
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
					public Integer getBokeDelete() {
						return bokeDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setBokeDelete(Integer bokeDelete) {
						this.bokeDelete = bokeDelete;
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
