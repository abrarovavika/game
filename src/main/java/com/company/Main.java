package com.company;

import acm.graphics.GObject;
import acm.graphics.GOval;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;


import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Main extends GraphicsProgram {
       private boolean clic=false;
       private GRect rect = new GRect(80, 80);
    private GRect rect1 = new GRect(80, 80);
public void  mousePressed(MouseEvent e){
    clic=!clic;
}

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode()==38&&rect1.getY()>0) {
                rect1.move(0, -20);
            }
            if (e.getKeyCode()==40&&rect1.getY()<getHeight()-150) {
                rect1.move(0, +20);
            }
            if (e.getKeyCode()==87) {
                rect.move(0, -20);
            }
            if (e.getKeyCode()==83) {
                rect.move(0, +20);
            }
        }
    public void run() {

        addKeyListeners();
        addMouseListeners();


        int x = getWidth();
        int y = getHeight();
        int vx = -10;
        int vy = 10;
        Color k = new Color((int) (Math.random() * 256));
        k = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
        GRect a =new GRect(1000,1000);
        a.setLocation(x/2-500,y/2-500);
        a.setColor(k);
        a.setFilled(true);
        a.setFillColor(k);
        add(a);
        GOval oval = new GOval(40, 40);
        oval.setLocation(x / 2 - 30, y / 2 - 70);
        oval.setColor(Color.black);
        oval.setFilled(true);
        oval.setFillColor(Color.black);
        add(oval);
        rect = new GRect(30, 150);
        rect.setLocation(x / 2 -350, y / 2 - 100);
        rect.setColor(Color.black);
        rect.setFilled(true);
        rect.setFillColor(Color.black);
        add(rect);
        rect1 = new GRect(30, 150);
        rect1.setLocation(x / 2 +320, y / 2 - 100);
        rect1.setColor(Color.black);
        rect1.setFilled(true);
        rect1.setFillColor(Color.black);
        add(rect1);

        while (true) {
            pause(1000 / 48);
            if (clic == true) {
                oval.move(vx, vy);
                k = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
                if (oval.getX() < 0) {
                    oval.setColor(k);
                    oval.setFilled(true);
                    oval.setFillColor(k);
                    vx = vx * (-1);
                }
                if (oval.getX() > x - 40) {
                    oval.setColor(k);
                    oval.setFilled(true);
                    oval.setFillColor(k);
                    vx = vx * (-1);
                }
                if (oval.getY() < 0) {
                    oval.setColor(k);
                    oval.setFilled(true);
                    oval.setFillColor(k);
                    vy = vy * (-1);
                }
                if (oval.getY() > y - 40) {
                    oval.setColor(k);
                    oval.setFilled(true);
                    oval.setFillColor(k);
                    vy = vy * (-1);
                }
                if (getElementAt(oval.getX(), oval.getY()) == rect ||
                        getElementAt(oval.getX() + 40, oval.getY() + 40) == rect ||
                        getElementAt(oval.getX() + 40, oval.getY()) == rect ||
                        getElementAt(oval.getX(), oval.getY() + 40) == rect) {
                    vy = vy * (-1);
                    vx = vx * (-1);

                }
                if (getElementAt(oval.getX(), oval.getY()) == rect1 ||
                        getElementAt(oval.getX() + 40, oval.getY() + 40) == rect1 ||
                        getElementAt(oval.getX() + 40, oval.getY()) == rect1 ||
                        getElementAt(oval.getX(), oval.getY() + 40) == rect1) {
                    vx = vx * (-1);
                    vy = vy * (-1);

                }
            }
        }
    }
    public static void main(String[] args) {
        new Main().start();
    }
}