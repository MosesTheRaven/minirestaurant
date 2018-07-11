package main.domain;

import java.util.LinkedList;
import java.util.List;

public class Stol {

    public int idStola;

    List<Objednavka> objednavky = new LinkedList<Objednavka>();

    public Stol(int idStola){
        this.setIdStola(idStola);
    }

    public int getIdStola() {
        return idStola;
    }

    public void setIdStola(int idStola) {
        this.idStola = idStola;
    }

    public List<Objednavka> getObjednavky() {
        return objednavky;
    }

    public void setObjednavky(List<Objednavka> objednavky) {
        this.objednavky = objednavky;
    }
}
