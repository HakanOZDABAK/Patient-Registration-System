import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HastaKayitGirisSayfasi extends JFrame {
	static HastaKayitGirisSayfasi frame = new HastaKayitGirisSayfasi();
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			
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
	public HastaKayitGirisSayfasi() {
		setTitle("HAKAN \u00D6ZDABAK HOSPITAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HAKAN \u00D6ZDABAK HOSPITAL HASTA KAYIT S\u0130STEM\u0130\r\n\r\n\r\n");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel.setBounds(55, 67, 622, 106);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("S\u0130STEME G\u0130R\u0130\u015E YAP");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			dispose();
			KayitListesi kayitlist = new KayitListesi();
			kayitlist.setVisible(true);
				
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.setBounds(234, 284, 272, 52);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("S\u0130STEME G\u0130RMEK \u0130\u00C7\u0130N L\u00DCTFEN A\u015EA\u011EIDAK\u0130 BUTONA TIKLAYINIZ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(10, 154, 743, 52);
		contentPane.add(lblNewLabel_1);
	}
}
