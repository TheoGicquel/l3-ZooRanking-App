package zoo.turquoise.zooappturquoise;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity {
    ArrayList<Zoo> zoos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);
        ZooLoader.setContext(this.getApplicationContext());
        zoos=ZooLoader.getZoos();
    }
  // 
    public void viewZooAction(View view)
    {
        switch (view.getId())
        {
            // yes, this is bad, but time is of the essence here..
            case R.id.zoo1:
                ZooLoader.setSelectedZoo(1);
                break;
            case R.id.zoo2:
                ZooLoader.setSelectedZoo(2);
                break;
            case R.id.zoo3:
                ZooLoader.setSelectedZoo(3);
                break;
            case R.id.zoo4:
                ZooLoader.setSelectedZoo(4);
                break;
            case R.id.zoo5:
                ZooLoader.setSelectedZoo(5);
                break;
            case R.id.zoo6:
                ZooLoader.setSelectedZoo(6);
                break;
            case R.id.zoo7:
                ZooLoader.setSelectedZoo(7);
                break;
        }
        switchToDetailsActivity();
    }

    public void switchToDetailsActivity() {
        Intent intent = new Intent(this, ZooInfoActivity.class);
        startActivity(intent);
        finish();
    }


    public void switchToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

}
