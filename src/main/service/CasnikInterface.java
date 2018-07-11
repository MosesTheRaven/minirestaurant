package main.service;

import main.dto.ObjednavkaStola;

public interface CasnikInterface {

    void objednaj(int idPolozky, int idStola);

    ObjednavkaStola[] dajObjednavkuStola(int idStola);

    void zmazObjednavku(int idObjednvky);

}
