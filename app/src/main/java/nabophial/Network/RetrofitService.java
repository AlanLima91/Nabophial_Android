package nabophial.Network;

import nabophial.Model.Session;


import java.util.List;

import nabophial.Model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Header;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

public interface RetrofitService {
    
	@POST("/login")
    @FormUrlEncoded
    Call<Session> login(@Field("email") String email,
                        @Field("plainPassword") String plainPassword);

	@POST("/signup")
    @FormUrlEncoded
    Call<User> signup(@Field("email") String email,
                      @Field("plainPassword") String plainPassword,
                      @Field("firstName") String firstName,
                      @Field("lastName") String lastName);

}
