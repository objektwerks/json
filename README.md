Scala Json
----------
>Scala json library common tests and performance benchmark.

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

Results
-------
>OpenJDK Runtime Environment (Zulu 8.56.0.23-CA-macos-aarch64) (build 1.8.0_302-b08)
1. jsoniter - 0.103
2. borer - 0.226
3. circe - 0.288
4. sprayjson - 0.311
5. ziojson - 0.440
6. upickle - 0.448
7. playjson - 1.562
>Total time: 23:25, 10 warmups, 10 iterations, in microseconds, completed 2021.9.7