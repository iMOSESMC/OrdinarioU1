package utez.edu.mx.Libros.Entity.Dao;

import org.springframework.data.repository.CrudRepository;
import utez.edu.mx.Libros.Entity.Bean.BeanLibro;

public interface DaoLibro extends CrudRepository<BeanLibro, Long> {
}
