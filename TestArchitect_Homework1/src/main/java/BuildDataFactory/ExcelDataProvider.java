package BuildDataFactory;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExcelDataProvider implements TestDataProvider {

    private final String filePath;
    private Map<String, String> dataMap;

    public ExcelDataProvider(String filePath) {
        this.filePath = filePath;
        this.dataMap = new HashMap<>();
        loadExcelData();
    }

    private void loadExcelData() {
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Read the first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            // Assuming the first row contains keys and the second row contains values
            Row headerRow = rowIterator.next();
            Row valueRow = rowIterator.next();

            Iterator<Cell> headerCells = headerRow.iterator();
            Iterator<Cell> valueCells = valueRow.iterator();

            while (headerCells.hasNext() && valueCells.hasNext()) {
                String key = headerCells.next().getStringCellValue();
                String value = valueCells.next().getStringCellValue();
                dataMap.put(key, value);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load data from Excel file: " + e.getMessage());
        }
    }

    @Override
    public Object getTestData(String key) {
        return dataMap.getOrDefault(key, "Key not found in Excel");
    }
}
