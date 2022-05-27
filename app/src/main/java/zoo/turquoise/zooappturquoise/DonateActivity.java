package zoo.turquoise.zooappturquoise;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class DonateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate_layout);
    }

    public void switchToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    public void openSeaSheoherdSite(View view){
        gotoUrl("https://seashepherd.fr/");
    }

    public void openWWFSite(View view){
        gotoUrl("https://www.wwf.fr/sengager-ensemble/faire-un-don-ifi?reserved_code_origine=22IFISEAGOOG");
    }

    public void openASPASSite(View view){
        gotoUrl("https://www.aspas-nature.org/nous-soutenir/faire-un-don/");
    }

    public void openLPOSite(View view){
        gotoUrl("https://www.lpo.fr/");
    }

    // Ouvre un site internet grâce à l'url renseigné
    private void gotoUrl(String url){
        Uri uri=Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}
