package model;

public class Userposjava {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Userposjava [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}

	
	
	

}
