/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Connexion;
import Metier.M_NiveauEtude;
import Metier.M_Specialite;
import Model.NiveauEtude;
import Model.Specialite;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
@WebServlet(name = "Controller_Specialite", urlPatterns = {"/specialite"})
public class Controller_Specialite extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out=response.getWriter();
        try{
            Connection connection=new Connexion().getConnexion();
            ArrayList<NiveauEtude> listniveau=new M_NiveauEtude().getAll(connection);
            ArrayList<Specialite> listSpecialite=new M_Specialite().getAll(connection);

            RequestDispatcher dispatcher=request.getRequestDispatcher("Admin.jsp?page=Page/Home.jsp");
            request.setAttribute("listniveau",listniveau);
            request.setAttribute("listspecialite",listSpecialite);

            dispatcher.forward(request,response);
        }catch(Throwable e){
            out.println(e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
