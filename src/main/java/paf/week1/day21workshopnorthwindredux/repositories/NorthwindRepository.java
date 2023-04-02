package paf.week1.day21workshopnorthwindredux.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NorthwindRepository extends BasicCrud{

    @Autowired
    private JdbcTemplate template;
    
}
