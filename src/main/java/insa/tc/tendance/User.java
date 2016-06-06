package insa.tc.tendance;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

/**
 * Created by Patrik on 05/06/2016.
 */

@Entity
public class User {
    @JsonBackReference
    @OneToMany(mappedBy = "owner")
    private List<Clothe> clothes;


    @JsonBackReference
    @ManyToMany
    @JoinTable(
    joinColumns=@JoinColumn(name="user_a"),
    inverseJoinColumns=@JoinColumn(name="user_b"))
    private List<User> friends;

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

    @JsonBackReference
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

    public List<User> getFriends() {
        return friends;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setSexe(boolean sexe) {
        this.sexe = sexe;
    }

    public void setPrivate_profil(boolean private_profil) {
        this.private_profil = private_profil;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(Date age) {
        this.age = age;
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
