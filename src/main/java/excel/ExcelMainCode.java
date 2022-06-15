package excel;

import java.io.IOException;

public class ExcelMainCode {
	
public static void main(String args[]) throws IOException {
	
ExelCodeInstance object =new ExelCodeInstance();
	for(int i=0;i<object.rowsize();i++) {
		for(int j=0;j<3;j++) {
			//String value=object.readData(i,j);
			System.out.print(object.readData(i,j)+" ");

		}
		System.out.println();
	}
	
	
}
}
