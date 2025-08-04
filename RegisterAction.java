package com.example;

import java.sql.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

public class RegisterAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response) {

        RegisterForm rf = (RegisterForm) form;

        try {	
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users (username, password, email, role, city, pincode, dob, age) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
      
            ps.setString(1, rf.getUsername());
            ps.setString(2, rf.getPassword());
            ps.setString(3, rf.getEmail());
            ps.setString(4, rf.getRole());
            ps.setString(5, rf.getCity());
            ps.setString(6, rf.getPincode());
            ps.setString(7, rf.getDob());
            ps.setInt(8, rf.getAge());
            int result=ps.executeUpdate();

            ps.close();
            conn.close();
            
            if (result > 0) {
                return mapping.findForward("success"); // Goes to registrationSuccess.jsp
            } else {
                return mapping.findForward("failure"); // Goes to registrationFailure.jsp
            }
        } catch (Exception e) {
            e.printStackTrace();
            return mapping.findForward("failure");
        }

        
    }
}
