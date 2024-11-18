<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Task Hub</title>
        <link rel="stylesheet" href="app.css/index.css?v=<%= System.currentTimeMillis()%>"">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div id="header">
            <img src="login_image.png" alt="img" width="500">
        </div>
        <!--Login-->
        <div id="login">
            <form action="login.jsp" method="post">
                <h2>Login</h2>
                <input type="email" name="email" placeholder="Email" required><br><br>
                <input type="password" name="password" placeholder="Password" required><br><br>
                <button type="submit">Login</button><br><br>
                <p>New user? <span data-bs-toggle="modal" data-bs-target="#staticBackdrop">Register here</span></p>
            </form>
            <%
                String id = request.getParameter("id");
                String message = request.getParameter("message");
                if (id != null && message != null) {
                    if (id.equals("101")) {
                        out.println("<h6 style='color:red'>" + message + "</h6>");
                    } else if (id.equals("102")) {
                        out.println("<h6 style='color:green'>" + message + "</h6>");
                    }
                }
            %>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
             aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <!--Registration-->
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">Registration</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div id="bodys">
                            <form action="register.jsp" method="post" onsubmit="return validateForm()">
                                <input type="text" name="first_name" placeholder="First name" required>
                                <input type="text" name="last_name" placeholder="Last name" required>
                                <input type="email" name="email" placeholder="Email" required>
                                <input type="text" name="role" placeholder="User Role" required>
                                <input type="password" id="password" name="password" placeholder="Password" required>
                                <input type="password" id="confirm_password" name="Cpassword" placeholder="Confirm password" required><br><br>
                                <button type="submit" class="btn btn-primary">Register</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script>
            function validateForm() {
                var password = document.getElementById("password").value;
                var confirmPassword = document.getElementById("confirm_password").value;
                if (password !== confirmPassword) {
                    alert("Passwords do not match.");
                    return false;
                }
                return true;
            }
        </script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
