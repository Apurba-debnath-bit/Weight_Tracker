
package weightTrackerDao;


import java.util.ArrayList;
import org.hibernate.Session;
import weightTrackerUtil.weightTrackerUtil;
public class WeightTrackerDao<T> {

public Session session = weightTrackerUtil.getSessionFactory().openSession();

    public void save(T value) {
        session.beginTransaction();
        session.save(value);
        session.getTransaction().commit();
    }

    public void update(T value) {
        session.beginTransaction();
        session.update(value);
        session.getTransaction().commit();
    }

    public void delete(T value) {
        session.beginTransaction();
        session.delete(value);
        session.getTransaction().commit();
    }

    public T find(T value, int id) {
        return  (T) session.get(value.getClass(), id);
    }

    public ArrayList<T> getAll(T value) {
        return (ArrayList<T>) session.createCriteria(value.getClass()).list();
    }
    
}
