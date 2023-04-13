/**
 * @author : Gathsara
 * created : 4/13/2023 -- 10:34 AM
 **/

package lk.ijse.hostel.pos.util;

import lk.ijse.hostel.pos.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfiguration {

    private static SessionFactoryConfiguration sessionFactoryConfiguration;
    private SessionFactory sessionFactory;

    private SessionFactoryConfiguration() {
        Configuration configuration = new Configuration().configure().
                addAnnotatedClass(User.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactoryConfiguration getInstance() {
        return (sessionFactoryConfiguration == null) ?
                sessionFactoryConfiguration = new SessionFactoryConfiguration()
                : sessionFactoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

}
