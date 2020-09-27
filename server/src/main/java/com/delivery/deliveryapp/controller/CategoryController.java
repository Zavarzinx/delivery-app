package com.delivery.deliveryapp.controller;

import com.delivery.deliveryapp.entity.Category;
import com.delivery.deliveryapp.entity.Product;
import com.delivery.deliveryapp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryRepository.save(category), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Category categoryFromDB, @RequestBody Category category) {
        BeanUtils.copyProperties(category, categoryFromDB,"id");
        return new ResponseEntity<>(categoryRepository.save(categoryFromDB), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Category category) {
        categoryRepository.delete(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllProducts() {
        return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/{id}/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Category> addProductToCategory(@PathVariable("id") Category category, @RequestBody Product product) {
        category.getProducts().add(product);
        return new ResponseEntity<>(categoryRepository.save(category), HttpStatus.OK);
    }
    @PostMapping("/{id}/removeProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Category> removeProductFromCategory(@PathVariable("id") Category category, @RequestBody Product product) {
        category.getProducts().remove(product);
        return new ResponseEntity<>(categoryRepository.save(category), HttpStatus.OK);
    }

}
