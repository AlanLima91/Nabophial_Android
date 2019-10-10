package nabophial.Network;

import nabophial.Model.AuthToken;


import java.util.List;

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
    Call<AuthToken> login(@Field("email") String email,
                        @Field("plainPassword") String plainPassword);

}
