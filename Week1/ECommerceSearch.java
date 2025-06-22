import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    Product(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return productId + " - " + productName + " (" + category + ")";
    }
}

public class ECommerceSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(targetName)) {
                return p;
            }
        }
        return null;
    }

    // Binary Search 
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);

            if (cmp == 0)
                return products[mid];
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shoes", "Fashion"),
            new Product(3, "Book", "Education"),
            new Product(4, "Mobile", "Electronics"),
            new Product(5, "Pen", "Stationery")
        };

        System.out.println("Linear Search Result:");
        Product result1 = linearSearch(products, "Mobile");
        System.out.println(result1 != null ? result1 : "Product not found");

        // Sort the array by product name for binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("\nBinary Search Result:");
        Product result2 = binarySearch(products, "Mobile");
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}
