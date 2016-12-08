//************************************************************
//
//  Hand.Java          Autores: Lucas Comamala, Lael Villar
//
//  Representacion de las cartas en la mano del jugador
//
//************************************************************

package main;

import exceptions.*;
import java.util.*;

public class Hand {

	protected Set<Card> inHand; //Set que contiene las cartas de la mano
	protected int handvalue; //Valor de la mano
	protected int count; //Cantidad de cartas en la mano

	/**********************************************************
		Constructor para Hand
	**********************************************************/
	public Hand () {
		inHand = new HashSet<Card>(12);
		handvalue = 0;
		count = 0;
	}
	
	/**********************************************************
		Anade una nueva carta a la mano
		@param currDeck: el deck actual
	**********************************************************/
	public Card newCard (Deck currDeck) {
		Card result;
		result = currDeck.getCard();
		inHand.add(result);
		handvalue += result.getvalue();
		reduceHand(result); //Intenta reducir la mano
		count++;
		 
		return result;
	}

	/**********************************************************
		Si la mano se pasa de 21 y tiene un as se reduce
		el valor del as.
		@param newCard: una carta al azar del set
	**********************************************************/
	private void reduceHand (Card newCard) {
		if ((handvalue) > 21) {
			if (aceInHand())
				handvalue -= 10;
		}
	}

	/**********************************************************
		Checa si la mano tiene un as
	**********************************************************/
	private boolean aceInHand() {
		boolean result = false;
		
		Card card = null;
		Iterator<Card> scan = inHand.iterator();

		while (scan.hasNext() && !result) {
			card = scan.next();
			
			if (card.getvalue() == 11) {
				card.setvalue(1);
				result = true;
			}
		}
		
		return result;
	}

	/**********************************************************
		Regresa el valor de la mano
	**********************************************************/
	public int getHandValue() {
		return handvalue;
	}

	/**********************************************************
		Nos regresa un iterador para esta mano
	**********************************************************/
	public Iterator<Card> iterator() {
		return inHand.iterator();
	}

	/**********************************************************
		Remueve una carta de la mano
		@param crd: carta que se va a remover
	**********************************************************/
	public Card remove(Card crd) throws ElementNotFoundException {
		//return (inHand.remove(crd));
		
		inHand.remove(crd);
		return crd;
	}
	
	public String toString() {
		String result="";

		Card cardstr = null;
		int i=0;
		Iterator<Card> scan = inHand.iterator();
		
		while (scan.hasNext()) {
			cardstr= scan.next();
			result += "carta" + i + ": " + cardstr.getvalue() + "\n";
			i++;
		}

		return result;
	}

}//end Hand
