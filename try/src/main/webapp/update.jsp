<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f2f5;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        text-align: center;
    }
    .update-button {
        margin: 10px;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        background-color: #1877f2;
        color: #fff;
        font-size: 16px;
        cursor: pointer;
        text-decoration: none;
    }
    .update-button:hover {
        background-color: #0e5a9c;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>What would you like to update?</h2>
        
        <form>
             <a href="up_name.jsp" class="update-button">Update Name</a>
             <a href="up_password.jsp" class="update-button">Update Password</a>
        </form>
    </div>
</body>
</html>
