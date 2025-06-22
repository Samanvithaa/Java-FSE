public class FinancialForecasting {
  public static double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
    return predictFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static double predictFutureValueIterative(double currentValue, double growthRate, int years) {
        for (int i = 0; i < years; i++) {
            currentValue *= (1 + growthRate);
        }
        return currentValue;
    }

    public static void main(String[] args) {
        double initialValue = 10000;      
        double growthRate = 0.05;         
        int years = 10;                   

        double resultRecursive = predictFutureValue(initialValue, growthRate, years);
        double resultIterative = predictFutureValueIterative(initialValue, growthRate, years);

        System.out.printf("Future Value (Recursive): %.2f%n", resultRecursive);
        System.out.printf("Future Value (Iterative): %.2f%n", resultIterative);
    }
}
