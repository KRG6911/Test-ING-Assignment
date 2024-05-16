package utilty;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Reusable {

    public String createXMLBody(String name,String year,String dob,String address,String salary){

        String body ="{\n" +
                "    \"name\":\""+name+"\",\n" +
                "    \"data\":{\n" +
                "        \"year\":"+year+",\n" +
                "        \"DOB\":\""+dob+"\",\n" +
                "        \"Address\":\""+address+"\",\n" +
                "        \"Salary\":\""+salary+"\"\n" +
                "    }\n" +
                "}";
        return body;
    }

}
