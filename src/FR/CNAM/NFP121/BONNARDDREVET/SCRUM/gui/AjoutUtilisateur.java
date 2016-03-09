package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;

public class AjoutUtilisateur extends JFrame {

	private JPanel contentPane;
	private JTextField JTextNom;
	private JTextField JTextPrenom;
	private JTextField JTextEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutUtilisateur frame = new AjoutUtilisateur();
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
	public AjoutUtilisateur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAjoutDunUtilisateur = new JLabel("Ajout d'un utilisateur");
		lblAjoutDunUtilisateur.setBounds(177, 26, 115, 14);
		contentPane.add(lblAjoutDunUtilisateur);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 98, 46, 14);
		contentPane.add(lblNom);
		
		JTextNom = new JTextField();
		JTextNom.setBounds(10, 123, 86, 20);
		contentPane.add(JTextNom);
		JTextNom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(10, 169, 46, 14);
		contentPane.add(lblPrenom);
		
		JTextPrenom = new JTextField();
		JTextPrenom.setBounds(10, 194, 86, 20);
		contentPane.add(JTextPrenom);
		JTextPrenom.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(159, 98, 46, 14);
		contentPane.add(lblEmail);
		
		JTextEmail = new JTextField();
		JTextEmail.setBounds(148, 123, 86, 20);
		contentPane.add(JTextEmail);
		JTextEmail.setColumns(10);
		
		JLabel lblDateDeNaissance = new JLabel("Date de naissance");
		lblDateDeNaissance.setBounds(148, 169, 100, 14);
		contentPane.add(lblDateDeNaissance);
		
		JDateChooser JCalendarDateNaissance = new JDateChooser();
		JCalendarDateNaissance.setBounds(148, 194, 144, 20);
		contentPane.add(JCalendarDateNaissance);
		
		JButton btnValider = new JButton("Valider");
		
		
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JTextNom.getText().equals(""))
				{
					JOptionPane erreurAbsenceText = new JOptionPane();
					erreurAbsenceText.showMessageDialog(erreurAbsenceText, "Nom Manquant", "Erreur", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					
					if(JTextPrenom.getText().equals(""))
					{
						JOptionPane erreurAbsenceText = new JOptionPane();
						erreurAbsenceText.showMessageDialog(erreurAbsenceText, "Prenom Manquant", "Erreur", JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						if(JTextEmail.getText().equals(""))
						{
							JOptionPane erreurAbsenceText = new JOptionPane();
							erreurAbsenceText.showMessageDialog(erreurAbsenceText, "Adresse E-mail manquante", "Erreur", JOptionPane.WARNING_MESSAGE);
						}
						else
						{
							//Date dateEntreUtilisateur = JCalendarDateNaissance.getDate();
							if(JCalendarDateNaissance.getDate() == null)
							{
								JOptionPane erreurAbsenceText = new JOptionPane();
								erreurAbsenceText.showMessageDialog(erreurAbsenceText, "Date de naissance manquante ou invalide", "Erreur", JOptionPane.WARNING_MESSAGE);
							}
							else
							{
								JOptionPane validationEnregistrement = new JOptionPane();
								validationEnregistrement.showMessageDialog(validationEnregistrement, "Enregistrement effectu� avec succ�s","Succ�s de l'enregistrement", JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}
							
						
						
						}
						
						
						
					}
					
					
				}
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnValider.setBounds(300, 148, 89, 23);
		contentPane.add(btnValider);
		

		
		
	}
}
