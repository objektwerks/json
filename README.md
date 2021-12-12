Scala Json
----------
>Feature tests and performance benchmarks across 7 Scala json libraries:
* Jsoniter, Borer, Circe, SprayJson, ZioJson, uPickle and PlayJson.

Test
----
1. sbt clean test

Benchmark
---------
>See Performance class for details.
1. sbt jmh:run

Results
-------
>OpenJDK Runtime Environment Zulu17.30+51-CA (build 17.0.1+12-LTS), Scala 2.13.7
1. jsoniter - 0.105
2. borer - 0.201
3. circe - 0.288
4. sprayjson - 0.305
5. ziojson - 0.441
6. upickle - 0.464
7. playjson - 1.534
>Total time: 1412 s (23:32), 10 warmups, 10 iterations, in microseconds, completed 2021.11.5