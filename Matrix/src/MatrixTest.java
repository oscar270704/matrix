
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatrixTest {

    Matrix myMatrix = new Matrix(2, 3, new double[] {10, 20, 30, 40, 50, 60});

    @Test
    void testConstructor() {
        assertEquals(2, myMatrix.getRows());
        assertEquals(3, myMatrix.getColumns());
        assertArrayEquals(new double[] {10, 20, 30, 40, 50, 60}, myMatrix.getElementsRowMajor());
        assertArrayEquals(new double[] {10, 40, 20, 50, 30, 60}, myMatrix.getElementsColumnMajor());
        assertArrayEquals(new double[][] {{10, 20, 30}, {40, 50, 60}}, myMatrix.getRowArray());
        assertEquals(60, myMatrix.getElement(1, 2));
    }

    @Test
    void testScaled() {
        Matrix scaledMatrix = myMatrix.scaled(10);
        assertEquals(2, scaledMatrix.getRows());
        assertEquals(3, scaledMatrix.getColumns());
        assertArrayEquals(new double[] {100, 200, 300, 400, 500, 600}, scaledMatrix.getElementsRowMajor());
    }

    @Test
    void testPlus() {
        Matrix som = myMatrix.plus(myMatrix);
        assertEquals(2, som.getRows());
        assertEquals(3, som.getColumns());
        assertArrayEquals(new double[] {20, 40, 60, 80, 100, 120}, som.getElementsRowMajor());
    }
}