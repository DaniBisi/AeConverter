package TapAeConverter.AeConverter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JSplitPane;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JInternalFrame;

public class AeConverterGui {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=149,377
	 */
	private final JPanel panel_1 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AeConverterGui window = new AeConverterGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AeConverterGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//################## PANEL CHOISE VIEW ########################
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		JButton btnNewButton_1 = new JButton("base converter");
		
		panel.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton("float converter");
		panel.add(btnNewButton_2);
		//################## END PANEL CHOISE VIEW ####################
		
		
		
		//################## PANEL CHOISE BASE CONVERTER ########################
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 2, 0, 0));
		JButton btnNewButton_3 = new JButton("Start base");
		panel1.add(btnNewButton_3);
		JButton btnNewButton_4 = new JButton("End base");
		panel1.add(btnNewButton_4);
		//################## PANEL CHOISE BASE CONVERTER ########################
		
		
		
		//################## EVENT LISTENER #########################
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(panel1);
				frame.revalidate();
				frame.repaint();
			}
		});
		
	}

}
