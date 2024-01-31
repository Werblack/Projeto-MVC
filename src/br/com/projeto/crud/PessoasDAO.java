package br.com.projeto.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.projeto.model.DadosPessoais;
import br.com.projeto.util.ConnectionFactory;




public class PessoasDAO {
	
	private DadosPessoais pessoa;
	private Connection conn;		//é a conexao com o db
	private PreparedStatement ps;//permite usa sql
	private ResultSet rs;		//é uma tabela
	
	public PessoasDAO() throws Exception{
		
		try {
			conn = ConnectionFactory.getConnection();
		}catch(Exception e) {
			throw new Exception("Erro ao conectar ao DB" + e.getMessage());
		}
	}
	
	public void salvar(DadosPessoais pessoa) throws Exception{
		try {
			
			String sql="INSERT INTO PESSOAIS(rgm, nome, data_nascimento, cpf, email, endereco, municipio, uf, celular, curso, campus, periodo)"
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt		(1, pessoa.getRgm());
			ps.setString	(2, pessoa.getNome());
			ps.setString	(3, pessoa.getDataNascimento());
			ps.setString	(4, pessoa.getCpf());
			ps.setString	(5, pessoa.getEmail());
			ps.setString	(6, pessoa.getEndereco());
			ps.setString	(7, pessoa.getMunicipio());
			ps.setString	(8, pessoa.getUf());
			ps.setString	(9, pessoa.getCelular());
			ps.setString	(10, pessoa.getCurso());
			ps.setString	(11, pessoa.getCampus());
			ps.setString	(12, pessoa.getPeriodo());
			ps.executeUpdate();
		
	}catch(Exception e) {
		throw new Exception("Erro ao salvar"+e.getMessage());
		}
		
	}


   //=========================================================================================================


	public void alterar(DadosPessoais pessoa) throws Exception {
		try {
			String sql = "UPDATE PESSOAIS SET NOME =? ,"
					+ "DATA_NASCIMENTO=? , CPF=? ,EMAIL=? ,ENDERECO=? ,MUNICIPIO=? ,UF=? ,CELULAR=? ,CURSO=? ,CAMPUS=? ,"
					+ "PERIODO=? WHERE RGM=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getDataNascimento());
			ps.setString(3, pessoa.getCpf());
			ps.setString(4, pessoa.getEmail());
			ps.setString(5, pessoa.getEndereco());
			ps.setString(6, pessoa.getMunicipio());
			ps.setString(7, pessoa.getUf());
			ps.setString(8, pessoa.getCelular());
			ps.setString(9, pessoa.getCurso());
			ps.setString(10, pessoa.getCampus());
			ps.setString(11, pessoa.getPeriodo());
			ps.setInt(12, pessoa.getRgm());
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception("Erro ao alterar: " + e.getMessage());
		}
	}

	//=====================================================================================
	
	public void excluir(int rgm) throws Exception {
		try {
			String sql = "DELETE FROM PESSOAIS WHERE rgm=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rgm);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception("Erro ao excluir: " + e.getMessage());
		}
	}

	//=========================================================================================
	
	public DadosPessoais consultar(int rgm) throws Exception {
		try {
			ps = conn.prepareStatement("select * from pessoais where rgm=?");
			ps.setInt(1, rgm);
			rs = ps.executeQuery();// quando é select coloca query
			if (rs.next()) {
				String nome = rs.getString("nome");
				String data_nascimento = rs.getString("data_nascimento");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				String endereco = rs.getString("endereco");
				String municipio = rs.getString("municipio");
				String uf = rs.getString("uf");
				String celular = rs.getString("celular");
				String curso = rs.getString("curso");
				String campus = rs.getString("campus");
				String periodo = rs.getString("periodo");
				pessoa = new DadosPessoais(rgm, nome, data_nascimento, cpf, email, endereco, municipio, uf, celular,
						curso, campus, periodo);
			}
			return pessoa;
		} catch (Exception e) {
			throw new Exception("Erro ao Consulta: " + e.getMessage());
		}
	}
}

	//=======================================================================================