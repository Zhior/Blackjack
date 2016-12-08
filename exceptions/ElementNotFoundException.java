package exceptions;

public class ElementNotFoundException extends RuntimeException {

	public ElementNotFoundException (String collection) {
		super ("El elemento no se encuentra en " + collection);
	}
}

