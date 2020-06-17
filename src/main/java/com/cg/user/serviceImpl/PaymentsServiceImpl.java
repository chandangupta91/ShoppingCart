package com.cg.user.serviceImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.user.dao.PaymentsCardRepo;
import com.cg.user.dao.PaymentsDao;
import com.cg.user.domain.Payments;
import com.cg.user.domain.UserPaymentCardDetails;
import com.cg.user.service.PaymentsService;

@Service
public class PaymentsServiceImpl implements PaymentsService{
	
	@Autowired
	private PaymentsDao paymentsDao;
	
	@Autowired
	private PaymentsCardRepo paymentsCardRepo;

	
	private Payments pay =new Payments();
	
	
	@Override
	public Payments cardPayments(UserPaymentCardDetails card) {
		
      UserPaymentCardDetails userPaymentCardDetails  = paymentsCardRepo.findByCardNumber(card.getCardNumber());
		
		
		try {
			if(userPaymentCardDetails.getUserID().equalsIgnoreCase(card.getUserID())&&userPaymentCardDetails.getNameonCard().equalsIgnoreCase(card.getNameonCard())
					&&userPaymentCardDetails.getExpMonth()==(card.getExpMonth())
							&&userPaymentCardDetails.getExpYear().equals(card.getExpYear())
							&&userPaymentCardDetails.getcVV().equals(card.getcVV())
					
					){
				Payments payments = new Payments();
				payments.setFirstName(card.getFirstName());
				payments.setLastName(card.getLastName());
				payments.setUserId(Integer.valueOf((card.getUserID())));
				payments.setAmount("2000");
				payments.setPaymentType("Card");
				payments.setProductInfo("Electronics");
				
				String cs = savePayments(payments);
				if(cs!=null) {
					System.out.println("Payment SucessFull");
				}
				else {
					System.err.println("Payment Failed");
				}
				//Payments pay = paymentsRepo.findByPaymentId(payments.getPaymentId());
	             return pay;
			}
			else {
				throw new Exception("Enter All The Details Properly");
			}
			
			
		} catch (Exception e) {
			return null;
		}
				
	}
	
	
public String savePayments(Payments payments) throws Exception {
		
		Payments paymentsData = new Payments();
		//UserPaymentCardDetails userPaymentCardDetails = new UserPaymentCardDetails();
		
		//List<UserPaymentCardDetails> userPaymentCardDetailsList = paymentsCardRepo.findAll();
		//System.out.println(userPaymentCardDetailsList);
		
		try {
			if(payments.getUserId()!=null&&payments.getAmount()!=null&&payments.getAmount()!=null&&payments.getPaymentType()!=null&&payments.getProductInfo()!=null) {
			paymentsData.setUserId(payments.getUserId());
			paymentsData.setAmount(payments.getAmount());
			paymentsData.setPaymentType(payments.getPaymentType());
			paymentsData.setProductInfo(payments.getProductInfo());
			paymentsData.setFirstName(payments.getFirstName());
			paymentsData.setLastName(payments.getLastName());
			Timestamp transId = new Timestamp(System.currentTimeMillis());
			String tranactionId = Long.toString(transId.getTime());
			paymentsData.setTxnId(tranactionId);
			DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss a");
			LocalDateTime now = LocalDateTime.now();	  
			paymentsData.setPaymentDate(datetimeformat.format(now));	
			paymentsDao.save(paymentsData);	
			
			
			
			
			}
			else {
				throw new Exception("Enter All The Details Properly");
			}
		    pay = paymentsDao.findByPaymentId(paymentsData.getPaymentId());
			
		       return "Payment ID: "+pay.getPaymentId()+"\nTransaction Id: "+pay.getTxnId();
		       }
	
			
			
		 catch (Exception e) {
			System.out.println("Exception :"+e);
			throw new Exception("Enter All The Details");
		}
      }

} 
