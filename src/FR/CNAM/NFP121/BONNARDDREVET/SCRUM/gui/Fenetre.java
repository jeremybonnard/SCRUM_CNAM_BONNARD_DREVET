package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Tache;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.TypeTache;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao.FenetreUtil;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao.TacheUtils;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.border.BevelBorder;
import javax.swing.JTextPane;

public class Fenetre extends JFrame {

	private JPanel contentPane;
	public static Fenetre fenetreMere;
	private JMenu mnFichier;
	private JMenu mnEquipe;
	private JMenu mnTche;
	private JMenu mnAPropos;
	private JPanel JPanelAFaire;
	private JPanel JPanelEnCours;
	private JPanel JPanelEnTest;
	private JPanel JPanelFini;
	private JLabel lblAFaire;
	private JLabel lblEnCours;
	private JLabel lblEnTest;
	private JLabel lblFini;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre frame = new Fenetre();
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
	public Fenetre() {
		setType(Type.UTILITY);
		Fenetre.fenetreMere = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 906, 474);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmSauvegarder = new JMenuItem("Sauvegarder");
		mnFichier.add(mntmSauvegarder);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
		mnFichier.add(mntmQuitter);
		
		mnEquipe = new JMenu("Equipe");
		menuBar.add(mnEquipe);
		
		FenetreUtil.actualiserUtilisateur();
		
		mnTche = new JMenu("T\u00E2che");
		menuBar.add(mnTche);
		
		JMenuItem mntmNouvelleFonctionnalit = new JMenuItem("Nouvelle Fonctionnalit\u00E9");
		mntmNouvelleFonctionnalit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				TypeTache typeTacheCreationEnCours = new TypeTache(0, "Fonctionnalitee",Color.blue);
				AjoutTache nvAjoutTache = new AjoutTache(typeTacheCreationEnCours);
				nvAjoutTache.setVisible(true);
				
				
				
			}
		});
		mnTche.add(mntmNouvelleFonctionnalit);
		
		JMenuItem mntmNouvelleAmlioration = new JMenuItem("Nouvelle Am\u00E9lioration");
		mntmNouvelleAmlioration.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				TypeTache typeTacheCreationEnCours = new TypeTache(1,"Amélioration",Color.green);
				AjoutTache nvAjoutTache = new AjoutTache(typeTacheCreationEnCours);
				nvAjoutTache.setVisible(true);
			}
		});
		mnTche.add(mntmNouvelleAmlioration);
		
		JMenuItem mntmNouveauBug = new JMenuItem("Nouveau Bug");
		mntmNouveauBug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TypeTache typeTacheCreationEnCours = new TypeTache(1,"Bug",Color.orange);
				AjoutTache nvAjoutTache = new AjoutTache(typeTacheCreationEnCours);
				nvAjoutTache.setVisible(true);
				
			}
		});
		mnTche.add(mntmNouveauBug);
		
		JMenuItem mntmNouveauSpike = new JMenuItem("Nouveau Spike");
		mntmNouveauSpike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TypeTache typeTacheCreationEnCours = new TypeTache(1,"Spike",Color.magenta);
				AjoutTache nvAjoutTache = new AjoutTache(typeTacheCreationEnCours);
				nvAjoutTache.setVisible(true);
				
			}
		});
		mnTche.add(mntmNouveauSpike);
		
		mnAPropos = new JMenu("A propos");
		menuBar.add(mnAPropos);
		
		JMenuItem mntmAPropos = new JMenuItem("A propos");
		mntmAPropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane aPropos = new JOptionPane();
			
				aPropos.showMessageDialog(aPropos, "Nom : ScrumBoard\nDevelopper : Jeremy Bonnard et Vincent DREVET\nVersion : 1.0\nDate de réalisation :  25 mars 2016\nLicence GPL :p", "A propos", JOptionPane.INFORMATION_MESSAGE);

				
			}
		});
		mntmAPropos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		mnAPropos.add(mntmAPropos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		List<Tache> allTache = TacheUtils.allTaches();
		List<String> status = new ArrayList<String>();
		status.add("A Faire");
		status.add("2");
		status.add("3");
		for(int i =0; i<5; i++){
			
		}
		
		JPanelAFaire = new JPanel();
		JPanelAFaire.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JPanelAFaire.setBounds(27, 36, 200, 366);
		contentPane.add(JPanelAFaire);
		JPanelAFaire.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanelEnCours = new JPanel();
		JPanelEnCours.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JPanelEnCours.setBounds(237, 36, 200, 366);
		contentPane.add(JPanelEnCours);
		JPanelEnCours.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanelEnTest = new JPanel();
		JPanelEnTest.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JPanelEnTest.setBounds(447, 36, 200, 366);
		contentPane.add(JPanelEnTest);
		JPanelEnTest.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanelFini = new JPanel();
		JPanelFini.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JPanelFini.setBounds(657, 36, 200, 366);
		contentPane.add(JPanelFini);
		JPanelFini.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblAFaire = new JLabel("A Faire ");
		lblAFaire.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAFaire.setBounds(91, 0, 74, 25);
		contentPane.add(lblAFaire);
		
		lblEnCours = new JLabel("En Cours");
		lblEnCours.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnCours.setBounds(306, 0, 85, 25);
		contentPane.add(lblEnCours);
		
		lblEnTest = new JLabel("En Test");
		lblEnTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnTest.setBounds(516, 1, 85, 23);
		contentPane.add(lblEnTest);
		
		lblFini = new JLabel("Fini");
		lblFini.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFini.setBounds(734, 0, 85, 25);
		contentPane.add(lblFini);
		Fenetre.fenetreMere = this;
		FenetreUtil.actualiserTache();

	}

	public JMenu getMenuFichier() {
		return mnFichier;
	}
	public JMenu getMenuEquipe() {
		return mnEquipe;
	}
	public JMenu getMenuTache() {
		return mnTche;
	}
	public JMenu getMenuAPropos() {
		return mnAPropos;
	}
	public JPanel getJPanelAFaire() {
		return JPanelAFaire;
	}
	public JPanel getJPanelEnCours() {
		return JPanelEnCours;
	}
	public JPanel getJPanelEnTest() {
		return JPanelEnTest;
	}
	public JPanel getJPanelFini() {
		return JPanelFini;
	}
}
