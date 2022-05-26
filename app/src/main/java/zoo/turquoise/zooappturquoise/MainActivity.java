package zoo.turquoise.zooappturquoise;

import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import static zoo.turquoise.zooappturquoise.ZooLoader.getZoos;

public class MainActivity extends AppCompatActivity{

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ZooLoader zl = new ZooLoader();
        zl.load("zooDB.json");

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

    public void openList() {
        Intent intent = new Intent(this, ListZoo.class);
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