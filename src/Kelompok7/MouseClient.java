/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kelompok7;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;

/**
 *
 * @author choirulandriansyah
 */
public class MouseClient {
    public static void main(String[] args) throws AWTException {        
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        int x = (int) b.getX();
        int y = (int) b.getY();
        System.out.print(y + "jjjjjjjjj");
        System.out.print(x);
        Robot r = new Robot();
        r.mouseMove(x, y - 50);
    }
}
