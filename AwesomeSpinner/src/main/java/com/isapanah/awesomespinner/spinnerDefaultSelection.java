package com.isapanah.awesomespinner;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;

/**
 * Created by sadra on 5/27/17.
 */

public class spinnerDefaultSelection extends AppCompatSpinner {

    OnItemSelectedListener listener;
    int prevPos = 0;
    public spinnerDefaultSelection(Context context) {
        super(context);
        init();
    }

    public spinnerDefaultSelection(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public spinnerDefaultSelection(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init()
    {
        this.getBackground().setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
    }

    @Override
    public void setSelection(int position) {
        super.setSelection(position);
        if (position == getSelectedItemPosition() && prevPos == position) {
            getOnItemSelectedListener().onItemSelected(null, null, position, 0);
        }
        prevPos = position;
    }
}