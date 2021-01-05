## 목표
자바의 인터페이스에 대해 학습하세요.

## 학습할 것 (필수)
- 인터페이스 정의하는 방법
- 인터페이스 구현하는 방법
- 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법
- 인터페이스 상속
- 인터페이스의 기본 메소드 (Default Method), 자바 8
- 인터페이스의 static 메소드, 자바 8
- 인터페이스의 private 메소드, 자바 9

### 인터페이스란?

자식 클래스가 여러 부모 클래스를 상속받을 수 있다면, 다양한 동작을 수행할 수 있다는 장점을 가지게된다.

하지만,  클래스를 이용하여 다중 상속을할 경우 메소드 출처의 모호성 등 여러가지 문제가 발생할 수 있어 자바에서는 클래스를 통한 다중 상속은 지원하지 않는다.

하지만 다중 상속의 이점을 버릴 수는 없기에 자바에서는 인터페이스라는 것을 통해 다중 상속을 지원하고 있다.
인터페이스(interface)란 다른 클래스를 작성할 때 기본이 되는 틀을 제공하면서, 다른 클래스 사이의 중간 매개 역할까지 담당하는 일종의 추상 클래스를 의미한다.

자바에서 추상 클래스는 추상 메소드뿐만 아니라 생성자, 필드, 일반 메소드도 포함할 수 있다. 하지만 인터페이스(interface)는 오로지 추상메소드와 상수만을 포함할 수 있다.

요약하자면 아래와 같다.

- 구현된 것이 없는 프레임 또는 기본 설계도
- 일반 메서드 또는 멤버 변수를 가질 수 없고, 오직 추상 메서드와 상수만을 멤버로 가질 수 있다. -> 추상 클래스보다 추상화가 더 높다.
- 인터페이스는 표준, 약속, 규칙이다.

### ref
- http://www.tcpschool.com/java/java_polymorphism_interface
- https://enjoyplaying.tistory.com/33

### 인터페이스를 정의하는 방법

인터페이스는 예약어로 class 대신 interface를 사용하며, 접근 제어자로 public 또는 default를 사용한다.

```
접근제어자 interface 인터페이스이름 {
    public static final 타입 상수이름 = 값;

    ....

    public abstract 메소드이름(매개변수목록);
    ...
}
```

### ref
- https://sungwoon.tistory.com/59
- http://www.tcpschool.com/java/java_polymorphism_interface
- https://enjoyplaying.tistory.com/33


### 인터페이스를 구현하는 방법

- 모든 `멤버 변수`는 `public static final` 이어야 하며, 이를 `생략 가능`
- 모든 `메서드`는 public abstract 이어야 하며, 이를 `생략 가능`

### ref
- https://enjoyplaying.tistory.com/33