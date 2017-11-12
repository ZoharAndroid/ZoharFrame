package zzh.com.zoharframe.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zohar on 2017/11/12.
 *
 * 自定义View 点--随手指移动
 */

public class DragPoint extends View {

    private float mCurrentX = 50;
    private float mCurrentY = 50;

    public DragPoint(Context context) {
        super(context);
    }

    public DragPoint(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawCircle(mCurrentX, mCurrentY, 15, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 获取当前的位置
        mCurrentX = event.getX();
        mCurrentY = event.getY();
        // 不断重绘
        invalidate();
        // 返回true
        return true;
    }
}
