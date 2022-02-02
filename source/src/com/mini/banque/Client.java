package com.mini.banque;

import java.util.*;

/**
 * 
 */
public class Client {

    public Client(String nomDuClient) {
        this.nom = nomDuClient;
        this.comptes = new Compte[] {new Compte()};
    }

    private String nom;
    public String getNom() {
        return this.nom;
    }

    public Compte[] comptes;
    public int getNbComptes(){
        return comptes.length - 1;
    }

    public void ajouterCompte(Compte compte) {
        Compte[] newComptes = Arrays.copyOf(this.comptes, this.comptes.length + 1);
        newComptes[newComptes.length - 1] = compte;
        comptes = newComptes;
    }

    public float getSolde(){
        float solde = 0;
        for (Compte compte : Arrays.asList(comptes)){
            solde = solde + compte.getSolde();
        }
        return  solde;
    }

    public void bilan(){
        for (Compte compte : Arrays.asList(comptes)){
            compte.afficherSolde();;
        }
    }

    public String listeNumeroComptes(){
        String numero[] = new String[comptes.length];

        for (int i = 0; i < comptes.length; i++){
            numero[i] = comptes[i].getNumero();
        }

        return Utils.chaineTableau(numero);
    }

    public String listeNumeroComptesAvecSolde(){
        String numero[] = new String[comptes.length];

        for (int i = 0; i < comptes.length; i++){
            numero[i] = "N°: " + comptes[i].getNumero() + ", solde = " + Utils.formatterMontant(comptes[i].getSolde());
        }

        return Utils.chaineTableau(numero);
    }

    public Compte getCompteByNumber(String number){
        for (int i = 0; i < comptes.length; i++){
            if (comptes[i].getNumero().equals(number))
                return comptes[i];
        }
        return null;
    }

}