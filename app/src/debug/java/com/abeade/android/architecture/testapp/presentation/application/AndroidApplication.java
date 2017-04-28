package com.abeade.android.architecture.testapp.presentation.application;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

public class AndroidApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        initializeStetho();
        initializeLeakCanary();
    }

    protected void initializeStetho() {
        Stetho.InitializerBuilder initializerBuilder = Stetho.newInitializerBuilder(this);

        // Enable Chrome DevTools
        initializerBuilder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this));

        // Enable command line interface
        initializerBuilder.enableDumpapp(Stetho.defaultDumperPluginsProvider(this));

        // Use the InitializerBuilder to generate an Initializer
        Stetho.Initializer initializer = initializerBuilder.build();

        // Initialize Stetho with the Initializer
        Stetho.initialize(initializer);
    }

    protected void initializeLeakCanary() {
        LeakCanary.install(this);
    }
}
