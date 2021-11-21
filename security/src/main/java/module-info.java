module security {
    requires image;
    requires java.desktop;
    requires com.google.gson;
    requires java.prefs;
    requires com.google.common;
    exports org.example.security.data to com.udacity.catpoint.app;
    exports org.example.security.application to com.udacity.catpoint.app;

    opens org.example.security.service;
}