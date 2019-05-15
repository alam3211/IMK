package com.example.watchit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.watchit.Activity.DetailActivity;
import com.example.watchit.Model.Card;
import com.example.watchit.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AdapterCard extends PagerAdapter {

    private List<Card> cards;
    private ArrayList<Card> arraylist;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterCard(List<Card> cards, Context context) {
        this.cards = cards;
        this.context = context;
        this.arraylist = new ArrayList<Card>();
        this.arraylist.addAll(cards);
    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item,container,false);

        ImageView imageView;
        TextView title,rating,watched;

        imageView = view.findViewById(R.id.cardImage);
        title = view.findViewById(R.id.tvCardTitle);
        rating = view.findViewById(R.id.tvCardRating);
        watched = view.findViewById(R.id.tvCardWatched);

        imageView.setImageResource(cards.get(position).getImage());
        title.setText(cards.get(position).getTitle());
        rating.setText(String.valueOf(cards.get(position).getRating()));
        watched.setText(String.valueOf(cards.get(position).getWatched()));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("title", cards.get(position).getTitle());
                intent.putExtra("genres", cards.get(position).getGenre());
                intent.putExtra("release", cards.get(position).getReleasedate());
                intent.putExtra("cast", cards.get(position).getCast());
                intent.putExtra("synopsis",cards.get(position).getSynopsis());
                intent.putExtra("image",cards.get(position).getImage());
                context.startActivity(intent);
                // finish();
            }
        });

        container.addView(view,0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        cards.clear();
        if (charText.length() == 0) {
            cards.addAll(arraylist);
        } else {
            for (Card wp : arraylist) {
                if (wp.getTitle().toLowerCase(Locale.getDefault()).contains(charText)) {
                    cards.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
