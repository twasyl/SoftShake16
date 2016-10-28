# Structure

This application is a really simple password generator developed in the JDK9 modular way meaning it is composed of two modules:

* `core` which provides the passwords' generator
* `fx` which is the JavaFX UI which uses the `core` module




# Prerequisites

In order to build the application you will need an early access build of the JDK9 with Jigsaw which can be found on the [OpenJDK website](https://jdk9.java.net/jigsaw/).

During the demonstration the JDK 9 build 141 was used.

# Compiling

## core module

In order to build the `core` module, you can use the following command:

```Shell
javac -d build/modules/io.twasyl.demo.core core/src/main/java/module-info.java core/src/main/java/io/twasyl/demo/core/Generator.java
```

Compiled class will be available in the `build/modules/io.twasyl.demo.core` directory.

## fx module

In order to build the `fx` module, you can use the following command:

```shell
javac -d build/modules/io.twasyl.demo.fx --module-path=build/modules fx/src/main/java/io/twasyl/demo/fx/DemoFXApp.java fx/src/main/java/io/twasyl/demo/fx/controllers/DemoFXController.java fx/src/main/java/module-info.java
```

Compiled class will be available in the `build/modules/io.twasyl.demo.fx` directory.

**WARNING**: don't forget to manually copy the FXML and CSS files to this directory and take care to respect the package architecture of the sources.

# Bundle

## core module

In order to create a modular JAR file for the `core` module you can execute the following command:

```shell
jar --create --file=build/libs/io.twasyl.demo.core@1.0.jar --module-version=1.0 -C build/modules/io.twasyl.demo.core .
```

The modular JAR file will be present in the `build/libs` directory.

## fx module

In order to create a modular JAR file for the `core` module you can execute the following command:

```shell
jar --create --file=build/libs/io.twasyl.demo.fx@1.0.jar --manifest=fx/src/main/resources/META-INF/MANIFEST.MF --main-class=io.twasyl.demo.fx.DemoFXApp -C build/modules/io.twasyl.demo.fx .
```

The modular JAR file will be present in the `build/libs` directory.

## Native bundle

You can create a native bundle that contains a JRE using the following command:

```shell
javapackager -deploy -native image -outdir . -outfile DemoFX -p build/libs -m io.twasyl.demo.fx -name DemoFX -v
```

You will find the bundle in the `bundles/DemoFX` folder.

# Execution

If you want to execute the UI modular JAR (not the bundle), you can use the following command:

```shell
java --module-path build/libs -m io.twasyl.demo.fx
```

Or :

```shell
java -p build/libs -m io.twasyl.demo.fx
```