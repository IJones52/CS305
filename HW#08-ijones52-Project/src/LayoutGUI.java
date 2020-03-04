import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LayoutGUI extends JFrame {
	JPanel top;
	JPanel west;
	JPanel center;
	JPanel east;
	JPanel bottom;
	
	public LayoutGUI() {
		setSize(420,250);
		setTitle("Layout Question");
		setupTop();
		setupBottom();
		setupEast();
		setupCenter();
		setupWest();
		JPanel centerContainer = new JPanel();
		centerContainer.setLayout(new GridLayout(0,3));
		centerContainer.add(west);
		centerContainer.add(center);
		centerContainer.add(east);
		add(centerContainer);
		
		
		
	}
	
	public void setupTop() {
		top = new JPanel();
		top.setLayout(new GridLayout(0,4));
		JLabel button = new JLabel("Buttons:");
		JButton hi = new JButton("hi");
		JButton longName = new JButton("long name");
		JButton bye = new JButton("bye");
		top.add(button);
		top.add(hi);
		top.add(longName);
		top.add(bye);
		add(top, BorderLayout.NORTH);
		
	}
	
	public void setupBottom() {
		bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		JButton cancel = new JButton("Cancel");
		bottom.add(cancel);
		add(bottom, BorderLayout.SOUTH);
	}
	
	public void setupEast() {
		east = new JPanel();
		GridLayout grid = new GridLayout(0,1);
		east.setLayout(grid);
		east.add(new JButton("2"));
		east.add(new JButton("7"));
	}
	
	public void setupCenter() {
		center = new JPanel();
		GridLayout grid = new GridLayout(0,1);
		center.setLayout(grid);
		center.add(new JButton("1"));
		JPanel lower = new JPanel();
		lower.setLayout(new GridLayout(0,2));
		lower.add(new JButton("3"));
		lower.add(new JButton("4"));
		lower.add(new JButton("5"));
		lower.add(new JButton("6"));
		center.add(lower);
		
	}
	
	public void setupWest() {
		west = new JPanel();
		west.setLayout(new GridLayout(0,1));
		west.add(new JCheckBox("Bold"));
		west.add(new JCheckBox("Italic"));
		west.add(new JCheckBox("Underline"));
		west.add(new JCheckBox("Strikeout"));
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			LayoutGUI gui = new LayoutGUI();
			gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gui.setVisible(true);
		});
		
	}
}
