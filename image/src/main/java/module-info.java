module image {
    exports org.example.image to org.example.security, security;
    requires java.desktop;
    requires software.amazon.awssdk.auth;
    requires software.amazon.awssdk.core;
    requires software.amazon.awssdk.regions;
    requires software.amazon.awssdk.services.rekognition;
    requires org.slf4j;
}