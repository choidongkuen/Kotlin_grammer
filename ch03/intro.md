## chap03 : 함수

Kotlin 에서의 함수는 자바와 달리 함수를 선언하는 키워드 `fun` 이 별도로 존재한다.

### [1]. 함수 선언

> fun 함수 이름 (인자 : 인자 타입, ..) : 리턴 타입 {
> ...
> }

`fun` 다음의 바로 함수의 이름이 오고, 리턴 타입이 제일 뒤로 간다.
그리고 리턴 타입을 정의하기 위해 `:` 기호를 사용한다.
또한 리턴 타입이 하나인 경우 다음과 같이 줄일 수 있다.

> fun 함수 이름 (인자 : 인자 타입, ..) : 리턴 타입 = 함수

Int 형 타입의 x,y 를 더하는 함수를 간단하게 예시로 들어보자.

> fun add(x:Int, y:Int) : Int = x + y (1)


> fun add(x:Int, y:Int) = x + y (2)

`(2)` 함수 처럼 리턴 값이 인자형과 동일한 경우 함수의 리턴 타입은 생략이 가능하다.

또한 다음과 같이 함수의 인자의 `기본값` 을 설정할 수 있다.

> fun add(x:Int, y:Int = 10) = x + y

### [2] 변수 타입

자바의 `기본형` 타입과 달리 Kotlin 은 변수 타입의 시작이 대문자이다.
Int,Double,Float ..

1. Kotlin 은 자동 형 변환 기능을 허용하지 않는다.

- 자바에서는 작은 타입의 데이터를 큰 타입의 변수로 지정할 수 있지만, Kotlin 은 불가하다.
- 명시적으로 타입변환이 필요하다.

> // 자바 double x = intVal(int 100) -> 가능
>
>// 코틀린 var d: Double = intVal.toDouble() -> 명시적으로 변환 필요

2. int 에서 char 타입 변환이 자동으로 되지 않는다.

> // 자바 char x = 65 -> 65 아스키 코드 값을 갖는 A
>
> // 코틀린 val x : Char = 65 -> 자동으로 변환 x
>
> val x : Char = 65.toChar() -> 명시적으로 변환 필요
>

3. Kotlin 에서 가능한 비트 연산자

|  코틀린  |         일반 형         |
|:-----:|:--------------------:|
|  shl  |    shift left(<<)    |
|  shr  |   shift right(>>)    |
| ushr  | unsigned shift right |
|  and  |          &           |
|  or   |          \           |                   
|  xor  |          ~           |
| inv() |          !           |

4. varag 를 통해 하나의 변수로 다양한 변수 값을 받을 수 있다.

```kotlin
fun add(varag numbers: Int): Int {
    var total: Int = 0
    for (n in numbers) {
        total += n
    }
    return total
}
```

