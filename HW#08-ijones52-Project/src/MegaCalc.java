import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MegaCalc extends JFrame{
	
	JPanel north;
	JPanel mid;
	JPanel south;
	JTextField left;
	JTextField right;
	JLabel sum;
	JButton add ;
	JButton clear;
	public MegaCalc() {
		setSize(400,300);
		setTitle("MegaCalc");
		setupCenter();
		setupNorth();
		setupSouth();
	}
	
	public void setupNorth() {
		north = new JPanel();
		left = new JTextField(5);
		right = new JTextField(5);
		add = new JButton("+");
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sum.setText(""+(Integer.parseInt(left.getText()) + Integer.parseInt(right.getText())));
			}
			
		});
		north.add(left);
		north.add(add);
		north.add(right);
		add(north, BorderLayout.NORTH);
	}
	
	public void setupCenter() {
		mid = new JPanel();
		mid.setLayout(new BorderLayout());
		sum = new JLabel("0");
		mid.add(sum, BorderLayout.WEST);
		add(mid, BorderLayout.CENTER);
	}
	
	public void setupSouth() {
		south = new JPanel();
		south.setLayout(new BorderLayout());
		 clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				left.setText("");
				right.setText("");
				sum.setText("0");
			}
			
		});
		south.add(clear, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
	}

	
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			MegaCalc calc = new MegaCalc();
			calc.setDefaultCloseOperation(EXIT_ON_CLOSE);
			calc.setVisible(true);
			
		});
	}
}
