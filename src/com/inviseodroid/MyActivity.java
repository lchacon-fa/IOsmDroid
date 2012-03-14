package com.inviseodroid;

import android.app.Activity;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import org.osmdroid.views.MapView;


/**
 * https://github.com/excilys/androidannotations/wiki/FirstActivity
 */
@EActivity(R.layout.main)
public class MyActivity extends Activity {

    @ViewById
    EditText myInput;

    @ViewById(R.id.myTextView)
    TextView textView;

    @ViewById
    MapView mOsmv;

    @AfterViews
    public void init() {
        this.mOsmv = new MapView(this, 256);
        this.addContentView(mOsmv,new RelativeLayout.LayoutParams(MapView.LayoutParams.FILL_PARENT,
                                                                  MapView.LayoutParams.FILL_PARENT));
    }

    @Click(R.id.myButton)
    void myButton() {
        String name = myInput.getText().toString();
        textView.setText("Hello " + name);
    }
}