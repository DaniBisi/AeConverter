package tapaeconverter.aeconverter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FrameGui extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public FrameGui(JPanel p1, boolean visibility) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();

		JMenu file = new JMenu("File");
		file.setName("File");
		menuBar.add(file);

		JMenuItem mntmBaseConversion = new JMenuItem("Base Conversion");
		mntmBaseConversion.setName("baseConversion");
		file.add(mntmBaseConversion);

		JMenuItem mntmFloatConversion = new JMenuItem("Float Conversion");
		file.add(mntmFloatConversion);

		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.setName("close");
		mntmClose.addActionListener(arg0 -> dispose());
		file.add(mntmClose);

		mntmBaseConversion.addActionListener(arg0 -> {
			BaseConverterGui panelBaseConverter = new BaseConverterGui(new CheckSymbolCore(null),
					new XtoTenConverterCore(), new TenToXConverterCore());
			getContentPane().remove(1);
			getContentPane().add(panelBaseConverter);
			resizeWindows(panelBaseConverter);
			getContentPane().setVisible(true);
			revalidate();
		});

		getContentPane().add(menuBar, BorderLayout.NORTH);
		getContentPane().add(p1);
		resizeWindows(p1);
		setVisible(visibility);
		revalidate();
		repaint();

	}

	protected void resizeWindows(JPanel panelBaseConverter) {
		Rectangle r1 = panelBaseConverter.getBounds();
		r1.setSize(r1.width, r1.height + 40);
		setBounds(r1);
	}
}
