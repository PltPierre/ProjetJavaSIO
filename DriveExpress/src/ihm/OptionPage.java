package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dao.DaoDriveExpress;
import metier.Employe;
import metier.User;
import javax.swing.JTextField;
import javax.swing.JButton;

public class OptionPage extends JFrame implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = -8475963155634927953L;
    private JPanel contentPane;
    private JLabel lblExitBtn;
    private JPanel topBar;
    private Connection connect;
    private int mouseX;
    private int mouseY;
    private Object user;
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
    private JLabel lblNomPage;
    private JLabel lblPanier;
    private JLabel lblLogoPanier;
    private JLabel lblNewLabel;
    private JTextField txtPrenom;
    private JLabel lblNewLabel_1;
    private JTextField txtNom;
    private JLabel lblTlphone;
    private JTextField txtTel;
    private JLabel lblNewLabel_2;
    private JTextField txtMail;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JTextField txtMDP;
    private JTextField txtCP;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JTextField txtVille;
    private JTextField txtAdresse;
    private JButton btnValider;

    // constructeur (page commune entre employé et user)
    public OptionPage(Connection connection, int posX, int posY, Object person) {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	if (posX != 0 && posY != 0) {
	    setBounds(posX, posY, 1080, 630);
	} else {
	    setBounds(100, 100, 1080, 624);
	}

	if (this.connect == null) {
	    this.connect = connection;
	}

	//regarde si c'est un utilisateur ou un employé
	if (person instanceof User) {
	    this.user = (User) person;
	} else {
	    this.user = (Employe) person;
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

	lblNomPage = new JLabel("DriveExpress - Options");
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

	lblNewLabel = new JLabel("Nom");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel.setBounds(484, 24, 56, 17);
	Onglet1.add(lblNewLabel);

	txtPrenom = new JTextField();
	txtPrenom.setBounds(39, 52, 310, 36);
	Onglet1.add(txtPrenom);
	txtPrenom.setColumns(10);

	lblNewLabel_1 = new JLabel("Prenom");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_1.setBounds(39, 24, 56, 17);
	Onglet1.add(lblNewLabel_1);

	txtNom = new JTextField();
	txtNom.setColumns(10);
	txtNom.setBounds(484, 52, 310, 36);
	Onglet1.add(txtNom);

	lblTlphone = new JLabel("T\u00E9l\u00E9phone");
	lblTlphone.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblTlphone.setBounds(39, 316, 78, 17);
	Onglet1.add(lblTlphone);

	txtTel = new JTextField();
	txtTel.setColumns(10);
	txtTel.setBounds(39, 344, 310, 36);
	Onglet1.add(txtTel);

	lblNewLabel_2 = new JLabel("Mail");
	lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_2.setBounds(39, 126, 56, 17);
	Onglet1.add(lblNewLabel_2);

	txtMail = new JTextField();
	txtMail.setColumns(10);
	txtMail.setBounds(39, 154, 310, 36);
	Onglet1.add(txtMail);

	lblNewLabel_3 = new JLabel("Mot de passe");
	lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_3.setBounds(484, 126, 98, 17);
	Onglet1.add(lblNewLabel_3);

	lblNewLabel_4 = new JLabel("Code postal");
	lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_4.setBounds(484, 316, 78, 17);
	Onglet1.add(lblNewLabel_4);

	txtMDP = new JTextField();
	txtMDP.setColumns(10);
	txtMDP.setBounds(484, 154, 310, 36);
	Onglet1.add(txtMDP);

	txtCP = new JTextField();
	txtCP.setColumns(10);
	txtCP.setBounds(484, 344, 310, 36);
	Onglet1.add(txtCP);

	lblNewLabel_5 = new JLabel("Ville");
	lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_5.setBounds(39, 217, 56, 17);
	Onglet1.add(lblNewLabel_5);

	lblNewLabel_6 = new JLabel("Adresse");
	lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_6.setBounds(484, 217, 78, 17);
	Onglet1.add(lblNewLabel_6);

	txtVille = new JTextField();
	txtVille.setColumns(10);
	txtVille.setBounds(39, 245, 310, 36);
	Onglet1.add(txtVille);

	txtAdresse = new JTextField();
	txtAdresse.setColumns(10);
	txtAdresse.setBounds(484, 245, 310, 36);
	Onglet1.add(txtAdresse);

	btnValider = new JButton("Enregistrer");
	btnValider.setBounds(350, 454, 133, 36);
	btnValider.setForeground(Color.BLACK);
	btnValider.setBackground(Color.GREEN);
	btnValider.addMouseListener(this);
	btnValider.setFont(new Font("Arial", Font.PLAIN, 16));
	btnValider.setBorderPainted(false);
	btnValider.setFocusable(false);
	Onglet1.add(btnValider);

	ongletMenu = new JPanel();
	ongletMenu.setBackground(Color.WHITE);
	ongletMenu.setBounds(0, 27, 180, 612);
	contentPane.add(ongletMenu);
	ongletMenu.setLayout(null);

	pnlAcceuil = new JPanel();
	pnlAcceuil.setBounds(0, 143, 180, 80);
	ongletMenu.add(pnlAcceuil);
	pnlAcceuil.addMouseListener(this);
	pnlAcceuil.setLayout(null);

	pnlBoutique = new JPanel();
	pnlBoutique.setBounds(0, 225, 180, 80);
	ongletMenu.add(pnlBoutique);
	pnlBoutique.setLayout(null);

	pnlLogout = new JPanel();
	pnlLogout.setBounds(0, 558, 180, 43);
	ongletMenu.add(pnlLogout);
	pnlLogout.setLayout(null);

	//bouton sur le coté différents si user ou employé
	if (person instanceof User) {

	    pnlPanier = new JPanel();
	    pnlPanier.setBounds(0, 307, 180, 80);
	    ongletMenu.add(pnlPanier);
	    pnlPanier.setLayout(null);

	    lblAcceuil = new JLabel("Acceuil");
	    lblAcceuil.setHorizontalAlignment(SwingConstants.CENTER);
	    lblAcceuil.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
	    lblBoutique.addMouseListener(this);
	    pnlBoutique.add(lblBoutique);

	    lblLogoBoutique = new JLabel("");
	    lblLogoBoutique.setHorizontalAlignment(SwingConstants.CENTER);
	    lblLogoBoutique.setBounds(0, 0, 64, 80);
	    lblLogoBoutique.setIcon(new ImageIcon(MainPage.class.getResource("/ihm/media/boutique.png")));
	    lblLogoBoutique.addMouseListener(this);
	    pnlBoutique.add(lblLogoBoutique);

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

	} else if (person instanceof Employe) {
	    
	    lblAcceuil = new JLabel("Livraisons Ajout\u00E9es");
	    lblAcceuil.setFont(new Font("Tahoma", Font.PLAIN, 13));
	    lblAcceuil.setHorizontalAlignment(SwingConstants.CENTER);
	    lblAcceuil.setBounds(66, 0, 114, 80);
	    lblAcceuil.setBackground(new Color(200, 200, 200));
	    pnlAcceuil.add(lblAcceuil);

	    lblLogoAcceuil = new JLabel("");
	    lblLogoAcceuil.setHorizontalAlignment(SwingConstants.CENTER);
	    lblLogoAcceuil.setBounds(0, 0, 64, 80);
	    lblLogoAcceuil.setIcon(new ImageIcon(MainPage.class.getResource("/ihm/media/LivraisonAjoutee.png")));
	    pnlAcceuil.add(lblLogoAcceuil);

	    lblBoutique = new JLabel("Livraisons en attente");
	    lblBoutique.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    lblBoutique.setHorizontalAlignment(SwingConstants.CENTER);
	    lblBoutique.setBounds(66, 0, 114, 80);
	    lblBoutique.setBackground(new Color(200, 200, 200));
	    lblBoutique.addMouseListener(this);
	    pnlBoutique.add(lblBoutique);

	    lblLogoBoutique = new JLabel("");
	    lblLogoBoutique.setHorizontalAlignment(SwingConstants.CENTER);
	    lblLogoBoutique.setBounds(0, 0, 64, 80);
	    lblLogoBoutique.setIcon(new ImageIcon(MainPage.class.getResource("/ihm/media/LivraisonAttente.png")));
	    lblLogoBoutique.addMouseListener(this);
	    pnlBoutique.add(lblLogoBoutique);
	}

	lblDeconnexion = new JLabel("D\u00E9connexion");
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
	pnlSettings.setBackground(new Color(200, 200, 200));
	ongletMenu.add(pnlSettings);
	pnlSettings.setLayout(null);

	lblOption = new JLabel("Options");
	lblOption.setHorizontalAlignment(SwingConstants.CENTER);
	lblOption.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblOption.setBackground(new Color(200, 200, 200));
	lblOption.setBounds(49, 0, 131, 43);
	lblOption.addMouseListener(this);
	pnlSettings.add(lblOption);

	lblLogoOption = new JLabel("");
	lblLogoOption.setHorizontalAlignment(SwingConstants.CENTER);
	lblLogoOption.setBounds(0, 0, 46, 43);
	lblLogoOption.setIcon(new ImageIcon(MainPage.class.getResource("/ihm/media/SettingsLogo.png")));
	lblLogoOption.setBackground(new Color(200, 200, 200));
	lblLogoOption.addMouseListener(this);
	pnlSettings.add(lblLogoOption);

	// --------------------------------------------------------------
	// champs différent si c'est un utilisateur ou un employé
	if (person instanceof User) {
	    txtPrenom.setText(((User) person).getPrenomUser());
	    txtNom.setText(((User) person).getNomUser());
	    txtAdresse.setText(((User) person).getAdresse());
	    txtCP.setText(((User) person).getCP());
	    txtMail.setText(((User) person).getUserMail());
	    txtMDP.setText(((User) person).getPasswordUser());
	    txtTel.setText(((User) person).getNumTel());
	    txtVille.setText(((User) person).getVille());
	} else if (person instanceof Employe) {
	    txtPrenom.setText(((Employe) person).getPrenomEmploye());
	    txtNom.setText(((Employe) person).getNomEmploye());
	    txtAdresse.setText(((Employe) person).getAdresseEmploye());
	    txtCP.setText(((Employe) person).getCpEmploye());
	    txtMail.setText(((Employe) person).getMailEmploye());
	    txtTel.setText(((Employe) person).getNumTelEmploye());
	    txtVille.setText(((Employe) person).getVilleEmploye());
	    txtMDP.setText(((Employe) person).getPassword());
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

	if (e.getSource() == btnValider) {
	    
	    // check si les champs sont bon
	    boolean enregistrementValide = false;
	    if (DaoDriveExpress.validate(this.txtMail.getText())) {
		this.txtMail.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
		enregistrementValide = true;
	    } else {
		this.txtMail.setBorder(new LineBorder(Color.RED, 2));
	    }

	    enregistrementValide = this.checkJTextFieldString(this.txtCP, true, 5) && enregistrementValide;
	    enregistrementValide = this.checkJTextFieldString(this.txtTel, true, 10) && enregistrementValide;
	    enregistrementValide = this.checkJTextFieldString(this.txtVille) && enregistrementValide;
	    enregistrementValide = this.checkJTextFieldString(this.txtNom) && enregistrementValide;
	    enregistrementValide = this.checkJTextFieldString(this.txtPrenom) && enregistrementValide;
	    enregistrementValide = this.checkJTextFieldString(this.txtAdresse) && enregistrementValide;
	    enregistrementValide = this.checkJTextFieldString(this.txtMDP) && enregistrementValide;

	    // update les infos dans l'instance soit d'utilisateur soit d'employé
	    if (enregistrementValide && this.user instanceof User) {

		((User) this.user).setAdresse(this.txtAdresse.getText());
		((User) this.user).setCpUser(this.txtCP.getText());
		((User) this.user).setNumTel(this.txtTel.getText());
		((User) this.user).setVille(this.txtVille.getText());
		((User) this.user).setNomUser(this.txtNom.getText());
		((User) this.user).setPrenomUser(this.txtPrenom.getText());
		((User) this.user).setPasswordUser(this.txtMDP.getText());
		((User) this.user).setUserMail(this.txtMail.getText());

		DaoDriveExpress.updateUser(connect, (User) this.user);

		// default title and icon
		JOptionPane.showMessageDialog(this, "Modification(s) validée(s)");
	    } else if (enregistrementValide && this.user instanceof Employe) {
		((Employe) this.user).setAdresseEmploye(this.txtAdresse.getText());
		((Employe) this.user).setCpEmploye(this.txtCP.getText());
		((Employe) this.user).setNumTelEmploye(this.txtTel.getText());
		((Employe) this.user).setVilleEmploye(this.txtVille.getText());
		((Employe) this.user).setNomEmploye(this.txtNom.getText());
		((Employe) this.user).setPrenomEmploye(this.txtPrenom.getText());
		((Employe) this.user).setMailEmploye(this.txtMail.getText());
		((Employe) this.user).setPassword(this.txtMDP.getText());

		DaoDriveExpress.updateEmploye(connect, (Employe) this.user);

		JOptionPane.showMessageDialog(this, "Modification(s) validée(s)");
	    }
	}

	if (this.user instanceof User) {

	    try {

		// click pour le panel acceuil
		if ((JLabel) e.getComponent() == this.lblLogoAcceuil || (JLabel) e.getComponent() == this.lblAcceuil) {
		    MainPage mp = new MainPage(this.connect, getLocationOnScreen().x, getLocationOnScreen().y,
			    (User) this.user);
		    mp.setUndecorated(true);
		    mp.setVisible(true);
		    dispose();
		}
		// click pour le panel boutique
		if ((JLabel) e.getComponent() == this.lblBoutique
			|| (JLabel) e.getComponent() == this.lblLogoBoutique) {
		    BoutiquePage bp = new BoutiquePage(this.connect, getLocationOnScreen().x, getLocationOnScreen().y,
			    (User) this.user);
		    bp.setUndecorated(true);
		    bp.setVisible(true);
		    dispose();
		}
		// click pour le panel Panier
		if ((JLabel) e.getComponent() == this.lblPanier || (JLabel) e.getComponent() == this.lblLogoPanier) {
		    PanierPage op = new PanierPage(this.connect, getLocationOnScreen().x, getLocationOnScreen().y,
			    (User) this.user);
		    op.setUndecorated(true);
		    op.setVisible(true);
		    dispose();
		}
	    } catch (Exception e2) {
		// TODO: handle exception
	    }

	    // click pour le panel deconnexion
	    if ((JLabel) e.getComponent() == this.lblDeconnexion
		    || (JLabel) e.getComponent() == this.lblLogoDeconnexion) {
		LoginPage lp = new LoginPage(this.connect, getLocationOnScreen().x, getLocationOnScreen().y);
		lp.setUndecorated(true);
		lp.setVisible(true);
		dispose();
	    }
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
	    // hover pour le panel acceuil
	    if ((JLabel) e.getComponent() == this.lblAcceuil || (JLabel) e.getComponent() == this.lblLogoAcceuil) {
		this.lblAcceuil.setBackground(new Color(220, 220, 220));
		this.lblLogoAcceuil.setBackground(new Color(220, 220, 220));
		this.pnlAcceuil.setBackground(new Color(220, 220, 220));
	    }
	    // Hover pour le panel boutique
	    if ((JLabel) e.getComponent() == this.lblBoutique || (JLabel) e.getComponent() == this.lblLogoBoutique) {
		this.pnlBoutique.setBackground(new Color(220, 220, 220));
		this.lblBoutique.setBackground(new Color(220, 220, 220));
		this.lblLogoBoutique.setBackground(new Color(220, 220, 220));
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

	    // hover pour le panel acceuil
	    if ((JLabel) e.getComponent() == this.lblAcceuil || (JLabel) e.getComponent() == this.lblLogoAcceuil) {
		this.lblAcceuil.setBackground(new Color(240, 240, 240));
		this.pnlAcceuil.setBackground(new Color(240, 240, 240));
		this.lblLogoAcceuil.setBackground(new Color(240, 240, 240));
	    }
	    // Hover pour le panel boutique
	    if ((JLabel) e.getComponent() == this.lblBoutique || (JLabel) e.getComponent() == this.lblLogoBoutique) {
		this.pnlBoutique.setBackground(new Color(240, 240, 240));
		this.lblBoutique.setBackground(new Color(240, 240, 240));
		this.lblLogoBoutique.setBackground(new Color(240, 240, 240));
	    }
	    // Hover pour le panel panier
	    if ((JLabel) e.getComponent() == this.lblPanier || (JLabel) e.getComponent() == this.lblLogoPanier) {
		this.pnlPanier.setBackground(new Color(240, 240, 240));
		this.lblPanier.setBackground(new Color(240, 240, 240));
		this.lblLogoPanier.setBackground(new Color(240, 240, 240));
	    }
	} catch (Exception e2) {

	}

    }

    // Check si le texte du JTextField est vide renvoie un boolean
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

    // Surchage de checkJTextFieldString avec un check si le text du JTextField est
    // un int et si il a le nombre de caractère voulu
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