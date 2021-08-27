Scala Json
----------
>Test performance in milliseconds:

1. Borer : 26
2. Circe : 122
3. Jsoniter : 17
4. PlayJson : 150
5. SprayJson : 23
6. uPickle : 28
7. ZioJson : 147

>Note:
* Tests are similar, with UPicleTest being a bit more involved.
* Logging is used in all tests. 
* So performance numbers should ***not*** be taken ***too*** seriously.

Test
----
1. sbt clean test