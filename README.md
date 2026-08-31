# Aerial Ladder Watch Face (Pixel Watch / Wear OS)

A Watch Face Format (WFF) v1 watch face featuring a fire-service aerial ladder truck as an analog clock.

![Watch face preview (10:00)](watchface/src/main/res/drawable/preview.png)

## Display

- Fire engine seen from above = hour hand
- Turntable = center
- Extended aerial ladder + rescue basket = minute hand
- At the top of the hour (`MINUTE == 0`) the two blue emergency lights flash alternately for 60 seconds
- The blue lights are disabled in ambient / always-on display mode
- The subtle dial reacts slightly to the watch's tilt; the actual hands stay geometrically fixed to the center so the time remains accurate

## Project

The watch face is implemented declaratively in `watchface/src/main/res/raw/watchface.xml`. It intentionally contains no app code; the manifest uses `android:hasCode="false"`.

## Installing with Android Studio

1. Open the project folder in Android Studio.
2. If Android Studio asks for Android SDK 35, let it install.
3. If no Gradle wrapper is available yet, run once from an existing Gradle installation:
   `gradle wrapper --gradle-version 9.2.1`
4. Connect the Pixel Watch to Android Studio via wireless debugging / ADB.
5. Launch the run configuration for the `watchface` module.
6. Select the `Drehleiter` watch face on the watch.

## Notes

- The project targets Wear OS API 33+, which makes it suitable for the Pixel Watch 1.
- The blue lights flash intentionally instead of staying lit. The logic lives directly in `watchface.xml` and can easily be changed to a steady light.
- The geometry is built entirely from WFF vector primitives; the watch face itself has no bitmap dependency.

<!-- CI smoke test -->
