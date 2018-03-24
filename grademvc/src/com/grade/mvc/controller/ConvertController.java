package com.grade.mvc.controller;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grade.mvc.pojo.FormatPojo;

@Controller
@RequestMapping("/convert")
public class ConvertController {

	@RequestMapping("/format")
	public String format(Model model,
			@DateTimeFormat(iso = ISO.DATE) @RequestParam(value = "date1") Date date,
			@RequestParam(value = "amount1") @NumberFormat(pattern = "#,###.##") Double amount) {
		try {
			DecimalFormat df = new DecimalFormat("0.00");
			model.addAttribute("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
			model.addAttribute("amount", df.format(amount));
			return "showFormatInfo";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "showFormatInfo";
	}
	
	@RequestMapping("/formatPojo")
	public String formatPojo(Model model,FormatPojo p) {
			DecimalFormat df = new DecimalFormat("0.00");
			model.addAttribute("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(p.getDate1()));
			model.addAttribute("amount", df.format(p.getAmount1()));
			
		return "showFormatInfo";
	}
}
