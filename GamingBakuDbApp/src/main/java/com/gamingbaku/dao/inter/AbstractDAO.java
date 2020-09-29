package com.gamingbaku.dao.inter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDAO {

    public Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/gamingbaku?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "12345";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }

    private static EntityManagerFactory emf = null;

    public EntityManager em() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("gamingbakuapp");
        }
        EntityManager entitymanager = emf.createEntityManager();
        return entitymanager;
    }

    public void closeEmf() {
        emf.close(); //entitymanagerfactory-ni baglamag hem de entitymanageri baglamag demekdir
    }
}
