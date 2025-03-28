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
 * 共享单车
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-04-21 22:32:52
 */
@TableName("gongxiangdanche")
public class GongxiangdancheEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GongxiangdancheEntity() {
		
	}
	
	public GongxiangdancheEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * bid
	 */
					
	private String bid;
	
	/**
	 * account
	 */
					
	private String account;
	
	/**
	 * pp
	 */
					
	private String pp;
	
	/**
	 * month
	 */
					
	private String month;
	
	/**
	 * orderid
	 */
					
	private String orderid;
	
	/**
	 * area
	 */
					
	private String area;
	
	/**
	 * price
	 */
					
	private String price;
	
	/**
	 * ridetime
	 */
					
	private Integer ridetime;
	
	/**
	 * starttime
	 */
					
	private String starttime;
	
	/**
	 * userid
	 */
					
	private String userid;
	
	/**
	 * week
	 */
					
	private String week;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：bid
	 */
	public void setBid(String bid) {
		this.bid = bid;
	}
	/**
	 * 获取：bid
	 */
	public String getBid() {
		return bid;
	}
	/**
	 * 设置：account
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * 获取：account
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 设置：pp
	 */
	public void setPp(String pp) {
		this.pp = pp;
	}
	/**
	 * 获取：pp
	 */
	public String getPp() {
		return pp;
	}
	/**
	 * 设置：month
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * 获取：month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * 设置：orderid
	 */
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	/**
	 * 获取：orderid
	 */
	public String getOrderid() {
		return orderid;
	}
	/**
	 * 设置：area
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置：price
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * 获取：price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * 设置：ridetime
	 */
	public void setRidetime(Integer ridetime) {
		this.ridetime = ridetime;
	}
	/**
	 * 获取：ridetime
	 */
	public Integer getRidetime() {
		return ridetime;
	}
	/**
	 * 设置：starttime
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	/**
	 * 获取：starttime
	 */
	public String getStarttime() {
		return starttime;
	}
	/**
	 * 设置：userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 获取：userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * 设置：week
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	/**
	 * 获取：week
	 */
	public String getWeek() {
		return week;
	}

}
