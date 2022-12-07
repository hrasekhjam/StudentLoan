package org.example.repository;


import org.example.entity.Students;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

public class StudentRepository extends BaseRepository<Students>{
    public StudentRepository() {
        super("Students",Students.class );
    }
    public Students getStudents(String username) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select s from Students s where s.userName=:username")
                .setParameter("username", username);
        List<Students> list = query.list();
        session.close();
        if (list.isEmpty())
            return null;

        return list.get(0);
    }
}
