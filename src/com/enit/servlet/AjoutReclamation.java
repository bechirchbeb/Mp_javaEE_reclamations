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
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AjoutReclamation
 */
@WebServlet("/AjoutReclamation")
public class AjoutReclamation extends HttpServlet {
	ServletContext context;
	@EJB private ReclamationServiceLocal metierreclamation;
	@EJB private AuthentificationServiceLocal metierEtudiant;
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AjoutReclamation() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		context= request.getSession().getServletContext();
		List<Reclamation> listReclamation=metierreclamation.listerReclamations();
		List<Etudiant>listerEtudiant=metierEtudiant.listerEtudiants();
		List<TypeReclamation>listerTypeReclamation=metierreclamation.listerTypeReclamations();
		context.setAttribute("listReclamation",listReclamation);
		context.setAttribute("listerEtudiant",listerEtudiant);
		context.setAttribute("listerTypeReclamation",listerTypeReclamation);
		request.getRequestDispatcher("WEB-INF/ajoutReclamtion.jsp").forward(request, response);
	}
		
	/*	HttpSession session = request.getSession(true);
		Etudiant et = (Etudiant) session.getAttribute("session");
		String username = et.getNom();
		request.setAttribute("username", username);
		request.getRequestDispatcher("WEB-INF/addReclForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context=(ServletContext)request.getSession().getServletContext();
		doGet(request, response);
		List<Reclamation> listReclamation=metierreclamation.listerReclamations();
		String action=request.getParameter("action"); 
		if(action.equals("ajouter"))
		{
		Integer id_reclamation= Integer.parseInt(request.getParameter("id_reclamation"));
		String titre= request.getParameter("titre");
		String description =request.getParameter("description");
		 String id=request.getParameter("id");
		// String type=request.getParameter("type");
		 String id_type=request.getParameter("id_type");
		 Etudiant et=metierEtudiant.chercherEtudiant(Integer.parseInt(id));
		 TypeReclamation typerec=metierreclamation.chercherTypeReclamationParid(Integer.parseInt(id_type));
		
		Reclamation rec=new Reclamation(id_reclamation,titre,description);
		 rec.setEtudiant(et);
	  	rec.setTypereclamation(typerec);
	  	metierreclamation.ajouterReclamation(rec);
		}
		
		/*Reclamation rec1=new Reclamation(1,"bbb","bbb");
		metierreclamation.ajouterReclamation(rec1);*/
		
		
		
	}

}
