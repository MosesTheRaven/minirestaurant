package main.dto;

import main.domain.StavPolozky;

public class ObjednavkaStola {

    private int idObjednavky;
    private int idPolozky;
    private StavPolozky stav;

    public ObjednavkaStola(int idObjednavky, int idPolozky, StavPolozky stav){
        this.idObjednavky = idObjednavky;
        this.idPolozky = idPolozky;
        this.stav = stav;
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
}
