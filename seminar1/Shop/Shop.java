package seminar1.Shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        List<Product> sortedProducts = new ArrayList<>(products);
        sortedProducts.sort(Comparator.comparing(Product::getCost));
        return sortedProducts;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        if (products.isEmpty()) {
            return null;
        }
        Product mostExpensive = products.get(0);
        for (Product product : products) {
            if (product.getCost() > mostExpensive.getCost()) {
                mostExpensive = product;
            }
        }
        return mostExpensive;
    }

}