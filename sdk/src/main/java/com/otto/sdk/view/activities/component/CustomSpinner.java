package com.otto.sdk.view.activities.component;

import android.content.Context;
import android.util.AttributeSet;

public class CustomSpinner extends android.support.v7.widget.AppCompatSpinner {
    OnItemSelectedListener listener;

    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setSelection(int position) {
        super.setSelection(position);
        if (listener != null)
            listener.onItemSelected(null, null, position, 0);
    }

    public void setOnItemSelectedEvenIfUnchangedListener(
            OnItemSelectedListener listener) {
        this.listener = listener;
    }

}
