package bdbt_project.SpringApplication.DAO;

import bdbt_project.SpringApplication.classes.Reklamy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReklamyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ReklamyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Reklamy> list() {
        String sql = "SELECT * FROM reklamy";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Reklamy.class));
    }

    public void save(Reklamy reklama) {
        // Implementacja wstawiania nowego wiersza do bazy
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("reklamy").usingColumns("ID_reklamy", "czas_trwania",
                "kanal_dystrybucji", "grupa_docelowa");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(reklama);
        insertActor.execute(param);
    }

    public Reklamy get(int ID_reklamy) {
        // Implementacja odczytywania danych z bazy
        Object[] args = {ID_reklamy};
        String sql = "SELECT * FROM reklamy WHERE ID_reklamy = " + args[0];
        Reklamy reklamy = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Reklamy.class));
        return reklamy;
    }

    public void update(Reklamy reklama) {
        // Implementacja aktualizacji danych
        String sql = "UPDATE reklamy SET czas_trwania=:czas_trwania, kanal_dystrybucji=:kanal_dystrybucji, grupa_docelowa=:grupa_docelowa WHERE ID_reklamy=:ID_reklamy";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(reklama);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int ID_reklamy) {
        // Implementacja usuwania rekordu o danym ID
        String sql = "DELETE FROM reklamy WHERE ID_reklamy = ?";
        jdbcTemplate.update(sql, ID_reklamy);
    }
}
