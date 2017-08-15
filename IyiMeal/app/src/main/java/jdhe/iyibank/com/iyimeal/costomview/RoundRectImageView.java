package jdhe.iyibank.com.iyimeal.costomview;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

import jdhe.iyibank.com.iyimeal.R;


public class RoundRectImageView extends ImageView {
	private Paint paint;
	private int roundWidth = 8;
	private int roundHeight = 8;
	private int drawDirection= 4;
	private Paint paint2;

	public RoundRectImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context, attrs);
	}

	public RoundRectImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	public RoundRectImageView(Context context) {
		super(context);
		init(context, null);
	}
	
	private void init(Context context, AttributeSet attrs) {
		if(attrs != null) {   
			TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RoundAngleImageView);
			roundWidth= a.getDimensionPixelSize(R.styleable.RoundAngleImageView_roundWidth, roundWidth);
			roundHeight= a.getDimensionPixelSize(R.styleable.RoundAngleImageView_roundHeight, roundHeight);
			drawDirection= a.getInteger(R.styleable.RoundAngleImageView_drawDirection, drawDirection);
			a.recycle();
		}else {
			float density = context.getResources().getDisplayMetrics().density;
			roundWidth = (int) (roundWidth*density);
			roundHeight = (int) (roundHeight*density);
		} 
		
		paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setAntiAlias(true);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
		
		paint2 = new Paint();
		paint2.setXfermode(null);
	}
	
	@Override
	public void draw(Canvas canvas) {
		try {
			Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
			Canvas canvas2 = new Canvas(bitmap);
			super.draw(canvas2);
			switch (drawDirection) {
				case 2:
					drawLiftUp(canvas2);
					drawRightUp(canvas2);
					break;
				case 4:
					drawLiftUp(canvas2);
					drawRightUp(canvas2);
					drawLiftDown(canvas2);
					drawRightDown(canvas2);
					break;
			}
			canvas.drawBitmap(bitmap, 0, 0, paint2);
			bitmap.recycle();
		}catch (Exception e){

		}
	}
	
	private void drawLiftUp(Canvas canvas) {
		Path path = new Path();
		path.moveTo(0, roundHeight);
		path.lineTo(0, 0);
		path.lineTo(roundWidth, 0);
		path.arcTo(new RectF(
				0, 
				0, 
				roundWidth*2, 
				roundHeight*2), 
				-90, 
				-90);
		path.close();
		canvas.drawPath(path, paint);
	}
	
	private void drawLiftDown(Canvas canvas) {
		Path path = new Path();
		path.moveTo(0, getHeight()-roundHeight);
		path.lineTo(0, getHeight());
		path.lineTo(roundWidth, getHeight());
		path.arcTo(new RectF(
				0, 
				getHeight()-roundHeight*2, 
				0+roundWidth*2, 
				getHeight()),
				90, 
				90);
		path.close();
		canvas.drawPath(path, paint);
	}
	
	private void drawRightDown(Canvas canvas) {
		Path path = new Path();
		path.moveTo(getWidth()-roundWidth, getHeight());
		path.lineTo(getWidth(), getHeight());
		path.lineTo(getWidth(), getHeight()-roundHeight);
		path.arcTo(new RectF(
				getWidth()-roundWidth*2, 
				getHeight()-roundHeight*2, 
				getWidth(), 
				getHeight()), 0, 90);
		path.close();
		canvas.drawPath(path, paint);
	}
	
	private void drawRightUp(Canvas canvas) {
		Path path = new Path();
		path.moveTo(getWidth(), roundHeight);
		path.lineTo(getWidth(), 0);
		path.lineTo(getWidth()-roundWidth, 0);
		path.arcTo(new RectF(
				getWidth()-roundWidth*2, 
				0, 
				getWidth(), 
				0+roundHeight*2), 
				-90, 
				90);
		path.close();
		canvas.drawPath(path, paint);
	}
} 