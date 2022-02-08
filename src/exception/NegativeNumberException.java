package exception;

public class NegativeNumberException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private double value;
	public NegativeNumberException(double v) {
		value = v;
	}
	
	@Override
	public String getMessage() {
		return "Excepcion: No se pueden usar numeros negativos. Cambie " + value +  " por un numero positivo";
	}
}
