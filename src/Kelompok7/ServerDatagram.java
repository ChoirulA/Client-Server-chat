/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kelompok7;

import java.net.*;
import java.io.*;
/**
 *
 * @author choirulandriansyah
 */
public class ServerDatagram {
    public static DatagramSocket ds;
    public static int clientport=2000,serverport=2134;
    public static void main (String args[]) throws Exception {
        byte buffer[]= new byte[1024];
        ds= new DatagramSocket (serverport);
        BufferedReader dis= new BufferedReader ( new InputStreamReader
        (System.in));
        System.out.println ("Server menunggu input");
        InetAddress i=InetAddress.getByName ("localhost");
        while (true){
            System.out.print("Inputan Server: ");
            String str=dis.readLine();
            if ((str==null || str.equals ("end")) ) break;
            buffer=str.getBytes();
            ds.send(new DatagramPacket(buffer,str.length(), i,
            clientport));
        }
    }
}
