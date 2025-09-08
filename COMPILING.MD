# Compiling

Before beginning work on this mod you first need to publish Estrogen to your maven local.
Afterward you need to run forge data generators like so:

```shell
./gradlew runForgeData
```

If you're using INTELLIJ for development it might be helpful to run:

```shell
./gradlew idea
```

and you're pretty much set.
use

```shell
./gradlew runForgeClient
```

to test your changes on a minecraft client.
see [DevAuth](https://github.com/DJtheRedstoner/DevAuth) on how to login into this local minecraft instance with
your actual minecraft account.

## GameTests

Due to a known bug with cloche game-tests will need to be run manually by creating a world and running

```
/test [TEST NAME]
```

currently there is only one test, and it is named:
`src/main/kotlin/dev/mayaqq/createestrogen/test/CentrifugeTests.kt` in-game referred to as
`testcentrifugecrafts`.
if you try to run the test task cloche will run Create's tests and will always fail.

## Notes

- Remember to always run the forge data generator after changing anything that can effect data generation.
  of most importance is the directory `src/data` and `src/forgeData` as those directly work with data generation.
