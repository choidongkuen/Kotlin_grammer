## chap02 : 빠르게 살펴보는 코틀린 문법

코틀린은 자바에 뿌리를 두고 있어 자바와 같은 점이 많다.
코틀린에서도 클래스를 선언할 때 Class 라는 키워드를 사용하며, 자바에서의 interface, enum 클래스
모두 갖고 있다.
하지만 자바에는 없는 data 클래스와 같은 유용한 클래스가 추가되기도 한다.

### [1] Kotlin Class 특징

1. 자바와 달리 클래스 내부에 생성자를 만들지 않고 클래스 선언부에서 `constructor` 키워드를 사용하여 생성자를 만듬
2. 자바와 같이 여러 생성자를 가질 수 있으며 추가적인 생성자는 `this()` 를 통해 기본 생성자를 호출애야 함
3. `init 블록`을 통해 생성자에 추가적인 기능을 구현할 수 있음

### [2] val Vs var

1. val : 자바의 final 과 같이 수정이 불가능한 변수를 의미한다. val 로 선언된 변수는 변수 타입을 쓰지 않아도 코틀린에서 자동으로 `Type Casting` 해줌
2. var : 변수가 변경 가능성이 있다면 선언
3. Kotlin 에서는 val 사용을 권장 -> 개발자의 의도치 않은 값 변경을 피하기 위해(안정성 good)
4. 만약 val 로 선언했는데 해당 값을 변경하는 코드가 있다면 `val cannot be reassigned` 에러 발생 ❗️

### [3] 접근 제한자

1. `private`,`protected`,`internal`,`public` 존재함
2. `internal` -> 같은 모듈(컴파일 집단)에 한해서 접근익 가능 ☝️

```kotlin
open class OuterClass {
    private val a = 1 // OuterClass 내부에서만 접근 가능
    protected val b = 2 // 상속을 받은 클래스에서만 접근 가능
    internal val c = 3 // 같은 모듈 안에 클래스에서 접근 가능
    val d = 4 // 어디서든 가능(default) -> 접근 제한이 필요한 상황이라면 꼭 명시해야함(else Public)
}
```

### [4] 상속

1. 자바에서의 extends -> 코틀린에서의 :
2. 상속을 당하는 부모 클래스는 `open` 키워드 필수
3. 부모 클래스이 함수를 `Overriding` 하기 위해서는 `open` 필수 (default : final)
4. `super`를 통해 부모 클래스의 생성자를 초기화해야함

```kotlin
open class Figure(vertex: Int) {
    open fun onFinishDraw() { // 오버라이딩 가능
        // ..
    }

    fun draw() { // 오버라이딩 불가
        // ..
    }
}

class Triangle : Figure(3) {
    //...
}
```

```kotlin

import javax.naming.Context

open class AlertDialog(val context: Context)

class CustomDialog : AlertDialog {
    constructor(context: Context) : super(context) // super 를 통해 부모 클래스 초기화
}


```