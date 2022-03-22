package br.com.fiap.enjoy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_enjoy_bebida")
public class Bebida {

	@Id
	@Column(name = "id_bebida")
	@SequenceGenerator(name="bebida",sequenceName="sq_tb_bebida",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bebida")
	private Integer id;
	
	@Column(name = "nm_bebida", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "ds_categoria", length = 30, nullable = false)
	private String categoria;

	public Bebida() {
		super();
	}

	public Bebida(Integer id, String nome, String categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
