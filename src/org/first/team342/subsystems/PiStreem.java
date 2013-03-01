/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables2.stream.SocketConnectionStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Team 342
 */
public class PiStreem extends Subsystem {

    private static final PiStreem INSTANCE = new PiStreem();
    private SocketConnectionStream connection;

    private PiStreem() {
        try {
            connection = new SocketConnectionStream("10.3.42.9", 8882);
        } catch (IOException ex) {
            System.out.print("failed to connect to Pi");
        }
    }

    public static PiStreem getInstance() {
        return INSTANCE;
    }

    protected void initDefaultCommand() {
    }

    public String getData() {
        int temp;
        String output = "";
        InputStream listen;
        DataInputStream data;
        try {
            listen = this.connection.getInputStream();
            data = new DataInputStream(listen);
            temp = data.readChar();
            System.out.print("Reading ");
            for (int i = 0; temp != -1 && i < 7; i++) {
                System.out.print("Working ");
                System.out.println((char) temp + "\t");

                output += (char) temp;
                temp = listen.read();

            }
            System.out.println("Done");
            System.out.println(output);
        } catch (IOException ex) {
            System.out.println("Failed to connect to pi");
            output = "no output";
        }
        return output;
    }
}
