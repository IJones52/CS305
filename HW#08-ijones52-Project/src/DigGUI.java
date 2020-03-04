import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DigGUI extends JFrame{
	
	public DigGUI() {
		setSize(400,300);
		setTitle("I dig it!");
		setLayout(new GridLayout(0,1));
		add(new JButton("2"));
		JPanel textPanel = new JPanel();
		textPanel.add(new JButton("1"));
		textPanel.add(new JTextArea(1,37));
		add(textPanel);
	}
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			DigGUI gui = new DigGUI();
			gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
			gui.setVisible(true);
		});
	}
}
