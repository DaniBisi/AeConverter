package TapAeConverter.AeConverter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AeConverterGui {

	private JFrame frame;
	JPanel panelBaseConverter;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AeConverterGui window = new AeConverterGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AeConverterGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new MakeChoise();
	}

}
