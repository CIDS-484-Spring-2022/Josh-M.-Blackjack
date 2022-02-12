package Main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class View implements Viewer, MouseListener, ActionListener {

	public JFrame frame; // maybe shouldn't be public
	private JButton Deal; 
	private JButton Split; 
	private JButton Hit;
	private JButton Stand;
	private JButton Double;
	Card card;
	Player player;
	//Player player1 = new Player();

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public View() {
		initialize();
	}
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Hit = new JButton("Hit");
		Hit.setBounds(99, 195, 89, 23);
		frame.getContentPane().add(Hit);
		Hit.addActionListener(this);
		
		Stand = new JButton("Stand");
		Stand.setBounds(215, 195, 89, 23);
		frame.getContentPane().add(Stand);
		Stand.addActionListener(this);
		
		Double = new JButton("Double");
		Double.setBounds(99, 227, 89, 23);
		frame.getContentPane().add(Double);
		Double.addActionListener(this);
		
		Split = new JButton("Split");
		Split.setBounds(215, 229, 89, 23);
		frame.getContentPane().add(Split);
		Split.addActionListener(this);
		
		Deal = new JButton("Deal");
		Deal.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(Deal);
		Deal.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == Deal) {
			System.out.println("DealCard");
			JTextField dealField = new JTextField("CardsDealt");
			dealField.setBounds(150,150,150,23);
			dealField.setEditable(false);
			frame.add(dealField);
			//player.getCard(2);
			//System.out.println(player.dealCard().getCard(1));
		}
		if(e.getSource() == Hit) {
			System.out.println("Hit!");
			JTextField hitField = new JTextField("HIT!");
			hitField.setBounds(250,50,150,23);
			frame.add(hitField);
		}
		if(e.getSource() == Stand) {
			System.out.println("Stand");
			JTextField standField = new JTextField("Stand");
			standField.setBounds(150,150,150,23);
			frame.add(standField);
		}
		if(e.getSource() == Double) {
			System.out.println("Double");
			JTextField doubleField = new JTextField("Double");
			doubleField.setBounds(150,150,150,23);
			frame.add(doubleField);
		}
		if(e.getSource() == Split) {
			System.out.println("Split");
			JTextField splitField = new JTextField("Split");
			splitField.setBounds(150,150,150,23);
			frame.add(splitField);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

 // Class is for GUI layout
	
	
	
	
}
