package com.example;

import java.sql.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

public class LoginAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response) {
        
        LoginForm loginForm = (LoginForm) form;
        boolean isValid = false;

        try {
            Connection conn = DBConnection.getConnection();
            CallableStatement stmt = conn.prepareCall("{CALL check_login(?, ?, ?, ?, ?)}");
            stmt.setString(1, loginForm.getUsername());
            stmt.setString(2, loginForm.getPassword());
            stmt.setString(3, loginForm.getEmail());
            stmt.setString(4, loginForm.getRole());
            stmt.registerOutParameter(5, Types.INTEGER);
            stmt.execute();

            int result = stmt.getInt(5);
            isValid = (result == 1);

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isValid) {
            return mapping.findForward("success");
        } else {
            return mapping.findForward("failure");
        }
    }
}
