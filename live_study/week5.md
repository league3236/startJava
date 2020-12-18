# 목표

Java의 Class에 대해 학습하기

## 학습할 것 (필수)

- 클래스 정의하는 방법
- 객체 만드는 방법 (new 키워드 이해하기)
- 메소드 정의하는 방법
- 생성자 정의하는 방법
- this 키워드 이해하기

## 과제 (Optional)

- int 값을 가지고 있는 이진 트리를 나타내는 Node 라는 클래스를 정의하세요.
- int value, Node left, right를 가지고 있어야 합니다.
- BinrayTree라는 클래스를 정의하고 주어진 노드를 기준으로 출력하는 bfs(Node node)와 dfs(Node node) 메소드를 구현하세요.
- DFS는 왼쪽, 루트, 오른쪽 순으로 순회하세요.


## 클래스 정의하는 방법

**클래스란 ?**

자전거라는 클래스가 있다고 생각해보자. 바퀴, 벨 등은 클래스의 데이터가 된다. 그리고 바퀴는 돌리는 역할, 벨은 울리는 역할을 하게 되는데 이것이 클래스 관점에서 보면 연산이다.

각 클래스 안에서 역할에 따라 각 클래스의 기능을 서술해 나가고, 사람에 따라 같은 프로그램을 만들더라도 여러가지 관점으로 만들 수 있다.

**클래스는 아래와 같이 정의한다.**

```java
public class 클래스 이름 {
    // 프로그램 시작 시점
    public static void main(String[] args) {
        ....
    }
}
```

- ref
https://velog.io/@max9106/Java-%ED%81%B4%EB%9E%98%EC%8A%A4Class<br>

**객체란?** 

객체(Object)란 물리적으로 존재하거나 추상적으로 생각할 수 있는 것 중에서 자신의 속성을 가지고 있고 다른것과 식별 가능한 것을 말한다. 객체는 속성과 동작으로 구성되어 있다고 보면 되는데 자바에서는 이 속성과 동작을 각각 필드(field)와 메소드(method)라고 부른다.

먼가 어렵다... 

학창 시절 나는 클래스(Class)를 붕어빵 틀, 객체(Object)를 붕어빵으로 배웠다. 객체는 클래스로 찍어낸 고유한 특성이라고 생각하면 될 것 같다. 붕어빵에 어떠한 재료를 붙느냐에 따라 다른 붕어빵들이 생성되기 때문이다. 슈크림 붕어빵이 먹고싶다.

**객체는 다음과 같이 생성한다**

Java에서는 객체를 New 연산자로 생성한다. 

아래와 같은 클래스가 있다고 가정해보자.
```java
class Bicycle {
    int cadence;
    int speed;
    int gear;

    // 생성자는 아래에서 배운다.
}
```

main 문에서는 다음과 같이 객체를 생성한다.

```java

public class BicycleTest {
    public static void main(String[] args) {
        Bicycle b = new Bicycle(); 

        // 추가적으로 b객체를 통해 객체 멤버변수에 접근 가능하다.
        b.cadence = 10;
        b.speed = 13;
        b.gear = 10;
    }
}

```

위를 참고하여 보면 객체 생성 과정은 아래와 같다.

1. new 연산자가 b 객체에 저장될 메모리 공간 할당
2. 생성자가 b 객체를 초기화 (위에서는 default 생성자가 동작한다.)
3. new 연산자가 새로 생성된 객체의 주소(reference) b 변수에 저장
4. b를 통하여 Bicycle에 접근 가능하다

- ref
https://jwprogramming.tistory.com/121<br>
https://sime.tistory.com/41

**메소드는 어떻게 정의할까?**

메소드는 기능 즉, 행동을 나타낸다. 클래스에서 메소드를 작성하여 사용하는 이유는 중복되는 코드의 반복적인 프로그래밍을 피할 수 있기 때문이다. 또한, 모듈화로 인하여 코드의 가독성도 좋아진다.

프록그램에서 문제가 발생하거나 기능의 변경이 필요할 때 손쉽게 유지보수 할 수 있다는 장점도있다.

`메소드를 작성할 때는 되도록 하나의 메소드가 하나의 기능만을 수행하도록 작성하는 것이 좋다.`

**Java에서 메소드는 아래와 같이 정의한다.**

```java
접근제어자 반환타입 메소드이름(매개변수목록) {
    ...실행 문단
}
```

Bicycle을 예제로 작성하면 기어를 변동하거나 스피드를 올리는등의 행동을 할것이다. 이것을 메소드로 정의해보자

기어를 변동하는 메소드

```java
void chageGear(int newValue) {
        gear = newValue;
    }
```

메소드 전체 구현
```java
class Bicycle {
    // 멤버 변수 정의
    int cadence = 0;
    int speed = 0;
    int gear = 1;

    // 메소드 정의
    void changeCadence(int newValue) {
        cadence = newValue;
    }
    
    void chageGear(int newValue) {
        gear = newValue;
    }

    void speedUp(int increment) {
        speed = speed + increment;
    }

    void applyBrakes(int decrement) {
        speed = speed - decrement;
    }
    
    void printStates() {
        System.out.println("cadence:" + cadence + " speed:" + speed + " gear:" + gear);
    }

}
```

