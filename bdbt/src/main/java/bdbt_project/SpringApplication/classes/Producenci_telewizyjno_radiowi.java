package bdbt_project.SpringApplication.classes;

public class Producenci_telewizyjno_radiowi {
    public Producenci_telewizyjno_radiowi() {
    }

    private int ID_producenta;
    private String Nazwa;
    private String Data_zalozenia;
    private int NIP;
    private int KRS;

    public int getID_producenta() {
        return ID_producenta;
    }

    @Override
    public String toString() {
        return "Producenci_telewizyjno_radiowi{" +
                "ID_producenta=" + ID_producenta +
                ", Nazwa='" + Nazwa + '\'' +
                ", Data_zalozenia='" + Data_zalozenia + '\'' +
                ", NIP=" + NIP +
                ", KRS=" + KRS +
                '}';
    }

    public void setID_producenta(int ID_producenta) {
        this.ID_producenta = ID_producenta;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String Nazwa) {
        this.Nazwa = Nazwa;
    }

    public String getData_zalozenia() {
        return Data_zalozenia;
    }

    public void setData_zalozenia(String Data_zalozenia) {
        this.Data_zalozenia = Data_zalozenia;
    }

    public int getNIP() {
        return NIP;
    }

    public void setNIP(int NIP) {
        this.NIP = NIP;
    }

    public int getKRS() {
        return KRS;
    }

    public void setKRS(int KRS) {
        this.KRS = KRS;
    }

    public Producenci_telewizyjno_radiowi(int ID_producenta, String Nazwa, String Data_zalozenia, int NIP, int KRS) {
        super();
        this.ID_producenta = ID_producenta;
        this.Nazwa = Nazwa;
        this.Data_zalozenia = Data_zalozenia;
        this.NIP = NIP;
        this.KRS = KRS;
    }
}
