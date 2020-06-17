package com.cg.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.user.domain.UserPaymentCardDetails;

@Repository
public interface PaymentsCardRepo extends JpaRepository<UserPaymentCardDetails, Integer>{

	UserPaymentCardDetails findByCardNumber(String cardNumber);

}
