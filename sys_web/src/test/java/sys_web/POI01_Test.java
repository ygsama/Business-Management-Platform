package sys_web;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

public class POI01_Test {

	@Test
	public void testPOI() throws Exception{
		// 创建工作簿
		Workbook wb = new HSSFWorkbook();
		
		// 创建工作表Sheet
		Sheet sheet = wb.createSheet();
		
		// 创建行对象Row,下标从0开始
		Row row = sheet.createRow(3);
		
		// 创建单元格对象，从0
		Cell cell = row.createCell(3);
		
		// 设置单元格内容
		cell.setCellValue("测试");
		
		// 设置单元格样式
		CellStyle cellStyle = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short)48);
		cellStyle.setFont(font);
		cell.setCellStyle(cellStyle);
		
		// 保存并关闭流
		OutputStream os = new FileOutputStream("e:/test.xls");
		wb.write(os);
		os.close();
	}
}
