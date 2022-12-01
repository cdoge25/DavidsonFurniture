package com.nhom6.davidsonfurniture.Models;

import android.icu.text.CaseMap;

public class Notification {
    int NotificationThumb;
    String NotificationTitle;
    String NotificationClick;

    public Notification(int notificationThumb, String notificationTitle, String notificationClick) {
        this.NotificationThumb = notificationThumb;
        this.NotificationTitle = notificationTitle;
        this.NotificationClick = notificationClick;
    }

    public int getNotificationThumb() {
        return NotificationThumb;
    }

    public void setNotificationThumb(int notificationThumb) {
        NotificationThumb = notificationThumb;
    }

    public String getNotificationTitle() {
        return NotificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        NotificationTitle = notificationTitle;
    }

    public String getNotificationClick() {
        return NotificationClick;
    }

    public void setNotificationClick(String notificationClick) {
        NotificationClick = notificationClick;
    }
}
