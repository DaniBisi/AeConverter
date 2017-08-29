package tapaeconverter.aeconverter;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StepByStepGui extends JPanel {

	private static final long serialVersionUID = 1L;
	private transient XtoTenConverterCore xToTen;
	private transient TenToXConverterCore tenToX;
	protected int contStepByStep;
	protected int contStepByStep2;

	/**
	 * Create the panel.
	 */
	public StepByStepGui(XtoTenConverterCore x1, TenToXConverterCore t1) {
		contStepByStep = 0;
		contStepByStep2 = 0;
		this.xToTen = x1;
		this.tenToX = t1;
		setBounds(100, 100, 450, 330);
		setName("stepByStep");
		setLayout(null);

		JButton btnBackX = new JButton("Back");

		btnBackX.setName("btnBackX");
		btnBackX.setEnabled(false);
		btnBackX.setBounds(12, 33, 117, 25);

		JButton btnForwardXtT = new JButton("Forward");

		btnForwardXtT.setBounds(141, 33, 117, 25);
		btnForwardXtT.setName("btnForward");

		JButton btnAllStepsXtT = new JButton("All Steps");
		btnAllStepsXtT.setBounds(321, 33, 117, 25);
		btnAllStepsXtT.setName("allStep");

		JTextPane textPaneXtT = new JTextPane();
		textPaneXtT.setName("textPaneXtoTenResult");
		textPaneXtT.setBounds(12, 70, 426, 91);
		textPaneXtT.setAutoscrolls(true);
		JScrollPane jsp = new JScrollPane();
		jsp.setViewportView(textPaneXtT);
		jsp.setBounds(12, 70, 426, 91);
		jsp.setVisible(true);

		add(jsp);

		btnForwardXtT.addActionListener(arg0 -> {
			String msg = textPaneXtT.getText();
			msg = msg + xToTen.getStepByStep().get(contStepByStep) + '\n';
			contStepByStep += 1;
			if (contStepByStep == xToTen.getStepByStep().size()) {
				btnForwardXtT.setEnabled(false);
			} // thread ui.
			textPaneXtT.setText(msg);
			btnBackX.setEnabled(true);
		});

		add(btnAllStepsXtT);
		add(btnBackX);
		add(btnForwardXtT);

		JLabel lblFirstStepConvert = new JLabel("First step: Convert Number in base 10");
		lblFirstStepConvert.setBounds(12, 6, 291, 25);
		add(lblFirstStepConvert);

		JButton btnBackT = new JButton("Back");
		
		btnBackT.setName("btnBackT");
		btnBackT.setBounds(12, 188, 117, 25);
		btnBackT.setEnabled(false);
		add(btnBackT);

		JButton btnForwardTtX = new JButton("Forward");
		btnForwardTtX.setName("btnForward_1");
		btnForwardTtX.setBounds(141, 188, 117, 25);

		JButton btnAllStepsTtX = new JButton("All Steps");
		
		btnAllStepsTtX.setBounds(321, 188, 117, 25);
		btnAllStepsTtX.setName("allStepT");
		add(btnAllStepsTtX);

		JTextPane textPaneTtX = new JTextPane();
		textPaneTtX.setName("textPaneTenToXResult");
		textPaneTtX.setBounds(12, 225, 426, 93);
		add(textPaneTtX);

		btnBackT.addActionListener(arg0 -> {
			String msg = textPaneTtX.getText();
			int k = msg.lastIndexOf('\n', msg.length() - 2);
			k = k + 1;
			textPaneTtX.setText(msg.substring(0, k));
			contStepByStep2 = contStepByStep2 - 1;
			btnForwardTtX.setEnabled(true);

			if (textPaneTtX.getText().isEmpty()) {
				btnBackT.setEnabled(false);
			}

		});
		btnBackX.addActionListener(arg0 -> {
			String msg = textPaneXtT.getText();
			int k = msg.lastIndexOf('\n', msg.length() - 2);
			k = k + 1;
			textPaneXtT.setText(msg.substring(0, k));
			contStepByStep = contStepByStep - 1;
			btnForwardXtT.setEnabled(true);

			if (textPaneXtT.getText().isEmpty()) {
				btnBackX.setEnabled(false);
			}

		});

		btnForwardTtX.addActionListener(arg0 -> {
			String msg = textPaneTtX.getText();
			msg = msg + tenToX.getStepByStep().get(contStepByStep2) + "\n";
			contStepByStep2 += 1;
			if (contStepByStep2 == tenToX.getStepByStep().size()) {
				btnForwardTtX.setEnabled(false);
			} // thread ui.
			textPaneTtX.setText(msg);
			btnBackT.setEnabled(true);
		});

		btnAllStepsXtT.addActionListener(arg0 -> {
			StringBuilder s1 = new StringBuilder();
			for (int i = 0; i < x1.getStepByStep().size(); i++) {
				s1 = s1.append(x1.getStepByStep().get(i));
				s1.append("\n");
			}
			contStepByStep = x1.getStepByStep().size();
			textPaneXtT.setText(s1.toString());
			btnBackX.setEnabled(true);
			btnForwardXtT.setEnabled(false);
		});

		add(btnForwardTtX);
		btnAllStepsTtX.addActionListener(arg0 -> {
			StringBuilder s1 = new StringBuilder();
			for (int i = 0; i < t1.getStepByStep().size(); i++) {
				s1 = s1.append(t1.getStepByStep().get(i));
				s1.append("\n");
			}
			contStepByStep2 = t1.getStepByStep().size();
			textPaneTtX.setText(s1.toString());
			btnBackT.setEnabled(true);
			btnForwardTtX.setEnabled(false);
		});
		
		JLabel lblSecondStepConvert = new JLabel("Second step: Convert Number in Destination Base");
		lblSecondStepConvert.setBounds(12, 161, 426, 25);
		add(lblSecondStepConvert);
		setVisible(true);
	}
}
