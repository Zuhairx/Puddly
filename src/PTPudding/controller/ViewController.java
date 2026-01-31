package PTPudding.controller;

import PTPudding.model.Pudding;
import PTPudding.model.PuddingDAO;
import PTPudding.view.ViewDataView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewController implements ActionListener {
    private ViewDataView view;
    private PuddingDAO dao;

    public ViewController(ViewDataView view) {
        this.view = view;
        this.dao = new PuddingDAO();
        view.setController(this);
        view.getBtnBack().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getBtnBack()) {
            view.hide();
        }
    }

    private void loadTable() {
        loadTable(null);
    }

    private void loadTable(String filter) {
        try {
            List<Pudding> puddings = dao.getAllPudding();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nama");
            model.addColumn("Harga");
            model.addColumn("Stok");
            for (Pudding p : puddings) {
                if (filter == null || filter.isEmpty() || p.getId().equalsIgnoreCase(filter)) {
                    String[] row = { p.getId(), p.getNama(), String.valueOf(p.getHarga()), String.valueOf(p.getStok()) };
                    model.addRow(row);
                }
            }
            view.setTableModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view.getTable(), "Error loading data: " + ex.getMessage());

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nama");
            model.addColumn("Harga");
            model.addColumn("Stok");
            view.setTableModel(model);
        }
    }

    public void filterTable(String filter) {
        loadTable(filter);
    }

    public void showView() {
        loadTable();
        view.show();
    }
}
