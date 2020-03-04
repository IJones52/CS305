import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class StudiedGUI extends JFrame {
	JPanel top;
	JButton topCenter;
	JButton topLeft;
	JButton topRight;
	JPanel center;
	JButton centerLeft1;
	JButton centerRight1;
	JButton centerLeft2;
	JButton centerRight2;
	JPanel bottom;
	JLabel typeStuff;
	JTextArea box;
	
	public StudiedGUI() {
		setSize(285,200);
		setTitle("Good thing I sutdied!");
		setupTop();	
		setupCenter();
		setupBottom();
		
	}
	
	public void setupTop() {
		top = new JPanel();
		topCenter = new JButton();
		topCenter.setText("Button 2");
		topLeft = new JButton();
		topLeft.setText("Button 1");
		topRight = new JButton();
		topRight.setText("Button 3");
		top.add(topLeft, BorderLayout.WEST);
		top.add(topCenter,BorderLayout.CENTER);
		top.add(topRight,BorderLayout.EAST);
		add(top,BorderLayout.NORTH);

	}
	
	public void setupCenter() {
		center = new JPanel();
		GridLayout grid = new GridLayout(0,2);
		center.setLayout(grid);
		centerLeft1 = new JButton();
		centerLeft1.setText("Button 4");
		centerRight1 = new JButton();
		centerRight1.setText("Button 6");
		centerLeft2 = new JButton();
		centerLeft2.setText("Button 5");
		centerRight2 = new JButton();
		centerRight2.setText("Button 7");
		center.add(centerLeft1);
		center.add(centerRight1);
		center.add(centerLeft2);
		center.add(centerRight2);
		add(center);
	}
	
	public void setupBottom() {
		bottom = new JPanel();
		box = new JTextArea(1,10);
		typeStuff = new JLabel("Type Stuff:");
		bottom.add(typeStuff);
		bottom.add(box);
		add(bottom, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(()-> {
			
			StudiedGUI gui = new StudiedGUI();
			gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gui.setVisible(true);
		});
		
	}
}
