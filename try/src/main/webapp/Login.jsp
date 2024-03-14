<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
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
        }
        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #1877f2;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #1877f2;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0e5a9c;
        }
        .forgot-password, .register-link {
            text-align: center;
            margin-top: 10px;
        }
        .forgot-password a, .register-link a {
            color: #1877f2;
            text-decoration: none;
        }
        .register-link a {
            display: block;
            margin-top: 20px;
        }
    </style> 
</head>
<body>
    <div class="container">
        <h2>Login to Facebook</h2>
        
        <form action="login_servlet" method="post">
            <label for="name">Email or Phone</label>
            <input type="text" id="name" name="name" required>
            
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
            
            <button type="submit">Log In</button>
            
            <div class="forgot-password">
                <a href="forgot.jsp">Forgot Password?</a>
            </div>

            <div class="register-link">
                <a href="register.jsp">Register</a>
            </div>
        </form>
    </div>
</body>
</html>
