package nabophial.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("lastname")
    @Expose
    private String lastname;

    @SerializedName("firstname")
    @Expose
    private String firstname;

    @SerializedName("birthday")
    @Expose
    private String birthday;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("number")
    @Expose
    private Object number;

    @SerializedName("gender")
    @Expose
    private Boolean gender;

    @SerializedName("preference")
    @Expose
    private List<Sport> preference = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public User() {
    }

    /**
     *
     * @param id
     * @param birthday
     * @param preference
     * @param email
     * @param gender
     * @param lastname
     * @param number
     * @param firstname
     */
    public User(Integer id, String lastname, String firstname, String birthday, String email, Object number, Boolean gender, List<Sport> preference) {
        super();
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthday = birthday;
        this.email = email;
        this.number = number;
        this.gender = gender;
        this.preference = preference;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getNumber() {
        return number;
    }

    public void setNumber(Object number) {
        this.number = number;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public List<Sport> getPreference() {
        return preference;
    }

    public void setPreference(List<Sport> preference) {
        this.preference = preference;
    }

}