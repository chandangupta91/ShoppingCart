package com.cg.user.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import java.util.HashSet;
import java.util.Set;




@Data
@Entity
@Table(name= "orders")
public class OrdersDomain implements Serializable{ 
	
	private static final long serialVersionUID = -3819883511505235030L;

	@Id
	    
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int orderId;

	 @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "orderMain")
	    private Set<ProductsDomain> products = new HashSet<>();

	    
	    @Column(name = "buyeremail")
	    private String buyerEmail;

	    
	    @Column(name = "buyername")
	    private String buyerName;

	    
	    @Column(name = "buyerproduct")
	    private String buyerProduct;

	    
	    @Column(name = "buyeradress")
	    private String buyerAddress;

	    // Total Amount
	
	    @Column(name = "orderamount")
	    private BigDecimal orderAmount;

	    /**
	     * default 0: new order.
	     */
	    
	    @Column(name = "orderstatus")
	    private Integer orderStatus;

	    @CreationTimestamp
	    @Column(name = "createtime")
	    private LocalDateTime createTime;

	    @UpdateTimestamp
	    @Column(name = "updatetime")
	    private LocalDateTime updateTime;

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public Set<ProductsDomain> getProducts() {
			return products;
		}

		public void setProducts(Set<ProductsDomain> products) {
			this.products = products;
		}

		public String getBuyerEmail() {
			return buyerEmail;
		}

		public void setBuyerEmail(String buyerEmail) {
			this.buyerEmail = buyerEmail;
		}

		public String getBuyerName() {
			return buyerName;
		}

		public void setBuyerName(String buyerName) {
			this.buyerName = buyerName;
		}

		public String getBuyerProduct() {
			return buyerProduct;
		}

		public void setBuyerProduct(String buyerProduct) {
			this.buyerProduct = buyerProduct;
		}

		public String getBuyerAddress() {
			return buyerAddress;
		}

		public void setBuyerAddress(String buyerAddress) {
			this.buyerAddress = buyerAddress;
		}

		public BigDecimal getOrderAmount() {
			return orderAmount;
		}

		public void setOrderAmount(BigDecimal orderAmount) {
			this.orderAmount = orderAmount;
		}

		public Integer getOrderStatus() {
			return orderStatus;
		}

		public void setOrderStatus(Integer orderStatus) {
			this.orderStatus = orderStatus;
		}

		public LocalDateTime getCreateTime() {
			return createTime;
		}

		public void setCreateTime(LocalDateTime createTime) {
			this.createTime = createTime;
		}

		public LocalDateTime getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(LocalDateTime updateTime) {
			this.updateTime = updateTime;
		}
	    
	    
	    

			
}
