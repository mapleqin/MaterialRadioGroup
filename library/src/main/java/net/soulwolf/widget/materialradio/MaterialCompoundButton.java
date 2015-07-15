/**
 * <pre>
 * Copyright (C) 2015  Soulwolf MaterialRadioGroup
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </pre>
 */
package net.soulwolf.widget.materialradio;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.LinearLayout;

/**
 * author : Soulwolf Create by 2015/7/15 15:15
 * email  : ToakerQin@gmail.com.
 */
public class MaterialCompoundButton extends LinearLayout implements Checkable{

    private static final boolean DEBUG = false;

    private static final String LOG_TAG = "MaterialCompoundButton:";

    protected boolean   mChecked;

    protected float     mPadding;

    protected int       mButtonRes;

    protected Drawable  mButtonDrawable;

    protected CharSequence mText;

    protected float     mTextSize;

    protected ColorStateList mColorColorStateList;

    public MaterialCompoundButton(Context context) {
        this(context, null);
    }

    public MaterialCompoundButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MaterialCompoundButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyAttributeSet(context, attrs);
    }

    private void applyAttributeSet(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MaterialCompoundButton);
        setChecked(typedArray.getBoolean(R.styleable.MaterialCompoundButton_mcChecked,isChecked()));
        mButtonRes = typedArray.getResourceId(R.styleable.MaterialCompoundButton_mcButton,0);
        if(mButtonRes != 0){
            setButtonRes(mButtonRes);
        }
        setButtonPadding(typedArray.getDimensionPixelOffset(R.styleable.MaterialCompoundButton_mcPadding,0));
        setText(typedArray.getText(R.styleable.MaterialCompoundButton_mcText));
        setTextSize(typedArray.getDimensionPixelSize(R.styleable.MaterialCompoundButton_mcTextSize,15));
        final int colorResourceId = typedArray.getResourceId(R.styleable.MaterialCompoundButton_mcTextColor,0);
        if(colorResourceId != 0){
            setTextColor(typedArray.getColorStateList(colorResourceId));
        }
        typedArray.recycle();
    }


    @Override
    public void setChecked(boolean checked) {

    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {
        setChecked(!mChecked);
    }

    public void setButtonPadding(float mPadding) {
        this.mPadding = mPadding;
    }

    public void setButtonRes(int mButtonRes) {
        this.mButtonRes = mButtonRes;
        setButtonDrawable(getResources().getDrawable(mButtonRes));
    }

    public void setButtonDrawable(Drawable mButtonDrawable) {
        this.mButtonDrawable = mButtonDrawable;
    }

    public void setText(CharSequence mText) {
        this.mText = mText;
    }

    public void setTextSize(float mTextSize) {
        this.mTextSize = mTextSize;
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.mColorColorStateList =colorStateList;
    }

    public void setTextColor(@ColorInt int color) {
        setTextColor(ColorStateList.valueOf(color));
    }
}
