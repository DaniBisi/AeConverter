package tapaeconverter.aeconverter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameGui extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	

	public FrameGui(JPanel p1,int []bounds,boolean visibility ) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(p1);
		setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		setVisible(visibility);
		revalidate();
		repaint();

	}
}
