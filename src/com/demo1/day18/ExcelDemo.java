package com.demo1.day18;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by whb on 2017/7/3.
 * 最简单的excel生成
 * 首先，理解一下
 * 一个Excel的文件的组织形式，
  一个Excel文件对应于一个workbook(HSSFWorkbook)，
  一个workbook可以有多个sheet（HSSFSheet）组成，
  一个sheet是由多个row（HSSFRow）组成，
  一个row是由多个cell（HSSFCell）组成。
  基本操作步骤：
 1、用HSSFWorkbook打开或者创建“Excel文件对象”
 2、用HSSFWorkbook对象返回或者创建Sheet对象
 3、用Sheet对象返回行对象，用行对象得到Cell对象
 4、对Cell对象读写。
 */
public class ExcelDemo {
    public static void main(String[] args) throws IOException{
        //创建HSSFWorkbook对象
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建HSSFSheet对象
        HSSFSheet sheet = wb.createSheet("sheet0");
        //创建HSSFRow对象
        HSSFRow row = sheet.createRow(0);
        //创建HSSFCell对象
        HSSFCell cell = row.createCell(0);
        //设置单元格的值
        cell.setCellValue("单元格中的中文");
        //输出Excel文件
        FileOutputStream output = new FileOutputStream("d:\\workbook.xls");
        wb.write(output);
        output.flush();
    }
}
/**
 * 常用组件：

 HSSFWorkbook                      excel的文档对象

 HSSFSheet                         excel的表单

 HSSFRow                           excel的行

 HSSFCell                          excel的格子单元

 HSSFFont                          excel字体

 HSSFDataFormat                    日期格式

 HSSFHeader                        sheet头

 HSSFFooter                        sheet尾（只有打印的时候才能看到效果）
 */
/**
 * 样式：

 HSSFCellStyle                       cell样式

 辅助操作包括：

 HSSFDateUtil                        日期

 HSSFPrintSetup                      打印

 HSSFErrorConstants                  错误信息表
 */



