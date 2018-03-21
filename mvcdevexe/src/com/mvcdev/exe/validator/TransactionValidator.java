package com.mvcdev.exe.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mvcdev.exe.pojo.Transaction;


public class TransactionValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return Transaction.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		Transaction transaction = (Transaction) arg0;
		try {
			double dls = transaction.getAmount() - (transaction.getQuantity()*transaction.getPrice());
			if(Math.abs(dls)>0.01){
				errors.rejectValue("amount", null, "交易金额和购买数量与价格不匹配");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
