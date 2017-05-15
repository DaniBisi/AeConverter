package TapAeConverter.AeConverter;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GuiFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GuiFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		MakeChoise p1 = new MakeChoise();
		p1.setFrameP(this);
		add(p1);
//		setContentPane(p1);
		setVisible(true);
		revalidate();
		repaint();
	}

}
