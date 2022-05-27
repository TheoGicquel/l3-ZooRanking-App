package zoo.turquoise.zooappturquoise;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import zoo.turquoise.zooappturquoise.Zoo.*;

import java.io.IOException;
import java.util.ArrayList;


public class RankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ranking_layout);

        ListView zooListView = (ListView) findViewById(R.id.ZooListView);

        ZooLoader.setContext(this.getApplicationContext());

        try {
            ZooLoader.load("zooDB.json");
        } catch (IOException e) {
            Log.d("TAG", e.getMessage());
            e.printStackTrace();
        }

        ArrayList<Zoo> loczoos = new ArrayList<Zoo>();
        loczoos = ZooLoader.getZoos();

        ArrayList<String> zooListStrings = new ArrayList<>();
        Log.d("TAG", "size");
        Log.d("TAG", String.valueOf(ZooLoader.getZoos().size()));
        Log.d("TAG", String.valueOf(loczoos.size()));

        try {
            String name = "?";
            int rank=0;
            String zooDisplayedText;
            for (Zoo zoo : loczoos) {


                name = zoo.getName();
                rank = zoo.getRank();
                Log.d("TAG", name);
                Log.d("TAG", String.valueOf(rank));
                zooDisplayedText = "#" + rank + "  " + name;
                zooListStrings.add(zooDisplayedText);
            }




        }catch (Exception e)
        {
            Log.d("TAG", "forLoop");
            Log.d("TAG", e.getMessage());

        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,zooListStrings);
        zooListView.setAdapter(adapter);

        zooListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int chosenZooRankId = position;

                Log.d("TAG", "click !");
                Log.d("TAG", String.valueOf(position));
                Log.d("TAG", String.valueOf(id));
                ZooLoader.setSelectedZoo(chosenZooRankId);
                switchToDetailsActivity();
            }

        });
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

    public void searchAction(View view)
    {
        TextView topBarTitle = findViewById(R.id.rankingTopBarTitle);
        EditText searchField = findViewById(R.id.searchZooField);
        topBarTitle.setVisibility(View.GONE);
        searchField.setVisibility(View.VISIBLE);
    }


}
