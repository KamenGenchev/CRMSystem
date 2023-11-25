package com.sirma.manager;

import com.sirma.cli.UserInterface;
import com.sirma.entities.Client;
import com.sirma.entities.Industry;
import com.sirma.service.Service;


import java.util.Arrays;

import static com.sirma.utils.ClientCreator.createClient;
import static com.sirma.utils.InputFetcher.*;
import static com.sirma.utils.SearchHelper.*;

public class ClientManager extends Manager {
    public ClientManager(Service<Integer, Client, Client> service) {
        super(service);
    }

    @Override
    public void performAction(int command) {
        service.getInitialValues();
        switch (command) {
            case 1 -> addClient(-1);
            case 2 -> updateClient();
            case 3 -> viewClients();
            case 4 -> searchIndustry();
            case 5 -> searchID();
            case 6 -> searchName();
            case 7 -> remove();
            case 9 -> saveAndExit();
        }
    }


    private void addClient(int ID) {
        if (ID == -1) {
            System.out.println("Adding a new client:");
            System.out.println("Enter ID:");
            ID = getIntegerInput();
        }

        System.out.println("Enter Name:");
        String name = getInput();

        System.out.println("Enter Industry:");
        System.out.println("! Values can be: " + Arrays.toString(Industry.values()) + " !");
        String industry = getInput();

        System.out.println("Enter Contact Person:");
        String contactPerson = getInput();

        System.out.println("Enter Revenue:");
        double revenue = getDoubleInput();

        Client client = createClient(ID, name, industry, contactPerson, revenue);
        service.updateMap(client, true);
        System.out.println("Client added successfully!");

        clearScreen();
    }

    private void updateClient() {
        System.out.println("Please enter the ID of the client you want to edit:");
        int ID = getIntegerInput();

        Client client = (Client) service.getMap().get(ID);
        if (client == null) {
            System.out.println("Client with ID " + ID + " not found.");
            return;
        }
        System.out.println("Editing Client: ");
        addClient(ID);

    }

    private void viewClients() {
        for (Object client : service.getMap().values()) {
            System.out.println(client);
        }
    }

    private void searchIndustry() {
        System.out.println("Enter Industry To Search:");
        Industry industry = Industry.valueOf(getInput());

        setMap(service.getMap());
        System.out.println(searchByIndustry(industry).isEmpty() ? "No clients found!" : searchByIndustry(industry));
    }

    private void searchID() {
        System.out.println("Enter ID To Search:");
        int ID = getIntegerInput();
        if (service.getMap().containsKey(ID)) {
            System.out.println(service.getMap().get(ID));

        } else {
            System.out.println("Client with ID " + ID + " not found.");
        }
    }

    private void searchName() {
        System.out.println("Enter Name To Search: ");
        String name = getInput();

        setMap(service.getMap());
        System.out.println(searchByName(name).isEmpty() ? "No clients found!" : searchByName(name));

    }

    private void remove() {
        System.out.println("Enter Client ID To Remove:");
        int ID = getIntegerInput();

        if (!service.getMap().containsKey(ID)) {
            System.out.println("Client with ID " + ID + " not found.");

        } else {
            Client clientToRemove = (Client) service.getMap().get(ID);
            service.updateMap(clientToRemove, false);
            System.out.println("Client removed successfully!");
        }

        clearScreen();
    }

    private void saveAndExit() {
        service.saveValues();
        System.out.println("Save successful!");
    }

    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
        UserInterface.displayOptions();
    }
}
