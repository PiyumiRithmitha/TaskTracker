package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import app.classes.User;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class dashboard_005fuser_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    String email = (String) session.getAttribute("userEmail");
    String name = (String) session.getAttribute("user_name");
    if (email == null) {
        response.sendRedirect("index.jsp");
        return; // Exit if email is not found
    }

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"app.css/dashboard_user.css\">\r\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("        <title>User Dashboard</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"wrapper\">\r\n");
      out.write("            <div class=\"sideBar\" id=\"sidebar\">\r\n");
      out.write("                <div class=\"profile\">\r\n");
      out.write("                    <img src=\"images/panellogo.png\" alt=\"Logo\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <ul class=\"navLinks\">\r\n");
      out.write("                    <li><a href=\"#\" onclick=\"showSection('home')\" class=\"active\">Dashboard</a></li>\r\n");
      out.write("                    <li><a href=\"#\" onclick=\"showSection('ProjectDetails')\">Project Details</a></li>\r\n");
      out.write("                    <li><a href=\"#\" onclick=\"showSection('manageAccount')\">Manage Account</a></li>\r\n");
      out.write("                    <li><a href=\"index.jsp\"><i class=\"bi bi-box-arrow-left\"></i>&nbsp;&nbsp;&nbsp;Log out</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"mainContainer\">\r\n");
      out.write("                <nav class=\"topNavBar\">\r\n");
      out.write("                    <button class=\"hamburger\" onclick=\"toggleSidebar()\">\r\n");
      out.write("                        <i class=\"bi bi-list\"></i>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <h1>Dashboard</h1>\r\n");
      out.write("                    <h1>");
out.print(name);
      out.write("</h1>\r\n");
      out.write("                </nav>\r\n");
      out.write("                <header>\r\n");
      out.write("                    <img src=\"images/dashboard image bar.png\" class=\"img-fluid\" width=\"1550px\" alt=\"Dashboard Image\">\r\n");
      out.write("                </header>\r\n");
      out.write("\r\n");
      out.write("                <!--Dashboard -->\r\n");
      out.write("                <div class=\"content active\" id=\"home\">\r\n");
      out.write("                    <div class=\"card\">  \r\n");
      out.write("                        <div class=\"user-dashboard\">\r\n");
      out.write("                            <h3><i class=\"bi bi-bell-fill fs-3\"></i>&nbsp;&nbsp;Notification</h3>\r\n");
      out.write("                            ");

                                String message;
                                if (request.getParameter("k") != null) {

                                    if (request.getParameter("k").equals("1")) {
                                        message = "<p class='text-success'>you have successfully selected project</p>";
                                        out.print(message);
                                    } else {
                                        message = "<p class='text-danger'>The project is already Selected</p>";
                                        out.print(message);
                                    }

                                } else {

                                }


                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <hr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            ");
                                // Database connection settings
                                String dbURL = "jdbc:mysql://localhost:3306/task_tracker";
                                String dbUser = "task";
                                String dbPassword = "task";

                                Connection conn = null;
                                PreparedStatement pstmt = null;
                                ResultSet rs = null;

                                try {
                                    // Connect to the database
                                    Class.forName("com.mysql.jdbc.Driver");
                                    conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);

                                    // Prepare the SQL query to retrieve all property details
                                    String sql = "SELECT * FROM project";
                                    pstmt = conn.prepareStatement(sql);

                                    // Execute the query
                                    rs = pstmt.executeQuery();
                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"container\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("                                    ");

                                        // Iterate over the result set and display property details
                                        while (rs.next()) {
                                            String p_id = rs.getString("project_id"); // Get the property ID
                                            String p_name = rs.getString("project_name"); // Get the property ID
                                            String p_des = rs.getString("project_des");
                                            String p_startDate = rs.getString("start_date");
                                            String p_dueDate = rs.getString("due_date");
                                            int isStarted = rs.getInt("isStarted");

                                            // Get the number instance for the default locale
                                            //                                            NumberFormat numberFormatter = NumberFormat.getNumberInstance();
                                            // Format the price
                                            //                                            String formattedPrice = numberFormatter.format(price);
                                            // Add other relevant fields as needed
                                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"col-4 mt-5 box\">\r\n");
      out.write("                                        <div class=\"user-boxes\">\r\n");
      out.write("                                            <div class=\"user-box\">\r\n");
      out.write("                                                <h5>Project :");
