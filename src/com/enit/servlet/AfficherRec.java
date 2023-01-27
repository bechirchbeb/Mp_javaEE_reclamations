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
 * Servlet implementation class AfficherRec
 */
public class AfficherRec extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServletContext context ;
		
		@EJB private AuthentificationServiceLocal metierAuthentification;
		@EJB private ReclamationServiceLocal metierReclamation;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherRec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		context=request.getSession().getServletContext();
		 List<Reclamation> listeReclamations=metierReclamation.listerReclamations();
			context.setAttribute("listeReclamations",listeReclamations);
		request.getRequestDispatcher("WEB-INF/afficherReclamation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 List<Reclamation> listeReclamations=metierReclamation.listerReclamations();
			context.setAttribute("listeReclamations",listeReclamations);
	}

}
