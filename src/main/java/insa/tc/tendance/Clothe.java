package insa.tc.tendance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.net.URI;

/**
 * Created by Patrik on 05/06/2016.
 */
@Entity
public class Clothe {

    @Id
    @GeneratedValue
    private long clothe_id;

    @JsonIgnore
    private long owner;

    Clothe(){//JPA Only
    }

    public Clothe(String clothe_photo, long owner) {
        this.clothe_photo = clothe_photo;
        this.owner = owner;
    }

    public String clothe_photo;



}
