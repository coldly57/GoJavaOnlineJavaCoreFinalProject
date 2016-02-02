import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MatrixConstructorTest {

    private static double[][] expectedMatrix;
    private static double[] expectedMatrixIdentifier;
    private static int numberOfVariables;
    private static MatrixConstructor matrixConstructor;

    @BeforeClass
    public static void setUpClass() throws Exception {

        numberOfVariables = 4;
        expectedMatrix = new double[][]{
                {0, 1, 2, 3},
                {1, 2, 3, 4},
                {2, 3, 4, 5},
                {3, 4, 5, 6}
        };

        expectedMatrixIdentifier = new double[]{0, 2, 4, 6};

        matrixConstructor = new MatrixConstructor();
    }

    @Test(timeout = 3000)
    public void testSetValueToMatrix() throws Exception {

        for (int i = 0; i < numberOfVariables; i++){
            for (int j = 0; j < numberOfVariables; j++){
                matrixConstructor.setValueToMatrix(4, i, j, j + i);
            }
        }

        assertArrayEquals(expectedMatrix, matrixConstructor.getMatrix());
    }

    @Test(timeout = 3000)
    public void testSetValueToArray() throws Exception {

        for (int i = 0; i < numberOfVariables; i++){
            matrixConstructor.setValueToMatrixIdentifier(numberOfVariables, i, i * 2);
        }

        assertArrayEquals(expectedMatrixIdentifier, matrixConstructor.getMatrixIdentifier(), 0);
    }
}