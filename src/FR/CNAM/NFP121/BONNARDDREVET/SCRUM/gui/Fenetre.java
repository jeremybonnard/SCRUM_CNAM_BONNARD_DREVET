package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.gui;

import java.awt.BorderLayout;
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
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class Fenetre extends JFrame {

	private JPanel contentPane;
	public static Fenetre fenetreMere;
	private JMenu mnFichier;
	private JMenu mnEquipe;
	private JMenu mnTche;
	private JMenu mnAPropos;
	private JTable tableTache;
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
		Fenetre.fenetreMere = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
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
				TypeTache typeTacheCreationEnCours = new TypeTache(0, "Fonctionnalitee","#4040A4");
				AjoutTache nvAjoutTache = new AjoutTache(typeTacheCreationEnCours);
				nvAjoutTache.setVisible(true);
				
				
				
			}
		});
		mnTche.add(mntmNouvelleFonctionnalit);
		
		JMenuItem mntmNouvelleAmlioration = new JMenuItem("Nouvelle Am\u00E9lioration");
		mntmNouvelleAmlioration.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				TypeTache typeTacheCreationEnCours = new TypeTache(1,"Amélioration","#40A451");
				AjoutTache nvAjoutTache = new AjoutTache(typeTacheCreationEnCours);
				nvAjoutTache.setVisible(true);
			}
		});
		mnTche.add(mntmNouvelleAmlioration);
		
		JMenuItem mntmNouveauBug = new JMenuItem("Nouveau Bug");
		mntmNouveauBug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TypeTache typeTacheCreationEnCours = new TypeTache(1,"Bug","#C03000");
				AjoutTache nvAjoutTache = new AjoutTache(typeTacheCreationEnCours);
				nvAjoutTache.setVisible(true);
				
			}
		});
		mnTche.add(mntmNouveauBug);
		
		JMenuItem mntmNouveauSpike = new JMenuItem("Nouveau Spike");
		mntmNouveauSpike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TypeTache typeTacheCreationEnCours = new TypeTache(1,"Spike","#4A1A2C");
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
		tableTache = new JTable(allTache.size()+1,4);
		tableTache.setRowSelectionAllowed(false);
		tableTache.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableTache.setModel(new DefaultTableModel(
			new Object[][] {
				{"A Faire", "En Cours", "En Test", "Fini"},
				{null, null, null, null},
			},
			new String[] {
				"A", "B", "C", "D"
			}
		));
		tableTache.setToolTipText("");
		
		tableTache.setBounds(27, 11, 376, 80);
		
		contentPane.add(tableTache);
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
	
}
