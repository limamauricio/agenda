package br.com.agenda.factory;

import java.sql.*;

public class ConexaoBanco {

	private static final String banco = "agenda";
	private static final String usuario = "postgres";
	private static final String senha = "postgres";
	private static final String driver = "org.postgresql.Driver";
	private static final String url = "jdbc:postgresql://localhost:5432/";
	
	
	
	public Connection AbrirConexao() {
		
		Connection conexao = null;
		try{
			
		Class.forName(driver);
		conexao = (Connection)DriverManager.getConnection(url+ banco,usuario,senha);
		if(conexao != null)
			System.out.println("Conectou!");
		
		}catch(Exception e){
			System.out.println("Erro na conexao com o banco");
			e.printStackTrace();
		
	}
		return conexao;
	}
	
	public void fecharConexao(Connection conexao, PreparedStatement pstm, ResultSet rs){
		
		try {
			if(conexao != null){
				conexao.close();
			}
			if(pstm != null){
				pstm.close();
			}
			if(rs != null){
				rs.close();
			}
		} catch (Exception e) {
			System.out.println("Erro ao fechar conexao com o banco");
		}
	}
	 
}
