/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.2.1.v20140609
 * Generated at: 2016-09-28 13:03:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(21);
    _jspx_dependants.put("jar:file:/home/ideas2it/.m2/repository/org/springframework/security/spring-security-taglibs/3.2.5.RELEASE/spring-security-taglibs-3.2.5.RELEASE.jar!/META-INF/security.tld", Long.valueOf(1408081174000L));
    _jspx_dependants.put("file:/home/ideas2it/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar", Long.valueOf(1474097707000L));
    _jspx_dependants.put("jar:file:/home/ideas2it/.m2/repository/org/springmodules/spring-modules-validation/0.8/spring-modules-validation-0.8.jar!/META-INF/spring-commons-validator.tld", Long.valueOf(1173608916000L));
    _jspx_dependants.put("jar:file:/home/ideas2it/.m2/repository/displaytag/displaytag/1.2/displaytag-1.2.jar!/META-INF/displaytag.tld", Long.valueOf(1230369346000L));
    _jspx_dependants.put("jar:file:/home/ideas2it/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar!/META-INF/fn.tld", Long.valueOf(1153365282000L));
    _jspx_dependants.put("/WEB-INF/appfuse.tld", Long.valueOf(1474527625000L));
    _jspx_dependants.put("jar:file:/home/ideas2it/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153365282000L));
    _jspx_dependants.put("jar:file:/home/ideas2it/.m2/repository/opensymphony/sitemesh/2.4.2/sitemesh-2.4.2.jar!/META-INF/sitemesh-page.tld", Long.valueOf(1084602314000L));
    _jspx_dependants.put("/common/taglibs.jsp", Long.valueOf(1474878930000L));
    _jspx_dependants.put("jar:file:/home/ideas2it/.m2/repository/struts-menu/struts-menu/2.4.3/struts-menu-2.4.3.jar!/META-INF/struts-menu-el.tld", Long.valueOf(1180679192000L));
    _jspx_dependants.put("file:/home/ideas2it/.m2/repository/struts-menu/struts-menu/2.4.3/struts-menu-2.4.3.jar", Long.valueOf(1474097706000L));
    _jspx_dependants.put("jar:file:/home/ideas2it/.m2/repository/opensymphony/sitemesh/2.4.2/sitemesh-2.4.2.jar!/META-INF/sitemesh-decorator.tld", Long.valueOf(1123658492000L));
    _jspx_dependants.put("file:/home/ideas2it/.m2/repository/displaytag/displaytag/1.2/displaytag-1.2.jar", Long.valueOf(1474097675000L));
    _jspx_dependants.put("jar:file:/home/ideas2it/.m2/repository/org/springframework/spring-webmvc/4.1.3.RELEASE/spring-webmvc-4.1.3.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1418070746000L));
    _jspx_dependants.put("file:/home/ideas2it/.m2/repository/org/springmodules/spring-modules-validation/0.8/spring-modules-validation-0.8.jar", Long.valueOf(1474097677000L));
    _jspx_dependants.put("file:/home/ideas2it/.m2/repository/org/springframework/spring-webmvc/4.1.3.RELEASE/spring-webmvc-4.1.3.RELEASE.jar", Long.valueOf(1474097714000L));
    _jspx_dependants.put("file:/home/ideas2it/.m2/repository/opensymphony/sitemesh/2.4.2/sitemesh-2.4.2.jar", Long.valueOf(1474097711000L));
    _jspx_dependants.put("jar:file:/home/ideas2it/.m2/repository/org/springframework/spring-webmvc/4.1.3.RELEASE/spring-webmvc-4.1.3.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1418070746000L));
    _jspx_dependants.put("jar:file:/home/ideas2it/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar!/META-INF/sql.tld", Long.valueOf(1153365282000L));
    _jspx_dependants.put("file:/home/ideas2it/.m2/repository/org/springframework/security/spring-security-taglibs/3.2.5.RELEASE/spring-security-taglibs-3.2.5.RELEASE.jar", Long.valueOf(1474097711000L));
    _jspx_dependants.put("jar:file:/home/ideas2it/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153365282000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.release();
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"/error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>School Of Rock</title>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta name=\"viewport\"\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n");
      out.write("<link href=\"layout/styles/layout.css\" rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("\tmedia=\"all\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t<!-- ################################################################################################ -->\n");
      out.write("\t<div class=\"wrapper row0\">\n");
      out.write("\t\t<div id=\"topbar\" class=\"clear\">\n");
      out.write("\t\t\t<!-- ################################################################################################ -->\n");
      out.write("\t\t\t<nav>\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\t\t\t\t    <li><a href=\"User.html\">Create Admin</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"displayTeachers.html\">Teachers</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"displayStudents.html\">Students</a>\n");
      out.write("\t\t\t\t\t<li><a href=\"Standard.html\">Standards</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"Subject.html\">Subjects</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"TimeTable.html\">Time Table</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"logout.html\">Logout</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</nav>\n");
      out.write("\t\t\t<!-- ################################################################################################ -->\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- ################################################################################################ -->\n");
      out.write("\t<div class=\"wrapper row1\">\n");
      out.write("\t\t<header id=\"header\" class=\"clear\">\n");
      out.write("\t\t\t<!-- ################################################################################################ -->\n");
      out.write("\t\t\t<div id=\"logo\" class=\"fl_left\">\n");
      out.write("\t\t\t\t<h1>\n");
      out.write("\t\t\t\t\t<a href=\"index.jsp\">School Of Rock</a>\n");
      out.write("\t\t\t\t</h1>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<!-- ################################################################################################ -->\n");
      out.write("\t\t</header>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- ################################################################################################ -->\n");
      out.write("\t<div class=\"wrapper\">\n");
      out.write("\t\t<div id=\"slider\">\n");
      out.write("\t\t\t<div id=\"slide-wrapper\" class=\"rounded clear\">\n");
      out.write("\t\t\t\t<!-- ################################################################################################ -->\n");
      out.write("\t\t\t\t<figure id=\"slide-1\">\n");
      out.write("\t\t\t\t\t<a class=\"view\" href=\"#\"><img src=\"images/demo/slider/101.jpg\"\n");
      out.write("\t\t\t\t\t\talt=\"\"></a>\n");
      out.write("\t\t\t\t\t<figcaption>\n");
      out.write("\t\t\t\t\t\t<h2>All About The School</h2>\n");
      out.write("\t\t\t\t\t\t<p>Our school was established in the year 1947 in calcutta.\n");
      out.write("\t\t\t\t\t\t\tOver the years it has expanded to over 20 cities all over India.\n");
      out.write("\t\t\t\t\t\t\tWe have top notch quality of faculty</p>\n");
      out.write("\t\t\t\t\t</figcaption>\n");
      out.write("\t\t\t\t</figure>\n");
      out.write("\t\t\t\t<figure id=\"slide-2\">\n");
      out.write("\t\t\t\t\t<a class=\"view\" href=\"#\"><img\n");
      out.write("\t\t\t\t\t\tsrc=\"images/demo/slider/teachers.jpg\" alt=\"\"></a>\n");
      out.write("\t\t\t\t\t<figcaption>\n");
      out.write("\t\t\t\t\t\t<h2>Why you should study with us</h2>\n");
      out.write("\t\t\t\t\t\t<p>Our school is one of the most prestigious educational\n");
      out.write("\t\t\t\t\t\t\tinstitute in the country. We have over 500 students. We provide\n");
      out.write("\t\t\t\t\t\t\tthe best state of the art education.</p>\n");
      out.write("\t\t\t\t\t</figcaption>\n");
      out.write("\t\t\t\t</figure>\n");
      out.write("\t\t\t\t<figure id=\"slide-3\">\n");
      out.write("\t\t\t\t\t<a class=\"view\" href=\"#\"><img src=\"images/demo/slider/999.jpg\"\n");
      out.write("\t\t\t\t\t\talt=\"\"></a>\n");
      out.write("\t\t\t\t\t<figcaption>\n");
      out.write("\t\t\t\t\t\t<h2>Education And Student Experience</h2>\n");
      out.write("\t\t\t\t\t\t<p>We provide all around education that focuses not only on\n");
      out.write("\t\t\t\t\t\t\tacademics but overall development of the student. We do not\n");
      out.write("\t\t\t\t\t\t\tbelieve in producing only Einsteins and Newtons but also Picassos\n");
      out.write("\t\t\t\t\t\t\tand DaVincis</p>\n");
      out.write("\t\t\t\t\t</figcaption>\n");
      out.write("\t\t\t\t</figure>\n");
      out.write("\t\t\t\t<figure id=\"slide-4\">\n");
      out.write("\t\t\t\t\t<a class=\"view\" href=\"#\"><img\n");
      out.write("\t\t\t\t\t\tsrc=\"images/demo/slider/index.jpg\" alt=\"\"></a>\n");
      out.write("\t\t\t\t\t<figcaption>\n");
      out.write("\t\t\t\t\t\t<h2>Our Teachers</h2>\n");
      out.write("\t\t\t\t\t\t<p>The school alumni is always present at our beck and call.\n");
      out.write("\t\t\t\t\t\t\tWe have donors from all over the world with donations crossing\n");
      out.write("\t\t\t\t\t\t\tover billions of dollars.</p>\n");
      out.write("\t\t\t\t\t</figcaption>\n");
      out.write("\t\t\t\t</figure>\n");
      out.write("\t\t\t\t<figure id=\"slide-5\">\n");
      out.write("\t\t\t\t\t<a class=\"view\" href=\"#\"><img src=\"images/demo/slider/cu11.jpg\"\n");
      out.write("\t\t\t\t\t\talt=\"\"></a>\n");
      out.write("\t\t\t\t\t<figcaption>\n");
      out.write("\t\t\t\t\t\t<h2>Our Coordinates</h2>\n");
      out.write("\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\tAddress: School Of Rock<br>No.220, Harington Road, Chennai,\n");
      out.write("\t\t\t\t\t\t\tTamilnadu, India\n");
      out.write("\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t<p>Contact No:044-26218190</p>\n");
      out.write("\t\t\t\t\t\t<p>E-mail:schoolofrock@gmail.com</p>\n");
      out.write("\t\t\t\t\t</figcaption>\n");
      out.write("\t\t\t\t</figure>\n");
      out.write("\t\t\t\t<!-- ################################################################################################ -->\n");
      out.write("\t\t\t\t<ul id=\"slide-tabs\">\n");
      out.write("\t\t\t\t\t<li><a href=\"#slide-1\">All About The School</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"#slide-2\">Why You Should Study With Us</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"#slide-3\">Education And Student Experience</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"#slide-4\">Alumni And Its Donors</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"#slide-5\">Contact Us</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t\t<!-- ################################################################################################ -->\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- ################################################################################################ -->\n");
      out.write("\n");
      out.write("\t<!-- JAVASCRIPTS -->\n");
      out.write("\t<script src=\"layout/scripts/jquery.min.js\"></script>\n");
      out.write("\t<script src=\"layout/scripts/jquery.fitvids.min.js\"></script>\n");
      out.write("\t<script src=\"layout/scripts/jquery.mobilemenu.js\"></script>\n");
      out.write("\t<script src=\"layout/scripts/tabslet/jquery.tabslet.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /common/taglibs.jsp(19,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false deferredMethod = false expectedTypeName = null methodSignature = null 
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /common/taglibs.jsp(19,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true deferredMethod = false expectedTypeName = java.lang.Object methodSignature = null 
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/common/taglibs.jsp(19,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent(null);
    // /common/taglibs.jsp(20,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false deferredMethod = false expectedTypeName = null methodSignature = null 
    _jspx_th_c_005fset_005f1.setVar("datePattern");
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_eval_c_005fset_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_c_005fset_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_c_005fset_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_c_005fset_005f1.doInitBody();
      }
      do {
        if (_jspx_meth_fmt_005fmessage_005f0(_jspx_th_c_005fset_005f1, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_c_005fset_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_c_005fset_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fset_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fset_005f1);
    // /common/taglibs.jsp(20,25) name = key type = null reqTime = true required = false fragment = false deferredValue = false deferredMethod = false expectedTypeName = null methodSignature = null 
    _jspx_th_fmt_005fmessage_005f0.setKey("date.format");
    int _jspx_eval_fmt_005fmessage_005f0 = _jspx_th_fmt_005fmessage_005f0.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f0);
    return false;
  }
}
