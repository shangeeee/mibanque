/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shangeeee.mibanque.ui;

import com.shangeeee.mibanque.agency.AgencyListener;
import com.shangeeee.mibanque.agency.PrincipalAgency;
import com.shangeeee.mibanque.core.Client;
import com.shangeeee.mibanque.core.ImmutableClient;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author fourange
 */
public class ConsoleAgencyUI {

    Scanner scanner;

    PrincipalAgency agency;

    public ConsoleAgencyUI() {
        this.scanner = new Scanner(System.in);
        
        this.agency.addAgencyListener(new AgencyListener() {
            @Override
            public void onClientNotFound(int idClient) {
                System.err.println("Le client " + idClient + " n'existe pas");
            }

            @Override
            public void onInsufficientAmount(int amount) {
                System.err.println("Impossible d'effectuer le retrait de: " + amount);
            }
        });
    }


    
    public void start(PrincipalAgency agency) {
        this.agency = agency;
        int stops;
        do {
            showMenu();
            stops = this.nextPosInt("Voulez vous arreter le programme? (1 pour Oui): ", 1, 2);
        } while (stops != 1);
        this.scanner.close();
    }

    protected void showMenu() {
        int choosed ;

        System.out.println("**************************");
        System.out.println("*********  MENU  *********");
        System.out.println("**************************");

        System.out.println("Veuillez saisir ");

        System.out.println("1 - Pour ajouter un client");
        System.out.println("2 - Pour un retrait d'argrent");
        System.out.println("3 - Pour un versement d'argent");
        System.out.println("4 - Pour avoir la liste des clients");

        choosed = this.nextPosInt("Entre 1 et 4", 1, 4);
        switch (choosed) {
            case 1: {
                System.out.println("1 - Pour ajouter un client");
                String nom = this.nextLine("Nom: ");
                String prenom = this.nextLine("Prenom: ");
                String adress = this.nextLine("Adresse: ");

                Client c = new Client(nom, prenom, adress);
                boolean res = this.agency.addOrUpdateClient(c);
                if (res) {
                    System.out.println("Ajouter avec succes. ");
                    System.out.println(c);
                }

                break;

            }
            case 2: {
                System.out.println("2 - Pour un retrait d'argrent");
                int idClient = this.nextPosInt("Entrer l'id du client", 0);
                int montant = this.nextPosInt("Saisissez le montant: ", 0);

                this.agency.retrait(idClient, montant);
                break;
            }
            case 3: {
                System.out.println("3 - Pour un versement d'argent");
                int idClient = this.nextPosInt("Entrer l'id du client", 0);
                int montant = this.nextPosInt("Saisissez le montant: ", 0);

                this.agency.depot(idClient, montant);
                break;
            }
            case 4: {
                System.out.println("4 - Pour avoir la liste des clients");

                List<ImmutableClient> clients = this.agency.getClients();

                for (ImmutableClient client : clients) {
                    System.out.println(client + "\n\n");
                }

                break;
            }

            default:
                throw new AssertionError();
        }

    }

    protected int nextPosInt(String msg, int min) {
        int max = Integer.MAX_VALUE;
        return this.nextPosInt(msg, min, max);
    }

    protected Integer nextPosInt(String msg, int min, int max) {
        if (min < 0) {
            min = 0;
            System.err.println("La valeur minimale doit etre superieur ou egale a zero. Automatiquement Corriger");

        }
        Integer next = null;
//        try (this.scanner) {
        do {
            System.out.println(msg);
            // Read user input
            try {
                next = this.scanner.nextInt();
                if (next < min) {
                    System.out.println("Saisi invalid: l'entier doit etre superieur ou egale a " + min);
                } else if (next > max) {
                    System.out.println("Saisi invalid: l'entier doit etre inferieur ou egale a " + max);
                }
            } catch (InputMismatchException e) {
                System.out.println("Saisi invalid");
            } catch (Exception e) {
                System.out.println("Erreur inconnue pendant la saisie.");

            }

        } while (next < min || next > max);
//        }
        return next;// Output user input
    }

    protected String nextLine(String msg) {
        String line = null;
        do {

            System.out.println(msg);
            try {
                line = this.scanner.next();
            } catch (Exception e) {
                System.out.println("Erreur inconnue pendant la saisie.");
                System.err.println(e);
            }

        } while (line == null);
        return line;// Output user input
    }

    protected int askClientId() {
        return this.nextPosInt("Saisissez l'id du client:", 0);
    }

    protected int askDepotSolde() {
        return this.nextPosInt("Saisissez le montant a deposer:", 0);
    }

    protected int askRetraitSolde() {
        return this.nextPosInt("Saisissez le montant a retirer:", 0);
    }

}
