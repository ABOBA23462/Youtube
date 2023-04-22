plugins {
    id("com.android.application")
    kotlin("android")

    //safeargs
    id("androidx.navigation.safeargs")

    //kapt
    id("kotlin-kapt")

    //hilt
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.youtube"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.youtube"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        //viewBinding
        viewBinding = true
    }
}

dependencies {
    //core
    implementation("androidx.core:core-ktx:1.10.0")

    //AppCompat
    implementation("androidx.appcompat:appcompat:1.6.1")

    //Material Design
    implementation("com.google.android.material:material:1.8.0")

    //UI Companents
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    //Livedata
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")

    //ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Retrofit 2
    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    //Gson converter
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    // OkHttp
    implementation(platform("com.squareup.okhttp3:okhttp-bom:5.0.0-alpha.6"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    // Navigation
    val navVersion = "2.5.3"

    //   implementation
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.15.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.0")

    // ViewBindingPropertyDelegate
    val view_binding_property_delegate = "1.5.3"

    //noinspection GradleDependency
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:$view_binding_property_delegate")

    //view pager
    implementation("androidx.viewpager2:viewpager2:1.1.0-beta01")

    //Hilt
    val hilt_version = "2.45"
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-compiler:$hilt_version")

    // paging 3
    val paging_version = "3.1.1"
    //noinspection GradleDependency
    implementation ("androidx.paging:paging-runtime:$paging_version")
}