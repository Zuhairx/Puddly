package PTPudding.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class DeleteView {
    private JFrame frame;
    private JTable table;
    private JButton btnDelete, btnBack;
    private JLabel labelViewMenu;
    private JScrollPane scrollPane;

    public DeleteView() {
        initializeComponents();
    }

    private void initializeComponents() {
        frame = new JFrame("Delete data");
        frame.getContentPane().setBackground(new Color(0xba7575));
        frame.setLayout(null);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(80, 70, 400, 287);
        scrollPane.setViewportView(table);

        labelViewMenu = new JLabel("Delete Menu");
        labelViewMenu.setHorizontalAlignment(SwingConstants.CENTER);
        labelViewMenu.setFont(new Font("Open Sans", Font.BOLD, 21));
        labelViewMenu.setForeground(Color.WHITE);
        labelViewMenu.setBounds(160, 11, 260, 27);

        btnDelete = new JButton("Delete");
        btnDelete.setBackground(new Color(0xe95953));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setBounds(150, 380, 127, 34);

        btnBack = new JButton("Back");
        btnBack.setBackground(new Color(0x82807f));
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(300, 380, 127, 34);

        frame.add(btnDelete);
        frame.add(btnBack);
        frame.add(scrollPane);
        frame.add(labelViewMenu);

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

    public JButton getBtnDelete() {
        return btnDelete;
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
}