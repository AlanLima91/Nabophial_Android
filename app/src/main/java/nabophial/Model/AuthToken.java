package nabophial.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthToken {

    @SerializedName("token")
    @Expose
    private String token;

    /**
     * @param token
     */
    public AuthToken(String token) {
        super();
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}