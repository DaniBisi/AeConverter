package tapaeconverter.aeconverter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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
		setBounds(100, 180, 450, 390);
		JLabel lblWellcome = new JLabel("Wellcome To Aeconverter");
		lblWellcome.setName("lblWellcome");
		lblWellcome.setVerticalAlignment(SwingConstants.TOP);
		lblWellcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWellcome.setFont(new Font("Dialog", Font.PLAIN, 24));

		JLabel lblHelp = new JLabel(
				"<html>Click File and chose a type of conversion to start a new job:<br>Base Converter to start a new conversion from a base to another.<br>Float conversion to start a new conversion from float to decimal and likewise</html>");
		lblHelp.setName("lblHelp");
		lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(65)
						.addComponent(lblWellcome, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE).addGap(66))
				.addGroup(groupLayout.createSequentialGroup().addGap(42)
						.addComponent(lblHelp, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE).addGap(48)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(42).addComponent(lblWellcome).addGap(52)
						.addComponent(lblHelp).addContainerGap(177, Short.MAX_VALUE)));
		setLayout(groupLayout);

	}
}
