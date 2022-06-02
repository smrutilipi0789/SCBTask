package com.smrutilipi.movieeapplication.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;


import androidx.recyclerview.widget.RecyclerView;

import com.smrutilipi.movieeapplication.Activities.DetailsActivity;
import com.smrutilipi.movieeapplication.Model.Movie;
import com.smrutilipi.movieeapplication.R;
import com.squareup.picasso.Picasso;


import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Movie> movies;
    private int view_type;

    public static final int GRID_TYPE = 2;




    public MovieAdapter(Context context, List<Movie> movies, int view_type) {
        this.context = context;
        this.movies = movies;
      //  this.view_type = view_type;
    }


    @Override
    public int getItemViewType(int position) {
        return view_type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GridViewHolder(LayoutInflater.from(parent.getContext())
           .inflate(R.layout.grid_view,parent,false));

    }

    @Override
    public void onBindViewHolder (RecyclerView.ViewHolder holder,int position){

        final Movie movie = movies.get(position);
        String image_link = movie.getPoster();
        Picasso.with(context).load(image_link).placeholder(android.R.drawable.stat_notify_error).into(((GridViewHolder)holder).movie_poster);
        ((GridViewHolder) holder).movie_title
                    .setText(movie.getTitle());

            ((GridViewHolder) holder).category.setText(movie.getMovieType());
            ((GridViewHolder) holder).release_year.setText(movie.getYear());

            ((GridViewHolder) holder).mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,DetailsActivity.class);
                    intent.putExtra("movie",movie);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
    }


    @Override
    public int getItemCount () {
        return movies.size();
    }



    public static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView movie_poster;
        TextView movie_title;
        TextView release_year;
        TextView category;
        View mView;


        public ListViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
            movie_poster = itemView.findViewById(R.id.movie_image_view);
            movie_title = itemView.findViewById(R.id.movie_title_view);
            release_year = itemView.findViewById(R.id.release_id_view);
            category = itemView.findViewById(R.id.category_view);


        }
    }



    public static class GridViewHolder extends RecyclerView.ViewHolder{
        ImageView movie_poster;
        TextView movie_title;
        TextView release_year;
        TextView category;
        View mView;

        public GridViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
            movie_poster = itemView.findViewById(R.id.grid_movie_img);
            movie_title = itemView.findViewById(R.id.grid_movie_name);
            release_year = itemView.findViewById(R.id.grid_movie_released);
            category = itemView.findViewById(R.id.grid_movie_category);


        }
    }

}
