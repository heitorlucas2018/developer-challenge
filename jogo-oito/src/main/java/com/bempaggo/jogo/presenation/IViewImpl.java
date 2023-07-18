package com.bempaggo.jogo.presenation;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class IViewImpl implements IView {

    private final JFrame frame = new JFrame();

    private final Font fontText = new Font("Arial",Font.BOLD, 36);


    public IViewImpl(final String title, final int width, final int heigth ) {
        frame.setTitle(title);
        frame.setSize(width, heigth);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 3));
    }

    public void addButton(final String label) {
       addButton(label, null, fontText);
    }

    public void addButton(final String label, final ActionListener listener, final Font font) {

        final var btnName = label.equals("0") ? "" : label;
        final var button = new JButton(btnName);
        button.setFont(font);
        button.setVisible(true);
        button.addActionListener(listener);
        frame.add(button);
    }

    @Override
    public void showDialog(final String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public void removeComponents() {
        if(frame.getContentPane().getComponentCount() > 0) {
            frame.getContentPane().removeAll();
        }
    }

    public void addActions(KeyListener listener) {
        frame.addKeyListener(listener);
    }

    public void show() {
        frame.setFocusable(true);
        frame.setVisible(true);
    }

}
