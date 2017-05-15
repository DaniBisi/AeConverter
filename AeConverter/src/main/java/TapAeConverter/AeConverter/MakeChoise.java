package TapAeConverter.AeConverter;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MakeChoise extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JFrame frameP;
	/**
	 * Create the frame.
	 */
	public MakeChoise() {

		//################## PANEL CHOISE VIEW ########################
		
		setLayout(new GridLayout(1, 2, 0, 0));
		JButton base_converter = new JButton("base converter");
		base_converter.setName("base_converter");
		add(base_converter);
		JButton btnNewButton_2 = new JButton("float converter");
		add(btnNewButton_2);
		//################## END PANEL CHOISE VIEW ####################
		
		
		//################## EVENT LISTENER #########################
		
		base_converter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameP.getContentPane().removeAll();
				baseConverter panelBaseConverter = new baseConverter();
				panelBaseConverter.setParentFrame(frameP);
				frameP.getContentPane().removeAll();
				frameP.getContentPane().add(panelBaseConverter);
				frameP.getContentPane().setVisible(true);
				frameP.revalidate();
				frameP.repaint();
			}
		});
		
		
	}
	public void setFrameP(JFrame frame){
		frameP = frame;
		
	}

}
