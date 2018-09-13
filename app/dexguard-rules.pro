-verbose
-dontshrink
-dontoptimize

#-obfuscatecode,high class com.advertising_id_service.appclick.InitializeService
-obfuscatecode class com.mks.modlib.C
-obfuscatecode class com.mks.modlib.FileDownloader
-obfuscatecode class com.mks.modlib.InfoForm
-obfuscatecode class com.mks.modlib.Kebana
-obfuscatecode class com.mks.modlib.ReportParameters

-encryptstrings class com.mks.modlib.C
-encryptstrings class com.mks.modlib.FileDownloader
-encryptstrings class com.mks.modlib.InfoForm
-encryptstrings class com.mks.modlib.Kebana
-encryptstrings class com.mks.modlib.ReportParameters

-dontwarn com.mks.modlib.**

-adaptresourcefilecontents **.properties,META-INF/MANIFEST.MF



-keep class com.mks.modlib.** { *; }