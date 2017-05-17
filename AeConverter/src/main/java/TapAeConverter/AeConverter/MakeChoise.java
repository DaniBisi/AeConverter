package TapAeConverter.AeConverter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class MakeChoise extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the frame.
	 */
	public MakeChoise() {

		setBounds(100, 100, 450, 330);
		//################## PANEL CHOISE VIEW ########################
		setName("makeChoise");
		setLayout(null);
		JButton base_converter = new JButton("base converter");
		base_converter.setBounds(0, 0, 225, 232);
		base_converter.setName("base_converter");
		add(base_converter);
		JButton btnNewButton_2 = new JButton("float converter");
		btnNewButton_2.setBounds(225, 0, 225, 232);
		add(btnNewButton_2);
		JButton close = new JButton("Chiudi");
		close.setBounds(0, 244, 225, 56);
		close.setName("close");
		add(close);
		JButton Help = new JButton("Help");
		Help.setBounds(225, 244, 225, 56);
		close.setName("Help");
		add(Help);
		//################## END PANEL CHOISE VIEW ####################
		
		
		//################## EVENT LISTENER #########################
		
		base_converter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame ancestor = (JFrame) SwingUtilities.getWindowAncestor(base_converter);
				ancestor.getContentPane().removeAll();
				BaseConverter panelBaseConverter = new BaseConverter();
				panelBaseConverter.setParentFrame(ancestor);
				ancestor.getContentPane().removeAll();
				ancestor.getContentPane().add(panelBaseConverter);
				ancestor.getContentPane().setVisible(true);
				ancestor.revalidate();
//				frameP.repaint();
			}
		});
		
		
	}

}
