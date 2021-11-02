package dev.mbo.quarkus.sample.resource

import io.quarkus.test.junit.NativeImageTest

@NativeImageTest
class NativeHealthResourceIT : HealthResourceTest() { // Execute the same tests but in native mode.
}
