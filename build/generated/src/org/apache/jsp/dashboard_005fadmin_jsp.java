package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import app.classes.User;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import app.classes.DbConnector;

public final class dashboard_005fadmin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    String email = (String) session.getAttribute("userEmail");
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
      out.write("        <link rel=\"stylesheet\" href=\"app.css/dashboard_admin.css\">\r\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("        <title>Admin Dashboard</title>\r\n");
      out.write("\r\n");
      out.write("        <style>\r\n");
      out.write("            .modal-content {\r\n");
      out.write("                border-radius: 10px;\r\n");
      out.write("                box-shadow:rgba(0, 0, 0, 0.35) 0px 5px 15px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .modal-header {\r\n");
      out.write("                background-color: #ffffff;\r\n");
      out.write("                color: #091E47;\r\n");
      out.write("                font-size: 40px;\r\n");
      out.write("                border-top-left-radius: 10px;\r\n");
      out.write("                border-top-right-radius: 10px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .modal-title {\r\n");
      out.write("                margin-bottom: 20px;\r\n");
      out.write("                font-size: 40px;\r\n");
      out.write("                font-weight: 700;\r\n");
      out.write("                text-align: center;\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .modal-body {\r\n");
      out.write("                width: calc(100% - 20px);\r\n");
      out.write("                padding: 10px;\r\n");
      out.write("                margin-bottom: 10px;\r\n");
      out.write("                color: #091e4775 ;\r\n");
      out.write("                font-size: 16px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            #bodys form {\r\n");
      out.write("                display: flex;\r\n");
      out.write("                flex-direction: column;\r\n");
      out.write("                gap: 10px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            #bodys form input {\r\n");
      out.write("                padding: 10px;\r\n");
      out.write("                border: 1px solid #ccc;\r\n");
      out.write("                border-radius: 5px;\r\n");
      out.write("                font-size: 14px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            #bodys form input:focus {\r\n");
      out.write("                border-color: #091E47;\r\n");
      out.write("                box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);\r\n");
      out.write("                outline: none;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"wrapper\">\r\n");
      out.write("        <div class=\"sideBar\" id=\"sidebar\">\r\n");
      out.write("            <div class=\"profile\">\r\n");
      out.write("                <img src=\"images/panellogo.png\" alt=\"Logo\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <ul class=\"navLinks\">\r\n");
      out.write("                <li><a href=\"#\" onclick=\"showSection('home')\" class=\"active\">Dashboard</a></li>\r\n");
      out.write("                <li><a href=\"#\" onclick=\"showSection('userList')\">User List</a></li>\r\n");
      out.write("                <li><a href=\"#\" onclick=\"showSection('report')\">Report</a></li>\r\n");
      out.write("                <li><a href=\"#\" onclick=\"showSection('manageAccount')\">Manage Account</a></li>\r\n");
      out.write("                <li><a href=\"index.jsp\"><i class=\"bi bi-box-arrow-left\"></i>&nbsp;&nbsp;&nbsp;Log out</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"mainContainer\">\r\n");
      out.write("            <nav class=\"topNavBar\">\r\n");
      out.write("                <button class=\"hamburger\" onclick=\"toggleSidebar()\">\r\n");
      out.write("                    <i class=\"bi bi-list\"></i>\r\n");
      out.write("                </button>\r\n");
      out.write("                <h1>Dashboard</h1>\r\n");
      out.write("                <h1>Administrator</h1>\r\n");
      out.write("            </nav>\r\n");
      out.write("            <header>\r\n");
      out.write("                <img src=\"images/dashboard image bar.png\" class=\"img-fluid\" width=\"1550px\" alt=\"Dashboard Image\">\r\n");
      out.write("            </header>\r\n");
      out.write("\r\n");
      out.write("    <!-- dashboard -->\r\n");
      out.write("            <div class=\"content active\" id=\"home\">\r\n");
      out.write("                <div class=\"card\">\r\n");
      out.write("                    <button id=\"newProject\" class=\"btn btn-outline-primary\"><span data-bs-toggle=\"modal\" data-bs-target=\"#staticBackdrop\">+ Add New Project</span></button>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"modal fade\" id=\"staticBackdrop\" data-bs-backdrop=\"static\" data-bs-keyboard=\"false\" tabindex=\"-1\"\r\n");
      out.write("                         aria-labelledby=\"staticBackdropLabel\" aria-hidden=\"true\">\r\n");
      out.write("\r\n");
      out.write("                        <!--add project-->\r\n");
      out.write("                        <div class=\"modal-dialog modal-dialog-centered\">\r\n");
      out.write("                            <div class=\"modal-content\">\r\n");
      out.write("                                <div class=\"modal-header\">\r\n");
      out.write("                                    <h5 class=\"modal-title\" id=\"staticBackdropLabel\">Add project</h5>\r\n");
      out.write("                                    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"modal-body\">\r\n");
      out.write("                                    <div id=\"bodys\">\r\n");
      out.write("                                        <form action=\"add-project.jsp\" method=\"post\" onsubmit=\"return validateForm()\">\r\n");
      out.write("                                            <input type=\"text\" name=\"p_name\" placeholder=\"project name\" required>\r\n");
      out.write("                                            <textarea name=\"project_des\" placeholder=\"project description\" required ></textarea>\r\n");
      out.write("                                            <input type=\"date\" name=\"start_date\" placeholder=\"start date\" required>\r\n");
      out.write("                                            <input type=\"date\" name=\"deu_date\" placeholder=\"due_date\" required>\r\n");
      out.write("                                            <button type=\"submit\" class=\"btn btn-primary\">Add Project</button>\r\n");
      out.write("                                        </form>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <table class=\"table\">\r\n");
      out.write("                        <thead>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <th>#</th>\r\n");
      out.write("                                <th>Project Name</th>\r\n");
      out.write("                                <th>Project</th>\r\n");
      out.write("                                <th>Date started</th>\r\n");
      out.write("                                <th>Due date</th>\r\n");
      out.write("                                <th>Action</th>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody>\r\n");
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

                                    // Iterate over the result set and display property details
                                    while (rs.next()) {
                                        String p_id = rs.getString("project_id"); // Get the property ID
                                        String p_name = rs.getString("project_name"); // Get the property ID
                                        String p_des = rs.getString("project_des");
                                        String p_startDate = rs.getString("start_date");
                                        String p_dueDate = rs.getString("due_date");
                                        // Get the number instance for the default locale
//                                            NumberFormat numberFormatter = NumberFormat.getNumberInstance();
                                        // Format the price
//                                            String formattedPrice = numberFormatter.format(price);
                                        // Add other relevant fields as needed
                            
      out.write("\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>#</td>\r\n");
      out.write("                                <td>");
out.print(p_name);
      out.write("</td>\r\n");
      out.write("                                <td style=\"width: 600px\"> Project ");
out.print(p_id);
      out.write("<p>");
out.print(p_des);
      out.write("</p></td>\r\n");
      out.write("                                <td>");
out.print(p_startDate);
      out.write("</td>\r\n");
      out.write("                                <td>");
out.print(p_dueDate);
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("                                <td>\r\n");
      out.write("\r\n");
      out.write("                                    <!--                     //                edit button-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    <a href=\"delete_project.jsp?p_id=");
 out.print(p_id); 
      out.write("\" class=\"btn btn-danger btn-sm\">Delete</a>\r\n");
      out.write("                                </td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            ");
                                        }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- user list -->\r\n");
      out.write("            <div class=\"content\" id=\"userList\">\r\n");
      out.write("                <div class=\"card\">\r\n");
      out.write("                    ");

                        User user = new User();
                        List<User> users = user.getUserList();

                        if (users != null && !users.isEmpty()) {
                    
      out.write("\r\n");
      out.write("                    <h2>User List</h2>\r\n");
      out.write("                    <table class=\"table\">\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th>First Name</th>\r\n");
      out.write("                            <th>Last Name</th>\r\n");
      out.write("                            <th>Email</th>\r\n");
      out.write("                            <th>Role</th>\r\n");
      out.write("                            <th>Action</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        ");

                            for (User u : users) {
                                String userEmail = u.getEmail(); // Get the user's email

      out.write("\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>");
      out.print( u.getFirstName());
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( u.getLastName());
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( u.getEmail());
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( u.getRole());
      out.write("</td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <form action=\"deleteUser.jsp\" method=\"post\" onsubmit=\"return confirm('Are you sure you want to delete this user?');\">\r\n");
      out.write("                                    <input type=\"hidden\" name=\"email\" value=\"");
      out.print( userEmail);
      out.write("\">\r\n");
      out.write("                                    <button type=\"submit\" class=\"btn btn-danger\">Delete</button>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        ");

                            }
                        
      out.write("\r\n");
      out.write("                    </table>\r\n");
      out.write("                    ");

                    } else {
                    
      out.write("\r\n");
      out.write("                    <p>No users found.</p>\r\n");
      out.write("                    ");

                        }
                    
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- report -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"content\" id=\"report\">\r\n");
      out.write("                <div class=\"card\">\r\n");
      out.write("                    <section class=\"report\">\r\n");
      out.write("                        <h2>Project Progress</h2>\r\n");
      out.write("                        <table>\r\n");
      out.write("                            <thead>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <th>Project Name</th>\r\n");
      out.write("                                    <th>Employee Name</th>\r\n");
      out.write("                                    <th>Status</th>\r\n");
      out.write("                                    \r\n");
      out.write("                                </tr>\r\n");
      out.write("                            </thead>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            ");

                                try {
                                    // Connect to the database
                                    Class.forName("com.mysql.jdbc.Driver");
                                    conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);

                                    // Prepare the SQL query to retrieve all property details
                                    String sql = "SELECT * FROM project p INNER JOIN startproject sp ON p.project_id = sp.projectId INNER JOIN users u ON sp.userId = u.id;";
                                    pstmt = conn.prepareStatement(sql);

                                    // Execute the query
                                    rs = pstmt.executeQuery();

                                    // Iterate over the result set and display property details
                                    while (rs.next()) {
                                        String p_id = rs.getString("project_id"); // Get the property ID
                                        String p_name = rs.getString("project_name"); // Get the property ID
                                        String p_des = rs.getString("project_des");
                                        String p_startDate = rs.getString("start_date");
                                        String p_dueDate = rs.getString("due_date");
                                        String employee_fname = rs.getString("first_name");
                                        String employee_lname = rs.getString("last_name");
                                        String status = rs.getString("status");
                                        
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <tbody>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td> ");
out.print(p_name);
      out.write("</td>\r\n");
      out.write("                                    <td>");
out.print(employee_fname);
out.print(" ");
out.print(employee_lname);
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("                                    ");

                                        if (status.equals("started")) {
                                    
      out.write("\r\n");
      out.write("                                    <td><span class=\"badge bg-primary\">On-Progress</span></td>\r\n");
      out.write("                                    ");

                                    } else {
                                    
      out.write("\r\n");
      out.write("                                    <td><span class=\"badge bg-success\">Finish</span>\r\n");
      out.write("                                    </td>\r\n");
      out.write("                                    ");

                                        }
                                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    \r\n");
      out.write("                                </tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                ");
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                
      out.write("\r\n");
      out.write("                            </tbody>\r\n");
      out.write("                        </table>\r\n");
      out.write("                    </section>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- manage account -->\r\n");
      out.write("            <div class=\"content\" id=\"manageAccount\">\r\n");
      out.write("                <section class=\"manage-account\">\r\n");
      out.write("                    ");

                        String successMessage = (String) session.getAttribute("successMessage");
                        if (successMessage != null) {
                    
      out.write("\r\n");
      out.write("                    <div class=\"alert alert-success\">\r\n");
      out.write("                        ");
      out.print( successMessage);
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    ");

                            session.removeAttribute("successMessage"); // Clear the message after displaying
                        }

                        User userDetails = user.getUserDetailsByEmail(email); // Fetch user details by email

      out.write("\r\n");
      out.write("                    <form class=\"manageaccount-form\" action=\"manageAccount.jsp?action=updateProfile\" method=\"post\">\r\n");
      out.write("                        <h3 class=\"fw-bold ps-3 mt-4 mb-3\">Edit Profile</h3>\r\n");
      out.write("                        <div class=\"container\">\r\n");
      out.write("                            <div class=\"row g-3\">\r\n");
      out.write("                                <div class=\"col\">\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" placeholder=\"First name\" name=\"firstName\" value=\"");
      out.print( userDetails.getFirstName());
      out.write("\" required>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"col\">\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" placeholder=\"Last name\" name=\"lastName\" value=\"");
      out.print( userDetails.getLastName());
      out.write("\" required>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"row g-3 mt-2\">\r\n");
      out.write("                                <div class=\"col\">\r\n");
      out.write("                                    <input type=\"email\" class=\"form-control\" placeholder=\"Email\" name=\"email\" value=\"");
      out.print( userDetails.getEmail());
      out.write("\" required readonly>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"mt-3\">\r\n");
      out.write("                                <button type=\"reset\" class=\"btn btn-outline-primary activateB\">Cancel</button>\r\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-primary activate\">Update Profile</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                    <form class=\"manageaccount-form\" action=\"manageAccount.jsp?action=updatePassword\" method=\"post\">\r\n");
      out.write("                        <h3 class=\"fw-bold ps-3 mt-4 mb-3\">Update Password</h3>\r\n");
      out.write("                        <div class=\"container\">\r\n");
      out.write("                            <div class=\"row g-3\">\r\n");
      out.write("                                <div class=\"col\">\r\n");
      out.write("                                    <input type=\"password\" class=\"form-control\" placeholder=\"Current Password\" name=\"currentPassword\" required>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"row g-3 mt-2\">\r\n");
      out.write("                                <div class=\"col\">\r\n");
      out.write("                                    <input type=\"password\" class=\"form-control\" placeholder=\"New Password\" name=\"newPassword\" required>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"col\">\r\n");
      out.write("                                    <input type=\"password\" class=\"form-control\" placeholder=\"New Password Again\" name=\"newPasswordAgain\" required>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"mt-3\">\r\n");
      out.write("                                <button type=\"button\" class=\"btn btn-outline-primary activateB\">Cancel</button>\r\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-primary activate\">Update Password</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </section>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"app.js/dashboard.js\"></script>\r\n");
      out.write("</body>\r\n");
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
