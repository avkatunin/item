package ru.andreykatunin.services.excel;

import io.swagger.annotations.ApiModelProperty;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;

public class ExportObjectUtils {

    public static byte[] toExcel(Object object) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(object.getClass().getCanonicalName());
        HSSFRow rowHead = sheet.createRow((0));
        HSSFRow rowBody = sheet.createRow((1));
        int i = 0;
        for (Field f: object.getClass().getDeclaredFields()) {
            ApiModelProperty property = f.getAnnotation(ApiModelProperty.class);
            f.setAccessible(true);
            if (property != null) {
                rowHead.createCell(i).setCellValue(property.notes());
                rowBody.createCell(i).setCellValue(f.get(object).toString());
            }
            i++;
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        workbook.write(bos);
        bos.close();
        workbook.close();
        return bos.toByteArray();
    }
}
