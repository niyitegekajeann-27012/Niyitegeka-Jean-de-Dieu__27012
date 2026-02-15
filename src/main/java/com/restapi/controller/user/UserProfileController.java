package com.restapi.controller.user;

import com.restapi.model.user.ApiResponse;
import com.restapi.model.user.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {
    private List<UserProfile> users = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserProfile>>> getAllUsers() {
        return ResponseEntity.ok(new ApiResponse<>(true, "Users retrieved successfully", users));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserProfile>> getUserById(@PathVariable Long userId) {
        return users.stream()
                .filter(u -> u.getUserId().equals(userId))
                .findFirst()
                .map(user -> ResponseEntity.ok(new ApiResponse<>(true, "User found", user)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(false, "User not found", null)));
    }

    @GetMapping("/search/username")
    public ResponseEntity<ApiResponse<List<UserProfile>>> searchByUsername(@RequestParam String username) {
        List<UserProfile> result = users.stream()
                .filter(u -> u.getUsername().toLowerCase().contains(username.toLowerCase()))
                .toList();
        return ResponseEntity.ok(new ApiResponse<>(true, "Search completed", result));
    }

    @GetMapping("/search/country")
    public ResponseEntity<ApiResponse<List<UserProfile>>> searchByCountry(@RequestParam String country) {
        List<UserProfile> result = users.stream()
                .filter(u -> u.getCountry().equalsIgnoreCase(country))
                .toList();
        return ResponseEntity.ok(new ApiResponse<>(true, "Users from " + country + " retrieved", result));
    }

    @GetMapping("/search/age-range")
    public ResponseEntity<ApiResponse<List<UserProfile>>> searchByAgeRange(@RequestParam int min, @RequestParam int max) {
        List<UserProfile> result = users.stream()
                .filter(u -> u.getAge() >= min && u.getAge() <= max)
                .toList();
        return ResponseEntity.ok(new ApiResponse<>(true, "Users in age range retrieved", result));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserProfile>> createUser(@RequestBody UserProfile user) {
        user.setUserId(nextId++);
        users.add(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "User created successfully", user));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserProfile>> updateUser(@PathVariable Long userId, @RequestBody UserProfile updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equals(userId)) {
                updatedUser.setUserId(userId);
                users.set(i, updatedUser);
                return ResponseEntity.ok(new ApiResponse<>(true, "User updated successfully", updatedUser));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false, "User not found", null));
    }

    @PatchMapping("/{userId}/activate")
    public ResponseEntity<ApiResponse<UserProfile>> activateUser(@PathVariable Long userId) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                user.setActive(true);
                return ResponseEntity.ok(new ApiResponse<>(true, "User activated successfully", user));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false, "User not found", null));
    }

    @PatchMapping("/{userId}/deactivate")
    public ResponseEntity<ApiResponse<UserProfile>> deactivateUser(@PathVariable Long userId) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                user.setActive(false);
                return ResponseEntity.ok(new ApiResponse<>(true, "User deactivated successfully", user));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false, "User not found", null));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long userId) {
        boolean removed = users.removeIf(u -> u.getUserId().equals(userId));
        if (removed) {
            return ResponseEntity.ok(new ApiResponse<>(true, "User deleted successfully", null));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false, "User not found", null));
    }
}
