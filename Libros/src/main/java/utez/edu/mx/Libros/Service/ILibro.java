package utez.edu.mx.Libros.Service;

import utez.edu.mx.Libros.Entity.Bean.BeanLibro;
import utez.edu.mx.Libros.Entity.Dto.DtoLibro;

import java.util.List;

public interface ILibro{

    BeanLibro save (DtoLibro libros);

    BeanLibro findById(Long id);

    List <BeanLibro> findAll();

    public void delete (BeanLibro libros);





}

