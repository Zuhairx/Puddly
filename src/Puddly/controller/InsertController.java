package Puddly.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Puddly.model.PuddingDAO;
import Puddly.view.InsertView;

public class InsertController implements ActionListener {
    private InsertView view;
    private PuddingDAO dao;

    public InsertController(InsertView view) {
        this.view = view;
        this.dao = new PuddingDAO();
        view.getBtnInsert().addActionListener(this);
        view.getBtnBack().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getBtnInsert()) {
            insertPudding();
        } else if (e.getSource() == view.getBtnBack()) {
            view.hide();
        }
    }

    private void insertPudding() {
        String namacheck = view.getNama();
        String hargacheck = view.getHarga();
        String stokcek = view.getStok();
        if (namacheck.isBlank() || hargacheck.isBlank() || stokcek.isBlank()) {
            javax.swing.JOptionPane.showMessageDialog(null, "Input tidak boleh kosong!", "Message",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            String nama = view.getNama();
            int harga = Integer.parseInt(view.getHarga());
            int stok = Integer.parseInt(view.getStok());

            if (nama.length() > 0 && harga > 0 && stok > 0) {
                java.util.Random random = new java.util.Random();
                String kode = "PD-" + (random.nextInt(900) + 100);
                dao.insertPudding(kode, nama, harga, stok);
                javax.swing.JOptionPane.showMessageDialog(null, "Menu Berhasil Ditambahkan Dengan Kode Menu " + kode,
                        null,
                        javax.swing.JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("Image/success.png"));
            }
            if (nama.length() <= 0 || harga <= 0 || stok <= 0) {
                javax.swing.JOptionPane.showMessageDialog(null, "Input tidak boleh kosong!", "Message",
                        javax.swing.JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e1) {
            javax.swing.JOptionPane.showMessageDialog(null, "Menu gagal ditambahkan", "Message",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showView() {
        view.show();
    }
}