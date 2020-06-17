package com.cg.user.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="paymentscarddata")

public class UserPaymentCardDetails implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="userPaymentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userPaymentId;
	
	@Column(name="userID")
	private String userID;
	
	@Column(name="cardusername")
	private String nameonCard;
	
	
	private String firstName;
	
	private String lastName;
	
	public String getNameonCard() {
		return nameonCard;
	}

	public void setNameonCard(String nameonCard) {
		this.nameonCard = nameonCard;
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

	@Column(name="cardNumber")
	private String cardNumber;
	
	@Column(name="expMonth")
	private Integer expMonth;
	
	@Column(name="expYear")
	private Integer expYear;
	
	@Column(name="cVV")
	private Integer cVV;

	public Integer getUserPaymentId() {
		return userPaymentId;
	}

	public void setUserPaymentId(Integer userPaymentId) {
		this.userPaymentId = userPaymentId;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(Integer expMonth) {
		this.expMonth = expMonth;
	}

	public Integer getExpYear() {
		return expYear;
	}

	public void setExpYear(Integer expYear) {
		this.expYear = expYear;
	}

	

	public Integer getcVV() {
		return cVV;
	}

	public void setcVV(Integer cVV) {
		this.cVV = cVV;
	}

	@Override
	public String toString() {
		return "UserPaymentCardDetails [userPaymentId=" + userPaymentId + ", userID=" + userID + ", nameonCard="
				+ nameonCard + ", firstName=" + firstName + ", lastName=" + lastName + ", cardNumber=" + cardNumber
				+ ", expMonth=" + expMonth + ", expYear=" + expYear + ", CVV=" + cVV + "]";
	}

	
	
	
	
	
	
	 

}
