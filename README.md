Scala Json
----------
>Test performance in milliseconds:

1. Jsoniter : 17
2. SprayJson : 23
3. Borer : 26
4. uPickle : 28
5. Circe : 122
7. ZioJson : 147
6. PlayJson : 150

>Note:
* Tests are similar, with UPicleTest being a bit more involved.
* Logging is used in all tests. 
* So performance numbers should ***not*** be taken ***too*** seriously.

Test
----
1. sbt clean test