package com.mini.banque;

import java.util.Scanner;

public class BanqueInteractive {

    private Banque banque = new Banque();

    public BanqueInteractive(){
        // sample
        banque.ajouterClient("Guy");
        banque.getClient("Guy").comptes[0].depot(1500);
        banque.ajouterClient("Jean");
        banque.getClient("Jean").comptes[0].depot(200000);
        banque.ajouterClient("Luc");
        banque.getClient("Luc").comptes[0].depot(4000000);
    }

    private void ajouterClient(){
        System.out.println("Ajouter un client");
        String nom = ScannerUtils.getString("Veuillez entrer le nom du client ?");
        banque.ajouterClient(nom);

        interaction();
    }

    private void afficherClients(){
        System.out.println("Liste des clients : ");
        System.out.println(banque.listNomClients() + "\n");

        interaction();
    }

    private void operationClientBilan(Client client){
        client.bilan();
        operationClient(client);
    }

    private void operationClientAjouterCompte(Client client){
        client.ajouterCompte(new Compte());
        operationClient(client);
    }

    private void operationClientCompte(Client client){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < client.comptes.length; i++){
            sb.append(" " + i + "");
        }
        int idxCompte = ScannerUtils.getInt("Selectionnez un numero de compte :" + client.listeNumeroComptes() + "");
        // todo : getCompteByNumero
        Compte compte = client.comptes[idxCompte];

        System.out.println("solde = " + compte.getSolde());
        operationClient(client);
    }

    private void operationClient(Client client){
        StringBuilder sb = new StringBuilder();
        sb.append("Quelle opération voulez-vous effectuer sur le client " + client.getNom() + " ?\n");
        sb.append("1) Consulter le bilan \n");
        sb.append("2) Ajouter un compte\n");
        sb.append("3) Opération sur un compte \n");
        sb.append("4) Retour\n\n\n");

        String message = sb.toString();
        int operation = ScannerUtils.getInt(message);

        switch (operation){
            case 1 : operationClientBilan(client); break;
            case 2 : operationClientAjouterCompte(client); break;
            case 3 : operationClientCompte(client); break;
            case 4 : interaction(); break;
            default: operationClient(client);
        }
    }

    private void selectionClient(){
        System.out.println("Opération client : ");
        String nom = ScannerUtils.getString("Selectionnez le client : " + banque.listNomClients() + "\n");

        Client client = banque.getClient(nom);
        if (client != null)
            operationClient(client);
        else
            System.err.println("BIPPPPP! Erreur : Nom du client non reconnu !");

        interaction();
    }

    private void afficherBilan(){
        System.out.println("Afficher bilan");
        banque.afficherBilan();
        interaction();
    }


    private String preparerMenu(int nbCompte){
        StringBuilder sb = new StringBuilder();
        sb.append("Quelle opération voulez-vous effectuer ?\n");
        sb.append("1) Ajouter un client\n");
        if (nbCompte == 0) {
            sb.append("2) * menu 2 non disponible *\n");
            sb.append("3) * menu 2 non disponible *\n");
            sb.append("4) * menu 3 non disponible *\n");
        } else {
            sb.append("2) Afficher la liste des clients\n");
            sb.append("3) Effectuer une opération sur un client\n");
            sb.append("4) Afficher un bilan général\n");
        }
        sb.append("5) Terminer\n");
        return sb.toString();
    }

    public void interaction(){
        int nbCompte = banque.getClients().length;
        String message = preparerMenu(nbCompte);
        int operation = ScannerUtils.getInt(message);

        switch (operation){
            case 1 : ajouterClient(); break;
            case 2 :
                if (nbCompte > 0)
                    afficherClients();
                else {
                    System.out.println("menu non disponible");
                    interaction();
                }
                break;
            case 3 :
                if (nbCompte > 0)
                    selectionClient();
                else {
                    System.out.println("menu non disponible");
                    interaction();
                }
                break;
            case 4 :
                if (nbCompte > 0)
                    afficherBilan();
                else {
                    System.out.println("menu non disponible");
                    interaction();
                }
                break;
            case 5 : terminer(); break;
            default: interaction();
        }
    }

    public void terminer(){
        ScannerUtils.closeScanner();
        System.out.println("Terminé");
    }
}
