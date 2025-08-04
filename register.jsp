<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration Form</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .form-container {
            width: 400px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 2px 2px 12px #aaa;
        }
        h2 { text-align: center; }
        table { width: 100%; }
        td { padding: 10px; vertical-align: middle; }
        input[type="text"],
        input[type="password"],
        input[type="email"],
        input[type="date"],
        input[type="number"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        .btn {
            display: block;
            margin: 0 auto;
            padding: 8px 16px;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>User Registration Form</h2>

    <!-- Success message -->
    <logic:present name="successMsg">
        <div style="color: blue ;"><bean:write name="successMsg" /></div>
    </logic:present>

    <!-- Error message -->
    <logic:present name="errorMsg">
        <div style="color: red;"><bean:write name="errorMsg" /></div>
    </logic:present>

    <!-- 🔧 Correct Struts Form tag -->
    <html:form action="/register" method="post">
        <table>
            <tr>
                <td>UserName:</td>
                <td><html:text property="username" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><html:password property="password" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><html:text property="email" /></td>
            </tr>
            <tr>
                <td>Role:</td>
                <td><html:text property="role" /></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><html:text property="city" /></td>
            </tr>
            <tr>
                <td>PinCode:</td>
                <td><html:text property="pincode" /></td>
            </tr>
            <tr>
                <td>Date of Birth:</td>
                <td><html:text property="dob" /></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><html:text property="age" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <html:submit styleClass="btn" value="Register" />
                </td>
            </tr>
        </table>
    </html:form>
</div>

</body>
</html>
