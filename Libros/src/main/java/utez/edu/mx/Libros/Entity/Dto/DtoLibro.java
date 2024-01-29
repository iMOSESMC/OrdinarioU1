package utez.edu.mx.Libros.Entity.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DtoLibro {

    private Long id;
    private String nombre;
    private int isbn;
    private String nombreautor;
    private String apellidoautor;
    private int paginas;
    private String categoria;
    private String fechapublicacion;
    private String folio;


}
