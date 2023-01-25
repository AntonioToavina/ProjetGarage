/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Connexion;
import Metier.M_Employe;
import Metier.M_NiveauEtude;
import Metier.M_Specialite;
import Model.Employe;
import Model.NiveauEtude;
import Model.Specialite;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author antonio
 */
@WebServlet(name = "Controller_NewEmploye", urlPatterns = {"/newEmploye"})
public class Controller_NewEmploye extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller_NewEmploye</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller_NewEmploye at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
       PrintWriter out=response.getWriter();
        Connection connection=null;
        try{
            connection=new Connexion().getConnexion();
            ArrayList<NiveauEtude> listniveau=new M_NiveauEtude().getAll(connection);
            ArrayList<Specialite> listSpecialite=new M_Specialite().getAll(connection);

            RequestDispatcher dispatcher=request.getRequestDispatcher("Admin.jsp?page=Page/Home.jsp");
            request.setAttribute("listniveau",listniveau);
            request.setAttribute("listspecialite",listSpecialite);

            dispatcher.forward(request,response);
        }catch(Throwable e){
            out.println(e.getMessage());
        }
        finally{
            if(connection!=null)
                try {
                    connection.close();
            } catch (SQLException ex) {
               out.print(ex.getMessage());
            }
        }
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
        PrintWriter out=response.getWriter();
        try{
            NiveauEtude niveauetude=new NiveauEtude();
            niveauetude.setIdNiveauEtude(Integer.parseInt(request.getParameter("niveauetude")));
            
            Employe employe=new Employe();
            employe.setNom(request.getParameter("nom"));
            employe.setPrenom(request.getParameter("prenom"));
            employe.setNiveauEtude(niveauetude);
            employe.setDateNaissance(Date.valueOf(request.getParameter("dn")));
            
            String[] list=request.getParameterValues("specialite[]");
            Specialite[] specialite=new Specialite[list.length];
            
            for(int i=0;i<list.length;i++)
            {
                specialite[i]=new Specialite();
                specialite[i].setIdSpecialite(Integer.parseInt(list[i]));
            }
            
            employe.setSpecialite(specialite);
            new M_Employe().newEmploye(employe);
            
            response.sendRedirect("niveauetude");
        }catch(Throwable e){
            out.println(e.getMessage());
        }
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
