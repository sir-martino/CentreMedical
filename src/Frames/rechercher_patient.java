package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Code.*;
public class rechercher_patient extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rechercher_patient frame = new rechercher_patient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public rechercher_patient() {
		setTitle("rechercher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel PatientICI = new JLabel("patient");
		PatientICI.setBounds(41, 11, 347, 79);
		contentPane.add(PatientICI);
		
		JButton btnNewButton = new JButton("modifier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifier_patient modifierpatient = new modifier_patient();
				modifierpatient.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 133, 120, 58);
		contentPane.add(btnNewButton);
		
		JButton suppr = new JButton("supprimer");
		suppr.setBounds(297, 133, 129, 58);
		contentPane.add(suppr);
		suppr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				basePatient basePat = new basePatient("ListePatient.txt");
				//basePat.supprimerPatient();
			}

			
		});
	}
}
