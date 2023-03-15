package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Car;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.openSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCars() {
        TypedQuery<Car> query = sessionFactory.openSession().createQuery("from Car");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCarsLimitedByQuantity(int quantity) {
        TypedQuery<Car> query = sessionFactory.openSession().createQuery("from Car");
        query.setMaxResults(quantity);
        return query.getResultList();
    }
}
