package com.cg.user.service;

import com.cg.user.domain.Payments;
import com.cg.user.domain.UserPaymentCardDetails;

public interface PaymentsService {

	Payments cardPayments(UserPaymentCardDetails card);

}
