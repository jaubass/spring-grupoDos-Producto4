package com.grupodos.producto4.controller;

import com.grupodos.producto4.model.MenuItem;
import com.grupodos.producto4.repository.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
// @RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuItemController {

    // private final MenuItemRepository items;

    // @GetMapping("")
    // public ResponseEntity<List<MenuItem>> all() {
    //     return ok(this.items.findAll());
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity<MenuItem> get(@PathVariable("id") Long id) {
    //     return ok(this.items.findById(id).orElseThrow(() -> new VehicleNotFoundException()));
    // }

}
