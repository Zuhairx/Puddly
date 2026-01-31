package PTPudding.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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

public class ViewDataView {
    private JFrame frame;
    private JTable table;
    private JButton btnBack;
    private JLabel labelViewMenu;
    private JScrollPane scrollPane;
    private JTextField tfId;
    private PTPudding.controller.ViewController controller;

    public ViewDataView() {
        initializeComponents();
    }

    private void initializeComponents() {

        frame = new JFrame("view data");
        frame.getContentPane().setBackground(new Color(0xdec731));
        frame.setLayout(null);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ImageIcon icon = new ImageIcon("image/icon.png");
        Image iconImg = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        frame.setIconImage(iconImg);

        table = new JTable();
        table.setDefaultEditor(Object.class, null);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 80, 400, 287);
        scrollPane.setViewportView(table);

        labelViewMenu = new JLabel("View Menu");
        labelViewMenu.setHorizontalAlignment(SwingConstants.CENTER);
        labelViewMenu.setFont(new Font("Open Sans", Font.BOLD, 21));
        labelViewMenu.setForeground(Color.WHITE);
        labelViewMenu.setBounds(165, 11, 260, 27);

        tfId = new JTextField();
        tfId.setToolTipText("Search by ID");
        tfId.setText("Search by ID...");
        tfId.setBounds(100, 49, 100, 20);
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

        btnBack = new JButton("Back To Main Menu");
        btnBack.setBackground(new Color(0x82807f));
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(145, 380, 300, 50);

        frame.add(scrollPane);
        frame.add(labelViewMenu);
        frame.add(tfId);
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

    public JButton getBtnBack() {
        return btnBack;
    }

    public JTable getTable() {
        return table;
    }

    public void setTableModel(javax.swing.table.DefaultTableModel model) {
        table.setModel(model);
    }

    public void setController(PTPudding.controller.ViewController controller) {
        this.controller = controller;
    }
}
