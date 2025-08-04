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
            PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM users WHERE username = ? AND password = ? AND email = ? AND role = ?");

            ps.setString(1, loginForm.getUsername());
            ps.setString(2, loginForm.getPassword());
            ps.setString(3, loginForm.getEmail());
            ps.setString(4, loginForm.getRole());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                isValid = true;
            }

            rs.close();
            ps.close();
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