해당 메서드를 호출하는 예시는 아래와 같다. 속도를 10 올려보겠다.

```java

public class BicycleTest {
    public static void main(String[] args) {
        Bicycle b = new Bicycle(); 

        b.speedUp(10);
    }
}

```
해당 스피드는 기본 스피드 0 + 10 = 10이 되었을 것이다.

ref
- http://www.tcpschool.com/java/java_methodConstructor_method

**생성자란??**

객체를 생성할때 항상 실행되는 것으로 이해하면 될것같다. `생성자는 반환값이 없으며 클래스명과 메소드명이 동일`해야한다.


**생성자 정의는 어떻게 할까?**

그러면 Bycicle에서는 생성자를 다음과 같이 정의할 수 있다.

```java
class Bicycle {

    // 생성자 정의
    public Bicycle() {

    }

}
```

생성자를 통해서 초기 멤버변수의 값 세팅이 가능하다.

```java
class Bicycle {
    int cadence = 0;
    int speed = 0;
    int gear = 1;

    Bicycle() {
        cadence = 10;
        speed = 10;
        gear = 10;
    }
}
```

ref
- https://wakestand.tistory.com/81
- https://joonyon.tistory.com/24


**this 키워드는 무엇일까?**

자바에서 this는 객체, 자기 자신을 나타낸다.

주로 3가지 형태로 사용되고 있으며 하나씩 살펴보자.

1. 클래스의 속성과 생성자/메소드의 매개변수(input parameter)의 이름이 같은 경우


아래와 같은 코드에서는 cadence = cadence가 되는데 여기서는 좌측의 cadence는 Bicycle 객체의 cadence 속성을 가르키고 있다는 사실을 인지하지 못한다.
실제 객체에는 넘어온 파라미터 cadence값이 입력되지 않는다.
```java
class Bicycle {
    int cadence = 0;
    int speed = 0;
    int gear = 1;

    Bicycle(int cadence, int speed, int gear) {
        cadence = cadence;
        speed = speed;
        gear = gear;
    }
}
```

아래와 같이 바꾸어 객체에 주입시켜야 한다.

```java
class Bicycle {
    int cadence = 0;
    int speed = 0;
    int gear = 1;

    Bicycle(int cadence, int speed, int gear) {
        this.cadence = cadence;
        this.speed = speed;
        this.gear = gear;
    }
}
```

2. 클래스에 오버로딩된 다른 생성자 호출

하나의 클래스에 여러개의 생성자가 오버로딩 되어 있을 때, 일부분을 제외하고는 서로 중복된 코드를 가지고 있는 경우가 많다. 

내부에 정의된 다른 생성자를 호출하여 코드의 중복을 피하고 깖금한 소스를 작성할 수 있다.

`같은 클래스에 오버로딩된 다른 생성자를 호출때에도 this 키워드가 사용된다.`

```java
class Bicycle {
    int cadence;
    int speed;
    int gear;

    Bicycle(int cadence, int speed) {
        // Bicycle(int cadence, int speed, int gear)를 호출
        this(cadence, speed, 0);
    }

    Bicycle(int cadence, int speed, int gear) {
        this.cadence = cadence;
        this.speed = speed;
        this.gear = gear;
    }
}
```



3. 객체 자신의 참조값을 전달하고 싶을 때

어떤 메소드에서는 내부에서 호출하고자 하는 메소드의 매개변수(input parameter)로 객체, 자기 자신의 참조값을 전달하고 싶은 경우가 있다.

이럴때에는 get~Instance() 메소드의 구현부분에서처럼 this 키워드를 이용함으로써 구현이 가능하다.

```java 
class Bicycle {
    int cadence;
    int speed;
    int gear;

    Bicycle(int cadence, int speed, int gear) {
        this.cadence = cadence;
        this.speed = speed;
        this.gear = gear;
    }

    public Bicycle getBicycleInstance() {
        return this;
    }
}
```

- ref
https://library1008.tistory.com/4 <br>


**전체적인 정의는 아래와 같이 한다.**

```java
public//공개 범위 class 클래스이름 {
    // 멤버변수
    int a;
    int b;

    // 생성자
    클래스이름() {
        a = 10;
        b = 15;
    }

    // 메서드
    메서드명() {

    }

    // 프로그램 시작 시점
    public static void main(String[] args) {
        ...
    }
}
```



Bicycle이라는 클래스를 만들어 보자.

```java
class Bicycle {
    int cadence = 0;
    int speed = 0;
    int gear = 1;

    Bicycle() {
        this.cadence = 10;
        this.speed = 10;
        this.gear = 10;
    }

    void changeCadence(int newValue) {
        cadence = newValue;
    }
    
    void chageGear(int newValue) {
        gear = newValue;
    }

    void speedUp(int increment) {
        speed = speed + increment;
    }

    void applyBrakes(int decrement) {
        speed = speed - decrement;
    }
    
    void printStates() {
        System.out.println("cadence:" + cadence + " speed:" + speed + " gear:" + gear);
    }

}
```

- ref
https://reakwon.tistory.com/26<br>
https://docs.oracle.com/javase/tutorial/java/concepts/class.html