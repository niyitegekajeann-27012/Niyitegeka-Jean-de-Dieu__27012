package com.restapi.controller.restaurant;

import com.restapi.model.restaurant.MenuItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    private List<MenuItem> menuItems = new ArrayList<>();
    private Long nextId = 9L;

    public MenuController() {
        menuItems.add(new MenuItem(1L, "Sambaza", "Fried small fish from Lake Kivu", 3000.0, "Appetizer", true));
        menuItems.add(new MenuItem(2L, "Isombe", "Cassava leaves with peanut sauce", 2500.0, "Appetizer", true));
        menuItems.add(new MenuItem(3L, "Brochettes", "Grilled meat skewers", 5000.0, "Main Course", true));
        menuItems.add(new MenuItem(4L, "Tilapia", "Grilled fish from Lake Kivu", 8000.0, "Main Course", false));
        menuItems.add(new MenuItem(5L, "Ugali with Beans", "Cornmeal with red beans", 2000.0, "Main Course", true));
        menuItems.add(new MenuItem(6L, "Mandazi", "Sweet fried dough", 1500.0, "Dessert", true));
        menuItems.add(new MenuItem(7L, "Banana Cake", "Traditional banana cake", 2000.0, "Dessert", true));
        menuItems.add(new MenuItem(8L, "Ikivuguto", "Traditional fermented milk", 1000.0, "Beverage", true));
    }

    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        return ResponseEntity.ok(menuItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long id) {
        return menuItems.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<MenuItem>> getItemsByCategory(@PathVariable String category) {
        List<MenuItem> result = menuItems.stream()
                .filter(m -> m.getCategory().equalsIgnoreCase(category))
                .toList();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/available")
    public ResponseEntity<List<MenuItem>> getAvailableItems(@RequestParam boolean available) {
        List<MenuItem> result = menuItems.stream()
                .filter(m -> m.isAvailable() == available)
                .toList();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public ResponseEntity<List<MenuItem>> searchByName(@RequestParam String name) {
        List<MenuItem> result = menuItems.stream()
                .filter(m -> m.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
        return result.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem) {
        menuItem.setId(nextId++);
        menuItems.add(menuItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(menuItem);
    }

    @PutMapping("/{id}/availability")
    public ResponseEntity<MenuItem> toggleAvailability(@PathVariable Long id) {
        for (MenuItem item : menuItems) {
            if (item.getId().equals(id)) {
                item.setAvailable(!item.isAvailable());
                return ResponseEntity.ok(item);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) {
        boolean removed = menuItems.removeIf(m -> m.getId().equals(id));
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
