package com.example.view;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * 本demo测试view的点击事件
 */
public class MyView extends View {

	Paint paint = new Paint();
	int radius = 50;
	// int cx = -50, cy = -50;

	ArrayList<MyPoint> pointList = new ArrayList<MyPoint>();// 链表多遍历for循环

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		canvas.drawColor(Color.BLACK);
		paint.setColor(Color.WHITE);
		// 绘制圆
		for (int i = 0; i < pointList.size(); i++) {
			canvas.drawCircle(pointList.get(i).getX(), pointList.get(i).getY(),
					radius, paint);
		}

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		// 获取触摸点坐标
		int x = (int) event.getX();
		int y = (int) event.getY();
		Log.d("Test", "(" + x + "," + y + ")");
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			Log.d("Tag", "down");
			// cx = x;
			// cy = y;
			MyPoint point = new MyPoint(x, y);
			pointList.add(point);
			// 发送消息，让系统自动调用onDraw方法
			this.invalidate();

		} else if (event.getAction() == MotionEvent.ACTION_UP) {
			Log.d("Tag", "up");
		} else if (event.getAction() == MotionEvent.ACTION_MOVE) {
			Log.d("Tag", "move");
		}
		return true;

	}
}
