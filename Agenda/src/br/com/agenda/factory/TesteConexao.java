package br.com.agenda.factory;

import br.com.agenda.factory.ConexaoBanco;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TesteConexao
 */
@WebServlet("/TesteConexao")

public class TesteConexao extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        response.setContentType("text/html;charset=UTF-8");
		        PrintWriter out = response.getWriter();
		        try {
		            Connection conexao = ConexaoBanco.AbrirConexao();

		            if(conexao != null){
		                out.println("<html><head></head><body>Voc� conectou ao banco de dados!</body></html>");
		            }

		        }catch(Exception e){
		            out.println("Erro: " + e.getMessage());
		        } finally { 
		            out.close();
		        }
		    } 

		    @Override
		    protected void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        processRequest(request, response);
		    } 

		    @Override
		    protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        processRequest(request, response);
		    }

		    @Override
		    public String getServletInfo() {
		        return "Short description";
		    }
}
