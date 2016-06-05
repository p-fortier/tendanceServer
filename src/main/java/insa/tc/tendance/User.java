package insa.tc.tendance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Patrik on 05/06/2016.
 */

@Entity
public class User {

    @OneToMany(mappedBy = "owner")
    private List<Clothe> clothes;

    //friends

    @OneToMany(mappedBy = "owner")
    private List<Outfit> outfits;

    private String email;
    private String username;
    private String bio;
    private Date age;
    private boolean sexe;
    private boolean private_profil;

    @Id
    @GeneratedValue
    private long id;

    public List<Clothe> getMyClothes(){
        return clothes;
    }

    public long getId(){
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getBio() {
        return bio;
    }

    public Date getAge() {
        return age;
    }

    public boolean isSexe() {
        return sexe;
    }

    public boolean isPrivate_profil() {
        return private_profil;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    public String password;

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    User(){ //JPA ONLY
    }
}
