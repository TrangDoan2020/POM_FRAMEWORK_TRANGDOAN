package utils;

import commons.GlobalConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {

    public static Object[][] readExcelValues(String sheetName){
        String filePath = GlobalConstants.projectPath + "/src/main/resources/SendoTestcase.xlsx";
        Object[][] object = null;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int totalRows = sheet.getLastRowNum() + 1;
            int totalCols = sheet.getRow(0).getLastCellNum();
            object = new Object[totalRows-1][totalCols];
            for(int i=1; i<totalRows; i++){
                for(int j=0; j<totalCols; j++){
                    object[i-1][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }
}