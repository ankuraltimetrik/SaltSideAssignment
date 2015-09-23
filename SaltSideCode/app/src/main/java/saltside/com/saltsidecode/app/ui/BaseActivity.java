package saltside.com.saltsidecode.app.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import saltside.com.saltsidecode.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

}
