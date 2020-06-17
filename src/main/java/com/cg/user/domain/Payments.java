package com.cg.user.domain;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;




@Entity
@Table(name="payments")

public class Payments implements Serializable {
	  
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="paymentId")
		
	    private Integer paymentId;
		@Column(name="userId")
		
	    private Integer userId;
		@Column(name="productInfo")
	    private String productInfo;
		@Column(name="amount")
		
	    private String amount;
		@Column(name="txnId")
		
	    private String txnId;
		@Column(name="paymentType")
	    private String paymentType;
		@Column(name="paymentDate")
		
	    private String paymentDate;
		
	    @NotNull
		private String firstName;
	    @NotNull
		private String lastName;
		
		
		



		public Integer getPaymentId() {
			return paymentId;
		}



		public void setPaymentId(Integer paymentId) {
			this.paymentId = paymentId;
		}



		public Integer getUserId() {
			return userId;
		}



		public void setUserId(Integer userId) {
			this.userId = userId;
		}



		public String getProductInfo() {
			return productInfo;
		}



		public void setProductInfo(String productInfo) {
			this.productInfo = productInfo;
		}



		public String getAmount() {
			return amount;
		}



		public void setAmount(String amount) {
			this.amount = amount;
		}



		public String getTxnId() {
			return txnId;
		}



		public void setTxnId(String txnId) {
			this.txnId = txnId;
		}



		public String getPaymentType() {
			return paymentType;
		}



		public void setPaymentType(String paymentType) {
			this.paymentType = paymentType;
		}



		public String getPaymentDate() {
			return paymentDate;
		}



		public void setPaymentDate(String paymentDate) {
			this.paymentDate = paymentDate;
		}



		public String getFirstName() {
			return firstName;
		}



		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}



		public String getLastName() {
			return lastName;
		}



		public void setLastName(String lastName) {
			this.lastName = lastName;
		}



		@Override
		public String toString() {
			return "Payments [paymentId=" + paymentId + ", userId=" + userId + ", productInfo=" + productInfo
					+ ", amount=" + amount + ", txnId=" + txnId + ", paymentType=" + paymentType + ", paymentDate="
					+ paymentDate + ", firstName=" + firstName + ", lastName=" + lastName + "]";
		}
		
		
		
		

}
