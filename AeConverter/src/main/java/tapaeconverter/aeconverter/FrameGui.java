package tapaeconverter.aeconverter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JMenu;
import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

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

		JMenu File = new JMenu("File");
		File.setName("File");
		menuBar.add(File);

		JMenuItem mntmBaseConversion = new JMenuItem("Base Conversion");
		mntmBaseConversion.setName("baseConversion");
		File.add(mntmBaseConversion);

		JMenuItem mntmFloatConversion = new JMenuItem("Float Conversion");
		File.add(mntmFloatConversion);

		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.setName("close");
		mntmClose.addActionListener(arg0 -> {
		dispose();
		});
		File.add(mntmClose);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		mntmBaseConversion.addActionListener(arg0 -> {		
				BaseConverterGui panelBaseConverter = new BaseConverterGui();
				getContentPane().remove(1);
				getContentPane().add(panelBaseConverter);
				resizeWindows(panelBaseConverter);
				getContentPane().setVisible(true);
				revalidate();
		});
		menuBar.add(mnHelp);

		getContentPane().add(menuBar, BorderLayout.NORTH);
		getContentPane().add(p1);
		resizeWindows(p1);
		setVisible(visibility);
		revalidate();
		repaint();

	}

	protected void resizeWindows(JPanel panelBaseConverter) {
		Rectangle r1 = panelBaseConverter.getBounds();
		r1.setSize(r1.width, r1.height +40);
		setBounds(r1);
	}
}
