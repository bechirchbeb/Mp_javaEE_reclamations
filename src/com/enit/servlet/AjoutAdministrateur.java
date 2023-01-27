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

import com.enit.entities.Administrateur;
import com.enit.entities.Etudiant;
import com.enit.entities.Reclamation;
import com.enit.service.AuthentificationServiceLocal;
import com.enit.service.ReclamationServiceLocal;

/**
 * Servlet implementation class AjoutAdministrateur
 */
public class AjoutAdministrateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServletContext context ;
		
		@EJB private AuthentificationServiceLocal metierAuthentification;
		@EJB private ReclamationServiceLocal metierReclamation;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutAdministrateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		context=request.getSession().getServletContext();
		List<Etudiant> listeEtudiants=metierAuthentification.listerEtudiants();
		   List<Reclamation> listeReclamations=metierReclamation.listerReclamations();
			  context.setAttribute("listeEtudiants", listeEtudiants);
					context.setAttribute("listeReclamations",listeReclamations);
					request.getRequestDispatcher("WEB-INF/ajoutAdmin.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
     		String action=request.getParameter("action"); 
		 
			if(action.equals("ajouter"))
		
			{ 
				
				Integer id= Integer.parseInt(request.getParameter("id"));
				String email= request.getParameter("email");
				String  password=request.getParameter("password");
				Administrateur etud= new Administrateur();
				etud.setId(id);
				etud.setActif(true);
				etud.setEmail(email);
				etud.setPassword(password);
				metierAuthentification.ajouterAdmin(etud);
		
		
		
		
		
		
		
		
	}

	}
	}
