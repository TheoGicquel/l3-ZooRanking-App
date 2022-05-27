package zoo.turquoise.zooappturquoise;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_layout);

        NewsArticle new1 = new NewsArticle("Droit des animaux : Si l’éléphante Happy devenait une personne morale, ça changerait quoi ?", "https://www.20minutes.fr/societe/3296363-20220524-droit-animaux-si-elephante-happy-devenait-personne-morale-ca-changerait-quoi");
        NewsArticle new2 = new NewsArticle("Marseille : Un trafiquant d’espèces protégées condamné à six mois ferme", "https://www.20minutes.fr/justice/3294283-20220520-marseille-trafiquant-especes-protegees-condamne-six-mois-ferme");
        NewsArticle new3 = new NewsArticle("Gironde : Un faucon opéré avec succès dans le nouveau centre de chirurgie de la LPO","https://www.20minutes.fr/planete/3284955-20220506-gironde-faucon-opere-succes-nouveau-centre-chirurgie-lpo");
        NewsArticle[] listNew = new NewsArticle[]{new1,new2, new3};

        ListView listViewNew = (ListView) findViewById(R.id.listNews);

        listViewNew.setAdapter(new ArrayAdapter<NewsArticle>(this, android.R.layout.simple_list_item_1, listNew));
        listViewNew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Uri uri=Uri.parse(listNew[i].getUrl());
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });
    }
    public void switchToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

}
