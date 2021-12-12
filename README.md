Scala Json
----------
>Feature tests and performance benchmarks across 7 Scala json libraries:
* SprayJson, Jsoniter, Borer, Circe, uPickle, ZioJson and PlayJson.

Test
----
1. sbt clean test

Benchmark
---------
>See Performance class for details.
1. sbt jmh:run

Results
-------
>OpenJDK Runtime Environment Zulu17.30+51-CA (build 17.0.1+12-LTS), Scala 2.13.7, Apple M1
1. sprayjson - 0.071
1. jsoniter - 0.126
2. borer - 0.138
3. circe - 0.164
5. upickle - 0.353
6. ziojson - 0.380
7. playjson - 1.250
>Total time: 1405s (23:25), 10 warmups, 10 iterations, in microseconds, completed 2021.12.12