package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Status;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Tache;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.TypeTache;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Utilisateur;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao.FenetreUtil;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao.StatusUtil;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao.TacheUtils;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao.UtilisateurUtil;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;

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
					TypeTache tacheTest = new TypeTache(0,"Test",Color.white);
					AjoutTache frame = new AjoutTache(tacheTest);
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
	public AjoutTache(TypeTache typeTacheCreationEnCours) 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		

		
		List<Utilisateur> allUtilisateur = UtilisateurUtil.allUtilisateurs();
		DefaultListModel listModel = new DefaultListModel();
		String[] values = new String[allUtilisateur.size()];
		for(int i=0; i<allUtilisateur.size();i++)
		{
			values[i] = allUtilisateur.get(i).getNomUtilisateur()+"  "+allUtilisateur.get(i).getPrenomUtilisateur();
		}
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 100, 145, 151);
		contentPane.add(scrollPane_1);
		
		
		JList JListUtilisateurs = new JList(values);
		scrollPane_1.setViewportView(JListUtilisateurs);
		JListUtilisateurs.setModel(new AbstractListModel() {
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
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
						List<Utilisateur> utilisateursDepart = new ArrayList<Utilisateur>();
						for(Object unNomSelectionner : JListUtilisateurs.getSelectedValues())
						{
							Utilisateur utilisateurSelectionner = UtilisateurUtil.getUtilisateurParNomPrenom(unNomSelectionner.toString());
							utilisateursDepart.add(utilisateurSelectionner);
							
						}
						
						Tache tacheCree = new Tache(JTextNomTache.getText(),statusDepart,utilisateursDepart, typeTacheCreationEnCours);
						TacheUtils.enregistrerTache(tacheCree);
						for(Utilisateur unUtilisateur : utilisateursDepart)
						{
							UtilisateurUtil.ajoutTacheUtilisateur( unUtilisateur, tacheCree);
						}
						FenetreUtil.actualiserTache();
						JOptionPane validationEnregistrement = new JOptionPane();
						validationEnregistrement.showMessageDialog(validationEnregistrement, "Enregistrement effectué avec succès","Succès de l'enregistrement", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						
					}
					
				}
				
				
			}
		});
		btnCrerTche.setBounds(165, 200, 89, 23);
		contentPane.add(btnCrerTche);
		
		JLabel lblSelectionnerLesUtilisateurs = new JLabel("Selectionner les utilisateurs");
		lblSelectionnerLesUtilisateurs.setBounds(10, 73, 146, 14);
		contentPane.add(lblSelectionnerLesUtilisateurs);
		
		JLabel lblMaintenirCtrlPour = new JLabel("Maintenir ctrl pour selectionner plusieurs personne");
		lblMaintenirCtrlPour.setBounds(165, 102, 259, 20);
		contentPane.add(lblMaintenirCtrlPour);
		
		
	}
}
