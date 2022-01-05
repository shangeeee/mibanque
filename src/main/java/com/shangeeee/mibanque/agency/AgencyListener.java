/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shangeeee.mibanque.agency;

/**
 * 
 * @author fourange
 */
public interface AgencyListener {
    public void onClientNotFound(int id);
    public void onInsufficientAmount(int amount);
}
