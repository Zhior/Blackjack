//************************************************************
//
//  BlackJackGUI.java          Autores: Lucas Comamala, Lael Villar
//
//  Interfaz grafica para un juego de Blackjack
//
//************************************************************

package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class BlackjackGUI extends JPanel {

	/* Bets */
	/*int fondo = 200;
	int bet = 0;*/

	JPanel topPanel = new JPanel();
	JPanel dCardPanel = new JPanel();
	JPanel pCardPanel = new JPanel();
	JPanel countersPanel = new JPanel();
	JPanel betPanel = new JPanel();
	
	JTextPane resultPane = new JTextPane();
	
	JButton hitButton = new JButton();
	JButton dealButton = new JButton();
	JButton stayButton = new JButton();
	JButton playAgainButton = new JButton();
	
	JLabel dealerLabel = new JLabel();
	JLabel playerLabel = new JLabel();

	Hand dealer = new Hand(); //cartas del dealer
	Hand player = new Hand(); //cartas del jugador
	
	int juegosPlayer;
	int juegosDealer;
	
	Blackjack game = new Blackjack(dealer, player); 

	/*************************************************************
		Labels para las cartas del juego
	*************************************************************/
	JLabel playerCard1;
	JLabel playerCard2;
	JLabel playerCardHit;
	JLabel dealerCard0;
	JLabel dealerCard2;
	JLabel dealerCard1;
	JLabel dealerCardHit;
	
	JLabel counters = new JLabel();
	
	/* Bets */
	/*JLabel fondoLabel = new JLabel();
	JLabel betLabel = new JLabel();*/

	/*************************************************************
		Constructor
	*************************************************************/
	public BlackjackGUI () {
	
		juegosPlayer = 0;
		juegosDealer = 0;

		topPanel.setBackground(new Color(0, 122, 0));
		dCardPanel.setBackground(new Color(0, 122, 0));
		pCardPanel.setBackground(new Color(0, 122, 0));
		countersPanel.setBackground(new Color(0, 122, 0));
		betPanel.setBackground(new Color(0, 122, 0));

		topPanel.setLayout(new FlowLayout());
		resultPane.setText(" ");
		resultPane.setFont(new java.awt.Font("Helvetica Bold", 1, 20));
		resultPane.setEditable(false);
		
		dealButton.setText("Deal");
		dealButton.addActionListener(new DealButton());
		
		hitButton.setText("Hit");
		hitButton.addActionListener(new HitButton());
		hitButton.setEnabled(false);
		
		stayButton.setText("Stay");
		stayButton.addActionListener(new StayButton()); 
		stayButton.setEnabled(false);
		
		playAgainButton.setText("Juego Nuevo");
		playAgainButton.addActionListener(new PlayAgainButton());
		playAgainButton.setEnabled(false); 

		dealerLabel.setText("Dealer:");
		playerLabel.setText("Jugador:");
		
		counters.setText("Jugador " + juegosPlayer + "-" + juegosDealer + " Dealer"); 

		topPanel.add(resultPane);
		topPanel.add(dealButton);
		topPanel.add(hitButton);
		topPanel.add(stayButton);
		topPanel.add(playAgainButton);
		pCardPanel.add(playerLabel);
		dCardPanel.add(dealerLabel);
		
		countersPanel.add(counters);
		
		/* Bets */
		/*fondoLabel.setText("Fondo: " + fondo);
		betLabel.setText("Bet: " + bet);
		betPanel.add(fondoLabel);
		betPanel.add(betLabel);*/

		setLayout(new BorderLayout());
		add(topPanel, BorderLayout.PAGE_START);
		add(dCardPanel, BorderLayout.CENTER);
		add(pCardPanel, BorderLayout.PAGE_END);
		add(betPanel, BorderLayout.LINE_START);
		add(countersPanel, BorderLayout.LINE_END);

	} //end BlackjackGUI 

	/*************************************************************
		Muestra la pantalla
	*************************************************************/
	public void display() {
		JFrame myFrame = new JFrame("BlackJack");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setContentPane(this);
		myFrame.setPreferredSize(new Dimension(700,550));

		myFrame.pack();
		myFrame.setVisible(true);

	} //end display
	
	/*************************************************************
		updateCounters
		false = dealer win
		true = player win
	*************************************************************/
	public void updateCounters(boolean ganador) {
	
		 if (ganador)
		 	juegosPlayer++;
		 else
		 	juegosDealer++;
		 	
		 counters.setText("Jugador " + juegosPlayer + "-" + juegosDealer + " Dealer");
	}

	/*************************************************************
		DealButton
	*************************************************************/
	class DealButton implements ActionListener { 
		public void actionPerformed(ActionEvent e) {

			dCardPanel.add(dealerLabel);
			pCardPanel.add(playerLabel);

			dealerCard0 = new JLabel(new ImageIcon("imgs/back.jpg"));

			game.dealInicial();
			
			Card dcard = null;
			
			Iterator<Card> dscan = (dealer.inHand).iterator();
			int count = 0;
			
			while (dscan.hasNext()) {
				dcard = dscan.next();
				if(count==0)
					dealerCard1 = new JLabel(dcard.getimage());
				else 
					dealerCard2 = new JLabel(dcard.getimage());

				count++;
			}

			Iterator<Card> pscan = (player.inHand).iterator();
			count = 0;
			while (pscan.hasNext()) {
				Card pcard = pscan.next();
				if(count==0)
				playerCard1 = new JLabel(pcard.getimage());
				else
				playerCard2 = new JLabel(pcard.getimage());
				 
				count++;
			}
			 
			dCardPanel.add(dealerCard0);
			dCardPanel.add(dealerCard2);
			 
			pCardPanel.add(playerCard1);
			pCardPanel.add(playerCard2);

			dealerLabel.setText("Dealer:"+ dcard.getvalue());
			playerLabel.setText("Jugador:" + game.handValue(player));

			hitButton.setEnabled(true);
			stayButton.setEnabled(true);
			dealButton.setEnabled(false);

			if(game.blackj()) {
				updateCounters(true);
				hitButton.setEnabled(false);
				stayButton.setEnabled(false);
				dealButton.setEnabled(false);
				playAgainButton.setEnabled(true);
				resultPane.setText("BlackJack");
			}

			add(dCardPanel,BorderLayout.CENTER);
			add(pCardPanel,BorderLayout.PAGE_END);

		}
	}//end dealbutton

	/*************************************************************
		HitButton
	*************************************************************/
	class HitButton implements ActionListener { 
		public void actionPerformed(ActionEvent e) {


		Card hitcard = game.hit(player);
		playerCardHit = new JLabel(hitcard.getimage());
		pCardPanel.add(playerCardHit);
		pCardPanel.repaint();
		 
		if(game.bust(player)) {
			updateCounters(false);
			resultPane.setText("Bust");
			hitButton.setEnabled(false);
			dealButton.setEnabled(false);
			stayButton.setEnabled(false);
			playAgainButton.setEnabled(true);
		}

		playerLabel.setText("Jugador: " + game.handValue(player));

		}
	}//end hitbutton

	/*************************************************************
		StayButton
	*************************************************************/
	class StayButton implements ActionListener { 
			public void actionPerformed(ActionEvent e) {

			dCardPanel.remove(dealerCard0);
			dCardPanel.add(dealerCard1);

			dealer = game.dealerPlays();
			dCardPanel.removeAll();
			dCardPanel.add(dealerLabel);
			dealerLabel.setText(" " + dealerLabel.getText());

			Card dhitcard = null;
			Iterator<Card> scan = (dealer.inHand).iterator();
			while ( scan.hasNext() ) {
				dhitcard = scan.next();
				dealerCardHit = new JLabel(dhitcard.getimage());
				dCardPanel.add(dealerCardHit);
			}

			dealerLabel.setText("Dealer: " + game.handValue(dealer));
			playerLabel.setText("Jugador: " + game.handValue(player));

			if (game.ganador() == 1)
				updateCounters(false);
			else if (game.ganador() == 2)
				updateCounters(true);
			
			resultPane.setText(game.ganadorToString());
			hitButton.setEnabled(false);
			stayButton.setEnabled(false);

			playAgainButton.setEnabled(true);

		}
	}//end staybutton

	/*************************************************************
		PlayAgainButton
	*************************************************************/
	class PlayAgainButton implements ActionListener { 
		public void actionPerformed(ActionEvent e) {

			dealerLabel.setText("Dealer: ");
			playerLabel.setText("Jugador: ");
			resultPane.setText(""); 
			dealer = new Hand();
			player = new Hand();
			game = new Blackjack(dealer, player);

			dCardPanel.removeAll();
			pCardPanel.removeAll();

			hitButton.setEnabled(false);
			stayButton.setEnabled(false);
			playAgainButton.setEnabled(false);
			dealButton.setEnabled(true);

		}
	}//end playagainbutton
	
}//end BlackjackGUI
