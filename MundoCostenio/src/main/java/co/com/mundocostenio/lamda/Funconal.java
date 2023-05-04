package co.com.mundocostenio.lamda;


@FunctionalInterface
public interface Funconal {
	default void saluda() {
		System.out.println("Un saludo!");
	}
	public abstract int calcula(int dato1, int dato2);
}
