package bdbt_project.SpringApplication.classes;

public class Reklamy {
    public Reklamy() {
    }

    private int ID_reklamy;
    private String Czas_trwania;
    private String Kanal_dystrybucji;
    private String Grupa_docelowa;

    public Reklamy(
            int ID_reklamy,
            String Czas_trwania,
            String Kanal_dystrybucji,
            String Grupa_docelowa)
    {
        this.ID_reklamy = ID_reklamy;
        this.Czas_trwania = Czas_trwania;
        this.Kanal_dystrybucji = Kanal_dystrybucji;
        this.Grupa_docelowa = Grupa_docelowa;
    }

    public int getID_reklamy() {
        return ID_reklamy;
    }

    public void setID_reklamy(int ID_reklamy) {
        this.ID_reklamy = ID_reklamy;
    }

    public String getCzas_trwania() {
        return Czas_trwania;
    }

    public void setCzas_trwania(String Czas_trwania) {
        this.Czas_trwania = Czas_trwania;
    }

    public String getKanal_dystrybucji() {
        return Kanal_dystrybucji;
    }

    public void setKanal_dystrybucji(String Kanał_dystrybucji) {
        this.Kanal_dystrybucji = Kanał_dystrybucji;
    }

    public String getGrupa_docelowa() {
        return Grupa_docelowa;
    }

    public void setGrupa_docelowa(String Grupa_docelowa) {
        this.Grupa_docelowa = Grupa_docelowa;
    }

    @Override
    public String toString() {
        return "Reklamy{" +
                "ID_reklamy=" + ID_reklamy +
                ", Czas_trwania='" + Czas_trwania + '\'' +
                ", Kanał_dystrybucji='" + Kanal_dystrybucji + '\'' +
                ", Grupa_docelowa='" + Grupa_docelowa + '\'' +
                '}';
    }
}
