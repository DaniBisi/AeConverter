package tapaeconverter.aeconverter;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		super();
		setBounds(100, 100, 533, 347);
		contStepByStep = 0;
		contStepByStep2 = 0;
		this.xToTen = x1;
		this.tenToX = t1;
		setName("stepByStep");

		JButton btnBackX = new JButton("<<");
		btnBackX.setName("btnBackX");
		btnBackX.setEnabled(false);

		JButton btnForwardXtT = new JButton(">>");
		btnForwardXtT.setName("btnForwardX");

		JButton btnAllStepsXtT = new JButton("All Steps");
		btnAllStepsXtT.setName("allStep");

		JTextPane textPaneXtT = new JTextPane();
		textPaneXtT.setName("textPaneXtoTenResult");
		textPaneXtT.setAutoscrolls(true);

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

		JLabel lblFirstStepConvert = new JLabel("First step: Convert Number in base 10");

		JButton btnBackT = new JButton("<<");

		btnBackT.setName("btnBackT");
		btnBackT.setEnabled(false);

		JButton btnForwardTtX = new JButton(">>");
		btnForwardTtX.setName("btnForwardT");

		JButton btnAllStepsTtX = new JButton("All Steps");
		btnAllStepsTtX.setName("allStepT");

		JTextPane textPaneTtX = new JTextPane();
		textPaneTtX.setName("textPaneTenToXResult");

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
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textPaneXtT, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
									.addGap(12)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAllStepsXtT, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnForwardXtT, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnBackX, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textPaneTtX, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAllStepsTtX, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnForwardTtX, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnBackT, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))))
							.addGap(28))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFirstStepConvert, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(230, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSecondStepConvert, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(95, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblFirstStepConvert, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBackX)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnForwardXtT)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnAllStepsXtT))
						.addComponent(textPaneXtT, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(lblSecondStepConvert, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBackT)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnForwardTtX)
							.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
							.addComponent(btnAllStepsTtX))
						.addComponent(textPaneTtX))
					.addGap(34))
		);
		setLayout(groupLayout);
		setVisible(true);
	}
}
