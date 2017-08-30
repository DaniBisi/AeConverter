package tapaeconverter.aeconverter;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

		setBounds(100, 100, 450, 350);
		checkSymbol = new CheckSymbolCore(dictionarySym);
		this.setName("baseConverter");
		setLayout(null);
		Integer[] baseAvailable = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		JComboBox<Integer> bcBaseStart = new JComboBox<>(baseAvailable);

		bcBaseStart.setSelectedIndex(0);
		bcBaseStart.setName("baseStart");
		bcBaseStart.setBounds(12, 37, 65, 24);

		JComboBox<Integer> bcBaseDest = new JComboBox<>(baseAvailable);
		bcBaseDest.setSelectedIndex(8);
		bcBaseDest.setBounds(373, 37, 65, 24);

		JTextPane tpNumber = new JTextPane();
		tpNumber.setName("number");
		tpNumber.setBounds(99, 37, 248, 24);

		JButton btnCalc = new JButton("Calculate");
		btnCalc.setName("calc");
		btnCalc.setEnabled(false);
		btnCalc.setBounds(12, 111, 117, 25);

		JTextPane tpResult = new JTextPane();
		tpResult.setName("tpResult");
		tpResult.setBounds(141, 111, 168, 24);

		JButton btnStepByStep = new JButton("StepByStep");
		btnStepByStep.setName("btnStepByStep");
		btnStepByStep.addActionListener(arg0 -> {
			StepByStepGui p1 = new StepByStepGui(xToTenConverter, tenToXConverter);
			setAncestorPanel(btnStepByStep,p1, new int[]{450,390});
		});
		btnStepByStep.setBounds(321, 110, 117, 25);
		btnStepByStep.setEnabled(false);

		JButton btnBack = new JButton("Back");

		btnBack.setName("back");
		btnBack.setBounds(12, 235, 117, 25);

		add(btnBack);
		JButton btnClose = new JButton("Close");
		btnClose.setName("close");
		btnClose.addActionListener(arg0 -> {
			JFrame ancestor = (JFrame) SwingUtilities.getWindowAncestor(btnClose);
			ancestor.dispose();
		});
		btnClose.setBounds(321, 235, 117, 25);

		JLabel lblEnterTheNumber = new JLabel("Enter the number to convert");
		lblEnterTheNumber.setName("enterTheNumber");
		lblEnterTheNumber.setBounds(99, 12, 223, 25);

		JLabel lblBaseStart = new JLabel("Base Start");
		lblBaseStart.setForeground(Color.BLACK);
		lblBaseStart.setName("baseStart");
		lblBaseStart.setBounds(12, 14, 81, 20);

		JLabel lblBaseEnd = new JLabel("Base End");
		lblBaseEnd.setName("baseEnd");
		lblBaseEnd.setBounds(373, 14, 70, 20);

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

		btnBack.addActionListener(arg0 -> {
			MakeChoiseGui p1 = new MakeChoiseGui();
			setAncestorPanel(btnBack,p1,null);
			
		});

		add(lblBaseEnd);
		add(lblBaseStart);
		add(lblEnterTheNumber);
		add(btnClose);
		add(btnStepByStep);
		add(tpResult);
		add(btnCalc);
		add(tpNumber);
		add(bcBaseDest);
		add(bcBaseStart);

		revalidate();
		repaint();
	}

}
