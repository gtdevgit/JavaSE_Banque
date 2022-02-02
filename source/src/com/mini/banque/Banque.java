package com.mini.banque;

import java.util.*;

/**
 * 
 */
public class Banque {

    private String nom;
    private Compte compte;
    private Client[] clients = {};

    /**
     * Default constructor
     */
    public Banque() {
    }

    /**
     * @param nomClient
     */
    public void ajouterClient(String nomClient) {
        Client[] newClients = Arrays.copyOf(clients, clients.length + 1);
        newClients[newClients.length - 1] = new Client(nomClient);
        clients = newClients;
    }

    /**
     * @param client
     */
    public void bilanClient(Client client) {
        System.out.println("Bilan client : " + client.getNom() + " = " + Utils.formatterMontant(client.getSolde()));
    }

    /**
     * 
     */
    public void afficherBilan() {
        for (Client client : Arrays.asList(clients)){
            bilanClient(client);
        }
        System.out.println("");
    }

    public Client getClient(String nom){
        for (Client client : Arrays.asList(clients)){
            if (client.getNom().equals(nom)) {
                return  client;
            }
        }
        return null;
    }

    public Client[] getClients(){
        return clients;
    }

    public String listNomClients(){
        String nom[] = new String[clients.length];

        for (int i = 0; i < clients.length; i++){
            nom[i] = clients[i].getNom();
        }

        return Utils.chaineTableau(nom);
    }

}