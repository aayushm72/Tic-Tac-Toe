package TicTacToeGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;

public class Application {

	private JFrame frmTicTacToe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frmTicTacToe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

 GameType game;
 
 interface Myfun {
	 void fun();
	 void fun2(int a);
 }
	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTicTacToe = new JFrame();
		frmTicTacToe.setBackground(new Color(204, 153, 51));
		frmTicTacToe.getContentPane().setBackground(new Color(204, 204, 102));
		frmTicTacToe.setResizable(false);
		frmTicTacToe.setTitle("Tic Tac Toe");
		frmTicTacToe.setBounds(200, 100, 750, 500);
		frmTicTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTicTacToe.getContentPane().setLayout(null);
		
		Button button1 = new Button("");
		button1.setForeground(new Color(153, 0, 51));
		button1.setFont(new Font("Baskerville Old Face", Font.BOLD, 63));
		button1.setEnabled(false);
		button1.setBounds(32, 62, 118, 102);
		frmTicTacToe.getContentPane().add(button1);
		
		Button button2 = new Button("");
		button2.setFont(new Font("Baskerville Old Face", Font.BOLD, 63));
		button2.setEnabled(false);
		button2.setBounds(156, 62, 118, 102);
		frmTicTacToe.getContentPane().add(button2);
		
		Button button3 = new Button("");
		button3.setFont(new Font("Baskerville Old Face", Font.BOLD, 63));
		button3.setEnabled(false);
		button3.setBounds(280, 62, 118, 102);
		frmTicTacToe.getContentPane().add(button3);
		
		Button button4 = new Button("");
		button4.setFont(new Font("Baskerville Old Face", Font.BOLD, 63));
		button4.setEnabled(false);
		button4.setBounds(32, 170, 118, 102);
		frmTicTacToe.getContentPane().add(button4);
		
		Button button5 = new Button("");
		button5.setFont(new Font("Baskerville Old Face", Font.BOLD, 63));
		button5.setEnabled(false);
		button5.setBounds(156, 170, 118, 102);
		frmTicTacToe.getContentPane().add(button5);
		
		Button button6 = new Button("");
		button6.setFont(new Font("Baskerville Old Face", Font.BOLD, 63));
		button6.setEnabled(false);
		button6.setBounds(280, 170, 118, 102);
		frmTicTacToe.getContentPane().add(button6);
		
		Button button7 = new Button("");
		button7.setFont(new Font("Baskerville Old Face", Font.BOLD, 63));
		button7.setEnabled(false);
		button7.setBounds(32, 278, 118, 102);
		frmTicTacToe.getContentPane().add(button7);
		
		Button button8 = new Button("");
		button8.setFont(new Font("Baskerville Old Face", Font.BOLD, 63));
		button8.setEnabled(false);
		button8.setBounds(156, 278, 118, 102);
		frmTicTacToe.getContentPane().add(button8);
		
		Button button9 = new Button("");
		button9.setFont(new Font("Baskerville Old Face", Font.BOLD, 63));
		button9.setEnabled(false);
		button9.setBounds(280, 278, 118, 102);
		frmTicTacToe.getContentPane().add(button9);
		
		Button button = new Button("Single Player");
		button.setFont(new Font("Baskerville Old Face", Font.BOLD, 28));
		button.setBounds(473, 62, 202, 46);
		frmTicTacToe.getContentPane().add(button);
		
		Button button_1 = new Button("Double Player");

