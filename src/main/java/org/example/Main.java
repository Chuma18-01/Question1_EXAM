package question1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] productNames = {
                "Cozy Nights Monarch",
                "Restonic Barbados",
                "Sealy Phuket"
        };

        int numberOfMonths = 3;
        int[][] monthlySales = new int[productNames.length][numberOfMonths];

        try (Scanner scanner = new Scanner(System.in)) {
            for (int product = 0; product < productNames.length; product++) {
                for (int month = 0; month < numberOfMonths; month++) {
                    System.out.printf(
                            "Enter number of sales for month %d for %s mattress: ",
                            month + 1, productNames[product]
                    );
                    monthlySales[product][month] = readSales(scanner);
                }
                System.out.println();
            }
        }

        IProducts product = new Product(productNames, monthlySales);
        PrintProduct report = new PrintProduct();

        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("****************************************");
        report.printTotalProductSales(product.GetTotalProductsSold());
        report.printAverageProductSales(product.GetAverageProductSold());
        report.printMostPopularProduct(product.GetMostPopularProduct());
    }

    private static int readSales(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int sales = scanner.nextInt();

                if (sales >= 0) {
                    return sales;
                }
            } else {
                scanner.next();
            }

            System.out.print("Please enter a whole number of zero or more: ");
        }
    }
}