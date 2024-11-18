<%-- 
    Document   : loadEmail
    Created on : Aug 8, 2024, 11:20:28 PM
    Author     : sheha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Email Redirect</title>
    <script type="text/javascript">
        // Open the email client on page load
        window.onload = function() {
            window.location.assign("mailto:admin@gmail.com?subject=Your%20Subject%20Here&body=Your%20Message%20Here");
            
            setTimeout(function() {
                window.location.href = "dashboard_user.jsp";
            }, 500);
        }
        
    </script>
</head>
<body>
    
<!--    <p>If your email client didn't open, <a href="mailto:admin@gmail.com?subject=Your%20Subject%20Here&body=Your%20Message%20Here">click here</a>.</p>-->

    
    
</body>
</html>

