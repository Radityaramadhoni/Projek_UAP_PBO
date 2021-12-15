package restauran;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pesanan {
    private IntegerProperty idPesanan;
    private StringProperty pemesan;
    private StringProperty pesanan;
    private IntegerProperty jumlahPesanan;
    private IntegerProperty hargaSatuan;
    private IntegerProperty totalPembayaran;

    public Pesanan(int idPesanan, String pemesan, String pesanan, int jumlahPesanan, int hargaSatuan, int totalPembayaran) {
        this.idPesanan = new SimpleIntegerProperty(idPesanan);
        this.pemesan = new SimpleStringProperty(pemesan);
        this.pesanan = new SimpleStringProperty(pesanan);
        this.jumlahPesanan = new SimpleIntegerProperty(jumlahPesanan);
        this.hargaSatuan = new SimpleIntegerProperty(hargaSatuan);
        this.totalPembayaran = new SimpleIntegerProperty(totalPembayaran);
    }

    public String getPemesan() {
        return pemesan.get();
    }

    public StringProperty pemesanProperty() {
        return pemesan;
    }

    public void setPemesan(String pemesan) {
        this.pemesan.set(pemesan);
    }

    public String getPesanan() {
        return pesanan.get();
    }

    public StringProperty pesananProperty() {
        return pesanan;
    }

    public void setPesanan(String pesanan) {
        this.pesanan.set(pesanan);
    }

    public int getJumlahPesanan() {
        return jumlahPesanan.get();
    }

    public IntegerProperty jumlahPesananProperty() {
        return jumlahPesanan;
    }

    public void setJumlahPesanan(int jumlahPesanan) {
        this.jumlahPesanan.set(jumlahPesanan);
    }

    public int getHargaSatuan() {
        return hargaSatuan.get();
    }

    public IntegerProperty hargaSatuanProperty() {
        return hargaSatuan;
    }

    public void setHargaSatuan(int hargaSatuan) {
        this.hargaSatuan.set(hargaSatuan);
    }

    public int getTotalPembayaran() {
        return totalPembayaran.get();
    }

    public IntegerProperty totalPembayaranProperty() {
        return totalPembayaran;
    }

    public void setTotalPembayaran(int totalPembayaran) {
        this.totalPembayaran.set(totalPembayaran);
    }
}
