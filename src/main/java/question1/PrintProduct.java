package question1;

import java.text.DecimalFormat;

public class PrintProduct {

    public void printTotalProductSales(int total) {
        System.out.println("TOTAL PRODUCT SALES: " + total);
    }

    public void printAverageProductSales(double average) {
        DecimalFormat format = new DecimalFormat("0.##");
        System.out.println("AVERAGE PRODUCT SALES: " + format.format(average));
    }

    public void printMostPopularProduct(String product) {
        System.out.println("MOST POPULAR PRODUCT: " + product);
    }
}
