# MetaDataExtractor
MetaDataExtractor is a cross-platform tool for extracting metadata from files, supporting desktop, iOS, Android, and web (JS). It's open-source and user-friendly.

**Note :**  The AstroPlayer library is currently under development, and as such, some parts of the library may not work as expected. The Android platform is the only one that has been tested, while the Javascript platform is untested. The JVM and iOS platforms are not yet supported. Additionally, not all of the methods listed in the code may be available, as they are still being worked on. Certain functions may also not work as expected due to the ongoing development process.

# Usage
To use the library, add the following dependency to your app's `build.gradle` file: 

## Base module 

```kotlin
  implementation("com.github.Deaths-Door:MetaDataExtractor:base:0.1.1")
  implementation("com.github.Deaths-Door:MetaDataExtractor:base-android:0.1.1")
  implementation("com.github.Deaths-Door:MetaDataExtractor:base-desktop:0.1.1")
  implementation("com.github.Deaths-Door:MetaDataExtractor:base-js:0.1.1")
```

## Music Module

```kotlin
  implementation("com.github.Deaths-Door:MetaDataExtractor:music:0.1.1")
  implementation("com.github.Deaths-Door:MetaDataExtractor:music-android:0.1.1")
  implementation("com.github.Deaths-Door:MetaDataExtractor:music-desktop:0.1.1")
  implementation("com.github.Deaths-Door:MetaDataExtractor:music-js:0.1.1")
```

# Contribution
 Any contributions, whether they are large or small, are greatly appreciated. This can include major features, bug fixes, additional language translations, recommendations, or unit/integration tests.
To contribute, please follow these steps:
-Fork the repository and create your own branch for your changes.
- Make your changes and ensure that they are thoroughly tested.
- Submit a pull request with a detailed description of your changes and the problem it solves.
- All contributions will be thoroughly reviewed and discussed before being merged. Please ensure that your contributions align with the project's goals and coding standards.

Thank you for contributing to this project!
