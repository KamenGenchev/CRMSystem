package com.sirma.service;

import java.util.Map;

public interface Service<K, V, T> {

    Map<K,V> getMap();

    void populate();

     void getInitialValues();

    void saveValues();


    void updateMap(T object, boolean bool);

}
