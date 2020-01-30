package com.debashish.excel;

import com.debashish.excel.service.GenerateExcelService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcelDownloadController {
    GenerateExcelService generateExcelService;

    public ExcelDownloadController(GenerateExcelService generateExcelService) {
        this.generateExcelService = generateExcelService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/download/excel-report")
    public HttpEntity<byte[]> downloadExcelReport() {

        /** assume that below line gives you file content in byte array **/
        byte[] excelContent = generateExcelService.getExcelReportContent();
        // prepare response
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=my_file.xls");
        header.setContentLength(excelContent.length);

        return new HttpEntity<byte[]>(excelContent, header);
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadErrorData() throws Exception {
     /*   List<Employee> employees = employeeService.getEmployees();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(employees);*/
        byte[] bytesA = generateExcelService.getExcelReportContent();
        String fileName = "employees.json";
        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.setContentLength(bytesA.length);
        respHeaders.setContentType(new MediaType("text", "json"));
        respHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        respHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
        return new ResponseEntity<byte[]>(bytesA, respHeaders, HttpStatus.OK);
    }
}
