package TapAeConverter.AeConverter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MakeChoise extends JPanel {
	/**
	 * 
	 */
	// private static final long serialVersionUID = 1L;
	/**
	 * Create the frame.
	 */
	public MakeChoise() {
		setBounds(100, 100, 450, 330);
		// ################## PANEL CHOISE VIEW ########################
		setName("makeChoise");
		setLayout(null);
		JButton base_converter = new JButton("base converter");
		base_converter.setBounds(0, 0, 225, 232);
		base_converter.setName("base_converter");
		add(base_converter);
		JButton btnNewButton_2 = new JButton("float converter");
		btnNewButton_2.setBounds(225, 0, 225, 232);
		add(btnNewButton_2);
		JButton btnClose = new JButton("Chiudi");
		btnClose.setName("Chiudi");
		btnClose.setBounds(0, 244, 225, 56);
		add(btnClose);
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(225, 244, 225, 56);
		btnHelp.setName("btnHelp");
		add(btnHelp);
		// ################## END PANEL CHOISE VIEW ####################

		// ################## EVENT LISTENER #########################
		btnClose.addActionListener(arg0 -> {
			JFrame ancestor = (JFrame) SwingUtilities.getWindowAncestor(btnClose);
			ancestor.dispose();
		});
		
		base_converter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame ancestor = (JFrame) SwingUtilities.getWindowAncestor(base_converter);
				ancestor.getContentPane().removeAll();
				BaseConverter panelBaseConverter = new BaseConverter();
				ancestor.getContentPane().removeAll();
				ancestor.getContentPane().add(panelBaseConverter);
				ancestor.getContentPane().setVisible(true);
				ancestor.revalidate();
				// frameP.repaint();
			}
		});

	}

}
