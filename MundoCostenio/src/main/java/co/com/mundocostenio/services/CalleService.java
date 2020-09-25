package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.Calle;

public interface CalleService {
	Calle insertCalle(Calle calle);
	Calle updateCalle(Calle calle);
	void deleteCalle(Calle calle);
	List<Calle> showCalle(Calle calle);
}
