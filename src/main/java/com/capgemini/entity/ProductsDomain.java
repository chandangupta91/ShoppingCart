package com.capgemini.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name= "tbl_products")
@Data
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
    
    //List<String> errormessage ;

}
