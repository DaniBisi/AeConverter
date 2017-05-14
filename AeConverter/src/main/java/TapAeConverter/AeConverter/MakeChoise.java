package TapAeConverter.AeConverter;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MakeChoise extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected baseConverter panelBaseConverter;
	/**
	 * Create the frame.
	 */
	public MakeChoise() {

		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//################## PANEL CHOISE VIEW ########################
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		JButton base_converter = new JButton("base converter");
		base_converter.setName("base_converter");

		
		panel.add(base_converter);
		JButton btnNewButton_2 = new JButton("float converter");
		panel.add(btnNewButton_2);
		//################## END PANEL CHOISE VIEW ####################
		
		
		
		//################## PANEL CHOISE BASE CONVERTER ########################
		
		//################## PANEL CHOISE BASE CONVERTER ########################
		
		
		
		//################## EVENT LISTENER #########################
		base_converter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				panelBaseConverter = new baseConverter();
				getContentPane().add(panelBaseConverter);
				revalidate();
				repaint();
			}
		});
	}

}
