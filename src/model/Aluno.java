package model;

public class Aluno {
	private String rgm;
	private String email;
	private String endereco;
	private String municipio;
	private String uf;
	private String dtNascimento;
	private String nome;
	private String celular;
	private String cpf;
	private String curso;
	private String campus;
	private String periodo;
	private String nota;
	private String faltas;
	private String semestre;
	private String disciplina;

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRgm(String rgm) {
		this.rgm = rgm;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public Aluno(String nome, String rgm, String email, String endereco, String municipio, String uf, String dtNascimento, 
			String celular, String cpf, String curso, String campus, String periodo, String disciplina, String nota, String faltas) {
		this.rgm = rgm;
		this.nome = nome;
		this.email = email;
		this.dtNascimento = dtNascimento;
		this.endereco = endereco;
		this.municipio = municipio;
		this.uf = uf;
		this.celular = celular;
		this.cpf = cpf;
		this.curso = curso;
		this.campus = campus;
		this.periodo = periodo;
		this.disciplina = disciplina;
		this.nota = nota;
		this.faltas = faltas;
	}
	
	public Aluno() {
		
	}

	public String getCelular() {
		return  celular;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getRgm() {
		return rgm;
	}
	
	public String getEmail() {
		return email;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getMunicipio() {
		return municipio;
	}
	public String getUf() {
		return uf;
	}
	public String getDtNascimento() {
		return dtNascimento;
	}
	public String getCurso() {
		return curso;
	}
	public String getCampus() {
		return campus;
	}
	public String getPeriodo() {
		return periodo;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getFaltas() {
		return faltas;
	}

	public void setFaltas(String faltas) {
		this.faltas = faltas;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
}
