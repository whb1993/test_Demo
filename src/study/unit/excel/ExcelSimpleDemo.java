package study.unit.excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;

/**
 * Created by whb on 2017/7/5.
 * * 最简单的excel生成
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
public class ExcelSimpleDemo {
    public static void main(String[] args) throws Exception{

        test();
    }

    /**
     * 最简洁表格输出
      */
    void sample() throws Exception{
        //创建HSSFWorkbook对象
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建HSSFSheet对象
        HSSFSheet sheet = wb.createSheet("工作表名字");
        //创建HSSFRow对象  行
        HSSFRow row = sheet.createRow(0);
        //创建HSSFCell对象  子表格单元
        HSSFCell cell = row.createCell(0);
        //设置单元格的值
        cell.setCellValue("输出excel");
        //输出Excel文件
        FileOutputStream output = new FileOutputStream("d:\\workbook.xls");
        wb.write(output);
        output.flush();
    }

    /**
     * 一般使用表格
     */
    static void test () throws Exception{
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook workbook = new HSSFWorkbook();
//      建立新的sheet对象（excel的表单）
        HSSFSheet sheet=workbook.createSheet("成绩表");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row=sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell=row.createCell(0);
        //设置单元格内容
        cell.setCellValue("学员考试成绩一览表");
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
        //在sheet里创建第二行
        HSSFRow row2=sheet.createRow(1);
        //创建单元格并设置单元格内容
        row2.createCell(0).setCellValue("姓名");
        row2.createCell(1).setCellValue("班级");
        row2.createCell(2).setCellValue("笔试成绩");
        row2.createCell(3).setCellValue("机试成绩");
        //在sheet里创建第三行
        HSSFRow row3=sheet.createRow(2);
        row3.createCell(0).setCellValue("李明");
        row3.createCell(1).setCellValue("As178");
        row3.createCell(2).setCellValue("87");
        row3.createCell(3).setCellValue("78");
        //输出Excel文件
        FileOutputStream output = new FileOutputStream("d:\\workbook.xls");
        workbook.write(output);
        output.close();

    }


    /**
     * 带样式表格输出
     */
    static void typeExcel() throws Exception{
        //创建HSSFWorkbook对象
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建HSSFSheet对象
        HSSFSheet sheet = wb.createSheet("工作表名字");
        //创建HSSFRow对象  行
        HSSFRow row = sheet.createRow(0);
        //创建HSSFCell对象  子表格单元
        HSSFCell cell = row.createCell(0);

        //整体样式
        sheet.setDefaultRowHeightInPoints(50);
        //设置缺省列高sheet.setDefaultColumnWidth(20);//设置缺省列宽
        //设置指定列的列宽，256 * 50这种写法是因为width参数单位是单个字符的256分之一
        //sheet.setColumnWidth(cell.getColumnIndex(), 256 * 50);
       //添加样式对象
        HSSFCellStyle cellStyle=wb.createCellStyle();
        HSSFCellStyle cellFontStyle=wb.createCellStyle();

        /* 设置单元格的填充方式，以及前景颜色和背景颜色
           三点注意：
           1.如果需要前景颜色或背景颜色，一定要指定填充方式，两者顺序无所谓；
           2.如果同时存在前景颜色和背景颜色，前景颜色的设置要写在前面；
           3.前景颜色不是字体颜色。
          */
        //设置填充方式(填充图案)
        cellStyle.setFillPattern(HSSFCellStyle.DIAMONDS);
        //设置前景色
        cellStyle.setFillForegroundColor(HSSFColor.RED.index);
        //设置背景颜色
        cellStyle.setFillBackgroundColor(HSSFColor.LIGHT_YELLOW.index);
        //将样式应用于单元格
        //cell.setCellStyle(cellStyle);
        //将样式应用到行，但有些样式只对单元格起作用
       // row.setRowStyle(cellStyle);

        //设置字体样式
        //创建HSSFFont对象（调用HSSFWorkbook 的createFont方法）
        HSSFFont  fontStyle=wb.createFont();
        //设置字体各种样式
        //设置字体样式
        fontStyle.setFontName("宋体");
        //设置字体高度
        fontStyle.setFontHeightInPoints((short)20);
        //设置字体颜色
        fontStyle.setColor(HSSFColor.BLUE.index);
        //设置粗体
        fontStyle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置斜体
        fontStyle.setItalic(true);
        //设置下划线
        fontStyle.setUnderline(HSSFFont.U_SINGLE);
        // 将字体对象赋值给单元格样式对象
        cellFontStyle.setFont(fontStyle);
        // 将单元格样式应用于单元格
        cell.setCellStyle(cellFontStyle);

        //设置单元格的值
        cell.setCellValue("输出excel");

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


 * 样式：

 HSSFCellStyle                       cell样式

 辅助操作包括：

 HSSFDateUtil                        日期

 HSSFPrintSetup                      打印

 HSSFErrorConstants                  错误信息表
 */

