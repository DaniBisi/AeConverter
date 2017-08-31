package tapaeconverter.aeconverter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MakeChoiseGui extends BasePanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public MakeChoiseGui() {
		setBounds(100, 100, 450, 330);
		// ################## PANEL CHOISE VIEW ########################
		setName("makeChoise");
		setLayout(null);
		JButton baseConverter = new JButton("Base Converter");
		baseConverter.setBounds(0, 0, 225, 232);
		baseConverter.setName("baseConverter");
		add(baseConverter);
		JButton floatConverter = new JButton("Float Converter");
		floatConverter.setBounds(225, 0, 225, 232);
		add(floatConverter);
		JButton btnClose = new JButton("Close");
		btnClose.setName("close");
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
				BaseConverterGui panelBaseConverter = new BaseConverterGui();
				setAncestorPanel(baseConverter, panelBaseConverter, new int[] { 450, 360 });
			}
		});

	}

}
