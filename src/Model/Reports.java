package Model;

import java.io.IOException;
import java.sql.Connection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class Reports 
{
		
	
	
	public void viewUserList() throws Exception
	{
		ConnectDB connectDB = new ConnectDB();
		Connection conn = connectDB.getConnection();
		
		JasperDesign jasperDesign = JRXmlLoader.load("C:/Users/Adrian/Desktop/report1.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
		JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Users/Adrian/Desktop/report1.pdf");
		
		Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+ "C:/Users/Adrian/Desktop/report1.pdf");
	}
	public void viewTaskList() throws Exception
	{
		ConnectDB connectDB = new ConnectDB();
		Connection conn = connectDB.getConnection();
		
		JasperDesign jasperDesign = JRXmlLoader.load("C:/Users/Adrian/Desktop/report2.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
		JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Users/Adrian/Desktop/report2.pdf");
		
		Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+ "C:/Users/Adrian/Desktop/report2.pdf");
	}
	public void viewEmpTask() throws Exception
	{
		ConnectDB connectDB = new ConnectDB();
		Connection conn = connectDB.getConnection();
		
		JasperDesign jasperDesign = JRXmlLoader.load("C:/Users/Adrian/Desktop/report3.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
		JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Users/Adrian/Desktop/report3.pdf");
		
		Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+ "C:/Users/Adrian/Desktop/report3.pdf");
	}
}
