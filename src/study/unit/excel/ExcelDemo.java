package study.unit.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by whb on 2017/7/5.
 * 使用导出功能
 */
public class ExcelDemo {
    public static void main(String[] args) throws Exception{
        OutPrint();
    }
    static void OutPrint ()throws IOException{
        List temp = new ArrayList();
        FileInputStream fileIn = new FileInputStream("d:\\workbook.xls");
        //根据指定的文件输入流导入Excel从而产生Workbook对象
        Workbook wb = new HSSFWorkbook(fileIn);
        //获取Excel文档中的第一个表单
        Sheet sht0 = wb.getSheetAt(0);
        //对Sheet中的每一行进行迭代
        for (Row r : sht0) {
            //如果当前行的行号（从0开始）未达到2（第三行）则从新循环
            if (r.getRowNum() < 1) {
                continue;
            }

        System.out.println(r.getCell(0).getStringCellValue());
            //r.getCell(1).setCellType(CellType.STRING);
            //设置字符串
            r.getCell(2).setCellType(CellType.STRING);
            //获取时间类型
            System.out.println(r.getCell(1).getDateCellValue());

            r.getCell(3).setCellType(CellType.STRING);

        System.out.println(r.getCell(2).getStringCellValue());
        System.out.println(r.getCell(3).getStringCellValue());
        }
        fileIn.close();

    }

}
