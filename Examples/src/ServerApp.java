
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
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
public class ServerApp extends Thread{
    
    ServerSocket server;

    public ServerApp() {
        try{
        server = new ServerSocket(4444);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void run() {
        Socket aClient;
        while(true){
            try {
                System.out.println("Waiting ...");
                aClient = server.accept();
                System.out.println("New Client is HERE!!");
                DataInputStream reader =
                        new DataInputStream(aClient.getInputStream());
                DataOutputStream writter = 
                        new DataOutputStream(aClient.getOutputStream());
                String aClientMsg = reader.readUTF();
                writter.writeUTF(aClientMsg);
                System.out.println("SERVER: User FROM Port : "+aClient.getPort() + " SEND " + aClientMsg);
                reader.close();
                writter.close();
                aClient.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        new ServerApp().start();
    }
    
    
}
