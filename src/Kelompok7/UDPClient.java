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
public class UDPClient {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        BufferedReader inFromUser =
         new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        while(true){
            System.out.print("Text : ");
            String sentence = inFromUser.readLine();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            clientSocket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String modifiedSentence = new String(receivePacket.getData(), 
                    receivePacket.getOffset(), receivePacket.getLength());
            System.out.println("FROM SERVER:" + modifiedSentence);
            if(Character.isDigit(sentence.charAt(0))){
                if(Integer.parseInt(sentence)==1){
                    break;
                }
            }
        }
        clientSocket.close();
    }
}
