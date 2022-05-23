package co.com.mundocostenio.services;

import java.io.IOException;

import org.bouncycastle.util.Encodable;
import org.springframework.stereotype.Component;

@Component
public class DefaultEncoreable implements Encodable {

	@Override
	public byte[] getEncoded() throws IOException {
		// TODO Auto-generated method stub
		return new byte[0];
	}

}
