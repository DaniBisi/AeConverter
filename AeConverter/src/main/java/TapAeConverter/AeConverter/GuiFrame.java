package TapAeConverter.AeConverter;


import javax.swing.JFrame;

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