		button_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 28));
		button_1.setBounds(473, 114, 202, 50);
		frmTicTacToe.getContentPane().add(button_1);
		
		Myfun reset = new Myfun(){
			public void fun(){
				button.setEnabled(true);
				button_1.setEnabled(true);
				button1.setLabel("");
				button1.setEnabled(false);
				button2.setLabel("");
				button2.setEnabled(false);
				button3.setLabel("");
				button3.setEnabled(false);
				button4.setLabel("");
				button4.setEnabled(false);
				button5.setLabel("");
				button5.setEnabled(false);
				button6.setLabel("");
				button6.setEnabled(false);
				button7.setLabel("");
				button7.setEnabled(false);
				button8.setLabel("");
				button8.setEnabled(false);
				button9.setLabel("");
				button9.setEnabled(false);
				game.reset();
			}
			public void fun2(int a)
			{
				switch (a)
				{
				case 0: button1.setLabel("O"); button1.setEnabled(false);break;
				case 1: button2.setLabel("O"); button2.setEnabled(false);break;
				case 2: button3.setLabel("O"); button3.setEnabled(false);break;
				case 3: button4.setLabel("O"); button4.setEnabled(false);break;
				case 4: button5.setLabel("O"); button5.setEnabled(false);break;
				case 5: button6.setLabel("O"); button6.setEnabled(false);break;
				case 6: button7.setLabel("O"); button7.setEnabled(false);break;
				case 7: button8.setLabel("O"); button8.setEnabled(false);break;
				case 8: button9.setLabel("O"); button9.setEnabled(false);break;
				}
			}
		};
		
		//Action Listeners
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button1.setEnabled(true);
				button2.setEnabled(true);
				button3.setEnabled(true);
				button4.setEnabled(true);
				button5.setEnabled(true);
				button6.setEnabled(true);
				button7.setEnabled(true);
				button8.setEnabled(true);
				button9.setEnabled(true);
				button.setEnabled(false);
				button_1.setEnabled(false);
				game = new SinglePlayer();
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button1.setEnabled(true);
				button2.setEnabled(true);
				button3.setEnabled(true);
				button4.setEnabled(true);
				button5.setEnabled(true);
				button6.setEnabled(true);
				button7.setEnabled(true);
				button8.setEnabled(true);
				button9.setEnabled(true);
				button.setEnabled(false);
				button_1.setEnabled(false);
				game = new DoublePlayer();
			}
		});
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				button1.setEnabled(false);
				game.enterValue(0,game.getCurrentPlayer().getValue());
				button1.setLabel(game.getCurrentPlayer().getSymbol());
				int position;
				if (game.checkDraw(game.getBoard()) || game.checkWin(game.getBoard()))
					reset.fun();
				else if (game.isSinglePlayer())
					{
					position = game.AITurn();
					reset.fun2(position);
					if (game.checkDraw(game.getBoard()) || game.checkWin(game.getBoard()))
						reset.fun();
					}
				else
					game.switchPlayer();
			}
		});
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				button2.setEnabled(false);
				game.enterValue(1,game.getCurrentPlayer().getValue());
				button2.setLabel(game.getCurrentPlayer().getSymbol());
				if (game.checkDraw(game.getBoard()) || game.checkWin(game.getBoard()))
					reset.fun();
				else if (game.isSinglePlayer())
				{
				int position = game.AITurn();
				reset.fun2(position);
				if (game.checkDraw(game.getBoard()) || game.checkWin(game.getBoard()))
					reset.fun();
				}
				else
					game.switchPlayer();
			}
		});
		
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				button3.setEnabled(false);
				game.enterValue(2,game.getCurrentPlayer().getValue());
				button3.setLabel(game.getCurrentPlayer().getSymbol());
				if (game.checkDraw(game.getBoard()) || game.checkWin(game.getBoard()))
					reset.fun();
				else if (game.isSinglePlayer())
				{
				int position = game.AITurn();
				reset.fun2(position);
				if (game.checkDraw(game.getBoard()) || game.checkWin(game.getBoard()))
					reset.fun();
				}
				else
					game.switchPlayer();
			}
		});
		
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				button4.setEnabled(false);
				game.enterValue(3,game.getCurrentPlayer().getValue());
				button4.setLabel(game.getCurrentPlayer().getSymbol());
				if (game.checkDraw(game.getBoard()) || game.checkWin(game.getBoard()))
					reset.fun();
				else if (game.isSinglePlayer())
				{
				int position = game.AITurn();
				reset.fun2(position);
				if (game.checkDraw(game.getBoard()) || game.checkWin(game.getBoard()))
					reset.fun();
				}
				else
					game.switchPlayer();
			}
		});
		
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				button5.setEnabled(false);
				game.enterValue(4,game.getCurrentPlayer().getValue());
				button5.setLabel(game.getCurrentPlayer().getSymbol());
				if (game.checkDraw(game.getBoard()) || game.checkWin(game.getBoard()))
					reset.fun();
				else if (game.isSinglePlayer())
				{
				int position = game.AITurn();
				reset.fun2(position);
				if (game.checkDraw(game.getBoard()) || game.checkWin(game.getBoard()))
					reset.fun();
				}
				else
					game.switchPlayer();
			}
		});
		
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				button6.setEnabled(false);
				game.enterValue(5,game.getCurrentPlayer().getValue());
				button6.setLabel(game.getCurrentPlayer().getSymbol());
				if (game.checkDraw(game.getBoard()) || game.checkWin(game.getBoard()))
					reset.fun();
				else if (game.isSinglePlayer())
				{
					int position = game.AITurn();
					reset.fun2(position);
					if (game.checkDraw(game.getBoard()) || game.checkWin(game.getBoard()))
						reset.fun();
				}
				else
					game.switchPlayer();
			}
		});
		
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				button7.setEnabled(false);
				game.enterValue(6,game.getCurrentPlayer().getValue());
				button7.setLabel(game.getCurrentPlayer().getSymbol());
				if (game.checkDraw(game.getBoard()) || game.checkWin(game.getBoard()))
					reset.fun();
				else if (game.isSinglePlayer())
				{
				int position = game.AITurn();
				reset.fun2(position);
				if (game.checkDraw(game.getBoard()) || game.checkWin(game.getBoard()))
					reset.fun();
				}
				else
					game.switchPlayer();
			}
		});
		
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				button8.setEnabled(false);
				game.enterValue(7,game.getCurrentPlayer().getValue());
				button8.setLabel(game.getCurrentPlayer().getSymbol());
				if (game.checkDraw(game.getBoard()) || game.checkWin(game.getBoard()))
					reset.fun();
				else if (game.isSinglePlayer())
				{
				int position = game.AITurn();
				reset.fun2(position);
				if (game.checkDraw(game.getBoard()) || game.checkWin(game.getBoard()))
					reset.fun();
				}
				else
					game.switchPlayer();
			}
		});
		
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				button9.setEnabled(false);
				game.enterValue(8,game.getCurrentPlayer().getValue());
				button9.setLabel(game.getCurrentPlayer().getSymbol());
				if (game.checkDraw(game.getBoard()) || game.checkWin(game.getBoard()))
					reset.fun();
				else if (game.isSinglePlayer())
				{
				int position = game.AITurn();
				reset.fun2(position);
				if (game.checkDraw(game.getBoard()) || game.checkWin(game.getBoard()))
					reset.fun();
				}
				else
					game.switchPlayer();
			}
		});
		
		Label label = new Label("Player 1 - X");
		label.setFont(new Font("Baskerville Old Face", Font.BOLD, 28));
		label.setBounds(473, 170, 202, 33);
		frmTicTacToe.getContentPane().add(label);
		
		Label label_1 = new Label("Player 2 - O");
		label_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 28));
		label_1.setBounds(473, 209, 202, 33);
		frmTicTacToe.getContentPane().add(label_1);
	}
	}

