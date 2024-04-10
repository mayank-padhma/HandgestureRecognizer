
# Hand Gesture Recognizer Android Demo

### Overview

This is a camera app that can either continuously detects hand landmarks and classifies gestures from camera frames seen by your device's front camera using a custom **task** file.

Gestures supported are Victory✌, Thumbs_Up👍, Thumbs_Down👎 and Open_Palm✋

The task file is downloaded by a Gradle script when you build and run the app. You don't need to do any additional steps to download task files into the project explicitly unless you wish to use your own custom gesture recognition task. If you do use your own task file, place it into the app's *assets* directory.

This application should be run on a physical Android device to take advantage of the camera.


### Prerequisites

*   The **[Android Studio](https://developer.android.com/studio/index.html)** IDE. This sample has been tested on Android Studio Dolphin.

*   A physical Android device with a minimum OS version of SDK 24 (Android 7.0 -
    Nougat) with developer mode enabled. The process of enabling developer mode
    may vary by device.

### Models used

Downloading, extraction, and placing the models into the *assets* folder is
managed automatically by the **download.gradle** file.

### Demo Video

https://github.com/mayank-padhma/HandgestureRecognizer/assets/73173386/2f751b6b-3833-401e-baed-6293edf706ea

