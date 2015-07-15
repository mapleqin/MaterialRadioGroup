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

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * author : Soulwolf Create by 2015/7/15 15:11
 * email  : ToakerQin@gmail.com.
 */
public class MaterialRadioGroup extends LinearLayout {

    private static final boolean DEBUG = false;

    private static final String LOG_TAG = "MaterialRadioGroup:";

    public MaterialRadioGroup(Context context) {
        super(context);
    }

    public MaterialRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MaterialRadioGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MaterialRadioGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
