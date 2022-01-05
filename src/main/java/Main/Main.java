/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import com.shangeeee.mibanque.ui.ConsoleAgencyUI;
import com.shangeeee.mibanque.agency.PrincipalAgency;

/**
 *
 * @author fourange
 */
public class Main {
    
    public static void main(String[] args) {
        PrincipalAgency agency = new PrincipalAgency();
        
        ConsoleAgencyUI consoleAgency = new ConsoleAgencyUI();
        
        // Start the command line interface
        consoleAgency.start(agency);
    }
    
}
