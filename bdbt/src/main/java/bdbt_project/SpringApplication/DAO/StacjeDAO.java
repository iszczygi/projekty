package bdbt_project.SpringApplication.DAO;

import bdbt_project.SpringApplication.classes.Stacje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StacjeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StacjeDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Stacje> list() {
        String sql = "SELECT * FROM stacje";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Stacje.class));
    }

    public void save(Stacje stacja) {
        // Implementacja wstawiania nowego wiersza do bazy
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("stacje").usingColumns("ID_stacji", "ilosc_pracownikow",
                "rodzaj_stacji", "czestotliwosc");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(stacja);
        insertActor.execute(param);
    }

    public Stacje get(int ID_stacji) {
        // Implementacja odczytywania danych z bazy
        Object[] args = {ID_stacji};
        String sql = "SELECT * FROM stacje WHERE ID_stacji = " + args[0];
        Stacje stacje = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Stacje.class));
        return stacje;
    }

    public void update(Stacje stacja) {
        // Implementacja aktualizacji danych
        String sql = "UPDATE stacje SET ilosc_pracownikow=:ilosc_pracownikow, rodzaj_stacji=:rodzaj_stacji, czestotliwosc=:czestotliwosc WHERE ID_stacji=:ID_stacji";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(stacja);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int ID_stacji) {
        // Implementacja usuwania rekordu o danym ID
        String sql = "DELETE FROM stacje WHERE ID_stacji = ?";
        jdbcTemplate.update(sql, ID_stacji);
    }
}
