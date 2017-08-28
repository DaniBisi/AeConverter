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
	public FrameGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MakeChoiseGui p1 = new MakeChoiseGui();
		getContentPane().add(p1);
		setBounds(100, 100, 450, 330);
		setVisible(true);
		revalidate();
		repaint();
	}

	public FrameGui(JPanel p1) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(p1);
		setBounds(100, 100, 450, 330);
		setVisible(true);
		revalidate();
		repaint();

	}

}
