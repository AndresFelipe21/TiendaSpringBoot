package com.demo.Tienda.respositories;

//Se llaman las librerias necesarias
import com.demo.Tienda.entities.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;


public interface ProductsRepository extends JpaRepository<ProductsEntity, UUID> { //Se crea una herencia con ProductsEntity

}
