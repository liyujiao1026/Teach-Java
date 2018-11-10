/*
create workbook
 */
package exceldemo;

import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelDemo1 {


    public static void main(String[] args) throws Exception {
       
        Workbook wb = new HSSFWorkbook(); //instantiate workbook 
        
        //Creates a file output stream to write to the file represented by the specified File object.
        //A file output stream is an output stream for writing data to a File
        
        FileOutputStream fileOut = new FileOutputStream("/Users/Yujiao/Desktop/java_swing/excel_demo/demo1.xls"); // create excel
        wb.write(fileOut);
	fileOut.close();
        
    }
    
}
