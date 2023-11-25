package com.sirma.utils;

import java.io.File;
import java.net.URL;

public final class ResourceFiles {
    public static final File CLIENTS_CSV;

    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource("resources/clients.csv");
        if (url == null) {
            throw new RuntimeException("Could not find resource file: resources/clients.csv");
        }
        CLIENTS_CSV = new File(url.getPath());
    }
}
