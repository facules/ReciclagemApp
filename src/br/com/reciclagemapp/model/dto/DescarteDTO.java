package br.com.reciclagemapp.model.dto;

import java.util.Date;

public class DescarteDTO {

	private int idUsuario;
	
	private int idProduto;
	
	private String descricaoProduto;
	
	private int idTipoDescarte;
	
	private String descricaoTipoDescarte;
	
	private Date descarte;
	
	private Integer quantidade;
	
	private String motivo;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getIdTipoDescarte() {
		return idTipoDescarte;
	}

	public void setIdTipoDescarte(int idTipoDescarte) {
		this.idTipoDescarte = idTipoDescarte;
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

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public String getDescricaoTipoDescarte() {
		return descricaoTipoDescarte;
	}

	public void setDescricaoTipoDescarte(String descricaoTipoDescarte) {
		this.descricaoTipoDescarte = descricaoTipoDescarte;
	}
}