public class MatrixConstructor {
    private double[][] matrix = null;
    private double[] matrixIdentifier = null;

    public void setValueToMatrix(int numberOfVariables, int row, int index, double value){
        if (this.matrix == null){
            this.matrix = new double[numberOfVariables][numberOfVariables];
        }
        this.matrix[row][index] = value;
    }

    public void setValueToArray(int numberOfVariables, int index, double value){
        if (this.matrixIdentifier == null){
            this.matrixIdentifier = new double[numberOfVariables];
        }
        this.matrixIdentifier[index] = value;
    }

    public double[][] getMatrix() {
        return this.matrix;
    }

    public double[] getMatrixIdentifier() {
        return matrixIdentifier;
    }
}
