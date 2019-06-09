package org.mazzarese.turnoutControl;

/**
 * A class to store and parse JADE commands.
 *
 * Written by Max Mazzarese.
 */
public class TurnoutCommand {
    private String command;
    private String identifier;
    private String instruction;



    public TurnoutCommand(String command) {
        this.command = command;
        identifier = "";
        instruction = "";
        boolean after = false;
        for(int i = 0; i < command.length(); i++) {
            if(command.charAt(i) == ':') {
                after = true;
            }
            if(after == false) {
                identifier += command.charAt(i);
            }
            else if(command.charAt(i) != ':') {
                instruction += command.charAt(i);
            }
        }
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getCommand() {
        return command;
    }
}
