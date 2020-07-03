/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.snortum.javafx.multiscenefxml.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elisa
 */
public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        observers.forEach(o -> {
            o.update();
        });
    }

    public void notifyAllObserversSpesa() {
        observers.forEach(o -> {
            o.updateSpesa();
        });
    }

}
