package com.cg.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.user.domain.Payments;
import com.cg.user.domain.UserPaymentCardDetails;
import com.cg.user.service.PaymentsService;

@RestController
@RequestMapping("/payments")
public class PaymentsController {
	
	@Autowired
	private PaymentsService paymentService;
	
	
	@PostMapping("/cardpaymentsprocess")
    public Payments checkPaymentDetails(@RequestBody UserPaymentCardDetails card) throws Exception {	 
	return paymentService.cardPayments(card);
    }

}
