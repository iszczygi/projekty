package bdbt_project.SpringApplication.DAO;

import bdbt_project.SpringApplication.classes.Klienci;
import bdbt_project.SpringApplication.classes.Pracownicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PracownicyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Pracownicy pracownik) {
        // Implementacja wstawiania nowego wiersza do bazy
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pracownicy").usingColumns("ID_pracownika", "imie", "drugie_imie",
                "nazwisko", "data_urodzin", "zarobki", "pesel", "data_zatrudnienia", "stanowisko", "jezyk");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        insertActor.execute(param);
    }

    public List<Pracownicy> list() {
        String sql = "SELECT * FROM PRACOWNICY";
        List<Pracownicy> listPracownicy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return listPracownicy;
    }


    public Pracownicy get(int ID_pracownika) {
        // Implementacja odczytywania danych z bazy
        Object[] args = {ID_pracownika};
        String sql = "SELECT * FROM pracownicy WHERE ID_pracownika = " + args[0];
        Pracownicy pracownicy = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return pracownicy;
    }

    public void update(Pracownicy pracownik) {
        // Implementacja aktualizacji danych
        String sql = "UPDATE pracownicy SET imie=:imie, drugie_imie=:drugie_imie, nazwisko=:nazwisko," +
                "data_urodzin=:data_urodzin, zarobki=:zarobki, pesel=:PESEL," +
                "data_zatrudnienia=:data_zatrudnienia, stanowisko=:stanowisko WHERE ID_pracownika=:ID_pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int ID_pracownika) {
        // Implementacja usuwania rekordu o danym ID
        String sql = "DELETE FROM pracownicy WHERE ID_pracownika = ?";
        jdbcTemplate.update(sql, ID_pracownika);
    }
}
