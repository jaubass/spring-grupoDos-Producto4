package com.grupoDos.JavaBackendProject.controller;

import com.grupoDos.JavaBackendProject.model.MenuItem;
import com.grupoDos.JavaBackendProject.model.OrderItem;
import com.grupoDos.JavaBackendProject.service.MenuItemService;
import com.grupoDos.JavaBackendProject.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController {

    private final MenuItemService menuItemService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping("/")
    public List<MenuItem> getAllMenuItems() {
        return menuItemService.findAll();
    }

    @PostMapping("/")
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemService.save(menuItem);
    }

    @PutMapping("/{id}")
    public MenuItem updateMenuItem(@PathVariable Long id, @RequestBody MenuItem updatedMenuItem) {
        MenuItem menuItem = menuItemService.findById(id);
        if (menuItem == null) {
            throw new ResourceNotFoundException("MenuItem not found with id: " + id);
        }

        // Actualizar los atributos del ítem del menú con los valores de updatedMenuItem
        menuItem.setName(updatedMenuItem.getName());
        menuItem.setDescription(updatedMenuItem.getDescription());
        menuItem.setPrice(updatedMenuItem.getPrice());
        menuItem.setCategory(updatedMenuItem.getCategory());
        menuItem.setRestaurant(updatedMenuItem.getRestaurant());

        return menuItemService.save(menuItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMenuItem(@PathVariable Long id) {
        MenuItem menuItem = menuItemService.findById(id);
        if (menuItem == null) {
            throw new ResourceNotFoundException("MenuItem not found with id: " + id);
        }

        menuItemService.delete(menuItem);

        return ResponseEntity.ok().build();
    }
}
