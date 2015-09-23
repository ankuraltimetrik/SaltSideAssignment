package saltside.com.saltsidecode.app.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Agoel on 23-09-2015.
 */
public class DashboardModel implements Parcelable {

    public String image;
    public String title;
    public String description;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image);
        dest.writeString(title);
        dest.writeString(description);
    }

    protected DashboardModel(Parcel in) {
        image = in.readString();
        title = in.readString();
        description = in.readString();
    }

    public static final Creator<DashboardModel> CREATOR = new Creator<DashboardModel>() {
        @Override
        public DashboardModel createFromParcel(Parcel in) {
            return new DashboardModel(in);
        }

        @Override
        public DashboardModel[] newArray(int size) {
            return new DashboardModel[size];
        }
    };
}
