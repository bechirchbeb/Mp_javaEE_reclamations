package com.enit.servlet;

import java.io.IOException;
import java.util.List;

import com.enit.entities.Etudiant;
import com.enit.entities.Reclamation;
import com.enit.entities.TypeReclamation;
import com.enit.service.AuthentificationServiceLocal;
import com.enit.service.ReclamationServiceLocal;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjoutTypereclamation
 */
@WebServlet("/AjoutTypereclamation")
public class AjoutTypereclamation extends HttpServlet {
	private static final long serialVersionUID = 1L;
ServletContext context ;
	
	@EJB private AuthentificationServiceLocal metierAuthentification;
	@EJB private ReclamationServiceLocal metierReclamation;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutTypereclamation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		context=request.getSession().getServletContext();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Reclamation> listeReclamations=metierReclamation.listerReclamations();
		List<TypeReclamation> listTyperec= metierReclamation.listerTypeReclamations();
		  context.setAttribute("listTyperec",listTyperec);
		  context.setAttribute("listeReclamations",listeReclamations);
		request.getRequestDispatcher("WEB-INF/ajoutTypeReclamation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		context= (ServletContext) request.getSession().getServletContext();
		doGet(request, response);
		List<TypeReclamation> listTyperec= metierReclamation.listerTypeReclamations();
		
		String action=request.getParameter("action"); 
		 
		if(action.equals("submit"))
	
		{ 
			Integer id= Integer.parseInt(request.getParameter("id"));
			String type = request.getParameter("type");
			TypeReclamation typerec=new TypeReclamation();
			typerec.setId_type(id);
			typerec.setType(type);
			metierReclamation.ajouterTypeReclamation(typerec);
			
		}
	}

}
