package zoo.turquoise.zooappturquoise;

import android.content.Intent;
import android.view.Window;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.test);

        button.setOnClickListener(v -> openList());
    }

    public void openList() {
        Intent intent = new Intent(this, ListZoo.class);
        startActivity(intent);
    }
}