package restauran;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Makanan extends Menu{
    private StringProperty namaMakanan;

    public Makanan(String jenisPesanan, int jumlahPesanan, String namaPemesan, int hargaPesanan, String namaMakanan) {
        super(jenisPesanan, jumlahPesanan, namaPemesan, hargaPesanan);
        this.namaMakanan = new SimpleStringProperty(namaMakanan);
    }

    public String getNamaMakanan() {
        return namaMakanan.get();
    }

    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan.set(namaMakanan);
    }

    public StringProperty namaMakananProperty() {
        return namaMakanan;
    }

    public void cetakPesanan(){
        System.out.println("Jenis Pesanan : "+getJenisPesanan());
        System.out.println("Nama Makanan  : "+getNamaMakanan());
        System.out.println("Jumlah Pesanan : "+getJumlahPesanan());
    }
}
