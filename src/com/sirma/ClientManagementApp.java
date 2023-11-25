package com.sirma;

import com.sirma.fileio.CsvReader;
import com.sirma.fileio.CsvWriter;
import com.sirma.manager.*;
import com.sirma.service.*;
import com.sirma.cli.*;

public class ClientManagementApp {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        CsvReader fileReader = new CsvReader();
        CsvWriter fileWriter = new CsvWriter();
        Service service = new ClientService(fileReader, fileWriter);
        Manager manager = new ClientManager(service);
        System.out.println("Welcome to the Client Management System");
        ui.displayOptions();
        boolean active = true;
        while (active) {
            int command = ui.start();
            manager.performAction(command);
// Add Client
// 1, Oceanic Enterprises, Finance, Sarah Smith, 500000.00
// Update Client
// 1, Oceanic Enterprises, Tech, Sarah Smith, 750000.00
// View Clients
// Search Industry Tech
// Search ID 1
// Remove Client 1
// Search Name Oceanic
// Save &amp; Exit
        }
    }
}