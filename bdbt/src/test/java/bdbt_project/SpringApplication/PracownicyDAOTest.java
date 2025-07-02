package bdbt_project.SpringApplication;

import bdbt_project.SpringApplication.DAO.PracownicyDAO;
import bdbt_project.SpringApplication.classes.Pracownicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracownicyDAOTest {
    private PracownicyDAO dao;
    @BeforeEach
    void setUp() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        dataSource.setUsername("BDBTGRC08");
        dataSource.setPassword("bdbtgrc08");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new PracownicyDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void testList() {
        List<Pracownicy> listPracownicy = dao.list();
        System.out.println(listPracownicy.isEmpty());
        System.out.println(listPracownicy);
        assertFalse(listPracownicy.isEmpty());
    }

}