out.print(p_name);
      out.write("</h5>\r\n");
      out.write("                                                <h5>Description :</h5>\r\n");
      out.write("                                                <p>");
out.print(p_des);
      out.write("\r\n");
      out.write("                                                </p>\r\n");
      out.write("                                                <form action='startProject.jsp' method='POST'>\r\n");
      out.write("                                                    <input name='projectID' value='");
      out.print( p_id);
      out.write("' hidden/>\r\n");
      out.write("                                                    ");

                                                        if (isStarted == 1) {
                                                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                                    <span>STARTED</span>\r\n");
      out.write("\r\n");
      out.write("                                                    ");

                                                    } else {
      out.write("\r\n");
      out.write("                                                    <button type=\"submit\" class=\"btn btn-primary\">Select</button>\r\n");
      out.write("                                                    ");

                                                        }
                                                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                                </form>\r\n");
      out.write("                                            </div>  \r\n");
      out.write("                                        </div>         \r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    ");
    } //end whileloop
                                            out.print("</div>");
                                            out.print("</div>");
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    
      out.write("\r\n");
      out.write("                                </div>           \r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <!--project details-->\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"content active\" id=\"ProjectDetails\">\r\n");
      out.write("                            <div class=\"card\">\r\n");
      out.write("\r\n");
      out.write("                                <table class=\"table\">\r\n");
      out.write("                                    <thead>\r\n");
      out.write("                                        <tr>\r\n");
      out.write("\r\n");
      out.write("                                            <th>Project</th>\r\n");
      out.write("                                            <th>Date started</th>\r\n");
      out.write("                                            <th>Due date</th>\r\n");
      out.write("                                            <th>Status</th>\r\n");
      out.write("                                            <th>Submit your file</th>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                    </thead>\r\n");
      out.write("                                    <tbody>\r\n");
      out.write("                                        ");

                                            try {
                                                // Connect to the database
                                                Class.forName("com.mysql.jdbc.Driver");
                                                conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);

                                                // Prepare the SQL query to retrieve all property details
                                                String sql = "SELECT * FROM project INNER JOIN startproject ON project.project_id = startproject.projectId";
                                                pstmt = conn.prepareStatement(sql);

                                                // Execute the query
                                                rs = pstmt.executeQuery();
                                                while (rs.next()) {
                                                    String p_id = rs.getString("project_id"); // Get the property ID
                                                    String p_name = rs.getString("project_name"); // Get the property ID
                                                    String p_des = rs.getString("project_des");
                                                    String p_startDate = rs.getString("start_date");
                                                    String p_dueDate = rs.getString("due_date");
                                                    String status = rs.getString("status");
                                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                        <tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                            <td style=\"width: 600px\"> <p>");
out.print(p_des);
      out.write("</p></td>\r\n");
      out.write("                                            <td>");
out.print(p_startDate);
      out.write("</td>\r\n");
      out.write("                                            <td>");
