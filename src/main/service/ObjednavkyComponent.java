package main.service;

import main.domain.Objednavka;
import main.domain.StavPolozky;
import main.dto.ObjednavkaStola;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class ObjednavkyComponent implements CasnikInterface, KuchynaInterface, ZakaznikInterface {

    List<Objednavka> objednavky = new LinkedList<Objednavka>();
    CasnikNotifyInterface casnikNotifyService;
    KuchynaNotifyInterface kuchynaNotifyService;

    // pre dostupnost a ceny objednavok => chcelo by to mat objekty typu Polozky, kde by boli stanovene ceny, dostupnost a tak dalej
    boolean[] nedostupnePolozky;
    int[] cenyPoloziek;

    // tato cast je tu kvoli hodnoteniam
    // tieto dve cisla by mali byt v systeme uchovavane v inom komponente, nie tu - pre jednoduchost predpokladajme, ze k nim vieme pristupit
    int pocetHodnoteni = 0;
    long hodnotenie = 0;
    double vysledneHodnotenie = 3;


    public double getVysledneHodnotenie() {
        return vysledneHodnotenie;
    }

    public void spracujHodnotenie(int hodnotenie){
        this.hodnotenie += hodnotenie;
        this.pocetHodnoteni ++;
        this.vysledneHodnotenie = ((double) this.hodnotenie) / pocetHodnoteni;
    }


    public List<Objednavka> getObjednavky() {
        return objednavky;
    }

    public void addObjednavka(Objednavka objednavka){
        this.objednavky.add(objednavka);
    }

    // implementacia main.service.KuchynaInterface
    @Override
    // ocakavam, ze sa pripravila polozka, ktora bola objednana - ak sa pripravila polozka, ktoru uz nikto nechcel, tak sa "zahodi"
    public void pripravene(int idPolozky) {
        for (Objednavka objednavka : objednavky) {
            if (objednavka.getStav() == StavPolozky.OBJEDNANA && objednavka.getIdPolozky() == idPolozky){
                objednavka.setStav(StavPolozky.PRIPRAVENA);
                break;
            }
        }
    }



    // implementacia main.service.CasnikInterface
    @Override
    public void objednaj(int idPolozky, int idStola) {
        this.objednavky.add(new Objednavka(idStola, idPolozky));
    }
    @Override
    public ObjednavkaStola[] dajObjednavkuStola(int idStola) {
        List<ObjednavkaStola> objednavkaStola = new LinkedList<>();
        for (Objednavka objednavka : objednavky) {
            if(objednavka.getStol().getIdStola() == idStola){
                ObjednavkaStola convertedObjednavka = new ObjednavkaStola(objednavka.getIdObjednavky(), objednavka.getIdPolozky(), objednavka.getStav());
                objednavkaStola.add(convertedObjednavka);
            }
        }
        ObjednavkaStola[] retVal = objednavkaStola.toArray(new ObjednavkaStola[objednavkaStola.size()]);

        return retVal;
    }
    @Override
    public void zmazObjednavku(int idObjednavky) {
        int index = -1;
        for (int i = 0; i < this.objednavky.size(); i++){
            if (this.objednavky.get(i).getIdObjednavky() == idObjednavky){
                index = i;
                break;
            }
        }
        if(index != -1) this.objednavky.remove(index);
        else throw new NoSuchElementException();
    }


// implementacia main.service.ZakaznikInterface

//    povedzme, ze si system nejakym sposobom uchovava zakaznikov - kazdy zakaznik, resp skupina zakaznikov sedi pri nejakom stole
//    tento komponent by vedel pristupovat k zakaznikom a teda aj k ich stolom, potom zavolanim tejto metody - nech uz to znamena cokolvek
//    z hladiska zadania ulohy nebolo potrebne implementovat tuto metodu, pretoze z diagramu nebolo jasne, ako by zasahovala do "zivota" tejto komponenty
    @Override
    public void zavolajCasnika(int cisloStola) {
    }
//    tato metoda nejakeho zakaznika odovzdava hodnotenie restauracie
//    pre jednoduchost nech hodnoti nahodnymi cislami
//    idealne by mal casnik odovzdat hodnotenie objednavka
    @Override
    public int odovzdajHodnotenieRestauracii() {
        return new Random().nextInt(11);
    }


}
