/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shangeeee.mibanque.core;

/**
 *
 * @author fourange
 */
public class IdGenerator {
    public static int current = 1;
    
    public static int next() {
        return ++current;
    }
    
}
