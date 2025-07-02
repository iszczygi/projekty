package bdbt_project.SpringApplication.classes;

public class Pracownicy {
    public Pracownicy() {
    }

    private int ID_pracownika;
    private String Imie;
    private String Drugie_imie;
    private String nazwisko;
    private String Adres;
    private String Data_urodzin;
    private float Zarobki;
    private String PESEL;
    private String Data_zatrudnienia;
    private String Stanowisko;
    private String Znajomosc_jezyka;

    public Pracownicy(int ID_pracownika, String Imie, String Drugie_imie, String Nazwisko, String Adres, String Data_urodzin,
                      float Zarobki, String PESEL, String Data_zatrudnienia, String Stanowisko, String Znajomosc_jezyka) {
        this.ID_pracownika = ID_pracownika;
        this.Imie = Imie;
        this.Drugie_imie = Drugie_imie;
        this.nazwisko = Nazwisko;
        this.Adres = Adres;
        this.Data_urodzin = Data_urodzin;
        this.Zarobki = Zarobki;
        this.PESEL = PESEL;
        this.Data_zatrudnienia = Data_zatrudnienia;
        this.Stanowisko = Stanowisko;
        this.Znajomosc_jezyka = Znajomosc_jezyka;
    }

    public int getID_pracownika() {
        return ID_pracownika;
    }

    public void setID_pracownika(int ID_pracownika) {
        this.ID_pracownika = ID_pracownika;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        this.Imie = imie;
    }

    public String getDrugie_imie() {
        return Drugie_imie;
    }

    public void setDrugie_imie(String drugie_imie) {
        this.Drugie_imie = drugie_imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String adres) {
        this.Adres = adres;
    }

    public String getData_urodzin() {
        return Data_urodzin;
    }

    public void setData_urodzin(String data_urodzin) {
        this.Data_urodzin = data_urodzin;
    }

    public float getZarobki() {
        return Zarobki;
    }

    public void setZarobki(float zarobki) {
        this.Zarobki = zarobki;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getData_zatrudnienia() {
        return Data_zatrudnienia;
    }

    public void setData_zatrudnienia(String Data_zatrudnienia) {
        this.Data_zatrudnienia = Data_zatrudnienia;
    }

    public String getStanowisko() {
        return Stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.Stanowisko = stanowisko;
    }

    public String getZnajomosc_jezyka() {
        return Znajomosc_jezyka;
    }

    public void setZnajomosc_jezyka(String Znajomosc_jezyka) {
        this.Znajomosc_jezyka = Znajomosc_jezyka;
    }

    @Override
    public String toString() {
        return "Pracownicy{" +
                "ID_pracownika=" + ID_pracownika +
                ", Imie='" + Imie + '\'' +
                ", Drugie_imie='" + Drugie_imie + '\'' +
                ", Nazwisko='" + nazwisko + '\'' +
                ", Adres='" + Adres + '\'' +
                ", Data_urodzin='" + Data_urodzin + '\'' +
                ", Zarobki=" + Zarobki +
                ", PESEL='" + PESEL + '\'' +
                ", Data_zatrudnienia='" + Data_zatrudnienia + '\'' +
                ", Stanowisko='" + Stanowisko + '\'' +
                ", ZnajomoscJezyka='" + Znajomosc_jezyka + '\'' +
                '}';
    }
}
