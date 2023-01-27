package com.enit.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.enit.entities.Etudiant;
import com.enit.entities.Reclamation;
import com.enit.service.AuthentificationServiceLocal;
import com.enit.service.ReclamationServiceLocal;

/**
 * Servlet implementation class AfficherEtud
 */
public class AfficherEtud extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServletContext context ;
		
		@EJB private AuthentificationServiceLocal metierAuthentification;
		@EJB private ReclamationServiceLocal metierReclamation;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherEtud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		context=request.getSession().getServletContext();
		List<Etudiant> listeEtudiants=metierAuthentification.listerEtudiants();
			  context.setAttribute("listeEtudiants", listeEtudiants);
			request.getRequestDispatcher("WEB-INF/afficherEtudiant.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		List<Etudiant> listeEtudiants=metierAuthentification.listerEtudiants();
		  context.setAttribute("listeEtudiants", listeEtudiants);
	}

}
