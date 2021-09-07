Scala Json
----------
>Scala json library benchmark and common test.

ScalaJs
-------
>Jsoniter, uPickle, Borer, Circe, ZioJson and PlayJson suport **ScalaJs**.

Test
----
1. sbt clean test

Benchmark
---------
>See Performance class for details.
1. sbt jmh:run
* Benchmark  Mode  Cnt  Score   Error  Units
* jsoniter   avgt    3  0.136 ± 0.002  us/op
* borer      avgt    3  0.230 ± 0.002  us/op
* circe      avgt    3  0.294 ± 0.001  us/op
* sprayjson  avgt    3  0.312 ± 0.003  us/op
* ziojson    avgt    3  0.442 ± 0.027  us/op
* upickle    avgt    3  0.454 ± 0.001  us/op
* playjson   avgt    3  1.539 ± 0.010  us/op
>Total time: 424 s (07:04), completed Sep 7, 2021 7:50:46 AM

* Benchmark  Mode  Cnt  Score    Error  Units
* jsoniter   avgt   10  0.103 ±  0.001  us/op
* borer      avgt   10  0.226 ±  0.001  us/op
* circe      avgt   10  0.288 ±  0.001  us/op
* sprayjson  avgt   10  0.311 ±  0.001  us/op
* ziojson    avgt   10  0.440 ±  0.001  us/op
* upickle    avgt   10  0.448 ±  0.001  us/op
* playjson   avgt   10  1.562 ±  0.005  us/op
>Total time: 1405 s (23:25), completed Sep 7, 2021 8:25:23 AM