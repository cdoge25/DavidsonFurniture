package com.nhom6.davidsonfurniture.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhom6.davidsonfurniture.Models.Notification;
import com.nhom6.davidsonfurniture.Models.PlacedOrder;
import com.nhom6.davidsonfurniture.R;

import java.util.List;

public class NotificationAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<Notification> notifications;

    public NotificationAdapter(Activity activity, int item_layout, List<Notification> notifications) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.notifications = notifications;
    }

    @Override
    public int getCount() {
        return notifications.size();
    }

    @Override
    public Object getItem(int i) {
        return notifications.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        NotificationAdapter.ViewHolder holder;
        if (view == null){
            holder = new NotificationAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
            holder.imvNotificationThumb = view.findViewById(R.id.imvNotificationThumb);
            holder.txtNotificationTitle = view.findViewById(R.id.txtNotificationTitle);
            holder.txtNotificationClick = view.findViewById(R.id.txtNotificationClick);

            view.setTag(holder);
        }
        else{
            holder = (NotificationAdapter.ViewHolder) view.getTag();
        }
        Notification n = notifications.get(i);
        holder.imvNotificationThumb.setImageResource(n.getNotificationThumb());
        holder.txtNotificationTitle.setText(n.getNotificationTitle());
        holder.txtNotificationClick.setText(n.getNotificationClick());
        return view;
    }

    public static class ViewHolder{
        ImageView imvNotificationThumb;
        TextView txtNotificationTitle, txtNotificationClick;
    }
}
