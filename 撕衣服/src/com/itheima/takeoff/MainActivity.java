package com.itheima.takeoff;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView iv_pre;
	private Bitmap alterBitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv_pre = (ImageView) findViewById(R.id.iv_pre);
		// 原图.
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.pre);
		alterBitmap = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), bitmap.getConfig());
		Canvas canvas = new Canvas(alterBitmap);
		Paint paint = new Paint();
		canvas.drawBitmap(bitmap, new Matrix(), paint);
		iv_pre.setImageBitmap(alterBitmap);

		iv_pre.setOnTouchListener(new OnTouchListener() {
			int x;
			int y;

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					x = (int) event.getX();
					y = (int) event.getY();
					for(int i=-3;i<4;i++){
						for(int j=-3;j<4;j++){
							if(Math.sqrt(i*i+j*j)<=3){
								try {
									alterBitmap.setPixel(x+i, y+j, Color.TRANSPARENT);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					}
					iv_pre.setImageBitmap(alterBitmap);
					break;
				case MotionEvent.ACTION_MOVE:
					x = (int) event.getX();
					y = (int) event.getY();
					for(int i=-3;i<4;i++){
						for(int j=-3;j<4;j++){
							if(Math.sqrt(i*i+j*j)<=3){
								try {
									alterBitmap.setPixel(x+i, y+j, Color.TRANSPARENT);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					}
					iv_pre.setImageBitmap(alterBitmap);
					break;
				case MotionEvent.ACTION_UP:

					break;
				}
				return true;// 事件结束被消费掉了
			}
		});
	}

}
