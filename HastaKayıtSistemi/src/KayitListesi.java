import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class KayitListesi extends JFrame {

	private JPanel contentPane;
	private JTable table;
    DefaultTableModel model = new DefaultTableModel();
    Object[]sutunlar = {"Kayýt ID", "Hasta Adý", "Hasta Soyadý", "Hasta Yaþý", "Hastanýn Hastalýðý", "Hastanýn Doktoru"};
    Object[] satirlar = new Object[6];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KayitListesi frame = new KayitListesi();
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
	public KayitListesi() {
		setTitle("Kay\u0131tlar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 43, 615, 323);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(SystemColor.menuText);
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table.setForeground(SystemColor.text);
		model.setColumnIdentifiers(sutunlar);
		table.setBounds(212, 261, 198, 165);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Kay\u0131t Listesini \u00C7a\u011F\u0131r");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Baglanti baglanti = new Baglanti();
				ResultSet myRs = baglanti.yap();
				model.setRowCount(0);
				try {
					
					while(myRs.next()) {
						
						satirlar[0] = myRs.getInt("idhastalar");
						satirlar[1] = myRs.getString("hasta_adi");
						satirlar[2] = myRs.getString("hasta_soyadi");
						satirlar[3]	= myRs.getInt("hasta_yas");	
						satirlar[4] = myRs.getString("hasta_hastalik");
						satirlar[5]	= myRs.getString("hasta_doktor");		
						model.addRow(satirlar);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					
				}
				
				table.setModel(model);
               
				
			}
		});
		btnNewButton.setBounds(269, 390, 200, 37);
		contentPane.add(btnNewButton);
		
		JButton btnKaytGirgncelle = new JButton("Kay\u0131t Gir/G\u00FCncelle");
		btnKaytGirgncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HastaKayitEkle ekle = new HastaKayitEkle();
				ekle.setVisible(true);
			}
		});
		btnKaytGirgncelle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnKaytGirgncelle.setBounds(71, 457, 200, 37);
		contentPane.add(btnKaytGirgncelle);
		
		JButton btnKaytSil = new JButton("Kay\u0131t Sil");
		btnKaytSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HastaKayitSil sil = new HastaKayitSil();
				sil.setVisible(true);
			}
		});
		btnKaytSil.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnKaytSil.setBounds(465, 457, 200, 37);
		contentPane.add(btnKaytSil);
	}
}
