
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oz
 */
public class ClientApp {
    public static void main(String[] args) {
        try {
            String Msg = "Hi From Lab 5";
            Socket client = new Socket("127.0.0.1", 4444);
            DataInputStream reader = new DataInputStream(client.getInputStream());
            DataOutputStream writer = new DataOutputStream(client.getOutputStream());
            writer.writeUTF(Msg);
            String ServerMsg = reader.readUTF();
            System.out.println("SERVER SAID: "+ServerMsg);
            reader.close();
            writer.close();
            client.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
