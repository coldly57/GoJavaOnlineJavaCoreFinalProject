public class GaussMethod {

    private double[][] matrix;
    private double[] matrixIdentifier;
    private double[] results;

    public GaussMethod(double[][] matrix, double[] matrixIdentifier){
        this.matrix = matrix;
        this.matrixIdentifier = matrixIdentifier;
    }

    // Calculates system of linear equations using Gauss method
    public void calculateGauss() {
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            // Searching the main element in the column
            int mainElement = row;
            for (int i = row + 1; i < n; i++) {
                if (Math.abs(matrix[mainElement][row]) < Math.abs(matrix[i][row])) {
                    mainElement = i;
                }
            }
            // Moving row with main element to the top
            double[] tempRow = matrix[row];
            matrix[row] = matrix[mainElement];
            matrix[mainElement] = tempRow;
            // Moving values of matrixIdentifier in correspondence with rows movements
            double temp = matrixIdentifier[row];
            matrixIdentifier[row] = matrixIdentifier[mainElement];
            matrixIdentifier[mainElement] = temp;
            // Calculating multipliers and matrix
            for (int i = row + 1; i < n; i++) {
                matrix[row][i] /= matrix[row][row];
            }
            matrixIdentifier[row] /= matrix[row][row];
            for (int i = 0; i < n; i++) {
                double x = matrix[i][row];
                if (i != row && x != 0) {
                    for (int j = row + 1; j < n; j++)
                        matrix[i][j] -= matrix[row][j] * x;
                    matrixIdentifier[i] -= matrixIdentifier[row] * x;
                }
            }
        }
        this.results = matrixIdentifier;
    }

    public double[] getResults() {
        return results;
    }
}
