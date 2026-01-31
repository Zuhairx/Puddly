package PTPudding.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InsertView {
    private JFrame frame;
    private JTextField tfNama, tfHarga, tfStok;
    private JButton btnInsert, btnBack;
    private JLabel labelInsertMenu, labelNamaMenu, labelHargaMenu, labelStokMenu;

    public InsertView() {
        initializeComponents();
    }

    private void initializeComponents() {
        frame = new JFrame("Menu Insert");
        frame.getContentPane().setBackground(new Color(0x007198));
        frame.setLayout(null);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        labelInsertMenu = new JLabel("Insert Data");
        labelInsertMenu.setHorizontalAlignment(SwingConstants.CENTER);
        labelInsertMenu.setFont(new Font("Open Sans", Font.BOLD, 21));
        labelInsertMenu.setForeground(Color.WHITE);
        labelInsertMenu.setBounds(160, 11, 260, 27);

        labelNamaMenu = new JLabel("Nama Pudding");
        labelNamaMenu.setFont(new Font("", Font.PLAIN, 17));
        labelNamaMenu.setBounds(149, 67, 116, 27);
        labelNamaMenu.setForeground(Color.WHITE);

        labelHargaMenu = new JLabel("Harga");
        labelHargaMenu.setFont(new Font("Open Sans", Font.PLAIN, 17));
        labelHargaMenu.setBounds(150, 149, 102, 30);
        labelHargaMenu.setForeground(Color.WHITE);

        labelStokMenu = new JLabel("Stok");
        labelStokMenu.setFont(new Font("Open Sans", Font.PLAIN, 17));
        labelStokMenu.setBounds(150, 230, 102, 30);
        labelStokMenu.setForeground(Color.WHITE);

        tfNama = new JTextField();
        tfNama.setToolTipText("Input Nama");
        tfNama.setBounds(150, 98, 277, 34);
        tfNama.setColumns(10);
        tfNama.setEnabled(true);
        tfNama.setEditable(true);

        tfHarga = new JTextField();
        tfHarga.setToolTipText("Input Harga");
        tfHarga.setColumns(10);
        tfHarga.setBounds(150, 179, 277, 34);
        tfHarga.setEnabled(true);
        tfHarga.setEditable(true);
        tfHarga.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume();
                }
            }
        });

        tfStok = new JTextField();
        tfStok.setToolTipText("input Stok");
        tfStok.setColumns(10);
        tfStok.setBounds(150, 263, 277, 34);
        tfStok.setEnabled(true);
        tfStok.setEditable(true);
        tfStok.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume();
                }
            }
        });

        btnInsert = new JButton("Insert");
        btnInsert.setBackground(new Color(0x35cade));
        btnInsert.setForeground(Color.WHITE);
        btnInsert.setBounds(150, 320, 127, 34);

        btnBack = new JButton("Back");
        btnBack.setBackground(new Color(0x82807f));
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(300, 320, 127, 34);

        frame.add(labelInsertMenu);
        frame.add(labelNamaMenu);
        frame.add(labelHargaMenu);
        frame.add(labelStokMenu);
        frame.add(tfNama);
        frame.add(tfHarga);
        frame.add(tfStok);
        frame.add(btnInsert);
        frame.add(btnBack);

        frame.setResizable(false);
    }

    public void show() {
        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }

    public void hide() {
        frame.setVisible(false);
    }

    public JButton getBtnInsert() {
        return btnInsert;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public String getNama() {
        return tfNama.getText();
    }

    public String getHarga() {
        return tfHarga.getText();
    }

    public String getStok() {
        return tfStok.getText();
    }

    public JTextField getTfHarga() {
        return tfHarga;
    }

    public JTextField getTfStok() {
        return tfStok;
    }
}