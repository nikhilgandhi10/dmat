package com.api.dmat.service;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.poi.ss.usermodel.Row;



import com.api.dmat.helper.DownloadReportResponseHelper;





@Component
public class UserExcelExporterService {
    
    @Autowired
    DownloadReportAPIService sras;
    
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<DownloadReportResponseHelper> listUsers;
    
    public UserExcelExporterService(List<DownloadReportResponseHelper> listUsers) {
        this.listUsers = listUsers;
        workbook = new XSSFWorkbook();
    }
    
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Users");
        Row row = (Row) sheet.createRow(0);
        
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(12);
        style.setFont(font);
        style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());



       createCell(row, 0, "Assessment ID", style);
//        createCell(row, 0, "User ID", style);
        createCell(row, 1, "Email Id", style);       
        createCell(row, 2, "Project Id", style);    
        createCell(row, 3, "Project Name", style);
        createCell(row, 4, "BU Name", style);
        createCell(row, 5, "Assessment Status", style);
        createCell(row, 6, "Created At", style);
    
        
    }
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = ( (Row) row).createCell(columnCount);
//        cell.setCellValue((String) value);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Date) {
            cell.setCellValue((Date) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
    
    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(8);
        style.setFont(font);
                 
        for (DownloadReportResponseHelper user : listUsers) {
            Row row = (Row) sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, user.getAssessmentid(), style);
            createCell(row, columnCount++, user.getEmailid(), style);
            createCell(row, columnCount++, user.getProjectid(), style);
            createCell(row, columnCount++, user.getProjectName(), style);
            createCell(row, columnCount++, user.getBuname(), style);
            createCell(row, columnCount++, user.getAssessementStatus(), style);
            createCell(row, columnCount++, user.getCreatedAt(), style);
            
             
        }
    }
    
    public String export() throws IOException{
        writeHeaderLine();
        writeDataLines();
        
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateTime = dateFormatter.format(new Date());
        String fileName = "DMATReport"+ currentDateTime +".xlsx";
        
        //return fileName;
        
        String fileLocation = "C:\\ProjectReports\\"+fileName;
        System.out.println("...........................");
      System.out.println(fileLocation);

       FileOutputStream outputStream = new FileOutputStream(fileLocation);
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        return fileLocation;
    }
    
}