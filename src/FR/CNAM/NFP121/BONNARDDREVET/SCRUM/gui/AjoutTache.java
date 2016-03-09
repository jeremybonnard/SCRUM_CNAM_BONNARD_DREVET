package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Status;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Tache;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Utilisateur;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao.StatusUtil;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AjoutTache extends JFrame {

	private JPanel contentPane;
	private JTextField JTextNomTache;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutTache frame = new AjoutTache();
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
	public AjoutTache() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextNomTache = new JTextField();
		JTextNomTache.setBounds(10, 42, 191, 20);
		contentPane.add(JTextNomTache);
		JTextNomTache.setColumns(10);
		
		JLabel lblNomDeLa = new JLabel("Nom de la tache");
		lblNomDeLa.setBounds(10, 17, 88, 14);
		contentPane.add(lblNomDeLa);
		
		JList JListUtilisateurs = new JList();
		JListUtilisateurs.setModel(new AbstractListModel() {
			String[] values = new String[] {"toto", "titi", "tata"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		JListUtilisateurs.setBounds(10, 98, 95, 82);
		contentPane.add(JListUtilisateurs);
		
		JButton btnCrerTche = new JButton("Cr\u00E9er t\u00E2che");
		btnCrerTche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//test nom manquant
				System.out.println(JTextNomTache.getText());
				if(JTextNomTache.getText().equals(""))
				{
					JOptionPane erreurAbsenceText = new JOptionPane();
					erreurAbsenceText.showMessageDialog(erreurAbsenceText, "Nom Manquant", "Erreur", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					if(JListUtilisateurs.isSelectionEmpty())
					{
						JOptionPane erreurAbsenceUtilisateur = new JOptionPane();
						erreurAbsenceUtilisateur.showMessageDialog(erreurAbsenceUtilisateur, "Aucun utilisateur selectionné", "Erreur", JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						Status statusDepart = StatusUtil.getStatusDepart();
						List<Utilisateur> utilisateurDepart = new ArrayList<Utilisateur>();
						
						Tache tacheCree = new Tache(JTextNomTache.getText(),statusDepart,utilisateurDepart);
						
						
					}
					System.out.println("OK");
				}
				System.out.println("Fin");
				
			}
		});
		btnCrerTche.setBounds(165, 200, 89, 23);
		contentPane.add(btnCrerTche);
		
		JLabel lblSelectionnerLesUtilisateurs = new JLabel("Selectionner les utilisateurs");
		lblSelectionnerLesUtilisateurs.setBounds(10, 73, 146, 14);
		contentPane.add(lblSelectionnerLesUtilisateurs);
		
		JLabel lblMaintenirCtrlPour = new JLabel("Maintenir ctrl pour selectionner plusieurs personne");
		lblMaintenirCtrlPour.setBounds(115, 116, 301, 20);
		contentPane.add(lblMaintenirCtrlPour);
	}
}
