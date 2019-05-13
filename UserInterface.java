

import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;   

public class UserInterface {
   
    static String reader(String a,int status) throws IOException 
            //throws BiffException, IOException,WriteException
    {
        File f;
        Workbook wb;
        DataFormatter formator = new DataFormatter();
        if(status==0){
            f = new File("C:\\Users\\Jhanvi Dodiya\\Desktop\\JhanviJava1\\LTranslator\\src\\EF.xlsx");
            wb=WorkbookFactory.create(f);
            
            //System.out.println("ASM 0");
           
        }
        else{
            f = new File("C:\\Users\\Jhanvi Dodiya\\Desktop\\JhanviJava1\\LTranslator\\src\\FE.xlsx");
            wb=WorkbookFactory.create(f);
           
            //System.out.println("ASM 1 "+f);
        }    
            
        Sheet s=wb.getSheetAt(0);
        Cell cell;
        Row row;
        String sr="NOT FOUND!!!";
        ///a=a+" ";
        Iterator<Row> rowIterator = s.rowIterator();
        while(rowIterator.hasNext()){
            row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while(cellIterator.hasNext()){
                cell = cellIterator.next();
                String cellValue = formator.formatCellValue(cell);
                a.toLowerCase();
                cellValue = cellValue.toLowerCase();
                //System.out.print(cellValue+"\t");
                if(a.matches(cellValue)){
                    cell = cellIterator.next();
                    sr = formator.formatCellValue(cell);
                    break;
                    
                }
            }
            //System.out.println();
        }
        return sr;
       
    }
}
