1. Do `npm install --save git+https://github.com/sourav15/ReactandroidWrapper.git` in your main project.
2. Link the library:
    * Add the following to `android/settings.gradle`:
        ```
        include ':livquiksdk'
        project(':livquiksdk').projectDir = new File(settingsDir, '../node_modules/livquiksdk/android')
        ```

    * Add the following to `android/app/build.gradle`:
        ```xml
        ...

        dependencies {
            ...
            compile project(':livquiksdk')
        }
        ```
    * Add the following to `android/app/src/main/java/**/MainApplication.java`:
        ```java
        package com.awesomeproject;

        import com.livquik.quikwallet.Package;  // add this for livquiksdk package

        public class MainApplication extends Application implements ReactApplication {

            @Override
            protected List<ReactPackage> getPackages() {
                return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
                    new Package()     // add this for livquiksdk package
                );
            }
        }
        ```
3. Simply `import/require` it by the name defined in your library's `package.json`:

    ```javascript
    import qwsdk from 'livquiksdk';
    qwsdk.init('Mobile','PartnerId','signature','ENV');
    ```
