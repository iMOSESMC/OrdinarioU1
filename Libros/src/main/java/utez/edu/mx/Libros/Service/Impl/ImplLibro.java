package utez.edu.mx.Libros.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Libros.Entity.Bean.BeanLibro;
import utez.edu.mx.Libros.Entity.Dao.DaoLibro;
import utez.edu.mx.Libros.Entity.Dto.DtoLibro;
import utez.edu.mx.Libros.Service.ILibro;

import java.util.List;
import java.util.Random;

@Service
public class ImplLibro implements ILibro {

    @Autowired
    DaoLibro daoLibro;

    @Override
    @Transactional
    public BeanLibro save(DtoLibro libros) {
        String folio = generateFolio(libros.getNombre(), libros.getNombreautor(), libros.getApellidoautor(), libros.getFechapublicacion(), String.valueOf(libros.getIsbn()));

        BeanLibro beanLibro = BeanLibro.builder()
                .id(libros.getId())
                .nombre(libros.getNombre())
                .isbn(libros.getIsbn())
                .nombreautor(libros.getNombreautor())
                .apellidoautor(libros.getApellidoautor())
                .paginas(libros.getPaginas())
                .categoria(libros.getCategoria())
                .fechapublicacion(libros.getFechapublicacion())
                .folio(folio)
                .build();

        return daoLibro.save(beanLibro);
    }

    @Override
    @Transactional(readOnly = true)
    public BeanLibro findById(Long id) {
        return daoLibro.findById(id).get();
    }

    @Override
    public List<BeanLibro> findAll() {
        return (List<BeanLibro>) daoLibro.findAll();
    }

    @Override
    @Transactional
    public void delete(BeanLibro libros) {
        daoLibro.delete(libros);
    }

    private String generateFolio(String nombre, String nombreAutor, String apellidoAutor, String fechaPublicacion, String isbn) {
        // Obtener las partes necesarias del folio
        String primeraLetraTitulo = String.valueOf(nombre.charAt(0));
        String primeraLetraAutor = String.valueOf(nombreAutor.charAt(0));
        String primerasDosLetrasApellido = apellidoAutor.substring(0, Math.min(apellidoAutor.length(), 2));
        String fechaPublicacionStr = fechaPublicacion.substring(0,Math.min(fechaPublicacion.length(), 4));
        String primerasCuatroLetrasIsbn = isbn.substring(0, Math.min(isbn.length(), 4));
        String randomChars = generateRandomChars(2);

        String folio = primeraLetraTitulo + primeraLetraAutor + primerasDosLetrasApellido + fechaPublicacionStr + primerasCuatroLetrasIsbn + randomChars;

        return folio;
    }

    private String generateRandomChars(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = new Random().nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }

        return sb.toString();
    }
}