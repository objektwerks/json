Scala 3 Json
------------
>Feature tests and performance benchmarks across 4 Scala 3 json libraries:
* Jsoniter, Circe, uPickle, ZioJson
>Borer, Play-Json and Scala-Json were removed due to **no** or **poor** Scala 3 support.

Test
----
1. sbt clean test

Benchmark
---------
>See Performance class for details.
1. sbt jmh:run

Results
-------
>Runtime Environment Zulu17.30+51-CA (build 17.0.1+12-LTS), Scala 2.13.7, Apple M1
1. jsoniter - 0.126
2. circe - 0.164
3. upickle - 0.353
4. ziojson - 0.380
>Total time: 1405s (23:25), 10 warmups, 10 iterations, in microseconds, completed 2021.12.12

>Runtime Environment Zulu17.30+51-CA (build 17.0.1+12-LTS), Scala 3.1.3-RC3, Apple M1
1. jsoniter - 0.124
2. circe - 0.181
3. ziojson - 0.331
4. upickle - 0.976
>Total time: 804 s (13:24), 10 warmups, 10 iterations, in microseconds, completed 2022.5.18