package com.spring.mvcdev.view;

import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

public interface ExcelExportService {

	void makeWorkBook(Map<String, Object>model,Workbook workbook);
}
