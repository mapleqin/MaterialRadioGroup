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
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.toaker.common.tlog.TLog;

import net.soulwolf.widget.materialradio.R;
import net.soulwolf.widget.materialradio.listener.OnCheckedChangeListener;
import net.soulwolf.widget.materialradio.widget.MaterialStateButton;
import net.soulwolf.widget.materialradio.widget.MaterialStateText;

/**
 * author : Soulwolf Create by 2015/7/15 15:15
 * email  : ToakerQin@gmail.com.
 */
public class MaterialCompoundButton extends FrameLayout implements Checkable, OnCheckedChangeListener {

    private boolean mBroadcasting;

    protected int     mPadding;

    protected int       mButtonRes;

    protected Drawable  mButtonDrawable;

    protected CharSequence mText;

    protected float     mTextSize;

    protected ColorStateList mColorColorStateList;

    protected MaterialStateButton mButtonView;

    protected MaterialStateText  mButtonText;

    protected View      mSpaceView;

    private OnCheckedChangeListener mOnCheckedChangeListener;

    private OnCheckedChangeListener mOnCheckedChangeWidgetListener;

    public MaterialCompoundButton(Context context) {
        this(context, null);
    }

    public MaterialCompoundButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MaterialCompoundButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.mcl_compound_button, this, true);
        mButtonView = (MaterialStateButton) findViewById(R.id.mci_compound_button_image);
        mSpaceView = findViewById(R.id.mci_compound_button_padding);
        mButtonText = (MaterialStateText) findViewById(R.id.mci_compound_button_text);
        mButtonView.setOnCheckedChangeListener(this);
        applyAttributeSet(context, attrs);
    }

    private void applyAttributeSet(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MaterialCompoundButton);
        setChecked(typedArray.getBoolean(R.styleable.MaterialCompoundButton_mcChecked,isChecked()));
        mButtonRes = typedArray.getResourceId(R.styleable.MaterialCompoundButton_mcButton,0);
        if(mButtonRes != 0){
            setButtonRes(mButtonRes);
        }
        setButtonPadding(typedArray.getDimensionPixelOffset(R.styleable.MaterialCompoundButton_mcPadding, 0));
        setText(typedArray.getText(R.styleable.MaterialCompoundButton_mcText));
        setTextSize(typedArray.getDimensionPixelSize(R.styleable.MaterialCompoundButton_mcTextSize,15));
        setTextColor(typedArray.getColorStateList(R.styleable.MaterialCompoundButton_mcTextColor));
        typedArray.recycle();
    }


    @Override
    public void setChecked(boolean checked) {
        mButtonView.setChecked(checked);
        mButtonText.setChecked(checked);
    }

    @Override
    public void onCheckedChanged(MaterialCompoundButton compoundView, boolean isChecked) {
        mButtonText.setChecked(isChecked);
        if (mBroadcasting) {
            return;
        }
        mBroadcasting = true;
        if (mOnCheckedChangeListener != null) {
            mOnCheckedChangeListener.onCheckedChanged(MaterialCompoundButton.this, isChecked);
        }
        if (mOnCheckedChangeWidgetListener != null) {
            mOnCheckedChangeWidgetListener.onCheckedChanged(MaterialCompoundButton.this, isChecked);
        }
        mBroadcasting = false;
    }

    @Override
    public boolean isChecked() {
        return mButtonView.isChecked();
    }

    @Override
    public void toggle() {
        mButtonView.toggle();
        mButtonText.toggle();
    }


    public void setButtonPadding(int padding) {
        this.mPadding = padding;
        mSpaceView.getLayoutParams().height = mPadding;
        mSpaceView.requestLayout();
    }

    public void setButtonRes(int mButtonRes) {
        this.mButtonRes = mButtonRes;
        setButtonDrawable(getResources().getDrawable(mButtonRes));
    }

    public void setButtonDrawable(Drawable drawable) {
        this.mButtonDrawable = drawable;
        this.mButtonView.setImageDrawable(mButtonDrawable);
    }

    public void setText(@StringRes int resId) {
        setText(getResources().getString(resId));
    }

    public void setText(CharSequence text) {
        this.mText = text;
        this.mButtonText.setText(mText);
    }

    public void setTextSize(float textSize) {
        this.mTextSize = textSize;
        this.mButtonText.setTextSize(mTextSize);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.mColorColorStateList = colorStateList;
        this.mButtonText.setTextColor(mColorColorStateList);
    }

    public void setTextColor(@ColorInt int color) {
        setTextColor(ColorStateList.valueOf(color));
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener mOnCheckedChangeListener) {
        this.mOnCheckedChangeListener = mOnCheckedChangeListener;
    }

    public void setOnCheckedChangeWidgetListener(OnCheckedChangeListener mOnCheckedChangeWidgetListener) {
        this.mOnCheckedChangeWidgetListener = mOnCheckedChangeWidgetListener;
    }
}
