package br.com.georg.bookstore.service;

import br.com.georg.bookstore.products.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Dashboard {

    private Bookstore bookstore;
    private HashMap<String, Integer> productQuantityDashboard;

    private HashMap<String, BigDecimal> productValueDashboard;

    public Dashboard(Bookstore bookstore) {
        this.bookstore = bookstore;
        productQuantityDashboard = DashboardTools.initializeProductQuantityDashboard();
        productValueDashboard = DashboardTools.initializeProductValueDashboard();
    }

    public void recieveProductData(Product product, String category) {
        productQuantityDashboard.put(category, productQuantityDashboard.get(category) + product.getQuantity());
        productValueDashboard.put(category, productValueDashboard.get(category).add(product.getValueOfItemStack()));
    }

    public void recieveSaleData(Order order) {
        List<Product> items = order.getItems();
        items.stream().forEach(product -> {
            productQuantityDashboard.put(product.getCategory(), productQuantityDashboard.get(product.getCategory()) - product.getQuantity());
            productValueDashboard.put(product.getCategory(), productValueDashboard.get(product.getCategory()).subtract(product.getValueOfItemStack()));
        });
    }

    public HashMap<String, Integer> getProductQuantityDashboard() {
        return productQuantityDashboard;
    }

    public HashMap<String, BigDecimal> getProductValueDashboard() {
        return productValueDashboard;
    }

    private static class DashboardTools {
        private static HashMap<String, Integer> initializeProductQuantityDashboard() {
            var productDashboard = new HashMap<String, Integer>();
            Arrays.stream(Product.getCategoriesArray()).forEach(category -> productDashboard.put(category, 0));
            return productDashboard;
        }

        private static HashMap<String, BigDecimal> initializeProductValueDashboard() {
            var productDashboard = new HashMap<String, BigDecimal>();
            Arrays.stream(Product.getCategoriesArray()).forEach(category -> productDashboard.put(category, BigDecimal.valueOf(0)));
            return productDashboard;
        }
    }

}
