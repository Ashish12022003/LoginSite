<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .form-container {
            background-color: #ffffff;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            width: 350px;
        }
        h2 {
            text-align: center;
            margin-bottom: 25px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"], input[type="password"], input[type="email"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .btn-login {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            font-weight: bold;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn-login:hover {
            background-color: #45a049;
        }
        .register-link {
            margin-top: 15px;
            text-align: center;
        }
        .register-link a {
            text-decoration: none;
        }
        .register-link button {
            background-color: #007BFF;
            color: white;
            padding: 8px 16px;
            border: none;
            border-radius: 5px;
            margin-top: 10px;
            cursor: pointer;
        }
        .register-link button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Login</h2>

        <html:form action="/login">
            <label for="username">UserName:</label>
            <html:text property="username" /><br/>

            <label for="password">Password:</label>
            <html:password property="password" /><br/>

            <label for="email">Email:</label>
            <html:text property="email" /><br/>

            <label for="role">Role:</label>
            <html:text property="role" /><br/>

            <html:submit value="Login" styleClass="btn-login"/>

            <div class="register-link">
                Don't have an account?
                <a href="register.jsp">
                    <button type="button">Register</button>
                </a>
            </div>
        </html:form>
    </div>
</body>
</html>
