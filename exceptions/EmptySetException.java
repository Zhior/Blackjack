package exceptions;

public class EmptySetException extends RuntimeException {
  
	public EmptySetException() {
		super ("El set esta vacio.");
	}

   
	public EmptySetException (String message) {
		super (message);
	}
}
