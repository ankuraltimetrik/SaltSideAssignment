package saltside.com.saltsidecode.app.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import saltside.com.saltsidecode.R;
import saltside.com.saltsidecode.app.model.DashboardModel;

/**
 * detail activity with description
 */
public class DashboardDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_detail);

        initUiComponenets();
    }

    /**
     * initializing ui components
     */
    private void initUiComponenets() {

        DashboardModel listModel = getIntent().getParcelableExtra("KEY");

//        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
//        collapsingToolbarLayout.setTitle(listModel.mTitle);
//        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        // setting and downloading image from url
        final ImageView image = (ImageView) findViewById(R.id.description_imageview);
        if (!TextUtils.isEmpty(listModel.image)) {
            Picasso.with(this).load(listModel.image).placeholder(R.mipmap.ic_launcher) // optional
                    .error(R.mipmap.ic_launcher).into(image);
        }
        // setting title
        TextView title = (TextView) findViewById(R.id.title_detail_textview);
        if (!TextUtils.isEmpty(listModel.title)) {
            title.setText(listModel.title);
        } else {
//show default text
        }

        // setting description
        TextView description = (TextView) findViewById(R.id.description_detail_textview);
        if (!TextUtils.isEmpty(listModel.description)) {
            description.setText(listModel.description);
        } else {
            // default text
        }
    }

}
