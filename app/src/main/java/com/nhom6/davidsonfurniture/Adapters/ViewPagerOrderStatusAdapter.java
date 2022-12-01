package com.nhom6.davidsonfurniture.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.nhom6.davidsonfurniture.Fragments.CompletedOrderFragment;
import com.nhom6.davidsonfurniture.Fragments.DeliveredOrderFragment;
import com.nhom6.davidsonfurniture.Fragments.DeliveringOrderFragment;
import com.nhom6.davidsonfurniture.Fragments.PlacedOrderFragment;
import com.nhom6.davidsonfurniture.Fragments.PreparingOrderFragment;

public class ViewPagerOrderStatusAdapter extends FragmentStateAdapter {
    public ViewPagerOrderStatusAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new PlacedOrderFragment();
            case 1:
                return new PreparingOrderFragment();
            case 2:
                return new DeliveringOrderFragment();
            case 3:
                return new DeliveredOrderFragment();
            case 4:
                return new CompletedOrderFragment();
            default:
                return new PlacedOrderFragment();
        }
    }

    @Override
    public int getItemCount() {
        //số tab trả về
        return 5;
    }
}
