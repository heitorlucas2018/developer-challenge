package com.bempaggo.jogo;

import com.bempaggo.jogo.listeners.KeyListenerImpl;
import com.bempaggo.jogo.presenation.IView;
import com.bempaggo.jogo.actions.IGameAction;
import com.bempaggo.jogo.actions.impl.GameActionImpl;
import com.bempaggo.jogo.presenation.IViewImpl;


public class GameApplication {

    private static final String NAME_APPLICATION = "Jogo dos Oito";

    private static final int WIDTH_AND_HEIGHT = 300;

    protected static void start() {
        final IGameAction action = new GameActionImpl();
        final KeyListenerImpl keyListenerImpl = new KeyListenerImpl();
        final IView view = new IViewImpl(NAME_APPLICATION, WIDTH_AND_HEIGHT, WIDTH_AND_HEIGHT);

        view.addActions(keyListenerImpl);

        keyListenerImpl.event(action::move);
        keyListenerImpl.beforeEvent(() -> handlerComponentsView(view, action));

        handlerComponentsView(view, action);
    }

    private static void handlerComponentsView(final IView view, final IGameAction action) {
        view.removeComponents();
        action.vectorItems(item -> view.addButton(String.valueOf(item)));

        view.addButton("Reiniciar", e -> {
            action.random();
            handlerComponentsView(view, action);
        }, null);

        if(action.isFinished()) {
            view.showDialog("Parabéns, você venceu!");
        }

        view.show();

    }

    public static void main(String[] str) {
        GameApplication.start();
    }
}
