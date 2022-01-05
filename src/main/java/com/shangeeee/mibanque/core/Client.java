/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shangeeee.mibanque.core;

/**
 *
 * @author fourange
 */
public class Client {

    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private Account account;

    public Client() {
        this.id = IdGenerator.next();
        this.account = new Account();
    }

    public Client(String nom, String prenom, String adress) {
        this();
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adress;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ImmutableClient toImmutable() {
        return ImmutableClient.from(this);
    }

    @Override
    public String toString() {
        return new StringBuilder("Client: ").append("\n")
                .append("Numéro: ").append(this.id).append(", ")
                .append("Nom: ").append(this.nom).append(", ")
                .append("Prenom: ").append(this.prenom).append(", ")
                .append("Adresse: ").append(this.adresse).append(", ")
                .append("Compte numéro: ").append(this.account.getId()).append(", ")
                .append("Solde compte: ").append(this.account.getSolde())
                .toString();
    }

}
