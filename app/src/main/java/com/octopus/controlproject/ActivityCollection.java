package com.octopus.controlproject;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollection {

    private static List<Activity> activityList = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    public static void removeAll()
    {
        for (Activity activity :activityList)
        {
            if (!activity.isFinishing())
            {
                activity.finish();
            }
        }
    }

    /**
     * app exit
     */
    public static void AppExit(Context context) {
        try {
//            removeAll();
            ActivityManager activityMgr = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception ignored) {
        }
    }

}


