/*
Update (Revise) the content of the workbook.
 */
package exceldemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


public class ExcelDemo6 {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("/Users/Yujiao/Desktop/java_swing/excel_demo/cars.xls");
                POIFSFileSystem fs = new POIFSFileSystem(is); // save the input stream into memory
                HSSFWorkbook wb = new HSSFWorkbook(fs); // create workbook
                
                Sheet sheet = wb.getSheetAt(0); // get the first sheet
                Row row = sheet.getRow(0); // get the first row
                Cell cell = row.getCell(0); // get the cell (row 0 column 0)
                
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue("Hello world");
                
                
                FileOutputStream fileOut = new FileOutputStream("/Users/Yujiao/Desktop/java_swing/excel_demo/cars.xls");
		wb.write(fileOut);
		fileOut.close();
        }
}

