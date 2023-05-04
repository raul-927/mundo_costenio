package co.com.mundocostenio.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.Asiento;
import co.com.mundocostenio.domain.Caja;
import co.com.mundocostenio.domain.Cuenta;
import co.com.mundocostenio.domain.ListaPrecios;
import co.com.mundocostenio.domain.Pago;
import co.com.mundocostenio.domain.PrecioProducto;
import co.com.mundocostenio.domain.Producto;
import co.com.mundocostenio.enumerator.TipoCuentaEnum;
import co.com.mundocostenio.enumerator.TipoFormaPago;
import co.com.mundocostenio.mybatis.mappers.AsientoMapper;
import co.com.mundocostenio.mybatis.mappers.CajaMapper;
import co.com.mundocostenio.mybatis.mappers.CuentaMapper;

@Service("asientoService")
public class AsientoServiceImpl implements AsientoService {
	
	@Autowired
	private AsientoMapper asientoMapper;
	
	@Autowired
	private CajaMapper cajaMapper;
	
	@Autowired
	private CuentaMapper cuentaMapper;
	
	@Autowired
	private ListaPreciosService listaPreciosService;
	
	private BigDecimal 	total = new BigDecimal("00");

	@Override
	@Transactional
	public List<Asiento> insert(Pago pago, Producto producto) {
		if(pago.getTarjeta()!=null) {
			
		}
		List<Asiento> returnAsiento = this.pagoContado(pago, producto);
		return returnAsiento;
	}
	private List<Asiento> pagoContado(Pago pago, Producto producto){
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
	public void ingresarAsientoContable(Pago pago) {
		Caja cajaActual  = this.cajaMapper.cargoCajaActual();
		ListaPrecios listaPreciosActual = this.listaPreciosService.selectActualListaPrecios();
		Cuenta cuentaL1 = pago.getCuenta();
		BigDecimal montoDebeL1 = new BigDecimal(00);
		BigDecimal montoHaberL1 = new BigDecimal(00);
		Cuenta cuentaImpuesto = pago.getProducto().getImpuesto().getCuentaImpuesto();
		for(PrecioProducto precProd: listaPreciosActual.getPrecioProductoList()) {
			if(pago.getProducto().getProdId() == precProd.getProducto().getProdId()) {
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
		BigDecimal impuesto = pago.getProducto().getImpuesto().getImpuestoValor();
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
		
		asL3.setCuentaDebe(pago.getProducto().getTipoProducto().getCuenta());
		asL3.setCuentaHaber(pago.getProducto().getTipoProducto().getCuenta());
		asL3.setMontoDebe(asImpDebeMonto);
		asL3.setMontoHaber(this.total);
		asL3.setTipoCuenta(pago.getProducto().getTipoProducto().getCuenta().getTipoCuenta());
		asL3.setDescripcion(pago.getProducto().getTipoProducto().getCuenta().getCuentaDesc());
		
		asientoList.add(asL1);
		asientoList.add(asL2);
		asientoList.add(asL3);
		
		List<Asiento>asResult = new ArrayList<Asiento>();
		for(Asiento as: asientoList) {
			this.asientoMapper.insert(as);
			asResult.add(as);
		}

		int cuentaId = pago.getCuenta().getCuentaId();
		int maxNumAsientoContable = this.asientoMapper.selectMaxNroAsiento();
		switch (pago.getTipoFormaPago()) {
		case EF:
			pagoEfectivo(pago, cajaActual, maxNumAsientoContable);
			break;
		case TC:
			//pagoTarjetaCredito(pago, cajaActual, maxNumAsientoContable);
			break;
		case CE:
			//pagoCreditoEfectivo(pago, cajaActual, maxNumAsientoContable);
			break;
		case DP:
			pagoDepositoBancario(pago, cajaActual, maxNumAsientoContable);
			break;
		}
		ArrayList<Asiento> asientoContableList = new ArrayList<Asiento>();
		List<Cuenta> asCuentaL1 = this.cuentaMapper.select(pago.getCuenta());
		BigDecimal asCuentaDebeMontoL1 = pago.getImporte();
		BigDecimal asCuentaHaberMontoL1 = new BigDecimal((double)00);
		
		Producto prod = pago.getProducto();//this.productoMapper.findTratamientoById(tratamientoPaciente.getTratamId());
		List<Cuenta> cuentaImp = this.cuentaMapper.select(prod.getImpuesto().getCuentaImpuesto());
		
		Cuenta cuentaProducto = new Cuenta();
		cuentaProducto.setCuentaId(pago.getCuenta().getCuentaId());
		cuentaProducto.setCuentaDesc(prod.getNombre());
		cuentaProducto.setTipoCuenta(TipoCuentaEnum.PRODUCTO);
	
		
		int asConNro = this.asientoMapper.selectMaxNroAsiento();
		Asiento asientoContableL1 = new Asiento();
		Asiento asientoContableL2 = new Asiento();
		Asiento asientoContableL3 = new Asiento();
		
		asientoContableL1.setAsientoNro(asConNro);
		asientoContableL2.setAsientoNro(asConNro);
		asientoContableL3.setAsientoNro(asConNro);
		
		asientoContableL1.setCaja(cajaActual);
		asientoContableL2.setCaja(cajaActual);
		asientoContableL3.setCaja(cajaActual);
		
		this.total = asCuentaDebeMontoL1.subtract(resultado);
		asImpHaberMonto.add(resultado);

		asientoContableL1.setCuentaDebe(asCuentaL1.get(0));
		asientoContableL1.setCuentaHaber(asCuentaL1.get(0));
		asientoContableL1.setMontoDebe(asCuentaDebeMontoL1);
		asientoContableL1.setMontoHaber(asCuentaHaberMontoL1);
		asientoContableL1.setDescripcion(asCuentaL1.get(0).getCuentaDesc());
		asientoContableL1.setTipoCuenta(asCuentaL1.get(0).getTipoCuenta());

		asientoContableL2.setCuentaDebe(cuentaImp.get(0));
		asientoContableL2.setCuentaHaber(cuentaImp.get(0));
		asientoContableL2.setMontoDebe(asImpDebeMonto);
		asientoContableL2.setMontoHaber(resultado);
		asientoContableL2.setDescripcion(cuentaImp.get(0).getCuentaDesc());
		asientoContableL2.setTipoCuenta(cuentaImp.get(0).getTipoCuenta());

		asientoContableL3.setCuentaDebe(cuentaProducto);
		asientoContableL3.setCuentaHaber(cuentaProducto);	
		asientoContableL3.setMontoDebe(asImpDebeMonto);
		asientoContableL3.setMontoHaber(total);
		asientoContableL3.setDescripcion(cuentaProducto.getCuentaDesc());
		asientoContableL3.setTipoCuenta(cuentaProducto.getTipoCuenta());
	
		asientoContableList.add(asientoContableL1);
		asientoContableList.add(asientoContableL2);
		asientoContableList.add(asientoContableL3);
		
		Iterator<Asiento> it = asientoContableList.iterator();
		
		while(it.hasNext()){
			this.asientoMapper.insert(it.next());
		}	
	}
	
	private void pagoEfectivo(Pago pago, Caja cajaActual, int maxNumAsientoContable) {
		
		
		
		
		//String desCuentaFormaDePago = this.formasDePagosService.cuentaFormaDePagoDesc(pago.getCuenta().getCuentaId());
		//String pagoEfCuenta = desCuentaFormaDePago;
		pago.setCaja(cajaActual);
		//pago.setCuenta(pagoEfCuenta);
		//pago.setAsiento(maxNumAsientoContable);
		//this.formasDePagosService.insertTratamientoPagoEfectivo(tratamientoPaciente, (PagoEfectivo) formaDePago, formasDePagoDesc.getFormasDePagoCuenta());
	}
	
	/*private void pagoTarjetaCredito(Pago pago, Caja cajaActual, int maxNumAsientoContable) {
		DescCuentaFormaDePago desCuentaFormaDePago = this.formasDePagosService.cuentaFormaDePagoDesc(cuentaId);
		String pagoTarjCuenta = desCuentaFormaDePago.getCuentaDesc();
		((PagoTarjeta) formaDePago).setTarjetaCajaId(cajaActual.getCajaId());
		((PagoTarjeta) formaDePago).setTarjCuenta(pagoTarjCuenta);
		((PagoTarjeta) formaDePago).setAsientoNro(maxNumAsientoContable.getMaxNum());
		this.formasDePagosService.insertTratamientoPagoTarjeta(tratamientoPaciente,(PagoTarjeta) formaDePago, formasDePagoDesc.getFormasDePagoCuenta());
	}*/
	
	/*private void pagoCreditoEfectivo(Pago pago, Caja cajaActual, int maxNumAsientoContable) {
		DescCuentaFormaDePago desCuentaFormaDePago = this.formasDePagosService.cuentaFormaDePagoDesc(cuentaId);
		String pagoEfCuenta = desCuentaFormaDePago.getCuentaDesc();
		((PagoCredito) formaDePago).setPagoEfCajaId(cajaActual.getCajaId());
		((PagoCredito) formaDePago).setPagoEfCuenta(pagoEfCuenta);
		((PagoCredito) formaDePago).setAsientoNro(maxNumAsientoContable.getMaxNum());
		this.formasDePagosService.insertTratamientoPagoEfectivo(tratamientoPaciente, (PagoCredito) formaDePago, formasDePagoDesc.getFormasDePagoCuenta());
	}*/
	
	private void pagoDepositoBancario(Pago pago, Caja cajaActual, int maxNumAsientoContable) {
		
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