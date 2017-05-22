package com.xxx.sys.action.statistics;

import java.io.FileNotFoundException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.xxx.sys.action.BaseAction;
import com.xxx.sys.springdao.SqlDao;
import com.xxx.sys.utils.file.FileUtil;

public class StatChartAction extends BaseAction {

	// 省略了StatChartService, = =!
	private SqlDao sqlDao;
	public void setSqlDao(SqlDao sqlDao) {
		this.sqlDao = sqlDao;
	}
	
	/**
	 * 厂家销量排名
	 */
	public String factorysale() throws Exception {
		List<String> list = execSQL("select factory_name,sum(amount) samount from contract_product_c group by factory_name order by samount desc");
		System.out.println("----------------------->");
		/*	拼接json数据
		var chartData = [
		                 {
		                     "country": "USA",
		                     "visits": 4025,
		                     "color": "#FF0F00"
		                 },
		*/
		StringBuilder sb = new StringBuilder();
		String colors[]={"#FF0F00","#FF6600","#FF9E01","#FCD202","#F8FF01","#B0DE09","#04D215","#0D52D1","#2A0CD0","#8A0CCF","#CD0D74","#754DEB"};
		sb.append("[");
		for (int i = 0, j = 0; i < list.size(); i++) {
			sb.append("{").append("\"factory\":\"").append(list.get(i)).append("\",")
			  .append("\"amount\":\"").append(list.get(++i)).append("\",")
			  .append("\"color\":\"").append(colors[j>=colors.length?j=0:j++]).append("\"")
			  .append("},");
		}
		sb.delete(sb.length()-1, sb.length());
		
		sb.append("]");
		
		// 将json放入值栈
		super.put("result", sb.toString());

		return "factorysale01";
	}
	/**
	 * 厂家销量排名(旧版)
	 */
/*	public String factorysale() throws Exception {
//		write2XML("stat\\chart\\factorysale\\data.xml",this.genPieDataSet(this.execSQL("select factory_name,sum(amount) samount from contract_product_c group by factory_name order by samount desc")));
		
		List<String> list = execSQL("select factory_name,sum(amount) samount from contract_product_c group by factory_name order by samount desc");
		
		// 拼接xml数据
		String xmlData = genPieDataSet(list);
		
		// 将sb写入data.xml文件中
		write2XML("stat\\chart\\factorysale\\data.xml",xmlData);
		
		return "factorysale";
	}*/
	
	/**
	 * 产品销量前15名
	 * @return
	 * @throws Exception
	 */
	public String productsale() throws Exception {
		
		List<String> list = execSQL("select * from ( select product_no,sum(amount) samount from contract_product_c group by product_no order by samount desc ) b  where rownum<16");
		
		// 拼接xml数据
		String xmlData = genBarDataSet(list);
		
		// 将sb写入data.xml文件中
		write2XML("stat\\chart\\productsale\\data.xml",xmlData);
		
		return "productsale";
	}

	/**
	 * 在线人数统计
	 * 		表：LOGIN_LOG_P
	 * 		对登录者IP统计
	 * @return
	 * @throws Exception
	 */
	public String onlineinfo() throws Exception {
		
		List<String> list = execSQL("select a.a1, nvl(b.c,0) from (select * from online_info_t) a left join (select to_char(login_time,'HH24') a1, count(*) c from login_log_p group by  to_char(login_time,'HH24') order by a1) b on (a.a1=b.a1) order by a.a1");
		
		// 拼接xml数据
		String xmlData = genLineDataSet(list);
		
		// 将sb写入data.xml文件中
		write2XML("stat\\chart\\onlineinfo\\data.xml",xmlData);
		
		return "onlineinfo";
	}

	/**
	 * 执行sql语句
	 * @param sql
	 * @return
	 */
	private List<String> execSQL(String sql) {
		// 查询统计结果
		List<String> list = sqlDao.executeSQL(sql);
		return list;
	}

	/**
	 * 生成饼图的数据源
	 * @param list
	 * @return string
	 */
	private String genPieDataSet(List<String> list) {
		StringBuilder sb=new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<pie>");
		for ( int i=0;i<list.size();i++) {
			sb.append("<slice title=\""+list.get(i++)+"\" pull_out=\"true\">"+list.get(i)+"</slice>");
		}
		sb.append("</pie>");
		return sb.toString();
	}

	/**
	 * 生成柱状图的数据源
	 * @param list
	 * @return string
	 */
	private String genBarDataSet(List<String> list) {
		StringBuilder sb = genBarOrLineDataSet(list);
	    sb.append("<labels><label lid=\"0\"><x>0</x><y>20</y><rotate></rotate><width></width><align>center</align><text_color></text_color><text_size></text_size><text><![CDATA[<b>产品销量排名</b>]]></text></label></labels>");
	    sb.append("</chart>");
		return sb.toString();
	}
	
	/**
	 * 生成折线图数据源
	 * @param list
	 * @return
	 */
	private String genLineDataSet(List<String> list) {
		StringBuilder sb = genBarOrLineDataSet(list);
		sb.append("</chart>");
		return sb.toString();
	}
	
	/**
	 * 生成折线图or柱状图数据源
	 * @param list
	 * @return
	 */
	private StringBuilder genBarOrLineDataSet(List<String> list) {
		StringBuilder sb=new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<chart><series>");
		
	    for(int i=0,j=0;i<list.size();i++){
	    	sb.append("<value xid=\""+(j++)+"\">"+list.get(i++)+"</value>");
	    }
		
	    sb.append("</series><graphs><graph gid=\"30\" color=\"#FFCC00\" gradient_fill_colors=\"#111111, #1A897C\">");
	    
	    for(int i=0,j=0;i<list.size();i++){
	    	sb.append("<value xid=\""+(j++)+"\" description=\"\" url=\"\">"+list.get(++i)+"</value>");
	    }
	    
	    sb.append("</graph></graphs>");
		return sb;
	}
	
	
	
	/**
	 * 数据写入xml文件
	 * @param fileName
	 * @param content
	 * @throws FileNotFoundException
	 */
	private void write2XML(String fileName,String content) throws FileNotFoundException {
		FileUtil fileUtil = new FileUtil();
		String sPath = ServletActionContext.getServletContext().getRealPath("/");
		fileUtil.createTxt(sPath,fileName ,content,"UTF-8");
	}
}
