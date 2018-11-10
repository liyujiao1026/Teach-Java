/*
add sheet
 */
package exceldemo;

import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;


public class ExcelDemo2 {

	public static void main(String[] args) throws Exception {
		
		Workbook wb=new HSSFWorkbook(); // create workbook
                
		wb.createSheet("mysheet1");       // create sheet1
		wb.createSheet("mysheet2");       // create sheet2
                
		FileOutputStream fileOut=new FileOutputStream("/Users/Yujiao/Desktop/java_swing/excel_demo/demo2.xls");
		wb.write(fileOut);
		fileOut.close();
	}
}

