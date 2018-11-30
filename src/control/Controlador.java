package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import modelo.Libro;
import modelo.usuarios;
import modelo.usuarios;
import utilidades.Conexion;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/conecta")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String mensaje = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");
		String rutaJSP = "";
		switch (opcion) {
		case "1":
			rutaJSP = "mensaje";
			opcion1(request);
			break;
		case "2":
			rutaJSP = "libros";			
			opcion2(request);
			break;
		case "3":
			rutaJSP = "registro";			
			try {
				opcion3(request);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "4":
			rutaJSP = "registro";			
			opcion2(request);
			break;
		default:
			break;
		}
		request.getRequestDispatcher("jsp/" + rutaJSP + ".jsp").forward(request, response);
	}
	public void opcion2(HttpServletRequest request) {
		ArrayList<Libro> libros = Conexion.getAllLibros();
		request.setAttribute("libros", libros);
	}
	public void opcion1(HttpServletRequest request) {

		Connection cnx = Conexion.conectar("localhost:3306", "eshop", "root", "");
		if (cnx == null)
			mensaje = "Error de conexión...";
		else
			mensaje = "Conectado con exito...";
		request.setAttribute("mensaje", mensaje);
	}
	
	public void opcion3(HttpServletRequest request) throws SQLException {
		String sql="INSERT TO usuarios(usuario,clave) values (String , String)";
		Connection connection= Conexion.conectar("localhost:3306", "eshop", "root", "");
		Statement stmt = connection.prepareStatement(sql);
		stmt.executeQuery(sql);
		
		
	try {
		System.out.println("error al meter" + usuarios.getUsario() + usuarios.getContraseña());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
