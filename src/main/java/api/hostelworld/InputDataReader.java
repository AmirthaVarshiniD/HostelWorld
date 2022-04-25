package api.hostelworld;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InputDataReader{

	public static Object[][] getSheet(String dataSheetName) {		

		Object[][] data = null ;

		try {			
			XSSFWorkbook workbook = new XSSFWorkbook("./data/"+dataSheetName+".xlsx");
			XSSFSheet sheet = workbook.getSheetAt(0);	

			int rowCount = sheet.getLastRowNum();
			int columnCount = sheet.getRow(0).getLastCellNum();
			//System.out.println(columnCount+rowCount);
			data = new String[rowCount][columnCount];

			for(int i=1; i <rowCount+1; i++){
				try {
					XSSFRow row = sheet.getRow(i);
					for(int j=0; j <columnCount; j++){ 
						try {
							String cellValue = "";
							try{
								cellValue = row.getCell(j).getStringCellValue();
							}catch(NullPointerException e){

							}
							data[i-1][j]  = cellValue; 
						} catch (Exception e) {
							e.printStackTrace();
						}				
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}
}
