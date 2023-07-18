package com.bempaggo.jogo.presenation;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public interface IView {
    void removeComponents();

    void show();

    void addActions(KeyListener listener);

    void addButton(final String label);

    void addButton(final String label, final ActionListener listener, final Font font);

    void showDialog(String s);
}
