package com.mini.banque;

import java.text.NumberFormat;
import java.util.*;

/**
 * 
 */
public class Compte {
    private static int compteur = 0;

    private String numero;

    public String getNumero() {
        return numero;
    }

    private float solde;

    public Compte() {
        solde = 0;
        Compte.compteur++;
        //numero = UUID.randomUUID().toString();
        numero = Integer.toString(Compte.compteur);
    }

    public String statut(){
        return "N° : " + getNumero() + " Solde = " + Utils.formatterMontant(getSolde());
    }

    public void depot(float valeur) {
        solde = solde + valeur;
    }

    public void retrait(float valeur) {
        solde = solde - valeur;
    }

    public float getSolde() {
        return solde;
    }

    public void afficherSolde() {
        String strSolde = Utils.formatterMontant(solde);
        System.out.println("Compte: " + numero + " Solde = " +  strSolde);
    }

    public void virer(float valeur, Compte destinataire) {
        retrait(valeur);
        destinataire.depot(valeur);
    }

}