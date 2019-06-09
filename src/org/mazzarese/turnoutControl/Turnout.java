package org.mazzarese.turnoutControl;

import com.fazecast.jSerialComm.*;

import java.nio.charset.StandardCharsets;

/**
 *  A class to represent turnouts in the Java-Arduino Dispatching Environment. JADE turnouts currently operate over USB.
 *
 *  Written by Max Mazzarese.
 */
public class Turnout {
    private int state;
    private String identifier;
    private SerialPort port;

    /**
     * The turnout constructor.
     *
     * @param identifier an identifier(in the form of a number) for the turnout. No two turnouts on the same SerialPort should use the same identifier.
     * @param port the SerialPort which should be used to communicate with this turnout.
     */
    public Turnout(String identifier, SerialPort port) {
        this.identifier = identifier;
        this.port = port;
    }

    /**
     * Flips the turnout in the specified direction.
     *
     * @param instruction the direction (1 or 0) to flip the turnout.
     */
    public void flipDirection(String instruction) {
        String toSend = ("c" + this.identifier + ":" + instruction);
        byte[] idBytes = toSend.getBytes(StandardCharsets.US_ASCII);
        System.out.println(toSend);
        System.out.println(port.openPort());
        port.writeBytes(idBytes, idBytes.length);
        port.closePort();
    }

    /**
     * A string to represent the turnout in the form "identifier:state"
     *
     * @return a string representing the turnout.
     */
    public String toString() {
        return identifier + ":" + state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public SerialPort getPort() {
        return port;
    }

    public void setPort(SerialPort port) {
        this.port = port;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
