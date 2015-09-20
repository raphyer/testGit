package com.example.testnewandroid;

import java.text.NumberFormat;

import android.os.Bundle;
import android.os.StrictMode;
import android.provider.ContactsContract;
import android.R.integer;
import android.app.Activity;
import android.database.Cursor;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.example.testnewandroid.R ;

public class MainActivity extends Activity {

    private static final String myStaticMember = "abc" ;
    private int myMember = 100 ;
    
    class testInter {
        int a = 1 ;
        
        protected int test() {
            return a + myMember ;
        }
        
        protected String test1() {
            return myStaticMember ;
        }
    }
    
    static class testStaticInter {
        int a = 1 ;
        
        protected int test() {
            return a ;
        }
        
        protected String test1() {
            return myStaticMember ;
        }
    }
    
    protected void modifyString(String a) {
        a = a + "bc" ;
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // view is null, and can only get the first internel text view 
        View view = findViewById(R.id.merge_1) ;
        View subView = findViewById(R.id.inter_text) ;
        
        ((TextView)subView).setText("merge view1") ;
        
        DisplayMetrics metric = new DisplayMetrics();
        
        String aa = "a" ;
        modifyString(aa) ;
        
        this.getWindowManager().getDefaultDisplay().getMetrics(metric); 
  
        
        float density = metric.density;  // dpËõ·ÅÒò×Ó  
        float a = metric.widthPixels / density ;
        
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()  
        .detectLeakedSqlLiteObjects()  
        .penaltyLog()  
        .penaltyDeath()  
        .build());  
        
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()  
        .detectDiskReads()  
        .detectDiskWrites()  
        .detectNetwork()  
        .penaltyLog()  
        .penaltyDeath()
        .build());  
        
//        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null) ;
//        cursor.moveToFirst() ;
       
        Log.e("wowo", "test new second commit from master") ;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
        case MotionEvent.ACTION_DOWN:
            break;
        case MotionEvent.ACTION_MOVE:
            break;
        case MotionEvent.ACTION_UP:
            View view = findViewById(R.id.viewStub) ;
            if (view != null) {
                view.setVisibility(View.VISIBLE) ;
            } else {
                TextView textView = (TextView)findViewById(R.id.tv1) ;
                textView.setText("view stub is visible now!!!") ;
                textView.invalidate() ;
            }
            break;
        }
        
        return super.onTouchEvent(event);
    }
}
