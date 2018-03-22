package com.spring.mvcdev.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.document.AbstractXlsView;

public class ExcelView extends AbstractXlsView {

	
	private String fileName = null;
	private ExcelExportService excelExportService;
	public ExcelView(String fileName,ExcelExportService excelExportService){
		this.fileName = fileName;
		this.excelExportService = excelExportService;
	}
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(excelExportService == null){
			throw new Exception("导出服务接口不能为null");
		}
		if(!StringUtils.isEmpty(fileName)){
			String reqCharset=request.getCharacterEncoding();
			reqCharset = reqCharset == null?"utf-8":reqCharset;
			fileName = new String(fileName.getBytes(reqCharset),"ISO8859-1");
			response.setHeader("Content-disposition", "attachment;filename="+fileName);
		}
		excelExportService.makeWorkBook(model, workbook);
	}

}
