package co.com.mundocostenio.jni;

import org.springframework.stereotype.Component;

@Component
public class ControlCedulaJni {

	static {
		System.loadLibrary("ControlCedulaC");
	}
	public native int controloCedula(int cedula);
}
