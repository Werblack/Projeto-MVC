package br.com.projeto.crud;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.projeto.model.NotasFaltas;
import br.com.projeto.util.ConnectionFactory;

public class NotaEFalta {
	
	private NotasFaltas notasfaltas;
	private Connection conn;			//é a conexao com o db
	private PreparedStatement ps;		//permite usa sql
	private ResultSet rs;				//é uma tabela
	
	public NotaEFalta() throws Exception{
		
		try {
			conn = ConnectionFactory.getConnection();
		}catch(Exception e) {
			throw new Exception("Erro ao conectar ao DB" + e.getMessage());
		}
	}
	
	public void salvar(NotasFaltas notasfaltas) throws Exception{
		try {
			
			String sql="INSERT INTO notas_faltas (rgm, disciplina, semestre, nota, faltas)"
					+ "values(?, ?, ?, ?, ? )";
			ps = conn.prepareStatement(sql);
			ps.setInt		(1, notasfaltas.getRgm1());
			ps.setString	(2, notasfaltas.getDisciplina1());
			ps.setString	(3, notasfaltas.getSemestre1());
			ps.setString	(4, notasfaltas.getNota1());
			ps.setString	(5, notasfaltas.getFaltas1());
		
			ps.executeUpdate();
		
	}catch(Exception e) {
		throw new Exception("Erro ao salvar"+e.getMessage());
		}
		
	}


   //=========================================================================================================


	public void alterar(NotasFaltas notasfaltas ) throws Exception {
		try {
			
			String sql = "UPDATE NOTAS_FALTAS SET DISCIPLINA = ?, SEMESTRE = ?, NOTA = ?, FALTAS = ?"
					+ " WHERE RGM = ? " ;
		
			ps = conn.prepareStatement(sql);
			
			ps.setString	(1, notasfaltas.getDisciplina1());
			ps.setString	(2, notasfaltas.getSemestre1());
			ps.setString	(3, notasfaltas.getNota1());
			ps.setString	(4, notasfaltas.getFaltas1());
			ps.setInt		(5, notasfaltas.getRgm1());
					
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception("Erro ao alterar: " + e.getMessage());
		}
	}

	//=====================================================================================
	
	public void excluir(int rgm1) throws Exception {
		try {
			String sql = "DELETE FROM NOTAS_FALTAS WHERE rgm=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rgm1);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception("Erro ao excluir: " + e.getMessage());
		}
	}

	//=========================================================================================
	
	public NotasFaltas consultar(int rgm1) throws Exception {
		
		try {
			ps = conn.prepareStatement("select * from NOTAS_FALTAS where rgm=?");
			ps.setInt(1, rgm1);
			rs = ps.executeQuery();// quando é select coloca query
			
			if (rs.next()) {
				String disciplina1 = rs.getString("disciplina");
				String semestre1 = rs.getString("semestre");
				String nota1 = rs.getString("Nota");
				String falta1 = rs.getString("Faltas");
				
				
				notasfaltas = new NotasFaltas (rgm1, disciplina1,semestre1,nota1,falta1 );
			}
			
			return notasfaltas;
		} 
		
		catch (Exception e) {
			throw new Exception("Erro ao Consulta: " + e.getMessage());
		}
	}
	
	//===================================================================================		
	
	public List<NotasFaltas> listarNotas(int rgm) throws Exception {
		List<NotasFaltas> lista = new ArrayList<NotasFaltas>();
		try {
			ps = conn.prepareStatement("SELECT * FROM notas_faltas where RGM = ?");
			ps.setInt(1, rgm);
			rs = ps.executeQuery();
			while(rs.next()) {
				int rgm1 = rs.getInt("rgm");
				String disciplina1 = rs.getString("disciplina");
				String notas1 = rs.getString("nota");
				String faltas1 = rs.getString("faltas");
				notasfaltas = new NotasFaltas (rgm1, disciplina1, notas1, faltas1);
				lista.add(notasfaltas);
			}
			
			return lista;
		}
		
		catch(Exception e) {
			throw new Exception("Erro ao listar "+ e.getMessage());
		}
	}

	//==============================================================================
}
