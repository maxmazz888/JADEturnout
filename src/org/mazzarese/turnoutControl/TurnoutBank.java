package org.mazzarese.turnoutControl;

import java.util.*;
import com.fazecast.jSerialComm.*;

/**
 * A class to hold multiple Turnouts that are controlled by one device on the same SerialPort.
 *
 * Written by Max Mazzarese.
 */
public class TurnoutBank {
    ArrayList<Turnout> turnouts;
    SerialPort port;
    char bankID;

    public TurnoutBank(SerialPort port, char bankID) {
        this.port = port;
        this.bankID = bankID;
        turnouts = new ArrayList<Turnout>();
    }

    public ArrayList<Turnout> getTurnouts() {
        return turnouts;
    }

    public void setTurnouts(ArrayList<Turnout> turnouts) {
        this.turnouts = turnouts;
    }

    public void add(Turnout t) {
        turnouts.add(t);
    }

    public void remove(Turnout t) {
        turnouts.remove(t);
    }

    public SerialPort getPort() {
        return port;
    }

    public void setPort(SerialPort port) {
        this.port = port;
    }

    public char getBankID() {
        return bankID;
    }

    public void setBankID(char bankID) {
        this.bankID = bankID;
    }

    public int size() {
        return turnouts.size();
    }

    public Turnout get(int i) {
        return turnouts.get(i);
    }
}
