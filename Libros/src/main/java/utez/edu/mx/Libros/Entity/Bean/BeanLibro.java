package utez.edu.mx.Libros.Entity.Bean;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Libro")



public class BeanLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column (name = "isbn")
    private int isbn;
    @Column(name = "nombreautor")
    private String nombreautor;
    @Column(name = "apellidoautor")
    private String apellidoautor;
    @Column(name = "paginas")
    private int paginas;
    @Column(name = "categoria")
    private String categoria;
    @Column (name = "fechapublicacion")
    private String fechapublicacion;
    @Column(name = "folio")
    private String folio;



}
