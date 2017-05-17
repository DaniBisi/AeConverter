package TapAeConverter.AeConverter;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import TapAeConverter.AeConverter.CheckSymbol;
import TapAeConverter.AeConverter.ComponentInteract;
import TapAeConverter.AeConverter.TenToXConverter;
import TapAeConverter.AeConverter.XtoTenConverter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class BaseConverter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<String, Integer> DictionarySym;
	private int baseStart;
	private int baseDest;
	private JFrame frameP;
	private XtoTenConverter conv;
	private TenToXConverter conv1;
	private CheckSymbol checkSymbol;

	/**
	 * Create the panel.
	 */
	public BaseConverter() {
		DictionarySym = new HashMap<String, Integer>();
		DictionarySym.put("0", 0);
		DictionarySym.put("1", 1);
		DictionarySym.put("2", 2);
		DictionarySym.put("3", 3);
		DictionarySym.put("4", 4);
		DictionarySym.put("5", 5);
		DictionarySym.put("6", 6);
		DictionarySym.put("7", 7);
		DictionarySym.put("8", 8);
		DictionarySym.put("9", 9);
		DictionarySym.put("A", 10);
		DictionarySym.put("B", 11);
		DictionarySym.put("C", 12);
		DictionarySym.put("D", 13);
		DictionarySym.put("E", 14);
		DictionarySym.put("F", 15);


		setBounds(100, 100, 450, 350);
		checkSymbol = new CheckSymbol(DictionarySym);
		this.setName("baseConverter");
		setLayout(null);
		Integer[] baseAvailable = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		JComboBox <Integer>cbBaseStart = new JComboBox(baseAvailable);

		cbBaseStart.setSelectedIndex(0);
		cbBaseStart.setName("baseStart");
		cbBaseStart.setBounds(12, 37, 65, 24);
		add(cbBaseStart);

		JComboBox <Integer>cbBaseDest = new JComboBox(baseAvailable);
		cbBaseDest.setSelectedIndex(8);
		cbBaseDest.setBounds(373, 37, 65, 24);
		add(cbBaseDest);

		JTextPane tpNumber = new JTextPane();
		tpNumber.setName("Number");
		tpNumber.setBounds(99, 37, 248, 24);
		add(tpNumber);

		JButton btnCalcola = new JButton("Calcola");
		btnCalcola.setName("Calcola");
		btnCalcola.setEnabled(false);
		btnCalcola.setBounds(12, 111, 117, 25);
		add(btnCalcola);

		JTextPane tpResult = new JTextPane();
		tpResult.setName("tpResult");
		tpResult.setBounds(141, 111, 168, 24);
		add(tpResult);

		JButton btnStepByStep = new JButton("StepByStep");
		btnStepByStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StepByStep p1 = new StepByStep(conv,conv1);
				JFrame ancestor = (JFrame) SwingUtilities.getWindowAncestor(btnStepByStep);
				ancestor.getContentPane().removeAll();
				ancestor.getContentPane().add(p1);
				ancestor.getContentPane().setVisible(true);
				ancestor.revalidate();
			}
		});
		btnStepByStep.setBounds(321, 110, 117, 25);
		btnStepByStep.setEnabled(false);
		add(btnStepByStep);

		JButton btnBack = new JButton("indietro");
		
		
		btnBack.setName("indietro1");
		btnBack.setBounds(12, 235, 117, 25);

		add(btnBack);
		JButton btnChiudi = new JButton("Chiudi");
		btnChiudi.setName("chiudi");
		btnChiudi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);

			}
		});
		btnChiudi.setBounds(321, 235, 117, 25);
		add(btnChiudi);
		
		JLabel lblEnterTheNumber = new JLabel("Enter the number to convert");
		lblEnterTheNumber.setName("enterTheNumber");
		lblEnterTheNumber.setBounds(99, 12, 223, 25);
		add(lblEnterTheNumber);
		
		JLabel lblBaseStart = new JLabel("Base Start");
		lblBaseStart.setForeground(Color.BLACK);
		lblBaseStart.setName("baseStart");
		lblBaseStart.setBounds(12, 14, 81, 20);
		add(lblBaseStart);
		
		JLabel lblBaseEnd = new JLabel("Base End");
		lblBaseEnd.setName("baseEnd");
		lblBaseEnd.setBounds(373, 14, 70, 20);
		add(lblBaseEnd);
		
		ComponentInteract InteractWithbtnCalcola = new ComponentInteract() {
			@Override
			public void componentInteraction() {
				if (!"".equals(tpNumber.getText())) {
					baseStart = (Integer) cbBaseStart.getSelectedItem();
					baseDest = (Integer) cbBaseDest.getSelectedItem();
					if (checkSymbol.checkSymbols(tpNumber.getText().toUpperCase(), baseStart)) {
						btnCalcola.setEnabled(true);
						lblEnterTheNumber.setForeground(new Color(0, 0, 0));
						lblEnterTheNumber.setText("Click convert to continue...");
					} else {

						lblEnterTheNumber.setText("Number is not valid in selected base.");
						lblEnterTheNumber.setForeground(new Color(255, 0, 0));
						btnCalcola.setEnabled(false);
					}
				} else {
					lblEnterTheNumber.setText("Enter the number to convert");
					lblEnterTheNumber.setForeground(new Color(0, 0, 0));
					btnCalcola.setEnabled(false);
				}
			}
		};

		tpNumber.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent arg0) {
				InteractWithbtnCalcola.componentInteraction();
			}
		});
		cbBaseStart.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				InteractWithbtnCalcola.componentInteraction();
			}
		});
		
		//################### I LISTENERE LI DEVO AGGIUNGERE QUANOD È ABILITATO ALTRIMENTI ERRORE
		btnCalcola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				baseStart = (Integer) cbBaseStart.getSelectedItem();
				baseDest = (Integer) cbBaseDest.getSelectedItem();
				String Number = tpNumber.getText().toUpperCase();
				conv = new XtoTenConverter(baseStart,checkSymbol);
				conv1 = new TenToXConverter(baseDest);
				Number = conv.deConvert(Number);
				Number = conv1.convert(Integer.parseInt(Number));
				tpResult.setText(Number);
				btnStepByStep.setEnabled(true);
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MakeChoise p1 = new MakeChoise();
				JFrame ancestor = (JFrame) SwingUtilities.getWindowAncestor(btnBack);
				ancestor.getContentPane().removeAll();
				ancestor.getContentPane().add(p1);
				ancestor.getContentPane().setVisible(true);
				ancestor.revalidate();
			}
		});
	}
	public void setParentFrame(JFrame fParent){
		frameP = fParent;
	}
}
