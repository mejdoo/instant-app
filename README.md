# instant-app

Google Play Instant apps is a great feature provided by Google Play which lets Android users try apps without an installation.

On the other hand by using instant apps developers are given the opportunity to showcase the most important feature of their app and thus overcome the target market for the complete version of the app.

## Main steps to create an instant app

- Create a new module for your instant app.
- Use the same ```applicationId``` of your installed app for your instant app.
- Declare instant app dependencies: ```implementation "com.google.android.gms:play-services-instantapps:17.0.0"```

- Update the target sandbox version and declare your module as instant-enabled app. Just add the following code to ```AndroidManifest.xml``` below your instant app module.

```
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:dist="http://schemas.android.com/apk/distribution"
    android:targetSandboxVersion="2">

    <dist:module dist:instant="true" />
    <application 
    ------------
    </application>
    
</manifest>
```

- Customize your instant app experience. Follow the guidelines of UX best practices for apps on Google Play Instant https://developer.android.com/topic/google-play-instant/best-practices/apps
- Before releasing your app bundles, make sure to define the correct version codes for your instant and installed apps. The version code of your app's instant experience needs to be less than the version code of the installable app. The expectation is that users move from the Google Play Instant experience to downloading and installing the app onto their device. The Android framework considers this transition to be an app update. To make sure that you follow the versioning scheme that users expect, follow one of these strategies:
Restart the version codes for the Google Play Instant experience at 1.
Increase the version code of the installable APK by a large number, such as 1000, to ensure that there is enough space for your instant experience's version number to increase.
