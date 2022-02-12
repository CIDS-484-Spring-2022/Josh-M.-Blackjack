package Main;

import java.awt.EventQueue;

public class Container{

	public static void main(String[] args) {
		// the main driver of the program
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			
	}

}
