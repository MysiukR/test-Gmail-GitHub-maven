package com.epam.lab.filereader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.lab.filereader.PropertyReader.usersGmailPath;
import static com.epam.lab.utils.Constants.ROW_COUNT;
import static com.epam.lab.utils.Constants.SHIFT;

public class XSLReader {
    private PropertyReader propertyReader;
    private int cellCount;
    List<ModelGmailUsers> usersData = null;

    public XSLReader() {
        propertyReader = new PropertyReader();
        propertyReader.readProperties();
    }

    public Object[][] readXSLfile() {
        try (FileInputStream excelFile = new FileInputStream(new File(usersGmailPath))) {
            usersData = new ArrayList<>();
            Workbook workbook = WorkbookFactory.create(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = SHIFT; i < sheet.getPhysicalNumberOfRows() - SHIFT; i++) {
                Row currentRow = sheet.getRow(i);
                ModelGmailUsers gmailData = new ModelGmailUsers();
                gmailData.setLogin(currentRow.getCell(0).getStringCellValue());
                gmailData.setPassword(currentRow.getCell(1).getStringCellValue());
                gmailData.setSendTo(currentRow.getCell(2).getStringCellValue());
                gmailData.setSubject(currentRow.getCell(3).getStringCellValue());
                gmailData.setMessageText(currentRow.getCell(4).getStringCellValue());
                usersData.add(gmailData);
            }
            cellCount = usersData.size();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return convertGmailData(usersData);
    }

    public Object[][] convertGmailData(List<ModelGmailUsers> gmailUsers) {
        Object[][] usersData = new Object[cellCount][ROW_COUNT];
        for (int cell = 0; cell < cellCount; cell++) {
            usersData[cell][0] = gmailUsers.get(cell).getLogin();
            usersData[cell][1] = gmailUsers.get(cell).getPassword();
            usersData[cell][2] = gmailUsers.get(cell).getSendTo();
            usersData[cell][3] = gmailUsers.get(cell).getSubject();
            usersData[cell][4] = gmailUsers.get(cell).getMessageText();
        }
        return usersData;
    }
}

