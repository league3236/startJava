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

개발 코드가 인터페이스 메소드를 호출하면 인터페이스는 객체의 메소드를 호출한다.
객체는 인터페이스에서 정의된 추상 메소드와 동일한 메소드 이름, 매개 타입, 리턴 타입을 가진 실체 메소드를 가지고 있어야 한다.

이러한 객체를 인터페이스의 구현(implement) 객체라고 하고, 구현 객체를 생성하는 클래스를 구현 클래스라고 한다.

- 모든 `멤버 변수`는 `public static final` 이어야 하며, 이를 `생략 가능`
- 모든 `메서드`는 `public abstract` 이어야 하며, 이를 `생략 가능`

구현한다는 의미의 `implements`를 사용해서 구현한다. (클래스는 확장한다는 의미에서 extends를 사용)

만약 인터페이스의 메서드 중 일부만 구현한다면, 추상클래스로 선언되어야 한다.
상속과 구현을 동시에 할 수 있다.

```
class 클래스이름 implements 인터페이스 이름 {
    // 인터페이스에 정의된 추상 메서드를 구현
}

abstract class 클래스 이름 implements 인터페이스이름 {
    // 인터페이스에 정의된 추상 메서드의 일부만 구현
}

class 클래스이름 extends 조상클래스이름 implements 인터페이스이름 {

}
```

### ref
- https://enjoyplaying.tistory.com/33
- https://blog.naver.com/mals93/220716635488


### 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법

인터페이스를 사용 레퍼런스로 변수를 선언할 수 있다. 선언된 인터페이스를 구현하는 모든 클래스의 인스턴스는  이러한 변수에 의해 레퍼런스 구현이 가능하다.

아래 예제에서는 인터페이스 참조 변수를 통해 topSpeed() 메서드를 호출한다.

```java
interface Speed {
    void topSpeed();
}

class Audi implements Speed {
    public void topSpeed()
    {
        System.out.println("Audi : 250 km/h");
    }
}

class Ford implements Speed {
    public void topSpeed()
    {
        System.out.println("Ford : 220 km/h");
    }
}

class BMW implements Speed {
    public void topSpeed()
    {
        System.out.println("BMW : 300 km/h");
    }
}

public class Javaapp {
    public static void main(String[] args) {
        Speed spd = new Audi();
        spd.topSpeed();
        spd = new Ford();
        spd.topSpeed();
        spd = new BMW();
        spd.topSpeed();
    }
}

```

### ref
- https://hajsoftutorial.com/accessing-implementations-through-interface-references/

### 인터페이스 상속

`extends`는 상속을 뜻한다. 사전적 의미로는 확장, 확대의 뜻을 가지고 있다. 코딩으로 치면 조상의 멤버 (메서드, 변수 등)를 자식에서 그대로 물려받아 추가적으로 자식의 멤버를 추가, 즉 조상의 멤버를 물려받고 자식에서 거기에 추가로 확장하여 사용하는 의미로 보면 적당할 것 같다.

따라서 자식으로 내려갈수록 조상보다 멤버의 범위가 더 넓다.

클래스끼리는 하나의 클래스만 상속할 수 있다.

```java
public class Ambulance extends Car()
```

인터페이스끼리는 다중 상속이 가능하다.
여러개의 인터페이스를 상속받은 인터페이스를 클래스에 적용할땐 모든 메서드를 구현해주어야 한다.
```java

interface InterfaceTest1 {
    public final int a = 110;
    public void method1();
}

interface InterfaceTest2 {
    public void method2();
    public void method3();
}

public interface Interface3 extends InterfaceTest1, InterfaceTest2{} 
// 인터페이스 다중상속

public class InterfaceTestClass implements InterfaceTest3{
    int b = a; //여기서 a는 InterfaceTest1의 멤버 변수 a이다.

    // InterfaceTest1,2,3의 모든 메서드를 구현해줘야한다.
    @Override
    public void method1() {
        System.out.println(a);
    }

    @Override
    public void method2() {
        System.out.println(a);
    }

    @Ovrride
    public void method3() {
        System.out.println(a);
    }
}
```

### ref
- https://debugdaldal.tistory.com/171

### 인터페이스의 기본 메소드 (Default Method), 자바 8

### ref
- http://happinessoncode.com/2017/04/19/java8-changes-in-interface/

Java 8에서는 인터페이스에 기본 구현을 정의할 수 있게 되었다. 기본 구현이 제공되는 메서드는 구현클래스에서 구현하지 않아도 컴파일이 가능하다. 기본메서드는 기존의 인터페이스에 메서드를 추가해야하는 경우에 아주 유용한다. 인터페이스가 변경되는 일이 없도록 프로그램을 잘 작성하는게 좋겠지만 변경이 불가피한 상황이 생길 수도 잇다. 인터페이스에 메서드를 추가하면 해당 인터페이스를 구현하는 모든 클래스에서 추가된 메서드를 구현해야하기 때문에 문제가 생긴다. 구현 크래릇가 9개라면 인터페이스까지 10개의 파일을 수정해야한다. 하지만 추가되는 메서드의 구현이 대부분 동일하다면 인터페이스에 기본적인 메서드 구현을 정의하고 유별난 클래스만 수정해준다. 연료 유형을 포함하는 `car` 인터페이스의 예제이다.

