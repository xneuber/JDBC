package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import entities.Aluno;

public class AlunoJDBC {
	
	Connection con;
	String sql;
	PreparedStatement pst;
	
	
	public void salvar(Aluno a) throws IOException {
		
		try {
			Connection con = db.getConexao();
			System.out.println("Conex�o realizada com sucesso !");
			
			sql = "INSERT INTO aluno (nome, sexo, dt_nasc) VALUES ( ?,  ?, ?)";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, a.getNome());
			pst.setString(2, a.getSexo());
			
			Date dataSql = new Date(a.getDt_nasc().getTime());
			pst.setDate(3, dataSql);
			
			pst.executeUpdate();
			System.out.println("\nCadastro do aluno realizado com sucesso!");
			
			db.fechaConexao();
			System.out.println("Conex�o fechada com sucesso !");
		}
		catch (SQLException e) {
			
			System.out.println(e);
		}
		
	}
	
	public List<Aluno> listar() {

		return null;
	}
	
	public void apagar(int id) {
		
	}
	
	public void alterar(Aluno a) {
		
	}
}

