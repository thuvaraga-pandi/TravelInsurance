package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import PageObjectModel.CarInsurance1;
import PageObjectModel.HealthInsurance1;
import PageObjectModel.Travelinsurance1;

public class ExcelforInsurance {
	 
	 
	 
	public static void excel() throws IOException {
	FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\ExcelFile\\OutputTI.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook();
	XSSFSheet sheet=workbook.createSheet("Sheet1");
	XSSFRow row=sheet.createRow(0);
	row.createCell(0).setCellValue("Plans & Packages");
	
	for(int i=1;i<Travelinsurance1.Plans.size()+1;i++) {
		XSSFRow row1=sheet.createRow(i);
		row1.createCell(0).setCellValue(Travelinsurance1.Plans.get(i-1));
		row1.createCell(1).setCellValue(Travelinsurance1.PriceAmt.get(i-1));
	}
	XSSFSheet sheet2=workbook.createSheet("Sheet2");
	XSSFRow row2=sheet2.createRow(0);
	row2.createCell(0).setCellValue("HealthInsurance");
	
	for(int i=1;i<HealthInsurance1.allHealthList.size()+1;i++) {
		XSSFRow row3=sheet2.createRow(i);
		row3.createCell(0).setCellValue(HealthInsurance1.allHealthList.get(i-1));
		
	}
	
	XSSFSheet sheet3=workbook.createSheet("Sheet3");
	XSSFRow row4=sheet3.createRow(0);
	row4.createCell(0).setCellValue("CarQoute");
	XSSFRow row3=sheet3.createRow(1);
	row3.createCell(0).setCellValue(CarInsurance1.PlanQoute);
	
	
	workbook.write(file);
	workbook.close();
	file.close();
	}
	
	public static List<String> ReadExcel() throws IOException {
		
		 FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\ExcelFile\\InputTI.xlsx");
    	 XSSFWorkbook workbook=new XSSFWorkbook(file);
    	 XSSFSheet sheet=workbook.getSheet("Sheet1");
    	 String mblenum=sheet.getRow(0).getCell(0).toString();//(0)
    	 String namecar=sheet.getRow(1).getCell(0).toString();//(1)
    	 String wrngEmail=sheet.getRow(2).getCell(0).toString();//(2)
    	 String carmblenum=sheet.getRow(3).getCell(0).toString();//(3)
    	 String carcity=sheet.getRow(4).getCell(0).toString();//(4)
    	 String Healthname=sheet.getRow(5).getCell(0).toString();//(5)
    	 String healthMblenum=sheet.getRow(6).getCell(0).toString();//(6)
    	 String Crctname=sheet.getRow(0).getCell(1).toString();//(7)
    	  List<String> list=new ArrayList<String>();
    	  list.add(mblenum);
    	  list.add(namecar);
    	  list.add(wrngEmail);
    	  list.add(carmblenum);
    	  list.add(carcity);
    	  list.add(Healthname);
    	  list.add(healthMblenum);
    	  list.add(Crctname);
    	  workbook.close();
    	  return list;
	}
}
