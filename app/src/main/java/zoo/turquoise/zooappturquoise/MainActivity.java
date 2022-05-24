package zoo.turquoise.zooappturquoise;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void switchToMapActivity(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
        finish();

    }

    public void switchToRankingActivity(View view) {
        Intent intent = new Intent(this, RankingActivity.class);
        startActivity(intent);
        finish();
    }


    public void switchToNewsActivity(View view) {
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
        finish();
    }


    public void switchToDonateActivity(View view) {
        Intent intent = new Intent(this, DonateActivity.class);
        startActivity(intent);
        finish();
    }


}