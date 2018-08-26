# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement # Retrofit
-dontwarn com.squareup.okhttp.** # Picasso
-dontnote retrofit2.Platform # Retrofit
-dontwarn retrofit2.Platform$Java8 # Retrofit
-dontwarn okio.** # Okio
-dontwarn okhttp3.** # Okhttp
-dontwarn okio.** # Okhttp, Moshi
-dontwarn javax.annotation.** # Okhttp, Moshi
-dontwarn org.conscrypt.** # Okhttp
-keep @com.squareup.moshi.JsonQualifier interface * # Moshi
-keepattributes Exceptions # Retrofit
-keepattributes Signature # Retrofit
-keepattributes SourceFile,LineNumberTable
-keepclasseswithmembers class * { # Moshi
    @com.squareup.moshi.* <methods>;
}
-keepclassmembernames,allowobfuscation interface * { # Retrofit
    @retrofit2.http.* <methods>;
}
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase # Okhttp


