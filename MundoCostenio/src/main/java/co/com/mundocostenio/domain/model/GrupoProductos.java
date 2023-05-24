package co.com.mundocostenio.domain.model;

import java.io.Serializable;
import java.util.List;

public class GrupoProductos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer			id;
	private Integer 		grupProdId;
	private List<Producto>	productos;
	private ListaPrecios	listaPrecios;
	private Asiento 		asiento;
	
	public Integer getId() {
		id = grupProdId;
		return id;
	}
	public Integer getGrupProdId() {
		return grupProdId;
	}
	public void setGrupProdId(Integer grupProdId) {
		this.grupProdId = grupProdId;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public ListaPrecios getListaPrecios() {
		return listaPrecios;
	}
	public void setListaPrecios(ListaPrecios listaPrecios) {
		this.listaPrecios = listaPrecios;
	}
	public Asiento getAsiento() {
		return asiento;
	}
	public void setAsiento(Asiento asiento) {
		this.asiento = asiento;
	}

}
