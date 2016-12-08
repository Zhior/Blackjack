//************************************************************
//
//  Deck.Java          Autores: Lucas Comamala, Lael Villar
//
//  Implementacion de un deck de cartas
//
//************************************************************

package main;

import java.util.*;
import javax.swing.*;


public class Deck {

	Set<Card> deckSet = new HashSet<Card>();

	/**********************************************************
		Construye el deck de cartas
	**********************************************************/
	public Deck () {
		
		//Espadas		
		deckSet.add(new Card(new ImageIcon("imgs/2s.jpg"), 2, "espada", "Dos"));
		deckSet.add(new Card(new ImageIcon("imgs/3s.jpg"), 3, "espada", "Tres"));		
		deckSet.add(new Card(new ImageIcon("imgs/4s.jpg"), 4, "espada", "Cuatro"));
		deckSet.add(new Card(new ImageIcon("imgs/5s.jpg"), 5, "espada", "Cinco"));
		deckSet.add(new Card(new ImageIcon("imgs/6s.jpg"), 6, "espada", "Seis"));
		deckSet.add(new Card(new ImageIcon("imgs/7s.jpg"), 7, "espada", "Siete"));
		deckSet.add(new Card(new ImageIcon("imgs/8s.jpg"), 8, "espada", "Ocho"));
		deckSet.add(new Card(new ImageIcon("imgs/9s.jpg"), 9, "espada", "Nueve"));
		deckSet.add(new Card(new ImageIcon("imgs/10s.jpg"), 10, "espada", "Diez"));
		deckSet.add(new Card(new ImageIcon("imgs/jacks.jpg"), 10, "espada", "Joto"));
		deckSet.add(new Card(new ImageIcon("imgs/queens.jpg"), 10, "espada", "Reina"));
		deckSet.add(new Card(new ImageIcon("imgs/kings.jpg"), 10, "espada", "Rey"));
		deckSet.add(new Card(new ImageIcon("imgs/aces.jpg"), 11, "espada", "As"));
		
		//Corazones
		deckSet.add(new Card(new ImageIcon("imgs/2h.jpg"), 2, "corazon", "Dos"));
		deckSet.add(new Card(new ImageIcon("imgs/3h.jpg"), 3, "corazon", "Tres"));		
		deckSet.add(new Card(new ImageIcon("imgs/4h.jpg"), 4, "corazon", "Cuatro"));
		deckSet.add(new Card(new ImageIcon("imgs/5h.jpg"), 5, "corazon", "Cinco"));
		deckSet.add(new Card(new ImageIcon("imgs/6h.jpg"), 6, "corazon", "Seis"));
		deckSet.add(new Card(new ImageIcon("imgs/7h.jpg"), 7, "corazon", "Siete"));
		deckSet.add(new Card(new ImageIcon("imgs/8h.jpg"), 8, "corazon", "Ocho"));
		deckSet.add(new Card(new ImageIcon("imgs/9h.jpg"), 9, "corazon", "Nueve"));
		deckSet.add(new Card(new ImageIcon("imgs/10h.jpg"), 10, "corazon", "Diez"));
		deckSet.add(new Card(new ImageIcon("imgs/jackh.jpg"), 10, "corazon", "Joto"));
		deckSet.add(new Card(new ImageIcon("imgs/queenh.jpg"), 10, "corazon", "Reina"));
		deckSet.add(new Card(new ImageIcon("imgs/kingh.jpg"), 10, "corazon", "Rey"));
		deckSet.add(new Card(new ImageIcon("imgs/aceh.jpg"), 11, "corazon", "As"));
		
		//Diamantes
		deckSet.add(new Card(new ImageIcon("imgs/2d.jpg"), 2, "diamante", "Dos"));
		deckSet.add(new Card(new ImageIcon("imgs/3d.jpg"), 3, "diamante", "Tres"));		
		deckSet.add(new Card(new ImageIcon("imgs/4d.jpg"), 4, "diamante", "Cuatro"));
		deckSet.add(new Card(new ImageIcon("imgs/5d.jpg"), 5, "diamante", "Cinco"));
		deckSet.add(new Card(new ImageIcon("imgs/6d.jpg"), 6, "diamante", "Seis"));
		deckSet.add(new Card(new ImageIcon("imgs/7d.jpg"), 7, "diamante", "Siete"));
		deckSet.add(new Card(new ImageIcon("imgs/8d.jpg"), 8, "diamante", "Ocho"));
		deckSet.add(new Card(new ImageIcon("imgs/9d.jpg"), 9, "diamante", "Nueve"));
		deckSet.add(new Card(new ImageIcon("imgs/10d.jpg"), 10, "diamante", "Diez"));
		deckSet.add(new Card(new ImageIcon("imgs/jackd.jpg"), 10, "diamante", "Joto"));
		deckSet.add(new Card(new ImageIcon("imgs/queend.jpg"), 10, "diamante", "Reina"));
		deckSet.add(new Card(new ImageIcon("imgs/kingd.jpg"), 10, "diamante", "Rey"));
		deckSet.add(new Card(new ImageIcon("imgs/aced.jpg"), 11, "diamante", "As"));
		
		//Treboles
		deckSet.add(new Card(new ImageIcon("imgs/2c.jpg"), 2, "trebol", "Dos"));
		deckSet.add(new Card(new ImageIcon("imgs/3c.jpg"), 3, "trebol", "Tres"));		
		deckSet.add(new Card(new ImageIcon("imgs/4c.jpg"), 4, "trebol", "Cuatro"));
		deckSet.add(new Card(new ImageIcon("imgs/5c.jpg"), 5, "trebol", "Cinco"));
		deckSet.add(new Card(new ImageIcon("imgs/6c.jpg"), 6, "trebol", "Seis"));
		deckSet.add(new Card(new ImageIcon("imgs/7c.jpg"), 7, "trebol", "Siete"));
		deckSet.add(new Card(new ImageIcon("imgs/8c.jpg"), 8, "trebol", "Ocho"));
		deckSet.add(new Card(new ImageIcon("imgs/9c.jpg"), 9, "trebol", "Nueve"));
		deckSet.add(new Card(new ImageIcon("imgs/10c.jpg"), 10, "trebol", "Diez"));
		deckSet.add(new Card(new ImageIcon("imgs/jackc.jpg"), 10, "trebol", "Joto"));
		deckSet.add(new Card(new ImageIcon("imgs/queenc.jpg"), 10, "trebol", "Reina"));
		deckSet.add(new Card(new ImageIcon("imgs/kingc.jpg"), 10, "trebol", "Rey"));
		deckSet.add(new Card(new ImageIcon("imgs/acec.jpg"), 11, "diamante", "As"));

	}
	
	/**********************************************************
		Regresa una carta al azar del Deck
	**********************************************************/
	public Card getCard() {
		
		int size = deckSet.size();
		int item = new Random().nextInt(size);
		int i = 0;
		
		for(Card obj : deckSet)
		{
		    if (i == item)
		        return obj;
		    i = i + 1;
		}
		
		return null;
		
		/*Card result = new Card();
		result = deckSet.removeRandom();

		return result;*/
	}

}//end Deck
