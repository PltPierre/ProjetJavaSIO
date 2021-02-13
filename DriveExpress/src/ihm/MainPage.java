package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainPage extends JFrame implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = -8475963155634927953L;
    private JPanel contentPane;
    private JLabel lblExitBtn;
    private JPanel topBar;
    private Connection connect;
    private int mouseX;
    private int mouseY;
    private JPanel Onglet1;
    private JPanel ongletMenu;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JPanel panel_4;

    public MainPage(Connection connection, int posX, int posY) {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	if (posX != 0 && posY != 0) {
	    setBounds(posX, posY, 1080, 624);
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

	Onglet1 = new JPanel();
	Onglet1.setBackground(Color.WHITE);
	Onglet1.setBounds(182, 27, 904, 561);
	contentPane.add(Onglet1);
	Onglet1.setLayout(null);

	ongletMenu = new JPanel();
	ongletMenu.setBackground(Color.WHITE);
	ongletMenu.setBounds(0, 27, 180, 561);
	contentPane.add(ongletMenu);
	ongletMenu.setLayout(null);

	panel = new JPanel();
	panel.setBounds(0, 0, 180, 80);
	ongletMenu.add(panel);

	panel_1 = new JPanel();
	panel_1.setBounds(0, 82, 180, 80);
	ongletMenu.add(panel_1);

	panel_2 = new JPanel();
	panel_2.setBounds(0, 164, 180, 80);
	ongletMenu.add(panel_2);

	panel_3 = new JPanel();
	panel_3.setBounds(0, 246, 180, 80);
	ongletMenu.add(panel_3);

	panel_4 = new JPanel();
	panel_4.setBounds(0, 328, 180, 80);
	ongletMenu.add(panel_4);
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

    }

    @Override
    public void mouseExited(MouseEvent e) {
	// TODO Stub de la méthode généré automatiquement

    }
}
