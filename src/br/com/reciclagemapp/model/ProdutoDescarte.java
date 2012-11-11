package br.com.reciclagemapp.model;

import java.util.Date;

public class ProdutoDescarte {
	
	private int id;

	private Usuario usuario;

	private Produto produto;

	private TipoDescarte tipoDescarte;

	private Date descarte;

	private Integer quantidade;

	private String motivo;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public TipoDescarte getTipoDescarte() {
		return tipoDescarte;
	}

	public void setTipoDescarte(TipoDescarte tipoDescarte) {
		this.tipoDescarte = tipoDescarte;
	}

	public Date getDescarte() {
		return descarte;
	}

	public void setDescarte(Date descarte) {
		this.descarte = descarte;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}