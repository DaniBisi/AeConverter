package tapaeconverter.aeconverter;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public abstract class BasePanel extends JPanel {

	public BasePanel() {
	}

	public void setAncestorPanel(Component t1, JPanel p1) {
		FrameGui ancestor = (FrameGui) SwingUtilities.getWindowAncestor(t1);
		ancestor.getContentPane().remove(1);
		ancestor.getContentPane().add(p1);
		ancestor.resizeWindows(p1);
		ancestor.getContentPane().setVisible(true);
		ancestor.revalidate();

	}

}
