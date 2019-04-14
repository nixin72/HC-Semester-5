package com.example.phdum.pdumaresq_b51_a04;

import android.widget.Button;

class MatrixCoordinate {
    private Button button;
    private double value;
    private int coordX;
    private int coordY;

    public MatrixCoordinate(int x, int y, Button btn, double val) {
        button = btn;
        coordX = x;
        coordY = y;
        value = val;
    }

    public Button getEditText() {
        return button;
    }

    public double getValue() {
        return value;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

}