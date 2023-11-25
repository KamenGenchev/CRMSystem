package com.sirma.utils;

import com.sirma.entities.Client;
import com.sirma.entities.Industry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SearchHelper {
    private static Map<Integer, Client> clientMap = new HashMap<>();
    public static void setMap(Map<Integer, Client> inputMap) {
        for (Map.Entry<Integer, Client> entry : inputMap.entrySet()) {
            Integer key = entry.getKey();
            Client value = entry.getValue();
            clientMap.put(key, value);
        }
    }


    public static List<Client> searchByName(String name) {

        List<Client> matchingClients = new ArrayList<>();

        for (Client client : clientMap.values()) {
            if (client.name().equals(name)) {
                matchingClients.add(client);
            }
        }
        return matchingClients;
    }

    public static List<Client> searchByIndustry (Industry industry) {
        List<Client> matchingClients = new ArrayList<>();

        for (Client client : clientMap.values()) {
            if (client.industry().equals(industry)) {
                matchingClients.add(client);
            }
        }
        return matchingClients;
    }

}
