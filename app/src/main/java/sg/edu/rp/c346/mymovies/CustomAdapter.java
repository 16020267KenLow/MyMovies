package sg.edu.rp.c346.mymovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 16020267 on 23/7/2018.
 */

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movie> MovieList;
    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        MovieList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvGenre = rowView.findViewById(R.id.textViewGenre);
        ImageView ivRating = rowView.findViewById(R.id.imageViewRating);
        Movie currentItem = MovieList.get(position);
        tvTitle.setText(currentItem.getTitle());
        tvYear.setText(currentItem.getYear());
        tvGenre.setText(currentItem.getGenre());
        if(currentItem.getRated() == "pg" ){
            ivRating.setImageResource(R.drawable.rating_pg);
        }else if(currentItem.getRated() == "g" ){
            ivRating.setImageResource(R.drawable.rating_g);
        }else if(currentItem.getRated() == "pg13" ){
            ivRating.setImageResource(R.drawable.rating_pg13);
        }else if(currentItem.getRated() == "nc16" ){
            ivRating.setImageResource(R.drawable.rating_nc16);
        }else if(currentItem.getRated() == "m18" ){
            ivRating.setImageResource(R.drawable.rating_m18);
        }else{
            ivRating.setImageResource(R.drawable.rating_r21);
        }

        return rowView;
    }
}
