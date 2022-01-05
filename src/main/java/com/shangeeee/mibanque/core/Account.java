/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shangeeee.mibanque.core;

import com.shangeeee.mibanque.exceptions.InsufficientAmountException;

/**
 *
 * @author fourange
 */
public class Account {
    private int id;
    private int solde;
    
    public Account() {
        this.id = IdGenerator.next();
        this.solde = 0;
    }
    
   public Account(int solde) {
        this();
        this.solde = solde;
    }

    public int getId() {
        return id;
    }


    public int getSolde() {
        return solde;
    }

    protected void setSolde(int solde) {
        this.solde = solde;
    }
    
    /**
     * Retrait d'argent
     * @param solde 
     * @throws com.shangeeee.mibanque.exceptions.InsufficientAmountException 
     */
    public void retrait(int solde) throws InsufficientAmountException {
        if(this.solde < solde) {
            throw  new InsufficientAmountException();
        }
        
        this.solde -= solde;
        
    }
    
    /**
     * Depot d'argent
     * @param solde 
     */
    public void depot(int solde) {
        this.solde += solde;
    }   
}
