package org.mazzarese.turnoutControl;

import com.fazecast.jSerialComm.SerialPort;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        SerialPort[] ports = SerialPort.getCommPorts();
        for(SerialPort sp: ports) {
            System.out.println(sp.getPortDescription());
        }
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose the port for bank A: ");
        int selected = sc.nextInt();
        TurnoutBank bankA = new TurnoutBank(ports[selected], 'a');
        Turnout test = new Turnout("1", bankA.getPort());
        bankA.add(test);


        TurnoutCommand cmd;
        while(true) {

            System.out.println("Enter Command:");
            String command = sc.nextLine();
            System.out.println(command);
            if(command.equals("list")) {
                System.out.println("itworks");
                for(int i = 0; i < bankA.size(); i++) {
                    System.out.println("yayay");
                    System.out.print("" + i + ") " + bankA.get(i));
                    System.out.println();
                }
            }
            else if(command.equals("exit")) {
                break;
            }
            else {
                cmd = new TurnoutCommand(command);
                Turnout t;
                for(int i = 0; i < bankA.size(); i++) {
                    t = bankA.get(i);
                    if(t.getIdentifier().equals(cmd.getIdentifier())) {
                        t.flipDirection(cmd.getInstruction());
                    }
                }
            }
        }
    }
}
