package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dao.DaoDriveExpress;
import metier.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InscriptionPage extends JFrame implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel leftSide;
    private JPanel topBar;
    private JPanel rightSide;
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
    private int mouseX;
    private int mouseY;
    private JLabel lblPassword;
    private JTextField txtPassword;
    private JPanel SuccessPanel;
    private JLabel lblGif;

    public InscriptionPage(Connection connection, int posX, int posY) {
	this.connect = connection;

	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	if (posX != 0 && posY != 0) {
	    setBounds(posX, posY, 1080, 624);
	} else {
	    setBounds(100, 100, 1080, 624);
	}

	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	rightSide = new JPanel();
	rightSide.setBounds(534, 26, 552, 597);
	contentPane.add(rightSide);
	rightSide.setLayout(null);

	leftSide = new JPanel();
	leftSide.setBackground(SystemColor.windowBorder);
	leftSide.setBounds(0, 26, 535, 612);
	contentPane.add(leftSide);
	leftSide.setLayout(null);

	topBar = new JPanel();
	topBar.setBackground(SystemColor.activeCaptionBorder);
	topBar.addMouseMotionListener(this);
	topBar.addMouseListener(this);
	topBar.setBounds(0, 0, 1086, 27);
	contentPane.add(topBar);
	topBar.setLayout(null);

	lblExitBtn = new JLabel("X");
	lblExitBtn.setToolTipText("Fermer");
	lblExitBtn.setForeground(Color.RED);
	lblExitBtn.addMouseListener(this);
	lblExitBtn.setBackground(Color.WHITE);
	lblExitBtn.setFont(new Font("Arial Black", Font.BOLD, 18));
	lblExitBtn.setHorizontalAlignment(SwingConstants.CENTER);
	lblExitBtn.setBounds(1018, 0, 68, 27);
	topBar.add(lblExitBtn);

	lblMail = new JLabel("Mail");
	lblMail.setFont(new Font("Arial", Font.PLAIN, 16));
	lblMail.setHorizontalAlignment(SwingConstants.LEFT);
	lblMail.setBounds(43, 11, 414, 14);
	rightSide.add(lblMail);

	txtMail = new JTextField();
	txtMail.setFont(new Font("Arial", Font.PLAIN, 16));
	txtMail.setBounds(43, 36, 414, 35);
	rightSide.add(txtMail);
	txtMail.setColumns(10);

	lblPrenom = new JLabel("Pr\u00E9nom");
	lblPrenom.setHorizontalAlignment(SwingConstants.LEFT);
	lblPrenom.setFont(new Font("Arial", Font.PLAIN, 16));
	lblPrenom.setBounds(43, 80, 414, 14);
	rightSide.add(lblPrenom);

	txtPrenom = new JTextField();
	txtPrenom.setFont(new Font("Arial", Font.PLAIN, 16));
	txtPrenom.setColumns(10);
	txtPrenom.setBounds(43, 101, 414, 35);
	rightSide.add(txtPrenom);

	lblNom = new JLabel("Nom");
	lblNom.setHorizontalAlignment(SwingConstants.LEFT);
	lblNom.setFont(new Font("Arial", Font.PLAIN, 16));
	lblNom.setBounds(43, 147, 414, 14);
	rightSide.add(lblNom);

	txtNom = new JTextField();
	txtNom.setFont(new Font("Arial", Font.PLAIN, 16));
	txtNom.setColumns(10);
	txtNom.setBounds(43, 172, 414, 35);
	rightSide.add(txtNom);

	lblTel = new JLabel("T\u00E9l\u00E9phone");
	lblTel.setHorizontalAlignment(SwingConstants.LEFT);
	lblTel.setFont(new Font("Arial", Font.PLAIN, 16));
	lblTel.setBounds(43, 218, 414, 19);
	rightSide.add(lblTel);

	txtTel = new JTextField();
	txtTel.setFont(new Font("Arial", Font.PLAIN, 16));
	txtTel.setColumns(10);
	txtTel.setBounds(43, 243, 414, 35);
	rightSide.add(txtTel);

	lblAdresse = new JLabel("Adresse");
	lblAdresse.setHorizontalAlignment(SwingConstants.LEFT);
	lblAdresse.setFont(new Font("Arial", Font.PLAIN, 16));
	lblAdresse.setBounds(43, 289, 414, 19);
	rightSide.add(lblAdresse);

	txtAdresse = new JTextField();
	txtAdresse.setFont(new Font("Arial", Font.PLAIN, 16));
	txtAdresse.setColumns(10);
	txtAdresse.setBounds(43, 314, 414, 35);
	rightSide.add(txtAdresse);

	lblVille = new JLabel("Ville");
	lblVille.setHorizontalAlignment(SwingConstants.LEFT);
	lblVille.setFont(new Font("Arial", Font.PLAIN, 16));
	lblVille.setBounds(43, 363, 169, 19);
	rightSide.add(lblVille);

	txtVille = new JTextField();
	txtVille.setFont(new Font("Arial", Font.PLAIN, 16));
	txtVille.setColumns(10);
	txtVille.setBounds(43, 388, 169, 35);
	rightSide.add(txtVille);

	txtCP = new JTextField();
	txtCP.setFont(new Font("Arial", Font.PLAIN, 16));
	txtCP.setColumns(10);
	txtCP.setBounds(288, 388, 169, 35);
	rightSide.add(txtCP);

	lblCodePoste = new JLabel("Code Postal");
	lblCodePoste.setHorizontalAlignment(SwingConstants.LEFT);
	lblCodePoste.setFont(new Font("Arial", Font.PLAIN, 16));
	lblCodePoste.setBounds(288, 363, 169, 19);
	rightSide.add(lblCodePoste);

	btnCreerCompte = new JButton("Cr\u00E9er un compte");
	btnCreerCompte.addMouseListener(this);
	btnCreerCompte.setForeground(Color.BLACK);
	btnCreerCompte.setFont(new Font("Arial", Font.PLAIN, 16));
	btnCreerCompte.setFocusable(false);
	btnCreerCompte.setBorderPainted(false);
	btnCreerCompte.setBackground(Color.GREEN);
	btnCreerCompte.setBounds(288, 524, 169, 43);
	rightSide.add(btnCreerCompte);

	btnRetour = new JButton("Retour");
	btnRetour.addMouseListener(this);
	btnRetour.setForeground(Color.BLACK);
	btnRetour.setFont(new Font("Arial", Font.PLAIN, 16));
	btnRetour.setFocusable(false);
	btnRetour.setBorderPainted(false);
	btnRetour.setBackground(Color.GRAY);
	btnRetour.setBounds(43, 524, 169, 43);
	rightSide.add(btnRetour);

	lblPassword = new JLabel("Mot de Passe");
	lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
	lblPassword.setFont(new Font("Arial", Font.PLAIN, 16));
	lblPassword.setBounds(43, 434, 414, 19);
	rightSide.add(lblPassword);

	txtPassword = new JTextField();
	txtPassword.setFont(new Font("Arial", Font.PLAIN, 16));
	txtPassword.setColumns(10);
	txtPassword.setBounds(43, 461, 414, 35);
	rightSide.add(txtPassword);

	SuccessPanel = new JPanel();
	SuccessPanel.setBounds(-12, 26, 1098, 612);
	SuccessPanel.setBackground(new Color(236, 234, 236));
	contentPane.add(SuccessPanel);
	SuccessPanel.setLayout(null);

	lblGif = new JLabel("");
	lblGif.setIcon(new ImageIcon(InscriptionPage.class.getResource("/ihm/media/SuccessVideo.gif")));
	lblGif.setHorizontalAlignment(SwingConstants.CENTER);
	lblGif.setBounds(0, 0, 1098, 612);
	SuccessPanel.add(lblGif);
	SuccessPanel.setVisible(false);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
	if (e.getSource() == btnRetour) {
	    // retour page login
	    MainPage mp = new MainPage(connect, getLocationOnScreen().x, getLocationOnScreen().y);
	    mp.setUndecorated(true);
	    mp.setVisible(true);
	    dispose();

	}

	if (e.getSource() == btnCreerCompte) {
	    // check si les champs sont bon
	    boolean bon = false;
	    if (DaoDriveExpress.validate(this.txtMail.getText())) {
		this.txtMail.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
		bon = true;
	    } else {
		this.txtMail.setBorder(new LineBorder(Color.RED, 2));
	    }

	    bon = this.checkJTextFieldString(this.txtCP, true, 5) && bon;
	    bon = this.checkJTextFieldString(this.txtTel, true, 10) && bon;
	    bon = this.checkJTextFieldString(this.txtVille) && bon;
	    bon = this.checkJTextFieldString(this.txtNom) && bon;
	    bon = this.checkJTextFieldString(this.txtPrenom) && bon;
	    bon = this.checkJTextFieldString(this.txtAdresse) && bon;
	    bon  = this.checkJTextFieldString(this.txtNom) && bon;

	    if (bon) {
		// Appel fonction d'inscription de la classe DaoDriveExpress avec parametre
		// connection et User
		DaoDriveExpress.inscriptionUser(connect,
			new User(DaoDriveExpress.getLastIDUser(connect) + 1, this.txtNom.getText(),
				this.txtPrenom.getText(), this.txtAdresse.getText(), this.txtVille.getText(),
				this.txtCP.getText(), this.txtTel.getText(), this.txtMail.getText(),
				this.txtPassword.getText()));

		// Timer pour jouer le gif 1 fois (6.306s) puis retour a la page de login
		Timer chrono = new Timer();
		rightSide.setVisible(false);
		leftSide.setVisible(false);
		SuccessPanel.setVisible(true);
		chrono.schedule(new TimerTask() {

		    @Override
		    public void run() {
			lblGif.setVisible(false);
			
			MainPage mp = new MainPage(connect, getLocationOnScreen().x, getLocationOnScreen().y);
			mp.setUndecorated(true);
			mp.setVisible(true);
			dispose();
		    }
		}, 6306);
	    }
	}
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
	// get la position de la souris
	if (e.getSource() == topBar) {
	    mouseX = e.getXOnScreen();
	    mouseY = e.getYOnScreen();
	}

	if (e.getSource() == lblExitBtn) {
	    // ferme la connection a la bdd puis check si elle est bien fermé
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

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
	// get les coordonnées de la souris (qui bouge) puis lui soustrait la position
	// où la souris à cliqué et bouge la fenetre en fonction de ces infos
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

    //Check si le texte du JTextField est vide renvoie un boolean
    public boolean checkJTextFieldString(JTextField jtf) {
	boolean res = false;

	if (!jtf.getText().equals("")) {
	    res = true;
	    jtf.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
	} else

	{
	    jtf.setBorder(new LineBorder(Color.RED, 2));
	}

	return res;
    }

    //Surchage de checkJTextFieldString avec un check si le text du JTextField est un int et si il a le nombre de caractère voulu
    public boolean checkJTextFieldString(JTextField jtf, boolean isInt, int nbChar) {
	boolean res = this.checkJTextFieldString(jtf);
	if (res && jtf.getText().length() == nbChar && jtf.getText().chars().allMatch(Character::isDigit)) {
	    jtf.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
	} else {
	    res = false;
	    jtf.setBorder(new LineBorder(Color.RED, 2));
	}
	return res;
    }

}
