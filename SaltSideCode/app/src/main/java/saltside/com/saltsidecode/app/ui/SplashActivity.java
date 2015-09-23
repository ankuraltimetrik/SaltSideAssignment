package saltside.com.saltsidecode.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import saltside.com.saltsidecode.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initiUiComponents();

    }

    /**
     * showing the splash screen for 2 sec
     */
    private void initiUiComponents() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this, DashboardListActivity.class);
                startActivity(intent);
                finish();
            }
//            }
        }, 2000);
    }

}
