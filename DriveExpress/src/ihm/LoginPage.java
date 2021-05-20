package ihm;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.DaoDriveExpress;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;

public class LoginPage extends JFrame implements MouseListener, MouseMotionListener, KeyListener {
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel leftSide;
    private JPanel topBar;
    private JLabel lblExitBtn;
    private JLabel lblLogin;
    private JLabel lblMail;
    private JLabel lblMotDePasse;
    private JButton btnValidationConnection;
    private JLabel lblDbConnection;
    private Connection connect;
    private JTextField txtMail;
    private JTextField txtMDP;
    private JButton btnCreerUnCompte;
    private JLabel lblNomPage;

    private boolean isConnected;
    private boolean isEmployee;
    private int mouseX;
    private int mouseY;

    public LoginPage(Connection connection, int posX, int posY) {
	if (this.connect == null) {
	    connect = connection;
	}

	setBackground(Color.WHITE);
	setTitle("DriveExpress");
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	if (posX != 0 && posY != 0) {
	    setBounds(posX, posY, 1080, 624);
	} else {
	    setBounds(100, 100, 1080, 624);
	}

	isConnected = false;
	isEmployee = false;

	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	leftSide = new JPanel();
	leftSide.setBackground(SystemColor.windowBorder);
	leftSide.setBounds(0, 26, 535, 612);
	contentPane.add(leftSide);

	topBar = new JPanel();

	topBar.setBackground(SystemColor.activeCaptionBorder);
	topBar.addMouseListener(this);
	topBar.addMouseMotionListener(this);
	topBar.setBounds(0, 0, 1086, 27);
	contentPane.add(topBar);
	topBar.setLayout(null);
	
	lblNomPage = new JLabel("DriveExpress - Connection");
	lblNomPage.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNomPage.setBounds(10, 0, 230, 27);
	topBar.add(lblNomPage);


	lblExitBtn = new JLabel("X");
	lblExitBtn.setToolTipText("Fermer");
	lblExitBtn.setForeground(Color.RED);

	lblExitBtn.setBackground(Color.WHITE);
	lblExitBtn.addMouseListener(this);
	lblExitBtn.setFont(new Font("Arial Black", Font.BOLD, 18));
	lblExitBtn.setHorizontalAlignment(SwingConstants.CENTER);
	lblExitBtn.setBounds(1018, 0, 68, 27);
	topBar.add(lblExitBtn);

	lblLogin = new JLabel("Se connecter");
	lblLogin.setFont(new Font("Arial", Font.PLAIN, 20));
	lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
	lblLogin.setBounds(534, 71, 540, 43);
	contentPane.add(lblLogin);

	lblMail = new JLabel("Mail");
	lblMail.setFont(new Font("Arial", Font.PLAIN, 14));
	lblMail.setBounds(604, 142, 46, 27);
	contentPane.add(lblMail);

	txtMail = new JTextField();
	txtMail.setFont(new Font("Arial", Font.PLAIN, 16));
	txtMail.setBounds(604, 168, 414, 35);
	contentPane.add(txtMail);
	txtMail.setColumns(10);

	lblMotDePasse = new JLabel("Mot de passe");
	lblMotDePasse.setFont(new Font("Arial", Font.PLAIN, 14));
	lblMotDePasse.setBounds(604, 243, 97, 27);
	contentPane.add(lblMotDePasse);

	txtMDP = new JTextField();
	txtMDP.addKeyListener(this);
	txtMDP.setFont(new Font("Arial", Font.PLAIN, 16));
	txtMDP.setColumns(10);
	txtMDP.setBounds(604, 281, 414, 35);
	contentPane.add(txtMDP);

	btnValidationConnection = new JButton("Valider");

	btnValidationConnection.setForeground(Color.BLACK);
	btnValidationConnection.setBackground(Color.GREEN);
	btnValidationConnection.addMouseListener(this);
	btnValidationConnection.setFont(new Font("Arial", Font.PLAIN, 16));
	btnValidationConnection.setBounds(857, 388, 161, 43);
	btnValidationConnection.setBorderPainted(false);
	btnValidationConnection.setFocusable(false);
	contentPane.add(btnValidationConnection);

	lblDbConnection = new JLabel("OUI");
	lblDbConnection.setHorizontalAlignment(SwingConstants.CENTER);
	lblDbConnection.setBounds(545, 342, 519, 14);
	contentPane.add(lblDbConnection);

	btnCreerUnCompte = new JButton("Cr\u00E9er un compte");
	btnCreerUnCompte.addMouseListener(this);
	btnCreerUnCompte.setForeground(Color.BLACK);
	btnCreerUnCompte.setFont(new Font("Arial", Font.PLAIN, 16));
	btnCreerUnCompte.setFocusable(false);
	btnCreerUnCompte.setBorderPainted(false);
	btnCreerUnCompte.setBackground(Color.GRAY);
	btnCreerUnCompte.setBounds(604, 388, 161, 43);
	contentPane.add(btnCreerUnCompte);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
	// Bouton Créer un compte va vers page d'inscription
	if (e.getSource() == btnCreerUnCompte) {
	    InscriptionPage inscP = new InscriptionPage(connect, getLocationOnScreen().x, getLocationOnScreen().y);
	    inscP.setUndecorated(true);
	    inscP.setVisible(true);
	    dispose();
	}

	// Quitte l'app en vérifiant si la connection est bien fermée
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

	// test de Bouton de validation (A modifier)
	if (e.getSource() == btnValidationConnection) {
	    if (txtMDP.getText().isEmpty() || txtMail.getText().isEmpty()) {
		lblDbConnection.setText("Veuillez renseigner tout les champs");
	    } else {
		if (DaoDriveExpress.Connect(txtMail.getText(), txtMDP.getText(), connect) != 0) {
		    this.isConnected = true;
		    lblDbConnection.setText("olémarche");
		    MainPage mp = new MainPage(this.connect, getLocationOnScreen().x, getLocationOnScreen().y, DaoDriveExpress.getUser(txtMail.getText(), txtMDP.getText(), connect));
		    mp.setUndecorated(true);
		    mp.setVisible(true);
		    dispose();
		} else {
		    if (DaoDriveExpress.ConnectEmployee(txtMail.getText(), txtMDP.getText(), connect) != 0) {
			this.isConnected = true;
			this.isEmployee = true;
			lblDbConnection.setText("olémarche + Employé");

		    } else {
			lblDbConnection.setText("pabon");
		    }
		}
	    }
	}
    }

