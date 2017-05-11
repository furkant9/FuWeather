package com.furkantazegullu.weather.helpers;

import android.content.Context;
import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by user on 9.08.2016.
 */
public class Utility {
    private static Utility ourInstance = new Utility();

    private InputMethodManager inputMethodManager;

    private static Context mContext;

    private Utility() {
    }

    public static synchronized Utility getInstance(Context context) {
        mContext = context;
        return ourInstance;
    }

    public void showSoftKeyboard(){
        inputMethodManager=(InputMethodManager)
                mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager
                .toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

    }

    public void hideSoftKeyboard(IBinder iBinder){
        inputMethodManager = (InputMethodManager)
                mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(iBinder,0);

    }
}
