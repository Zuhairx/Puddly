package Puddly.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PuddingDAO {
    private KoneksiDatabase kd;

    public PuddingDAO() {
        kd = new KoneksiDatabase();
    }

    public void insertPudding(String kode, String nama, int harga, int stok) throws SQLException {
        try {
            kd.connect();
        } catch (Exception e) {
            throw new SQLException("Database connection failed", e);
        }
        String query = "INSERT INTO Menu (`Kode`,`Nama`,`Harga`,`Stok`) VALUES (?,?,?,?)";
        PreparedStatement ps = kd.conn.prepareStatement(query);
        ps.setString(1, kode);
        ps.setString(2, nama);
        ps.setInt(3, harga);
        ps.setInt(4, stok);
        ps.executeUpdate();
    }

    public java.util.List<Pudding> getAllPudding() throws SQLException {
        try {
            kd.connect();
        } catch (Exception e) {
            throw new SQLException("Database connection failed", e);
        }
        java.util.List<Pudding> puddings = new java.util.ArrayList<>();
        String query = "SELECT * FROM `Menu`";
        ResultSet rs = kd.query(query);
        while (rs.next()) {
            Pudding p = new Pudding();
            p.setId(rs.getString("Kode"));
            p.setNama(rs.getString("Nama"));
            p.setHarga(rs.getInt("Harga"));
            p.setStok(rs.getInt("Stok"));
            puddings.add(p);
        }
        return puddings;
    }

    public Pudding getPuddingById(String kode) throws SQLException {
        try {
            kd.connect();
        } catch (Exception e) {
            throw new SQLException("Database connection failed", e);
        }
        String query = "SELECT * FROM Menu WHERE Kode = ?";
        PreparedStatement ps = kd.conn.prepareStatement(query);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Pudding p = new Pudding();
            p.setId(rs.getString("Kode"));
            p.setNama(rs.getString("Nama"));
            p.setHarga(rs.getInt("Harga"));
            p.setStok(rs.getInt("Stok"));
            return p;
        }
        return null;
    }

    public void updatePudding(String kode, String nama, int harga, int stok) throws SQLException {
        try {
            kd.connect();
        } catch (Exception e) {
            throw new SQLException("Database connection failed", e);
        }
        String query = "UPDATE `Menu` SET `Nama`=?,`Harga`=?,`Stok`=? WHERE Kode = ?";
        PreparedStatement ps = kd.conn.prepareStatement(query);
        ps.setString(1, nama);
        ps.setInt(2, harga);
        ps.setInt(3, stok);
        ps.setString(4, kode);
        ps.executeUpdate();
    }

    public void deletePudding(String kode) throws SQLException {
        try {
            kd.connect();
        } catch (Exception e) {
            throw new SQLException("Database connection failed", e);
        }
        String query = "DELETE FROM Menu WHERE Kode = '" + kode + "'";
        kd.queryDel(query);
    }
}