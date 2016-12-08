//************************************************************
//
//  Blackjack.Java          Autores: Lucas Comamala, Lael Villar
//
//  Controlador principal para el juego de Blackjack
//
//************************************************************

package main;

import exceptions.*;
import java.util.*;

public class Blackjack {

	Hand dealer;  //mano del dealer
	Hand player;  //mano del jugador
	Deck newDeck; //el Deck

	/***********************************************************
		Constructor Blackjack
		Inicializa un nuevo juejo de blackjack
	***********************************************************/
	public Blackjack (Hand d, Hand p) {
		dealer = d;
		player = p;
		newDeck = new Deck();
	}

	/***********************************************************
		Hace el reparto inicial de dos cartas al jugador y
		dos	al dealer
	***********************************************************/
	public void dealInicial() { 
		dealer.newCard(newDeck);
		dealer.newCard(newDeck);

		player.newCard(newDeck);
		player.newCard(newDeck);
	}

	/***********************************************************
		Agrega una nueva carta a una mano
		Regresa la carta que se anadio a la mano
		@param mano: mano que pidio la carta (jugador o dealer)
	***********************************************************/
	public Card hit (Hand mano) {
		Card result = mano.newCard(newDeck);
		return result;
	}

	/***********************************************************
		Regresa el valor de una mano
		@param mano: mano de la que vamos a calcular el valor
	***********************************************************/
	public int handValue (Hand mano) {
		int result = mano.getHandValue();
		return result;
	}

	/***********************************************************
		Descarta una carta de la mano
		Avienta una excepcion si esa carta no esta en la mano
		@param mano: mano de la cual se va a descartar
		@param cartaDisc: carta que se va a descartar
	************************************************************/
	public void discard (Hand mano, Card cartaDisc) throws ElementNotFoundException {
		Card card = null;
		boolean found = false;
		Iterator<Card> handItr = mano.iterator();
		
		while (handItr.hasNext() && !found) {
			card = handItr.next();
			
			if (cartaDisc.equals(card)) {
				mano.remove(card);
				found = true;
			}
		}
		
		if(!found)
			throw new ElementNotFoundException("BlackJack");

	}

	/***********************************************************
		Checa si el jugador tiene 21
	***********************************************************/
	public boolean blackj() {
		boolean result = false;

		if (player.getHandValue() == 21)
			result = true;

		return result;
	}

	/***********************************************************
		Checa si la mano se pasa de 21
		@param mano: mano que estamos checando
	***********************************************************/
	public boolean bust (Hand mano) {
		boolean result = false;

		if(mano.getHandValue() > 21)
			result = true;

		return result;

	}

	/***********************************************************
		Agrega cartas a la mano del dealer hasta que llegue o
		se pase de 16
	***********************************************************/
	public Hand dealerPlays() {
		Hand result = dealer;

		while(dealer.getHandValue() <= 16)
			dealer.newCard(newDeck);
		
		return result;
	}
	
	/***********************************************************
		Determina el ganador del juego
		0 = empate
		1= gana dealer
		2 = gana jugador
	***********************************************************/
	public int ganador() {
	
		int result = 0;
		
		if ((player.getHandValue() < dealer.getHandValue()) && dealer.getHandValue() <= 21 ) 
			result = 1;
		
		else if ((player.getHandValue() == dealer.getHandValue()) && dealer.getHandValue() <= 21 )
			result = 0;
		
		else
			result = 2;

		return result;	 
	}

	/***********************************************************
		Determina el ganador del juego y lo pone en un String
	***********************************************************/
	public String ganadorToString() {
	
		String result = "";
		
		if ((player.getHandValue() < dealer.getHandValue()) && dealer.getHandValue() <= 21 ) 
			result = "Gana el dealer";
		
		else if ((player.getHandValue() == dealer.getHandValue()) && dealer.getHandValue() <= 21 )
			result = "Empate";
		
		else
			result = "Gana el jugador";

		return result;	 
	}
	
}//end Blackjack
