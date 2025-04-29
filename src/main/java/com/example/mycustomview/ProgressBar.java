package com.example.mycustomview;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

/**
 * Created by parsian pc on 10/19/2020.
 */
public class ProgressBar extends View {

    private int backColor=0;
    private int frontColor=0;
    private int lineColor=0;
    private boolean displayValue;
    private int outerCirlceRadius=200;
    private int innerCirlceRadius=150;
    private int displayTextSize=20;
    private int value=90;
    private int centerX=200;
    private int centerY=200;
    private int width=400;
    private int height=400;
    private String name="";

    public ProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupAttrs(attrs);
    }
    private void setupAttrs(AttributeSet attrs){

        try {
            for(int i=0;i<attrs.getAttributeCount();i++) {
                if(attrs.getAttributeName(i).contains("backColor")) {
                    backColor = attrs.getAttributeIntValue(i, backColor);
                }else if(attrs.getAttributeName(i).contains("frontColor")){
                    frontColor = attrs.getAttributeIntValue(i, frontColor);
                }else if(attrs.getAttributeName(i).contains("lineColor")){
                    lineColor = attrs.getAttributeIntValue(i, lineColor);
                }else if(attrs.getAttributeName(i).contains("displayValue")){
                    displayValue = attrs.getAttributeBooleanValue(i, false);
                }else if(attrs.getAttributeName(i).contains("name")){
                    name = attrs.getAttributeValue(i);
                }else if(attrs.getAttributeName(i).contains("layout_width")) {
                    String text=attrs.getAttributeValue(i);text=text.substring(0,text.length()-5);
                    width = Integer.parseInt(text);
                }else if(attrs.getAttributeName(i).contains("layout_height")) {
                    String text=attrs.getAttributeValue(i);text=text.substring(0,text.length()-5);
                    height = Integer.parseInt(text);
                }
            }
        }catch(Exception ex) {
            Toast.makeText(getContext(),ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onLayout(boolean changed,int left,int top,int right,int bottom){
        if(changed){
            centerX=(left+right)/2;
            centerY=(top+bottom)/2;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec){
        width = Math.min(width, widthMeasureSpec);
        height = Math.min(height, heightMeasureSpec);
        width=Math.min(width,height);
        height=Math.min(width,height);
        innerCirlceRadius=(35*width)/100;
        outerCirlceRadius=width/2;
        displayTextSize=width/10;
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint paint=new Paint();
        paint.setColor(backColor);
        canvas.drawCircle(centerX,centerY,outerCirlceRadius,paint);
        paint.setColor(frontColor);
        RectF rectf=new RectF();
        rectf.left=centerX-outerCirlceRadius;rectf.top=centerY-outerCirlceRadius;
        rectf.right=centerX+outerCirlceRadius;
        rectf.bottom=centerY+outerCirlceRadius;
        if(value<=50) {
            canvas.drawArc(rectf, 180f, ((float)value)*3.6f, true, paint);
        }else{
            canvas.drawArc(rectf, 180f, 180f, true, paint);
            canvas.drawArc(rectf, 0f, (value-50)*3.6f, true, paint);
        }
        paint.setColor(Color.WHITE);
        canvas.drawCircle(centerX,centerY,innerCirlceRadius,paint);
        if(displayValue) {
            paint.setColor(lineColor);
            paint.setTextSize(displayTextSize);
            String displayText=name + " = "+ value;
            int len=displayText.length()*displayTextSize/4;
            canvas.drawText(displayText, centerX-len, centerY, paint);
        }
    }

    public void setValue(int value){
        this.value=value;
        invalidate();
    }
    public int getValue(){
        return this.value;
    }
}
