package tapaeconverter.aeconverter;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BaseConverterGui extends BasePanel {

	private static final long serialVersionUID = 1L;
	private HashMap<String, Integer> dictionarySym;
	private int baseStart;
	private int baseDest;
	private transient XtoTenConverterCore xToTenConverter;
	private transient TenToXConverterCore tenToXConverter;
	private transient CheckSymbolCore checkSymbol;

	/**
	 * Create the panel.
	 */
	public BaseConverterGui() {

		setBounds(100, 100, 773, 170);
		dictionarySym = new HashMap<>();
		dictionarySym.put("0", 0);
		dictionarySym.put("1", 1);
		dictionarySym.put("2", 2);
		dictionarySym.put("3", 3);
		dictionarySym.put("4", 4);
		dictionarySym.put("5", 5);
		dictionarySym.put("6", 6);
		dictionarySym.put("7", 7);
		dictionarySym.put("8", 8);
		dictionarySym.put("9", 9);
		dictionarySym.put("A", 10);
		dictionarySym.put("B", 11);
		dictionarySym.put("C", 12);
		dictionarySym.put("D", 13);
		dictionarySym.put("E", 14);
		dictionarySym.put("F", 15);

		checkSymbol = new CheckSymbolCore(dictionarySym);
		this.setName("baseConverter");
		Integer[] baseAvailable = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		JComboBox<Integer> bcBaseStart = new JComboBox<>(baseAvailable);
		bcBaseStart.setSelectedIndex(0);
		bcBaseStart.setName("baseStart");

		JComboBox<Integer> bcBaseDest = new JComboBox<>(baseAvailable);
		bcBaseDest.setSelectedIndex(8);

		JTextPane tpNumber = new JTextPane();
		tpNumber.setName("number");

		JButton btnCalc = new JButton("Calculate");
		btnCalc.setName("calc");
		btnCalc.setEnabled(false);

		JTextPane tpResult = new JTextPane();
		tpResult.setName("tpResult");

		JButton btnStepByStep = new JButton("StepByStep");
		btnStepByStep.setName("btnStepByStep");
		btnStepByStep.setEnabled(false);
		btnStepByStep.addActionListener(arg0 -> {
			StepByStepGui p1 = new StepByStepGui(xToTenConverter, tenToXConverter);
			setAncestorPanel(btnStepByStep, p1);
		});

		JLabel lblEnterTheNumber = new JLabel("Enter the number to convert");
		lblEnterTheNumber.setName("enterTheNumber");

		JLabel lblBaseStart = new JLabel("Base Start");
		lblBaseStart.setForeground(Color.BLACK);
		lblBaseStart.setName("baseStart");

		JLabel lblBaseEnd = new JLabel("Base End");
		lblBaseEnd.setName("baseEnd");

		ComponentInteract interactWithbtnCalcola = () -> {
			if (!"".equals(tpNumber.getText())) {
				baseStart = (Integer) bcBaseStart.getSelectedItem();
				baseDest = (Integer) bcBaseDest.getSelectedItem();
				if (checkSymbol.checkSymbols(tpNumber.getText().toUpperCase(), baseStart)) {
					btnCalc.setEnabled(true);
					lblEnterTheNumber.setForeground(new Color(0, 0, 0));
					lblEnterTheNumber.setText("Click convert to continue...");
				} else {
					lblEnterTheNumber.setText("Number is not valid in selected base.");
					lblEnterTheNumber.setForeground(new Color(255, 0, 0));
					btnCalc.setEnabled(false);
				}
			} else {
				lblEnterTheNumber.setText("Enter the number to convert");
				lblEnterTheNumber.setForeground(new Color(0, 0, 0));
				btnCalc.setEnabled(false);
			}
		};

		tpNumber.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent arg0) {
				interactWithbtnCalcola.componentInteraction();
			}
		});
		bcBaseStart.addItemListener(arg0 -> interactWithbtnCalcola.componentInteraction());

		btnCalc.addActionListener(arg0 -> {
			baseStart = (Integer) bcBaseStart.getSelectedItem();
			baseDest = (Integer) bcBaseDest.getSelectedItem();
			String number = tpNumber.getText().toUpperCase();
			xToTenConverter = new XtoTenConverterCore(baseStart, checkSymbol);
			tenToXConverter = new TenToXConverterCore(baseDest);
			number = xToTenConverter.deConvert(number);
			number = tenToXConverter.convert(Integer.parseInt(number));
			tpResult.setText(number);
			btnStepByStep.setEnabled(true);
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblBaseStart, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(lblEnterTheNumber, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblBaseEnd, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(bcBaseStart, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addGap(22)
									.addComponent(tpNumber, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bcBaseDest, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(tpResult)))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCalc, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnStepByStep, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCalc, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(lblBaseStart, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblEnterTheNumber, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblBaseEnd, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(bcBaseStart)
								.addComponent(bcBaseDest)
								.addComponent(tpNumber, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tpResult)
						.addComponent(btnStepByStep, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

		revalidate();
		repaint();
	}

}
