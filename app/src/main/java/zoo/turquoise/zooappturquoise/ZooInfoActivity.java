package zoo.turquoise.zooappturquoise;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import org.w3c.dom.Text;

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
            Button reviewButton = findViewById(R.id.reviewFinalizeButton);

            TextView avgValueLabel = findViewById(R.id.infoAvgLabel);
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

            // review displaying
            TextView userReviewText = findViewById(R.id.userReviewText);
            TextView userReviewLabel = findViewById(R.id.userReviewTextLabel);
            TextView reviewCountLabel = findViewById(R.id.infoReviewCountLabel);
            EditText postReviewField = findViewById(R.id.postReviewField);
            Boolean wantsToPostReview;
            Button userSetPresenceButton = findViewById(R.id.userSetPresenceButton);
            reviewButton.setVisibility(View.GONE);

            if(displayedZoo.isVisited())
            {
                userReviewText.setVisibility(View.VISIBLE);
                reviewCountLabel.setVisibility(View.VISIBLE);
                userSetPresenceButton.setVisibility(View.GONE);
                postReviewField.setVisibility(View.GONE);
                userReviewText.setText(displayedZoo.getUserReview());

            }else
            {
                avgValueLabel.setVisibility(View.INVISIBLE);
                userReviewLabel.setVisibility(View.GONE);
                userReviewText.setVisibility(View.GONE);
                reviewCountLabel.setVisibility(View.GONE);
                reviewCountText.setVisibility(View.GONE);
                postReviewField.setVisibility(View.GONE);
                avgValueText.setVisibility(View.GONE);

            }
            
        }

    public void zooSetPresenceAction(View view) {
        TextView userReviewText = findViewById(R.id.userReviewText);
        TextView userReviewLabel = findViewById(R.id.userReviewTextLabel);
        TextView reviewCountLabel = findViewById(R.id.infoReviewCountLabel);
        EditText postReviewField = findViewById(R.id.postReviewField);
        Button reviewFinalizeButton = findViewById(R.id.reviewFinalizeButton);
        Boolean wantsToPostReview;
        Button userSetPresenceButton = findViewById(R.id.userSetPresenceButton);
        reviewFinalizeButton.setVisibility(View.VISIBLE);
        userReviewLabel.setVisibility(View.VISIBLE);
        Button finalizeReview = findViewById(R.id.reviewFinalizeButton);
        finalizeReview.setVisibility(View.VISIBLE);
        userSetPresenceButton.setVisibility(View.GONE);
        postReviewField.setVisibility(View.VISIBLE);
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


            TextView userReviewText = findViewById(R.id.userReviewText);
            TextView userReviewLabel = findViewById(R.id.userReviewTextLabel);
            TextView reviewCountLabel = findViewById(R.id.infoReviewCountLabel);
            EditText postReviewField = findViewById(R.id.postReviewField);
            Button reviewFinalizeButton = findViewById(R.id.reviewFinalizeButton);
            Boolean wantsToPostReview;
            Button userSetPresenceButton = findViewById(R.id.userSetPresenceButton);
            Button finalizeReview = findViewById(R.id.reviewFinalizeButton);
            userReviewText.setVisibility(View.GONE);
            reviewCountLabel.setVisibility(View.VISIBLE);
            userSetPresenceButton.setVisibility(View.GONE);
            postReviewField.setVisibility(View.GONE);
            finalizeReview.setVisibility(View.GONE);


            userReviewText.setVisibility(View.VISIBLE);
            userSetPresenceButton.setVisibility(View.GONE);
            postReviewField.setVisibility(View.GONE);

            TextView avgValueLabel = findViewById(R.id.infoAvgLabel);
            TextView avgValueText = findViewById(R.id.infoAvgValue);
            avgValueText.setVisibility(View.VISIBLE);
            avgValueLabel.setVisibility(View.VISIBLE);
            TextView reviewCountText = findViewById(R.id.infoReviewCountValue);
            reviewCountText.setVisibility(View.VISIBLE);

            ArrayList<Zoo> zoos = new ArrayList<Zoo>();
            zoos = ZooLoader.getZoos();
            Zoo selectedZoo = zoos.get(ZooLoader.getSelectedZooRank());
            selectedZoo.setVisited(true);
            selectedZoo.setReview(String.valueOf(postReviewField.getText()));
            userReviewText.setText(selectedZoo.getUserReview());

            // TODO : save updated zoo data in json file (see TODOs in ZooLoader.java)
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

