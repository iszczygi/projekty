package bdbt_project.SpringApplication.DAO;

import bdbt_project.SpringApplication.classes.Klienci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KlienciDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public KlienciDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klienci> list() {
        String sql = "SELECT * FROM klienci";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klienci.class));
    }

    public void save(Klienci klient) {
        // Implementacja wstawiania nowego wiersza do bazy
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("klienci").usingColumns("ID_klienta", "nazwa", "Wycena_umowy",
                "liczba_reklam", "data_zawarcia", "data_zakonczenia", "nr_telefonu", "nip", "adres_email");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        insertActor.execute(param);
    }

    public Klienci get(int ID_klienta) {
        // Implementacja odczytywania danych z bazy
        Object[] args = {ID_klienta};
        String sql = "SELECT * FROM klienci WHERE ID_klienta = " + args[0];
        Klienci klienci = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Klienci.class));
        return klienci;
    }

    public void update(Klienci klient) {
        // Implementacja aktualizacji danych
        String sql = "UPDATE klienci SET nazwa=:nazwa, Wycena_umowy=:Wycena_umowy, liczba_reklam=:liczba_reklam," +
                "data_zawarcia=:data_zawarcia, data_zakonczenia=:data_zakonczenia, nr_telefonu=:nr_telefonu," +
                "nip=:NIP, adres_email=:adres_email WHERE ID_klienta=:ID_klienta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int ID_klienta) {
        // Implementacja usuwania rekordu o danym ID
        String sql = "DELETE FROM klienci WHERE ID_klienta = ?";
        jdbcTemplate.update(sql, ID_klienta);
    }
}
