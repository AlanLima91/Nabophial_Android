package nabophial.Network;

// import com.redevstudios.cineone.cineone.model.MoviePageResult;
import nabophial.Model.Status;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetStatusService {

    @GET("status")
    Call<Status> getStatus(@Query("page") int page, @Query("api_key") String userkey);

    //@GET("movie/top_rated")
    //Call<MoviePageResult> getTopRatedMovies(@Query("page") int page, @Query("api_key") String userkey);
}
