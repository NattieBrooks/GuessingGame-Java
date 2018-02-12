import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private JButton btnPlayAgain;
	private int theNumber;
	int guessCount = 0;

	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber) {
				message = guess + " is too low. Try again";
				guessCount++;
			}
			else if (guess > theNumber) {
				message = guess + " is too high. Try again.";
				guessCount++;
			}
			else {
				message = guess + " is correct. You win! It took you " + guessCount + " tries.";
				guessCount = 0;
				btnPlayAgain.setVisible(true);
				newGame();
			}
		}
		
		catch (Exception e) {
			message = "Enter a whole number between 1 and 100";
		}
		
		finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
	}
}

	public void newGame() {
		theNumber = (int) (Math.random() * 100 + 1);
	}

	public GuessingGame() {
		getContentPane().setBackground(new Color(204, 204, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Natalie's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Natalie's Hi-Lo- Guessing Game");
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(9, 24, 420, 32);
		getContentPane().add(lblNewLabel);

		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100");
		lblGuessANumber.setForeground(new Color(0, 0, 102));
		lblGuessANumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGuessANumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuessANumber.setBounds(95, 80, 219, 19);
		getContentPane().add(lblGuessANumber);

		txtGuess = new JTextField();
		txtGuess.setBounds(328, 80, 43, 19);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});

		JButton btnGuess = new JButton("Guess!");
		btnGuess.setForeground(new Color(0, 0, 102));
		btnGuess.setBackground(new Color(255, 255, 255));
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGuess.setBounds(173, 124, 92, 33);
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("Enter a number about and then click Guess");
		lblOutput.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOutput.setForeground(new Color(0, 0, 102));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(9, 231, 420, 19);
		getContentPane().add(lblOutput);
		
		
		btnPlayAgain = new JButton("Play Again!");
		btnPlayAgain.setForeground(new Color(204, 0, 51));
		btnPlayAgain.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPlayAgain.setBounds(175, 180, 89, 23);
		getContentPane().add(btnPlayAgain);
		btnPlayAgain.setVisible(false);
		
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlayAgain.setVisible(false);
				lblOutput.setText("Enter a number about and then click Guess");
				newGame();
			}
		});
		
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450, 300));
		theGame.setVisible(true);

	}
}
