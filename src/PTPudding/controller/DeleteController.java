package PTPudding.controller;

import PTPudding.model.PuddingDAO;
import PTPudding.view.DeleteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import PTPudding.model.Pudding;

public class DeleteController implements ActionListener {
    private DeleteView view;
    private PuddingDAO dao;

    public DeleteController(DeleteView view) {
        this.view = view;
        this.dao = new PuddingDAO();
        view.getBtnDelete().addActionListener(this);
        view.getBtnBack().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getBtnDelete()) {
            deletePudding();
        } else if (e.getSource() == view.getBtnBack()) {
            view.hide();
        }
    }

    private void deletePudding() {
        int row = view.getTable().getSelectedRow();
        if (row >= 0) {
            try {
                String kode = view.getTable().getValueAt(row, 0).toString();
                dao.deletePudding(kode);
                JOptionPane.showMessageDialog(view.getTable(), "Data Dengan Kode Menu " + kode + " Berhasil Dihapus",
                        null,
                        JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("Image/success.png"));
                loadTable();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view.getTable(), "Error deleting data: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(view.getTable(), "Pilih Data Yang Ingin Dihapus!");
        }
    }

    private void loadTable() {
        try {
            List<Pudding> puddings = dao.getAllPudding();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nama");
            model.addColumn("Harga");
            model.addColumn("Stok");
            for (Pudding p : puddings) {
                model.addRow(new Object[] { p.getId(), p.getNama(), p.getHarga(), p.getStok() });
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

    public void showView() {
        loadTable();
        view.show();
    }
}