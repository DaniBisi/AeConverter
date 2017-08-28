package tapaeconverter.aeconverter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MakeChoiseGui extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public MakeChoiseGui() {
		setBounds(100, 100, 450, 330);
		// ################## PANEL CHOISE VIEW ########################
		setName("makeChoise");
		setLayout(null);
		JButton baseConverter = new JButton("base converter");
		baseConverter.setBounds(0, 0, 225, 232);
		baseConverter.setName("base_converter");
		add(baseConverter);
		JButton floatConverter = new JButton("float converter");
		floatConverter.setBounds(225, 0, 225, 232);
		add(floatConverter);
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

		baseConverter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame ancestor = (JFrame) SwingUtilities.getWindowAncestor(baseConverter);
				ancestor.getContentPane().removeAll();
				BaseConverterGui panelBaseConverter = new BaseConverterGui();
				ancestor.getContentPane().removeAll();
				ancestor.getContentPane().add(panelBaseConverter);
				ancestor.getContentPane().setVisible(true);
				ancestor.revalidate();
			}
		});

	}

}
