import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MessageGUI extends JFrame {
	JPanel north= new JPanel();
	JPanel to;
	JPanel CC;
	JPanel message;
	JPanel send;
	
	public MessageGUI(){
		setSize(300,200);
		north.setLayout(new GridLayout(0,1));
		setTitle("Compose Message");
		setLayout(new BorderLayout());
		setupTo();
		setupCC();
		add(north,BorderLayout.NORTH);
		setupMessage();
		setupSend();
	}
	
	public void setupTo() {
		to = new JPanel();
		to.add(new JLabel("To:"));
		to.add(new JTextField(28));
		north.add(to);
	}
	
	public void setupCC() {
		CC = new JPanel();
		CC.add(new JLabel("CC:"));
		CC.add(new JTextField(27));
		north.add(CC);
		
	}
	
	public void setupMessage() {
		message = new JPanel();
		message.setLayout(new BoxLayout(message,BoxLayout.LINE_AXIS));
		message.add(new JTextArea());
		add(message,BorderLayout.CENTER);
	}
	
	public void setupSend() {
		send = new JPanel();
		send.setLayout(new BorderLayout());
		send.add(new JButton("Send"),BorderLayout.EAST);
		add(send,BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater((()->{
			MessageGUI gui = new MessageGUI();
			gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gui.setVisible(true);
		}));
	}
}
