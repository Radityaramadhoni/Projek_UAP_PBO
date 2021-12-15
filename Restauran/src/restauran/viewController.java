package restauran;

import java.net.URL;
import java.util.ResourceBundle;

import Databases.ControlPemesanan;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import javax.swing.*;


public class viewController implements Initializable {
    @FXML
    private TextField TFpmesan;
    @FXML
    private RadioButton nasiGoreng;
    @FXML
    private RadioButton ramen;
    @FXML
    private RadioButton milkShake;
    @FXML
    private RadioButton tehManis;
    @FXML
    private TableView<Pesanan>tabelPesanan;
    @FXML
    private TableColumn<Pesanan, Integer>COLid;
    @FXML
    private TableColumn<Pesanan, String>COLpemesanan;
    @FXML
    private TableColumn<Pesanan, String>COLpesanan;
    @FXML
    private TableColumn<Pesanan, Integer>COLjumlah;
    @FXML
    private TableColumn<Pesanan, Integer>COLharga;
    @FXML
    private TableColumn<Pesanan, Integer>COLtotal;
    @FXML
    private Spinner<Integer>SjumlahPesanan;
    @FXML
    private Label statusDB;

    @FXML
    public void showDatabase(ActionEvent event){
        ObservableList<Pesanan> pesanans = cp.showData();
        COLpemesanan.setCellValueFactory(new PropertyValueFactory<>("pemesan"));
        COLpesanan.setCellValueFactory(new PropertyValueFactory<>("pesanan"));
        COLjumlah.setCellValueFactory(new PropertyValueFactory<>("jumlahPesanan"));
        COLharga.setCellValueFactory(new PropertyValueFactory<>("hargaSatuan"));
        COLtotal.setCellValueFactory(new PropertyValueFactory<>("totalPembayaran"));
        tabelPesanan.setItems(pesanans);
    }
    private String namaPesanan = null;
    private int harga = 0;
    private int menu = 0;
    @FXML
    public void pemesanan(ActionEvent event){
        if(TFpmesan.getText().trim().equals("") || SjumlahPesanan.getValue() == 0 || menu == 0){
            JOptionPane.showMessageDialog(null,"Isi dengan Lengkap !!!");
        }else{
            if(menu == 1){
                cp.tambahPesanan(new Makanan("Makanan",SjumlahPesanan.getValue(),TFpmesan.getText(),harga,namaPesanan));
                harga = 0;
                namaPesanan = "";
                menu = 0;
            }else{
                cp.tambahPesanan(new Minuman("Minuman",SjumlahPesanan.getValue(),TFpmesan.getText(),harga,namaPesanan));
                harga = 0;
                namaPesanan = "";
                menu = 0;
            }
        }
    }
    @FXML
    public void getMenu(ActionEvent event){
        if(nasiGoreng.isSelected()){
            this.namaPesanan = "Nasi Goreng";
            this.harga = 13000;
            menu = 1;
        }else if(ramen.isSelected()){
            this.namaPesanan = "Ramen";
            this.harga = 17000;
            menu = 1;
        }else if(milkShake.isSelected()){
            this.namaPesanan = "Milk Shake";
            this.harga = 7000;
            menu = 2;
        }else if(tehManis.isSelected()){
            this.namaPesanan = "Teh Manis";
            this.harga = 4000;
            menu = 2;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            cp = new ControlPemesanan();
            SpinnerValueFactory<Integer>jumlah = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100);
            jumlah.setValue(0);
            statusDB.setText(cp.connection == null ? "Tidak Terhubung":"Terhubung ke Database");
            SjumlahPesanan.setValueFactory(jumlah);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    private ControlPemesanan cp;
    
}
