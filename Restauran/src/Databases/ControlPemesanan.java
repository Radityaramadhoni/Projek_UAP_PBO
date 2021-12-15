package Databases;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import restauran.Makanan;
import restauran.Minuman;
import restauran.Pesanan;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControlPemesanan {
    public final Connection connection;

    public ControlPemesanan() {
        this.connection = DBkoneksi.getKoneksi();
    }

    public Connection getConnection() {
        return connection;
    }

    public void tambahPesanan(Makanan makanan){
        try {
            String sql = "INSERT INTO pesananan(nama_pemesan, nama_pesanan, jumlah_pesanan, harga_pesanan, total_bayar) VALUE('%s','%s',%d,%d,%d)";
            sql = String.format(sql,
                    makanan.getNamaPemesan(),
                    makanan.getNamaMakanan(),
                    makanan.getJumlahPesanan(),
                    makanan.getHargaPesanan(),
                    (makanan.getJumlahPesanan() * makanan.getHargaPesanan())
            );

            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
            JOptionPane.showMessageDialog(null,"Berhasil Menambah Data");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Menambah Data");
            System.out.println(e);
        }
    }

    public void tambahPesanan(Minuman minuman){
        try {
            String sql = "INSERT INTO pesananan(nama_pemesan, nama_pesanan, jumlah_pesanan, harga_pesanan, total_bayar) VALUE('%s','%s',%d,%d,%d)";
            sql = String.format(sql,minuman.getNamaPemesan(),minuman.getNamaMinuman(),
                    minuman.getJumlahPesanan(),
                    minuman.getHargaPesanan(),
                    (minuman.getJumlahPesanan() * minuman.getHargaPesanan()));
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
            JOptionPane.showMessageDialog(null,"Berhasil Menambah Data");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Menambah Data");
            System.out.println(e);
        }
    }
    public ObservableList<Pesanan> showData(){
        ObservableList<Pesanan>pesanans = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM pesananan";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                pesanans.add(new Pesanan(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6)
                ));
            }
        }catch (SQLException e){
            System.out.println(e);
            return null;
        }
        return pesanans;
    }
}
