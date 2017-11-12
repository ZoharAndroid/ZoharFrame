package zzh.com.zoharframe.activity.conversation;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.othershe.nicedialog.Utils;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.base.BaseActionBarActivity;
import zzh.com.zoharframe.config.Constants;
import zzh.com.zoharframe.view.DragPoint;

/**
 * Created by zohar on 2017/11/12.
 */

public class DragPointActivity extends BaseActionBarActivity {

    private LinearLayout mLLRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_point);
        initActionBarTitle(getIntent().getStringExtra(Constants.INTENT_START_ACTIVITY));


    }

    @Override
    protected void initView() {
        super.initView();
        mLLRoot = (LinearLayout) findViewById(R.id.ll_point_root);

        DragPoint point = new DragPoint(this);
        point.setMinimumWidth(Utils.dp2px(this,20));
        point.setMinimumHeight(Utils.dp2px(this,20));

        mLLRoot.addView(point);

    }
}
