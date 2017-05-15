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
import java.util.Iterator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class baseConverter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<String, Integer> DictionarySym;
	private int baseStart;
	private int baseDest;
	private JFrame frameP;

	/**
	 * Create the panel.
	 */
	public baseConverter() {
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

		CheckSymbol c1 = new CheckSymbol(DictionarySym);
		setName("baseConverter");
		setLayout(null);
		Integer[] BaseAvailable = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		JComboBox comboBox = new JComboBox(BaseAvailable);

		comboBox.setSelectedIndex(0);
		comboBox.setName("baseStart");
		comboBox.setBounds(12, 37, 65, 24);
		add(comboBox);

		JComboBox comboBox_1 = new JComboBox(BaseAvailable);
		comboBox_1.setSelectedIndex(8);
		comboBox_1.setBounds(373, 37, 65, 24);
		add(comboBox_1);

		JTextPane textPane = new JTextPane();
		textPane.setName("Number");
		textPane.setBounds(89, 37, 272, 24);
		add(textPane);

		JButton btnCalcola = new JButton("Calcola");
		btnCalcola.setName("Calcola");
		btnCalcola.setEnabled(false);
		btnCalcola.setBounds(12, 111, 117, 25);
		add(btnCalcola);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(141, 111, 168, 24);
		add(textPane_1);

		JButton btnNewButton = new JButton("StepByStep");
		btnNewButton.setBounds(321, 110, 117, 25);
		add(btnNewButton);

		JButton btnIndietro = new JButton("Indietro");
		
		
		btnIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("sono qua"+frameP.toString());
				System.out.println("sono qua1"+frameP.toString());
				MakeChoise p1 = new MakeChoise();
				p1.setFrameP(frameP);
				frameP.getContentPane().removeAll();
				frameP.getContentPane().add(p1);
				frameP.getContentPane().setVisible(true);
				frameP.revalidate();
				frameP.repaint();
			}
		});
		btnIndietro.setBounds(12, 235, 117, 25);
		add(btnIndietro);

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
		
		
		ComponentInteract InteractWithbtnCalcola = new ComponentInteract() {
			@Override
			public void ComponentInteract() {
				if (!textPane.getText().equals("")) {
					baseStart = (Integer) comboBox.getSelectedItem();
					baseDest = (Integer) comboBox_1.getSelectedItem();
					if (c1.checkSymbols(textPane.getText(), baseStart)) {
						btnCalcola.setEnabled(true);
					} else {
						btnCalcola.setEnabled(false);
					}
				} else {
					btnCalcola.setEnabled(false);
				}
			}
		};

		textPane.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent arg0) {
				InteractWithbtnCalcola.ComponentInteract();
			}
		});
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				InteractWithbtnCalcola.ComponentInteract();
			}
		});
		btnCalcola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				baseStart = (Integer) comboBox.getSelectedItem();
				baseDest = (Integer) comboBox_1.getSelectedItem();
				String Number = textPane.getText();
				XtoTenConverter conv = new XtoTenConverter(baseStart);
				TenToXConverter conv1 = new TenToXConverter(baseDest);
				Number = conv.deConvert(Number);
				Number = conv1.convert(Integer.parseInt(Number));
				textPane_1.setText(Number);
			}
		});
	}
	public void setParentFrame(JFrame fParent){
		frameP = fParent;
	}

}
