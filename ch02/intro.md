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

1. 자바에서의 extends -> 코틀린에서의 `:`
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

### [5] Interface

1. 자바와 달리 kotlin 에서는 interface 내 함수가 바디를 가질 수 있으며, 멤버 변수를 추상 변수로 사용 가능
2. 클래스의 상속과 마찬가지로 `:` 사용하여 구현

```kotlin
interface FinishDraw {
    var distance: Int
    open fun onFinishDraw()
}

open class Figure(var vertex: Int) : FinishDraw {
    override var distance: Int
        get() = vertex
        set(value) {

        }

    override fun onFinishDraw() {
        // ...
    }
}
```

```kotlin
// 여러 부모 클래스 및 인터페이스를 구현하는 경우 함수 명이 동일할 때
open class A {
    open fun f() {}
    fun a() {}
}

interface B {
    fun f() {}
    fun b() {}
}

class C : A(), B {
    override fun f() {
        super<A>.f()
        super<B>.f() // 부모인 A,B 의 동일한 함수인 f 호출 시 명시적으로 어떤 부모인지 명시해야 함
    }
}
```

### [6] 다양한 클래스 타입

#### 1. data 클래스

- 데이터만을 가지는 클래스
- 반드시 디폴트 생성자를 선언해주어야 하며, 인자는 val 혹은 var 키워드를 꼭 사양해야 함
- 컴파일러에서 자동으로 `equal()`, `toString()` 생성
- 내부에 함수를 가지지 않

```kotlin
data class Data(var name: String, var age: Int)

// copy 
val data01: Data = Data("jame", 30)
val data02: Data = data01.copy(age = 70)
// age 값을 변경한 복사 데이터 클래스 인스턴스 생성
```

#### 2. enum 클래스

- 타입을 담는 클래스

```kotlin
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}
```

#### 3. sealed 클래스

- 동일한 파일에서는 상속이 가능하나 다른 외부에서는 상속 불가능
- 무분별한 상속을 제한하기 위한 클래스

```kotlin
package com.example.kotlin.fisrtcapter

sealed class Expression {
    // ...
}

data class Sum(val num1: Int, val num2: Int) : Expression() // 동일한 파일이므로 상속 가능
```

#### 4. object 타입

- 자바의 `anonymous` 와 같음

```kotlin
val webView = WebView(mCtx)
webView.setWebViewClient(object : WebViewClient() {
    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
    }
})
```

```kotlin
// 한번만 생성되어 사용되는 클래스에도 사용됨

interface Shape {
    fun onDraw()
}

val triangle = object : Shape { // 한번만 사용되는 인스턴스
    override fun onDraw() {
        // ...
    }
}

```

- object 타입은 함수의 리턴값으로도 사용 -> 이 함수를 객체로 넘겨준다는 의미