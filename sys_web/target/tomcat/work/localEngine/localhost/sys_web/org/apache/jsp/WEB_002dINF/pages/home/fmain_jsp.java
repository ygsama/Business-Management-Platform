package org.apache.jsp.WEB_002dINF.pages.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fmain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>商务综合管理平台</title>\r\n");
      out.write("</head>\r\n");
      out.write("<frameset rows=\"125,*\" name=\"topFrameset\" border=\"0\">\r\n");
      out.write("\t<frame name=\"top_frame\" scrolling=\"no\"  target=\"middleFrameSet\" src=\"homeAction_title\">\t\r\n");
      out.write("\t<frameset cols=\"202,*\" height=\"100%\" name=\"middle\" frameborder=\"no\" border=\"0\" framespacing=\"0\">\r\n");
      out.write("\t\t<frame name=\"leftFrame\" class=\"leftFrame\" target=\"main\" scrolling=\"no\" src=\"homeAction_toleft.action?moduleName=home\" />\r\n");
      out.write("\t\t<frame name=\"main\" class=\"rightFrame\" src=\"homeAction_tomain.action?moduleName=home\" />\r\n");
      out.write("\t</frameset>\r\n");
      out.write("</frameset>\r\n");
      out.write("\r\n");
      out.write("<noframes>\r\n");
      out.write("<body>\r\n");
      out.write("    <p>此网页使用了框架，但您的浏览器不支持框架。</p>\r\n");
      out.write("</body>\r\n");
      out.write("</noframes>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
