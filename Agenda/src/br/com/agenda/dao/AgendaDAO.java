package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.agenda.factory.ConexaoBanco;
import br.com.agenda.model.Agenda;

public class AgendaDAO extends ConexaoBanco{
	
	private static AgendaDAO instance;
	
	public static AgendaDAO getInstance(){
		if(instance == null)
			instance = new AgendaDAO();
		
		return instance;
		
	}
	
	public ArrayList<Agenda> listarTodos(){
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Agenda> pessoas = null;
		
		conexao = AbrirConexao();
		pessoas = new ArrayList<Agenda>();
		
		
		try{
			pstm = conexao.prepareStatement("select * from contato order by nome_contato");
			rs = pstm.executeQuery();
			
			while(rs.next()){
				Agenda pessoa = new Agenda();
				
				pessoa.setId(rs.getInt("id_contato_pk"));
				pessoa.setNome(rs.getString("nome_contato"));
				pessoa.setSobrenome(rs.getString("sobrenome_contato"));
				
				pessoas.add(pessoa);
				
			}
		} catch(Exception e){
			System.out.println("Erro ao listar todos os clientes: " + e);
			e.printStackTrace();
		} finally{
			fecharConexao(conexao, pstm, rs);
		}
		
		return pessoas;
	}
}
