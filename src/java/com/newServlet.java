/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author sheha
 */
@WebServlet(name = "newServlet", urlPatterns = {"/newServlet"})
public class newServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            int aid = Integer.parseInt(request.getParameter("aid"));

                Part part = request.getPart("img");
                String originalFilename = part.getSubmittedFileName();

                // Generate timestamp and random integer, then create new filename
                String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                Random random = new Random();
                int randomInt = random.nextInt(100000000) + 1; // Random integer between 1 and 100,000,000
                String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
                String newFilename = "file_" + timestamp + "_" + randomInt + fileExtension;

//                out.println("Original File Name: " + originalFilename + "<br>");
//                out.println("New File Name: " + newFilename + "<br>");

                // Adjusted path to save in the 'web' directory
                String path = "C:\\Users\\kalin\\OneDrive\\Documents\\NetBeansProjects\\Idamlk\\web\\images\\upload" + File.separator + newFilename;
//                out.println("File Path: " + path + "<br>");

                InputStream is = part.getInputStream();

                boolean success = uploadFile(is, path);
                if (success) {
                    out.println("File uploaded successfully: " + path);
                    out.println("</br>");
                } else {
                    out.println("Error uploading file.");
                }
                
                

                // Database connection settings
                String dbURL = "jdbc:mysql://localhost:3306/real_estate_system";
                String dbUser = "root";
                String dbPassword = "";

                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                
                String image = "img";

                try {
                    // Connect to the database
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
                    
                    // Prepare the SQL query to retrieve all property details
                    String sql = "UPDATE images SET "+image+"='"+newFilename+"' WHERE aid=? ";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, aid);
                    
                    

                    int a = pstmt.executeUpdate();
                    if (a > 0) {
                        out.println("sucessfull database update");
                        response.sendRedirect("user-acc.jsp");
                    } else {
                        out.println("unsucessfull database update");
                    }

                } catch (Exception e) {
                    out.println(e);
                }

            
            
            
            
            
            
            
            
            
            
            
        }
    }
    
    
    public boolean uploadFile(InputStream is, String path) {
        boolean test = false;
        try (FileOutputStream fos = new FileOutputStream(path)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            test = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
