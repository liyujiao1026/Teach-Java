/*
add value in the sheet
 */
package exceldemo;

import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class ExcelDemo3 {

	public static void main(String[] args) throws Exception {
		
		Workbook wb=new HSSFWorkbook(); // create workbook
                
		Sheet sheet = wb.createSheet("mysheet1");       // create sheet1
                Row row = sheet.createRow(0); // create one row
                Cell cell = row.createCell(0); // create one cell (row 0, column 0)
                cell.setCellValue(1); // set value for the first cell
                
                row.createCell(1).setCellValue(1.2); //create the cell (row 0, column 1) where the value is 1.2
                row.createCell(2).setCellValue("hi"); // create the cell (row 0, column 2) where the value is "hi"
                row.createCell(3).setCellValue(false); // create the cell (row 0, column 3) where the value is false
               
               
		FileOutputStream fileOut=new FileOutputStream("/Users/Yujiao/Desktop/java_swing/excel_demo/demo3.xls");
		wb.write(fileOut);
		fileOut.close();
	}
}

