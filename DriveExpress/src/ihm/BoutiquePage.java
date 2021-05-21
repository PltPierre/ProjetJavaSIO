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

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.DaoDriveExpress;
import metier.Produit;
import metier.TypeProduit;
import metier.User;

import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class BoutiquePage extends JFrame implements MouseListener, MouseMotionListener, ActionListener, ListSelectionListener {

    private static final long serialVersionUID = -8475963155634927953L;
    private JPanel contentPane;
    private JLabel lblExitBtn;
    private JPanel topBar;
    private Connection connect;
    private int mouseX;
    private int mouseY;
    private User user;
    private JPanel Onglet1;
    private JPanel ongletMenu;
    private JPanel pnlAcceuil;
    private JPanel pnlBoutique;
    private JPanel pnlPanier;
    private JPanel pnlLogout;
    private JLabel lblLogo;
    private JPanel pnlSettings;
    private JLabel lblOption;
    private JLabel lblDeconnexion;
    private JLabel lblLogoOption;
    private JLabel lblLogoDeconnexion;
    private JLabel lblAcceuil;
    private JLabel lblLogoAcceuil;
    private JLabel lblBoutique;
    private JLabel lblLogoBoutique;
    private JLabel lblNom;
    private JLabel lblNomPage;
    private JLabel lblPanier;
    private JLabel lblLogoPanier;
    private JComboBox<TypeProduit> cbTypeProduit;
    private JList<Produit> lstProduit;
    DefaultListModel<Produit> model;
    private JPanel pnlDetailProduit;
    
    private Vector<Produit> lesProduits;
    private Vector<TypeProduit> lesTypesProduit;
    private JLabel lblDesc;
    private JLabel lblPrix;
    private JButton btnAjoutPanier;
    private JSpinner spiQuantite;
    private JLabel lblQuantite;

    @SuppressWarnings("deprecation")
    public BoutiquePage(Connection connection, int posX, int posY, User user) {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	this.user = user;
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

	lblNomPage = new JLabel("DriveExpress - Boutique");
	lblNomPage.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNomPage.setBounds(10, 0, 230, 27);
	topBar.add(lblNomPage);

	lblExitBtn = new JLabel("X");
	lblExitBtn.setToolTipText("Fermer");
	lblExitBtn.setForeground(Color.RED);
	lblExitBtn.addMouseListener(this);
	lblExitBtn.setBackground(Color.WHITE);
	lblExitBtn.setFont(new Font("Arial Black", Font.BOLD, 18));
	lblExitBtn.setHorizontalAlignment(SwingConstants.CENTER);
	lblExitBtn.setBounds(1018, 0, 68, 27);
	topBar.add(lblExitBtn);

	Onglet1 = new JPanel();
	Onglet1.setBackground(Color.WHITE);
	Onglet1.setBounds(182, 27, 904, 612);
	contentPane.add(Onglet1);
	Onglet1.setLayout(null);

	lblNom = new JLabel("Bienvenue dans la boutique " + this.user.getPrenomUser() + " " + this.user.getNomUser());
	lblNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNom.setHorizontalAlignment(SwingConstants.CENTER);
	lblNom.setBounds(0, 11, 894, 50);
	Onglet1.add(lblNom);

	cbTypeProduit = new JComboBox<TypeProduit>();
	cbTypeProduit.addActionListener(this);
	cbTypeProduit.setBounds(333, 72, 232, 22);
	Onglet1.add(cbTypeProduit);

	model = new DefaultListModel<Produit>();
	lstProduit = new JList<Produit>(model);
	lstProduit.addListSelectionListener(this);
	lstProduit.setBackground(Color.LIGHT_GRAY);
	lstProduit.setBounds(333, 128, 232, 214);
	Onglet1.add(lstProduit);

	pnlDetailProduit = new JPanel();
	pnlDetailProduit.setBackground(Color.WHITE);
	pnlDetailProduit.setBounds(20, 382, 855, 186);
	Onglet1.add(pnlDetailProduit);
	pnlDetailProduit.setLayout(null);
	pnlDetailProduit.setVisible(false);
	
	lblDesc = new JLabel("test");
	lblDesc.setHorizontalAlignment(SwingConstants.CENTER);
	lblDesc.setBounds(203, 11, 380, 164);
	pnlDetailProduit.add(lblDesc);
	
	lblPrix = new JLabel("Prix : ");
	lblPrix.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
	lblPrix.setBounds(672, 11, 114, 30);
	pnlDetailProduit.add(lblPrix);
	
	btnAjoutPanier = new JButton("Ajouter au panier");
	btnAjoutPanier.setBounds(653, 120, 141, 55);
	btnAjoutPanier.setForeground(Color.BLACK);
	btnAjoutPanier.setBackground(Color.GREEN);
	btnAjoutPanier.setBorderPainted(false);
	btnAjoutPanier.addMouseListener(this);
	btnAjoutPanier.setFocusable(false);
	pnlDetailProduit.add(btnAjoutPanier);
	
	spiQuantite = new JSpinner();
	spiQuantite.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
	spiQuantite.setBounds(748, 83, 46, 20);
	pnlDetailProduit.add(spiQuantite);
	
	lblQuantite = new JLabel("Quantit\u00E9 :");
	lblQuantite.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblQuantite.setBounds(653, 80, 67, 23);
	pnlDetailProduit.add(lblQuantite);

	ongletMenu = new JPanel();
	ongletMenu.setBackground(Color.WHITE);
	ongletMenu.setBounds(0, 27, 180, 612);
	contentPane.add(ongletMenu);
	ongletMenu.setLayout(null);

	pnlAcceuil = new JPanel();
	pnlAcceuil.setBounds(0, 143, 180, 80);
	pnlAcceuil.setBackground(new Color(240, 240, 240));
	ongletMenu.add(pnlAcceuil);
	pnlAcceuil.addMouseListener(this);
	pnlAcceuil.setLayout(null);

	pnlBoutique = new JPanel();
	pnlBoutique.setBounds(0, 225, 180, 80);
	ongletMenu.add(pnlBoutique);
	pnlBoutique.setBackground(new Color(200, 200, 200));
	pnlBoutique.setLayout(null);

	pnlPanier = new JPanel();
	pnlPanier.setBounds(0, 307, 180, 80);
	ongletMenu.add(pnlPanier);
	pnlPanier.setLayout(null);

	pnlLogout = new JPanel();
	pnlLogout.setBounds(0, 558, 180, 43);
	ongletMenu.add(pnlLogout);
	pnlLogout.setLayout(null);

	lblAcceuil = new JLabel("Acceuil");
	lblAcceuil.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblAcceuil.setHorizontalAlignment(SwingConstants.CENTER);
	lblAcceuil.setBounds(66, 0, 114, 80);
	lblAcceuil.addMouseListener(this);
	pnlAcceuil.add(lblAcceuil);

	lblLogoAcceuil = new JLabel("");
	lblLogoAcceuil.setHorizontalAlignment(SwingConstants.CENTER);
	lblLogoAcceuil.setBounds(0, 0, 64, 80);
	lblLogoAcceuil.setIcon(new ImageIcon(MainPage.class.getResource("/ihm/media/home.png")));
	lblLogoAcceuil.addMouseListener(this);
	pnlAcceuil.add(lblLogoAcceuil);

	lblBoutique = new JLabel("Boutique");
	lblBoutique.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblBoutique.setHorizontalAlignment(SwingConstants.CENTER);
	lblBoutique.setBounds(66, 0, 114, 80);
	pnlBoutique.add(lblBoutique);

	lblLogoBoutique = new JLabel("");
	lblLogoBoutique.setHorizontalAlignment(SwingConstants.CENTER);
	lblLogoBoutique.setBounds(0, 0, 64, 80);
	lblLogoBoutique.setIcon(new ImageIcon(MainPage.class.getResource("/ihm/media/boutique.png")));
	pnlBoutique.add(lblLogoBoutique);

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

	lblPanier = new JLabel("Panier");
	lblPanier.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblPanier.setHorizontalAlignment(SwingConstants.CENTER);
	lblPanier.setBounds(66, 0, 114, 80);
	lblPanier.setBackground(new Color(200, 200, 200));
	lblPanier.addMouseListener(this);
	pnlPanier.add(lblPanier);

	lblLogoPanier = new JLabel("");
	lblLogoPanier.setHorizontalAlignment(SwingConstants.CENTER);
	lblLogoPanier.setBounds(0, 0, 64, 80);
	lblLogoPanier.setIcon(new ImageIcon(MainPage.class.getResource("/ihm/media/panier.png")));
	lblLogoPanier.addMouseListener(this);
	pnlPanier.add(lblLogoPanier);

	// ---------------------------------

	this.lesTypesProduit = DaoDriveExpress.getTypeProduit(connection);
	this.lesProduits = DaoDriveExpress.getProduits(connection, this.lesTypesProduit);

	cbTypeProduit.addItem(null);

	for (TypeProduit tp : this.lesTypesProduit) {
	    cbTypeProduit.addItem(tp);
	}


	for (Produit p : this.lesProduits) {
	    model.addElement(p);
	}

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
	// TODO Stub de la méthode généré automatiquement

    }

    @Override
    public void mouseClicked(MouseEvent e) {
	// TODO Stub de la méthode généré automatiquement
	try {

	    // click pour le panel acceuil
	    if ((JLabel) e.getComponent() == this.lblLogoAcceuil || (JLabel) e.getComponent() == this.lblAcceuil) {
		MainPage mp = new MainPage(this.connect, getLocationOnScreen().x, getLocationOnScreen().y, this.user);
		mp.setUndecorated(true);
		mp.setVisible(true);
		dispose();
	    }
	    // click pour le panel option
	    if ((JLabel) e.getComponent() == this.lblOption || (JLabel) e.getComponent() == this.lblLogoOption) {
		OptionPage op = new OptionPage(this.connect, getLocationOnScreen().x, getLocationOnScreen().y,
			this.user);
		op.setUndecorated(true);
		op.setVisible(true);
		dispose();
	    }
	    // click pour le panel Panier
	    if ((JLabel) e.getComponent() == this.lblPanier || (JLabel) e.getComponent() == this.lblLogoPanier) {
		PanierPage pp = new PanierPage(this.connect, getLocationOnScreen().x, getLocationOnScreen().y,
			this.user);
		pp.setUndecorated(true);
		pp.setVisible(true);
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
	
	// btn Ajout Panier
	if(e.getComponent() == this.btnAjoutPanier) {
	    Produit p = lstProduit.getSelectedValue();
	    DaoDriveExpress.ajoutPanier(connect, user, p, (Integer) spiQuantite.getValue());
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
	// TODO Stub de la méthode généré automatiquement

    }

    @Override
    public void mouseEntered(MouseEvent e) {
	// TODO Stub de la méthode généré automatiquement
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
	    // Hover pour le panel Acceuil
	    if ((JLabel) e.getComponent() == this.lblAcceuil || (JLabel) e.getComponent() == this.lblLogoAcceuil) {
		this.pnlAcceuil.setBackground(new Color(220, 220, 220));
		this.lblAcceuil.setBackground(new Color(220, 220, 220));
		this.lblLogoAcceuil.setBackground(new Color(220, 220, 220));
	    }
	    // Hover pour le panel Panier
	    if ((JLabel) e.getComponent() == this.lblPanier || (JLabel) e.getComponent() == this.lblLogoPanier) {
		this.pnlPanier.setBackground(new Color(220, 220, 220));
		this.lblPanier.setBackground(new Color(220, 220, 220));
		this.lblLogoPanier.setBackground(new Color(220, 220, 220));
	    }
	} catch (Exception e2) {

	}

    }

    @Override
    public void mouseExited(MouseEvent e) {
	// TODO Stub de la méthode généré automatiquement
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
	    // hover pour le panel acceuil
	    if ((JLabel) e.getComponent() == this.lblAcceuil || (JLabel) e.getComponent() == this.lblLogoAcceuil) {
		this.pnlAcceuil.setBackground(new Color(240, 240, 240));
		this.lblAcceuil.setBackground(new Color(240, 240, 240));
		this.lblLogoAcceuil.setBackground(new Color(240, 240, 240));
	    }
	    // Hover pour le panel boutique
	    if ((JLabel) e.getComponent() == this.lblPanier || (JLabel) e.getComponent() == this.lblLogoPanier) {
		this.pnlPanier.setBackground(new Color(240, 240, 240));
		this.lblPanier.setBackground(new Color(240, 240, 240));
		this.lblLogoPanier.setBackground(new Color(240, 240, 240));
	    }
	} catch (Exception e2) {

	}

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	if (arg0.getSource() == this.cbTypeProduit) {
	    lstProduit.clearSelection();
	    pnlDetailProduit.setVisible(false);
	    TypeProduit tp = (TypeProduit) cbTypeProduit.getSelectedItem();

	    if(tp == null) {
		this.model.clear();
		for(Produit p : this.lesProduits) {
		    this.model.addElement(p);
		}
	    }
	    else {
		this.model.clear();
		for(Produit p : tp.getLesProduits()) {
		    this.model.addElement(p);
		}
	    }
	}

    }

    @Override
    public void valueChanged(ListSelectionEvent arg0) {
	// TODO Auto-generated method stub
	if(arg0.getSource() == this.lstProduit && lstProduit.getSelectedValue() != null) {
	    spiQuantite.setValue(1);
	    Produit p = (Produit) lstProduit.getSelectedValue();
	    
	    pnlDetailProduit.setVisible(true);
	    lblDesc.setText(p.getDescProduit());
	    lblPrix.setText("Prix : " + p.getPrixProduit()*p.getPromotionProduit() + "€");
	}
	
    }
}
