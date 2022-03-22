package br.com.fiap.enjoy.domain;


import java.util.Calendar;
//import java.util.List;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tb_enjoy_estabelecimento")
public class Estabelecimento {
	@Id
	@SequenceGenerator(name="estabelecimento",sequenceName="sq_fm_estab",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="estabelecimento")
	@Column(name = "id_estab")
	private Integer idEstab;
	
	@Column(name="nm_estab",nullable=false,length=50)
	private String nomeEstabelecimento;
	
	@Column(name="ds_categoria",nullable=false,length=20)
	private String categoria;
	
	@Column(name="nr_cep",nullable=false,length=8)
	private String numeroCep;
	
	@Column(name="nm_endereco",nullable=false,length=30)
	private String nomeEnd;
	
	@Column(name="nr_endereco",nullable=false,length=8)
	private String numeroEndereco;
	
	@Column(name="ds_complemento",length=30)
	private String complemento;
	
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_cadastro", nullable = false)
    private Calendar dataCadastro;
	
	@OneToMany(mappedBy = "estabelecimento")
	private List<Visitas> visitas;
	
	@OneToMany(mappedBy = "estabelecimento")
	private List<Produto> produto;

	public Estabelecimento() {
		super();
	}

	public Estabelecimento(Integer idEstab, String nomeEstabelecimento, String categoria, String numeroCep,
			String nomeEnd, String numeroEndereco, String complemento, Calendar dataCadastro, List<Visitas> visitas,
			List<Produto> produto) {
		super();
		this.idEstab = idEstab;
		this.nomeEstabelecimento = nomeEstabelecimento;
		this.categoria = categoria;
		this.numeroCep = numeroCep;
		this.nomeEnd = nomeEnd;
		this.numeroEndereco = numeroEndereco;
		this.complemento = complemento;
		this.dataCadastro = dataCadastro;
		this.visitas = visitas;
		this.produto = produto;
	}

	public Integer getIdEstab() {
		return idEstab;
	}

	public void setIdEstab(Integer idEstab) {
		this.idEstab = idEstab;
	}

	public String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}

	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		this.nomeEstabelecimento = nomeEstabelecimento;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNumeroCep() {
		return numeroCep;
	}

	public void setNumeroCep(String numeroCep) {
		this.numeroCep = numeroCep;
	}

	public String getNomeEnd() {
		return nomeEnd;
	}

	public void setNomeEnd(String nomeEnd) {
		this.nomeEnd = nomeEnd;
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<Visitas> getVisitas() {
		return visitas;
	}

	public void setVisitas(List<Visitas> visitas) {
		this.visitas = visitas;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	
}