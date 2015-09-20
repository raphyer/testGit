package com.example.testnewandroid;

import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

import com.example.testnewandroid.R ;


public class HelloWidgetProvider extends AppWidgetProvider {
    
    Timer timer = new Timer(); 
    
    @Override 
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) { 
        timer.scheduleAtFixedRate(new MyTime(context, appWidgetManager), 1, 1000); 
    } 
    
    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // TODO Auto-generated method stub
        super.onDeleted(context, appWidgetIds);
        
        timer.cancel() ;
    }

    public class MyTime extends TimerTask { 
        RemoteViews remoteViews; 
        AppWidgetManager appWidgetManager; 
        ComponentName thisWidget; 
        int i = 0 ;
        
        public MyTime(Context context, AppWidgetManager appWidgetManager) {  
            this.appWidgetManager = appWidgetManager;  
            remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_test);  
            thisWidget = new ComponentName(context, HelloWidgetProvider.class) ; 
            }
        
        @Override  
        public void run() {
            remoteViews.setTextViewText(R.id.tvCurrTime, "Time = " + i++);  
            appWidgetManager.updateAppWidget(thisWidget, remoteViews);  
            }  
    }
}
