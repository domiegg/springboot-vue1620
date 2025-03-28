package com.entity.vo;

import com.entity.GongxiangdancheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 共享单车
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-04-21 22:32:52
 */
public class GongxiangdancheVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
