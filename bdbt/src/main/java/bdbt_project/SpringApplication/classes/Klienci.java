package bdbt_project.SpringApplication.classes;

public class Klienci {
    public Klienci() {
    }

    private int ID_klienta;
    private String Nazwa;
    private float Wycena_umowy;
    private int Liczba_reklam;
    private String Data_zawarcia;
    private String Data_zakonczenia;
    private String Nr_telefonu;
    private String NIP;
    private String Adres_email;

    public Klienci(
            int ID_klienta,
            String Nazwa,
            float Wycena_umowy,
            int Liczba_reklam,
            String DataZawarcia,
            String DataZakonczenia,
            String Nr_telefonu,
            String NIP,
            String Adres_email)
    {
        this.ID_klienta = ID_klienta;
        this.Nazwa = Nazwa;
        this.Wycena_umowy = Wycena_umowy;
        this.Liczba_reklam = Liczba_reklam;
        this.Data_zawarcia = DataZawarcia;
        this.Data_zakonczenia = DataZakonczenia;
        this.Nr_telefonu = Nr_telefonu;
        this.NIP = NIP;
        this.Adres_email = Adres_email;
    }

    public int getID_klienta() {
        return ID_klienta;
    }

    public void setID_klienta(int ID_klienta) {
        this.ID_klienta = ID_klienta;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String Nazwa) {
        this.Nazwa = Nazwa;
    }

    public float getWycena_umowy() {
        return Wycena_umowy;
    }

    public void setWycena_umowy(float WycenaUmowy) {
        this.Wycena_umowy = WycenaUmowy;
    }

    public int getLiczba_reklam() {
        return Liczba_reklam;
    }

    public void setLiczba_reklam(int LiczbaReklam) {
        this.Liczba_reklam = LiczbaReklam;
    }

    public String getData_zawarcia() {
        return Data_zawarcia;
    }

    public void setData_zawarcia(String DataZawarcia) {
        this.Data_zawarcia = DataZawarcia;
    }

    public String getData_zakonczenia() {
        return Data_zakonczenia;
    }

    public void setData_zakonczenia(String DataZakonczenia) {
        this.Data_zakonczenia = DataZakonczenia;
    }

    public String getNr_telefonu() {
        return Nr_telefonu;
    }

    public void setNr_telefonu(String NrTelefonu) {
        this.Nr_telefonu = NrTelefonu;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getAdres_email() {
        return Adres_email;
    }

    public void setAdres_email(String AdresEmail) {
        this.Adres_email = AdresEmail;
    }

    @Override
    public String toString() {
        return "Klienci{" +
                "ID_klienta=" + ID_klienta +
                ", Nazwa='" + Nazwa + '\'' +
                ", Wycena_umowy=" + Wycena_umowy +
                ", Liczba_reklam=" + Liczba_reklam +
                ", Data_zawarcia='" + Data_zawarcia + '\'' +
                ", Data_zakonczenia='" + Data_zakonczenia + '\'' +
                ", Nr_telefonu='" + Nr_telefonu + '\'' +
                ", NIP='" + NIP + '\'' +
                ", Adres_email='" + Adres_email + '\'' +
                '}';
    }
}
