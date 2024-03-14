<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Name</title>
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
    h2 {
        margin-bottom: 20px;
        color: #1877f2;
    }
    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }
    .update-button {
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
    .update-button:hover {
        background-color: #0e5a9c;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Update Name</h2>
        <form action="update_servlet1" method="post">
            <input type="text" name="newName" placeholder="Enter New Name" required>
            <button type="submit" class="update-button" name="update" value="name">Update</button>
        </form>
    </div>
</body>
</html>
