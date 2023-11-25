package com.sirma.cli;

import static com.sirma.utils.InputFetcher.getIntegerInput;

public class UserInterface {

    public int start() {
        int input = getIntegerInput();

        if (input < 0 || input > 7 && input != 9) {
            System.out.println("Wrong input!");
        }

        return input;
    }

    public static void displayOptions() {
        System.out.println("***Hello Manager! Manager do managing:***");
        System.out.println("""
                1. Add Client\s
                2. Update Client\s
                3. View Clients\s
                4. Search Industry\s
                5. Search ID\s
                6. Search Name\s
                7. Remove Client\s
                9. Save & Exit
                """);
    }
}
