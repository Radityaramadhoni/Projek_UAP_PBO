package restauran;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
//Abstract class
public abstract class Menu {
    protected StringProperty jenisPesanan;
    protected IntegerProperty jumlahPesanan;
    protected StringProperty namaPemesan;
    protected IntegerProperty hargaPesanan;

    public Menu(String jenisPesanan, int jumlahPesanan, String namaPemesan, int hargaPesanan) {
        this.jenisPesanan = new SimpleStringProperty(jenisPesanan);
        this.jumlahPesanan = new SimpleIntegerProperty(jumlahPesanan);
        this.namaPemesan = new SimpleStringProperty(namaPemesan);
        this.hargaPesanan = new SimpleIntegerProperty(hargaPesanan);
    }

    public String getJenisPesanan() {
        return jenisPesanan.get();
    }

    public StringProperty jenisPesananProperty() {
        return jenisPesanan;
    }

    public void setJenisPesanan(String jenisPesanan) {
        this.jenisPesanan.set(jenisPesanan);
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

    public String getNamaPemesan() {
        return namaPemesan.get();
    }

    public int getHargaPesanan() {
        return hargaPesanan.get();
    }

    public IntegerProperty hargaPesananProperty() {
        return hargaPesanan;
    }

    public void setHargaPesanan(int hargaPesanan) {
        this.hargaPesanan.set(hargaPesanan);
    }

    public StringProperty namaPemesanProperty() {
        return namaPemesan;
    }

    public void setNamaPemesan(String namaPemesan) {
        this.namaPemesan.set(namaPemesan);
    }

    public abstract void cetakPesanan();
}
