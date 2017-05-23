package TapAeConverter.AeConverter;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class StepByStep extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient XtoTenConverter xToTen;
	private transient TenToXConverter tenToX;
	protected int contStepByStep;

	/**
	 * Create the panel.
	 */
	public StepByStep(XtoTenConverter x1,TenToXConverter t1) {
		contStepByStep = 0;
		this.xToTen = x1;
		this.tenToX = t1;
		setBounds(100, 100, 450, 330);
		setName("stepByStep");
		setLayout(null);
		
		JButton btnBackX = new JButton("Back");
		btnBackX.setName("btnBack");
		btnBackX.setEnabled(false);
		btnBackX.setBounds(12, 33, 117, 25);
		
		JButton btnForward = new JButton("Forward");
		

		btnForward.setBounds(141, 33, 117, 25);
		btnForward.setName("btnForward");
		
		JButton btnAllSteps = new JButton("All Steps");
		btnAllSteps.setBounds(321, 33, 117, 25);
		
		JTextPane textPane = new JTextPane();
		textPane.setName("dividend");
		textPane.setBounds(12, 70, 426, 91);
		textPane.setAutoscrolls(true);
		 JScrollPane jsp= new JScrollPane();
		 jsp.setViewportView(textPane);
		 jsp.setBounds(12, 70, 426, 91);
		 jsp.setVisible(true);
	        
		add(jsp);
		
		 btnForward.addActionListener(arg0 -> {
			String msg=textPane.getText();
			msg = (msg +xToTen.getStepByStep().get(contStepByStep) +"\n");
			contStepByStep+=1;
			if(contStepByStep == xToTen.getStepByStep().size()){
				btnForward.setEnabled(false);
			}//thread ui.
			textPane.setText(msg);
			btnBackX.setEnabled(true);
		});

		

		add(btnAllSteps);
		add(btnBackX);
		//add(textPane);
		add(btnForward);
		
		JLabel lblFirstStepConvert = new JLabel("First step: Convert Number in base 10");
		lblFirstStepConvert.setBounds(12, 6, 291, 25);
		add(lblFirstStepConvert);
		
		JButton btnBackT = new JButton("Back");
		btnBackT.setBounds(12, 188, 117, 25);
		btnBackT.setEnabled(false);
		add(btnBackT);
		
		JButton btnForward_1 = new JButton("Forward");
		btnForward_1.setBounds(141, 188, 117, 25);
		add(btnForward_1);
		
		JButton btnAllSteps_1 = new JButton("All Steps");
		btnAllSteps_1.setBounds(321, 188, 117, 25);
		add(btnAllSteps_1);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(12, 225, 426, 93);
		add(textPane_1);
		
		JLabel lblSecondStepConvert = new JLabel("Second step: Convert Number in Destination Base");
		lblSecondStepConvert.setBounds(12, 161, 426, 25);
		add(lblSecondStepConvert);
		setVisible(true);
	}
}
