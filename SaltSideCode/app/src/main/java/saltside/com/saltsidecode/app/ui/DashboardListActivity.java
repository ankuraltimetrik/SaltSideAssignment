package saltside.com.saltsidecode.app.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import saltside.com.saltsidecode.R;
import saltside.com.saltsidecode.app.adapter.DashboardListAdapter;
import saltside.com.saltsidecode.app.model.ListModel;

public class DashboardListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_list);

        initUiComponents();
    }

    /**
     * initializing Ui componenets
     */
    private void initUiComponents() {
        mRecyclerView = (RecyclerView) findViewById(R.id.dashboard_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        List<ListModel> mListModelList = new ArrayList<ListModel>();

        for (int i = 0; i < 10; i++) {
            ListModel listModel = new ListModel();
            listModel.setTitle("title " + i);
            listModel.setDescription("descri[ption " + i);
            listModel.setImage("http://dummyimage.com/715x350/105B19/907ECC.png");

            mListModelList.add(listModel);
        }


        DashboardListAdapter mAdapter = new DashboardListAdapter(DashboardListActivity.this, mListModelList);
        mRecyclerView.setAdapter(mAdapter);
    }


}
