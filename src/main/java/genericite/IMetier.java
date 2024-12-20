package genericite;

import java.util.List;

public interface IMetier<T> {
    void add(T o);
    T findById(long id);
    List<T> getAll();
    void delete(long id);
}
