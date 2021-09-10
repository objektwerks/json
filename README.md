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
1. jsoniter - 0.136
2. borer - 0.230
3. circe - 0.294
4. sprayjson - 0.312
5. ziojson - 0.442
6. upickle - 0.454
7. playjson - 1.539
>Total time: 07:04, 3 warmups, 3 iterations, in microseconds, completed 2021.9.7

1. jsoniter - 0.103
2. borer - 0.226
3. circe - 0.288
4. sprayjson - 0.311
5. ziojson - 0.440
6. upickle - 0.448
7. playjson - 1.562
>Total time: 23:25, 10 warmups, 10 iterations, in microseconds, completed 2021.9.7
