package com.xxx.sys.action.cargo;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;

import com.xxx.sys.action.BaseAction;
import com.xxx.sys.domain.ContractProduct;
import com.xxx.sys.service.ContractProductService;
import com.xxx.sys.utils.DownloadUtil;
import com.xxx.sys.utils.UtilFuns;

/**
 * 出货表模块
 * @author G
 *
 */
public class OutProductAction extends BaseAction {

	/**
	 * 接收页面上的船期
	 */
	private String inputDate;
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	
	/**
	 * 注入货物的业务逻辑
	 */
	private ContractProductService contractProductService;
	public void setContractProductService(ContractProductService contractProductService) {
		this.contractProductService = contractProductService;
	}

	/**
	 * 进入出货表的打印页面
	 * @return
	 * @throws Exception
	 */
	public String toedit() throws Exception {
		
		return "toedit";
	}
	
	/**
	 * 打印出货表，下载xls
	 * @return
	 * @throws Exception
	 */
	public String print() throws Exception {
		int rowNo = 0,cellNo=1;
		Row row = null;
		Cell cell = null;
		
		// 读取工作簿
		String path = ServletActionContext.getServletContext().getRealPath("/")+"make/xlsprint/tOUTPRODUCT.xls";
		System.out.println("---->"+path);
		InputStream is = new FileInputStream(path);
		Workbook wb = new HSSFWorkbook(is);

		// 读取工作表Sheet

		Sheet sheet = wb.getSheetAt(0);
		/*****************大标题*****************/
		
		// 读取行对象
		row = sheet.getRow(rowNo++);
		cell = row.getCell(cellNo);
		// 设置单元格内容
		cell.setCellValue(inputDate.replace("-0", "-").replace("-", "年")+"月份出货表");
		
		/*****************小标题*****************/
		rowNo++;
		
		/*****************行数据*****************/
		// 读取第三行,及各列样式
		row = sheet.getRow(rowNo);
		CellStyle customCellStyle = row.getCell(cellNo++).getCellStyle();
		CellStyle orderNoCellStyle = row.getCell(cellNo++).getCellStyle();
		CellStyle productNoCellStyle = row.getCell(cellNo++).getCellStyle();
		CellStyle cNumberCellStyle = row.getCell(cellNo++).getCellStyle();
		CellStyle factoryCellStyle = row.getCell(cellNo++).getCellStyle();
		CellStyle deliveryPeriodCellStyle = row.getCell(cellNo++).getCellStyle();
		CellStyle shipTimeCellStyle = row.getCell(cellNo++).getCellStyle();
		CellStyle tradeTermsCellStyle = row.getCell(cellNo++).getCellStyle();
		

		String hql = "from ContractProduct where to_char(contract.shipTime,'yyyy-MM')=?";
		List<ContractProduct> list = contractProductService.find(hql, ContractProduct.class,new String[]{inputDate});
		
		for(ContractProduct cp:list){
			row = sheet.createRow(rowNo++);// 创建行
			row.setHeightInPoints(24f);// 设置行高
			
			cellNo=1;
			cell = row.createCell(cellNo++);// 创建单元格
			cell.setCellValue(cp.getContract().getCustomName());// 写入客户名称
			cell.setCellStyle(customCellStyle);//设置文本样式
			
			cell = row.createCell(cellNo++);// 创建单元格
			cell.setCellValue(cp.getContract().getContractNo());// 订单号，合同号
			cell.setCellStyle(orderNoCellStyle);//设置文本样式
			
			cell = row.createCell(cellNo++);// 创建单元格
			cell.setCellValue(cp.getProductNo());// 货物号
			cell.setCellStyle(productNoCellStyle);//设置文本样式
			
			cell = row.createCell(cellNo++);// 创建单元格
			cell.setCellValue(cp.getCnumber());// 数量
			cell.setCellStyle(cNumberCellStyle);//设置文本样式
			
			cell = row.createCell(cellNo++);// 创建单元格
			cell.setCellValue(cp.getFactoryName());// 工厂名
			cell.setCellStyle(factoryCellStyle);//设置文本样式
			
			cell = row.createCell(cellNo++);// 创建单元格
			cell.setCellValue(UtilFuns.dateTimeFormat(cp.getContract().getDeliveryPeriod()));// 工厂交期
			cell.setCellStyle(deliveryPeriodCellStyle);//设置文本样式
			
			cell = row.createCell(cellNo++);// 创建单元格
			cell.setCellValue(UtilFuns.dateTimeFormat(cp.getContract().getShipTime()));// 船期
			cell.setCellStyle(shipTimeCellStyle);//设置文本样式
			
			cell = row.createCell(cellNo++);// 创建单元格
			cell.setCellValue(cp.getContract().getTradeTerms());// 贸易条款
			cell.setCellStyle(tradeTermsCellStyle);//设置文本样式
		}
		
		
		// 输出，下载
		ByteArrayOutputStream stream = new ByteArrayOutputStream();// 流，内存中的缓存区
		wb.write(stream);// 将excle输出到缓存
		DownloadUtil dl = new DownloadUtil();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		dl.download(stream, response, "出货表.xls");
		//stream. close();
		
		return NONE;
	}
	
	
/*	public String printNoTemplate() throws Exception {
		int rowNo = 0,cellNo=1;
		Row row = null;
		Cell cell = null;
		
		// 创建工作簿
		Workbook wb = new HSSFWorkbook();
		
		// 创建工作表Sheet
		Sheet sheet = wb.createSheet();
		
		// 设置列宽
		sheet.setColumnWidth(cellNo++, 26*256);
		sheet.setColumnWidth(cellNo++, 11*256);
		sheet.setColumnWidth(cellNo++, 29*256);
		sheet.setColumnWidth(cellNo++, 12*256);
		sheet.setColumnWidth(cellNo++, 15*256);
		sheet.setColumnWidth(cellNo++, 10*256);
		sheet.setColumnWidth(cellNo++, 10*256);
		sheet.setColumnWidth(cellNo++, 8*256);
		cellNo = 1;
		
		*//*****************大标题*****************//*
		
		// 创建行对象
		row = sheet.createRow(rowNo++);
		row.setHeightInPoints(36);//行高
		cell = row.createCell(cellNo);//创建单元格
		
		// 合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0,0,1,8));
		
		// 设置单元格内容
		cell.setCellValue(inputDate.replace("-0", "-").replace("-", "年")+"月份出货表");
		
		// 设置样式
		cell.setCellStyle(this.bigTitle(wb));
		
		*//*****************小标题*****************//*
		
		String titles[] = {"客户","订单号","货号","数量","工厂","附件","工厂交期","船期","贸易条款"};
		
		// 小标题行对象
		row = sheet.createRow(rowNo++);
		row.setHeightInPoints(26.25f);//行高
		
		// 创建单元格对象，并设置内容，样式
		for(String title :titles){
			cell = row.createCell(cellNo++);//单元格
			cell.setCellValue(title);
			cell.setCellStyle(this.title(wb));
		}
		
		*//*****************行数据*****************//*
		String hql = "from ContractProduct where to_char(contract.shipTime,'yyyy-MM')=?";
		List<ContractProduct> list = contractProductService.find(hql, ContractProduct.class,new String[]{inputDate});
		
		for(ContractProduct cp:list){
			row = sheet.createRow(rowNo++);// 创建行
			row.setHeightInPoints(24);// 设置行高
			
			cellNo=1;
			cell = row.createCell(cellNo++);// 创建单元格
			cell.setCellValue(cp.getContract().getCustomName());// 写入客户名称
			cell.setCellStyle(this.text(wb));//设置文本样式
			
			cell = row.createCell(cellNo++);// 创建单元格
			cell.setCellValue(cp.getContract().getContractNo());// 订单号，合同号
			cell.setCellStyle(this.text(wb));//设置文本样式
			
			cell = row.createCell(cellNo++);// 创建单元格
			cell.setCellValue(cp.getProductNo());// 货物号
			cell.setCellStyle(this.text(wb));//设置文本样式
			
			cell = row.createCell(cellNo++);// 创建单元格
			cell.setCellValue(cp.getCnumber());// 数量
			cell.setCellStyle(this.text(wb));//设置文本样式
			
			cell = row.createCell(cellNo++);// 创建单元格
			cell.setCellValue(cp.getFactoryName());// 工厂名
			cell.setCellStyle(this.text(wb));//设置文本样式
			
			cell = row.createCell(cellNo++);// 创建单元格
			cell.setCellValue(UtilFuns.dateTimeFormat(cp.getContract().getDeliveryPeriod()));// 工厂交期
			cell.setCellStyle(this.text(wb));//设置文本样式
			
			cell = row.createCell(cellNo++);// 创建单元格
			cell.setCellValue(UtilFuns.dateTimeFormat(cp.getContract().getShipTime()));// 船期
			cell.setCellStyle(this.text(wb));//设置文本样式
			
			cell = row.createCell(cellNo++);// 创建单元格
			cell.setCellValue(cp.getContract().getTradeTerms());// 贸易条款
			cell.setCellStyle(this.text(wb));//设置文本样式
		}
		
		
		// 输出，下载
		ByteArrayOutputStream stream = new ByteArrayOutputStream();// 流，内存中的缓存区
		wb.write(stream);// 将excle输出到缓存
		DownloadUtil dl = new DownloadUtil();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		dl.download(stream, response, "出货表.xls");
		stream. close();//刷新缓存
		return NONE;
	}*/
	
	//大标题的样式
	public CellStyle bigTitle(Workbook wb){
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short)16);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);					//字体加粗
		
		style.setFont(font);
		
		style.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中
		
		return style;
	}
	//小标题的样式
	public CellStyle title(Workbook wb){
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short)12);
		
		style.setFont(font);
		
		style.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中
		
		style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
		style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
		style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
		style.setBorderRight(CellStyle.BORDER_THIN);				//右细线
		
		return style;
	}
	
	//文字样式
	public CellStyle text(Workbook wb){
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("Times New Roman");
		font.setFontHeightInPoints((short)10);
		
		style.setFont(font);
		
		style.setAlignment(CellStyle.ALIGN_LEFT);					//横向居左
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中
		
		style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
		style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
		style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
		style.setBorderRight(CellStyle.BORDER_THIN);				//右细线
		
		return style;
	}
}
