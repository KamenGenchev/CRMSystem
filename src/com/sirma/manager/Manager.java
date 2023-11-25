package com.sirma.manager;

import com.sirma.service.Service;

public abstract class Manager {
    protected Service service;

    public Manager(Service service) {
        this.service = service;
    }

    public abstract void performAction(int command);
}
