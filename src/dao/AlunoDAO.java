package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SqlConnection;
import model.Aluno;

public class AlunoDAO {
	// conectar com o BD
		private Connection conn;
		// para rodar SQL
		private PreparedStatement ps;
		private PreparedStatement ps2;
		// tabela
		ResultSet rs;
		Aluno aluno;

		public AlunoDAO() throws Exception {
			// chama a classe ConnectionFactory e 
			//estabele uma conexão
			try {
				this.conn = SqlConnection.getConnection();
			} catch (Exception e) {
				throw new Exception("erro: \n" + e.getMessage());
			}
		}

		// método de salvar

		public void salvar(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "INSERT INTO aluno (rgm, "
						+ "nome, datanascimento, cpf, email,"
						+ "endereco, municipio, uf, celular) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, aluno.getRgm());
				ps.setString(2, aluno.getNome());
				ps.setString(3, aluno.getDtNascimento());
				ps.setString(4, aluno.getCpf());
				ps.setString(5, aluno.getEmail());
				ps.setString(6, aluno.getEndereco());
				ps.setString(7, aluno.getMunicipio());
				ps.setString(8, aluno.getUf());
				ps.setString(9, aluno.getCelular());
				ps.executeUpdate();
				
				String SQL2 = "INSERT INTO curso (rgm_aluno, curso, campus, periodo) values (?, ?, ?, ?)";
				ps2 = conn.prepareStatement(SQL2);
				ps2.setString(1, aluno.getRgm());
				ps2.setString(2, "");
				ps2.setString(3, "");
				ps2.setString(4, "");
				ps2.executeUpdate();	
				
				String SQL3 = "INSERT INTO boletim (rgm_id, curso_id, disciplina, nota, faltas) values (?, ?, ?, ?, ?)";
				ps = conn.prepareStatement(SQL3);
				ps.setString(1, aluno.getCurso());
				ps.setString(2, "");
				ps.setString(3, "");
				ps.setString(4, "");
				ps.setString(5, "");
				ps.executeUpdate();
				
			} catch (SQLException sqle) {
				throw new Exception("Erro ao inserir dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}
		// atualizar
		public void atualizar(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "UPDATE aluno SET nome = ?, datanascimento =?, cpf=?, email=?,"
						+ "endereco=?, municipio=?, uf=?, celular=?  WHERE rgm=?";
				ps = conn.prepareStatement(SQL);;				
				ps.setString(1, aluno.getNome());
				ps.setString(2, aluno.getDtNascimento());
				ps.setString(3, aluno.getCpf());
				ps.setString(4, aluno.getEmail());
				ps.setString(5, aluno.getEndereco());
				ps.setString(6, aluno.getMunicipio());
				ps.setString(7, aluno.getUf());
				ps.setString(8, aluno.getCelular());
				ps.setString(9, aluno.getRgm());
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception("Erro ao atualizar dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}
		// Excluir
		public Aluno excluir(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
		        String SQL = "DELETE FROM aluno WHERE rgm=?";
		        ps = conn.prepareStatement(SQL);
		        ps.setString(1, aluno.getRgm());
		        int rowsAffected = ps.executeUpdate();
		        if (rowsAffected == 0) {
		            throw new Exception("Nenhum aluno encontrado com o RGM informado");
		        }

			} catch (SQLException sqle) {
				throw new Exception("Erro ao excluir dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
			return aluno;
		}

		// Consultar
		public Aluno consultar(Aluno a) throws Exception {
			if (a == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {				
				String SQL = "SELECT * FROM aluno, curso,boletim WHERE rgm=?";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, a.getRgm());
				rs = ps.executeQuery();
				if(rs.next()) {
					String rgm = rs.getString("rgm");
					String nome = rs.getString("nome");
					String email = rs.getString("email");
					String endereco = rs.getString("endereco");
					String municipio = rs.getString("municipio");
					String uf = rs.getString("uf");
					String dtNascimento = rs.getString("datanascimento");
					String celular = rs.getString("celular");
					String cpf = rs.getString("cpf");
					String curso = rs.getString("curso");
					String campus = rs.getString("campus");
					String periodo = rs.getString("periodo");
					String disciplina = rs.getString("disciplina");
					String nota = rs.getString("nota");
					String faltas = rs.getString("faltas");
					aluno = new Aluno(nome,rgm,email,endereco,municipio,uf,dtNascimento,celular,cpf,curso,campus,periodo, disciplina, nota, faltas);
								}
				return aluno;
			} catch (SQLException sqle) {
				throw new Exception("Erro ao consultar dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}
		
		
		// Aba de cursos
		public void salvarCurso(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "UPDATE curso SET campus = ?, curso = ?, periodo = ? WHERE rgm_aluno=?";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, aluno.getCampus());
				ps.setString(2, aluno.getCurso());
				ps.setString(3, aluno.getPeriodo());
				ps.setString(4, aluno.getRgm());
				ps.executeUpdate();
				
				String SQL2 = "UPDATE boletim SET curso_id = ?, disciplina = ?, nota = ?, faltas = ? WHERE rgm_id=?";
				ps = conn.prepareStatement(SQL2);
				ps.setString(1, aluno.getCurso());
				ps.setString(2, "");
				ps.setString(3, "");
				ps.setString(4, "");
				ps.setString(5, "");
				ps.executeUpdate();
				
			} catch (SQLException sqle) {
				throw new Exception("Erro ao inserir dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}
		
		
		public Aluno consultarCurso(Aluno a) throws Exception {
			if (a == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {				
				String SQL = "SELECT * FROM aluno,curso, boletim WHERE rgm_aluno=?";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, a.getRgm());
				rs = ps.executeQuery();
				if(rs.next()) {
					String rgm = rs.getString("rgm_aluno");
					String nome = rs.getString("nome");
					String email = rs.getString("email");
					String endereco = rs.getString("endereco");
					String municipio = rs.getString("municipio");
					String uf = rs.getString("uf");
					String dtNascimento = rs.getString("datanascimento");
					String celular = rs.getString("celular");
					String cpf = rs.getString("cpf");
					String curso = rs.getString("curso");
					String campus = rs.getString("campus");
					String periodo = rs.getString("periodo");
					String disciplina = rs.getString("disciplina");
					String nota = rs.getString("nota");
					String faltas = rs.getString("faltas");
					aluno = new Aluno(nome,rgm,email,endereco,municipio,uf,dtNascimento,celular,cpf,curso,campus,periodo, disciplina, nota, faltas);
								}
				return aluno;
			} catch (SQLException sqle) {
				throw new Exception("Erro ao consultar dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}
		
		public Aluno excluirCurso(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
		        String SQL = "UPDATE curso SET campus = '', curso = '', periodo = '' WHERE rgm_aluno=?";
		        ps = conn.prepareStatement(SQL);
		        ps.setString(1, aluno.getRgm());
		        int rowsAffected = ps.executeUpdate();
		        if (rowsAffected == 0) {
		            throw new Exception("Nenhum curso encontrado para o aluno com o RGM informado");
		        }
			} catch (SQLException sqle) {
				throw new Exception("Erro ao excluir dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
			return aluno;
		}
		public void salvarNotasEFaltas(Aluno aluno) throws Exception {
		    if (aluno == null)
		        throw new Exception("O valor passado nao pode ser nulo");
		    try {
		        // Verifica se já existe um registro com o mesmo RGM, curso e disciplina
		        String checkSQL = "SELECT COUNT(*) FROM boletim WHERE rgm_id = ? AND curso_id = ? AND disciplina = ?";
		        PreparedStatement checkStmt = conn.prepareStatement(checkSQL);
		        checkStmt.setString(1, aluno.getRgm());
		        checkStmt.setString(2, aluno.getCurso());
		        checkStmt.setString(3, aluno.getDisciplina());
		        ResultSet rs = checkStmt.executeQuery();
		        rs.next();
		        int count = rs.getInt(1);

		        if (count > 0) {
		            // Se o registro já existe, atualiza a nota e faltas
		            String updateSQL = "UPDATE boletim SET nota = ?, faltas = ? WHERE rgm_id = ? AND curso_id = ? AND disciplina = ?";
		            PreparedStatement updateStmt = conn.prepareStatement(updateSQL);
		            updateStmt.setString(1, aluno.getNota());
		            updateStmt.setString(2, aluno.getFaltas());
		            updateStmt.setString(3, aluno.getRgm());
		            updateStmt.setString(4, aluno.getCurso());
		            updateStmt.setString(5, aluno.getDisciplina());
		            updateStmt.executeUpdate();
		        } else {
		            // Se o registro não existe, insere um novo
		            String insertSQL = "INSERT INTO boletim (rgm_id, curso_id, disciplina, nota, faltas) VALUES (?, ?, ?, ?, ?)";
		            PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
		            insertStmt.setString(1, aluno.getRgm());
		            insertStmt.setString(2, aluno.getCurso());
		            insertStmt.setString(3, aluno.getDisciplina());
		            insertStmt.setString(4, aluno.getNota());
		            insertStmt.setString(5, aluno.getFaltas());
		            insertStmt.executeUpdate();
		        }
		    } catch (SQLException sqle) {
		        throw new Exception("Erro ao atualizar dados " + sqle);
		    } finally {
		        SqlConnection.closeConnection(conn, ps);
		    }
		}
		
		public Aluno excluirNotaSemestre1(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
		        String SQL = "DELETE FROM semestre1 WHERE rgm_aluno=?";
		        ps = conn.prepareStatement(SQL);
		        ps.setString(1, aluno.getRgm());
		        int rowsAffected = ps.executeUpdate();
		        if (rowsAffected == 0) {
		            throw new Exception("Nenhum curso encontrado para o aluno com o RGM informado");
		        }
			} catch (SQLException sqle) {
				throw new Exception("Erro ao excluir dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
			return aluno;
		}	
		
		public Aluno buscarNotaEFaltas(Aluno a) throws Exception {
			if (a == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {				
				String SQL = "SELECT nota,faltas FROM boletim WHERE rgm_id=? AND disciplina=?";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, a.getRgm());
				ps.setString(2, a.getDisciplina());
				rs = ps.executeQuery();
				if(rs.next()) {
					String nota = rs.getString("nota");
					String faltas = rs.getString("faltas");
		            Aluno aluno = new Aluno();
		            aluno.setRgm(a.getRgm());
		            aluno.setDisciplina(a.getDisciplina());
		            aluno.setNota(nota);
		            aluno.setFaltas(faltas);

		            return aluno;
				}else {
					// Se não houver dados para o aluno, retorna o objeto original
		            return a;
				}				
			} catch (SQLException sqle) {
				throw new Exception("Erro ao consultar dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);

			}
		}
		
		public List<Aluno> listarTodos() throws Exception {
			try {
				
				List<Aluno> lista = new ArrayList<Aluno>();
				
				String SQL = "SELECT * FROM aluno,curso,boletim";
				ps = conn.prepareStatement(SQL);
				rs = ps.executeQuery();
				while(rs.next()) {
					String rgm = rs.getString("rgm");
					String nome = rs.getString("nome");
					String email = rs.getString("email");
					String endereco = rs.getString("endereco");
					String municipio = rs.getString("municipio");
					String uf = rs.getString("uf");
					String dtNascimento = rs.getString("datanascimento");
					String celular = rs.getString("celular");
					String cpf = rs.getString("cpf");
					String curso = rs.getString("curso_id");
					String campus = rs.getString("campus");
					String periodo = rs.getString("periodo");
					String disciplina = rs.getString("disciplina");
					String nota = rs.getString("nota");
					String faltas = rs.getString("faltas");
					aluno = new Aluno(nome,rgm,email,endereco,municipio,uf,dtNascimento,celular,cpf,curso,
							campus,periodo, disciplina, nota, faltas);
					lista.add(aluno);
				}
				return lista;
			} catch (SQLException sqle) {
				throw new Exception("Erro ao excluir dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}
}
