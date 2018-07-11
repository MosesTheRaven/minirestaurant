package main.domain;

public class Objednavka {

    Stol stol;
    int idObjednavky = -1;
    int idPolozky;
    StavPolozky stav;

    // tento int by sa dal vyuzit pri roznasani objednavok
    int cas;
    // na vypocet ceny objednavky
    int cena;


    public Objednavka(int idStola, int idPolozky){
        this.setStol(new Stol(idStola));
        this.setIdPolozky(idPolozky);
    }
    public Stol getStol() {
        return stol;
    }

    public void setStol(Stol stol) {
        this.stol = stol;
    }

    public int getIdObjednavky() {
        return idObjednavky;
    }

    public void setIdObjednavky(int idObjednavky) {
        this.idObjednavky = idObjednavky;
    }

    public int getIdPolozky() {
        return idPolozky;
    }

    public void setIdPolozky(int idPolozky) {
        this.idPolozky = idPolozky;
    }

    public StavPolozky getStav() {
        return stav;
    }

    public void setStav(StavPolozky stav) {
        this.stav = stav;
    }

    public int getCas() {
        return cas;
    }

    public void setCas(int cas) {
        this.cas = cas;
    }
}
