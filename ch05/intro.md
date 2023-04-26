## chap05 : 콜렉션

자바에서는 자료구조 클래스를 사용할 때 수정에 대한 제약이 없다.
하지만 코틀린은 다른 언어들과 다르게 콜렉션이나 map 자료형에 대해 읽기 전용 모드 객체와 수정이 가능한 객체로 나누어 놓았다.

### [1] 변경가능한 콜렉션과 변경 불가능한 콜렉션

자바의 콜렉션은 모두 변경 가능하다. 즉 수정에 대한 제약이 없습니다.
하지만 Kotlin 에서의 콜렉션에는 수정에 제약이 존재한다.<br>
Kotlin 에서는 다른 언어들과 다르게 `읽기 전용 객체와`,`수정이 가능한 객체` 로 나누어 놓았다.

> 읽기 전용 콜렉션 : listOf(),mapOf(),setOf()
>
> 수정 가능한 콜렉션 : mutableListOf(),mutableMapOf()

```kotlin
val immutableList = listOf(1, 2, 3, 4)
print(immutableList.get(2))

val immutableMap = mapOf(1 to "one", 2 to "two")
print(immutableMap.get(1))
// add 나 remove 같은 수정 함수가 존재하지 않음
```

```kotlin
var mutableList = mutableListOf(12, 3)
mutableList.add(2)
mutableList.remove(3)
// add 나 remove 같은 수정 함수가 존재함
```

### [2] 코틀린 콜렉션의 다양한 기능

Kotlin 의 콜렉션은 다양한 함수를 제공한다.

1. filterNotNull

- 콜렉션 원소 중 null 이 아닌 것만 필터링하는 함수

```kotlin
val list = listOf(1, 2, null, null)
var notNullList = list.filterNotNull()

print(notNullList)
// [1,2]
```

2. 추가 삭제 함수

- 콜렉션 원소를 추가하거나 삭제하는 함수

```kotlin
val map = mapOf(1 to "One", 2 to "Two")

var newMap = map - 1 // key 가 1인 쌍 삭제
newMap += 3 to "Three" // key가 3인 쌍 추가


val list = listOf(1, 2, 3, 4)

var newList = list - 1
print(newList) // 1 원소 삭제된 새로운 리스트 출력

```