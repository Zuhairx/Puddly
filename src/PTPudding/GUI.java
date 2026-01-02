package PTPudding;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 4384317452685425476L;
	// deklarasi variabel Menu utama

	// database
	KoneksiDatabase kd = new KoneksiDatabase();

	// image
	ImageIcon Logo = new ImageIcon("Logo.png");
	ImageIcon succes = new ImageIcon("success.png");

	// label
	JLabel labeljudul = new JLabel();
	JLabel labelinsert = new JLabel();
	JLabel labelview = new JLabel();
	JLabel labelupdate = new JLabel();
	JLabel labeldelete = new JLabel();

	// frame
	JFrame MainFrame = new JFrame();

	// button
	JButton InsertButtonMenu = new JButton();
	JButton ViewButtonMenu = new JButton();
	JButton UpdateButtonMenu = new JButton();
	JButton DeleteButtonMenu = new JButton();

	// launcher
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI G = new GUI();
					G.validasiangkaharga();
					G.validasiangkastok();
					G.launcher();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// membuat aplikasi
	public void launcher() {
		MainMenu();
	}

	// pembuatan konten aplikasi
	public void MainMenu() {
		// koneksi database
		kd.connect();

		// pembuatan border
		Border b = BorderFactory.createLineBorder(Color.black, 3);

		// Label Judul
		labeljudul.setText("Data Pudding");
		Image img = Logo.getImage();
		Image newimg = img.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		ImageIcon a = new ImageIcon(newimg);
		labeljudul.setIcon(a);
		labeljudul.setHorizontalTextPosition(JLabel.CENTER);
		labeljudul.setVerticalTextPosition(JLabel.BOTTOM);
		labeljudul.setFont(new Font("Comic sans", Font.BOLD, 40));
		labeljudul.setIconTextGap(3);
		labeljudul.setBackground(new Color(0xf5ecd5));
		labeljudul.setOpaque(true);
		labeljudul.setBorder(b);
		labeljudul.setVerticalAlignment(JLabel.CENTER);
		labeljudul.setHorizontalAlignment(JLabel.CENTER);

		// label insert Menu
		labelinsert.setText("Insert");
		labelinsert.setFont(new Font("Calibri", Font.BOLD, 30));
		labelinsert.setHorizontalTextPosition(JLabel.CENTER);
		labelinsert.setVerticalTextPosition(JLabel.CENTER);
		labelinsert.setVerticalAlignment(JLabel.CENTER);
		labelinsert.setHorizontalAlignment(JLabel.CENTER);

		// label View Menu
		labelview.setText("View");
		labelview.setFont(new Font("Calibri", Font.BOLD, 30));
		labelview.setHorizontalTextPosition(JLabel.CENTER);
		labelview.setVerticalTextPosition(JLabel.CENTER);
		labelview.setVerticalAlignment(JLabel.CENTER);
		labelview.setHorizontalAlignment(JLabel.CENTER);

		// label update Menu
		labelupdate.setText("Update");
		labelupdate.setFont(new Font("Calibri", Font.BOLD, 30));
		labelupdate.setHorizontalTextPosition(JLabel.CENTER);
		labelupdate.setVerticalTextPosition(JLabel.CENTER);
		labelupdate.setVerticalAlignment(JLabel.CENTER);
		labelupdate.setHorizontalAlignment(JLabel.CENTER);

		// label delete Menu
		labeldelete.setText("Delete");
		labeldelete.setFont(new Font("Calibri", Font.BOLD, 30));
		labeldelete.setHorizontalTextPosition(JLabel.CENTER);
		labeldelete.setVerticalTextPosition(JLabel.CENTER);
		labeldelete.setVerticalAlignment(JLabel.CENTER);
		labeldelete.setHorizontalAlignment(JLabel.CENTER);

		// button Insert
		InsertButtonMenu.setBackground(Color.cyan);
		InsertButtonMenu.setLayout(new BorderLayout());
		InsertButtonMenu.add(labelinsert);

		// button View
		ViewButtonMenu.setBackground(Color.yellow);
		ViewButtonMenu.setLayout(new BorderLayout());
		ViewButtonMenu.add(labelview);

		// Button Update
		UpdateButtonMenu.setBackground(Color.green);
		UpdateButtonMenu.setLayout(new BorderLayout());
		UpdateButtonMenu.add(labelupdate);

		// Button Delete
		DeleteButtonMenu.setBackground(Color.red);
		DeleteButtonMenu.setLayout(new BorderLayout());
		DeleteButtonMenu.add(labeldelete);

		// Main frame
		MainFrame.setTitle("Toko Pudding");
		MainFrame.setLayout(new GridLayout(5, 1, 3, 3));
		MainFrame.setSize(800, 800);
		MainFrame.setLocationRelativeTo(null);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setIconImage(Logo.getImage());
		MainFrame.getContentPane().setBackground(Color.black);
		MainFrame.add(labeljudul);
		MainFrame.add(InsertButtonMenu);
		MainFrame.add(ViewButtonMenu);
		MainFrame.add(UpdateButtonMenu);
		MainFrame.add(DeleteButtonMenu);
		MainFrame.setResizable(true);
		MainFrame.setVisible(true);

		// action
		InsertButtonMenu.addActionListener(this);
		ViewButtonMenu.addActionListener(this);
		UpdateButtonMenu.addActionListener(this);
		DeleteButtonMenu.addActionListener(this);
		ButtonInsert.addActionListener(this);
		ButtonSearch.addActionListener(this);
		ButtonUpdate.addActionListener(this);
		ButtonDelete.addActionListener(this);
		ButtonBack.addActionListener(this);
	}

	// deklarasi variabel Sub-Menu

	// tabel data
	JTable tblData = new JTable();
	// frame
	JFrame InsertFrame = new JFrame();
	JFrame ViewFrame = new JFrame();
	JFrame UpdateFrame = new JFrame();
	JFrame DeleteFrame = new JFrame();

	// scrollpane
	JScrollPane scrollPane = new JScrollPane();

	// jpanel
	JPanel panel = new JPanel();

	// button
	JButton ButtonInsert = new JButton();
	JButton ButtonSearch = new JButton();
	JButton ButtonView = new JButton();
	JButton ButtonUpdate = new JButton();
	JButton ButtonDelete = new JButton();
	JButton ButtonBack = new JButton();

	// label
	JLabel labelInsertMenu = new JLabel();
	JLabel labelViewMenu = new JLabel();
	JLabel labelUpdateMenu = new JLabel();
	JLabel labelDeleteMenu = new JLabel();
	JLabel labelNamaMenu = new JLabel();
	JLabel labelHargaMenu = new JLabel();
	JLabel labelStokMenu = new JLabel();

	// textfield
	JTextField tfSearchMenu = new JTextField();
	JTextField tfNamaMenu = new JTextField();
	JTextField tfHargaMenu = new JTextField();
	JTextField tfStokMenu = new JTextField();

	public void Insert() {
		// tabel
		try {
			generateTable();
			tblData.setEnabled(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Database Failed Connected", "Message", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		// label
		labelInsertMenu.setText("Insert Data");
		labelInsertMenu.setHorizontalAlignment(SwingConstants.CENTER);
		labelInsertMenu.setFont(new Font("Open Sans", Font.BOLD, 21));
		labelInsertMenu.setForeground(Color.WHITE);
		labelInsertMenu.setBounds(160, 11, 260, 27);
		labelNamaMenu.setText("Nama Pudding");
		labelNamaMenu.setFont(new Font("", Font.PLAIN, 17));
		labelNamaMenu.setBounds(149, 67, 116, 27);
		labelNamaMenu.setForeground(Color.WHITE);
		labelHargaMenu.setText("Harga");
		labelHargaMenu.setFont(new Font("Open Sans", Font.PLAIN, 17));
		labelHargaMenu.setBounds(150, 149, 102, 30);
		labelHargaMenu.setForeground(Color.WHITE);
		labelStokMenu.setText("Stok");
		labelStokMenu.setFont(new Font("Open Sans", Font.PLAIN, 17));
		labelStokMenu.setBounds(150, 230, 102, 30);
		labelStokMenu.setForeground(Color.WHITE);

		// textfield
		tfNamaMenu.setToolTipText("Input Nama");
		tfNamaMenu.setBounds(150, 98, 277, 34);
		tfNamaMenu.setColumns(10);
		tfNamaMenu.setEnabled(true);
		tfNamaMenu.setEditable(true);
		tfHargaMenu.setToolTipText("Input Harga");
		tfHargaMenu.setColumns(10);
		tfHargaMenu.setBounds(150, 179, 277, 34);
		tfHargaMenu.setEnabled(true);
		tfHargaMenu.setEditable(true);
		tfStokMenu.setToolTipText("input Stok");
		tfStokMenu.setColumns(10);
		tfStokMenu.setBounds(150, 263, 277, 34);
		tfStokMenu.setEnabled(true);
		tfStokMenu.setEditable(true);

		// button
		ButtonInsert.setText("Insert");
		ButtonInsert.setBackground(new Color(0x35cade));
		ButtonInsert.setForeground(Color.WHITE);
		ButtonInsert.setBounds(150, 320, 127, 34);
		ButtonBack.setText("Back");
		ButtonBack.setBackground(new Color(0x82807f));
		ButtonBack.setForeground(Color.WHITE);
		ButtonBack.setBounds(300, 320, 127, 34);

		// frame
		InsertFrame.setTitle("Menu Insert");
		InsertFrame.getContentPane().setBackground(new Color(0x007198));
		InsertFrame.setLayout(null);
		InsertFrame.setSize(600, 500);
		InsertFrame.setLocationRelativeTo(null);
		InsertFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InsertFrame.add(labelInsertMenu);
		InsertFrame.add(labelNamaMenu);
		InsertFrame.add(labelHargaMenu);
		InsertFrame.add(labelStokMenu);
		InsertFrame.add(tfNamaMenu);
		InsertFrame.add(tfHargaMenu);
		InsertFrame.add(tfStokMenu);
		InsertFrame.add(ButtonInsert);
		InsertFrame.add(ButtonBack);
		InsertFrame.setResizable(false);
		InsertFrame.setVisible(true);

	}

	public void View() {
		// scrollpane
		scrollPane.setBounds(80, 70, 400, 287);
		scrollPane.setViewportView(tblData);

		// label
		labelViewMenu.setText("View Menu");
		labelViewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		labelViewMenu.setFont(new Font("Open Sans", Font.BOLD, 21));
		labelViewMenu.setForeground(Color.WHITE);
		labelViewMenu.setBounds(160, 11, 260, 27);

		// button
		ButtonBack.setText("Back To Main Menu");
		ButtonBack.setBackground(new Color(0x82807f));
		ButtonBack.setForeground(Color.WHITE);
		ButtonBack.setBounds(130, 380, 300, 50);

		// tabel
		try {
			generateTable();
			tblData.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Database Failed Connected", "Message", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		// frame
		ViewFrame.setTitle("view data");
		ViewFrame.getContentPane().setBackground(new Color(0xdec731));
		ViewFrame.setLayout(null);
		ViewFrame.setSize(600, 500);
		ViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ViewFrame.add(scrollPane);
		ViewFrame.add(labelViewMenu);
		ViewFrame.add(ButtonBack);
		ViewFrame.setLocationRelativeTo(null);
		ViewFrame.setResizable(false);
		ViewFrame.setVisible(true);

	}

	public void Update() {
		// tabel
		try {
			generateTable();
			tblData.setEnabled(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Database Failed Connected", "Message", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		// label
		labelUpdateMenu.setText("Update Menu");
		labelUpdateMenu.setHorizontalAlignment(SwingConstants.CENTER);
		labelUpdateMenu.setFont(new Font("Open Sans", Font.BOLD, 21));
		labelUpdateMenu.setForeground(Color.WHITE);
		labelUpdateMenu.setBounds(160, 11, 260, 27);
		labelNamaMenu.setText("Nama Menu");
		labelNamaMenu.setFont(new Font("Open Sans", Font.PLAIN, 17));
		labelNamaMenu.setBounds(146, 138, 116, 27);
		labelNamaMenu.setForeground(Color.WHITE);
		labelHargaMenu.setText("Harga Menu");
		labelHargaMenu.setFont(new Font("Open Sans", Font.PLAIN, 17));
		labelHargaMenu.setBounds(146, 216, 102, 30);
		labelHargaMenu.setForeground(Color.WHITE);
		labelStokMenu.setText("Stok Menu");
		labelStokMenu.setFont(new Font("Open Sans", Font.PLAIN, 17));
		labelStokMenu.setBounds(146, 290, 102, 30);
		labelStokMenu.setForeground(Color.WHITE);

		// textfield
		tfSearchMenu.setToolTipText("Search ID");
		tfSearchMenu.setColumns(10);
		tfSearchMenu.setBounds(22, 24, 234, 36);
		tfNamaMenu.setToolTipText("Nama Menu");
		tfNamaMenu.setColumns(10);
		tfNamaMenu.setEditable(false);
		tfNamaMenu.setBounds(146, 172, 254, 34);
		tfHargaMenu.setToolTipText("Harga Menu");
		tfHargaMenu.setColumns(10);
		tfHargaMenu.setEnabled(false);
		tfHargaMenu.setEditable(false);
		tfHargaMenu.setBounds(146, 246, 254, 34);
		tfStokMenu.setToolTipText("Stok Menu");
		tfStokMenu.setColumns(10);
		tfStokMenu.setBounds(146, 320, 254, 34);
		tfStokMenu.setEnabled(false);
		tfStokMenu.setEditable(false);

		// button
		ButtonSearch.setText("Search");
		ButtonSearch.setFont(new Font("Ubuntu Mono", Font.PLAIN, 17));
		ButtonSearch.setForeground(Color.WHITE);
		ButtonSearch.setBounds(270, 24, 89, 36);
		ButtonSearch.setBackground(new Color(0x4dbf5e));
		ButtonUpdate.setText("Update");
		ButtonUpdate.setBackground(new Color(0x538249));
		ButtonUpdate.setForeground(Color.WHITE);
		ButtonUpdate.setBounds(146, 380, 127, 34);
		ButtonBack.setText("Back");
		ButtonBack.setBackground(new Color(0x82807f));
		ButtonBack.setForeground(Color.WHITE);
		ButtonBack.setBounds(280, 380, 127, 34);

		// jpanel
		panel.setBackground(Color.gray);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
				new Color(160, 160, 160)), "Search Kode Menu",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.white));
		panel.setBounds(90, 49, 385, 77);
		panel.setLayout(null);
		panel.add(tfSearchMenu);
		panel.add(ButtonSearch);

		// frame
		UpdateFrame.setTitle("Update data");
		UpdateFrame.getContentPane().setBackground(new Color(0x7ccc84));
		UpdateFrame.setLayout(null);
		UpdateFrame.setSize(600, 500);
		UpdateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UpdateFrame.add(labelUpdateMenu);
		UpdateFrame.add(labelNamaMenu);
		UpdateFrame.add(labelHargaMenu);
		UpdateFrame.add(labelStokMenu);
		UpdateFrame.add(tfNamaMenu);
		UpdateFrame.add(tfHargaMenu);
		UpdateFrame.add(tfStokMenu);
		UpdateFrame.add(panel);
		UpdateFrame.add(ButtonUpdate);
		UpdateFrame.add(ButtonBack);
		UpdateFrame.setLocationRelativeTo(null);
		UpdateFrame.setResizable(false);
		UpdateFrame.setVisible(true);

	}

	public void Delete() {
		// scrollpane
		scrollPane.setBounds(80, 70, 400, 287);
		scrollPane.setViewportView(tblData);

		// label
		labelViewMenu.setText("Delete Menu");
		labelViewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		labelViewMenu.setFont(new Font("Open Sans", Font.BOLD, 21));
		labelViewMenu.setForeground(Color.WHITE);
		labelViewMenu.setBounds(160, 11, 260, 27);

		// button
		ButtonDelete.setText("Delete");
		ButtonDelete.setBackground(new Color(0xe95953));
		ButtonDelete.setForeground(Color.WHITE);
		ButtonDelete.setBounds(150, 380, 127, 34);
		ButtonBack.setText("Back");
		ButtonBack.setBackground(new Color(0x82807f));
		ButtonBack.setForeground(Color.WHITE);
		ButtonBack.setBounds(300, 380, 127, 34);

		// tabel
		try {
			generateTable();
			tblData.setEnabled(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Database Failed Connected", "Message", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		// frame
		DeleteFrame.setTitle("Delete data");
		DeleteFrame.getContentPane().setBackground(new Color(0xba7575));
		DeleteFrame.setLayout(null);
		DeleteFrame.setSize(600, 500);
		DeleteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DeleteFrame.add(ButtonDelete);
		DeleteFrame.add(ButtonBack);
		DeleteFrame.add(scrollPane);
		DeleteFrame.add(labelViewMenu);
		DeleteFrame.setLocationRelativeTo(null);
		DeleteFrame.setResizable(false);
		DeleteFrame.setVisible(true);

	}

	public void generateTable() {
		DefaultTableModel model = (DefaultTableModel) tblData.getModel();
		model.setRowCount(0);
		String query = "SELECT * FROM `datamenupudding`";
		ResultSet rs;
		try {
			rs = kd.query(query);
			String[] columnNames = { "Kode Menu", "Nama Menu", "Harga Menu", "Stok Menu" };
			model.setColumnIdentifiers(columnNames);
			String Kode, Nama, Harga, Stok;
			while (rs.next()) {
				Kode = rs.getString(1);
				Nama = rs.getString(2);
				Harga = rs.getString(3);
				Stok = rs.getString(4);
				String[] row = { Kode, Nama, Harga, Stok };
				model.addRow(row);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Execute action

	@Override
	public void actionPerformed(ActionEvent e) {
		// Main Menu Button
		if (e.getSource().equals(InsertButtonMenu)) {
			Insert();
			MainFrame.setVisible(false);
		}

		if (e.getSource().equals(ViewButtonMenu)) {
			View();
			MainFrame.setVisible(false);
		}

		if (e.getSource().equals(UpdateButtonMenu)) {
			Update();
			MainFrame.setVisible(false);
		}

		if (e.getSource().equals(DeleteButtonMenu)) {
			Delete();
			MainFrame.setVisible(false);
		}

		// Insert Button
		if (e.getSource().equals(ButtonInsert)) {
			String namacheck = String.valueOf(tfNamaMenu.getText());
			String hargacheck = String.valueOf(tfHargaMenu.getText());
			String stokcek = String.valueOf(tfStokMenu.getText());
			if (namacheck.isBlank() || hargacheck.isBlank() || stokcek.isBlank()) {
				JOptionPane.showMessageDialog(null, "Input tidak boleh kosong!", "Message",
						JOptionPane.WARNING_MESSAGE);
			}
			try {
				String nama = tfNamaMenu.getText();
				int harga = Integer.parseInt(tfHargaMenu.getText());
				int stok = Integer.parseInt(tfStokMenu.getText());

				if (nama.length() > 0 && harga > 0 && stok > 0) {
					Random random = new Random();
					String kode = "PD-" + (random.nextInt(900) + 100);
					// kd = new KoneksiDatabase();
					kd.connect2();
					PreparedStatement query = (PreparedStatement) kd.conn.prepareStatement(
							"INSERT INTO datamenupudding (`KodeMenu`,`NamaMenu`,`HargaMenu`,`StokMenu`) VALUES (?,?,?,?)");
					query.setString(1, kode);
					query.setString(2, nama);
					query.setInt(3, harga);
					query.setInt(4, stok);
					query.executeUpdate();
					generateTable();
					JOptionPane.showMessageDialog(null, "Menu Berhasil Ditambahkan Dengan Kode Menu " + kode, null,
							JOptionPane.INFORMATION_MESSAGE, succes);
					tfNamaMenu.setText("");
					tfHargaMenu.setText("");
					tfStokMenu.setText("");
				}
				if (nama.length() <= 0 || harga <= 0 || stok <= 0) {
					JOptionPane.showMessageDialog(null, "Input tidak boleh kosong!", "Message",
							JOptionPane.WARNING_MESSAGE);
				}

			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Menu gagal ditambahkan", "Message", JOptionPane.ERROR_MESSAGE);
			}
		}

		// Search Button
		if (e.getSource().equals(ButtonSearch)) {
			String kode = tfSearchMenu.getText();
			String query = "SELECT * FROM datamenupudding WHERE KodeMenu = '" + kode + "'";
			try {
				if (kode.length() > 0) {
					ResultSet rs = kd.query(query);
					boolean notEmpty = rs.next();
					if (notEmpty) {
						rs = kd.query(query);
						while (rs.next()) {
							tfNamaMenu.setText(rs.getString(2));
							tfNamaMenu.setEditable(false);
							tfHargaMenu.setText(rs.getString(3));
							tfHargaMenu.setEnabled(true);
							tfHargaMenu.setEditable(true);
							tfStokMenu.setText(rs.getString(4));
							tfStokMenu.setEnabled(true);
							tfStokMenu.setEditable(true);
						}
					} else {
						tfSearchMenu.setText("");
						tfHargaMenu.setText("");
						tfStokMenu.setText("");
						JOptionPane.showMessageDialog(null, "Menu Dengan Kode Menu " + kode + " Tidak Ditemukan");
					}
				} else {
					tfSearchMenu.setText("");
					tfNamaMenu.setText("");
					tfHargaMenu.setText("");
					tfStokMenu.setText("");
					JOptionPane.showMessageDialog(null, "Input Kode Menu Terlebih Dahulu");
				}
			} catch (Exception er) {
				tfSearchMenu.setText("");
				tfNamaMenu.setText("");
				tfHargaMenu.setText("");
				tfStokMenu.setText("");
				JOptionPane.showMessageDialog(null, "Menu Dengan Kode Menu " + kode + " Tidak Ditemukan");
			}
		}

		// Update Button
		if (e.getSource().equals(ButtonUpdate)) {
			try {
				String kode = tfSearchMenu.getText();
				String nama = tfNamaMenu.getText();
				int harga = Integer.parseInt(tfHargaMenu.getText());
				int stok = Integer.parseInt(tfStokMenu.getText());
				if (kode.length() > 0 && nama.length() > 0 && harga > 0 && stok > 0) {
					PreparedStatement query = (PreparedStatement) kd.conn.prepareStatement(
							"UPDATE `datamenupudding` SET `NamaMenu`=?,`HargaMenu`=?,`StokMenu`=? WHERE KodeMenu = ?");
					query.setString(1, nama);
					query.setInt(2, harga);
					query.setInt(3, stok);
					query.setString(4, kode);
					query.executeUpdate();
					generateTable();
					JOptionPane.showMessageDialog(null, "Data Dengan Kode Menu " + kode + " Berhasil Diupdate", null,
							JOptionPane.INFORMATION_MESSAGE, succes);
					tfSearchMenu.setText("");
					tfNamaMenu.setText("");
					tfHargaMenu.setText("");
					tfStokMenu.setText("");
					tfHargaMenu.setEnabled(false);
					tfHargaMenu.setEditable(false);
					tfStokMenu.setEnabled(false);
					tfStokMenu.setEditable(false);
				} else {
					tfSearchMenu.getText();
					tfNamaMenu.getText();
					tfHargaMenu.setText("");
					tfStokMenu.setText("");
					PreparedStatement query = (PreparedStatement) kd.conn.prepareStatement(
							"UPDATE `datamenupudding` SET `NamaMenu`=?,`HargaMenu`=?,`StokMenu`=? WHERE KodeMenu = ?");
					JOptionPane.showMessageDialog(null, "Input Tidak Valid!");
					if (harga > 0 && stok > 0) {
						query.setString(1, nama);
						query.setInt(2, harga);
						query.setInt(3, stok);
						query.setString(4, kode);
						query.executeUpdate();
					}
				}
			} catch (Exception er) {
				tfSearchMenu.setText("");
				tfNamaMenu.setText("");
				tfHargaMenu.setText("");
				tfStokMenu.setText("");
				tfHargaMenu.setEnabled(false);
				tfHargaMenu.setEditable(false);
				tfStokMenu.setEnabled(false);
				tfStokMenu.setEditable(false);
				JOptionPane.showMessageDialog(null, "Menu Gagal Di Update");
			}
		}

		// Delete Button
		if (e.getSource().equals(ButtonDelete) && tblData.getSelectedRow() < 0) {
			JOptionPane.showMessageDialog(null, "harap pilih data yang ingin di hapus!");
		}
		if (e.getSource().equals(ButtonDelete)) {
			int row = tblData.getSelectedRow();
			String idDel = tblData.getValueAt(row, 0).toString();
			String query = "DELETE FROM datamenupudding WHERE KodeMenu = '" + idDel + "'";
			try {
				kd.queryDel(query);
				generateTable();
				JOptionPane.showMessageDialog(null, "Berhasil Hapus Data Dengan Kode Menu " + idDel, null,
						JOptionPane.INFORMATION_MESSAGE, succes);

			} catch (Exception es) {
				JOptionPane.showMessageDialog(null, "Menu Gagal Di Hapus", null, JOptionPane.ERROR_MESSAGE);
			}
		}

		// Back Button
		if (e.getSource() == (ButtonBack)) {
			tfNamaMenu.setText("");
			tfHargaMenu.setText("");
			tfStokMenu.setText("");
			InsertFrame.setVisible(false);
			ViewFrame.setVisible(false);
			UpdateFrame.setVisible(false);
			DeleteFrame.setVisible(false);
			MainFrame.setVisible(true);
		}
	}

	// validasi angka
	public void validasiangkaharga() {
		tfHargaMenu.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '\b') {
					tfHargaMenu.setEditable(true);
				} else {
					tfHargaMenu.setEditable(false);
					JOptionPane.showMessageDialog(null, "input harga dengan angka!", "Message",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}

	public void validasiangkastok() {
		tfStokMenu.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '\b') {
					tfStokMenu.setEditable(true);
				} else {
					tfStokMenu.setEditable(false);
					JOptionPane.showMessageDialog(null, "input stok dengan angka!", "Message",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
}
