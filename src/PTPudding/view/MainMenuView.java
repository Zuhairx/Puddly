package PTPudding.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class MainMenuView {
    private JFrame mainFrame;
    private JButton insertButton;
    private JButton viewButton;
    private JButton updateButton;
    private JButton deleteButton;

    public MainMenuView() {
        initializeComponents();
    }

    private void initializeComponents() {
        mainFrame = new JFrame("Puddly");
        ImageIcon logo = new ImageIcon("image/logo.png");
        ImageIcon icon = new ImageIcon("image/icon.png");

        Border b = BorderFactory.createLineBorder(Color.black, 3);

        JLabel labelJudul = new JLabel();
        Image img = logo.getImage();
        Image newimg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon a = new ImageIcon(newimg);
        labelJudul.setIcon(a);
        labelJudul.setHorizontalTextPosition(JLabel.CENTER);
        labelJudul.setVerticalTextPosition(JLabel.BOTTOM);
        labelJudul.setBackground(new Color(0xf5ecd5));
        labelJudul.setOpaque(true);
        labelJudul.setBorder(b);
        labelJudul.setVerticalAlignment(JLabel.CENTER);
        labelJudul.setHorizontalAlignment(JLabel.CENTER);

        insertButton = new JButton();
        viewButton = new JButton();
        updateButton = new JButton();
        deleteButton = new JButton();

        JLabel labelInsert = new JLabel("Insert");
        labelInsert.setFont(new Font("Calibri", Font.BOLD, 30));
        labelInsert.setHorizontalTextPosition(JLabel.CENTER);
        labelInsert.setVerticalTextPosition(JLabel.CENTER);
        labelInsert.setVerticalAlignment(JLabel.CENTER);
        labelInsert.setHorizontalAlignment(JLabel.CENTER);

        JLabel labelView = new JLabel("View");
        labelView.setFont(new Font("Calibri", Font.BOLD, 30));
        labelView.setHorizontalTextPosition(JLabel.CENTER);
        labelView.setVerticalTextPosition(JLabel.CENTER);
        labelView.setVerticalAlignment(JLabel.CENTER);
        labelView.setHorizontalAlignment(JLabel.CENTER);

        JLabel labelUpdate = new JLabel("Update");
        labelUpdate.setFont(new Font("Calibri", Font.BOLD, 30));
        labelUpdate.setHorizontalTextPosition(JLabel.CENTER);
        labelUpdate.setVerticalTextPosition(JLabel.CENTER);
        labelUpdate.setVerticalAlignment(JLabel.CENTER);
        labelUpdate.setHorizontalAlignment(JLabel.CENTER);

        JLabel labelDelete = new JLabel("Delete");
        labelDelete.setFont(new Font("Calibri", Font.BOLD, 30));
        labelDelete.setHorizontalTextPosition(JLabel.CENTER);
        labelDelete.setVerticalTextPosition(JLabel.CENTER);
        labelDelete.setVerticalAlignment(JLabel.CENTER);
        labelDelete.setHorizontalAlignment(JLabel.CENTER);

        insertButton.setBackground(Color.cyan);
        insertButton.setLayout(new BorderLayout());
        insertButton.add(labelInsert);

        viewButton.setBackground(Color.yellow);
        viewButton.setLayout(new BorderLayout());
        viewButton.add(labelView);

        updateButton.setBackground(Color.green);
        updateButton.setLayout(new BorderLayout());
        updateButton.add(labelUpdate);

        deleteButton.setBackground(Color.red);
        deleteButton.setLayout(new BorderLayout());
        deleteButton.add(labelDelete);

        mainFrame.setLayout(new GridLayout(5, 1, 3, 3));
        mainFrame.setSize(800, 800);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image iconImg = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        mainFrame.setIconImage(iconImg);
        mainFrame.getContentPane().setBackground(Color.black);
        mainFrame.add(labelJudul);
        mainFrame.add(insertButton);
        mainFrame.add(viewButton);
        mainFrame.add(updateButton);
        mainFrame.add(deleteButton);
        mainFrame.setResizable(true);
    }

    public void show() {
        mainFrame.setVisible(true);
    }

    public JButton getInsertButton() {
        return insertButton;
    }

    public JButton getViewButton() {
        return viewButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }
}