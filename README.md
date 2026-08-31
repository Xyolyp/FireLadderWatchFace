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

## How to install (prebuilt APK)

Every commit to `main` publishes a signed APK under [Releases](https://github.com/Xyolyp/FireLadderWatchFace/releases).

Preparation on the watch (needed for either route — Wear OS only allows sideloading through wireless debugging):

1. Enable developer options: Settings → System → About → tap "Build number" seven times.
2. Enable Settings → Developer options → Wireless debugging. The watch must be on the same Wi-Fi network as the phone or computer.

Updates install the same way as a first install; since all releases are signed with the same key, no uninstall is needed. After installing, long-press the current watch face on the watch and select `Drehleiter` from the picker.

### With an Android phone (no computer, no adb)

1. Install [Wear Installer 2](https://play.google.com/store/apps/details?id=org.freepoc.wearinstaller2) from the Play Store on the phone.
2. Download the `FireLadderWatchFace-*.apk` from the latest release onto the phone.
3. In Wear Installer 2, enter the watch's IP address (shown under Wireless debugging) and pair using the code from "Pair new device" on the watch.
4. On the "Custom APK" tab, select the downloaded APK and install it.

### With a computer (adb)

1. Download the `FireLadderWatchFace-*.apk` from the latest release.
2. In Wireless debugging on the watch, choose "Pair new device" and pair from the computer:
   ```
   adb pair <ip>:<pairing-port>   # enter the code shown on the watch
   adb connect <ip>:<port>        # port shown on the Wireless debugging main screen
   ```
3. Install the APK:
   ```
   adb install FireLadderWatchFace-<version>.apk
   ```

## Building and installing with Android Studio

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