```

public interface Car {
    String fuelType();
}

public class DieselCar implements Car {
    @Override
    public String fuelType() {
        return "DIESEL";
    }
}

public class GasolineCar implements Car {
    @Override
    public String fuelType() {
        return "GASOLINE";
    }
}

```

자동 주행 차량 여부를 확인할 수 있는 메서드가 추가되어야한다고 생각해보자. 
`Car`는 아래와 같이 변경되어야 한다.

```java
public interface Car {
    String fuelType();
    boolean autodrive();
}
```

이 경우에 `autodrive()` 메서드는 기본 구현을 제공하지 않으므로 `DieselCar`, `GasoineCar`에서 구현해줘야한다. 하지만 기존 차량들은 자율 주행이 안될것이기 때문에 아래와 같이 기본 구현을 제공할 수 있다.

```java
public interface Car {
    String fuelType();
    default boolean autodrive() {
        return false;
    }
}
```

`autodrive()`는 `FutureCar`와 같은 유별난 클래스에서만 따로 구현해주면 된다.

```java
public class FutureCar implements Car {
    @Override
    public String fuelType() {
        return "SOLAR";
    }

    @Override
    public boolean autodrive() {
        return true;
    }
}
```

JAVA8에 와서는 더 이상 추상 클래스를 추가할 필요없이 기본 메서드를 정의할 수 있게 되었다. 이런 변화로 인터페이스와 추상 클래스의 경계가 모호해졌다는 느낌이 들지만 여전히 인스턴스 변수의 유무 차이는 존재한다.

### 인터페이스의 static 메소드, 자바 8

java 8 부터 interface에 static 메소드를 선언할 수 있게 되었다.
Calculator Interface의 print 메소드가 그 예에 해당한다.

```java
public interface ICalculator {
    int add(int x, int y);
    int sub(int x, int y);

    default int mul(int x, int y) {
        return x * y;
    }

    static void print(int value) {
        System.out.println(value);
    }
}
```

static 메소드를 사용하는데 주의해야할 점은 기존 클래스의 static 메소드처럼 class이름.메소드로 호출하는게 아니라 interface이름.메소드로 호출해야한다는 점이다.

```java
public class CalcTest {
    public static void main(String[] args){
        ICalculator cal = new Calculator();

        ICalculator.print(100);
    }
}
```


### ref
- https://velog.io/@ednadev/%EC%9E%90%EB%B0%94-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4Interface-%EB%94%94%ED%8F%B4%ED%8A%B8-%EB%A9%94%EC%84%9C%EB%93%9C%EC%99%80-static-%EB%A9%94%EC%84%9C%EB%93%9C


### 인터페이스의 private 메소드, 자바 9

Java8 이전 까지의 인터페이스는 variable/methods에 대해서 다음 두 가지의 형태를 갖고 있었습니다.

- Constant variables (상수)
- Abstract methods (추상메소드)

그래서 인터페이스안에서 메소드를 구현할 수 없고 더 정밀한 기본 구현을 할 수 없었다.

java 8에서는 위에서 설명한대로 아래와 같은 기능들이 추가되었다.

- Constant variable
- Abstract methods
- Default methods (기본 메소드)
- Static methods (정적 메소드)

하지만 해당 기능들이 추가되어도 여전히 불편한데 아래 이유 때문이다.

- 단지 특정 기능을 처리하는 내부 method 일뿐인데도 외부에 공개되는 public method로 만들었어야 했다.
- 인터페이스를 구현하는 다른 interface 또는 class가 해당 method에 액세스하거나 상속할 수 있는 것을 원하지 않는다.

java9 부터는 아래와 같은 타입들이 늘어났다.

- Constant variables
- Abstract methods
- Default methods
- Static methods
- Private methods 
- Private Static methods

Java9 Private Interface Method는 Interface에 private method / private static method 라는 새로운 기능을 제공하여 문제를 해결한다.
이제 중복 코드를 피하고 interface에 대한 캡슐화를 유지할 수 있다.

```java
public interface IMyInterface {
    private void method1(String arg) {
        // do something
    }
    private static void method2(Integer arg) {
        // do something
    }
}

```




### ref
- https://jamcode.tistory.com/66
- https://www.popit.kr/%EB%82%98%EB%A7%8C-%EB%AA%A8%EB%A5%B4%EA%B3%A0-%EC%9E%88%EB%8D%98-java9-%EB%B9%A0%EB%A5%B4%EA%B2%8C-%EB%B3%B4%EA%B8%B0/
