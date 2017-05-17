package org.apache.jsp.WEB_002dINF.pages.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class title_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/WEB-INF/pages/home/../base.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      java.util.Date now = null;
      synchronized (_jspx_page_context) {
        now = (java.util.Date) _jspx_page_context.getAttribute("now", PageContext.PAGE_SCOPE);
        if (now == null){
          now = new java.util.Date();
          _jspx_page_context.setAttribute("now", now, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("    <title></title>\r\n");
      out.write("\r\n");
      out.write("    <!-- 调用样式表 -->\r\n");
      out.write("    <link rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/css/default.css\" media=\"all\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/css/title.css\" media=\"all\"/>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/components/jquery-ui/jquery-1.2.6.js\"></script>    \t\r\n");
      out.write("\t<script language=\"javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/pngfix_map.js\"></script>\r\n");
      out.write("\t<script language=\"javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/common.js\"></script>\r\n");
      out.write("    <!-- 调用外部 JavaScript 脚本语言 -->\r\n");
      out.write("\t\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\r\n");
      out.write("\tfunction CustomTitle(){\r\n");
      out.write("\t\tvar Me = document.getElementById('memos');\r\n");
      out.write("\t\tvar Loin = document.getElementById('logins');\r\n");
      out.write("\t\tvar Lout = document.getElementById('logout');\r\n");
      out.write("\t\tMe.onmouseover = function(){document.getElementById('memo').style.background='url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/images/title/memo2.gif) no-repeat'};\r\n");
      out.write("\t\tMe.onmouseout = function(){document.getElementById('memo').style.background='url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/images/title/memo.gif) no-repeat'};\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tLoin.onmouseover = function(){document.getElementById('small_login').style.background='url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/images/title/small_login2.gif) no-repeat'};\r\n");
      out.write("\t\tLoin.onmouseout = function(){document.getElementById('small_login').style.background='url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/images/title/small_login.gif) no-repeat'};\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tLout.onmouseover = function(){document.getElementById('small_login_out').style.background='url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/images/title/login_out2.gif) no-repeat left -55px;'};\r\n");
      out.write("\t\tLout.onmouseout = function(){document.getElementById('small_login_out').style.background='url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/images/title/login_out.gif) no-repeat'};\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction linkHighlightMenu(obj){\r\n");
      out.write("\t\tvar links=document.getElementsByTagName('span');\r\n");
      out.write("\t\tfor(var i=0;i<links.length;i++){\r\n");
      out.write("\t\t\tif(links[i].id.indexOf('topmenu')!=-1){\r\n");
      out.write("\t\t\t\tlinks[i].style.background = 'url(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/images/title/li_dot.gif1\") no-repeat right 8px';\r\n");
      out.write("\t\t\t\tlinks[i].style.color = '';\r\n");
      out.write("\t\t\t\tlinks[i].style.fontWeight  = '';\r\n");
      out.write("\t\t\t\tlinks[i].style.borderTop = '';\r\n");
      out.write("\t\t\t\tlinks[i].style.borderLeft = '';\r\n");
      out.write("\t\t\t\tlinks[i].style.borderRight = '';\r\n");
      out.write("\t\t\t\tlinks[i].style.padding = '';\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tobj.style.background ='url(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/images/title/button_bg.jpg\") no-repeat';\r\n");
      out.write("\t\tobj.style.color = \"#fff\";                                                                                                                                                                                                                                                   \r\n");
      out.write("\t\tobj.style.fontWeight  = 'bold';\r\n");
      out.write("\t\tobj.style.padding= '6px 11x 5px 13px;';\r\n");
      out.write("\t\tobj.blur();\t\t//去掉图片的焦点框,使界面看起来漂亮 updated by tony\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t//sendRequest('000001');\t\r\n");
      out.write("\tvar y = -5; \t\t//个人信息栏初始Y坐标\r\n");
      out.write("\tvar dy = -40; \t\t//显示后Y坐标\r\n");
      out.write("\t\r\n");
      out.write("\tfunction doLoginDiv(){\r\n");
      out.write("\t\tShowLoginDiv();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction HideLoginDiv(){\r\n");
      out.write("\t\t dy = dy - 5;\r\n");
      out.write("\t\t MoveHideLoginDiv();\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction MoveHideLoginDiv(){\r\n");
      out.write("\t\tif( dy > -40){setTimeout(\"HideLoginDiv()\",10);}else{ y = -40; dy = -40;}\r\n");
      out.write("\t\tdocument.getElementById(\"userInfo\").style.top = dy;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction ShowLoginDiv(){\r\n");
      out.write("\t\t y = y + 5;\r\n");
      out.write("\t\t MoveShowLoginDiv();\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction MoveShowLoginDiv(){\t\t\t\r\n");
      out.write("\t\t\tif( y < -5){setTimeout(\"ShowLoginDiv()\",10);}else{ dy = -5; y = -1 }\r\n");
      out.write("\t\t\tdocument.getElementById(\"userInfo\").style.top = y;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction ShowFrameDiv(queryString){\r\n");
      out.write("\t\t\treturn false;\t\t//暂时屏蔽\r\n");
      out.write("\t\ttop.middle.switches.loading.style.display = 'block';\r\n");
      out.write("\t//\ttop.middle.switches.note_iframe.location.href=\"../home/empmemo/empMemoExpressCreate.jsp\";\r\n");
      out.write("\t\tsetTimeout(ShowFrameMain(queryString),10);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction ShowFrameMain(passValue){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar url = \"../home/doConsoleListAction.do\";\t//../home/empMemoCreateAction.do\r\n");
      out.write("\t\t\tvar topFrame = top.middle.switches;\r\n");
      out.write("\r\n");
      out.write("\t\t\tdocument.getElementById('PositionFrame').style.display = \"block\";\r\n");
      out.write("\t\t\ttop.middle.contents.left_frame.style.border = \"none\";\r\n");
      out.write("\t\t\ttop.middle.contents.left_frame.style.overflow = \"hidden\";\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\ttopFrame.PositionFrame_main.style.display =\"block\";\r\n");
      out.write("\t\t\ttopFrame.PositionFrame.style.display =\"block\";\r\n");
      out.write("\t\t\ttopFrame.PositionFrame_notebook.style.display = 'block';\r\n");
      out.write("\t\t\ttopFrame.PositionFrame_notebook2.style.display = 'none';\t\r\n");
      out.write("\t\t\ttopFrame.PositionFrame_my_note.style.display = 'block';\r\n");
      out.write("\t\t\t//topFrame.note_iframe.location.href=url;\r\n");
      out.write("\t\t\tform1.action = url;\r\n");
      out.write("\t\t\tform1.method = \"post\";\r\n");
      out.write("\t\t\tform1.target = \"note_iframe\";\r\n");
      out.write("//\t\t\talert(passValue);\r\n");
      out.write("\t\t\tif(passValue){\r\n");
      out.write("\t\t\t\tform1.innerHTML='<input type=\"hidden\"  name=\"passTitle\" value=\"' + passValue[0] + '\"/>';\r\n");
      out.write("\t\t\t\tform1.innerHTML=form1.innerHTML + '<input type=\"hidden\"  name=\"passContent\" value=\"' +passValue[1]+ '\"/>';\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tform1.submit();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\ttop.middle.contents.PositionFrame.style.display =\"block\";\r\n");
      out.write("\t\t\ttopFrame.loading.style.display = 'none';\r\n");
      out.write("\t\t\ttopFrame.PositionFrame_main.style.visibility = 'visible';\r\n");
      out.write("\t\t\ttopFrame.visibility.style.display = 'block';\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("   \r\n");
      out.write("\tfunction offset(place){\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar mask = $('#mask');\r\n");
      out.write("\t\tvar targetObj = $('#menuContent');\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar maxOffset = targetObj.width()-mask.width();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar currLeft = targetObj.css('left');\r\n");
      out.write("//\t\talert(maxOffset + \" \" + currLeft);\r\n");
      out.write("\t\tvar currLeft = Number(currLeft.substring(0,currLeft.length-2));\r\n");
      out.write("\t\tif(place==\"right\" && (0-currLeft) <= maxOffset){\r\n");
      out.write("\t\t\ttargetObj.css('left', currLeft - 5);\r\n");
      out.write("\t\t} else if(place==\"left\" && currLeft < 0){\r\n");
      out.write("\t\t\t\ttargetObj.css('left', currLeft + 5);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction periodOffset(thisObj, place){\r\n");
      out.write("\t\tvar intervalId = window.setInterval(function(){offset(place)}, 1);\r\n");
      out.write("\t\t$(thisObj).mouseout(function(){window.clearInterval(intervalId)});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\tfunction checkDirectionKey(){\r\n");
      out.write("\t\t\tvar mask = $('#mask');\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar bodyWidth = $('body').width();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//alert(bodyWidth - 450);\r\n");
      out.write("\t\t\tmask.width(bodyWidth - 250);\t//450\r\n");
      out.write("\t\t\t//alert(mask.width());\r\n");
      out.write("\t\t\tvar targetObj = $('#menuContent');\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar maxOffset = targetObj.width()-mask.width();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar currLeft = targetObj.css('left');\r\n");
      out.write("//\t\t\talert(maxOffset + \" \" + currLeft);\r\n");
      out.write("\t\t\tvar currLeft = Number(currLeft.substring(0,currLeft.length-2));\r\n");
      out.write("//\t\t\talert((0-currLeft) <= maxOffset);\r\n");
      out.write("\t\t\tif(!(0-currLeft) <= maxOffset || currLeft < 0) {\r\n");
      out.write("\t\t\t\t$(\"#rightKey\").show(\"slow\");\r\n");
      out.write("\t\t\t\t$(\"#leftKey\").show(\"slow\");\r\n");
      out.write("\t\t\t\tif(!isShow){\r\n");
      out.write("\t\t\t\t\t$(\"#prompt_div\").show(\"slow\", function(){window.setTimeout(function(){$(\"#prompt_div\").hide(\"slow\")}, 10000);isShow = true;});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$(\"#rightKey\").hide();\r\n");
      out.write("\t\t\t\t$(\"#leftKey\").hide();\r\n");
      out.write("\t\t\t\t$(\"#prompt_div\").hide();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar isShow = false;\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\twindow.onresize = checkDirectionKey;\r\n");
      out.write("\t\t\t$(\"#rightKey\").hide();\r\n");
      out.write("\t\t\t$(\"#leftKey\").hide();\r\n");
      out.write("\t\t\t$(\"#prompt_div\").hide();\r\n");
      out.write("\t\t\tcheckDirectionKey();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction logout(){\r\n");
      out.write("\t\t\treturn formSubmit(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/logout\", \"_top\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction toModule(moduleName){\r\n");
      out.write("\t\t\ttop.leftFrame.location.href = 'homeAction_toleft.action?moduleName=' + moduleName;\r\n");
      out.write("\t\t\ttop.main.location.href = 'homeAction_tomain.action?moduleName=' + moduleName;\r\n");
      out.write("\t\t\tlinkHighlightMenu(this);\r\n");
      out.write("\t\t}\r\n");
      out.write("</script>\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body onSelectStart=\"return true\"><!-- 文档主题部分开始 -->\r\n");
      out.write("\r\n");
      out.write("<div class=\"PositionFrame_black\" id=\"PositionFrame\"></div>\r\n");
      out.write("\t<div id=\"userInfo\" style=\"z-index:999;\" onclick=\"HideLoginDiv()\" title=\"点击关闭\">\r\n");
      out.write("\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/images/title/avataronline.gif\" border=\"0\" style=\"margin-top:-1px;\"/>\r\n");
      out.write("\t\t您好：<strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_CURRENT_USER.userInfo.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</strong>&nbsp;&nbsp;|\r\n");
      out.write("\t\t您所属单位：\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/images/title/close.gif\" border=\"0\" />\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<a id=\"memos\"  style=\"cursor:pointer;\" onclick=\"toModule('home');\" target=\"_top\" title=\"点击切换到系统首页\"><div id=\"memo\" class=\"memo\" title=\"点击切换到系统首页\"></div></a>\r\n");
      out.write("\t<a id=\"logins\" style=\"cursor:pointer;\" onclick=\"doLoginDiv();\" title=\"点击显示您的登录信息\"><div id=\"small_login\" class=\"small_login\" title=\"点击显示您的登录信息\"></div></a>\r\n");
      out.write("\t<a id=\"logout\" style=\"cursor:pointer;\" onclick=\"logout();\" target=\"_top\" title=\"点击退出系统\"><div id=\"small_login_out\" class=\"small_login_out\" title=\"点击退出系统\"></div></a>\r\n");
      out.write("\r\n");
      out.write("<div class=\"headerBg\">\r\n");
      out.write("\t<div class=\"top_logo\">\r\n");
      out.write("\t    <div class=\"navMenu\"  style=\"float:left;text-align:left;\">\r\n");
      out.write("\t    \t\t<div class=\"titleDate\" style=\"float:left;\">");
      if (_jspx_meth_fmt_005fformatDate_005f0(_jspx_page_context))
        return;
      out.write(" </div>\r\n");
      out.write("\t    \t\t<div style=\"height:29px;\">\r\n");
      out.write("\t\t    \t\t<span id=\"leftKey\"  onmouseover=\"periodOffset(this, 'left')\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/images/title/left_arrow.png\"/></span>\r\n");
      out.write("\t\t\t    \t<div class=\"mavMeau_top\"></div>\r\n");
      out.write("\t\t\t    \t<div id=\"mask\">\r\n");
      out.write("<div id=\"menuContent\">\r\n");
      out.write("\t <span id=\"topmenu\" onclick=\"toModule('home');\">系统首页</span><span id=\"tm_separator\"></span>\r\n");
      out.write("\t<span id=\"topmenu\" onclick=\"toModule('cargo');\">货运管理</span><span id=\"tm_separator\"></span>\r\n");
      out.write("\t<span id=\"topmenu\" onclick=\"toModule('stat');\">统计分析</span><span id=\"tm_separator\"></span>\r\n");
      out.write("\t<span id=\"topmenu\" onclick=\"toModule('baseinfo');\">基础信息</span><span id=\"tm_separator\"></span>\r\n");
      out.write("\t<span id=\"topmenu\" onclick=\"toModule('sysadmin');\">系统管理</span> \r\n");
      out.write("\t \r\n");
      out.write("\t \r\n");
      out.write("\t <!-- 当jsp页面碰到shiro标签时就执行AuthRealm中授权方法 -->\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t<span id=\"rightKey\" onmouseover=\"periodOffset(this, 'right')\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/images/title/right_arrow.png\"/></span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"prompt_div\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/images/title/prompt.png\"/><span style=\"position:absolute;top:2px;left:35px;z-index: 99999;width:100%;color:#FFFFFF;text-align: left; \">鼠标指向箭头位置<br/>可显示更多菜单项</span></div>\r\n");
      out.write("\r\n");
      out.write("<form name=\"form1\" style=\"display: none;\"></form>\t");
//备忘录等使用
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/pages/home/title.jsp(197,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty _CURRENT_USER.dept}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t<strong>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_CURRENT_USER.dept.deptName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</strong>&nbsp;&nbsp;\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatDate_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_005fformatDate_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_005fformatDate_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatDate_005f0.setParent(null);
    // /WEB-INF/pages/home/title.jsp(211,50) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${now}", java.util.Date.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/pages/home/title.jsp(211,50) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setPattern("yyyy年M月d日 E");
    int _jspx_eval_fmt_005fformatDate_005f0 = _jspx_th_fmt_005fformatDate_005f0.doStartTag();
    if (_jspx_th_fmt_005fformatDate_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
    return false;
  }
}
