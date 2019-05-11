package com.example.watchit.Fragment;

import android.animation.ArgbEvaluator;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.watchit.Adapter.AdapterCard;
import com.example.watchit.Model.Card;
import com.example.watchit.R;

import java.util.ArrayList;
import java.util.List;

public class BrowseFragment extends Fragment {

    ViewPager viewPager;
    List<Card> cards;
    AdapterCard adapterCard;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private int currentPage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_browse,container,false);

        cards = new ArrayList<>();
        cards.add(new Card(R.drawable.alita,"Alita : Battle Angel",1,11));
        cards.add(new Card(R.drawable.avatar,"Avatar",2,22));
        cards.add(new Card(R.drawable.aquagirl,"Aquaman",4,44));
        cards.add(new Card(R.drawable.starwar,"Star Wars : The Beginning",5,55));

        adapterCard = new AdapterCard(cards,this.getContext());
        viewPager = view.findViewById(R.id.ViewPager);
        viewPager.setAdapter(adapterCard);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp = {getResources().getColor(R.color.colorPrimary)};
        colors = colors_temp;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                if (i < (adapterCard.getCount() - 1) && i < (colors.length - 1)){
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    v,colors[i],colors[i+1]
                            )
                    );
                }
                else{
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(final int i) {
                currentPage = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        Button btWatchlist = view.findViewById(R.id.btWatchlist);
        btWatchlist.setOnClickListener(new ViewPager.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = cards.get(currentPage).getTitle();
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                builder.setTitle("Added to watchlist");
                builder.setMessage(text);
                builder.show();
            }
        });

        return view;
    }
}
