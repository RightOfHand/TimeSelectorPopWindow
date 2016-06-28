package com.example.com.timeselectorpop;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.com.timeselectorpop.pop.TimeSelectPop;
import com.example.com.timeselectorpop.utils.DateUtils;

import java.util.Date;


public class MainActivity extends Activity {

    private TextView tv_time;
    private Button btn_pop;
    private long sysTime = System.currentTimeMillis();
    private String showTime;
    private MainActivity mThis;
    private TimeSelectPop timeSelectPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mThis = this;
        initView();
        initClick();
    }

    private void initView() {
        btn_pop = (Button) findViewById(R.id.btn_pop);
        tv_time = (TextView) findViewById(R.id.tv_time);
//        btn_pop.setOnClickListener(this);
    }

    private void initClick() {
        btn_pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                initPop();
            }
        });
    }

    private void initPop() {
        if (timeSelectPop == null) {
            timeSelectPop = new TimeSelectPop(MainActivity.this, sysTime, new TimeSelectPop.CallBackTag() {
                @Override
                public void sendTime(long time) {

                    String timeString = String.valueOf(time);
                    Date date = new Date(Long.parseLong(timeString));
                    showTime = DateUtils.formatServerTime(date);
                    tv_time.setText(DateUtils.formatDateString(showTime, DateUtils.dateFormat_detail6));
                }
            });
        }

        timeSelectPop.show();
    }

//    @Override
//    public void onClick(View v) {
//
//        Log.d("activity","有点击没");

}
