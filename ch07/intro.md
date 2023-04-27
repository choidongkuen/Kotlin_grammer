## chap 07: 제네릭(Generic)

코틀린에도 제네릭을 지원한다. 자바와 비슷한 원리로 사용 가능하지만 `와일드 카드[?]` 사용하는 측면에 차이가 있다.

### [1] 코틀린에서의 제네릭

먼저 제네릭에 대해 간단하게 알아보자.
코트를 작성하다 보면 다양한 타이벵 동일한 로직을 적용하기 위해 코트를 재사용을 과도하게 하려는 경우가 있다.
예를 들어 파라미터를 전부 `Any` 로 받는다는 등 이러한 행위는 `타입 안정성` 을 저하시킬 수 있다.

이러한 상황을 `제네릭` 을 통해 해결할 수 있다.
자바에서는 기본적으로 `제네릭` 에서 타입 불변성을 강요했다. 이는 `만약 제네릭 함수가 파라미터 타입 T 를 받는다면 T의 부모 클래스나 자식 클래스를 사용하는 것이 불가능했다.`
이는 타입의 안정성을 확보하는 방향이다.

간단한 코드로 예를 들어보자.

```kotlin
open class Fruit
class Apple : Fruit()
class Banana : Fruit()


fun receive(fruits: Array<Fruit>) {
    println("Number of fruits : ${fruits.size}")
} // 오류 없이 실행
```

위의 코드에서 `receive` 함수의 파라미터로 Array<Apple> 혹은 Array<Banana> 는 올 수 없다.
앞에서도 말했듯이 타입 안정성 및 타입 불변성을 위해 T에 해당하는 타입만 올 수 있다.

```kotlin

fun receiveList(fruits: List<Fruit>) {
    println("Number : ${fruits.size}")

}
fun main() {
    val appleList: List<Apple> = listOf(Apple())
    receiveList(appleList)
}
```

위의 코드를 돌려보면 알겠지만 정상적으로 1이 출력된다. 앞서서 보았던 배열을 이용한 코드에서는 오류가 발생했지만 리스트를 이용한 경우는 왜 오류가 발생하지 않은걸끼?
이유는 `Array` 는 가변이지만 `List` 는 불변이기 때문이다. 즉 List는 아이템을 변경할 수 없기에 오류 없이 가능한것이다.
이처럼 코틀린은 `타입 불변성`을 중요하게 생각하는 언어이다.

###[2] 코틀린에서 와일드 카드 사용하기

자바에서는 `?` 를 이용해서 와일드 카드를 표현했습니다.
예를 들어 `<? extends T>` 라고 표현하는 경우 T 타입과 T를 상속하는 모든 하위 타입이 해당되며 `<? super T>` 라고 표현하는 경우 T 타입과 T 가 상속하는 모든 상위 타입이 해당됬습니다.
즉 T 타입 말고도 관련된 서브 타입을 허용하는 경우인데, 코틀린에서 와일드 카드 표현법에는 차이가 있습니다.

```kotlin
fun copyFromTo(from: Array<Fruit>, to: Array<Fruit>) {
    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun main() {
    val fruitBasket1 = Array<Fruit>(3) { _ -> Fruit() }
    val fruitBasket2 = Array<Fruit>(3) { _ -> Fruit() }
    copyFromTo(fruitBasket1, fruitBasket2)
}
```

코드에 있는 `copyFromTo` 함수는 from 배열의 객체를 순회하면서 to 배열로 값을 넣어주는 함수이다.
해당 코드는 별 문제 없이 작동하는데 이는 전달되는 두 배열 타입과 매개변수로 전달 받는 두 배열 타입이 일치하기 때문이다.

```kotlin
fun copyFromTo(from: Array<Fruit>, to: Array<Fruit>) {
    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun main() {
    val fruitsBasket1 = Array<Fruit>(3) { _ -> Apple() }
    val fruitsBasket2 = Array<Fruit>(3) { _ -> Fruit() }
}
```

해당 코드는 오류가 있는 코드입니다. `copyFromTo` 첫번째 인자에 `fruitsBasket1` 배열이 들어가게 되는데 타입이 맞지 않기 때문입니다.
하지만 앞에서도 설명했듯이 from 인자는 값을 읽는 용도이기 때문에 Fruit 의 하위 클래스가 전달되어도 문제가 없습니다.
이런 것을 타입이나 파생 타입에 접근하기 위한 파라미터 타입의 `공변성` 이라고 한다.
또한 동일한 타입은 아니지만 읽는 용도의 경우 하위 타입이 전달되는 것을 허용해주는 역할을 하는 것은 `out` 이다.

```kotlin
fun copyFromTo(from: Array<out Fruit>, to: Array<Fruit>) {
    for (i in from.indices) {
        to[i] = from[i]
    }
}

// -> 동일
```

`out` 을 통해 Fruit 타입과 Fruit 타입의 하위 타입이 들어갈 수 있다.
이는 마치 자바의 `<? extends Fruit>` 같은 역할을 한다.

이번에는 동일한 타입은 아니지만 쓰기 용도의 경우 상위 타입이 전달되는 것을 허용해주는 역할을 하는 `in` 에 대해 코드를 통해 알아보자.
만약 to 매개변수의 Fruit 타입이나 Fruit 의 상위 클래스를 전달하고 싶을 때는 어떻게 해야할까요? 코드와 함께 알아보겠습니다.

```kotlin
fun copyFromTo(from: Array<in Fruit>, to: Array<Fruit>) {
    for (i in from.indices) {
        to[i] = from[i]
    }
}
// -> 동일
```

이번에는 from 매개변수의 타입 변수에 `in` 을 사용했습니다.
이를 통해 상위 타입의 매개변수 또한 전달될 수 있습니다. 그리고 `out` 과 반대로 쓰기 용도인 경우 사용 가능합니다.
이를 `반공변성` 이라고 합니다.