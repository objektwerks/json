Scala Json
----------
>Test performance in milliseconds:

1. Jsoniter : 15
2. SprayJson : 23
3. uPickle : 25
4. Borer : 26
5. Circe : 123
6. ZioJson : 145
7. PlayJson : 152

>Notes:
* Tests implement a common template, with UPicleTest being a bit more involved.
* So performance numbers should ***not*** be taken ***too*** seriously.

Test
----
1. sbt clean test