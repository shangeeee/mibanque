/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shangeeee.mibanque.agency;

import com.shangeeee.mibanque.exceptions.InsufficientAmountException;
import com.shangeeee.mibanque.core.Client;
import com.shangeeee.mibanque.core.ImmutableClient;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author fourange
 */
public class PrincipalAgency {

    private final List<AgencyListener> agencyListeners;

    private final List<Client> clients;

    public PrincipalAgency() {
        this.clients = new ArrayList<>();
        this.agencyListeners = new ArrayList<>();
    }

    /**
     * Add client or Update with the new instance if already exists
     *
     * @param c The client to add or update
     * @return
     */
    public boolean addOrUpdateClient(Client c) {
        // Check if the client dont exists
        int existsIndex = this.findClientIndexById(c.getId());
        if (existsIndex >= 0) {

            this.clients.set(existsIndex, c);
        } else {
            this.clients.add(c);
        }

        return true;
    }

    /**
     * Retrait d'argent
     *
     * @param idClient
     * @param amount
     */
    public void retrait(int idClient, int amount) {
        int existsIndex = this.findClientIndexById(idClient);
        if (existsIndex == -1) {
            for (AgencyListener agencyListener : agencyListeners) {
                agencyListener.onClientNotFound(idClient);
            }
            // Abort
            return;
        }
        try {
            this.clients.get(existsIndex).getAccount().retrait(amount);
        } catch (InsufficientAmountException ex) {
            for (AgencyListener agencyListener : agencyListeners) {
                agencyListener.onInsufficientAmount(amount);
            }
        }

    }

    /**
     * Depot d'argent
     *
     * @param idClient
     * @param amount
     */
    public void depot(int idClient, int amount) {
        int existsIndex = this.findClientIndexById(idClient);
        if (existsIndex == -1) {
            for (AgencyListener agencyListener : agencyListeners) {
                agencyListener.onClientNotFound(idClient);
            }
            // abort
            return;
        }
        this.clients.get(existsIndex).getAccount().depot(amount);
    }

    /**
     * Returns an immutable list of all clients
     *
     * @return
     */
    public List<ImmutableClient> getClients() {
        return this.clients.stream()
                .map(c -> c.toImmutable())
                .collect(Collectors.toList());
    }

    /**
     * Find a client using it id
     *
     * @param id
     * @return The found client object. Null otherwise
     */
    public int findClientIndexById(int id) {
        int index = -1;
        Client c;
        for (int i = 0; i < this.clients.size(); i++) {
            c = this.clients.get(i);
            if (c.getId() == id) {
                // Ids are unique so we stop on the first match
                index = i;
                break;
            }
        }

        return index;
    }

    public void addAgencyListener(AgencyListener listener) {
        this.agencyListeners.add(listener);
    }
}
