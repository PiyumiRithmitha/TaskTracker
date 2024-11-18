package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <title>Task Hub</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"app.css/index.css\">\r\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"header\">\r\n");
      out.write("            <img src=\"login_image.png\" alt=\"img\" width=\"500\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!--Login-->\r\n");
      out.write("        <div id=\"login\">\r\n");
      out.write("            <form action=\"login.jsp\" method=\"post\">\r\n");
      out.write("                <h2>Login</h2>\r\n");
      out.write("                <input type=\"text\" name=\"email\" placeholder=\" Email\" required><br><br>\r\n");
      out.write("                <input type=\"password\" name=\"password\" placeholder=\" password\" required><br><br>\r\n");
      out.write("                <button type=\"submit\">Login</button><br><br>\r\n");
      out.write("                <p>New user? <span data-bs-toggle=\"modal\" data-bs-target=\"#staticBackdrop\">Register here</span></p>\r\n");
      out.write("            </form>\r\n");
      out.write("            ");

                String id = request.getParameter("id");
                String message = request.getParameter("message");
                if (id != null && message != null) {
                    if (id.equals("101")) {
                        out.println("<h6 style='color:red'>" + message + "</h6>");
                    } else if (id.equals("102")) {
                        out.println("<h6 style='color:green'>" + message + "</h6>");
                    }
                }
            
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- Modal -->\r\n");
      out.write("        <div class=\"modal fade\" id=\"staticBackdrop\" data-bs-backdrop=\"static\" data-bs-keyboard=\"false\" tabindex=\"-1\"\r\n");
      out.write("             aria-labelledby=\"staticBackdropLabel\" aria-hidden=\"true\">\r\n");
      out.write("\r\n");
      out.write("            <!--Registration-->\r\n");
      out.write("            <div class=\"modal-dialog modal-dialog-centered\">\r\n");
      out.write("                <div class=\"modal-content\">\r\n");
      out.write("                    <div class=\"modal-header\">\r\n");
      out.write("                        <h5 class=\"modal-title\" id=\"staticBackdropLabel\">Registration</h5>\r\n");
      out.write("                        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-body\">\r\n");
      out.write("                        <div id=\"bodys\">\r\n");
      out.write("                            <form action=\"register.jsp\" method=\"post\" onsubmit=\"return validateForm()\">\r\n");
      out.write("                                <input type=\"text\" name=\"first_name\" placeholder=\"First name\" required>\r\n");
      out.write("                                <input type=\"text\" name=\"last_name\" placeholder=\"Last name\" required>\r\n");
      out.write("                                <input type=\"text\" name=\"email\" placeholder=\"Email\" required>\r\n");
      out.write("                                <input type=\"text\" name=\"role\" placeholder=\"User Role\" required>\r\n");
      out.write("                                <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"Password\" required>\r\n");
      out.write("                                <input type=\"password\" id=\"confirm_password\" name=\"Cpassword\" placeholder=\"Confirm password\" required><br><br>\r\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-primary\">Register</button>\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("            function validateForm() {\r\n");
      out.write("                var password = document.getElementById(\"password\").value;\r\n");
      out.write("                var confirmPassword = document.getElementById(\"confirm_password\").value;\r\n");
      out.write("                if (password !== confirmPassword) {\r\n");
      out.write("                    alert(\"Passwords do not match.\");\r\n");
      out.write("                    return false;\r\n");
      out.write("                }\r\n");
      out.write("                return true;\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
