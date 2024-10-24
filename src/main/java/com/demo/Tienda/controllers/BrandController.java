package com.demo.Tienda.controllers;

import com.demo.Tienda.entities.BrandEntity;
import com.demo.Tienda.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tienda/1.0/marcas")
public class BrandController {
    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<List<BrandEntity>> getBrands() {
        List<BrandEntity> brands = brandService.getAllBrands();
        return ResponseEntity.ok(brands);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandEntity> getBrand(@PathVariable UUID id) {
        Optional<BrandEntity> brand = brandService.getBrandById(id);
        return brand.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createBrand(@RequestBody BrandEntity brand) {
        UUID createBrandId = brandService.createBrand(brand);
        return ResponseEntity.created(URI.create("/tienda/1.0/brands/" + createBrandId)).body("Marca Creada Correctamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBrand(@PathVariable UUID id, @RequestBody BrandEntity brand) {
        Optional<BrandEntity> updateBrand = brandService.updateBrand(id, brand);
        return ResponseEntity.ok().body("Marca Actualizada Correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable UUID id) {
        brandService.deleteBrand(id);
        return ResponseEntity.ok().body("Marca Eliminada Correctamente");
    }
}
