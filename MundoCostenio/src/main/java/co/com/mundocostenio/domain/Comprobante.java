package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.util.List;

public class Comprobante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 							comprobanteId;
	private CabeceraComprobante 			cabeceraComprobante;
	private List<LineaContenidoComprobante>	lineas;
	
	

}
