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
 * Servlet implementation class Activer
 */
public class Activer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServletContext context ;
		
		@EJB private AuthentificationServiceLocal metierAuthentification;
		@EJB private ReclamationServiceLocal metierReclamation;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Activer() {
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
		   List<Reclamation> listeReclamations=metierReclamation.listerReclamations();
			  context.setAttribute("listeEtudiants", listeEtudiants);
					context.setAttribute("listeReclamations",listeReclamations);
					request.getRequestDispatcher("WEB-INF/activer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
   List<Etudiant> listeEtudiants=metierAuthentification.listerEtudiants();
		
		String action=request.getParameter("action"); 
		 
			if(action.equals("activer"))
		
			{ 
				String nom=request.getParameter("nom");
				String prenom=request.getParameter("prenom");
				metierAuthentification.updateActive(nom, prenom);
				
				
				//List<Reclamation> reclamationSelectionnes= metierReclamation.listerReclamationParEtudiant(etud);
				}
			else if(action.equals("desactiver"))
			{
				String nom=request.getParameter("nom");
				String prenom=request.getParameter("prenom");
				metierAuthentification.updateDActive(nom, prenom);
			}
	}

}
