//************************************************************
//
//  Card.java          Autores: Lucas Comamala, Lael Villar
//
//  Implementacion de una clase para representar una carta
//
//************************************************************

package main;

import javax.swing.*;

public class Card {

	protected ImageIcon image;
	protected int value;
	protected String suit;
	protected String face;

	/***********************************************************
		Constructor vacio de una carta.
	***********************************************************/
	public Card () {
		image = null;
		value = 0;
		suit = null;
		face = null;
	}

	/***********************************************************
		Constructor de una cartae.
		@param c: la imagen de la carta
		@param v: el valor de la carta
		@param s: el palo de la carta
		@param f: el tipo de la carta
	***********************************************************/
	public Card (ImageIcon c, int v, String s, String f) {
		image = c;
		value = v;
		suit = s;
		face = f;
	}

	public ImageIcon getimage() {
		return image;
	}

	public int getvalue() {
		return value;
	}
	
	public void setvalue (int v) {
		value = v;
	}

	public String getsuit() {
		return suit;
	}

	public String getface() {
		return face;
	}

	public String toString() {
		return "Carta: " + face + " Palo" + suit + " Valor: " + value;
	}

}//end Card
