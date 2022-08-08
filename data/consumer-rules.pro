# ------------- Kotlin Serialization -------------

-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.AnnotationsKt # core serialization annotations

# kotlinx-serialization-json specific. Add this if you have java.lang.NoClassDefFoundError kotlinx.serialization.json.JsonObjectSerializer
-keepclassmembers class kotlinx.serialization.json.** {
    *** Companion;
}
-keepclasseswithmembers class kotlinx.serialization.json.** {
    kotlinx.serialization.KSerializer serializer(...);
}

-keep,includedescriptorclasses class com.top100.data.remote.**$$serializer { *; }
-keepclassmembers class com.top100.data.remote.** {
    *** Companion;
}
-keepclasseswithmembers class com.top100.data.remote.** {
    kotlinx.serialization.KSerializer serializer(...);
}

# ------------ End Models -----------