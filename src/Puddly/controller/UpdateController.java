package Puddly.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Puddly.model.Pudding;
import Puddly.model.PuddingDAO;
import Puddly.view.UpdateView;

public class UpdateController implements ActionListener {
    private UpdateView view;
    private PuddingDAO dao;

    public UpdateController(UpdateView view) {
        this.view = view;
        this.dao = new PuddingDAO();
        view.setController(this);
        view.getBtnUpdate().addActionListener(this);
        view.getBtnBack().addActionListener(this);
        view.getTable().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = view.getTable().getSelectedRow();
                if (selectedRow != -1) {
                    String nama = (String) view.getTable().getValueAt(selectedRow, 1);
                    String harga = String.valueOf(view.getTable().getValueAt(selectedRow, 2));
                    String stok = String.valueOf(view.getTable().getValueAt(selectedRow, 3));
                    view.getTfNama().setText(nama);
                    view.getTfNama().setEditable(true);
                    view.getTfHarga().setText(harga);
                    view.getTfHarga().setEditable(true);
                    view.getTfStok().setText(stok);
                    view.getTfStok().setEditable(true);
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getBtnUpdate()) {
            updatePudding();
        } else if (e.getSource() == view.getBtnBack()) {
            view.hide();
        }
    }

    private void updatePudding() {
        try {
            int selectedRow = view.getTable().getSelectedRow();
            if (selectedRow == -1) {
                javax.swing.JOptionPane.showMessageDialog(null, "Pilih data dari tabel terlebih dahulu!");
                return;
            }
            String kode = (String) view.getTable().getValueAt(selectedRow, 0);
            String nama = view.getNama();
            int harga = Integer.parseInt(view.getHarga());
            int stok = Integer.parseInt(view.getStok());
            if (nama.length() > 0 && harga > 0 && stok > 0) {
                dao.updatePudding(kode, nama, harga, stok);
                loadTable();
                javax.swing.JOptionPane.showMessageDialog(null, "Data Dengan Kode Menu " + kode + " Berhasil Diupdate",
                        null,
                        javax.swing.JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("Image/success.png"));
                view.clearFields();
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Input Tidak Valid!");
            }
        } catch (Exception er) {
            javax.swing.JOptionPane.showMessageDialog(null, "Menu Gagal Di Update");
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
                if (filter == null || filter.isEmpty() || p.getId().toLowerCase().contains(filter.toLowerCase())) {
                    model.addRow(new Object[] { p.getId(), p.getNama(), p.getHarga(), p.getStok() });
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