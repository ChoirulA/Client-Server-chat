/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kelompok7;

import java.io.*;
import java.net.*;

/**
 *
 * @author choirulandriansyah
 */
public class ClientController {
    private ClientGUI view;
    private DatagramSocket clientSocket;
    private InetAddress IPAddress;
    private byte[] sendData = new byte[1024];
    private byte[] receiveData = new byte[1024];

    public ClientController(ClientGUI view){
        this.view = view;
    }

    public void makeConnection() throws SocketException, UnknownHostException{
        clientSocket = new DatagramSocket();
        IPAddress = InetAddress.getByName("localhost");
    }
    
    public void sendMessage(String sentence) throws SocketException, UnknownHostException, IOException{
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);
    }
    
    public String receiveMessage() throws IOException{
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData(), 
                receivePacket.getOffset(), receivePacket.getLength());
        return "FROM SERVER: succesfully send message " + modifiedSentence + ".";
    }
    
    public void sendFile(String sentence) throws SocketException, UnknownHostException, IOException{
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);
    }
    
    public String receiveFile() throws IOException{
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData(), 
                receivePacket.getOffset(), receivePacket.getLength());
        return "FROM SERVER: succesfully send file " + modifiedSentence;
    }
    
    public void closeConnection(){
        clientSocket.close();
    }
}
