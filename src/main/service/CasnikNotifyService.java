package main.service;

public class CasnikNotifyService implements CasnikNotifyInterface {
    ObjednavkyComponent ObjComp;

    public CasnikNotifyService(ObjednavkyComponent objComp) {
        ObjComp = objComp;
    }

    // alternativne sa da prerobit, aby vracala string s odpovedou
    @Override
    public void nie_je(int idPolozky, int idStola) {
        if(this.ObjComp.nedostupnePolozky[idPolozky]) System.out.println("Stolu id. " + idStola + " oznamujem, ze polozka " + idPolozky + " nie je dostupna");
    }

    @Override
    public void pripravene(int idPolozky, int idStola) {
        System.out.println("Stolu id. " + idStola + " oznamujem, ze polozka " + idPolozky + " je pripravena.");
//        tu by sa dala popisovat cena jednotlivej polozky a aj cas
//        napriklad, ze sa na stol donesie najprv nejaka polozka, az potom ta dalsia = jednoduchym porovnavanim
    }
}
