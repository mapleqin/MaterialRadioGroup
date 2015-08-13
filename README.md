# MaterialRadioGroup
This is a cool radio button group!

For more information please see <a href='http://devsoulwolf.github.io/MaterialRadioGroup'>the website</a>

## Screenshots
![Sample1](https://img.alicdn.com/imgextra/i2/1025192026/TB2viundVXXXXXbXXXXXXXXXXXX_!!1025192026.jpg_310x310.jpg)
![Sample2](https://img.alicdn.com/imgextra/i1/1025192026/TB2B7xVdVXXXXcxXpXXXXXXXXXX_!!1025192026.jpg_310x310.jpg)


## PictureChooseLib with android layout code
```java
<net.soulwolf.widget.materialradio.MaterialRadioGroup
    android:layout_width="match_parent"
    android:gravity="center"
    android:layout_marginTop="50dp"
    android:layout_height="wrap_content"
    android:orientation="horizontal">

   <net.soulwolf.widget.materialradio.MaterialRadioButton
	    android:layout_width="wrap_content"
	    android:layout_height="match_parent"
	    soulwolf:mcTextSize="6sp"
	    soulwolf:mcText="男生"
	    soulwolf:mcPadding="5dp"
	    soulwolf:mcChecked="true"
	    soulwolf:mcAnimator="true"
	    soulwolf:mcTextColor="@drawable/radio_button_text_selector"
	    soulwolf:mcButton="@drawable/radio_button_boy_selector"/>
	
   <net.soulwolf.widget.materialradio.MaterialRadioButton
	    android:layout_width="wrap_content"
	    android:layout_marginLeft="30dp"
	    android:layout_height="match_parent"
	    soulwolf:mcAnimator="true"
	    soulwolf:mcTextSize="6sp"
	    soulwolf:mcPadding="5dp"
	    soulwolf:mcText="女生"
	    soulwolf:mcTextColor="@drawable/radio_button_text_selector"
	    soulwolf:mcButton="@drawable/radio_button_girl_selector"/>

</net.soulwolf.widget.materialradio.MaterialRadioGroup>
```

## Maven
	<dependency>
  	    <groupId>net.soulwolf.widget</groupId>
		<url>https://dl.bintray.com/soulwolf/maven</url>
  	    <artifactId>materialRadio</artifactId>
  	    <version>1.0.1</version>
	</dependency>
## Gradle
	allprojects {
       repositories {
          jcenter()
       }
	}
	
	compile 'net.soulwolf.widget:materialRadio:1.0.1'

## Developed by
 Ching Soulwolf - <a href='javascript:'>Ching.Soulwolf@gmail.com</a>


## License
	Copyright 2015 Soulwolf Ching
	Copyright 2015 The Android Open Source Project for MaterialRadioGroup
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	    http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
	
