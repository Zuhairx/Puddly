package PTPudding.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UpdateView {
    private JFrame frame;
    private JTable table;
    private JTextField tfId, tfNama, tfHarga, tfStok;
    private JButton btnUpdate, btnBack;
    private JLabel labelUpdateMenu, labelsearchID, labelNamaMenu, labelHargaMenu, labelStokMenu;
    private JScrollPane scrollPane;
    private PTPudding.controller.UpdateController controller;

    public UpdateView() {
        initializeComponents();
    }

    private void initializeComponents() {

        frame = new JFrame("Update data");
        frame.getContentPane().setBackground(new Color(0x7ccc84));
        frame.setLayout(null);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ImageIcon icon = new ImageIcon("image/icon.png");
        Image iconImg = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        frame.setIconImage(iconImg);

        labelUpdateMenu = new JLabel("Update Menu");
        labelUpdateMenu.setHorizontalAlignment(SwingConstants.CENTER);
        labelUpdateMenu.setFont(new Font("Open Sans", Font.BOLD, 21));
        labelUpdateMenu.setForeground(Color.WHITE);
        labelUpdateMenu.setBounds(160, 20, 260, 27);

        labelsearchID = new JLabel("Search ID");
        labelsearchID.setFont(new Font("Open Sans", Font.PLAIN, 14));
        labelsearchID.setBounds(80, 55, 100, 20);
        labelsearchID.setForeground(Color.WHITE);

        labelNamaMenu = new JLabel("Nama Menu");
        labelNamaMenu.setFont(new Font("Open Sans", Font.PLAIN, 14));
        labelNamaMenu.setBounds(80, 105, 100, 20);
        labelNamaMenu.setForeground(Color.WHITE);

        labelHargaMenu = new JLabel("Harga Menu");
        labelHargaMenu.setFont(new Font("Open Sans", Font.PLAIN, 14));
        labelHargaMenu.setBounds(80, 160, 100, 20);
        labelHargaMenu.setForeground(Color.WHITE);

        labelStokMenu = new JLabel("Stok Menu");
        labelStokMenu.setFont(new Font("Open Sans", Font.PLAIN, 14));
        labelStokMenu.setBounds(80, 215, 100, 20);
        labelStokMenu.setForeground(Color.WHITE);

        tfId = new JTextField();
        tfId.setToolTipText("Search by ID");
        tfId.setText("Search by ID...");
        tfId.setBounds(80, 75, 120, 25);
        tfId.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfId.getText().equals("Search by ID...")) {
                    tfId.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfId.getText().isEmpty()) {
                    tfId.setText("Search by ID...");
                }
            }
        });

        tfId.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTable();
            }

            private void filterTable() {
                String text = tfId.getText();
                if (text.equals("Search by ID...") || text.isEmpty()) {
                    controller.filterTable(null);
                } else {
                    controller.filterTable(text);
                }
            }
        });

        tfNama = new JTextField();
        tfNama.setToolTipText("Nama Menu");
        tfNama.setColumns(10);
        tfNama.setBounds(80, 125, 120, 25);

        tfHarga = new JTextField();
        tfHarga.setToolTipText("Harga Menu");
        tfHarga.setColumns(10);
        tfHarga.setBounds(80, 180, 120, 25);
        tfHarga.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume();
                }
            }
        });

        tfStok = new JTextField();
        tfStok.setToolTipText("Stok Menu");
        tfStok.setColumns(10);
        tfStok.setBounds(80, 235, 120, 25);
        tfStok.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume();
                }
            }
        });

        btnUpdate = new JButton("Update");
        btnUpdate.setBackground(new Color(0x538249));
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setBounds(146, 300, 127, 34);

        btnBack = new JButton("Back");
        btnBack.setBackground(new Color(0x82807f));
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(280, 300, 127, 34);

        table = new JTable();
        table.setDefaultEditor(Object.class, null);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(220, 60, 300, 200);
        frame.add(scrollPane);

        frame.add(labelUpdateMenu);
        frame.add(labelsearchID);
        frame.add(labelNamaMenu);
        frame.add(labelHargaMenu);
        frame.add(labelStokMenu);
        frame.add(tfId);
        frame.add(tfNama);
        frame.add(tfHarga);
        frame.add(tfStok);
        frame.add(btnUpdate);
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

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public String getId() {
        return tfId.getText();
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

    public JTable getTable() {
        return table;
    }

    public void setTableModel(javax.swing.table.DefaultTableModel model) {
        table.setModel(model);
    }

    public JTextField getTfNama() {
        return tfNama;
    }

    public JTextField getTfHarga() {
        return tfHarga;
    }

    public JTextField getTfStok() {
        return tfStok;
    }

    public void clearFields() {
        tfId.setText("Search by ID...");
        tfNama.setText("");
        tfHarga.setText("");
        tfStok.setText("");
    }

    public void setController(PTPudding.controller.UpdateController controller) {
        this.controller = controller;
    }
}