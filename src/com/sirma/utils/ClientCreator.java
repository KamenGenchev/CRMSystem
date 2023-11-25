package com.sirma.utils;

import com.sirma.entities.Client;
import com.sirma.entities.Industry;

import java.util.Arrays;


public final class ClientCreator {
    public static Client createClient(int ID, String name, String industryStr, String contactPerson, double revenue) {
        if (ID < 0 || revenue < 0) {
            throw new IllegalArgumentException("Revenue or ID can't be a negative number.");
        }

        if (name == null || industryStr == null || contactPerson == null) {
            throw new IllegalArgumentException("Not enough parameters.");
        }


        try {
            Industry industry = Industry.valueOf(industryStr);

            return new Client(ID, name, industry, contactPerson, revenue);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Industry value! Values can be: " + Arrays.toString(Industry.values()));
        }

    }

}
