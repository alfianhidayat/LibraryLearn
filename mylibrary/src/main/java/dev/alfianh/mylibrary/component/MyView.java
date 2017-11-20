package dev.alfianh.mylibrary.component;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import dev.alfianh.mylibrary.R;

/**
 * Created by alfianh on 20/11/17.
 */

public class MyView extends LinearLayout {
    public MyView(Context context) {
        super(context);
        initialize(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    private void initialize(Context context){
        inflate(context, R.layout.activity_library, this);
    }
}