    @Override
    public void mousePressed(MouseEvent e) {
	// Récup les coordonnée de la souris sur la topBar
	if (e.getSource() == topBar) {
	    mouseX = e.getXOnScreen();
	    mouseY = e.getYOnScreen();
	}
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
	// Bouge la fenetre en fonction de la position de la souris
	if (e.getSource() == topBar) {
	    int coorX = e.getXOnScreen();
	    int coorY = e.getYOnScreen();
	    setLocation(getLocationOnScreen().x + coorX - mouseX, getLocationOnScreen().y + coorY - mouseY);
	    mouseX = coorX;
	    mouseY = coorY;
	}
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
	// Même code que le clique sur le bouton valider avec entrée dans le change du
	// mdp
	if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	    if (txtMDP.getText().isEmpty() || txtMail.getText().isEmpty()) {
		lblDbConnection.setText("Veuillez renseigner tout les champs");
	    } else {
		if (DaoDriveExpress.Connect(txtMail.getText(), txtMDP.getText(), connect) != 0) {
		    this.isConnected = true;
		    lblDbConnection.setText("olémarche");
		    MainPage mp = new MainPage(this.connect, getLocationOnScreen().x, getLocationOnScreen().y, DaoDriveExpress.getUser(txtMail.getText(), txtMDP.getText(), connect));
		    mp.setUndecorated(true);
		    mp.setVisible(true);
		    dispose();
		} else {
		    if (DaoDriveExpress.ConnectEmployee(txtMail.getText(), txtMDP.getText(), connect) != 0) {
			this.isConnected = true;
			this.isEmployee = true;
			lblDbConnection.setText("olémarche + Employé");

		    } else {
			lblDbConnection.setText("pabon");
		    }
		}
	    }
	}
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
