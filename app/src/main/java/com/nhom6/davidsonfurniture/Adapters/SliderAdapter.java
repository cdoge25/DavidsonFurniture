package com.nhom6.davidsonfurniture.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.nhom6.davidsonfurniture.R;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    int images[] = {
            R.drawable.img_onboarding1,
            R.drawable.img_onboarding2,
            R.drawable.img_onboarding3
    };

    int headings[] = {
            R.string.intro_heading1,
            R.string.intro_heading2,
            R.string.intro_heading3
    };

    int descriptions[] = {
            R.string.intro_description1,
            R.string.intro_description2,
            R.string.intro_description3,
    };

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_slides,container,false);

        ImageView imageView = view.findViewById(R.id.imvOnboarding);
        TextView heading = view.findViewById(R.id.txtHeading);
        TextView desc = view.findViewById(R.id.txtDescription);

        imageView.setImageResource(images[position]);
        heading.setText(headings[position]);
        desc.setText(descriptions[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
