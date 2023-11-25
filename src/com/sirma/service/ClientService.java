package com.sirma.service;

import com.sirma.entities.Client;
import com.sirma.entities.Industry;
import com.sirma.fileio.CsvReader;
import com.sirma.fileio.CsvWriter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sirma.utils.ClientCreator.createClient;
import static com.sirma.utils.ResourceFiles.CLIENTS_CSV;


public class ClientService implements Service<Integer, Client, Client> {
    private final CsvReader csvReader;
    private final CsvWriter csvWriter;

    protected Map<Integer, Client> map = new HashMap<>();

    private List<Client> clientList;

    public ClientService(CsvReader csvReader, CsvWriter csvWriter) {
        this.csvReader = csvReader;
        this.csvWriter = csvWriter;
        clientList = new ArrayList<>();
    }

    @Override
    public void populate() {
        if (clientList.isEmpty()) {
            return;
        }

        for (Client client : clientList) {
            map.put(client.ID(), client);
        }
    }

    @Override
    public void getInitialValues() {
        List<String[]> clientData = csvReader.readDataFile(CLIENTS_CSV);

        if (clientData.isEmpty()) {
            return;
        }

        for (String[] data : clientData) {
            try {
                int ID = Integer.parseInt(data[0]);
                String name = data[1].trim();
                String industry = data[2].trim();
                String contactPerson = data[3].trim();
                double revenue = Double.parseDouble(data[4]);

                Client client = createClient(ID, name, industry, contactPerson, revenue);
                clientList.add(client);

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Error in creating employee from data");
            }
        }

        populate();
    }

    @Override
    public void saveValues() {
        List<String[]> clientExitData = new ArrayList<>();

        for (Client client : map.values()) {
            String[] clientData = new String[5];
            clientData[0] = String.valueOf(client.ID());
            clientData[1] = client.name();
            clientData[2] = client.industry().toString();
            clientData[3] = client.contactPerson();
            clientData[4] = String.valueOf(client.revenue());
            clientExitData.add(clientData);
        }

        csvWriter.writeDataFile(clientExitData, CLIENTS_CSV);
    }

    @Override
    public void updateMap(Client client, boolean addingOrDeleting) {
        // If the boolean is true then it will rewrite records to the csv file
        // If it is false then it will delete records

        Client checkIfExistingClient = map.putIfAbsent(client.ID(), client);

        if (checkIfExistingClient != null) {
            if (addingOrDeleting) {
                map.replace(client.ID(), checkIfExistingClient, client);
            } else {
                map.remove(client.ID());
            }
        }

        saveValues();
    }


    public Map<Integer, Client> getMap() {
        return this.map;
    }

}
