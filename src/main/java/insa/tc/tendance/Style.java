package insa.tc.tendance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by Patrik on 05/06/2016.
 */
@Entity
public class Style {

    @Id
    @GeneratedValue
    private long id;

    public String style_name;

}
