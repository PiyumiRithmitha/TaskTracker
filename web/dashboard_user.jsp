
<%@page import="app.classes.User"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%! User user = new User();%>
<%
    String email = (String) session.getAttribute("userEmail");
    String name = (String) session.getAttribute("user_name");
    if (email == null) {
        response.sendRedirect("index.jsp");
        return; // Exit if email is not found
    }
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="app.css/dashboard_user.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <title>User Dashboard</title>
    </head>
    <body>
        <div class="wrapper">
            <div class="sideBar" id="sidebar">
                <div class="profile">
                    <img src="images/panellogo.png" alt="Logo">
                </div>
                <ul class="navLinks">
                    <li><a href="#" onclick="showSection('home')" class="active">Dashboard</a></li>
                    <li><a href="#" onclick="showSection('ProjectDetails')">Project Details</a></li>
                    <li><a href="#" onclick="showSection('manageAccount')">Manage Account</a></li>
                    <li><a href="index.jsp"><i class="bi bi-box-arrow-left"></i>&nbsp;&nbsp;&nbsp;Log out</a></li>
                </ul>
            </div>

            <div class="mainContainer">
                <nav class="topNavBar">
                    <button class="hamburger" onclick="toggleSidebar()">
                        <i class="bi bi-list"></i>
                    </button>
                    <h1>Dashboard</h1>
                    <h1><%out.print(name);%></h1>
                </nav>
                <header>
                    <img src="images/dashboard image bar.png" class="img-fluid" width="1550px" alt="Dashboard Image">
                </header>


                <div class="content active" id="home">
                    <div class="card">  
                        <!--Dashboard -->                   
                        <div class="user-dashboard">
                            <h3><i class="bi bi-bell-fill fs-3"></i>&nbsp;&nbsp;Notification</h3>
                            <%
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


                            %>

                            <hr>

                            <%                                // Database connection settings
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
                            %>

                            <div class="container">
                                <div class="row">

                                    <%
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
                                    %>

                                    <div class="col-4 mt-5 box">
                                        <div class="user-boxes">
                                            <div class="user-box">
                                                <h5>Project :<%out.print(p_name);%></h5>
                                                <h5>Description :</h5>
                                                <p><%out.print(p_des);%>
                                                </p>
                                                <form action='startProject.jsp' method='POST'>
                                                    <input name='projectID' value='<%= p_id%>' hidden/>
                                                    <%
                                                        if (isStarted == 1) {
                                                    %>

                                                    <button class="btn btn-danger">ALREADY SELECTED</button>

                                                    <%
                                                    } else {%>
                                                    <button type="submit" class="btn btn-primary">Select</button>
                                                    <%
                                                        }
                                                    %>

                                                </form>
                                            </div>  
                                        </div>         
                                    </div>

                                    <%    } //end whileloop
                                            out.print("</div>");
                                            out.print("</div>");
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    %>
                                </div>           
                            </div>
                        </div>

                        <!--project details-->

                        <div class="content active" id="ProjectDetails">
                            <div class="card">

                                <table class="table">
                                    <thead>
                                        <tr>

                                            <th>Project</th>
                                            <th>Date started</th>
                                            <th>Due date</th>
                                            <th>Status</th>
                                            <th>Submit your file</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
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
                                        %>

                                        <tr>



                                            <td style="width: 600px"> <p><%out.print(p_des);%></p></td>
                                            <td><%out.print(p_startDate);%></td>
                                            <td><%out.print(p_dueDate);%></td>
                                            <%
                                                if (status.equals("started")) {
                                            %>
                                            <td><span class="badge bg-primary">On-Progress</span></td>
                                            <%
                                            } else {
                                            %>
                                            <td><span class="badge bg-success">Finished</span>
                                            </td>
                                            <%
                                                }
                                            %>
                                            <td>
                                                <form action="finish.jsp" method="POST">
                                                    <input type="text" name="p_id" value="<%=p_id%>" hidden/>
                                                    <button type="submit" id="select" class="btn btn-success">Submit here</button><a href="#" data-bs-toggle="tooltip" data-bs-placement="top" title="submit your file here!" style="text-decoration: none;color: black;">&nbsp;&nbsp;<i class="bi bi-info-circle"></i>&nbsp;info</a>
                                                </form>
                                            </td>

                                        </tr>
                                        <%
                                                } //end while loop
                                            } //end try block
                                            catch (Exception e) {
                                                e.printStackTrace();
                                            }

                                        %>


                                    </tbody>
                                </table>
                            </div>
                        </div>


                        <!-- manage account -->
                        <div class="content" id="manageAccount">
                            <section class="manage-account">
                                <%                        String successMessage = (String) session.getAttribute("successMessage");
                                    if (successMessage != null) {
                                %>
                                <div class="alert alert-success">
                                    <%= successMessage%>
                                </div>
                                <%
                                        session.removeAttribute("successMessage"); // Clear the message after displaying
                                    }

                                    User userDetails = user.getUserDetailsByEmail(email); // Fetch user details by email
                                %>
                                <form class="manageaccount-form" action="manageAccountUser.jsp?action=updateProfile" method="post">
                                    <h3 class="fw-bold ps-3 mt-4 mb-3">Edit Profile</h3>
                                    <div class="container">
                                        <div class="row g-3">
                                            <div class="col">
                                                <input type="text" class="form-control" placeholder="First name" name="firstName" value="<%= userDetails.getFirstName()%>" required>
                                            </div>
                                            <div class="col">
                                                <input type="text" class="form-control" placeholder="Last name" name="lastName" value="<%= userDetails.getLastName()%>" required>
                                            </div>
                                        </div>
                                        <div class="row g-3 mt-2">
                                            <div class="col">
                                                <input type="email" class="form-control" placeholder="Email" name="email" value="<%= userDetails.getEmail()%>" required readonly>
                                            </div>
                                        </div>
                                        <div class="mt-3">
                                            <button type="reset" class="btn btn-outline-primary activateB">Cancel</button>
                                            <button type="submit" class="btn btn-primary activate">Update Profile</button>
                                        </div>
                                    </div>
                                </form>
                                <form class="manageaccount-form" action="manageAccountUser.jsp?action=updatePassword" method="post">
                                    <h3 class="fw-bold ps-3 mt-4 mb-3">Update Password</h3>
                                    <div class="container">
                                        <div class="row g-3">
                                            <div class="col">
                                                <input type="password" class="form-control" placeholder="Current Password" name="currentPassword" required>
                                            </div>
                                        </div>
                                        <div class="row g-3 mt-2">
                                            <div class="col">
                                                <input type="password" class="form-control" placeholder="New Password" name="newPassword" required>
                                            </div>
                                            <div class="col">
                                                <input type="password" class="form-control" placeholder="New Password Again" name="newPasswordAgain" required>
                                            </div>
                                        </div>
                                        <div class="mt-3">
                                            <button type="button" class="btn btn-outline-primary activateB">Cancel</button>
                                            <button type="submit" class="btn btn-primary activate">Update Password</button>
                                        </div>
                                    </div>
                                </form>
                            </section>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <script src="app.js/dashboard.js"></script>
    </body>
</html>
