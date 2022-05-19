package zoo.turquoise.zooappturquoise;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
public class ListZoo extends AppCompatActivity {

    private Boolean boolRech = false;
    private Button retour;
    private Button find;
    private EditText findZoo;
    private TextView text;
    private ListView listZoo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listzoo);

        text=(TextView)findViewById(R.id.text);

        findZoo=(EditText) findViewById(R.id.textRecherche);

        retour = (Button) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagePrecedente();
            }
        });

        find = (Button) findViewById(R.id.chercher);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chercheZoo();
            }
        });

        listZoo = (ListView) findViewById(R.id.listZoo);
        listZoo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                zoo();
            }
        });
    }

    public void pagePrecedente(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void chercheZoo(){
        if(boolRech) {
            text.setVisibility(View.VISIBLE);
            findZoo.setVisibility(View.GONE);
            boolRech = false;
        }else{
            text.setVisibility(View.GONE);
            findZoo.setVisibility(View.VISIBLE);
            boolRech=true;
        }
    }

    public void zoo(){
        // Ouvrir la page correspondant au zoo sélectionné
    }
}
