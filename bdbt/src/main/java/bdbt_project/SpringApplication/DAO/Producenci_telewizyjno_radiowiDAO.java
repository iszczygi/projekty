package bdbt_project.SpringApplication.DAO;

import bdbt_project.SpringApplication.classes.Producenci_telewizyjno_radiowi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class Producenci_telewizyjno_radiowiDAO {


    @Autowired
    /* Import org.springframework.jd....Template */
    private JdbcTemplate jdbcTemplate;

    public Producenci_telewizyjno_radiowiDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */ /*(zawiera info z bazy danych)*/
    public List<Producenci_telewizyjno_radiowi> list(){
        String sql = "SELECT * FROM producenci_telewizyjno_radiowi";

        List<Producenci_telewizyjno_radiowi> listProducenci_radiowo_telewizyjni = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Producenci_telewizyjno_radiowi.class));

        return listProducenci_radiowo_telewizyjni;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Producenci_telewizyjno_radiowi producenci_telewizyjno_radiowi) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("producenci_telewizyjno_radiowi").usingColumns("ID_producenta", "nazwa",
                "data_zalozenia", "NIP", "KRS");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(producenci_telewizyjno_radiowi);
        insertActor.execute(param);
    }

    /* Read – odczytywanie danych z bazy */
    public Producenci_telewizyjno_radiowi get(int ID_producenta) {
        Object[] args = {ID_producenta};
        String sql = "SELECT * FROM producenci_telewizyjno_radiowi WHERE ID_producenta = " + args[0];
        Producenci_telewizyjno_radiowi producenci_telewizyjno_radiowi = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Producenci_telewizyjno_radiowi.class));
        return producenci_telewizyjno_radiowi;
    }
    /* Update – aktualizacja danych */
    public void update(Producenci_telewizyjno_radiowi producenci_telewizyjno_radiowi) {
        String sql = "UPDATE producenci_telewizyjno_radiowi SET nazwa=:nazwa, data_zalozenia=:data_zalozenia, NIP=:NIP, KRS=:KRS WHERE ID_producenta=:ID_producenta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(producenci_telewizyjno_radiowi);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int ID_producenta) {
        String sql = "DELETE FROM producenci_telewizyjno_radiowi WHERE ID_producenta = ?";
        jdbcTemplate.update(sql, ID_producenta);
    }


}
