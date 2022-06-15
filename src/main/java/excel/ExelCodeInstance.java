package excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelCodeInstance {
XSSFSheet sheet;

public ExelCodeInstance() throws IOException {                                       //constructor
FileInputStream file=new FileInputStream("E:\\Eclipse\\testproject1\\src\\main\\resources\\Book1.xlsx");
XSSFWorkbook w=new XSSFWorkbook(file);
sheet=w.getSheet("Sheet1");
}

public String readData(int row,int column) {                      //instance method
Row r= sheet.getRow(row); //row is interface
Cell c = r.getCell(column); //interface
int celltype = c.getCellType();

switch(celltype)
{
case Cell.CELL_TYPE_NUMERIC:
{
int  a=(int) c.getNumericCellValue();
return String.valueOf(a);

}

case Cell.CELL_TYPE_STRING:
{
return c.getStringCellValue();

}

}
return null;
}
public int rowsize() {
return sheet.getLastRowNum() + 1;
}



}

