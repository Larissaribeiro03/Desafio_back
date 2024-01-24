package br.com.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(max = 200, message = "Nome da pessoa não pode ser maior que 200 digitos")
	@Column(nullable = false, length = 200)
	private String nome;

	@Size(min = 1, max = 1, message = "Sexo deve conter apenas 1 digito")
	@Column(nullable = false, length = 1)
	private String sexo;

	@Size(min = 11, max = 15, message = "Cpf deve conter 15 digitos")
	@Column(nullable = false, length = 15)
	private String cpf;

	@Email
	@Size(max = 200, message = "Email da pessoa não pode ser maior que 200 digitos")
	@Column(nullable = false, length = 200)
	private String email;

	@Size(min = 11, max = 11, message = "Celular deve conter 11 digitos")
	@Column(length = 11)
	private String celular;

	public Pessoa() {

	}

	public Pessoa(Integer id,
			@Size(max = 200, message = "Nome da pessoa não pode ser maior que 200 digitos") String nome,
			@Size(min = 1, max = 1, message = "Sexo deve conter apenas 1 digito") String sexo,
			@Size(min = 11, max = 11, message = "Cpf deve conter 11 digitos") String cpf,
			@Email @Size(max = 200, message = "Email da pessoa não pode ser maior que 200 digitos") String email,
			@Size(min = 11, max = 11, message = "Celular deve conter 11 digitos") String celular) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.email = email;
		this.celular = celular;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public void limparCpf() {
        if (cpf != null) {
            cpf = cpf.replaceAll("[^0-9]", "");
        }
    }
}
