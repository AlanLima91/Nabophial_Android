package nabophial.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthToken {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("user")
    @Expose
    private User user;

    /**
     * No args constructor for use in serialization
     *
     */
    public AuthToken() {
    }

    /**
     *
     * @param id
     * @param createdAt
     * @param value
     * @param user
     */
    public AuthToken(Integer id, String value, String createdAt, User user) {
        super();
        this.id = id;
        this.value = value;
        this.createdAt = createdAt;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}