out.print(p_dueDate);
      out.write("</td>\r\n");
      out.write("                                            ");

                                                if (status.equals("started")) {
                                            
      out.write("\r\n");
      out.write("                                            <td><span class=\"badge bg-primary\">On-Progress</span></td>\r\n");
      out.write("                                            ");

                                            } else {
                                            
      out.write("\r\n");
      out.write("                                            <td><span class=\"badge bg-success\">Finished</span>\r\n");
      out.write("                                            </td>\r\n");
      out.write("                                            ");

                                                }
                                            
      out.write("\r\n");
      out.write("                                            <td>\r\n");
      out.write("                                                <form action=\"finish.jsp\" method=\"POST\">\r\n");
      out.write("                                                    <input type=\"text\" name=\"p_id\" value=\"");
      out.print(p_id);
      out.write("\" hidden/>\r\n");
      out.write("                                                    <button type=\"submit\" id=\"select\" class=\"btn btn-success\">Submit here</button><a href=\"#\" data-bs-toggle=\"tooltip\" data-bs-placement=\"top\" title=\"submit your file here!\" style=\"text-decoration: none;color: black;\">&nbsp;&nbsp;<i class=\"bi bi-info-circle\"></i>&nbsp;info</a>\r\n");
      out.write("                                                </form>\r\n");
      out.write("                                            </td>\r\n");
      out.write("\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                        ");

                                                } //end while loop
                                            } //end try block
                                            catch (Exception e) {
                                                e.printStackTrace();
                                            }

                                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    </tbody>\r\n");
      out.write("                                </table>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <!--Manage account -->\r\n");
      out.write("                        <div class=\"content active\" id=\"manageAccount\">\r\n");
      out.write("                            <section class=\"manage-account\">\r\n");
      out.write("\r\n");
      out.write("                                ");
                                    String successMessage = (String) session.getAttribute("successMessage");
                                    if (successMessage != null) {
                                
      out.write("\r\n");
      out.write("                                <div class=\"alert alert-success\">\r\n");
      out.write("                                    ");
      out.print( successMessage);
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                                ");

                                        session.removeAttribute("successMessage"); // Clear the message after displaying
                                    }
                                    User userDetails = new User();
                                    userDetails.getUserDetailsByEmail(email); // Fetch user details by email
                                
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                <form class=\"manageaccount-form\" action=\"jsp/Manageaccount.jsp\" method=\"post\">\r\n");
      out.write("                                    <h3 class=\"fw-bold ps-3 mt-4 mb-3\" >Edit Profile</h3>\r\n");
      out.write("                                    <div class=\"container\">\r\n");
      out.write("                                        <div class=\"row g-3\">\r\n");
      out.write("                                            <div class=\"col\">\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" placeholder=\"First name\" aria-label=\"First name\" value=\"");
out.print(name);
      out.write("\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col\">\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" placeholder=\"Last name\" aria-label=\"Last name\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"row g-3 mt-2\">\r\n");
      out.write("                                            <div class=\"col\">\r\n");
      out.write("                                                <input type=\"email\" class=\"form-control\" placeholder=\"email\" aria-label=\"email\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col\">\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" placeholder=\"Contact\" aria-label=\"Contact\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"mt-3\">\r\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-outline-primary activateB\">Cancel</button>\r\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-primary activate\">Update Profile</button>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <h3 class=\"fw-bold ps-3 mt-4 mb-3\" >Update Password</h3>\r\n");
      out.write("                                    <div class=\"container\">\r\n");
      out.write("                                        <div class=\"row g-3\">\r\n");
      out.write("                                            <div class=\"col\">\r\n");
      out.write("                                                <input type=\"password\" class=\"form-control\" placeholder=\"Current Password\" aria-label=\"cpassowrd\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"row g-3 mt-2\">\r\n");
      out.write("                                            <div class=\"col\">\r\n");
      out.write("                                                <input type=\"password\" class=\"form-control\" placeholder=\"New Password\" aria-label=\"newpsw\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col\">\r\n");
      out.write("                                                <input type=\"password\" class=\"form-control\" placeholder=\"New Password Again\" aria-label=\"newpswagain\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"mt-3\">\r\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-outline-primary activateB\">Cancel</button>\r\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-primary activate\">Update Password</button>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </section>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <!-- Additional sections can be added here -->\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script src=\"app.js/dashboard.js\"></script>\r\n");
      out.write("    </body>\r\n");
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
