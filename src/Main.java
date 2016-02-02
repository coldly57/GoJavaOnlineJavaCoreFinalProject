import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    /**
     * Carries information that user must input to make calculation
     * @param matrixConstructor is a MatrixConstruct class instance that carries matrix of variables multipliers and array of equation results
     */
    private void userInput(MatrixConstructor matrixConstructor){
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter number of variables (must be integer, more than 1 and equal to number of linear equations):");

        int numberOfVariables = 0;

        try {
            numberOfVariables = sc.nextInt();
            if (numberOfVariables <= 1){
                throw new InputMismatchException();
            }
        }
        catch (InputMismatchException e){
            System.out.println("You have entered incorrect value. Please try again");
            userInput(matrixConstructor);
        }
        for (int i = 1; i <= numberOfVariables; i++){
            System.out.format("Equation #%d:%n", i);
            for (int j = 1; j <= numberOfVariables; j++){
                System.out.format("Please enter multiplier of X%d%n", j);
                double multiplier = getCorrectValue();
                matrixConstructor.setValueToMatrix(numberOfVariables, i - 1, j - 1, multiplier);
            }
            System.out.println("Please enter the result of equation:");
            double res = getCorrectValue();
            matrixConstructor.setValueToMatrixIdentifier(numberOfVariables, i - 1, res);
        }
    }

    // Checks if user has entered correct number and repeats input if not
    private double getCorrectValue(){

        Scanner sc = new Scanner(System.in);

        double value;

        try {
            value = sc.nextDouble();
        }
        catch (InputMismatchException e){
            System.out.println("You have entered incorrect value. Please try again");
            value = getCorrectValue();
        }

        return value;
    }

    /**
     * Prints calculation results to the console
     * @param results is results of calculation
     */
    private void printResults(double[] results){

        System.out.println("Solution:");
        for (double value : results) {
            if (!Double.isFinite(value)) {
                System.out.println("Current system of linear equations has no solution or its solution is not a number");
                return;
            }
        }
        for (int i = 1; i < results.length + 1; i++){
            System.out.format(Locale.US, "X%d = %.2f%n", i, results[i - 1]);
        }
    }

    public static void main(String[] args) {

        MatrixConstructor matrixConstructor = new MatrixConstructor();

        new Main().userInput(matrixConstructor);

        GaussMethod gaussMethod = new GaussMethod(matrixConstructor.getMatrix(), matrixConstructor.getMatrixIdentifier());
        gaussMethod.calculateGauss();

        new Main().printResults(gaussMethod.getResults());
    }
}
