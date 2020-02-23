package com.company;

import acm.graphics.GLabel;
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
    public void  mousePressed(MouseEvent e){
        clic=!clic;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==37) {
            rect.move(-20,0);
        }
        if (e.getKeyCode()==39) {
            rect.move(+20,0);
        }
    }
    public void run() {

        addKeyListeners();
        addMouseListeners();


        int x = getWidth();
        int y = getHeight();
        int vy1 = 9;
        int vy = 10;
        Color k = new Color((int) (Math.random() * 256));
        k = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));

        GRect a = new GRect(1000, 1000);
        a.setLocation(x / 2 - 500, y / 2 - 500);
        a.setColor(k);
        a.setFilled(true);
        a.setFillColor(k);
        add(a);
        GLabel l=new GLabel("Game over");
        l.setLocation(x/2,y/2);
        l.setFont("Comic Sans-64");
        GOval oval = new GOval(40, 40);
        oval.setLocation(Math.random() * x, y / 2 - 250);
        oval.setColor(Color.black);
        oval.setFilled(true);
        oval.setFillColor(Color.black);
        add(oval);
        rect = new GRect(150, 30);
        rect.setLocation(x / 2 - 75, y / 2 + 100);
        rect.setColor(Color.black);
        rect.setFilled(true);
        rect.setFillColor(Color.black);
        add(rect);
        GRect rect1 = new GRect(40, 40);
        rect1.setLocation(Math.random() * x, y / 2 - 250);
        rect1.setColor(Color.black);
        rect1.setFilled(true);
        rect1.setFillColor(Color.black);
        add(rect1);
        while (true) {
            pause(1000 / 48);
            if (clic == true) {
                oval.move(0, vy);
                k = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
                if (oval.getX() < 0) {
                    oval.setColor(k);
                    oval.setFilled(true);
                    oval.setFillColor(k);
                    oval.setLocation(Math.random() * x, y / 2 - 250);
                }
                if (oval.getX() > x - 40) {
                    oval.setColor(k);
                    oval.setFilled(true);
                    oval.setFillColor(k);
                    oval.setLocation(Math.random() * x, y / 2 - 250);
                }
                if (oval.getY() > y - 40) {
                    oval.setColor(k);
                    oval.setFilled(true);
                    oval.setFillColor(k);
                    oval.setLocation(Math.random() * x, y / 2 - 250);
                }
                if (getElementAt(oval.getX(), oval.getY()) == rect ||
                        getElementAt(oval.getX() + 40, oval.getY() + 40) == rect ||
                        getElementAt(oval.getX() + 40, oval.getY()) == rect ||
                        getElementAt(oval.getX(), oval.getY() + 40) == rect) {
                    oval.setColor(k);
                    oval.setFilled(true);
                    oval.setFillColor(k);
                    oval.setLocation(Math.random() * x, y / 2 - 250);

                }
                rect1.move(0, vy1);
                if (rect1.getX() < 0) {
                    rect1.setColor(k);
                    rect1.setFilled(true);
                    rect1.setFillColor(k);
                    rect1.setLocation(Math.random() * x, y / 2 - 250);
                }
                if (rect1.getX() > x - 40) {
                    rect1.setColor(k);
                    rect1.setFilled(true);
                    rect1.setFillColor(k);
                    rect1.setLocation(Math.random() * x, y / 2 - 250);
                }
                if (rect1.getY() > y - 40) {
                    rect1.setColor(k);
                    rect1.setFilled(true);
                    rect1.setFillColor(k);
                    rect1.setLocation(Math.random() * x, y / 2 - 250);
                }
                if (getElementAt(rect1.getX(), rect1.getY()) == rect ||
                        getElementAt(rect1.getX() + 50, rect1.getY() + 50) == rect ||
                        getElementAt(rect1.getX() + 50, rect1.getY()) == rect ||
                        getElementAt(rect1.getX(), rect1.getY() + 50) == rect) {
                    rect1.setFilled(true);
                    rect1.setFillColor(k);
                    rect1.setLocation(Math.random() * x, y / 2 - 250);
                    l.setLocation(x/2-150,y/2);
                    add(l);
                }
            }
        }
    }
    public static void main(String[] args) {
        new Main().start();
    }
}