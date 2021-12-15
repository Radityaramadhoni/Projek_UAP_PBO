package restauran;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Minuman extends Menu{
    private StringProperty namaMinuman;


    public Minuman(String jenisPesanan, int jumlahPesanan, String namaPemesan, int hargaPesanan, String namaMinuman) {
        super(jenisPesanan, jumlahPesanan, namaPemesan, hargaPesanan);
        this.namaMinuman = new SimpleStringProperty(namaMinuman);
    }

    public String getNamaMinuman() {
        return namaMinuman.get();
    }

    public StringProperty namaMinumanProperty() {
        return namaMinuman;
    }

    public void setNamaMinuman(String namaMinuman) {
        this.namaMinuman.set(namaMinuman);
    }
    public void cetakPesanan(){
        System.out.println("Jenis Pesanan : "+getJenisPesanan());
        System.out.println("Nama Minuman : "+getNamaMinuman());
        System.out.println("Jumlah Pesanan : "+getJumlahPesanan());
    }
}
