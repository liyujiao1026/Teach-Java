/*
Extract the content of the workbook.
 */
package exceldemo;

import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class ExcelDemo5 {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("/Users/Yujiao/Desktop/java_swing/excel_demo/cars.xls");
                POIFSFileSystem fs = new POIFSFileSystem(is); // save the input stream into memory
                HSSFWorkbook wb = new HSSFWorkbook(fs); // create workbook
                
                ExcelExtractor excelExtractor = new ExcelExtractor(wb);
                excelExtractor.setIncludeSheetNames(false); //we do not need get the name of the sheet
                System.out.println(excelExtractor.getText());
        }
}

