package saltside.com.saltsidecode.app.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import saltside.com.saltsidecode.R;
import saltside.com.saltsidecode.app.adapter.DashboardListAdapter;
import saltside.com.saltsidecode.app.model.DashboardModel;
import saltside.com.saltsidecode.app.network.SaltSideAppi;
import saltside.com.saltsidecode.app.utility.RestConstant;

public class DashboardListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_list);

        gettingDataFromServer();

    }

    /**
     * getting data from server
     */
    private void gettingDataFromServer() {

        final ProgressDialog progress = new ProgressDialog(this);
        progress.setTitle(getString(R.string.please_wait));
        progress.setMessage(getString(R.string.loading_data));
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(false);
        progress.show();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(RestConstant.BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        SaltSideAppi saltSideAppi = restAdapter.create(SaltSideAppi.class);
        saltSideAppi.getTaskList(new Callback<List<DashboardModel>>() {

            @Override
            public void success(List<DashboardModel> dashboardModels, Response response) {
                if (RestConstant.SHOW_LOGS) {
                    System.out.println("repsonse success :" + response.getStatus());
                    System.out.println("Size  - - -" + dashboardModels.size());
                }
                initUiComponents(dashboardModels);

                progress.dismiss();
            }

            @Override
            public void failure(RetrofitError error) {
                if (RestConstant.SHOW_LOGS) {
                    System.out.println("repsonse error :" + error.getUrl());
                    System.out.println("repsonse error :" + error.getCause());
                }
                progress.dismiss();

                //TODO show alert

                Toast.makeText(DashboardListActivity.this, R.string.something_went_wrong, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * initializing Ui componenets
     *
     * @param dashboardModels
     */
    private void initUiComponents(List<DashboardModel> dashboardModels) {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.dashboard_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        DashboardListAdapter mAdapter = new DashboardListAdapter(DashboardListActivity.this, dashboardModels);
        mRecyclerView.setAdapter(mAdapter);
    }


}
