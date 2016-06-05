package insa.tc.tendance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Patrik on 05/06/2016.
 */

@Entity
public class Type {

    @Id
    @GeneratedValue
    private long id;

    private String type_name;
}
