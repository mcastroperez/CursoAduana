package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.model.Cliente;
import cl.model.ServicioLocal;

/**
 * Servlet implementation class Controller
 */
@WebServlet(name = "control.do", urlPatterns = { "/control.do" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ServicioLocal servicio;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void inicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String btn = request.getParameter("boton");
    	
    	if (btn.equals("guardar")){
    		this.guardar(request, response);
    	}
    	
    	if (btn.equals("eliminar")){
    		this.eliminar(request, response);
    	}
    	
    	if (btn.equals("actualizar")){
    		this.actualizar(request, response);
    	}
    	
    	/*switch (btn) {
		case "guardar":
			this.guardar(request, response);
			break;

		case "eliminar":
			this.eliminar(request, response);
			break;
		}*/
    	
		
	}
    
    protected void guardar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
    	String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String rut = request.getParameter("rut");
		
		Cliente cli = new Cliente(nombre, apellido, rut);
		servicio.addCliente(cli);
		response.sendRedirect("index.jsp");
	}
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String rut = request.getParameter("rut");
		servicio.eliminar(rut);
		
		response.sendRedirect("index.jsp");
	}
    
    protected void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
    	String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String rut = request.getParameter("rut");
		
		Cliente cli = new Cliente(nombre, apellido, rut);
		servicio.actualizarCliente(cli);
		
		response.sendRedirect("index.jsp");
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.getWriter().append("Server at:").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			this.inicio(request, response);
	}
	
	

}
