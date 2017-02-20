package com.chengx.mvp.widget.refresh.swipe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.view.ViewCompat;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.chengx.mvp.utils.SizeUtils;

/**
 * 作者：chengx
 * 日期：2017/2/20
 * 描述：
 */

public class CircleView extends ImageView {
    private static final int KEY_SHADOW_COLOR = 0x1E000000;
    private static final int FILL_SHADOW_COCLOR = 0x3D000000;

    private static final float X_OFFSET = 0f;
    private static final float Y_OFFSET = 1.75f;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final int SHADOW_ELEVATION = 4;

    private Animation.AnimationListener listener;
    private int shadowRadius;

    public CircleView(Context context, int color, float radius) {
        super(context);
        final int diameter = SizeUtils.dp2px(context,radius) * 2;
        final int shadowXOffset = SizeUtils.dp2px(context,X_OFFSET);
        final int shadowYOffset = SizeUtils.dp2px(context,Y_OFFSET);

        shadowRadius = SizeUtils.dp2px(context,SHADOW_RADIUS);

        ShapeDrawable circle;
        if (elevationSupported()){
            circle = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this,SizeUtils.dp2px(context,SHADOW_ELEVATION));
        } else {
            OvalShape oval = new OvalShadow(diameter);
            circle = new ShapeDrawable(oval);
            ViewCompat.setLayerType(this,ViewCompat.LAYER_TYPE_SOFTWARE,circle.getPaint());
            circle.getPaint().setShadowLayer(shadowRadius,shadowXOffset,shadowYOffset,KEY_SHADOW_COLOR);
            final int padding = shadowRadius;
            setPadding(padding,padding,padding,padding);
        }
        circle.getPaint().setColor(color);
        setBackgroundDrawable(circle);
    }
    private boolean elevationSupported() {
        return android.os.Build.VERSION.SDK_INT >= 21;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!elevationSupported()){
            setMeasuredDimension(getMeasuredWidth()+shadowRadius*2,getMeasuredHeight()+shadowRadius*2);
        }
    }

    public void setAnimationListener(Animation.AnimationListener listener){
        this.listener = listener;
    }

    @Override
    protected void onAnimationStart() {
        super.onAnimationStart();
        if (listener != null){
            listener.onAnimationStart(getAnimation());
        }
    }

    @Override
    protected void onAnimationEnd() {
        super.onAnimationEnd();
        if (listener != null){
            listener.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColorRes(int colorRes){
        setBackgroundColor(getContext().getResources().getColor(colorRes));
    }

    @Override
    public void setBackgroundColor(int color) {
        if (getBackground() instanceof ShapeDrawable){
            ((ShapeDrawable) getBackground()).getPaint().setColor(color);
        }
    }

    private class OvalShadow extends OvalShape{
        private RadialGradient radialGradient;
        private Paint shadowPaint;
        private int circleDiameter;

        public OvalShadow(int circleDiameter) {
            this.circleDiameter = circleDiameter;
            shadowPaint = new Paint();
            radialGradient = new RadialGradient(this.circleDiameter / 2,this.circleDiameter/2,
                    shadowRadius,new int[]{
                    FILL_SHADOW_COCLOR, Color.TRANSPARENT},null, Shader.TileMode.CLAMP);
            shadowPaint.setShader(radialGradient);
        }

        @Override
        public void draw(Canvas canvas, Paint paint) {
            super.draw(canvas, paint);
            final int viewWidth = CircleView.this.getWidth();
            final int viewHeight = CircleView.this.getHeight();
            canvas.drawCircle(viewWidth/2,viewHeight/2,(circleDiameter/2+shadowRadius),shadowPaint);
            canvas.drawCircle(viewWidth/2,viewHeight/2,(circleDiameter/2),paint);
        }
    }

}
