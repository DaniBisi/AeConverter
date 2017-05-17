package TapAeConverter.AeConverter;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridLayout;

public class GuiFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GuiFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		MakeChoise p1 = new MakeChoise();
		getContentPane().add(p1);
//		setContentPane(p1);
		setVisible(true);
		revalidate();
		repaint();
	}
	
	public GuiFrame(JPanel p1){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		getContentPane().add(p1);
//		setContentPane(p1);
		setVisible(true);
		revalidate();
		repaint();
		
	}
	

}
