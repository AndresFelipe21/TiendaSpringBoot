package com.demo.Tienda.entities;

//Importacion de librerias necesarias
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data // Me genera los metodos Getter and Setter automaticamente
@NoArgsConstructor // Me genera constructor sin argumentos
@AllArgsConstructor // Me genera constructor con todos los parametros de la clase

//Declaracion de la clase que representa la entidad de un cliente
public class CustomerEntity {
    private UUID id; //Identificador unico de un cliente
    private String nombre; //Atributo que representa el nombre del cliente
    private String email; //Atributo que representa el email del cliente
}
