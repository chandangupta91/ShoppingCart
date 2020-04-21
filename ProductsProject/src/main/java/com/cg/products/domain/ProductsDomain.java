package com.cg.products.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name= "products")
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
	    

}
