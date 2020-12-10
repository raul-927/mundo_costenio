package co.com.mundocostenio.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.Asiento;
import co.com.mundocostenio.domain.Cuenta;
import co.com.mundocostenio.domain.ListaPrecios;
import co.com.mundocostenio.domain.Pago;
import co.com.mundocostenio.domain.PrecioProducto;
import co.com.mundocostenio.domain.Producto;
import co.com.mundocostenio.mybatis.mappers.AsientoMapper;

@Service("asientoService")
public class AsientoServiceImpl implements AsientoService {
	
	@Autowired
	private AsientoMapper asientoMapper;
	
	@Autowired
	private ListaPreciosService listaPreciosService;
	
	private BigDecimal 	total = new BigDecimal("00");

	@Override
	@Transactional
	public List<Asiento> insert(Pago pago, Producto producto) {
		ListaPrecios listaPreciosActual = this.listaPreciosService.selectActualListaPrecios();
		Cuenta cuentaL1 = pago.getCuenta();
		BigDecimal montoDebeL1 = null;
		BigDecimal montoHaberL1 = new BigDecimal(00);
		Cuenta cuentaImpuesto = producto.getImpuesto().getCuentaImpuesto();
		for(PrecioProducto precProd: listaPreciosActual.getPrecioProductoList()) {
			if(producto.getProdId() == precProd.getProducto().getProdId()) {
				montoDebeL1 = new BigDecimal((double)precProd.getMonto());
			}
		}
		Integer maxNroAsiento = this.selectMaxNroAsiento();
		if(maxNroAsiento == null) {
			maxNroAsiento = 0;
		}
		Asiento asL1 = new Asiento();
		Asiento asL2 = new Asiento();
		Asiento asL3 = new Asiento();
		
		asL1.setAsientoNro(maxNroAsiento);
		asL2.setAsientoNro(maxNroAsiento);
		asL3.setAsientoNro(maxNroAsiento);
		
		BigDecimal asImpDebeMonto = new BigDecimal("00");
		BigDecimal impuesto = producto.getImpuesto().getImpuestoValor();
		BigDecimal aux = montoDebeL1.multiply(impuesto);
		BigDecimal divisor = new BigDecimal("100.00");
		BigDecimal resultado = aux.divide(divisor);
		BigDecimal asImpHaberMonto = new BigDecimal("00");
		this.total = montoDebeL1.multiply(impuesto);
		asImpHaberMonto.add(resultado);
		
		List<Asiento> asientoList = new ArrayList<Asiento>();
		
		asL1.setMontoDebe(montoDebeL1); 
		asL1.setMontoHaber(montoHaberL1);
		asL1.setCuentaDebe(cuentaL1);
		asL1.setCuentaHaber(cuentaL1);
		asL1.setTipoCuenta(cuentaL1.getTipoCuenta());
		asL1.setDescripcion(cuentaL1.getCuentaDesc());
		
		asL2.setCuentaDebe(cuentaImpuesto);
		asL2.setCuentaHaber(cuentaImpuesto);
		asL2.setMontoDebe(asImpDebeMonto);
		asL2.setMontoHaber(resultado);
		asL2.setTipoCuenta(cuentaImpuesto.getTipoCuenta());
		asL2.setDescripcion(cuentaImpuesto.getCuentaDesc());
		
		asL3.setCuentaDebe(producto.getTipoProducto().getCuenta());
		asL3.setCuentaHaber(producto.getTipoProducto().getCuenta());
		asL3.setMontoDebe(asImpDebeMonto);
		asL3.setMontoHaber(this.total);
		asL3.setTipoCuenta(producto.getTipoProducto().getCuenta().getTipoCuenta());
		asL3.setDescripcion(producto.getTipoProducto().getCuenta().getCuentaDesc());
		
		asientoList.add(asL1);
		asientoList.add(asL2);
		asientoList.add(asL3);
		
		List<Asiento>asResult = new ArrayList<Asiento>();
		for(Asiento as: asientoList) {
			this.asientoMapper.insert(as);
			asResult.add(as);
		}
		return asResult;
	}

	@Override
	@Transactional
	public Asiento update(Asiento asiento) {
		this.asientoMapper.update(asiento);
		return asiento;
	}

	@Override
	public List<Asiento> select(Asiento asiento) {
		return this.asientoMapper.select(asiento);
	}

	private Integer selectMaxNroAsiento() {
		Integer maxNroAsiento = this.asientoMapper.selectMaxNroAsiento();
		if(maxNroAsiento == null || maxNroAsiento == 0) {
			maxNroAsiento = 1;
		}
		return maxNroAsiento;
	}

	
}