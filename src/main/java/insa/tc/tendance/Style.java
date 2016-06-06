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

    private String style_name;

    public Style(String style_name) {
        this.style_name = style_name;
    }

    public String getStyle_name() {
        return style_name;
    }

    Style(){//JPA ONLY
    }
}
