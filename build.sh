#!/bin/sh

rm -rf build/modules/*
rm -rf build/libs/*

javac -d build/modules/io.twasyl.demo.core core/src/main/java/module-info.java core/src/main/java/io/twasyl/demo/core/Generator.java
jar --create --file=build/libs/io.twasyl.demo.core@1.0.jar --module-version=1.0 -C build/modules/io.twasyl.demo.core .

javac -d build/modules/io.twasyl.demo.fx --module-path=build/modules fx/src/main/java/io/twasyl/demo/fx/DemoFXApp.java fx/src/main/java/io/twasyl/demo/fx/controllers/DemoFXController.java fx/src/main/java/module-info.java
cp -R fx/src/main/resources/io/twasyl/demo/fx/* build/modules/io.twasyl.demo.fx/io/twasyl/demo/fx
jar --create --file=build/libs/io.twasyl.demo.fx@1.0.jar --manifest=fx/src/main/resources/META-INF/MANIFEST.MF --main-class=io.twasyl.demo.fx.DemoFXApp -C build/modules/io.twasyl.demo.fx .