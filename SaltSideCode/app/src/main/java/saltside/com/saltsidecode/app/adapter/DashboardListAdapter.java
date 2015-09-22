package saltside.com.saltsidecode.app.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import saltside.com.saltsidecode.R;
import saltside.com.saltsidecode.app.model.ListModel;
import saltside.com.saltsidecode.app.ui.DashboardDetailActivity;

/**
 * Created by Agoel on 22-09-2015.
 */
public class DashboardListAdapter extends RecyclerView.Adapter<DashboardListAdapter.ListViewHolder> {

    //activity context for adapter
    private final Context mContext;
    // beneficiary list List
    private List<ListModel> mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public DashboardListAdapter(Context context, List<ListModel> myDataset) {

        mDataset = myDataset;
        mContext = context;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ListViewHolder vh = new ListViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ListViewHolder listViewHolder, int position) {
// - get element from your dataset at this position
        // - replace the contents of the view with that element
        final ListModel listModel = mDataset.get(position);

        if (!TextUtils.isEmpty(listModel.getTitle())) {
            listViewHolder.titleTextView.setText(listModel.getTitle());
        } else {
            listViewHolder.titleTextView.setText("Name");
        }
        if (!TextUtils.isEmpty(listModel.getDescription())) {
            listViewHolder.descriptionTextView.setText(listModel.getDescription());
        } else {
            listViewHolder.descriptionTextView.setText("Name");
        }
        if (!TextUtils.isEmpty(listModel.getImage())) {
            Picasso.with(mContext)
                    .load(listModel.getImage())
                    .placeholder(R.mipmap.ic_launcher) // optional
                    .error(R.mipmap.ic_launcher)         // optional
                    .resize(120, 120)
                    .into(listViewHolder.itemImageView);
        } else {
            //TODO default image
        }


        listViewHolder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Clicked ", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, DashboardDetailActivity.class);
                intent.putExtra("KEY", listModel);
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    /**
     * view holder
     */
    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView descriptionTextView;
        ImageView itemImageView;
        RelativeLayout mainLayout;

        public ListViewHolder(View view) {
            super(view);

            mainLayout = (RelativeLayout) view.findViewById(R.id.main_layout);
            itemImageView = (ImageView) view.findViewById(R.id.listimage_imageview);
            titleTextView = (TextView) view.findViewById(R.id.title_textView);
            descriptionTextView = (TextView) view.findViewById(R.id.description_textView);
        }
    }
}
