/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shangeeee.mibanque.core;

/**
 *
 * @author fourange
 */
public class ImmutableClient {
    private final int id;
    private final String nom;
    private final String prenom;
    private final String adresse;
    private final int accountId;
    private final int accountSolde;

    public ImmutableClient(int id, String nom, String prenom, String adresse, int accountId, int accountSolde) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.accountId = accountId;
        this.accountSolde = accountSolde;
    }
    
    @Override
    public String toString() {
        return new StringBuilder("Client: ").append("\n")
                .append("Numéro: ").append(this.id).append(", ")
                .append("Nom: ").append(this.nom).append(", ")
                .append("Prenom: ").append(this.prenom).append(", ")
                .append("Adresse: ").append(this.adresse).append(", ")
                .append("Compte numéro: ").append(this.accountId).append(", ")
                .append("Solde compte: ").append(this.accountSolde)
                .toString()
                ;
        
    }
    
    static ImmutableClient from(Client c) {
        return new ImmutableClient(
                c.getId(), c.getNom(), 
                c.getPrenom(), 
                c.getAdresse(), 
                c.getAccount().getId(), 
                c.getAccount().getSolde()
        );
        
    }
}
