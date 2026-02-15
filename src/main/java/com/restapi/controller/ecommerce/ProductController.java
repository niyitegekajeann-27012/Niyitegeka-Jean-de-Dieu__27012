package com.restapi.controller.ecommerce;

import com.restapi.model.ecommerce.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 11L;

    public ProductController() {
        products.add(new Product(1L, "Itel A70", "Affordable smartphone", 150000.0, "Electronics", 50, "Itel"));
        products.add(new Product(2L, "Tecno Spark 10", "Budget Android phone", 180000.0, "Electronics", 30, "Tecno"));
        products.add(new Product(3L, "HP Laptop", "Core i5 laptop for students", 650000.0, "Electronics", 20, "HP"));
        products.add(new Product(4L, "Bata Shoes", "Comfortable walking shoes", 25000.0, "Footwear", 100, "Bata"));
        products.add(new Product(5L, "Sport Shoes", "Running shoes", 35000.0, "Footwear", 80, "Local Brand"));
        products.add(new Product(6L, "Wireless Earphones", "Bluetooth earphones", 15000.0, "Electronics", 0, "Generic"));
        products.add(new Product(7L, "Kitenge Fabric", "Traditional African fabric", 12000.0, "Clothing", 150, "Local"));
        products.add(new Product(8L, "Digital Camera", "Photography camera", 450000.0, "Electronics", 15, "Canon"));
        products.add(new Product(9L, "T-Shirt", "Cotton t-shirt", 8000.0, "Clothing", 200, "Local Brand"));
        products.add(new Product(10L, "Computer Monitor", "24 inch LED monitor", 180000.0, "Electronics", 45, "Dell"));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) Integer page, 
                                                         @RequestParam(required = false) Integer limit) {
        if (page != null && limit != null) {
            int start = page * limit;
            int end = Math.min(start + limit, products.size());
            if (start >= products.size()) return ResponseEntity.ok(new ArrayList<>());
            return ResponseEntity.ok(products.subList(start, end));
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        return products.stream()
                .filter(p -> p.getProductId().equals(productId))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
        List<Product> result = products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .toList();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> getProductsByBrand(@PathVariable String brand) {
        List<Product> result = products.stream()
                .filter(p -> p.getBrand().equalsIgnoreCase(brand))
                .toList();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {
        List<Product> result = products.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                           p.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<Product>> getProductsByPriceRange(@RequestParam Double min, @RequestParam Double max) {
        List<Product> result = products.stream()
                .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                .toList();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/in-stock")
    public ResponseEntity<List<Product>> getInStockProducts() {
        List<Product> result = products.stream()
                .filter(p -> p.getStockQuantity() > 0)
                .toList();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        product.setProductId(nextId++);
        products.add(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(productId)) {
                updatedProduct.setProductId(productId);
                products.set(i, updatedProduct);
                return ResponseEntity.ok(updatedProduct);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{productId}/stock")
    public ResponseEntity<Product> updateStock(@PathVariable Long productId, @RequestParam int quantity) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                product.setStockQuantity(quantity);
                return ResponseEntity.ok(product);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        boolean removed = products.removeIf(p -> p.getProductId().equals(productId));
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
