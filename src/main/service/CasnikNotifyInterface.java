package main.service;


// v zadani sa pise id_jedla, ale o jedle sa v celom projekte nehovorilo nic
// preto si myslim, ze je lepsi napad pisat idPolozky
public interface CasnikNotifyInterface {
    void nie_je(int idPolozky, int idStola);
    void pripravene(int idPolozky, int idStola);
}
