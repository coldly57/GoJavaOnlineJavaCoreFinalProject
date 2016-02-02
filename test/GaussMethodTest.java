import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GaussMethodTest {

    private static GaussMethod gaussMethod1;
    private static GaussMethod gaussMethod2;
    private static GaussMethod gaussMethod3;
    private static double[] results1;
    private static double[] results2;
    private static double[] results3;

    @BeforeClass
    public static void setUpClass() throws Exception {

        double[][] matrix1 = {
                {2, 4},
                {4, 2}
        };
        double[] matrix1Identifier = {10, 20};
        results1 = new double[]{5, 0};

        gaussMethod1 = new GaussMethod(matrix1, matrix1Identifier);

        double[][] matrix2 = {
                {2, 3, -1},
                {1, -2, 1},
                {1, 0, 2}
        };
        double[] matrix2Identifier = {9, 3, 2};
        results2 = new double[]{4, 0, -1};

        gaussMethod2 = new GaussMethod(matrix2, matrix2Identifier);

        double[][] matrix3 = {
                {3, 3, 6, 3},
                {3, 1, 5, 1},
                {2, 1, 4, 2},
                {1, 3, 3, 2}
        };
        double[] matrix3Identifier = {6, 2, 1, 6};
        results3 = new double[]{3, 3, -2, 0};

        gaussMethod3 = new GaussMethod(matrix3, matrix3Identifier);

    }

    @Test(timeout = 3000)
    public void testCalculateGauss() throws Exception {

        gaussMethod1.calculateGauss();
        gaussMethod2.calculateGauss();
        gaussMethod3.calculateGauss();

        assertArrayEquals(results1, gaussMethod1.getResults(), 0);
        assertArrayEquals(results2, gaussMethod2.getResults(), 0);
        assertArrayEquals(results3, gaussMethod3.getResults(), 0);
    }
}