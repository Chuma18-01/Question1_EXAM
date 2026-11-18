package question1;

public class Product implements IProducts {

    private final String[] productNames;
    private final int[][] monthlySales;

    public Product(String[] productNames, int[][] monthlySales) {
        this.productNames = productNames;
        this.monthlySales = monthlySales;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;

        for (int[] productSales : monthlySales) {
            total += totalForProduct(productSales);
        }

        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int numberOfEntries = 0;

        for (int[] productSales : monthlySales) {
            numberOfEntries += productSales.length;
        }

        return (double) GetTotalProductsSold() / numberOfEntries;
    }

    @Override
    public String GetMostPopularProduct() {
        int mostPopularIndex = 0;
        int highestTotal = totalForProduct(monthlySales[0]);

        for (int index = 1; index < monthlySales.length; index++) {
            int productTotal = totalForProduct(monthlySales[index]);

            if (productTotal > highestTotal) {
                highestTotal = productTotal;
                mostPopularIndex = index;
            }
        }

        return productNames[mostPopularIndex] + " (" + highestTotal + ")";
    }

    private int totalForProduct(int[] productSales) {
        int total = 0;

        for (int sales : productSales) {
            total += sales;
        }

        return total;
    }
}
