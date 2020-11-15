
## ref

- https://findstar.pe.kr/2019/01/20/install-openjdk-by-homebrew/

## ipad로 코딩하기

https://boxnwhis.kr/2020/01/11/coding_with_ipad.html

이전에 쓰던 맥북프로를 회사에 반납해야만 했다. (이직하면서....)  그래서 spring 개발을 ipad나 new mac(2015)로 진행하려한다.  최대한 가볍게 이용하기 위해서... 
new mac 2015에서는 vsc를 ide로 사용하려 한다.


## OpenJDK

OpenJDK(Open Java Development Kit)는 자바 플랫폼,  스탠더드 에디션 (자바 SE)의 자유-오픈소스 구현체이다. 최근 자바가 유료화 되면서 한층 주목받고 있는데, 
유료화에 대한 반발로 주변의 많은 사람들이 OpenJDK를 설치하는 모습을 볼 수 있었다.  

이때만 해도 OpenJDK그를 공식적인 brew로 설치가 불가능했다. 
지금은 어떨지 모르겠다.

## AdoptOpenJDK

AdoptOpenJDK는 사전에 prebuild 형태로 java binary를 제공하는 커뮤니티 그룹이다. Mac 뿐만 아니라
윈도우, 리눅스 환경도 제공하고 있다. 공식적으로 OpenJDK를 설이하는 것은 직접 빌드해서 사용하는 방법이 있지만, 
빌드 이외에도 자잘한 `JAVA_HOME` 설정 문제라던가 버전업을 편하게 하기 위해서 homebrew를 사용해서 
AdoptOpenJDk를 설치할 수 있다.

