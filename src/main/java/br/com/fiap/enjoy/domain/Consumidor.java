package br.com.fiap.enjoy.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_enjoy_consumidor")
public class Consumidor {
	
	@Id
	@Column(name="id_consumidor")
	@SequenceGenerator(name="consumidor",sequenceName="sq_tb_consumidor",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="consumidor")
	private int id;
	
	@Column(name="nr_telefone",nullable=false,length=11, unique = true)
	private int telefone;
	
	@Column(name="nm_consumidor",nullable=false,length=50)
	private String nome;
	
	@Column(name="nm_email",nullable=false,length=40)
	private String email;
	
	@Column(name="nr_cpf",nullable=false,length=11)
	private String cpf;
	
	@Column(name="ds_genero",nullable=false,length=1)
	private String genero;
	
	@Column(name="dt_nascimento")
	private Calendar nascimento;
	
	@OneToMany(mappedBy = "consumidor")
	private List<Visitas> visitas;
	

	public Consumidor() {
		super();
	}

	public Consumidor(int id, int telefone, String nome, String email, String cpf, String genero, Calendar nascimento,
			List<Visitas> visitas) {
		super();
		this.id = id;
		this.telefone = telefone;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.genero = genero;
		this.nascimento = nascimento;
		this.visitas = visitas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public List<Visitas> getVisitas() {
		return visitas;
	}

	public void setVisitas(List<Visitas> visitas) {
		this.visitas = visitas;
	}

}