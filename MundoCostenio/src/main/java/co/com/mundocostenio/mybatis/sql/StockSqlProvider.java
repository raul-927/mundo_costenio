package co.com.mundocostenio.mybatis.sql;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.model.Stock;

public class StockSqlProvider {
	
	public String insert(List<Stock> stockList) {
		return new SQL() {{
			INSERT_INTO("stock");
			INTO_COLUMNS("prod_id", "cantidad");
			for(Stock stock: stockList) {
				INTO_VALUES(String.valueOf(stock.getProducto().getProdId()), String.valueOf(stock.getCantidad()));
				ADD_ROW();
			}
		}}.toString();
	}
	
	public String update(Stock stock) {
		return new SQL() {{
			UPDATE("stock");
			if(stock.getCantidad() > 0) {
				SET("cantidad = " + String.valueOf(stock.getCantidad()));
			}
			WHERE("stock_id = " +String.valueOf(stock.getStockId()));
		}}.toString();
	}
	
	public String delete(Stock stock) throws SQLException {
		String sql = new SQL() {{
			if(stock.getStockId()!= null && stock.getStockId() > 0) {
				DELETE_FROM("stock");
				WHERE("stock_id = " +String.valueOf(stock.getStockId()));
			}else {
				throw new SQLException("sotock_id no debe ser 0");
			}
		}}.toString();
		return sql;
	}
}
