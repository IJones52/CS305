import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StringGame extends JFrame {
	
	
		
	public StringGame() {
		setSize(300,100);
		setTitle("Silly String Game");
		setLayout(new GridLayout(0,1));
		
		//Make the buttons
		JButton upper = new JButton("Upper case");
		JTextField text = new JTextField();
		JButton lower = new JButton("Lower case");
		upper.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText(text.getText().toUpperCase());
			}
			
		});
		lower.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText(text.getText().toLowerCase());
			}
			
		});
		JPanel upperP = new JPanel();
		upperP.setLayout(new BorderLayout());
		upperP.add(upper, BorderLayout.WEST);
		JPanel lowerP = new JPanel();
		lowerP.setLayout(new BorderLayout());
		lowerP.add(lower, BorderLayout.WEST);
		add(upperP, BorderLayout.NORTH);
		add(text,BorderLayout.CENTER);
		add(lowerP, BorderLayout.SOUTH);
		 	
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			StringGame game = new StringGame();
			game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			game.setVisible(true);
		});
	}
	
}
