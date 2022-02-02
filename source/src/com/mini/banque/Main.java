package com.mini.banque;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
/*        Banque banque = new Banque();
        banque.ajouterClient("jean");
        Client jean = banque.getClient("jean");
        jean.getSolde();
        jean.comptes[0].depot(100);
        jean.comptes[0].afficherSolde();

        banque.ajouterClient("claire");
        Client claire = banque.getClient("claire");
        claire.comptes[0].afficherSolde();

        jean.comptes[0].virer(10, claire.comptes[0]);

        claire.comptes[0].afficherSolde();
        Compte compte = new Compte();
        compte.depot(400);
        claire.ajouterCompte(compte);
        claire.bilan();

        banque.afficherBilan();*/

        BanqueInteractive bi = new BanqueInteractive();

        bi.interaction();
    }
}
