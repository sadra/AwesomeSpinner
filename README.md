# AwesomeSpinner
Awesome Android Spinner

[![](https://jitpack.io/v/amlashi-sadra/AwesomeSpinner.svg)](https://jitpack.io/#amlashi-sadra/AwesomeSpinner)

## Including the library

**Step 1.** Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

**Step 2.** Add the dependency:
```groovy
compile 'com.github.amlashi-sadra:AwesomeSpinner:1.0.1'
```

## How To Use

**Step 1.** From very firts, you should add the **Awsome Spinner** component inside of your layout:
```xml
    <com.isapanah.awesomespinner.AwesomeSpinner
        android:id="@+id/my_spinner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
```

- If you want to add a default value for hint just add the `spinnerHint` into your component
- The default spinner has `RTL` direction, if you want to declare the direction of spinner just add the `spinnerDirection` to **RTL** or **LTR**
so the complete example with **LTR** direction and hint text to **Select a category** is:
```xml
    <com.isapanah.awesomespinner.AwesomeSpinner
        android:id="@+id/my_spinner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:spinnerDirection="ltr"
        app:spinnerHint="Select a category" />
```

**Step 2.** Define the component class into your activity:
```java
AwesomeSpinner my_spinner = (AwesomeSpinner) findViewById(R.id.my_spinner);
```
Then Create your adapter. For now, there is two way to define apadter:
- With String List, define a `List<String>` in your activity and the attach that with your adapter:
```java
List<String> categories = new ArrayList<String>();
categories.add("Automobile");
categories.add("Ariplane");

ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

my_spinner.setAdapter(categoriesAdapter);
```
- With String-Array, define a `string-array` in your `strings.xml` file and attach that with your adapter:
```java
ArrayAdapter<CharSequence> provincesAdapter = ArrayAdapter.createFromResource(this, R.array.iran_provinces, android.R.layout.simple_spinner_item);

spinnerRTL.setAdapter(provincesAdapter, 0);
```

**Step 3.** For final step, you can create a **Listener** for listening on item selection:
```java
my_spinner.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
    @Override
    public void onItemSelected(int position, String itemAtPosition) {
        //TODO YOUR ACTIONS
    }
});
```

### Additional controls
there is some controls for your spinner:

| Control | Requierement | Result |
| ------------- |:-------------:| -----:|
| getSelectedItem() | - | `String`: returns the selected item |
| isSelected() | - | `boolean`: returns **true** if any item selected, and vice versa |


You can see the [EXAMPLE PROJECT](https://github.com/amlashi-sadra/AwesomeSpinner/tree/master/app/src/main) for more infromation.



## Developed by

Sadra Isapanag Amlashi

Website: [isapanah.com](http://isapanah.com)

Twitter: [@sadra_amlashi](https://twitter.com/sadra_amlashi)

## License

The MIT License (MIT)

Copyright (c) 2015 Sergio Rodrigo

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
