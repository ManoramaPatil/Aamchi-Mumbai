package am.aamchiimumbai;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH=3500;
    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_DISPLAY_LENGTH);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
