package com.debashish.excel;

import com.debashish.excel.service.GenerateExcelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

@SpringBootTest
class ExcelSpringbootPoiApplicationTests {

    @Autowired
    GenerateExcelService generateExcelService;
    @Test
    void myTest2() {
       System.out.println( generateExcelService.getEmployeeFields().toString());
    }
    @Test
    void myTest() {

        byte[] getByte = generateExcelService.getExcelReportContent();
        writeByte(getByte);
    }

    void writeByte(byte[] bytes) {
		 String FILEPATH = "C:\\UBS\\Software\\abc.xlsx";
		 File file = new File(FILEPATH);
        try {

            // Initialize a pointer
            // in file using OutputStream
            OutputStream
                    os
                    = new FileOutputStream(file);

            // Starts writing the bytes in it
            os.write(bytes);
            System.out.println("Successfully"
                    + " byte inserted");

            // Close the file
            os.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
