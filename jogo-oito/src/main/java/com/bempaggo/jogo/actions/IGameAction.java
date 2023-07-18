package com.bempaggo.jogo.actions;

import java.awt.event.KeyEvent;
import java.util.function.IntConsumer;

public interface IGameAction {

    IGameAction random();

    void move(KeyEvent keyEvent);

    void vectorItems(IntConsumer consumer);

    boolean isFinished();
}
