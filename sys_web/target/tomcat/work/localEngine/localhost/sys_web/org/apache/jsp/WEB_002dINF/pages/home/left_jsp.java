package org.apache.jsp.WEB_002dINF.pages.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class left_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/WEB-INF/pages/home/../base.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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

      out.write('\r');
      out.write('\n');
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/css/default.css\" media=\"all\"/>\r\n");
      out.write("<link rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/css/table.css\" media=\"all\"/>\r\n");
      out.write("<script language=\"javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/common.js\"></script>");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("    <title></title>\r\n");
      out.write("    <link rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/css/left.css\" media=\"all\"/>\r\n");
      out.write("\r\n");
      out.write("\t<script language=\"javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/common.js\"></script>\r\n");
      out.write("\t<script language=\"javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/ajax/setFastMenu.js\"></script>\r\n");
      out.write("\t<script language=\"javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/pngfix_map.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/components/jquery-ui/jquery-1.2.6.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/js/toggle.js\"></script>\r\n");
      out.write(" \r\n");
      out.write("\t\r\n");
      out.write("    <script language=\"javascript\">\r\n");
      out.write("    \t$().ready(function(){\r\n");
      out.write("\t\t\t$(fastMenu).hide();\r\n");
      out.write("\t\t\t//document.getElementById('aa_3').click();\t//默认打开我的留言板页面\r\n");
      out.write("    \t});\r\n");
      out.write("    \t\r\n");
      out.write("    \tfunction showMenu( who ){\r\n");
      out.write("    \t\tif(who==\"fastMenu\"){\r\n");
      out.write("    \t\t\t$(fastMenu).show();\r\n");
      out.write("    \t\t\t$(customerMenu).hide();\r\n");
      out.write("    \t\t}else if(who==\"customerMenu\"){\r\n");
      out.write("    \t\t\t$(customerMenu).show();\r\n");
      out.write("    \t\t\t$(fastMenu).hide();\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t}\r\n");
      out.write("    </script>\r\n");
      out.write(" \r\n");
      out.write("    \r\n");
      out.write("</head>\r\n");
      out.write(" \r\n");
      out.write("<body id=\"left_frame\">\r\n");
      out.write("<div class=\"PositionFrame_black\" id=\"PositionFrame\"></div>\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("<div id=\"sidebar\" class=\"sidebar\">\r\n");
      out.write("\t<div class=\"sidebar_t\">\r\n");
      out.write("\t\t<div class=\"sidebar_t_l\"></div>\r\n");
      out.write("\t\t<div class=\"sidebar_t_c\"></div>\r\n");
      out.write("\t\t<div class=\"sidebar_t_r\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t   <div class=\"panel\">\r\n");
      out.write("\t       <div class=\"panel_icon\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/images/icon/user2.png\" /></div>\r\n");
      out.write("\t       <div class=\"panel-header\">\r\n");
      out.write("\t        <div class=\"panel-title\">个人工作台</div>\r\n");
      out.write("\t        <div class=\"panel-content\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/tomain.action?modelName=home\" target=\"main\" id=\"aa_3\" onclick=\"linkHighlighted(this)\">我的留言板</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/home/workflow/tasklist.action\" target=\"main\" id=\"aa_2\" onclick=\"linkHighlighted(this)\">我的代办任务</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/baseinfo/leavebill/list.action\" target=\"main\" id=\"aa_1\" onclick=\"linkHighlighted(this)\">意见反馈</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t        \r\n");
      out.write("\t       </div>\r\n");
      out.write("\t   </div>\r\n");
      out.write("    <div class=\"sidebar_t\">\r\n");
      out.write("\t\t<div class=\"sidebar_b_l\"></div>\r\n");
      out.write("\t\t<div class=\"sidebar_t_c\"></div>\r\n");
      out.write("\t\t<div class=\"sidebar_b_r\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("<div id=\"sidebar\" class=\"sidebar\">\t\r\n");
      out.write("\t<div class=\"sidebar_t\">\r\n");
      out.write("\t\t<div class=\"sidebar_t_l\"></div>\r\n");
      out.write("\t\t<div class=\"sidebar_t_c\"></div>\r\n");
      out.write("\t\t<div class=\"sidebar_t_r\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write(" \t    <div class=\"panel\">\r\n");
      out.write("\t        <div class=\"panel_icon\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/images/icon/cubes.png\" /></div>\r\n");
      out.write("\t        <div class=\"panel-header\">\r\n");
      out.write("\t\t    \t<div class=\"panel-title\">我的常用功能</div>\r\n");
      out.write("\t\t\t\t\t<div style=\"margin-top:5px;\"></div>\r\n");
      out.write("\t\t\t\t\t<!-- 以上为永久固定栏目，以下为活动栏目 -->\r\n");
      out.write("\t        <div style=\"border-bottom:1px dotted #cee1df;\"> \r\n");
      out.write("\t         切换:<a href=\"#\" onmousemove=\"javascript:showMenu('fastMenu');\">快捷菜单</a>\r\n");
      out.write("\t        /\r\n");
      out.write("\t        <a href=\"#\" onmousemove=\"javascript:showMenu('customerMenu');\">自定义菜单</a>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t\t        \t<div id=\"fastMenu\">\r\n");
      out.write("\t\t        \t<div class=\"panel-content\"></div><a href=\"#\" class=\"DelFastMenu\"><font color=\"gray\">清除常用功能列表</font></a>\r\n");
      out.write("\t\t        \t</div>\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \t<div id=\"customerMenu\">\r\n");
      out.write("\t\t        \t<div class=\"FastMenu\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/images/notice.gif\" style=\"margin-right:5px;\" border=\"0\" /><font color=\"gray\">您还没定义您的菜单</font></div>\r\n");
      out.write("\t\t        \t</div>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t <div class=\"sidebar_t\">\r\n");
      out.write("\t\t<div class=\"sidebar_b_l\"></div>\r\n");
      out.write("\t\t<div class=\"sidebar_t_c\"></div>\r\n");
      out.write("\t\t<div class=\"sidebar_b_r\"></div>\r\n");
      out.write("\t</div>    \r\n");
      out.write("</div>\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("<!-- begin1  -->\r\n");
      out.write("<div id=\"sidebar\" class=\"sidebar\">\r\n");
      out.write("\t<div class=\"sidebar_t\">\r\n");
      out.write("\t\t<div class=\"sidebar_t_l\"></div>\r\n");
      out.write("\t\t<div class=\"sidebar_t_c\"></div>\r\n");
      out.write("\t\t<div class=\"sidebar_t_r\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("    <div class=\"panel\">\r\n");
      out.write("    \t<div class=\"panel_icon\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/images/icon/businessman2.png\" /></div>\r\n");
      out.write("        <div class=\"panel-header\">\r\n");
      out.write("        <div class=\"panel-title\">\r\n");
      out.write("\t\t用户设定\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"panel-content\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\" id=\"aa_2\" onclick=\"linkHighlighted(this)\">个人信息修改</a></li>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<li><a href=\"#\" id=\"aa_2\" onclick=\"linkHighlighted(this)\">系统使用反馈</a></li>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"sidebar_t\">\r\n");
      out.write("\t\t<div class=\"sidebar_b_l\"></div>\r\n");
      out.write("\t\t<div class=\"sidebar_t_c\"></div>\r\n");
      out.write("\t\t<div class=\"sidebar_b_r\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- end1 -->\r\n");
      out.write(" \r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/pages/home/../base.jsp(5,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/pages/home/../base.jsp(5,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/pages/home/../base.jsp(5,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }
}
