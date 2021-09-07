Scala Json
----------
>Scala json library benchmark and common test.

Test
----
1. sbt clean test

Benchmark
---------
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

ScalaJs
-------
>Jsoniter, uPickle, Borer, Circe, ZioJson and PlayJson suport **ScalaJs**.