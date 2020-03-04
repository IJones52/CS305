import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MidtermGUI extends JFrame{
	JPanel west;
	JPanel east;
	JPanel center;
	JPanel bottom;
	
	public MidtermGUI() {
		setSize(400,300);
		setTitle("Midterm on Thursday!");
		setupCenter();
		setupWest();
		setupEast();
		setupBottom();
			
	}
	
	public void setupCenter() {
		center = new JPanel();
		center.add(new JTextArea(20,20));
		add(center, BorderLayout.CENTER);
	}
	
	public void setupWest() {
		west = new JPanel();
		west.setLayout(new GridLayout(0,1));
		west.add(new JButton("Now Playing"));
		west.add(new JButton("Media Guide"));
		west.add(new JButton("Library"));
		west.add(new JButton("Help & Info"));
		west.add(new JButton("Services"));
		add(west, BorderLayout.WEST);	
		
 }
	
	
	public void setupEast() {
		east = new JPanel();
		east.setLayout(new GridLayout(0,1));
		JPanel subEast = new JPanel();
		subEast.setLayout(new GridLayout(0,2));
		subEast.add(new JButton("0"));
		subEast.add(new JButton("1"));
		subEast.add(new JButton("2"));
		subEast.add(new JButton("3"));
		east.add(subEast);
		east.add(new JButton("OK"));
		add(east, BorderLayout.EAST);
		
	}
	
	public void setupBottom() {
		bottom = new JPanel();
		bottom.setLayout(new GridLayout(0,5));
		bottom.add(new JLabel("Movies"));
		bottom.add(new JLabel("Music"));
		bottom.add(new JLabel("Videos"));
		bottom.add(new JLabel("DVD"));
		bottom.add(new JLabel("Web Pages"));
		add(bottom, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			MidtermGUI gui = new MidtermGUI();
			gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
			gui.setVisible(true);
			
		});
	}
}
