package tapaeconverter.aeconverter;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public abstract class BasePanel extends JPanel{
	public void setAncestorPanel(Component t1,JPanel p1, int []size) {
		JFrame ancestor = (JFrame) SwingUtilities.getWindowAncestor(t1);
		if(size != null){
			ancestor.setSize(size[0],size[1]);
		}
		ancestor.getContentPane().removeAll();
		ancestor.getContentPane().add(p1);
		ancestor.getContentPane().setVisible(true);
		ancestor.revalidate();
		
	}

}
