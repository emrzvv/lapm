package main;

import java.util.Scanner;

public class Matrix {
    private int[][] data;
    int lines, columns;

    public Matrix(int m, int n) {
        this.lines = m;
        this.columns = n;
        this.data = new int[lines][columns];
    }

    public void fillMatrixFromKeyboard(Scanner s) {
        for (int i = 0; i < this.lines; ++i) {
            for (int j = 0; j < this.columns; ++j) {
                this.data[i][j] = s.nextInt();
            }
        }
    }

    public void fillMatrixFromArray(int[] a) {
        if (a.length == this.lines * this.columns) {
            for (int i = 0; i < this.lines; ++i) {
                for (int j = 0; j < this.columns; ++j) {
                    this.data[i][j] = a[i * j];
                }
            }
        }
    }

    public Matrix add(Matrix m) {
        if (m.lines == this.lines && m.columns == this.columns) {
            Matrix result = new Matrix(this.lines, this.columns);
            for (int i = 0; i < this.lines; ++i) {
                for (int j = 0; j < this.lines; ++j) {
                    result.data[i][j] = this.data[i][j] + m.data[i][j];
                }
            }
            return result;
        }
        else {
            return null;
        }
    }

    public Matrix multiply(Matrix m) {
        if (this.columns == m.lines) {
            int resultLines = this.lines;
            int resultColumns = m.columns;
            Matrix result = new Matrix(resultLines, resultColumns);
            for (int i = 0; i < resultLines; ++i) {
                for (int j = 0; j < resultColumns; ++j) {
                    // i-я строка на j-й столбец
                    for (int k = 0; k < this.columns; ++k) {
                        result.data[i][j] += (this.data[i][k] * m.data[k][j]);
                    }
                }
            }
            return result;
        }
        else {
            return null;
        }
    }

    public void displayMatrix() {
        for (int i = 0; i < this.lines; ++i) {
            for (int j = 0; j < this.columns; ++j) {
                System.out.print(this.data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
