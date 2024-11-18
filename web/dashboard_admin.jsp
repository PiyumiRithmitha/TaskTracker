<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.List"%>
<%@page import="app.classes.User"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="app.classes.DbConnector"%>
<%
    String email = (String) session.getAttribute("userEmail");
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
        <link rel="stylesheet" href="app.css/dashboard_admin.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <title>Admin Dashboard</title>

        <style>
            .modal-content {
                border-radius: 10px;
                box-shadow:rgba(0, 0, 0, 0.35) 0px 5px 15px;
            }

            .modal-header {
                background-color: #ffffff;
                color: #091E47;
                font-size: 40px;
                border-top-left-radius: 10px;
                border-top-right-radius: 10px;
            }

            .modal-title {
                margin-bottom: 20px;
                font-size: 40px;
                font-weight: 700;
                text-align: center;

            }

            .modal-body {
                width: calc(100% - 20px);
                padding: 10px;
                margin-bottom: 10px;
                color: #091e4775 ;
                font-size: 16px;
            }

            #bodys form {
                display: flex;
                flex-direction: column;
                gap: 10px;
            }

            #bodys form input {
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 14px;
            }

            #bodys form input:focus {
                border-color: #091E47;
                box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
                outline: none;
            }
        </style>
    </style>
</head>
<body>

    <div class="wrapper">
        <div class="sideBar" id="sidebar">
            <div class="profile">
                <img src="images/panellogo.png" alt="Logo">
            </div>
            <ul class="navLinks">
                <li><a href="#" onclick="showSection('home')" class="active">Dashboard</a></li>
                <li><a href="#" onclick="showSection('userList')">User List</a></li>
                <li><a href="#" onclick="showSection('report')">Report</a></li>
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
                <h1>Administrator</h1>
            </nav>
            <header>
                <img src="images/dashboard image bar.png" class="img-fluid" width="1550px" alt="Dashboard Image">
            </header>

    <!-- dashboard -->
            <div class="content active" id="home">
                <div class="card">
                    <button id="newProject" class="btn btn-outline-primary"><span data-bs-toggle="modal" data-bs-target="#staticBackdrop">+ Add New Project</span></button>

                    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                         aria-labelledby="staticBackdropLabel" aria-hidden="true">

                        <!--add project-->
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">Add project</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div id="bodys">
                                        <form action="add-project.jsp" method="post" onsubmit="return validateForm()">
                                            <input type="text" name="p_name" placeholder="project name" required>
                                            <textarea name="project_des" placeholder="project description" required ></textarea>
                                            <input type="date" name="start_date" placeholder="start date" required>
                                            <input type="date" name="deu_date" placeholder="due_date" required>
                                            <button type="submit" class="btn btn-primary">Add Project</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>






                    <table class="table">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Project Name</th>
                                <th>Project</th>
                                <th>Date started</th>
                                <th>Due date</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>


                            <%
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
                            %>
                            <tr>
                                <td>#</td>
                                <td><%out.print(p_name);%></td>
                                <td style="width: 600px"> Project <%out.print(p_id);%><p><%out.print(p_des);%></p></td>
                                <td><%out.print(p_startDate);%></td>
                                <td><%out.print(p_dueDate);%></td>

                                <td>

                                    <!--                     //                edit button-->






                                    <a href="delete_project.jsp?p_id=<% out.print(p_id); %>" class="btn btn-danger btn-sm">Delete</a>
                                </td>
                            </tr>
                            <%                                        }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            %>


                        </tbody>
                    </table>
                </div>
            </div>

    <!-- user list -->
            <div class="content" id="userList">
                <div class="card">
                    <%
                        User user = new User();
                        List<User> users = user.getUserList();

                        if (users != null && !users.isEmpty()) {
                    %>
                    <h2>User List</h2>
                    <table class="table">
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Role</th>
                            <th>Action</th>
                        </tr>
                        <%
                            for (User u : users) {
                                String userEmail = u.getEmail(); // Get the user's email
%>
                        <tr>
                            <td><%= u.getFirstName()%></td>
                            <td><%= u.getLastName()%></td>
                            <td><%= u.getEmail()%></td>
                            <td><%= u.getRole()%></td>
                            <td>
                                <form action="deleteUser.jsp" method="post" onsubmit="return confirm('Are you sure you want to delete this user?');">
                                    <input type="hidden" name="email" value="<%= userEmail%>">
                                    <button type="submit" class="btn btn-danger">Delete</button>
                                </form>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                    <%
                    } else {
                    %>
                    <p>No users found.</p>
                    <%
                        }
                    %>
                </div>
            </div>

    <!-- report -->

            <div class="content" id="report">
                <div class="card">
                    <section class="report">
                        <h2>Project Progress</h2>
                        <table>
                            <thead>
                                <tr>
                                    <th>Project Name</th>
                                    <th>Employee Name</th>
                                    <th>Status</th>
                                    
                                </tr>
                            </thead>



                            <%
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
                            %>







                            <tbody>
                                <tr>
                                    <td> <%out.print(p_name);%></td>
                                    <td><%out.print(employee_fname);%><%out.print(" ");%><%out.print(employee_lname);%></td>

                                    <%
                                        if (status.equals("started")) {
                                    %>
                                    <td><span class="badge bg-primary">On-Progress</span></td>
                                    <%
                                    } else {
                                    %>
                                    <td><span class="badge bg-success">Finish</span>
                                    </td>
                                    <%
                                        }
                                    %>



                                    
                                </tr>


                                <%                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                %>
                            </tbody>
                        </table>
                    </section>
                </div>
            </div>

    <!-- manage account -->
            <div class="content" id="manageAccount">
                <section class="manage-account">
                    <%
                        String successMessage = (String) session.getAttribute("successMessage");
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
                    <form class="manageaccount-form" action="manageAccount.jsp?action=updateProfile" method="post">
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
                    <form class="manageaccount-form" action="manageAccount.jsp?action=updatePassword" method="post">
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

    <script src="app.js/dashboard.js"></script>
</body>
</html>
