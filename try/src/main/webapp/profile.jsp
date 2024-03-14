<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
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
        max-width: 400px;
        padding: 20px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    h1 {
        color: #1877f2;
    }
    p {
        margin-top: 20px;
        font-size: 18px;
    }
    .button {
        margin-top: 20px;
        display: inline-block;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        background-color: #1877f2;
        color: #fff;
        font-size: 16px;
        cursor: pointer;
        text-decoration: none;
    }
    .button:hover {
        background-color: #0e5a9c;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Hello, <%= request.getParameter("name") %>!</h1>
        <p>Welcome to your profile page.</p>
       
        <form action="delete_servlet" method="post">
        <button type="submit" class="button">Delete Account</button>
       
        <a href="update.jsp" class="button">Update Profile</a>
        </form>
        
    </div>
</body>
</html>
