package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.TypeTache;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fenetre extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenu mnEquipe = new JMenu("Equipe");
		menuBar.add(mnEquipe);
		
		JMenu mnTche = new JMenu("T\u00E2che");
		menuBar.add(mnTche);
		
		JMenuItem mntmNouvelleFonctionnalit = new JMenuItem("Nouvelle Fonctionnalit\u00E9");
		mntmNouvelleFonctionnalit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TypeTache typeTacheCreationEnCours = new TypeTache(0, "Fonctionnalitee","#00000");
				AjoutTache nvAjoutTache = new AjoutTache(typeTacheCreationEnCours);
				nvAjoutTache.setVisible(true);
				
				
				
			}
		});
		mnTche.add(mntmNouvelleFonctionnalit);
		
		JMenuItem mntmNouvelleAmlioration = new JMenuItem("Nouvelle Am\u00E9lioration");
		mnTche.add(mntmNouvelleAmlioration);
		
		JMenuItem mntmNouveauBug = new JMenuItem("Nouveau Bug");
		mnTche.add(mntmNouveauBug);
		
		JMenuItem mntmNouveauSpike = new JMenuItem("Nouveau Spike");
		mnTche.add(mntmNouveauSpike);
		
		JMenu mnAPropos = new JMenu("A propos");
		menuBar.add(mnAPropos);
		
		JMenuItem mntmAPropos = new JMenuItem("A propos");
		mntmAPropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane aPropos = new JOptionPane();
			
				aPropos.showMessageDialog(aPropos, "Ceci est l'a propos", "A propos", JOptionPane.INFORMATION_MESSAGE);

				
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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
