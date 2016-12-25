# android-1-liner
Android suffers with a lot of boiler plate codes. This is a collection of Android commonly 
used codes and utilities packaged as a one liner util. 

## Goals

* Try to solve the 80% common use cases as a one line code.
* Simplicity over flexibility
* Avoid 3rd party dependencies.

## How to integrate

To include the module as source from the repo:

1. Clone the repo.

2. In your app ```settings.gradle```:

```
include ':app', ':Android1liner'
project(':Android1liner').projectDir = new File(settingsDir, '../Android1liner/aar')
```

3. In your app ```build.gradle```:

```
dependencies {
    compile project(":Android1liner")
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
