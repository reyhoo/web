package com.mvcdev.exe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvcdev.exe.pojo.Transaction;
import com.mvcdev.exe.validator.TransactionValidator;

@Controller
@RequestMapping("/validate")
public class ValidateController {

	@RequestMapping(value="/annotation",method=RequestMethod.POST)
	public String annotation(@Valid Transaction transaction,Errors errors){
		if(errors.hasErrors()){
			List<FieldError> errorList = errors.getFieldErrors();
			for (FieldError fieldError : errorList) {
				System.err.println("field:"+fieldError.getField()+"\t"+
			"msg:"+fieldError.getDefaultMessage());
			}
		}else{
			System.err.println("没有错误:"+transaction);
		}
		System.out.println(transaction);
		return "redirect:/role/list";
	}
//	@InitBinder
	public void initBinder(DataBinder dataBinder){
		dataBinder.setValidator(new TransactionValidator());
	}
	@RequestMapping(value="/validator",method=RequestMethod.POST)
	public String validator(@Valid Transaction transaction,Errors errors){
		if(errors.hasErrors()){
			List<FieldError> errorList = errors.getFieldErrors();
			for (FieldError fieldError : errorList) {
				System.err.println("field:"+fieldError.getField()+"\t"+
			"msg:"+fieldError.getDefaultMessage());
			}
		}else{
			System.err.println("没有错误:"+transaction);
		}
		return "redirect:/role/list";
	}
}
