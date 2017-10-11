package tapaeconverter.aeconverter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class HomeGui extends BasePanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public HomeGui() {
		super();
		setName("homeGui");
		setBounds( 100, 180, 450, 390); 
		JLabel lblWellcome = new JLabel("Wellcome To Aeconverter");
		lblWellcome.setName("lblWellcome");
		lblWellcome.setVerticalAlignment(SwingConstants.TOP);
		lblWellcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWellcome.setFont(new Font("Dialog", Font.PLAIN, 24));
		
		JLabel lblHelp = new JLabel("<html>Click File and chose a type of conversion to start a new job:<br>Base Converter to start a new conversion from a base to another.<br>Float conversion to start a new conversion from float to decimal and likewise</html>");
		lblHelp.setName("lblHelp");
		lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addComponent(lblWellcome, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
					.addGap(66))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(lblHelp, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
					.addGap(48))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(lblWellcome)
					.addGap(52)
					.addComponent(lblHelp)
					.addContainerGap(177, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
//		// ################## PANEL CHOISE VIEW ########################
//		setName("makeChoise");
//		JButton baseConverter = new JButton("Base Converter");
//		
//		
//		baseConverter.setName("baseConverter");
//		JButton floatConverter = new JButton("Float Converter");
//		JButton btnClose = new JButton("Close");
//		btnClose.setName("close");
//		JButton btnHelp = new JButton("Help");
//		
//		btnHelp.setName("btnHelp");
//		GroupLayout groupLayout = new GroupLayout(this);
//		groupLayout.setHorizontalGroup(
//			groupLayout.createParallelGroup(Alignment.LEADING)
//				.addGroup(groupLayout.createSequentialGroup()
//					.addContainerGap()
//					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
//						.addComponent(btnHelp, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
//						.addComponent(baseConverter, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
//					.addGap(18)
//					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
//						.addComponent(btnClose, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
//						.addComponent(floatConverter, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
//					.addGap(22))
//		);
//		groupLayout.setVerticalGroup(
//			groupLayout.createParallelGroup(Alignment.LEADING)
//				.addGroup(groupLayout.createSequentialGroup()
//					.addGap(88)
//					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
//						.addComponent(baseConverter, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
//						.addComponent(floatConverter, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
//					.addGap(131)
//					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
//						.addComponent(btnHelp, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
//						.addComponent(btnClose, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
//					.addGap(25))
//		);
//		setLayout(groupLayout);
//		// ################## END PANEL CHOISE VIEW ####################
//
//		// ################## EVENT LISTENER #########################
//		btnClose.addActionListener(arg0 -> {
//			JFrame ancestor = (JFrame) SwingUtilities.getWindowAncestor(btnClose);
//			ancestor.dispose();
//		});
//
//		baseConverter.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				BaseConverterGui panelBaseConverter = new BaseConverterGui();
//				setAncestorPanel(baseConverter, panelBaseConverter);
//			}
//		});

	}
}
