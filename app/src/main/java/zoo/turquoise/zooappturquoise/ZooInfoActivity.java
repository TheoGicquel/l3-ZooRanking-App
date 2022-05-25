package zoo.turquoise.zooappturquoise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

    public class ZooInfoActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.zoo_info_layout);
        }

        public void zooPostReviewAction(View view) {
            // rate zoo here
        }

    }

