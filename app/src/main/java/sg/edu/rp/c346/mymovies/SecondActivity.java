package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by 16020267 on 23/7/2018.
 */

public class SecondActivity extends AppCompatActivity {
    TextView tvTitle;
    TextView tvYr_genre;
    TextView tvDesc;
    TextView tvWatched;
    TextView tvTheatre;
    ImageView ivImg;
    RatingBar rbRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        tvTitle = findViewById(R.id.textViewTitle);
        tvYr_genre = findViewById(R.id.textViewGenre);
        tvDesc = findViewById(R.id.textViewDescription);
        tvWatched = findViewById(R.id.textViewWatched);
        tvTheatre = findViewById(R.id.textViewTheatre);
        ivImg = findViewById(R.id.imageViewRating);
        rbRating = findViewById(R.id.ratingBar);

        Intent intentReceived = getIntent();

        Movie listItem = (Movie) intentReceived.getSerializableExtra("listitemselected");

        tvTitle.setText(listItem.getTitle());
        tvYr_genre.setText(listItem.getYear() + " - " + listItem.getGenre());
        tvDesc.setText(listItem.getDescription());
        tvWatched.setText("Watched on: " + listItem.getWatched_onString());
        tvTheatre.setText("In Theatre: " + listItem.getIn_theatre());
        rbRating.setRating(listItem.getRating());
        rbRating.setIsIndicator(true);

        String Rated = listItem.getRated();

        if (Rated.equals("g")) {
            ivImg.setImageResource(R.drawable.rating_g);
        }

        else if (Rated.equals("pg")){
            ivImg.setImageResource(R.drawable.rating_pg);
        }

        else if (Rated.equals("pg13")){
            ivImg.setImageResource(R.drawable.rating_pg13);
        }

        else if (Rated.equals("nc16")){
            ivImg.setImageResource(R.drawable.rating_nc16);
        }

        else if (Rated.equals("m18")){
            ivImg.setImageResource(R.drawable.rating_m18);
        }

        else if (Rated.equals("r21")){
            ivImg.setImageResource(R.drawable.rating_r21);
        }
    }
}