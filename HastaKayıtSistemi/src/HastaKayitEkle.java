import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class HastaKayitEkle extends JFrame {
    
	private JPanel contentPane;
	private JTextField hasta_id;
	private JTextField hasta_adi;
	private JTextField hasta_soyadi;
	private JTextField hastalik;
	private JTextField doktor;
	private JTextField yas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HastaKayitEkle frame = new HastaKayitEkle();
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
	public HastaKayitEkle() {
		setTitle("Kay\u0131t Ekle/G\u00FCncelle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel kontrol = new JLabel("");
		kontrol.setHorizontalAlignment(SwingConstants.CENTER);
		kontrol.setFont(new Font("Times New Roman", Font.BOLD, 25));
		kontrol.setBounds(0, 560, 548, 38);
		contentPane.add(kontrol);
		
		JLabel lblNewLabel = new JLabel("Kay\u0131t S\u0131ra No:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 44, 161, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblHastaAd = new JLabel("Hasta Ad\u0131:");
		lblHastaAd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHastaAd.setForeground(Color.RED);
		lblHastaAd.setBackground(Color.GREEN);
		lblHastaAd.setBounds(10, 113, 161, 42);
		contentPane.add(lblHastaAd);
		
		JLabel lblHastaSoyad = new JLabel("Hasta SoyAd\u0131:");
		lblHastaSoyad.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHastaSoyad.setForeground(Color.RED);
		lblHastaSoyad.setBackground(Color.GREEN);
		lblHastaSoyad.setBounds(10, 181, 161, 42);
		contentPane.add(lblHastaSoyad);
		
		JLabel lblHastannHastal = new JLabel("Hastan\u0131n Hastal\u0131\u011F\u0131:");
		lblHastannHastal.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHastannHastal.setForeground(Color.RED);
		lblHastannHastal.setBackground(Color.GREEN);
		lblHastannHastal.setBounds(10, 317, 161, 42);
		contentPane.add(lblHastannHastal);
		
		JLabel lblHastannDoktoru = new JLabel("Hastan\u0131n Doktoru:");
		lblHastannDoktoru.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHastannDoktoru.setForeground(Color.RED);
		lblHastannDoktoru.setBackground(Color.GREEN);
		lblHastannDoktoru.setBounds(10, 380, 161, 42);
		contentPane.add(lblHastannDoktoru);
		
		hasta_id = new JTextField();
		hasta_id.setBounds(188, 49, 191, 38);
		contentPane.add(hasta_id);
		hasta_id.setColumns(10);
		
		hasta_adi = new JTextField();
		hasta_adi.setColumns(10);
		hasta_adi.setBounds(188, 118, 191, 38);
		contentPane.add(hasta_adi);
		
		hasta_soyadi = new JTextField();
		hasta_soyadi.setColumns(10);
		hasta_soyadi.setBounds(188, 186, 191, 38);
		contentPane.add(hasta_soyadi);
		
		hastalik = new JTextField();
		hastalik.setColumns(10);
		hastalik.setBounds(188, 322, 191, 38);
		contentPane.add(hastalik);
		
		doktor = new JTextField();
		doktor.setColumns(10);
		doktor.setBounds(188, 385, 191, 38);
		contentPane.add(doktor);
		
		JButton kayit = new JButton("Kay\u0131t");
		kayit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		kayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					PreparedStatement myStatt = null;
					Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hasta_kayit_sistemi","root","1234Akdeniz");
					String ekle = "insert into hastalar(idhastalar,hasta_adi,hasta_soyadi,hasta_yas,hasta_hastalik,hasta_doktor)"+ "values(?,?,?,?,?,?)";
					 myStatt = myConn.prepareStatement(ekle);
					 myStatt.setInt(1,Integer.parseInt(hasta_id.getText())  ) ;
					 myStatt.setString(2,hasta_adi.getText()) ;
					 myStatt.setString(3,hasta_soyadi.getText()) ;
					 myStatt.setInt(4,Integer.parseInt(yas.getText())) ;
					 myStatt.setString(5,hastalik.getText()) ;
					 myStatt.setString(6,doktor.getText()) ;
					 myStatt.execute();
					 kontrol.setText("Kayýt Baþarýlý ile Alýndý!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					 kontrol.setText("Kayýt Gerçekleþtirilemedi!!");
				}
				
			}
		});
		kayit.setBounds(73, 460, 161, 55);
		contentPane.add(kayit);
		
		JLabel hasta_yas = new JLabel("Hastan\u0131n Ya\u015F\u0131:");
		hasta_yas.setForeground(Color.RED);
		hasta_yas.setFont(new Font("Times New Roman", Font.BOLD, 18));
		hasta_yas.setBackground(Color.GREEN);
		hasta_yas.setBounds(10, 254, 161, 42);
		contentPane.add(hasta_yas);
		
		yas = new JTextField();
		yas.setColumns(10);
		yas.setBounds(188, 259, 191, 38);
		contentPane.add(yas);
		
		JButton btnNewButton = new JButton("Sayfay\u0131 Kapat");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        dispose();
				
			}
		});
		btnNewButton.setBounds(445, 608, 103, 25);
		contentPane.add(btnNewButton);
		
		JButton btnGncelleme = new JButton("G\u00FCncelle");
		btnGncelleme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hasta_kayit_sistemi","root","1234Akdeniz");
					PreparedStatement myStatt = null;
					String guncelle = "update hastalar set hasta_adi=?, hasta_soyadi =?, hasta_yas = ?,hasta_hastalik = ?,hasta_doktor = ? where idhastalar = ?";
					myStatt = myConn.prepareStatement(guncelle);
					myStatt.setString(1, hasta_adi.getText());
					myStatt.setString(2, hasta_soyadi.getText());
					myStatt.setInt(3,Integer.parseInt(yas.getText()) );
					myStatt.setString(4, hastalik.getText());
					myStatt.setString(5, doktor.getText());
					myStatt.setInt(6,Integer.parseInt(hasta_id.getText()));
					 kontrol.setText("Kayýt Baþarýlý ile Güncellendi!");
					myStatt.execute();
				} catch (SQLException e1) {
					e1.printStackTrace();
					kontrol.setText("Kayýt Güncellenemedi!!");
				  
				}
			}
			
			
		});
		btnGncelleme.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnGncelleme.setBounds(300, 460, 161, 55);
		contentPane.add(btnGncelleme);
	
		
		
		
	}
}
