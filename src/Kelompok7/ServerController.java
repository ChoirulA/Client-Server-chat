/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kelompok7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author choirulandriansyah
 */
public class ServerController {
    private ServerGUI view;
    private DatagramSocket serverSocket;
    private InetAddress IPAddress;
    private int port;
    private byte[] receiveData = new byte[1024];
    private byte[] sendData = new byte[1024];

    public ServerController(ServerGUI view) {
        this.view = view;
    }
    
    public void makeConnection() throws SocketException{
        serverSocket = new DatagramSocket(9876);
    }
    
    public void closeConnection(){
        serverSocket.close();
    }
    
    public String receiveMessage() throws IOException{
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
        String sentence = new String( receivePacket.getData(), 
                receivePacket.getOffset(), receivePacket.getLength());
        IPAddress = receivePacket.getAddress();
        port = receivePacket.getPort();
        return sentence;
    }
    
    public void sendMessage(String sentence) throws IOException{
        sendData = sentence.getBytes();
        DatagramPacket sendPacket =
        new DatagramPacket(sendData, sendData.length, IPAddress, port);
        serverSocket.send(sendPacket);
    }
}
