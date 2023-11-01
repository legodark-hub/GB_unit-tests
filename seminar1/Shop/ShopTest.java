package seminar1.Shop;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ListAssert;

public class ShopTest {

    /*
     * 1. Напишите тесты, чтобы проверить, что магазин хранит верный список
     * продуктов (правильное количество продуктов, верное содержимое корзины).
     * 2. Напишите тесты для проверки корректности работы метода
     * getMostExpensiveProduct.
     * 3. Напишите тесты для проверки корректности работы метода sortProductsByPrice
     * (проверьте правильность сортировки).
     */

    public static void main(String[] args) {

        // Создаем продукты
        Product product1 = new Product();
        product1.setTitle("Product 1");
        product1.setCost(50);

        Product product2 = new Product();
        product2.setTitle("Product 2");
        product2.setCost(30);

        Product product3 = new Product();
        product3.setTitle("Product 3");
        product3.setCost(70);

        // Создаем магазин
        Shop shop = new Shop();
        shop.setProducts(List.of(product1, product2, product3));

        // Тест 1: Проверяем, что магазин хранит верный список продуктов
        ListAssert<Product> productAssert = Assertions.assertThat(shop.getProducts());
        productAssert.hasSize(3);
        productAssert.extracting(Product::getTitle).containsExactly("Product 1", "Product 2", "Product 3");

        // Тест 2: Проверяем корректность работы метода getMostExpensiveProduct
        Product mostExpensiveProduct = shop.getMostExpensiveProduct();
        Assertions.assertThat(mostExpensiveProduct).isNotNull();
        Assertions.assertThat(mostExpensiveProduct.getTitle()).isEqualTo("Product 3");

        // Тест 3: Проверяем корректность работы метода sortProductsByPrice
        List<Product> sortedProducts = shop.sortProductsByPrice();
        Assertions.assertThat(sortedProducts)
                .extracting(Product::getCost)
                .containsExactly(30, 50, 70);
    }

}