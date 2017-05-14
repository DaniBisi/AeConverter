package TapAeConverter.AeConverter;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

public class baseConverter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public baseConverter() {
		setName("baseConverter");
		setLayout(null);
		Integer[] BaseAvailable = { 2,3,4,5,6,7,8,9,10,11,12,13,14,15,16 };
		JComboBox <Integer>comboBox = new JComboBox<Integer>(BaseAvailable);
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(12, 37, 65, 24);
		add(comboBox);
		
		JComboBox  <Integer>comboBox_1 = new JComboBox<Integer>(BaseAvailable);
		comboBox_1.setSelectedIndex(8);
		comboBox_1.setBounds(373, 37, 65, 24);
		add(comboBox_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(89, 37, 272, 24);
		add(textPane);
		
		JButton btnCalcola = new JButton("Calcola");
		btnCalcola.setBounds(12, 111, 117, 25);
		add(btnCalcola);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(141, 111, 168, 24);
		add(textPane_1);
		
		JButton btnNewButton = new JButton("StepByStep");
		btnNewButton.setBounds(321, 110, 117, 25);
		add(btnNewButton);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.setBounds(12, 235, 117, 25);
		add(btnIndietro);
		
		JButton btnChiudi = new JButton("Chiudi");
		btnChiudi.setBounds(321, 235, 117, 25);
		add(btnChiudi);

	}
}
