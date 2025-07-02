package bdbt_project.SpringApplication.classes;

public class Stacje {
    public Stacje() {
    }

    private int ID_Stacji;

    private int ID_stacji;
    private String Adres;
    private int Ilosc_pracownikow;
    private String Rodzaj_stacji;
    private Short Czestotliwosc;

    public int getID_stacji() {
        return ID_stacji;
    }

    public void setID_stacji(int ID_stacji) {
        this.ID_stacji = ID_stacji;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String Adres) {
        this.Adres = Adres;
    }

    public int getIlosc_pracownikow() {
        return Ilosc_pracownikow;
    }

    public void setIlosc_pracownikow(int Ilosc_pracownikow) {
        this.Ilosc_pracownikow = Ilosc_pracownikow;
    }

    public String getRodzaj_stacji() {
        return Rodzaj_stacji;
    }

    public void setRodzaj_stacji(String Rodzaj_stacji) {
        this.Rodzaj_stacji = Rodzaj_stacji;
    }

    public Short getCzestotliwosc() {
        return Czestotliwosc;
    }

    public void setCzestotliwosc(Short Czestotliwosc) {
        this.Czestotliwosc = Czestotliwosc;
    }

    @Override
    public String toString() {
        return "Stacje{" +
                "ID_stacji=" + ID_stacji +
                ", Adres='" + Adres + '\'' +
                ", Ilosc_pracownikow=" + Ilosc_pracownikow +
                ", Rodzaj_stacji=" + Rodzaj_stacji +
                ", Czestotliwosc=" + Czestotliwosc +
                '}';
    }

    public Stacje(int ID_stacji, String Adres, int Ilosc_pracownikow, String Rodzaj_stacji, Short Czestotliwosc) {
        super();
        this.ID_stacji = ID_stacji;
        this.Adres = Adres;
        this.Ilosc_pracownikow = Ilosc_pracownikow;
        this.Rodzaj_stacji = Rodzaj_stacji;
        this.Czestotliwosc = Czestotliwosc;
    }
}

