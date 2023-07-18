package com.bempaggo.jogo.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Consumer;

public class KeyListenerImpl implements KeyListener {

    private Consumer<KeyEvent> eventConsumer;

    private Runnable runnerBeforeEvent;

    public void event(final Consumer<KeyEvent> consumer) {
        this.eventConsumer = consumer;
    }

    public void beforeEvent(final Runnable consumer) {
        this.runnerBeforeEvent = consumer;
    }

    @Override
    public void keyPressed(KeyEvent e) {
       this.eventConsumer.accept(e);
       runnerBeforeEvent.run();
    }

    @Override
    //NOSONAR
    public void keyReleased(KeyEvent e) {}
    
    @Override
    //NOSONAR
    public void keyTyped(KeyEvent e) {}

}
