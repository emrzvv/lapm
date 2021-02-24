package main;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    public Matrix a = new Matrix(2, 2);
    public Matrix b = new Matrix(2, 2);
    public Matrix c = new Matrix(3, 3);
    public Matrix d = new Matrix(3, 1);

    boolean compareMatrices(Matrix a, Matrix b) {
        if (a.lines == b.lines && a.columns == b.columns) {
            for (int i = 0; i < a.lines; ++i) {
                for (int j = 0; j < a.columns; ++j) {
                    if (a.data[i][j] != b.data[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    void initMatrices() {
        a.fillMatrixFromArray(new int[] {1, 2, 3, 4});
        b.fillMatrixFromArray(new int[] {1, 1, 1, 1});
        c.fillMatrixFromArray(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        d.fillMatrixFromArray(new int[] {9, 9, 9});
    }

    @Test
    void add() {
        initMatrices();
        Matrix result_ab = a.add(b);
        Matrix trueResult_ab = new Matrix(a.lines, a.columns);
        trueResult_ab.fillMatrixFromArray(new int [] {2, 3, 4, 5});
        assertTrue(compareMatrices(result_ab, trueResult_ab));
        assertNull(b.add(c));
    }

    @Test
    void multiply() {
        initMatrices();

        Matrix result_ab = a.multiply(b);
        Matrix trueResult_ab = new Matrix(a.lines, b.columns);
        trueResult_ab.fillMatrixFromArray(new int[] {3, 3, 7, 7});
        assertTrue(compareMatrices(result_ab, trueResult_ab));

        Matrix result_cd = c.multiply(d);
        Matrix trueResult_cd = new Matrix(c.lines, d.columns);
        trueResult_cd.fillMatrixFromArray(new int[] {54, 135, 216});
        assertTrue(compareMatrices(result_cd, trueResult_cd));

        assertNull(a.multiply(c));
    }
}