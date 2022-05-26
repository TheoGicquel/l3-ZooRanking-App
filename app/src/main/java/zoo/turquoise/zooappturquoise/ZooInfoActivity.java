package zoo.turquoise.zooappturquoise;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ZooInfoActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.zoo_infos_layout);

            try {
                ZooLoader.load("zooDB.json");
            } catch (IOException e) {
                e.printStackTrace();
            }

            ArrayList<Zoo> zoos = ZooLoader.getZoos();
            Log.d("TAG", "loading zoo info ");
            Zoo displayedZoo = zoos.get(ZooLoader.getSelectedZooRank());
            Log.d("TAG", displayedZoo.getName());
            Log.d("TAG", String.valueOf(displayedZoo.getScoreTreatment()));

            // Title and rank
            TextView zooNameText = findViewById(R.id.infoNameText);
            zooNameText.setText(displayedZoo.getName());
            TextView zooRankText = findViewById(R.id.infoRankNumber);
            String displayedRank= "#" + displayedZoo.getRank();
            zooRankText.setText(displayedRank);


            // reviews
            Button reviewButton = findViewById(R.id.reviewButton);

            TextView avgValueText = findViewById(R.id.infoAvgValue);
            avgValueText.setText(String.valueOf(displayedZoo.getScoreCustomers()));

            TextView reviewCountText = findViewById(R.id.infoReviewCountValue);
            reviewCountText.setText(String.valueOf(displayedZoo.getCountReviews()));


            // ratings
            TextView wellBeingText = findViewById(R.id.wellBeingRatingValue);
            wellBeingText.setText(String.valueOf(displayedZoo.getScoreTreatment()));
            ImageView wellBeingCircle = findViewById(R.id.wellBeingCircle);
            evalCircle(wellBeingCircle,displayedZoo.getScoreTreatment());

            TextView priceText = findViewById(R.id.priceRatingValue);
            priceText.setText(String.valueOf(displayedZoo.getScorePrice()));
            ImageView priceCircle = findViewById(R.id.priceCircle);
            evalCircle(priceCircle,displayedZoo.getScorePrice());


            TextView accessibilityText = findViewById(R.id.accessibilityRatingValue);
            accessibilityText.setText(String.valueOf(displayedZoo.getScoreAccess()));
            ImageView accessibilityCircle = findViewById(R.id.accessibilityCircle);
            evalCircle(accessibilityCircle,displayedZoo.getScoreAccess());


            TextView exotismText = findViewById(R.id.exotismRatingValue);
            exotismText.setText(String.valueOf(displayedZoo.getScoreDiversity()));
            ImageView exotismCircle = findViewById(R.id.exotismCircle);
            evalCircle(exotismCircle,displayedZoo.getScoreDiversity());

            // picture
            //ImageView zooDisplayPicture = findViewById(R.id.zooDisplayPicture);

            new DownloadImageFromInternet(findViewById(R.id.zooDisplayPicture)).execute(displayedZoo.getImageURL());



            // Description
            TextView descriptionText = findViewById(R.id.zooDescriptionText);
            descriptionText.setText(displayedZoo.getDescription());
            
            
        }

        // code from tutorialspoint
    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;
        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView=imageView;
            Toast.makeText(getApplicationContext(), "Récupération de l'image...",Toast.LENGTH_SHORT).show();
        }
        protected Bitmap doInBackground(String... urls) {
            String imageURL=urls[0];
            Bitmap bimage=null;
            try {
                InputStream in=new java.net.URL(imageURL).openStream();
                bimage=BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }

        public void zooPostReviewAction(View view) {
            // rate zoo here
        }

    public void switchToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    public void switchToRankingActivity(View view) {
        Intent intent = new Intent(this, RankingActivity.class);
        startActivity(intent);
        finish();

    }

    void evalCircle(ImageView image,int value)
    {
        if(value<=2){
            image.setImageResource(R.drawable.circle_red);
        }
        if(value<=5 && value>2)
        {
            image.setImageResource(R.drawable.circle_orange);
        }
        if(value>5 && value<8)
        {
            image.setImageResource(R.drawable.circle_yellow);
        }
        if(value>=8)
        {
            image.setImageResource(R.drawable.circle_green);
        }

    }




}

