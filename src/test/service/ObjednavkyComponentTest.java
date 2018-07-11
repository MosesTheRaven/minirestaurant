package test.service;

import main.domain.Objednavka;
import main.domain.StavPolozky;
import main.dto.ObjednavkaStola;
import main.service.ObjednavkyComponent;

import java.util.List;

public class ObjednavkyComponentTest {
    public static void main(String[] args) {

        // testy implementacie CasnikInterface-u


        // test pridavania objednavok
        // objednavkyComponent.dajObjednavkuStola a objednaj
        ObjednavkyComponent objednavkyComponent = new ObjednavkyComponent();
        ObjednavkaStola[] objednavkyStola = objednavkyComponent.dajObjednavkuStola(0);
        objednavkyComponent.objednaj(0,0 );
        assert(objednavkyComponent.dajObjednavkuStola(0).length == objednavkyStola.length + 1);


        // test mazania
        // rucne nastavim id objednavky
        Objednavka deleteMeObjednavka = new Objednavka(1, 1);
        deleteMeObjednavka.setIdObjednavky(666);
        // pridam ju k ostatnym objednavkam
        objednavkyComponent.addObjednavka(deleteMeObjednavka);
        List<Objednavka> deleteObjednavky = objednavkyComponent.getObjednavky();
        // mazem objednavku s konkretnym id
        objednavkyComponent.zmazObjednavku(666);
        assert(objednavkyComponent.getObjednavky().size() == deleteObjednavky.size());


        // test implementacie KuchynaInterface-u
        // test pripravene
        Objednavka pripraveneObjednavka = new Objednavka(0, 2);
        pripraveneObjednavka.setStav(StavPolozky.OBJEDNANA);
        objednavkyComponent.addObjednavka(pripraveneObjednavka);
        objednavkyComponent.pripravene(2);
        assert(pripraveneObjednavka.getStav() == StavPolozky.PRIPRAVENA);


        // test hodnotenia
        double test = objednavkyComponent.getVysledneHodnotenie();
        objednavkyComponent.spracujHodnotenie(objednavkyComponent.odovzdajHodnotenieRestauracii());
        assert(test != objednavkyComponent.getVysledneHodnotenie());



    }
}