자세한 설치방법은 github를 참조한다.(https://github.com/AdoptOpenJDK/homebrew-openjdk)


```
$ brew tap AdoptOpenJDK/openjdk
```

```
$ brew cask install adoptopenjdk8
```

version 확인

```
$ /usr/libexec/java_home -V
```

설치 위치 체크

```
$ /usr/libexec/java_home
/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home
```

example
```
Matching Java Virtual Machines (1):
    1.8.0_272, x86_64:	"AdoptOpenJDK 8"	/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home

/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home
```

mac에서 위와같이 확인 후 사용할 jdk 버전을 설정가능하다. 

vim ~/.bash_profile
```
export JAVA_HOME=/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home
```

적용
```
$ source ~/.bash_profile
```

적용된 버전 확인
```
$ java -version
openjdk version "1.8.0_272"
OpenJDK Runtime Environment (AdoptOpenJDK)(build 1.8.0_272-b10)
OpenJDK 64-Bit Server VM (AdoptOpenJDK)(build 25.272-b10, mixed mode)
```

plugin intall (visual studio code)

a. Java Extention Pack

b. Java Dependensy Viewer

c. Language Support for Java(TM) by Red Hat

d. Debugger for Java

e. Java Test Runner

f. Maven for Java


## ref 

- 자바 마스터 북
- https://medium.com/@lazysoul/jvm-이란-c142b01571f2

## 자바의 세가지 에디션과 두가지 환경

1. Java SE(Standard Edition) Java vm과 표준 api 등을 정리한 가장 표준적인 버전이다. PC나 서버 등에서 동작하는 애플리케이션을 개발 및 실행하는 경우에 사용한다.
2. Java EE(Enterprise Edition) 웹 서비스나 서버 간 통신, 메일 송신 등 서버 애플리케이션에 필요한 기능이 많이 포함되어 있다.
3. Java ME(Micro Edition) 가전제품과 휴대전화 등의 임베디드 시스템용의 애플리케이션을 개발하기 위한 에디션이다. Java SE에 비해 사용할 수 있는 기능이 한정되어 있지만 필요한 리소스(CPU나 메모리 등)가 적게 들어 임베디드 시스템 등에서도 잘 동작한다.   또한 자바는 실행 환경 (JRE) 및 개발 환경 (JDK)의 두가지로 나누어져 있다.

A. Jre(Java Runtime Environment)

자바 애플리케이션의 실행 환경이다. 이미 컴파일된 자바 애플리케이션의 모듈(JAR 파일과 클래스 파일 등)을 이용하여 실행할 수 있다.

B. JDK(Java Development Kit)

자바 애플리케이션의 개발 환경이다. 실행 환경뿐만 아니라 소스 파일의 컴파일러 및 디버거 등 자바 애플리케이션을 개발하기 위한 도구가 포함되어 있다.

애플리케이션을 JRE가 있으면 작동시킬 수 있다. 단,  운영할때 디버깅 및 분석 등을 하고자 하는 경우에는 jdk에 들어있는 도구가 필요하다. 따라서 서버 등의 운영 환경에 설치하는 경우에도 JRE보다는 JDK를 선택하는 것이 좋은 경우도 있다.

## jvm 이란

java virtual machine의 줄임말이며 Java Byte Code를 OS에 맞게 해석 해주는 역할을 합니다. Java Compiler는 .java 파일을 .class 라는 java byte code로 변환 시켜 준다. byte code는 기계어가 아니기 때문에 바로 os에서 바로 실행되지 않는다. 이때 jvm은 os가 bytecode를 이해할 수 있도록 해석 해준다. 하지만 jvm의 해석을 거치기 때문에 c언어와 같은 네이티브 언어에 비해 속도가 느렸지만 JIT(Just In Time) 컴파일러를 구현해 이점을 극복했다. 
Byte Code 는 JVM 위에서 os상관없이 실행된다. 이런점이 java의 가장 크나 장점이라고 할 수 있다. os에 종속적이지 않고 Java 파일 하나만 만들면 어느 디바이스든 JVM 위에서 실행 할 수 있다. JVM은 크게 Class Loader, Runtime Data Areas, Excution Engine 3가지로 구성되어 있다.

`class loader`

runtime 시점에 클래스를 로딩하게 해주며 클래스의 인스턴스를 생성하면 클래스 로더를 통해 메모리에 로드하게 된다.

`runtime data areas`

Jvm이 프로그램을 수행하기 위해 os로 부터 별도로 할당 받은 메모리 공간을 말하며, runtime data areas는 크게 5가지 영역으로 나눌 수 있다.

`execution engine`

load된 class의 bytecode를 실행하는 runtime module이 바로 execution engine이다. class loader를 통해 jvm 내의 runtime data areas에 배치된 바이트 코드는 execution engine에 의해 실행된다. 

최초 JVM이 나왔을때 Interpreter(한 줄씩 해석하고 실행) 이였기 때문에 속도가 느리다는 단점이 있었지만 JIT compiler (just in time) 방식을 통해 이 점을 보완해왔다. JIT는 bytecode를 어셈블러 같은 nativecode로 바꿔서 실행이 빠르지만 역시 변환하는데 비용이 발생한다. 이 같은 이유 때문에 jvm은 모든 코드를 jit compiler 방식으로 실행하지 않고 interpreter 방식을 사용하다 일정 기준이 넘어가면 jit compiler 방식으로 실행한다.

## 자바가 실행되는 순서

1. 자바 소스 코드를 작성한다.
2. javac 커맨드를 실행하여 소스 코드를 컴파일하고, ‘클래스 파일’ 이라고 불리는 중간 코드(os에 의존하지 않은 코드)를 생성한다.
3. java 커맨드를 실행하여 java VM이 클래스 파일에 기재된 코드를 해석하여 처리한다. Java VM은 위도우용 또는 리눅스용 등 각 os마다 준비되어 있으며 사용하는 os에 따라 실제적인 처리를 실시한다. 즉, 이 단계에서 각 os별로 내부 처리의 차이가 있다.





## 문법 day1

32 비트값에서 상위 16비트/하위 16비트를 추출

```
int number = 0x12345678
int lower = number & 0x0000ffff;
system.out.printf(“lower = %x\n”, lower);
```

`Switch`

switch에서 사용하는 변수로는 다음과 같은 것을 이용 
- 숫자값a
- enum 타입
- 문자열 
```
Month month = LocalDateTime.now().getMonth();

switch (month) {
    case MARCH :
    case APRIL :
    case MAY:
        Sytem.out.println(month + “는 봄이다”);         break;
    case JUNE:
    case JULY:
    case AUGUST:
         System.out.println(month + “는 봄이다”);
    ...     default:
    System.out.println(month + “는 봄이다”);
             break; }
```

`For 문`

```
int sum = 0;

for(int i = 1; i <= 10; i++) {
    sum += i;
    System.out.println(i + “번째: ” + sum); }
```

```
int[] numbers = {1, 1, 2, 3, 5, 8, 13, 21};
for (int number : numbers) {
    System.out.println(number);
} 
```


`while문/do...while 문`

while문과 do..while문의 차이는 ‘조건 판정을 반복 처리 전에 실시할지 반복처리 후에 할지에 대한 차이’이다. do...while문은 적어도 한번은 실행한다.

```
while(조건) {
}

do {
} while(조건)
```


```
Scanner in = new Scanner(System.in);
System.out.println(“암호를 입력해 주세요”);
String str = in.nextLine();

while(!str.equals(“abc”)) {
    System.out.println(“암호가 틀립니다. 올바른 암호를 입력해 주세요!”);
    str = in.nextfLine();    
}

System.out.println(“OK!”);
```


```
Scanner in = new Scanner(System.in);
System.out.println(“암호를 입력해 주세요”);
String str = in.nextLine();

while(true) {
    if (str.equals(“abc”)) {
        break;
    }

    System.out.println(“암호가 틀립니다. 올바른 암호를 입력해주세요!”);
    str = in.nextLine();
} 

System.out.println(“OK!”);
```


## ref

http://www.tcpschool.com/java/java_class_intro

## 객체 지향 프로그래밍(OOP, Object-Oriented Programming)

객체 지향 프로그래밍에서는 모든 데이터를 객체(object)로 취급하며, 이러한 객체가 바로 프로그래밍의 중심이 됩니다.

객체(object)란 간단히 이야기하자면 실생활에서 우리가 인식할 수 있는 사물로 설명할 수 있다.

이러한 객체의 상태(state)와 행동(behavior)을 구체화하는 형태의 프로그래밍이 바로 객체 지향 프로그래밍이다.
이때 객체를 만들어 내기 위한 설계도와 같은 개념을 클래스(class)라고 한다.

## 클래스란?

자바에서 클래스(class)란 객체를 정의하는 틀 또는 설계도와 같은 의미로 사용된다.

클래스란 변수나 메서드를 모아둔 틀 또는 그릇과 같은 것이다.  프로그램을 만들 때는 구조를 파악하기 쉽도록 프로그램을 분할하는데 그때 우선 클래스 단위로 분할을 고려한다. 그런 방침으로 실제 개체나 개념의 단위로 클래스를 분할하고 그것들을 연계시켜 나가도록 한다. 

클래스는 객체의 상태를 나타내는 필드(field)와 객체의 행동을 나타내는 메소드(method)로 구성된다.

즉,  필드(field)란 클래스에 포함된 변수(variable)를 의미한다.
또한, 메소드(method)란 어떠한 특정 작업을 수행하기 위한 명령문의 집합이라 할 수 있다.

```
class Student {
    // 필드 선언하기
    String name;
    int score;
    Static final int MAX_SCORE = 100;
}
```
`static`이나 `final`은 MAX_SCORE를 변경되지 않는 값으로 정의하고 있음을 나타낸다.

## 메서드 

자바에서 클래스는 멤버(member)로 속성을 표현하는 필드(field)와 기능을 표현하는 메소드(method)를 가진다. 그 중에서 메소드(method)란 어떠한 특정 작업을 수행하기 위한 명령문의 집합이라고 할 수 있다.

```
// 인수 1개를 건네는 메서드
void setScore(int newScore) {
    score = newScore;
}

// 인수가 없는 메서드
void printScore() {
    System.out.println(name.+ “씨의 점수는 ” + score + “점 입니다.”);
}
```

메소드 결과값 반환 / 반환값이 없는 경우는 타입을 ‘void’로 지정한다.

```
// 정수의 반환값을 반환하는 메소드
int getScore() {
    return score
    
}

// 반환값이 없는 메소드. return 문은 불필요
void printScore() {
    System.out.println(name + “씨의 점수는 ” + score + “점 입니다.” );
}
```

## ref

자바 마스터북
http://www.yes24.com/Product/Goods/58960335


## 수식자

q. `스터디때 형들에게 실무에서 수식자를 실제 어디까지 쓰는지 물어보기` + 수식자 설명 부탁 

1. abstract (어려움 다음에 다시보기)

해당 클래스나 메서드를 추상적으로 표현하겠다는 지정이다. 추상적이라는 말의 의미에서 알 수 있듯이 그 실체는 불완전하다. 예를 들어 abstract 메서드는 메서드의 선언부만 있을 뿐 실제 내용은 정의되어 있지 않은 경우에 지정한다.

2. static

static 수식자는 그 클래스가 인스턴스화되어 있지 않더라도 액세스가 가능하다는 지정이다. 메서드 또는 필드에 대해 지정할 수 있다. 

3. final

final 수식자는 멤버의 변경을 금지한다. 클래스, 메서드, 필드에 지정할 수 있는데 금지 동작은 final 수식자를 지정하는 대상에 따라 조금씩 다르다.

- 필드에 지정한 경우 => 그 필드의 값이 변경되는 것을 금지한다.
- 메서드에 지정한 경우 => 서브 클래스에서의 메서드 변경을 금지한다.
- 클래스에 지정한 경우 => 클래스의 서브 클래스화를 금지한다.

메서드의 변경이란 어떤 클래스를 계승해서 만든 서브 클래스 중에서 부모 클래스가 지닌 메서드를 서브 클래스 쪽에서 변경하는 것을 말한다. 이것을 오버라이드(Override)라고 부른다. 메서드에 final 수식자를 지정하는 것은 이 오버라이드를 금지한다는 의미다. 클래스에 final 수식자를 지정하면 지정한 클래스를 계승하여 서브클래스를 만드는 것을 금지한다는 의미이다.

4. transient

Transient 수식자는 객체의 직렬화 시에 해당 필드를 직렬화의 대상에서 제외하겠다는 지정이다. 직렬화(serialize)란 인스턴스화되어 있는 자바 객체를 바이트 열로 변환하는 것이다. 예를 들어 데이터를 필드에 보관하거나, 네트워크 간에 객체를 송수신하거나 할 때 객체에 일시적인 데이터를 보관하는 필드를 갖게 하는 경우가 있는데 그러한 데이터는 파일을 보관할때는 불필요하다. 

5. volatile

멀티 스레드로부터 액세스되는 필드에 대해 스레드마다 값이 캐시되지 않도록 하는 지정이다. 

6. synchronized

대상의 처리를 동기화하기 위한 지정이다. 메서드 또는 블록에 대해 지정할 수 있다.

7. native

native 숫자는 지정한 메서드가 네이티브한 코드를 호출한다는 것을 나타낸다.

8. strictfp

strictfp 수식자는 부동소수점 수를 IEEE 754 규격으로 엄밀하게 관리한다는 지정이다. 




## ref

https://whatisthenext.tistory.com/38

https://cloudstudying.kr/questions/285

## 메서드 오버로딩

클래스 안에서 동일 메서드를 복수 정의할 수 없다.

이때 같은 이름을 갖은 메서드이지만, 서로 다른 매개변수 형식을 가지고 있는 메서드를 여러개 정의하는 것을 `메서드 오버로딩` 이라고 한다.

## main 메서드

자바 프로그램을 실행했을 때 호출되는 프로그램의 시작점인 메서드, 반드시 존재해야 한다.

## 인스턴스

클래스를 객체화한 상태, 컴퓨터의 메모리상에 존재하게 되며 이를 인스턴스라고 한다.

```
Pizza p1 = new Pizza();
```

```

public class Student {
    String name;
    int Score;
    static final int MAX_SCORE = 100;

    void printScore() {
        System.out.println(name + “씨는” + MAX_SCORE + “점 만점 중, ” +score+ “점 입니다.”);
    }
}

class StudentSamlple {
    Public static void main(String... args) {
        Student league = new Student(); //league이라는 인스턴스를 만든다.
        league.name = “리그”;
        league.score = 80;
        league.printScore();

        Student cat = new Student();
        cat.name = “캣”;
        cat.score = 90;
        cat.printScore();
    }
}

```



`this를 사용하는 경우`

```
class Student {
    String name;
    int score;
    static final int MAX_SCORE = 100;

    String getName() {
        return name;
    }
    
    void setName(String name) {         This.name = name;     }
    int getScore() {         return score;     }
}
```

- 인스턴스 생성 시점에 값이 결정되고 나중에 변하지 않는 것
  -> 생성자에서 지정한다.
- 값이 나중에 변하는 것
  -> 메서드나 필드를 통하여 값을 설정한다.

## 생성자

`생성자(Constructor)`

생성자는 new 연산자를 통해서 인스턴스를 생성할 때 반드시 호출이 되고 제일 먼저 실행되는 일종의 메소드 (하지만 메소드와는 다르다.)이다. 생성자는 인스턴스 변수 (필드 값 등)를 초기화 시키는 역할을 한다.

`생성자 선언 방법`

- 메서드명이 클래스명과 동일하다
- 반환값의 선언이 존재하지 않는다

인스턴스를 생성할 때 반드시 생성자를 호출하여야한다. `생성자를 생략하면 컴파일러가 자동으로 기본 생성자(Default Constructor)를 생성`하여 준다. 

```
public class ConstructorEx01 {
    // public ConstructorEx01() 
    // Default contructor 자동 생성

    public static void main(String[] args) {
        ConstructorEx01 ce = new ConstructorEx01(); // 인스턴스 생성 및 생성자 호출
    }
}
```
위의 내용처럼 인스턴스를 생성할때 생성자를 호출한다.
생성자를 생략하면 주석 처리된 부분이 자동으로 생성된다.



## javadoc

javadoc은 클래스나 메서드에 정의하는 주석의 일종이다.

`example`

```
/ **
  * 학생의 점수를 취급하는 클래스    <- 해당부분을 뜻함
  */

class Student {
    ,,,,
}
```

## annotation

애노테이션이란 소스 코드 안의 요소 (클래스나 메서드 등)에 대해 정보(메타 데이터)를 설명하는 메커니즘이다.
클래스나 메서드에 특정 역할 및 의미를 갖게 하는데 사용할 수 있다.

- 메서드의 오버라이드를 나타내는 @Override
- 비추천을 나타내는 @Deprecated
- 경고를 출력하지 않도록 하는 @SuppressWarnings

@Override는 메서드의 앞에 기술함으로써 정말 오버라이드 되어있는지를 컴파일러가 체크하게 한다.
프로그램 작성 시의 실수에 의해 오버라이드가 성립하지 않을 경우 경고를 출력해준다. 
'소스 코드를 보는 것만으로 메서드가 오버라이드 되어 있는 것을 알 수 있다'는 장점이 있다.

```java
public class Person {
    private String name;

    @Override
    public String toString() {
        return name
    }
}
```

Override란?

프로그래밍에서 오버라이드를 덮어씌우는 것으로 생각하면 좋다.
상속 관계인 부모 클래스와 자식 클래스 사이에서 부모 클래스의 메소드를 똑같이 가져와 사용하는 것이다.

@Deprecated는 클래스나 메서드의 사용을 비추천임을 나타내기 위해 사용한다.
다음의 예는 `Person 클래스의 name 속성을 취득하기 위한 메서드로서 원래부터 준비되어 있던 get_name 메서드에서 getName 메서드로 변경하게 되었음`을 나타내고 있다.

```
public class Person {
    private String name;

    @Deprecated
    public String get_name() {
        return name;
    }

    public String getName() {
        return name;
    }
}
```

단순히 get_name 메서드를 삭제하게 되면 Person 클래스를 이용하고 있던 부분에서 컴파일 에러가 발생할지도 모른다. 그래서 get_name 메서드는 @Deprecated 애노테이션을 부여하여 남겨둠으로써 호환성을 유지하도록 한다. 또한 get_name 메서드를 사용하고 있으면 컴파일 시에 경고가 표시되고 이클립스상에서는 get_name 메서드의 호출에 취소선이 생기는 등 비추천임을 이용자에게 알릴 수 있다.

@SuppressWarnings 애노테이션은 코드 안에 억제하고 싶은 경고의 종류를 지정하여 컴파일 시에 경고를 출력하지 않도록 한다. 그러나 경고의 내용을 무시하게 되어 여러 문제점을 야기하기 때문에 사용을 권장하지 않는다.

## 명명규칙

**클래스와 변수는 카멜 케이스로, 상수는 스네이크 케이스로 한다.**

- 카멜케이스 : 복수의 단어로 형성된 복합어에서 각 단어의 첫 글자를 대문자로 표기하는 형식
- 스네이크 케이스 : 모두 대문자로 단어를 언더스코어(_)로 구분

클래스명 => 대문자로 시작하는 카멜케이스(파스칼 케이스)
변수 => 소문자로 시작하는 카멜케이스
상수 => 스네이크 케이스

```
public class ResultObject {
    public static final int STATUS_OK = 0;

    private int number;

    priabe String name;
}
```

**변수는 명사, 메서드는 동사로 명명**

```java
public class status {
    // 이것은 잘못된 명명
    // private boolean isStarted = false;

    // 올바른 명령은 이것이다.
    private boolean started = false;  < - 변수는 명사>

    public boolean isStarted()   <- 메소드는 동사>
        return this.stared
    }

    public void setstarted(boolean started) {
        this.started = started
    }
}
```

##  정적 타입언어와 동적 타입언어

java는 `정적 타입언어`로 변수의 선언 시에 타입을 명기하여 컴파일할때 타입의 정합성(matching)을 체크한다.

javascript나 ruby와 같은 언어는 `동적 타입언어`로 변수의 선언 시에는 타입을 명확하게 하지 않고 실행시에 타입의 정합성을 체크한다.

`정적 타입 언어`의 장점은 타입과 관련된 버그를 줄일 수 있다는 점이다. 단, 코딩 시에는 모든 변수, 메서드의 인수, 반환값에 타입을 지정할 필요가 있으며 실행하기 전ㅇ레 컴파일도 해야 하므로 이에 상응하는 노력이 발생해야 한다는 점이다.

`동적 타입 언어`의 장점은 코딩이 간단하고 자유도가 높다는 점이다. 타입을 명기하지 않는 만큼 소스코드를 보다 적은 행수로 작성할 수 있는 경우가 많다. 

단, 변수에 어떤 타입의 변수가 포함되어 있는지 실행시까지 정해지지 않으므로 실행시에 비로소 문제가 발생하거나 코딩 시에 IDE의 자동 보완 기능을 활용하기 어렵다는 단점이 있다. 

## 기본형

example
```
// int 타입의 정수 리터럴 (10진수)
int num1 = 123;
System. out.println(num1);

// int 타입의 정수 리터럴 (8진수)
int num2 = 010;             // 맨 앞에 0을 붙인다.

// int 타입의 정수 리터럴 (16진수)
int num3 = 0xa;             // 맨 앞에 0x 또는 0X를 붙인다.

// int 타입의 정수 리터럴 (2진수)
int num4 = 0b11;            // 맨 앞에 0b 또는 0B를 붙인다.

// long 타입의 정수 리터럴
long longNum = 1L           // 맨 끝에 l 또는 L을 붙인다.

// float 타입의 부동소수점 리터럴
float floatNum = 3.14f;         // 맨 끝에 f 또는 F를 붙인다.
System.out.println(floatNum);    //3.14
float floatNum2 = 3f;
System.out.println(floatNum2);    //3.0


//double 타입의 부동 소수점 리터럴
double doubleNum = 3.14;        // 소수점은 디폴트로 double 타입이 된다.
System.out.println(doubleNum);          //3.14
double doubleNum2 = 3d;         // 맨 끝에 d 또는 D를 붙인다.
System.out.println(doubleNum2);     //3.0

//논리 리터럴
boolean bool = true;                // true 또는 false
System.out.println(bool)            //true


//문자 리터럴
char c = 'A';                       //작은따옴표(')로 둘러싼다.
System.out.println(c)
```

수가 많은 숫자값을 표기할 경우 서류 등에서는 콤마(,)를 사용해서 `12,345,678`과 같이 구분해서 표기하는 일이 생긴다. 이런 경우 다음과 같이 언더스코어를 사용하여 구분 표기할 수 있다.
자바 7 이후에서 사용할수 있게 되었다.

```
long amount = 123_456_789;
System.out.println(amount);         //123456789
```

## 레퍼 클래스

기본형은 객체가 아니라 단순히 값이며 그 자신은 메서드를 갖지 않는다. 그러나 프로그램 안에서 기본형의 값에 대해 조작이 필요하게 되는 상황이 많이 있다. 그래서 자바는 기본형을 내포하여 해당 기본형의 값을 조작하는 기능을 마련한 '레퍼 클래스'를 제공하고 있다.

래퍼(wrapper)란 `감싼 것`이라는 의미다.

|기본형|래퍼클래스|
|------|-----------|
|byte|java.lang.Byte|
|sort|java.lang.Short|
|int|java.lang.Integer|
|long|java.lang.Long|
|char|java.lang.Character|
|float|java.lang.Float|
|double|java.lang.Double|
|boolean|java.lang.Boolean|

- 레퍼 클래스의 대표적인 상수

|상수|설명|
|------|-----------|
|SIZE|비트 수|
|BYTES|바이트 수(Java8)|
|MAX_VALUE|최댓값|
|MIN_VALUE|최솟값|

- 래퍼 클래스의 대표적인 메서드 

|메서드|설명|
|------|-----------|
|valueOf(기본형의 값)|기본형으로부터 래퍼 클래스의 객체로 변환한다.|
|valueOf(String s)|문자열로부터 래퍼 클래스의 객체로 변환한다.|
|valueOf(String s, int radix)|진수를 지정해서 문자열로부터 래퍼 클래스의 객체로 변환한다.|
|parseXxx(String s)|문자열로부터 기본형의 값으로 변환한다.|
|parseXxx(String s, int radix)|진수를 지정해 문자열로부터 기본형의 값으로 변환한다.|
|toString(기본형의 값)|기본형에서 문자열로 변환한다|
|toString(기본형의 값, int radix)|진수를 지정해 기본형에서 문자열로 변환한다.|

**스터디시 문의 개인적으로 이부분은 중요하다고 생각함**

valueOf 메서드를 이용하는 경우 사전에 생성된 객체를 이용할 수 있기 때문에 객체를 생성하지 않아 쓸데없이 메모리를 소비하지 않는다.

```
// int -> Integer
Integer num01 = new Integer(10);                // 새로운 객체를 생성하기 때문에 비효율적
Integer num02 = Integer.vlueOf(10);             // 캐시된 객체를 반환한다.

// Integer -> int
int num03 = num02.intValue();


// String -> Integer
Integer num04 = new Integer("10");              // 새로운 객체를 생성하기 때문에 비효율적
Integer num05 = Integer.valueOf("10");          // 캐시된 객체를 반환
Integer num06 = Integer.valueOf("11", 2);       // 진수 (radix)를 지정한다. 이 경우에 값은 3

// String -> int
int num07 = Integer.ParseInt("10");
int num08 = Integer.parseInt("11", 2);          // 진수 (radix)를 지정한다. 이 경우에 값은 3

// int -> String
String num09 = Integer.toStirng(10);

// Integer -> String
String num10 = num01.toString();
```

레퍼 클래스가 기본형과 크게 다른 점은 초깃값이다.
클래스의 필드로서 기본형인 int를 선언하는 경우도 초깃값이 0이다. 
이에 반해 래퍼형인 Integer를 선언하는 경우는 초깃값이 null이다.

이때문에 0과 데이터가 없는 상태(빈 상태)를 구별하고 싶은 경우는 래퍼형을 준비할 필요가 있음을 알 수 있다.

수치 계산에 이용하는 변수는 기본형을 사용하는 것이 좋다. null 체크 등이 불필요하며 대량의 계산이 필요한 경우에는 래퍼형에서 기본형으로 변환에 걸리는 시간도 무시할 수 없기 때문이다.

## enum

Enum은 Enumerated Type으로 `서로 연관된 상수 값들의 집합`이다.

상수는 변하지 않는다는 특징을 이용해 복잡한 값을 단순한 값으로 치환해서 사용할 수 있다.

```java
public static void main(String[] args) {
    /*
    * 1 = banana
    * 2 = apple
    * 3 = lemon
    */
    int type = 1;
    switch(type) {
    case 1:
        System.out.println("banana");
        break;
    case 2:
        System.out.println("apple");
        break;
    case 3:
        System.out.println("lemon");
        break;
    }
}
```

문제점은 치환한 값에 대한 정보(주석)가 삭제될 경우, 복잡한 코드로 주석을 찾기 어려워 질 경우 번호의 의미를 알 수 없다.
해결책으로 주석 삭제 후 변화지 않는 클래스 변수(final static)로 설정할 수 있다.

```java
private final static int BANANA = 1;
private final static int APPLE = 2;
private final static int LEMON = 3;

public static void main(String[] args) {
    int type = BANANA;
    switch(type) {
    case 1:
        System.out.println("banana");
        break;
    case 2:
        System.out.println("apple");
        break;
    case 3:
        System.out.println("lemon");
        break;
    }
}
```

문제점은 같은 상수명을 갖는 다른 의미의 값이 존재 가능하고 그 경우 에러를 발생할 수 있다.

```
private final static int BANANA = 1;
private final static int APPLE = 2;
private final static int LEMON = 3;

private final static int GOOGLE = 1;
private final static int APPLE = 2;
private final static int MS = 3;
```

이 경우 해결책 중 하나로 Interface를 통한 상수명 구체화로 상수명의 중복을 피할 수 있다.

```
interface FRUIT {
    final static int BANANA = 1;
    final static int APPLE = 2;
    final static int LEMON = 3;
}

interface COMPANY {
    final static int GOOGLE = 1;
    final static int APPLE = 2;
    final static int MS = 3;
}

..
    int type = FRUIT.BANANA;
..
```

문제점은 의미로 비교할 수 없는 상수간의 비교가 가능하다.

`비교를 하더라도 컴파일 에러가 발생하지 않는다.`

```
if (FRUIT.APPLE == COMPANY.APPLE) {
    System.out.println("과일 애플과 회사 애플은 같다.");
}
```

그러나 이러한 문제를 모두 해결해 줄 수 있는 것이 `Enum` 이다.

```
enum FRUIT {
    BANANA, APPLE, LEMON
}

enum COMPANY {
    GOOGLE, APPLE, MS
}

public class ex5 {
    public static void main(String[] args) {
        FRUIT type = FRUIT.BANANA;
        switch (type) {
        case BANANA:
            System.out.println("banana");
            break;
        case APPLE:
            System.out.println("apple");
            break;
        case LEMON:
            System.out.println("lemon");
            break;
        }
    }
}
```

**`enum` 장점**

- 코드의 양이 줄었다.
- 인스턴스 생성과 상속 시도 시, 컴파일 에러
- enum 이라는 키워드로 열거형의 의도를 명확히 드러냄

## 제네릭 (Generics)

클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법을 의미

```
public class GenericStack<E> {

    private List<E> taskList;
    public GenericStack() {
        taskList = new ArrayList<>();
    }
    public boolean push(E task) {
        return taskList.add(task);
    }
    
    public E pop() {
        if(teskList.isEmpty()) {
            return null;
        }
        
        return taskList.remove(taskList.size() - 1);
    }
}
```

```
GenericStack<String> genStack = new GenricStack<>();

genStack.push("Scala");
genStack.push("Groovy");
genStack.push("Java");

Stirng genElement.genStack.pop();
if(genElement != null) {
    System.out.println(genElement);
}

GenericStack<Integer> getStack2 = new GenericStack<>();

genStack2.push(100);
genStack2.push(200);

Integer genElement2 = genStack2.pop();   // 캐스트가 불필요

if(genElement2 != null) {
    System.out.pritln(genElement2);         //200
}
```


## 배열이란?

동일 타입의 값을 여러 개 취급할 수 있는 기능이 배열이다.
인덱스라고 불리는 []로 감싼 0 부터 시작하는 정수를 사용하여 배열의 길이나 순서를 나타낼 수 있다.
자바에서는 나중에 언급할 컬렉션의 기능이 출실하게 마련되어있어 배열보다도 컬렉션을 사용하는 경우가 많을지도 모르겠지만 기본적으로 파악해 두어야 한다.
우선 배열을 이요한 간단한 소스 코드를 살펴보자.

```
int[] array = new int[10]           // 배열의 선언
array[0] = 1;
array[1] = 1;
array[2] = 2;
array[3] = 3;
array[4] = 4;


System.out.println(array[0]);           //배열에서 값을 추출
```

배열을 사용한 피보나치 수열을 계산

```
int[] array = new int[10];

for(int i=0; i<10 ; i++) {
    if (i <= 1) {
        array[i] = 1;
    } else {
        array[i] = array[i-1] + array[i-2]
    }
}

for (int value: array) {
    System.out.println(value);
}
```

만약 배열이 없다면 값의 수만큼 변수를 선언해야한다.

- 배열 초기화 하기

```
int[] array1 = new int[10];                 // 크기만을 지정
int[] array2 = {1,2,3,4,5};                 // 초깃값을 지정
int[] array3 = new int[] {10, 9, 8, 7, 6}   // 초깃값과 타입을 지정

System.out.println(array1.length);          // length로 길이를 알아낼 수 있다.
```

```
void log(String message, String[] args) {

}

log("사용자를 등록하였습니다", new String[]{"userName", "Ken"});    //문제없이 실행할 수 있다.
log("사용자를 등록하였습니다", {"userName", "Ken"});        //컴파일 에러
```

배열은 한번 작성하면 요소 수를 변경할 수 없다.
그렇기 때문에 이미 작성한 배열의 요소 수를 변경하고 싶은 경우에는 새로운 배열을 작성한 후에 예정 배열에서 새로운 배열로 필요한 정보를 복사해야한다.

```
int[] array = {1, 1, 2, 3, 5, 9, 13};
int[] newArray1 = new int[array.length + 3];
System.arraycopy(array, 0, newArray1, 0, array.length); //자바 5.0까지의 배열 복사 방법

int[] newArray2 = Arrays.copyOf(array, array.length + 3);
// 자바 6.0 이후의 배열 복사 방법

newArray1[7] = 21;
newArray1[8] = 34;
newArray1[9] = 55;
newArray1[10] = 89;         //ArrayIndexOutOfBoundException 발생
```

- Arrays 클래스를 이용하여 배열 조작하기

자바에는 배열의 정렬이나 검색 등 자주 사용하는 처리를 정리한 java.util.Arrays 클래스가 준비되어 있다. Arrays 클래스를 이용함으로써 정렬 등도 효율적으로 실시할 수 있다.

**배열의 문자열 변환**

우선 배열의 요소를 문자열로 변환하는 메소드이다.

```
int[] array = {1,1,2,3,5,9,13};
System.out.println(array);
System.out.println(Arrays.toString(array));
```

이 처리를 실행하면 다음과 같이 실행된다.

```
[I@bb60c3
[1, 1, 2, 3, 5, 9, 13]
```

첫 번째의 [I@bb60c3의 부분은 다음과 같은 것을 나타낸다.

- [             = 배열
- ㅑ             = int 타입
- @이후의문자열    = 해시값


- 배열의 정렬

배열을 순서대로 나열하는 정렬 처리는 Arrays 클래스의 sort 메서드로 실시할 수 있다. sort 메서드는 자기 자신이 직접 기술하는 것보다도 효율이 좋은 알고리즘으로 정렬을 실시해 준다.

```
int[] array = {3, 1, 13, 2, 8, 5, 1};
Arrays.sort(array)
System.out.println(Arrays.toString(array));
```

```
[1, 1, 2, 3, 5, 8, 13]
```

객체의 경우, 정렬의 대상이 되는 클래스가 Comparable 인터페이스 구현 클래스가 아니면 ClassCastException이 발생한다는 점에 주의해야 한다.

- Comparable 인터페이스란?

Comparable 인터페이스는 compareTo() 메서드를 통해 객체 간의 순서를 비교할 수 있도록 해준다.
즉, Comparable 인터페이스를 구현한 클래스는 그 인스턴스들에게 순서가 존재한다는 뜻이다.

Comparable 인터페이스를 구현한면 객체들의 배열을 Arrays.sort() 메서드를 통해 아래와 같이 손쉽게 정렬할 수 있다.

``` java
public class Node implements Comparable<Node> {
    private String content;
    private int order;

    public Node(String content, int order) {
        this.content = content;
        this.order = order;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(order, o.order);
    }

    @Override
    public String toString() {
        return "content : " + content + ", order : " + order;
    }
}
```

```
@Test

public void simpleOrderingNode() {
    Node[] nodes = new Node[3];
    nodes[0] = new Node("five", 5);
    nodes[1] = new Node("three", 3);
    nodes[2] = new Node("one" 1);

    Arrays.sort(nodes);
    Arrays.stream(nodes).forEach(n -> System.out.prinln(n.toStirng()));

    // retsult
    // content : one, order : 1
    // content : three, order : 3
    // content : five, order : 5
}
```


## ref
- https://icarus8050.tistory.com/10
- https://programmingnote.tistory.com/29
- https://heepie.me/32
- 자바 마스터북



