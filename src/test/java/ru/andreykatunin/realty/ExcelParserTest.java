package ru.andreykatunin.realty;

import org.apache.poi.hssf.converter.ExcelToHtmlConverter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ExcelParserTest {

    @Test
    public void readExcel() {
        try {
            FileInputStream file = new FileInputStream(new File("src/test/resources/test1.xls"));
            Workbook workbook = new XSSFWorkbook(file);

            Sheet sheet = workbook.getSheetAt(0);

            Map<Integer, List<String>> data = new HashMap<>();
            int i = 0;
            for (Row row : sheet) {
                data.put(i, new ArrayList<>());
                for (Cell cell : row) {
                    switch (cell.getCellTypeEnum()) {
                        case STRING:
                            System.out.println(cell.getStringCellValue());
                            cell.getAddress();
                            break;
                        case NUMERIC:
                            System.out.println(cell.getNumericCellValue());
                            cell.getAddress();
                            break;
                        case BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            cell.getAddress();
                            break;
                        case FORMULA:
                            System.out.println(cell.getCellFormula());
                            cell.getAddress();
                            break;
                        default: data.get(new Integer(i)).add(" ");
                    }
                }
                i++;
            }
            System.out.println("END");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void convertToHtml() {
        FileInputStream file = null;
        try {
            String fileName = "src/test/resources/index.html";

            file = new FileInputStream(new File("src/test/resources/test.xls"));
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            ExcelToHtmlConverter converter = new ExcelToHtmlConverter(
                    DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument()
            );

            converter.processWorkbook(workbook);

            Document htmlDoc = converter.getDocument();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            DOMSource domSource = new DOMSource(htmlDoc);
            StreamResult streamResult = new StreamResult(out);
            TransformerFactory transfFactory = TransformerFactory.newInstance();
            Transformer serializer = transfFactory.newTransformer();

            serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            serializer.setOutputProperty(OutputKeys.INDENT, "yes");
            serializer.setOutputProperty(OutputKeys.METHOD, "html");
            serializer.transform(domSource, streamResult);

            try(OutputStream outputStream = new FileOutputStream(fileName)) {
                out.writeTo(outputStream);
            }

            out.close();

            String result = new String(out.toByteArray());
        } catch (IOException | ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void base64() {
        byte[] document = null;
        try {
            document = Files.readAllBytes(Paths.get("/home/andrei/Загрузки/file.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String documentAsString = Base64.getEncoder().encodeToString(document);
        System.out.println(documentAsString);
    }
}