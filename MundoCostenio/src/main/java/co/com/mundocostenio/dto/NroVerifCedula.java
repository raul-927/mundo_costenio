package co.com.mundocostenio.dto;

import java.util.InputMismatchException;

public abstract class NroVerifCedula {
	
	private int numero;
	
	public boolean nroCedula(int value){
		boolean control = false;
		if(value >0){
			try{
				
				numero = value;
				int suma=0;
				int total =0;
				
				int control8 = 3;
				int control7 = 2;
				int control6 = 9;
				int control5 = 8;
				int control4 = 7;
				int control3 = 6;
				int control2 = 3;
				int control1 = 4;
				
				int valor1 = numero % 10;
				int valor2 = numero % 100;
				int valor3 = numero % 1000;
				int valor4 = numero % 10000;
				int valor5 = numero % 100000;
				int valor6 = numero % 1000000;
				int valor7 = numero % 10000000;
				int valor8 = numero % 100000000;
				int valor9 = numero % 1000000000;
				
				//suma += (valor1 * control1);
				suma += ((valor2 - valor1)/10) 		  *	control1;
				suma += ((valor3 - valor2)/100)       *	control2;
				suma += ((valor4 - valor3)/1000)      *	control3;
				suma += ((valor5 - valor4)/10000)     *	control4;
				suma += ((valor6 - valor5)/100000)    *	control5;
				suma += ((valor7 - valor6)/1000000)   *	control6;
				suma += ((valor8 - valor7)/10000000)  *	control7;
				suma += ((valor9 + valor8)/100000000) * control8;
				
				
				total = 10 -(suma%10);
				if(valor1 == total){
					control = true;
				}
			}
			catch (InputMismatchException e){
			
				System.out.println("Ingrese un valor numerico valido");
				control = false;
			}
			catch(NumberFormatException e){
				System.out.println("Ingrese un valor numerico valido");
				control = false;
			}
		}
		else{
			control = true;
		}
	
		
	return control;
	}
	
}
