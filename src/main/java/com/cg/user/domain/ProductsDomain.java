package com.cg.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
@Table(name= "tbl_products")
public class ProductsDomain {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)   
    private int pid;
    
    @Column(name = "pname")
    private String pname;
    
    @Column(name = "pmodel")
    private String pmodel;
    
    @Column(name = "price")
    private double price;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private OrdersDomain orderMain;


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getPmodel() {
		return pmodel;
	}


	public void setPmodel(String pmodel) {
		this.pmodel = pmodel;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public OrdersDomain getOrderMain() {
		return orderMain;
	}


	public void setOrderMain(OrdersDomain orderMain) {
		this.orderMain = orderMain;
	}

    //List<String> errormessage ;

}
