# android-1-liner
Android suffers from a lot of boiler plate codes. This is a collection of Android commonly 
used codes and utilities packaged as a one liner util. 

## Goals

* Try to solve the 80% common use cases as a one line code.
* Simplicity over flexibility
* Avoid 3rd party dependencies.

## How to integrate

The AAR is available in https://jitpack.io/#bubblecrisis/android-1-liner

In the root gradle file:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

In the module gradle file:

```
dependencies {
    compile 'com.github.bubblecrisis:android-1-liner:-SNAPSHOT'
      :
```    

## List of modules

### Data Manipulation

* ArrayUtils
* DateUtils
* FormatUtils
* ImageUtils
* NullUtils
* ResourceUtils
* StringUtils

### Device Related

* KeyboardUtils
* LocationUtils

### UI Related

* ActivityUtils
* AnimationUtils
* DialogUtils
* MapUtils
* NetworkUtils
* ProgressUtils

### UI Listeners Support

* OnSwipeTouchListner
