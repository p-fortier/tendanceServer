package insa.tc.tendance;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by Patrik on 05/06/2016.
 */

@Entity
public class Outfit {

    @Id
    @GeneratedValue
    private long id_outfit;

    private long owner;
    /*
    @ManyToMany(mappedBy = "composer")
    private Set<Clothe> items;
*/
    public Date date_creation;
    public Date date_usage;
    public String description;

    @ManyToOne
    private Style id_style;

    Outfit(){//JPAOnly
    }


}
