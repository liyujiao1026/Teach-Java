/*
 get the content of the workbook.
 */
package exceldemo;

import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;



public class ExcelDemo4 {

	public static void main(String[] args) throws Exception {
            
                // Creates a FileInputStream by opening a connection to an actual file. (for reading data)
		InputStream is = new FileInputStream("/Users/Yujiao/Desktop/java_swing/excel_demo/cars.xls");
                
                POIFSFileSystem fs = new POIFSFileSystem(is); // accept input stream
                HSSFWorkbook wb = new HSSFWorkbook(fs); // create workbook
                HSSFSheet hssfSheet = wb.getSheetAt(0); // get the first sheet
                
                if (hssfSheet == null){  //if sheet does not exist, exit
                    return; 
                }
                // go through all rows
                for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum ++){
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    
                    if(hssfRow == null){
                        continue;
                    }
                    
                    // go through all columns in the current looped rowNum.
                    for (int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum ++){
                        HSSFCell hssfCell = hssfRow.getCell(cellNum);
                        if(hssfCell == null){
                            continue;
                        }
                        // show results
                        System.out.print(" "+ getValue(hssfCell));
                    }
                    System.out.println(); 
                }
                
	}
        
        
        
        private static String getValue(HSSFCell hssfCell){
            switch (hssfCell.getCellType()) {
                case HSSFCell.CELL_TYPE_BOOLEAN:
                    return String.valueOf(hssfCell.getBooleanCellValue());
                case HSSFCell.CELL_TYPE_NUMERIC:
                    return String.valueOf(hssfCell.getNumericCellValue());
                default:
                    return String.valueOf(hssfCell.getStringCellValue());
            }
        }
}

