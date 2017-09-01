package tapaeconverter.aeconverter;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public abstract class BasePanel extends JPanel {

	public BasePanel() {
		setBounds(100, 100, 450, 390);
	}

	public void setAncestorPanel(Component t1, JPanel p1) {
		JFrame ancestor = (JFrame) SwingUtilities.getWindowAncestor(t1);
		ancestor.getContentPane().removeAll();
		ancestor.getContentPane().add(p1);
		ancestor.getContentPane().setVisible(true);
		ancestor.revalidate();

	}

}
