package com.example.com.timeselectorpop.pop;

import android.app.Activity;
import android.view.View;

import com.example.com.timeselectorpop.view.DateTimePicker;

import java.util.Calendar;

/**
 * Created by SongYu on 2016/05/24.
 */
public class TimeSelectPop {
    private DateTimePicker mDateTimePicker;
    private Calendar mDate = Calendar.getInstance();
//    private long sysTime = System.currentTimeMillis();
    private PopupWin mPowWindow;
    private Activity mContext;
    private CallBackTag callBackTag;
    private long baseTime;

    public TimeSelectPop(Activity mContext, long baseTime, CallBackTag callBackTag) {
        this.mContext = mContext;
        this.callBackTag = callBackTag;
        this.baseTime = baseTime;


    }

    private void init() {
        View parentView = mContext.getWindow().getDecorView();
        mDateTimePicker = new DateTimePicker(mContext, baseTime);
        mPowWindow = PopupWin.Builder.create(mContext)
                .setParentView(parentView)
                .setContentView(mDateTimePicker)
                .build();
        mDateTimePicker
                .setOnDateTimeChangedListener(new DateTimePicker.OnDateTimeChangedListener() {
                    @Override
                    public void onDateTimeChanged(DateTimePicker view,
                                                  int year, int month, int day, int hour, int minute) {
                        mDate.set(Calendar.YEAR, year);
                        mDate.set(Calendar.MONTH, month);
                        mDate.set(Calendar.DAY_OF_MONTH, day);
                        mDate.set(Calendar.HOUR_OF_DAY, hour);
                        mDate.set(Calendar.MINUTE, minute);
                        mDate.set(Calendar.SECOND, 0);
                        /**
                         * 更新日期
                         */
                        callBackTag.sendTime(mDate.getTimeInMillis());


                    }
                });
    }


    public void show() {
        if (mPowWindow == null) {
            init();


        }
        mPowWindow.show();
    }

    public interface CallBackTag {
        void sendTime(long time);
    }
}
