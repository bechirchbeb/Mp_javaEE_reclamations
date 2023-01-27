package com.enit.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.enit.entities.Administrateur;
import com.enit.entities.Etudiant;
import com.enit.entities.Utilisateurs;
import com.enit.service.AuthentificationServiceLocal;
import com.enit.service.ReclamationServiceLocal;

/**
 * Servlet implementation class LogEtud
 */
public class LogEtud extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServletContext context ;
		@EJB private AuthentificationServiceLocal metierAuthentification;
		@EJB private ReclamationServiceLocal metierReclamation;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogEtud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("WEB-INF/loginEtudiant.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
         //		doGet(request, response);
		String action=request.getParameter("action");
		if (action.equals("Login")) {
			String em = request.getParameter("email");
			String pass = request.getParameter("password");
		Utilisateurs u=	metierAuthentification.authentifieruser(em, pass)
				if(u instanceof Etudiant)
				{response.sendRedirect("/projetV2/AjoutReclamation");}
			else if(u instanceof Administrateur) 
			{
				response.sendRedirect("/projetV2/aceuilAdmin.jsp");}
		  
		else {
			response.sendRedirect("/projetV2/LogEtud");}
			}
		}
	
	
	}

}
