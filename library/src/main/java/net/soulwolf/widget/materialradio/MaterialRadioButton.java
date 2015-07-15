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
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/**
 * author : Soulwolf Create by 2015/7/15 15:12
 * email  : ToakerQin@gmail.com.
 */
public class MaterialRadioButton extends MaterialCompoundButton {

    public MaterialRadioButton(Context context) {
        super(context);
    }

    public MaterialRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MaterialRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(MaterialRadioButton.class.getName());
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(MaterialRadioButton.class.getName());
    }
}
