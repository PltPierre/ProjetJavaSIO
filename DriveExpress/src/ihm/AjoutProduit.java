package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.DaoDriveExpress;
import metier.Employe;
import metier.Produit;
import metier.TypeProduit;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AjoutProduit extends JFrame implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = -8475963155634927953L;
    private JPanel contentPane;
    private JLabel lblExitBtn;
    private JPanel topBar;
    private Connection connect;
    private int mouseX;
    private int mouseY;
    private Employe employe;
    private JPanel Onglet1;
    private JPanel ongletMenu;
    private JPanel pnlTypeProduit;
    private JPanel pnlProduits;
    private JPanel pnlLogout;
    private JPanel pnlEmployes;
    private JLabel lblLogo;
    private JPanel pnlSettings;
    private JLabel lblOption;
    private JLabel lblDeconnexion;
    private JLabel lblLogoOption;
    private JLabel lblLogoDeconnexion;
    private JLabel lblType;
    private JLabel lblLogoType;
    private JLabel lblProduits;
    private JLabel lblLogoProduit;
    private JLabel lblEmployes;
    private JLabel lblLogoEmployes;
    private JLabel lblNom;
    private JLabel lblNomPage;
    private JLabel lblNewLabel;
    private JTextField txtLibType;
    private JButton btnAcheter;
    private JLabel lblNewLabel_1;
    private JTextField txtDesc;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JTextField txtPrix;
    private JComboBox<TypeProduit> cbType;
    private Vector<TypeProduit> lesTypesProduit;

    public AjoutProduit(Connection connection, int posX, int posY, Employe employe) {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	this.employe = employe;
	if (posX != 0 && posY != 0) {
	    setBounds(posX, posY, 1080, 630);
	} else {
	    setBounds(100, 100, 1080, 624);
	}
	
	if (this.connect == null) {
	    this.connect = connection;
	}
	
	contentPane = new JPanel();
	contentPane.setBackground(Color.BLACK);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	
	topBar = new JPanel();
	topBar.setBackground(SystemColor.activeCaptionBorder);
	topBar.addMouseMotionListener(this);
	topBar.addMouseListener(this);
	contentPane.setLayout(null);
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

	lblNomPage = new JLabel("DriveExpress - Livraison en attente");
	lblNomPage.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNomPage.setBounds(10, 0, 230, 27);
	topBar.add(lblNomPage);
	
	Onglet1 = new JPanel();
	Onglet1.setBackground(Color.WHITE);
	Onglet1.setBounds(182, 27, 904, 612);
	contentPane.add(Onglet1);
	Onglet1.setLayout(null);

	lblNom = new JLabel("Bonjour " + this.employe.getPrenomEmploye() + " " + this.employe.getNomEmploye() + " - Espace employ�");
	lblNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNom.setHorizontalAlignment(SwingConstants.CENTER);
	lblNom.setBounds(0, 11, 894, 50);
	Onglet1.add(lblNom);
	
	lblNewLabel = new JLabel("Description Produit :");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblNewLabel.setBounds(476, 123, 188, 26);
	Onglet1.add(lblNewLabel);
	
	txtLibType = new JTextField();
	txtLibType.setFont(new Font("Tahoma", Font.PLAIN, 14));
	txtLibType.setBounds(63, 160, 282, 34);
	Onglet1.add(txtLibType);
	txtLibType.setColumns(10);
	
	btnAcheter = new JButton("Valider");
	btnAcheter.setFont(new Font("Tahoma", Font.PLAIN, 20));
	btnAcheter.setBounds(733, 535, 141, 55);
	btnAcheter.setForeground(Color.BLACK);
	btnAcheter.setBackground(Color.GREEN);
	btnAcheter.setBorderPainted(false);
	btnAcheter.addMouseListener(this);
	btnAcheter.setFocusable(false);
	Onglet1.add(btnAcheter);
	
	lblNewLabel_1 = new JLabel("Nom Produit :");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblNewLabel_1.setBounds(63, 123, 188, 26);
	Onglet1.add(lblNewLabel_1);
	
	txtDesc = new JTextField();
	txtDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
	txtDesc.setColumns(10);
	txtDesc.setBounds(476, 160, 282, 34);
	Onglet1.add(txtDesc);
	
	lblNewLabel_2 = new JLabel("Prix Produit :");
	lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblNewLabel_2.setBounds(63, 253, 188, 26);
	Onglet1.add(lblNewLabel_2);
	
	lblNewLabel_3 = new JLabel("Type Produit :");
	lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblNewLabel_3.setBounds(476, 253, 188, 26);
	Onglet1.add(lblNewLabel_3);
	
	txtPrix = new JTextField();
	txtPrix.setFont(new Font("Tahoma", Font.PLAIN, 14));
	txtPrix.setColumns(10);
	txtPrix.setBounds(63, 290, 282, 34);
	Onglet1.add(txtPrix);
	
	cbType = new JComboBox<TypeProduit>();
	cbType.setFont(new Font("Tahoma", Font.PLAIN, 14));
	cbType.setBounds(476, 290, 282, 34);
	Onglet1.add(cbType);

	ongletMenu = new JPanel();
	ongletMenu.setBackground(Color.WHITE);
	ongletMenu.setBounds(0, 27, 180, 612);
	contentPane.add(ongletMenu);
	ongletMenu.setLayout(null);

	pnlTypeProduit = new JPanel();
	pnlTypeProduit.setBounds(0, 143, 180, 80);
	pnlTypeProduit.addMouseListener(this);
	pnlTypeProduit.setLayout(null);
	ongletMenu.add(pnlTypeProduit);

	pnlEmployes = new JPanel();
	pnlEmployes.setBounds(0, 307, 180, 80);
	ongletMenu.add(pnlEmployes);
	pnlEmployes.setLayout(null);

	pnlProduits = new JPanel();
	pnlProduits.setBounds(0, 225, 180, 80);
	pnlProduits.setBackground(new Color(200, 200, 200));
	ongletMenu.add(pnlProduits);
	pnlProduits.setLayout(null);

	pnlLogout = new JPanel();
	pnlLogout.setBounds(0, 558, 180, 43);
	ongletMenu.add(pnlLogout);
	pnlLogout.setLayout(null);
	
	lblType = new JLabel("Ajout Type Produit");
	lblType.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblType.setHorizontalAlignment(SwingConstants.CENTER);
	lblType.setBounds(66, 0, 114, 80);
	lblType.setBackground(new Color(200, 200, 200));
	lblType.addMouseListener(this);
	pnlTypeProduit.add(lblType);
	
	lblLogoType = new JLabel("");
	lblLogoType.setHorizontalAlignment(SwingConstants.CENTER);
	lblLogoType.setBounds(0, 0, 64, 80);
	lblLogoType.setIcon(new ImageIcon(MainPage.class.getResource("/ihm/media/LogoType.png")));
	lblLogoType.addMouseListener(this);
	pnlTypeProduit.add(lblLogoType);
	

	lblProduits = new JLabel("Ajout Produit");
	lblProduits.setFont(new Font("Tahoma", Font.PLAIN, 11));
	lblProduits.setHorizontalAlignment(SwingConstants.CENTER);
	lblProduits.setBounds(66, 0, 114, 80);
	lblProduits.setBackground(new Color(200, 200, 200));
	pnlProduits.add(lblProduits);

	lblLogoProduit = new JLabel("");
	lblLogoProduit.setHorizontalAlignment(SwingConstants.CENTER);
	lblLogoProduit.setBounds(0, 0, 64, 80);
	lblLogoProduit.setIcon(new ImageIcon(MainPage.class.getResource("/ihm/media/LogoProduit.png")));
	pnlProduits.add(lblLogoProduit);
	

	lblEmployes = new JLabel("Gestion employ�");
	lblEmployes.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblEmployes.setHorizontalAlignment(SwingConstants.CENTER);
	lblEmployes.setBounds(66, 0, 114, 80);
	lblEmployes.setBackground(new Color(200, 200, 200));
	lblEmployes.addMouseListener(this);
	pnlEmployes.add(lblEmployes);

	lblLogoEmployes = new JLabel("");
	lblLogoEmployes.setHorizontalAlignment(SwingConstants.CENTER);
	lblLogoEmployes.setBounds(0, 0, 64, 80);
	lblLogoEmployes.setIcon(new ImageIcon(MainPage.class.getResource("/ihm/media/LogoEmployes.png")));
	lblLogoEmployes.addMouseListener(this);
	pnlEmployes.add(lblLogoEmployes);
	

	lblDeconnexion = new JLabel("d\u00E9connexion");
	lblDeconnexion.setBounds(51, 0, 129, 43);
	lblDeconnexion.setHorizontalAlignment(SwingConstants.CENTER);
	lblDeconnexion.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblDeconnexion.addMouseListener(this);
	pnlLogout.add(lblDeconnexion);

	lblLogoDeconnexion = new JLabel("");
	lblLogoDeconnexion.setHorizontalAlignment(SwingConstants.CENTER);
	lblLogoDeconnexion.setBounds(0, 0, 46, 43);
	lblLogoDeconnexion.setIcon(new ImageIcon(MainPage.class.getResource("/ihm/media/LogoutLogo.png")));
	lblLogoDeconnexion.addMouseListener(this);
	pnlLogout.add(lblLogoDeconnexion);

	
	lblLogo = new JLabel("");
	lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
	lblLogo.setBounds(0, 0, 180, 117);
	lblLogo.setIcon(new ImageIcon(MainPage.class.getResource("/ihm/media/DriveExpressLogo.png")));
	ongletMenu.add(lblLogo);

	pnlSettings = new JPanel();
	pnlSettings.setBounds(0, 504, 180, 43);
	ongletMenu.add(pnlSettings);
	pnlSettings.setLayout(null);

	lblOption = new JLabel("Options");
	lblOption.setHorizontalAlignment(SwingConstants.CENTER);
	lblOption.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblOption.setBounds(49, 0, 131, 43);
	lblOption.addMouseListener(this);
	pnlSettings.add(lblOption);
	

	lblLogoOption = new JLabel("");
	lblLogoOption.setHorizontalAlignment(SwingConstants.CENTER);
	lblLogoOption.setBounds(0, 0, 46, 43);
	lblLogoOption.setIcon(new ImageIcon(MainPage.class.getResource("/ihm/media/SettingsLogo.png")));
	lblLogoOption.addMouseListener(this);
	pnlSettings.add(lblLogoOption);
	
	//-------------------------------------------------------
	//get les types de produits
	this.lesTypesProduit = DaoDriveExpress.getTypeProduit(connection);
	
	//les ajoutes dans la liste d�roulante
	for (TypeProduit tp : this.lesTypesProduit) {
	    cbType.addItem(tp);
	}
    }

    @Override
    public void mouseDragged(MouseEvent e) {

	// get les coordonn�es de la souris (qui bouge) puis lui soustrait la position
	// o� la souris � cliqu� et bouge la fenetre en fonction de ces infos
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
	// TODO Stub de la m�thode g�n�r� automatiquement

    }

    @Override
    public void mouseClicked(MouseEvent e) {
	// btn valider qui ajoute le produit dans la bdd
	
	if (e.getComponent() == this.btnAcheter) {
	    JOptionPane.showMessageDialog(this, "Produit ajout� !");
	    DaoDriveExpress.ajoutProduit(connect, new Produit(1, (TypeProduit) this.cbType.getSelectedItem(), this.txtLibType.getText(), this.txtDesc.getText(), Double.parseDouble(this.txtPrix.getText()), 0));
	    AjoutProduit ap = new AjoutProduit(connect, getLocationOnScreen().x, getLocationOnScreen().y, this.employe);
	    ap.setUndecorated(true);
	    ap.setVisible(true);
	    dispose();
	}
	
	try {
	    // click pour le panel Type
	    if ((JLabel) e.getComponent() == this.lblType || (JLabel) e.getComponent() == this.lblLogoType) {
		AjoutTypeProduit ap = new AjoutTypeProduit(this.connect, getLocationOnScreen().x, getLocationOnScreen().y, this.employe);
		ap.setUndecorated(true);
		ap.setVisible(true);
		dispose();
	    }
	    // click pour le panel option
	    if ((JLabel) e.getComponent() == this.lblOption || (JLabel) e.getComponent() == this.lblLogoOption) {
		OptionPage op = new OptionPage(this.connect, getLocationOnScreen().x, getLocationOnScreen().y,
			this.employe);
		op.setUndecorated(true);
		op.setVisible(true);
		dispose();
	    }
	    // click pour le panel deconnexion
	    if ((JLabel) e.getComponent() == this.lblDeconnexion
		    || (JLabel) e.getComponent() == this.lblLogoDeconnexion) {
		LoginPage lp = new LoginPage(this.connect, getLocationOnScreen().x, getLocationOnScreen().y);
		lp.setUndecorated(true);
		lp.setVisible(true);
		dispose();
	    }
	} catch (Exception e2) {

	}

    }

    @Override
    public void mousePressed(MouseEvent e) {
	// get la position de la souris
	if (e.getSource() == topBar) {
	    mouseX = e.getXOnScreen();
	    mouseY = e.getYOnScreen();
	}

	if (e.getSource() == lblExitBtn) {
	    // ferme la connection a la bdd puis check si elle est bien ferm�
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
		    System.out.println("db pas ferm�");
		}
	    } catch (SQLException e1) {
		e1.printStackTrace();
	    }
	}

    }

    @Override
    public void mouseReleased(MouseEvent e) {
	// TODO Stub de la m�thode g�n�r� automatiquement

    }

    @Override
    public void mouseEntered(MouseEvent e) {
	// TODO Stub de la m�thode g�n�r� automatiquement
	try {
	    // Hover pour le panel deconnexion
	    if ((JLabel) e.getComponent() == this.lblDeconnexion
		    || (JLabel) e.getComponent() == this.lblLogoDeconnexion) {
		this.pnlLogout.setBackground(new Color(220, 220, 220));
		this.lblDeconnexion.setBackground(new Color(220, 220, 220));
		this.lblLogoDeconnexion.setBackground(new Color(220, 220, 220));
	    }
	    // Hover pour le panel option
	    if ((JLabel) e.getComponent() == this.lblOption || (JLabel) e.getComponent() == this.lblLogoOption) {
		this.pnlSettings.setBackground(new Color(220, 220, 220));
		this.lblOption.setBackground(new Color(220, 220, 220));
		this.lblLogoOption.setBackground(new Color(220, 220, 220));
	    }

	    // Hover pour le panel Type Type Produit
	    if ((JLabel) e.getComponent() == this.lblType || (JLabel) e.getComponent() == this.lblLogoType) {
		this.pnlTypeProduit.setBackground(new Color(220, 220, 220));
		this.lblLogoType.setBackground(new Color(220, 220, 220));
		this.lblType.setBackground(new Color(220, 220, 220));
	    }
	    // Hover pour le panel Employes
	    if ((JLabel) e.getComponent() == this.lblEmployes || (JLabel) e.getComponent() == this.lblLogoEmployes) {
		this.lblEmployes.setBackground(new Color(220, 220, 220));
		this.lblLogoEmployes.setBackground(new Color(220, 220, 220));
	    }
	} catch (Exception e2) {

	}

    }

    @Override
    public void mouseExited(MouseEvent e) {
	// TODO Stub de la m�thode g�n�r� automatiquement
	try {
	    // Hover pour le panel deconnexion
	    if ((JLabel) e.getComponent() == this.lblDeconnexion
		    || (JLabel) e.getComponent() == this.lblLogoDeconnexion) {
		this.pnlLogout.setBackground(new Color(240, 240, 240));
		this.lblDeconnexion.setBackground(new Color(240, 240, 240));
		this.lblLogoDeconnexion.setBackground(new Color(240, 240, 240));
	    }
	    // Hover pour le panel option
	    if ((JLabel) e.getComponent() == this.lblOption || (JLabel) e.getComponent() == this.lblLogoOption) {
		this.pnlSettings.setBackground(new Color(240, 240, 240));
		this.lblOption.setBackground(new Color(240, 240, 240));
		this.lblLogoOption.setBackground(new Color(240, 240, 240));
	    }
	    // Hover pour le panel Type Produit
	    if ((JLabel) e.getComponent() == this.lblType || (JLabel) e.getComponent() == this.lblLogoType) {
		this.pnlTypeProduit.setBackground(new Color(240, 240, 240));
		this.lblLogoType.setBackground(new Color(240, 240, 240));
		this.lblType.setBackground(new Color(240,240,240));
	    }
	    // Hover pour le panel Produit
	    if ((JLabel) e.getComponent() == this.lblEmployes || (JLabel) e.getComponent() == this.lblLogoEmployes) {
		this.lblEmployes.setBackground(new Color(240, 240, 240));
		this.lblLogoEmployes.setBackground(new Color(240, 240, 240));
	    }
	} catch (Exception e2) {

	}

    }
}
