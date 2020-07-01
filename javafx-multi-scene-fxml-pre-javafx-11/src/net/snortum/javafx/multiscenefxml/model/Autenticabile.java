package net.snortum.javafx.multiscenefxml.model;

public abstract class Autenticabile extends Subject{
    
 
    private boolean isLogged = false;

    public boolean isIsLogged() {
        return isLogged;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
        notifyAllObservers();
    }

}
