package saltside.com.saltsidecode.app.network;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import saltside.com.saltsidecode.app.model.DashboardModel;

/**
 * Created by Agoel on 23-09-2015.
 */
public interface SaltSideAppi {
    /**
     * @param callback
     */
    /*GET LIST*/

    @GET("/items.json") //a function in your api to get all the list
    public void getTaskList(Callback<List<DashboardModel>> callback); //

}
