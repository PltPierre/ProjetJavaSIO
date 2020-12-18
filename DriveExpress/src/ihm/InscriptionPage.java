package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InscriptionPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel leftSide;
    private JPanel topBar;
    private JLabel lblExitBtn;
    private JLabel lblMail;
    private JTextField txtMail;
    private JLabel lblPrenom;
    private JTextField txtPrenom;
    private JLabel lblNom;
    private JTextField txtNom;
    private JLabel lblTel;
    private JTextField txtTel;
    private JLabel lblAdresse;
    private JTextField txtAdresse;
    private JLabel lblVille;
    private JTextField txtVille;
    private JTextField txtCP;
    private JLabel lblCodePoste;
    private JButton btnCreerCompte;
    private Connection connect;
    private JButton btnRetour;

    public InscriptionPage(Connection connection) {
	this.connect = connection;

	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1080, 624);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	leftSide = new JPanel();
	leftSide.setBackground(SystemColor.windowBorder);
	leftSide.setBounds(0, 26, 535, 612);
	contentPane.add(leftSide);
	leftSide.setLayout(null);

	topBar = new JPanel();
	topBar.setBackground(SystemColor.activeCaptionBorder);
	topBar.setBounds(0, 0, 1086, 27);
	contentPane.add(topBar);
	topBar.setLayout(null);

	lblExitBtn = new JLabel("X");
	lblExitBtn.setToolTipText("Fermer");
	lblExitBtn.setForeground(Color.RED);

	lblExitBtn.setBackground(Color.WHITE);
	lblExitBtn.setFont(new Font("Arial Black", Font.BOLD, 18));
	lblExitBtn.setHorizontalAlignment(SwingConstants.CENTER);
	lblExitBtn.setBounds(1018, 0, 68, 27);
	topBar.add(lblExitBtn);

	lblMail = new JLabel("Mail");
	lblMail.setFont(new Font("Arial", Font.PLAIN, 16));
	lblMail.setHorizontalAlignment(SwingConstants.CENTER);
	lblMail.setBounds(567, 51, 46, 14);
	contentPane.add(lblMail);

	txtMail = new JTextField();
	txtMail.setFont(new Font("Arial", Font.PLAIN, 16));
	txtMail.setBounds(577, 76, 414, 35);
	contentPane.add(txtMail);
	txtMail.setColumns(10);

	lblPrenom = new JLabel("Pr\u00E9nom");
	lblPrenom.setHorizontalAlignment(SwingConstants.CENTER);
	lblPrenom.setFont(new Font("Arial", Font.PLAIN, 16));
	lblPrenom.setBounds(576, 122, 55, 14);
	contentPane.add(lblPrenom);

	txtPrenom = new JTextField();
	txtPrenom.setFont(new Font("Arial", Font.PLAIN, 16));
	txtPrenom.setColumns(10);
	txtPrenom.setBounds(577, 147, 414, 35);
	contentPane.add(txtPrenom);

	lblNom = new JLabel("Nom");
	lblNom.setHorizontalAlignment(SwingConstants.CENTER);
	lblNom.setFont(new Font("Arial", Font.PLAIN, 16));
	lblNom.setBounds(573, 193, 40, 14);
	contentPane.add(lblNom);

	txtNom = new JTextField();
	txtNom.setFont(new Font("Arial", Font.PLAIN, 16));
	txtNom.setColumns(10);
	txtNom.setBounds(577, 218, 414, 35);
	contentPane.add(txtNom);

	lblTel = new JLabel("T\u00E9l\u00E9phone");
	lblTel.setHorizontalAlignment(SwingConstants.CENTER);
	lblTel.setFont(new Font("Arial", Font.PLAIN, 16));
	lblTel.setBounds(577, 264, 73, 19);
	contentPane.add(lblTel);

	txtTel = new JTextField();
	txtTel.setFont(new Font("Arial", Font.PLAIN, 16));
	txtTel.setColumns(10);
	txtTel.setBounds(577, 289, 414, 35);
	contentPane.add(txtTel);

	lblAdresse = new JLabel("Adresse");
	lblAdresse.setHorizontalAlignment(SwingConstants.CENTER);
	lblAdresse.setFont(new Font("Arial", Font.PLAIN, 16));
	lblAdresse.setBounds(577, 335, 66, 19);
	contentPane.add(lblAdresse);

	txtAdresse = new JTextField();
	txtAdresse.setFont(new Font("Arial", Font.PLAIN, 16));
	txtAdresse.setColumns(10);
	txtAdresse.setBounds(577, 365, 414, 35);
	contentPane.add(txtAdresse);

	lblVille = new JLabel("Ville");
	lblVille.setHorizontalAlignment(SwingConstants.CENTER);
	lblVille.setFont(new Font("Arial", Font.PLAIN, 16));
	lblVille.setBounds(567, 411, 46, 19);
	contentPane.add(lblVille);

	txtVille = new JTextField();
	txtVille.setFont(new Font("Arial", Font.PLAIN, 16));
	txtVille.setColumns(10);
	txtVille.setBounds(577, 441, 169, 35);
	contentPane.add(txtVille);

	txtCP = new JTextField();
	txtCP.setFont(new Font("Arial", Font.PLAIN, 16));
	txtCP.setColumns(10);
	txtCP.setBounds(822, 441, 169, 35);
	contentPane.add(txtCP);

	lblCodePoste = new JLabel("Code Postal");
	lblCodePoste.setHorizontalAlignment(SwingConstants.CENTER);
	lblCodePoste.setFont(new Font("Arial", Font.PLAIN, 16));
	lblCodePoste.setBounds(822, 411, 87, 19);
	contentPane.add(lblCodePoste);

	btnCreerCompte = new JButton("Cr\u00E9er un compte");
	btnCreerCompte.setForeground(Color.BLACK);
	btnCreerCompte.setFont(new Font("Arial", Font.PLAIN, 16));
	btnCreerCompte.setFocusable(false);
	btnCreerCompte.setBorderPainted(false);
	btnCreerCompte.setBackground(Color.GREEN);
	btnCreerCompte.setBounds(577, 502, 169, 43);
	contentPane.add(btnCreerCompte);

	btnRetour = new JButton("Retour");
	btnRetour.setForeground(Color.BLACK);
	btnRetour.setFont(new Font("Arial", Font.PLAIN, 16));
	btnRetour.setFocusable(false);
	btnRetour.setBorderPainted(false);
	btnRetour.setBackground(Color.GRAY);
	btnRetour.setBounds(822, 502, 169, 43);
	contentPane.add(btnRetour);

	lblExitBtn.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblExitBtn) {
		    if (connect != null) {
			try {
			    connect.close();
			} catch (SQLException e1) {
			    e1.printStackTrace();
			}
		    }
		    try {
			if (connect.isClosed()) {
			    dispose();
			} else {
			    System.out.println("db pas fermé");
			}
		    } catch (SQLException e1) {
			e1.printStackTrace();
		    }
		}
	    }
	});

	btnRetour.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		if (e.getSource() == btnRetour) {
		    MainPage mp = new MainPage(connect);
		    mp.setUndecorated(true);
		    mp.setVisible(true);
		    dispose();
		}
	    }
	});

    }
}
