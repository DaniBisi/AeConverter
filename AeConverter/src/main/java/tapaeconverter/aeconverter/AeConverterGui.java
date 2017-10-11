package tapaeconverter.aeconverter;

import java.awt.EventQueue;

import javax.swing.JPanel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class AeConverterGui {
	private static final Logger LOGGER = LogManager.getLogger(XtoTenConverterCore.class);

	private FrameGui frame;
	JPanel panelBaseConverter;

	/**
	 * Create the application.
	 */
	public AeConverterGui() {
		initialize();
	}

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			try {
				AeConverterGui window = new AeConverterGui();
				window.frame.setVisible(true);
			} catch (Exception e) {
				LOGGER.info(e);

			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int[] bounds = { 100, 100, 450, 390 };
		frame = new FrameGui(new HomeGui(), true);
	}

}
