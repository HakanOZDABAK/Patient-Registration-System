import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class HastaKayitSil extends JFrame {
	
	private JPanel contentPane;
	private JTextField IdText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 HastaKayitSil frame = new HastaKayitSil();
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
	public HastaKayitSil() {
		setTitle("Kay\u0131t Sil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel yazi = new JLabel("");
		yazi.setHorizontalAlignment(SwingConstants.CENTER);
		yazi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		yazi.setBounds(69, 408, 522, 72);
		contentPane.add(yazi);
		IdText = new JTextField();
		IdText.setFont(new Font("Times New Roman", Font.BOLD, 18));
		IdText.setToolTipText("Silinecek ID");
		IdText.setBounds(216, 201, 217, 47);
		contentPane.add(IdText);
		IdText.setColumns(10);
		JButton Sil = new JButton("S\u0130L");
		Sil.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		Sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hasta_kayit_sistemi","root","1234Akdeniz");
					PreparedStatement myStatt = null;
					String sil = "Delete from hastalar where idhastalar = ?";
					 myStatt = myConn.prepareStatement(sil);
					myStatt.setInt(1,Integer.parseInt(IdText.getText()) );
					 myStatt.executeUpdate();
					 yazi.setText("Kayýt Baþarýlý ile Silindi!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					yazi.setText("Kayýt Silme Ýþlemi Gerçekleþtirilemedi!!");
				}
			}
		});
		Sil.setBounds(230, 293, 191, 54);
		contentPane.add(Sil);
		
		JButton btnNewButton = new JButton("Sayfay\u0131 Kapat");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
				
			}
		});
		btnNewButton.setBounds(549, 490, 112, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Silinmesini \u0130stedi\u011Finiz Kayd\u0131n Id'sini Giriniz = ");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(91, 116, 522, 75);
		contentPane.add(lblNewLabel);
		
		
		
		
	}
}
