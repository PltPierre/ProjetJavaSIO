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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Connection connect;
	private JTextField txtMail;
	private JTextField txtMDP;
	
	public MainPage() {
		
		
		connect = DaoDriveExpress.SQLConnection();
		
		setBackground(Color.WHITE);
		setTitle("DriveExpress");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 624);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel leftSide = new JPanel();
		leftSide.setBackground(SystemColor.windowBorder);
		leftSide.setBounds(0, 26, 535, 612);
		contentPane.add(leftSide);
		
		JPanel topBar = new JPanel();
		topBar.setBackground(SystemColor.activeCaptionBorder);
		topBar.setBounds(0, 0, 1086, 27);
		contentPane.add(topBar);
		topBar.setLayout(null);
		
		JLabel lblExitBtn = new JLabel("X");
		lblExitBtn.setToolTipText("Fermer");
		lblExitBtn.setForeground(Color.RED);
		lblExitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource()==lblExitBtn) {
					if(connect!=null) {
						try {
							connect.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					try {
						if(connect.isClosed()) {
							System.exit(EXIT_ON_CLOSE);
						}
						else {
							System.out.println("db pas fermé");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		lblExitBtn.setBackground(Color.WHITE);
		lblExitBtn.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblExitBtn.setHorizontalAlignment(SwingConstants.CENTER);
		lblExitBtn.setBounds(1018, 0, 68, 27);
		topBar.add(lblExitBtn);
		
		JLabel lblLogin = new JLabel("Se connecter");
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 20));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(534, 71, 540, 43);
		contentPane.add(lblLogin);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMail.setBounds(604, 142, 46, 27);
		contentPane.add(lblMail);
		
		txtMail = new JTextField();
		txtMail.setFont(new Font("Arial", Font.PLAIN, 16));
		txtMail.setBounds(604, 168, 414, 35);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMotDePasse.setBounds(604, 243, 97, 27);
		contentPane.add(lblMotDePasse);
		
		txtMDP = new JTextField();
		txtMDP.setFont(new Font("Arial", Font.PLAIN, 16));
		txtMDP.setColumns(10);
		txtMDP.setBounds(604, 281, 414, 35);
		contentPane.add(txtMDP);
		
		JButton btnValidationConnection = new JButton("Valider");
		
		btnValidationConnection.setForeground(Color.BLACK);
		btnValidationConnection.setBackground(Color.GREEN);
		btnValidationConnection.setFont(new Font("Arial", Font.PLAIN, 16));
		btnValidationConnection.setBounds(742, 385, 146, 43);
		btnValidationConnection.setBorderPainted(false);
		btnValidationConnection.setFocusable(false);
		contentPane.add(btnValidationConnection);
		
		JLabel lblDbConnection = new JLabel("OUI");
		lblDbConnection.setHorizontalAlignment(SwingConstants.CENTER);
		lblDbConnection.setBounds(545, 342, 519, 14);
		contentPane.add(lblDbConnection);
		
		btnValidationConnection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource()==btnValidationConnection) {
					if(txtMDP.getText().isEmpty() || txtMail.getText().isEmpty()) {
						lblDbConnection.setText("Veuillez renseigner tout les champs");
					}
					else {
						lblDbConnection.setText(DaoDriveExpress.getFullNameUser(txtMail.getText(), txtMDP.getText(), connect));
					}
				}
			}
		});
		

		txtMDP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(txtMDP.getText().isEmpty() || txtMail.getText().isEmpty()) {
						lblDbConnection.setText("Veuillez renseigner tout les champs");
					}
					else {
						lblDbConnection.setText(DaoDriveExpress.getFullNameUser(txtMail.getText(), txtMDP.getText(), connect));
					}
				}
			}
		});
	}
}
