package com.bempaggo.jogo.actions.impl;

import com.bempaggo.jogo.actions.IGameAction;

import java.awt.event.KeyEvent;
import java.util.*;
import java.util.function.IntConsumer;

public class GameActionImpl implements IGameAction {

    private int columnEmptyItem;

    private int rowEmptyItem;

    private boolean finished = true;

    private final List<Integer> tabuleiro = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);

    private final Integer[][] vetorTabuleiro = new Integer[3][3];

    public GameActionImpl() {
        random();
    }

    public IGameAction random(){
        int row = 0;
        int column = 0;

        Collections.shuffle(tabuleiro);

        for(final int valor : tabuleiro) {
            vetorTabuleiro[row][column] = valor;

            if(valor == 0) {
                savePositionEmptyItem(row, column);
            }

            if(column == 2) {
                row++;
                column=0;
            } else {
                column++;
            }

        }

        return this;
    }

    private void savePositionEmptyItem(int row, int column) {
        columnEmptyItem = column;
        rowEmptyItem = row;
    }

    @Override
    public void vectorItems(final IntConsumer consumer) {
        int count= 1;
        finished =true;
        for (final Integer[] row: vetorTabuleiro) {
            for (final Integer column : row) {
                consumer.accept(column);
                if(column != count % 9) {
                    finished = false;
                }
                count++;
            }
        }
    }

    public boolean isFinished() {
        return finished;
    }

    @Override
    public void move(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP     -> calcMovement(1, 0);
            case KeyEvent.VK_DOWN   -> calcMovement(-1, 0);
            case KeyEvent.VK_LEFT   -> calcMovement(0, 1);
            case KeyEvent.VK_RIGHT  -> calcMovement(0, -1);
            default -> calcMovement(0,0);
        }
    }


     private void calcMovement(int x, int y) {
        final int newRow = rowEmptyItem + x;
        final int newColumn = columnEmptyItem + y;

        if(newRow > 2 || newRow < 0 ||  newColumn > 2 || newColumn < 0) {
            return;
        }

        vetorTabuleiro[rowEmptyItem][columnEmptyItem] = vetorTabuleiro[newRow][newColumn];
        vetorTabuleiro[newRow][newColumn] = 0;

        savePositionEmptyItem(newRow, newColumn);
    }

}
