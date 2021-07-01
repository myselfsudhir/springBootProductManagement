package com.te.springboot.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.Columns;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "products")
public class Products implements Serializable {
	@Id
	@Column
	private Integer pid;
	@Column
	private String pname;
	@Column
	private Date mgDate;
	@Column
	private Date exDate;
	@Column
	private Integer price;
	@Column
	private Integer quantity;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Date getMgDate() {
		return mgDate;
	}
	public void setMgDate(Date mgDate) {
		this.mgDate = mgDate;
	}
	public Date getExDate() {
		return exDate;
	}
	public void setExDate(Date exDate) {
		this.exDate = exDate;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
}