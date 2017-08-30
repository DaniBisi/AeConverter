package tapaeconverter.aeconverter;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;

public class StepByStepGui extends BasePanel {

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
		setSize(450, 390);
		setName("stepByStep");
		setLayout(null);

		JButton btnBackX = new JButton("<<");

		btnBackX.setName("btnBackX");
		btnBackX.setEnabled(false);
		btnBackX.setBounds(12, 33, 117, 25);

		JButton btnForwardXtT = new JButton(">>");

		btnForwardXtT.setBounds(141, 33, 117, 25);
		btnForwardXtT.setName("btnForwardX");

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

		JButton btnBackT = new JButton("<<");

		btnBackT.setName("btnBackT");
		btnBackT.setBounds(12, 188, 117, 25);
		btnBackT.setEnabled(false);
		add(btnBackT);

		JButton btnForwardTtX = new JButton(">>");
		btnForwardTtX.setName("btnForwardT");
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

		JButton btnBack = new JButton("Back");
		btnBack.setName("back");
		btnBack.addActionListener(arg0 -> {
			BaseConverterGui p1 = new BaseConverterGui();
			setAncestorPanel(btnBack, p1, new int[] { 450, 330 });
		});
		btnBack.setBounds(12, 330, 137, 35);
		add(btnBack);

		JButton btnClose = new JButton("Close");
		btnClose.setName("close");
		btnClose.addActionListener(arg0 -> {
			JFrame ancestor = (JFrame) SwingUtilities.getWindowAncestor(btnClose);
			ancestor.dispose();
		});
		btnClose.setBounds(301, 330, 137, 35);
		add(btnClose);
		setVisible(true);
	}
}
