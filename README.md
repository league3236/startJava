
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

```java
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

compareTo 메소드는 무엇인가?
```java
Integer x =7;
System.out.println(x.compareTo(3)); //7이 3보다 큼 결과값 1
System.out.println(x.compareTo(7)); //7 7 동일 0
System.out.println(x.compareTo(77)); //7이 77보다 작으므로 결과값 -1
```

Comparator 인터페이스의 구현 클래스를 건네, 숫자를 내림차순으로 정렬한 예제
```java
Integer[] array = {3, 1, 13, 2, 8, 5, 1};

Comparator<Integer> c = new Comparator<Integer> () {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
};

Arrays.sort(arrsy, c);
System.out.println(Arrays.toString(array));
```

결과값
```
[13, 8, 5, 3, 2, 1, 1]
```

위에서 compare 메소드의 반환값에 따라 정렬의 동작이 변한다.

- 배열의 검색

배열 안에서 원하는 번호를 찾으려면, 배열의 검색을 실시할 필요가 잇다.

검색에는 Arrays 클래스의 binarySearch 메서드를 사용할 수 있다.
binarySearch 메서드는 그 이름대로, 바이너리서치(이진 탐색)를 수행하여 원하는 값을 검색한다.

![binarysearch](https://www.computerhope.com/jargon/b/binary-search.jpg)
https://www.computerhope.com/jargon/b/binary-search.jpg

```java
int[] array = {1, 1, 4, 5, 7, 8, 11, 12, 17, 21, 24};
int found = Arrays.binarySearch(array, 5);          // '5'라는 숫자 겁색
System.out.println(found)               //결과값 3

int notFound = Arrays.binarySearch(array, 6);   // '6'이라는 숫자를 검색
System.out.println(notFound);

//결과값 마이너스값
```

찾는값이 없으면 마이너스 결과값이 반환된다.
또한 정렬되지 않은 값에 대해서는 잘못된 값이 반환되므로 binarySearch는 정렬된 배열에서 사용해야한다.

정렬되지 않은 배열에서는 다음 두가지의 방식을 사용 할 수 있다.

1. 사전에 Arrays 클래스의 sort 메서드를 사용하여 정렬한다.
2. Arrays 클래스의 binarySearch 메서드를 사용하지 않고 선형 검색 등을 실시한다.

- 가변 길이 인수로 메서드 정의하기

로그 메서드의 내부는 다음과 같이 인수의 값을 출력하도록 되어 있다.
```java
void log(String message, String[] args) {
    System.out.println(message);
    System.out.println("매개변수:");
    for (String arg : args) {
        System.out.println(arg);
    }
}
```

args 배열에 들어가는 요소의 수는 가변으로, 요소의 수에 상관없이 모든 값을 표시할 수 있도록 되었다. 그러나 이 메서드를 호출하는 쪽은 인수 args 부분에 배열을 건넬 필요가 있어 매번 배열을 new하는 기술이 중복된다.

args의 부분은 항상 new String[]해야 한다.

```java
log("사용자를 등록하였다.", new String[]{"UserName", "ken"})
log("오류가 발생하였다.", new String[]{"Cannot load file"})
log("처리를 종료하였다.", new String[0])
```

이 중복된 기술을 없애기 위해서 가변 길이 인수를 사용해 메서드를 정의할 수 있다. 가변 길이 인수는 타입의 뒤에 `...(마침표 3개)`를 붙여서 정의한다.
가변 길이 인수를 사용함으로써 메서드를 호출하는 쪽은 일일이 배열을 new 할 필요가 없게 되었다.

가변 길이 인수에 의한 메서드 정의

```java
void log(String message, String... args) {
    System.out.println(message);
    System.out.println("파라미터:");
    for (String arg : args) {
        System.out.println(arg);
    }
}
```

가변 길이 인수에 의한 메서드 호출

```java
log("사용자를 등록하였다", "userName", "KEN");
log("오류가 발생하였다.", "Cannot load file")
log("처리를 종료하였다.")
```

## 컬렉션 프레임워크로 여러 데이터 처리하기

**배열의 한계와 컬렉션의 특징**

배열을 길이가 결정되어 있기 때문에 요소의 추가가 삭제가 어렵다.

그래서 자바에서는 복수의 데이터를 좀 더 다루기 쉬운 구조로 `컬렉션`을 준비했다.

이러한 컬렉션과 반복자, 그리고 컬렉션을 다루기 위한 유틸리티 등의 집합을 프레임워크라고 부른다.

컬렉션은 배열과 달리 처음부터 크기의 제한을 결정할 필요가 없이 원하는 만큼 데이터를 저장 할 수 있다. 또한 컬렉션 프레임워크는 많은 인터페이스와 구현이 준비되어 있어, 각각 다른 알고리즘으로 데이터를 관리한다. 예를 들어, 배열처럼 여러 데이터를 처리할 수 있는 List 인터페이스와 키와 값을 나누어 데이터를 유지하는 Map 인터페이스 등이 있다.

**대표적인 컬렉션**

|명칭|개요|
|------|-----------|
|배열|복수의 요소를 취급하는 메커니즘. 간단하지만 유연성이 떨어진다.|
|java.util.List|배열처럼 복수의 요소를 취급할 수 있으며, 인덱스를 지정해서 값의 취득이나 설정을 할 수 있다.|
|java.util.Set|List와 비슷하지만 요소가 중복하는 경우는 등록하지 않기 때문에 중복이 없는 복수의 요소를 취급할 수 있다. 순서성이 없기 때문에 인덱스를 지정하여 값을 취득, 설정할 수 있다.|
|java.util.Map|키와 값을 이요하여 요소를 취급할 수 있다. 다른 언어에서는 연상 배열이나 딕셔너리라고 불리기도 한다. Set과 마찬가지로 순서성이없다.|

- 배열과 같이 인덱스를 지정해서 값의 취득이나 설정을 하고 싶은 경우
  -> List 인터페이스
- 요소에 값의 중복이 없는 경우, 검색/정렬을 고속으로 실시하고 싶은 경우
  -> Set 인터페이스
- 키와 값을 나누어서 요소를 취급하고 싶은 경우
  -> Map 인터페이스

## List 인터페이스의 기본

List 인터페이스는 배열과 비슷한 방법으로 복수의 요소를 처리할 수 있다.

- 요소를 추가하는 add 메서드
- 요소를 덮어 쓰는 set 메서드
- 인덱스를 사용하여 요소를 취득하는 get 메서드

취급하기 쉽기 때문에 컬렉션 프레임워크 중에서도 가장 이용될 기회가 많은 인터페이스다.

List 초기화

```java
List<Integer> list = new ArrayList<>();
```

또한 요소의 값을 열거하여 List를 작성하고 싶은 경우에는 다음과 같이 new로 작성항 List에 add 메서드로 요소를 추가할 수 있다.

```java
List<Integer> list = new ArrayList<>();
list.add(1);
list.add(62);
list.add(31);
list.add(1);
```

이것을 좀 더 간단하게 작성하고 싶은 경우에는 이미 작성한 배열을 베이스로 List를 작성하는것도 가능하다.

```
List<Integer> integerList = Arrays.asList(1, 62, 31, 1, 53, 31);
```

단 asList 메서드를 사용해서 List를 작성한 경우, 작성한 List에 대해 요소의 추가, 변경, 삭제를 할 수 없다.

Arrays 클래스의 asList 메서드로 작성한 클래스는 일반적인 ArrayList와 약간 달라서 읽기 전용의 List 구현이기 때문이다.

요소를 열거해서 작성한 List의 내용을 변경하고 싶은 경우에는 다음과 같이 List 클래스를 new 할때에 인수를 건넨다.

```
List<Integer> integerList = new ArrayList<>(Arrays.asList(1,63,43,23,3));
```

**List 정렬하기**

List를 정렬하기 위해서는 java.util.Collections 클래스의 sort 메서드를 이용한다. 배열의 정렬에서 사용한 Arrays 클래스의 sort 메서드와 똑같은 처리를 하는 메서드다.

다음의 소스코드는 Collections.sort 메서드를 이용한 정렬 처리이다.

```java
List<Integer> list = new ArrayList<>();
list.add(3);
list.add(1);
list.add(13);
list.add(2);

Comparator<Integer> c = new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}

Collections.sort(list, c);
System.out.println(list);
```


List를 검색하기 위해서는 Collections 클래스의 binarySearch 메서드를 이용한다. 

```java
List<Integer> values = Arrays.asList(1, 1, 4, 5, 7, 8, 11, 12, 17, 21, 24);

int found = Collections.binarySearch(values, 5);
System.out.println(found)

int notFound = Collections.binarySearch(values, 6);
System.out.println(notFound)
```

**List의 반복자**

```java
List<String> list = new ArrayList<>();
list.add("a");
list.add("b");
list.add("c");

for (String element : list){
    System.out.println(element);
}
```

동일하게 반복 처리를 실시하는 방법으로 Iterator 인터페이스 라는것이 있다.
List 인터페이스의 iterator 메서드를 실행함으로써 이 Iterator 인터페이스를 취득할 수 있다.

- 다음 요소가 있는지를 확인하는 hasNext 메서드
- 다음 요소를 실제로 취득하는 next 메서드

```java
List<String> list = new ArrayList<>();
list.add("a");
list.add("b");
list.add("c");

for(Iterator iterator = list.iterator(); iterator.hasNext();){
    String element = iterator.next();
    System.out.println(element);
}
```

for-each를 사용한 리스트와 iterator를 사용한 리스트를 서로 비교하면, for-each 문을 사용하는 편이 간단하므로 반복자인 iterator를 사용하지 않아도 될 것처럼 보인다. 그러나 반복자인 iterator요소를 삭제하는 메서드가 준비되어 있어 반복 처리를 하면서 컬렉션으로부터 요소를 삭제할 수있다.

```java
class Student {
    private Stirng name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
```

```java
List<Student> student = new ArrayList<>();
students.add(new Student("Ken", 100));
students.add(new Student("Shin", 60));
students.add(new Student("Kim", 80));

Iterator<Student> iterator = students.iterator();
while (iterator.hasNext()) {
    Student student = iterator.next();
    if (student.getScore() < 70) {
        iterator.remove()           //점수가 70점 미만인 사람은 리스트에서 삭제
    }
}

for (Student student : students) {
    System.out.println(student.getName() + ":" + student.getScore());
}
```

**ArrayList와 LinkedList 클래스의 비교**

LinkedList와 ArrayList는 모두 Java에서 제공하는 List 인터페이스를 구현한 Collection 구현체이다.

하지만 인터페이스만 같을 뿐 내부적으로 동작하는 방식은 다르다.

Java에서는 기본형 (Privitive Types) 또는 인스턴스(Reference Type)을 저장하기 위해 보통 배열을 사욯나다.

하지만 배열의 초기 길이를 지정해야 하며 생성된 배열의 길이는 동적으로 변경할 수 없다는 점 때문에 상황에 맞게 사용해야한다.

java의 초기 버전인 1.0에서는 이러한 문제를 해소하기 위해 주로 Vector를 사용하려고 했다. 하지만 Vector 역시 인스턴스 생성시에 capacity가 디폴트로 10개 정해져 리스트의 개수가 capacity 이상이 되면 두 배씩 늘려 나아가는 전략을 택하고 있다.

java 1.2 이후 부터는 호환성을 위해 제공하는 정도이며 List 인터페이스를 구현한 리스트로 대체하여 사용하고 있다.

**ArrayList**

ArrayList는 내부적으로 데이터를 배열에서 관리하며 데이터의 추가, 삭제를 위해 임식 배열을 생성해 데이터를 복사 하는 방법을 사용하고 있다.

대량의 자룔르 추가/삭제 하는 경우에는 그만큼 데이터의 복사가 많이 일어나게 되어 성능 저하를 일으킬 수 있다. 

반면 각 데이터는 인덱스를 가지고 있기 때문에 한번에 참조가 가능해 데이터 검색에는 유리한 구현체이다.

**LinkedList**

LinkedList는 데이터를 저장하는 각 노드가 이전 노드와 다음 노드의 상태만 알고 있다고 보면된다.

ArrayList와 같이 데이터의 추가, 삭제시 불필요한 데이터의 복사가 없어 데이터의 추가, 삭제시에 유리한 반면 데이터의 검색시에는 처음부터 노드를 순회해야 하기 때문에 성능상 불리하다. 

- 배열의 중간에서 요소의 추가나 삭제를 실시하는 일이 많다.
  -> LinkedList
- for문 등을 사용한 전체적인 반복 처리가 많다.
  -> ArrayList
- 복수의 스레드에서 동시에 액세스 한다.
  -> CopyonWriteArrayList

## Map 인터페이스

Map 인터페이스는 키와 값의 조합으로 값을 취급한다. List 인터페이스의 경우는 값의 추가는 add 메서드에 값만을 건넸지만, Map 인터페이스의 경우는 값의 추가는 'put' 메서드를 사용하여 키와 값을 동시에 건넨다. 또한 값의 삭제는 키를 지정하여 실시한다.

**Map 초기화**

다음 코드에서는 요소가 빈 HashMap 객체를 생성하고 있다.

```java
Map<Integer, String> map = new HashMap<>();
```

List와 동일하게 Map에도 초깃값을 지정할 방법은 없다. 그렇기 때문에 값을 지정하고 싶은 경우는 Map 인터페이스의 put 메서드를 사용하여 하나씩 값을 추가해 나갈 필요가 있다.

```java
Map<Integer, String> map = new HashMap<>();
map.put(1, "One");
map.put(2, "Two");
map.put(3, "Three");
```

클래스 초기화 시에 Map도 초기화하고 싶은 경우는 다음과 같이 static 초기화를 사용

```java
public class MapTest {
    private static final Map<Integer, String> map;

    static {
        map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "Two");
        map.put(3, "Three");
    }
}
```

**Map의 구현 클래스 분류 사용법**

각 클래스는 여기서 다루지 않겠다.. 스터디 데드라인이 빡세므로.... ㅠㅠ

- 키의 대소를 의식한 부분 집합을 취급할 경우
  -> TreeMap
- 요소의 순서를 유지할 필요가 있는 경우
  -> LinkedHashMap
- 복수 스레드로부터 동시에 액세스할 경우
  -> ConcureentHashMap
- 그 외의 경우
  -> HashMap

## Set 

Set 인터페이스는 값의 집합을 취급할 수 있는 인터페이스이다. List 인터페이스와 동일하게 요소를 추가하는 `add` 메서드가 준비되어 있는데 요소를 취득하는 `get` 메서드는 존재하지 않는다.
또한 값의 집합을 취급하는 인터페이스이기 때문에 특정의 요소를 취득할 수 없다.

**Set 초기화**

```java
Set<Integer> integerSet = new HashSet<>();
```

**컬렉션을 Set으로 변환하기**

생성자의 인수로 컬렉션을 건네고 컬렉션을 Set으로 변환한다.

```java
List<Integer> integerList = new ArrayList<>();
Set<Integer> integerSet = new HashSet<>(integerList)
```

변환하려는 컬렉션의 요소에 중복 요소가 존재하는 경우는 중복이 제외된 후 Set으로 변환된다.

```java
List<Integer> integerList = Arrays.asList(1, 62, 31, 1, 54, 31);
System.out.println("List : " + integerList);

Set<Integer> integerSet = new HashSet<>(integerList);
System.out.println("Set : " + integerSet)
```


## 갑자기 궁금해 져서 혼자 다시 정리한 내용(위에 내용 중복될 수 있음)

**int와 integer 차이**

`int`는 Privitive 자료형, 산술 연산이 가능하며 null로 초기화 할 수 없다.
`integer`는 Wrapper 클래스(객체) unboxing하지 않으면 산술 연산이 불가능하지만, null값을 처리 가능
null 값 처리가 용이하기 때문에 SQL과 연동할 경우 처리가 용이하다.

## StreamAPI

자바 8에서는 자바의 문법을 크게 변화시킬 새로운 기능이 도입되었다. 하나는 람다식이고 다른 하나는 Stream API다.
StreamAPI는 대량 데이터를 연속 처리하는 `스트림 처리`를 효율적으로 기술하기 위한 수단으로 도입되었다.
단, 대량 데이터가 아니더라도 컬렉션의 조작을 효율적으로 실시할 수 있으므로 자주 이용되고 있다.


```java
List<Student> students = new ArrayList<>();
students.add(new Student("Haeun", 100));
students.add(new Student("league", 60));
students.add(new Student("cat", 80));

students.stream()                   // `작성`. Stream 인스턴스를 생성한다.
    .filter(s->s.getScore() >= 70)              // `중간 작업`
    .forEach(s->System.out.println(s.getName())); // `종료 작업`. 이름을 표시
```

결과와 같이 소스 코드의 행수가 줄어든 뿐만 아니라 어떠한 처리를 실시하고 싶은지 쉽게 알 수 있게 되어있다.

## 람다식

Stream을 알기위해서는 람다식에 대해서 배울 필요성이 있다.
람다식은 메서드의 인수 등에 처리 그 자체를 건네는것이 가능한 강력한 기법이다.


```java
List<Student> studentList = new ArrayList<>();
studentList.add(new Student("Jung", 100));
studentList.add(new Student("Song", 70));
studentList.add(new Student("Tommy", 80));

System.out.println(studentList);

Collections.sort(studentList, (student1, student2) -> Integer.compare(student1.getscore(), student2.getScore()));

System.out.println(studentList);
```

**함수형 인터페이스**

자바8에서는 구현해야 할 메서드가 하나밖에 없는 인터페이스를 `함수형 인터페이스`라는 이름으로 취급할 수 잇다. 람다식은 이 함수형 인터페이스 대신 사용할 수 있는것이다.

```java
Student[] students = {
    new Student("Ken", 100),
    new Student("Shin", 60),
    new Student("Kim", 80)
}

Arrays.sort(students, (Student o1, Student o2) ->
Integer.compare(o2.getScore(), o1.getScore()));

Arrays.stream(students).forEach(s ->
System.out.println(s.getName() + ":" + s.getScore()));
```

**람다식의 기본 문법**

```
( 인수 ) -> { 처리 }
```

인수 부분은 메서드 정의의 인수 부분과 동일하게 작성한다. 예를 들어, 앞의 Comparator <Student> 클래스의 compare 메서드는 다음과 같이 선언

```java
compare(Student o1, Student o2)
```

이에 대응하는 람다식과 같다.

```java
(Student student1, Student student2) -> {
    return Integer.compare(student1.getScore(), student2.getScore());
}
```

해당 코드를 짧게 줄일 수 있다.

```java
(student1, student2) -> {
    return Integer.compare(student1.getscore(), student2.getscore())
}
```

**메서드 참조**

자바 8에서는 이미 준비되어 있는 메서드 그 자체를 대입할 수 있다.

```java
List<String> list = Arrays.asList("Xxx", "Yyyyy", "Zzzz");
list.forEasch(System.out::println);
```

**숫자 범위로 Stream 작성** 

```java
IntStream stream = IntStream.range(1, 5);           // range 메서드는 맨 마지막 값을 포함하지 않음
Stream.forEach(System.out::print);
```

```java
IntStream stream = IntStream.rangeClosed(1, 5);         // rangeClosed 메서드는 맨 마지막 값을 포함한다.
Stream.forEach(System.out:print);
```


for문을 사용한 처리
```
for (int i=0; i < count; i++) {
    // 처리
}
```

IntStream을 사용한 처리

```
IntStream.range(0, count).forEach( i -> {
    //처리
});
```

Student 객체의 Stream으로부터 score의 값을 추출하는 코드
```
List<Student> students = new ArrayList<>();
students.add(new Student("Ken", 100));
students.add(new Student("Shin", 60));
students.add(new Student("Tommy", 80));

Stream<Integer> stream = students.stream()
    .map(s -> s.getScore());
stream.forEach(System.out::println);
```

**map과 flatmap 차이**

map 메서드만 사용한 경우

```java
List<Student> allStudents = new ArrayList<>();
groups.stream().forEach(g -> allStudents.addAll(g.getStudents()));
allStudents.stream()
    .sorted((s1, s2) -> s2.getScore() - s1.getScore())
    .forEach(s -> System.out.println(s.getName() + " " s.getScore()));
```

flatMap 메서드를 사용한 경우

```java
froups.stream()
    .flatMap(g -> g.getStudents().stream())
    .sorted((s1, s2) -> s2.getScore() - s1.getScore())
    .forEach(s -> System.out.prinln(s.getName() + " " + s.getScore))
```

- 반복 처리를 실시하는 종료 작업 : forEach 메서드 사용
- 결과를 정리해서 추출하는 종료 작업 : collect, toArray, reduce

StreamAPI 중에서도 map, filter, collect는 매우 이용 빈도가 높기 때문에 처음부터 기억해야할 메서드라고 말할 수 있다.

```java
List<String> list = Arrays.asList("HaeunJung", "Shin", "ShinJung");

List<String> newList = list.stream()
    .filter(p -> p.length() > 5)
    .map(p -> "[" + p + "]")
    .collect(Collectors.toList());

newList.forEach(System.out::println)
```



작성한 프로그램에 `기대하지 않은 동작`이 발생한 것을 `예외`라고 한다.

자바에서는 예외를 크게 세가지 종류로 나눌 수 있다.

1. 검사 예외 (Exception)

주로 프로그램 작성 시에 예상할 수 잇는 비정상 상태를 통지하기 위해서 사용한다. 예를 들어 파일에서 데이터를 입출력하는 처리에서 파일을 읽고 쓸 수 없는 경우가 있는데
이때는 java.io.IOException 예외가 발생한다. 검사 예외를 사용하면 예상되는 비정상 상태에 대응하는 처리가 있는지 컴파일 시에 체크할 수 있기 때문에 견고한 애플리케이션을 만들 수 있다.
검사 예외는 프로그램에서 포착(catch)해서 처리하거나, 상위의 호출원에 대해 예외를 발생시키는(throw)것이 필수다.

2. 실행 시 예외 (RuntimeException)

주로 프로그램 작성 시에 예상할 수 없는 오류를 통지하기 위해서 사용한다.
`예상할 수 없는 오류`에는 흔히 있는 버그나 설정 누락이 포함되어있다. 검사 예외와는 달리 프로그램에서 포착하지 않아도 컴파일 오류가 발생하지 않는다.

포착하지 않는 경우 무조건 호출원에서 발생하게 된다. 예를 들어 Integer 클래스의 parseInt 메서드를 호출할 때 정수로 변환할 수 없는 문자열을 인수로 지정하면
java.langNumberFormatException이 발생한다. 그러나 Integer 클래스의 parseInt 메서드는 String 객체를 int 타입으로 변환하기 위한 API 이므로 정수로 변환할 수 없는 문자열을 인수로 지정하는 것은 예상 외의 이용 방법이다.

따라서 일반적으로 호출원에서 예외를 포착할 필요가 없다. 이러한 예외를 모두 검사 예외와 마찬가지로 반드시 포착해야 한다면 프로그래밍 복잡하기 어렵게 된다.

이러한 이유로 실행 시 예외를 이용함으로써 예상치 못한 동작에 의해 비정상 상태가 발생하는 경우에도 불필요하게 호출원에 예외를 포착시킬 필요가 업섹 되었다.

`2장 기본적인 작성법 익히기`의 예제 프로그램에서 다루었듯이 숫자를 0으로 나누는 경우에 발생하는 java.lang.ArithmeticException도 바로 실행 시 예외에 해당된다.

3. 오류 (Error)

예외와는 달리 시스템의 동작을 계속할 수 없는 `치명적 오류`를 나타낸다. 거의 대부분의 경우 이 `치명적 오류`는 프로그램에서 포착해야 하는 것이 아니다.

**예외를 나타내는 세 가지 클래스**

1. java.lang.Exception 클래스

검사 예외를 나타내는 클래스다. 이 클래스를 계승한 예외의 예로는 다음과 같은 것이 있다.

- 파일이나 네트워크 등의 입출력 중에 발생한 에러를 나타내는 java.io.IOException 클래스
- 데이터베이스 액세스 중에 발생한 에러를 나타내는 java.sqlSQLException 클래스

이 클래스를 계승한 예외는 프로그램 안에서 포착할 수 있는데, 발생하는 메서드의 시그니처에 throws 절을 기술할 필요가 있다. 
예를 들면 다음에 나타내는 고드에서는 readFile 메서드의 호출에서 IOException이 발생할 가능성이 있음을 명시적으로 알 수 있다.

```
public List<String> readFile() throws IOException {
	// 파일을 읽어들이는 처리
}
```

이런 예외 처리의 메커니즘은 실수가 발생하기 어려운 반면 강제적으로 try~catch 블록이 필요하게 되어 프로그램이 길어진다는 점에서 찬반 여론이 있는 것도 사실이다.

2. java.lang.RuntimeException 클래스

실행 시 예외를 나타내는 클래스다.

해당 클래스를 계승한 예외는 프로그램 안에서 반드시 포착할 필요도 없고, 메서드의 시그니처에 throws 절을 기술할 필요도 없다.
catch 블록도, throws 절도 기술하지 않은 경우 발생한 실행 시 예외는 호출원에 자동적으로 전파된다. 
그렇다면 실행시 예외를 어디서도 포착하지 않은 경우는 어떻게 될까?

해답은 `그 스레드가 종료해 버린다`이다. 스레드를 시작한 처리 자체에는 예외가 전파되지 않는다. 실제로 스레드를 시작하고 있는것은 Java VM이다.

그 결과 Java VM에 예외가 도달한 시점에 그 스레드는 종료해 버린다. 스레드가 JavaVM의 메인 스레드인 경우는 애플리케이션 자체가 종료한다.

3. java.lang.Error 클래스

`일반적인 애플리케이션에서는 포착해서는 안 되는 중대한 문제`를 나타내는 클래스다. 자바의 예외 메커니즘의 관점에서 볼 때 Error는 RuntimeException과 비슷하여 catch 블록도, throws 절도 기술할 필요가 없다.

그러나 그 의미는 RuntimeException과는 크게 다르다. 위에 언급한 대로 Error는 `포착해야 할 것이 아닌` 것이다.

왜냐하면 Error가 발생하는 상황은 대부분의 경우 애플리케이션이 비정상의 상태에 빠져 있어 신속하게 프로그램을 종료시켜야 하는 상황이기 때문이다.

예를들어 유명한 Error 중에 하나로 java.lang.OutOfMemoryError 클래스가 있다.

이것은 자바가 사용하는 메모리가 부족하거나 할 때 발생한다. 이 오류가 발생한 경우는 로그 출력 조차도 할 수 없는 상태라고 생각할 수 있다.

그런 상태에서 애플리케이션이 침묵하고 있는 최악의 사태라고 할 수 있기 때문에 신속하게 종료해야 하는 것 이다.

**예외 처리의 세 가지 구문 제대로 사용하기**

1. try-catch-finally

``` java
try {
    // SomeException 예외가 발생하는 코드를 포함하는 처리
} catch (SomeException ex) {
    // SomeException 예외를 catch한 경우의 처리
} finally {
   // try-catch 블록을 종료할 때에 반드시 실행해야 하는 처리
}
```

```java

// try-catch 블록을 가로질러 사용하는 변수의 선언
byte[] contents = new byte[100];
InputStream is = null;

try {
    // 예외가 발생하는 코드를 포함하는 처리 
    is = Files.newInputStream(path);
    is.read(contents);
} catch (IOException ex) {
    // 예외를 포착한 경우의 처리
} finally {
    // try-catch 블록을 종료하기 전에 반드시 실행
    if (is != null) {
        is.close();
    }
}

```

fially 블록은 스트림이나 데이터베이스 접속처럼 사용 후에 반드시 해제해야 하는 리소스의 객체를 사용할 경우에 자주 이용된다.
우선 finally 블록을 사용하지 않는 경우를 살펴 보자. 예를들어 다음과 같은 경우는 리소스의 해제를 빼먹는 일이 발생.

2. try-with-resources
finally 블록의 작성법은 중복으로 리소스를 여러개 사용하는 try-catch 블록에서는 중복이 배로 증가하여 상당히 귀찮다.
그래서 자바 7부터 도입된 것이 try-with-resources 구문이다.

```java
try (InputStream is = Files.newInputStream(path)) {
    is.read(contents);
    // contents에 대한 처리
} catch (IOException ex) {
    // 예외를 포착한 경우의 처리
}
```

자바 7부터 InputStream 등의 리소스를 취급하는 클래스는 java.lang.AutoClosable 인터페이스 또는 java.io.Closable 인터페이스를 구현하도록 되었다.
그리고 try 블록의 시작 시 (try (...)으로 작성한 ... 부분)에 AutoClosable 인터페이스의 구현 클래스를 선언해두면 해당 try~catch 블로의 종료 시의 처리에서 실시할 close 메서드를 자동으로 호출하게 된다.

3. 다중 캐치

try 블록안에서 한 종류의 예외만 발생한다고 가정했다.

그러나 실제 업무에서 프로그램을 만들려고 하면 try 블록 안에서 여러 예외가 발생하는 경우도 많다.
예를 들어 데이터베이스에 액세스 하는 처리와 파일을 읽어들이는 처리를 순서대로 실시하는 경우에는 각각의 처리에서 예외가 발생한다.

```java
try {
    Class<?> clazz = Class.forName(className);
    SomeClass objSomeClass = clazz.newInstance();
} catch (ClassNotFoundException ex) {
} catch (InstantiationException ex) {
} catch (IllegalAccessException ex) {
}
```

각각의 예외에 상응하는 처리를 하고 싶은 경우도 있을 것이다. 하지만 대부분의 경우 로그를 출력하고 상위로 예외를 발생시키든지, 처리를 중지시키게 된다.
귀찮다고 해서 Exception으로 포착해서는 안된다.

복수의 예외에서 동일 처리를하고 싶은 경우 자바 7에서 도입된 `다중 캐치`를 이용하면 복잡한 catch 블록의 기술을좀 더 편하게 할 수 있다.

```java
try {
    Class<?> clazz = Class.forName(className);
    SomeClass objSomeClss = clazz.newInstance();
} catch (ClassNotFoundException |
          InstantiationException |
          IllegalAccessException ex) {
}
``` 


예외는 catch 블록으로 포착하고, throw 하지 않아도 컴파일 오류가 안되는 코드는 다음과 같이 로그로 출력한다.

```JAVA

// Logger log = ...

String strValue = "abc";

try {
    int intValue= Integer.valueOf(strValue);
    System.out.println("intValue is " + intValue);
} catch (NumberFormatException ex) {
    log.warn("숫자가 아닙니다." + ex);
}
```


## StringBuilder

StringBuilder를 사용하면 문자열을 결합하는 for문이 있을때 처리시간이 압도적으로 빠르다.

```java
StringBuilder builder = new StringBuilder();
for (int i = 0; i < LOOP_COUNT; i++) {
    builder.append("a");
}
```

StringBuilder 클래스에서도 문자열을 배열로 보유하고 있지만 StringBuilder 클래스에서는 미리 여유 있는 크기의 배열을 확보하고 있기 때문에 append 메서드에 의한 문자열 추가에서 매번 새로운 배열을 만드는 일은 없다. 혹, 배열의 크기가 부족해도 다시 여유 있는 크기로 확장된다. 따라서 메모리를 확보하는 횟수가 적어져 + 연산자와 concat 메서드보다도 빨라진다.

- 로컬 변수 등 여러 스레드로부터 액세스되지 않는 경우 : String Builder 클래스를 사용한다.
- 여러 스레드로부터 사용되는 경우 : StringBuffer 클래스를 사용한다.

**문자열 분할하기**

```java
String sentence = "This is a pen.";
Stirng[] words = sentence.split(" ");

for (String word : words) {
    Sytem.out.println(word);
}
```

마침표(.)로 문자열을 구분

```java
Stirng url = "www.jpub.co.kr";
String[] words = url.split("\\.");

for (String word : words) {
    System.out.println(word);
}
```

**여러 문자열 결합하기**

```java
List<String> stringList = new ArrayList<>();
stringList.add("This");
stringList.add("is");
stringList.add("a");
stirngList.add("pen.");

StirngBuilder message = new StirngBuilder();
for (String word : stringList) {
    message.append(word);
    message.append(" ");
}

if (message>length() > 0) {
    message.deleteCharAt(message.length() - 1);
}

System.out.println(message.toStirng());

```

join 메서드 활용

인수 1에는 연결에 사용하는 문자, 인수 2에는 문자열의 리스트를 설정

```java
List<String> stirngList = new ArrayList<>();
stirngList.add("This");
stringList.add("is");
stringList.add("a");
stringList.add("pen.");

String message = String.join(" ", stringList);

System.out.prinln(message);
```

```
This is a pen.
```

join 메서드 의 다른 사용법
인수 1에 연결에 사용하는 문자, 인수 2 이후에는 연결하고 싶은 문자열을 열거하는 것도 가능

```java
Stirng message = String.join(".", "www", "jpub", "co", "kr");
System.out.println(message);
```

**문자열 치환하기**

```java
Stirng sentence = "This is a pen.";
Stirng replacedSentence = sentence.replace("is", "at");
System.out.prinln(replacedSentence)
```

**문자열 검색하기**

- indexOf : 앞에서 검색
- lastIndexOf : 뒤에서 부터 검색 

## 정규 표현

```java
Pattern pattern = Pattern.compile("This is a .*\\.");

String sentence = "This is a pen.";

Matcher matcher = patter.matcher(sentence);

if (matcher.matches()){
    System.out.println("적합하다");
} else {
    System.out.println("적합하지않다");
}
```

**정규표현을 사용하여 문자열 치환하기**

```java
Pattern pattern = Pattern.compile("\\s+");

String sentence = "This     is a pen.";

Matcher matcher = pattern.matcher(sentence);

System.out.println(matcher.replaceAll(" "));
```

String 클래스의 메서드로 정규 표현 사용하기

String 클래스만으로도 정규표현식 사용이 가능하다.
```jav

String sentence = "This         is a pen.";

System.out.println("(1)");
System.out.println(sentence.matches);

System.out.println("(2)");
String[] words = sentence.split("\\s+");
for (String word : words) {
    System.out.println(word);
}

System.out.println("(3)");
System.out.println(sentence.replaceAll("\\s+", " "));s
```

### 파일 조작

파일은 프로그램에서 일반적인 리소스 중의 하나. 어느 정도의 규모를 가진 프로그래밍라면 대부분의 경우는 설정 파일을 읽어들일 필요가 있고, 사용자 및 외부 시스템에서 파일을 송수신하는 것도 적지 않음.

**File 클래스의 객체 생성**

```java
File file1 = new File("C:/league/cat.txt");
File file2 = new File("./cat.txt");
```

**File.separator 상수를 사용하면 OS 파일 구분자를 얻을 수 있음**

```java
System.out.println(File.separtator);
```

**이스케이프 문자**

어떠한 문자의 다음 문자에 특별한 의미를 갖게 하는 문자


#### Path 클래스

자바 7 이후에는 java.nio.file.Path 클래스를 사용하여 파일을 조작하는 java.nio.file 패키지가 추가됨

### 파일 읽고 쓰는 예제

```java

File file = new File("C:/work/sample.dat");

InputStream is = null;

try{
    // 파일을 1문자씩 읽어서 표시
    is = new FileInputStream(file);
    for (int ch; (ch=is.read())!=-1;) {
        System.out.print((char) ch);
    }
} catch (FileNotFoundException ex) {
    System.err.println(ex);
} catch (IOException ex) {
    System.err.println(ex);
} finally {
    if (is != null) {
        try {
            is.close();
        } catch (IOException ex) {
             System.err.println(ex);
        }
    }
}
```

**path 클래스를 사용하여 바이너리 파일 읽기**

```java

Path path = Paths.get("C:/league/cat.dat");

try (InputStream is = Files.newInputStream(path)) {
    for (int ch; (ch = is.read()) != -1) {
        System.out.print((char) ch);
    }
} catch (IOException ex) {
    Sytem.err.println(ex);
}

```

**path 클래스를 사용하여 텍스트 파일 읽기**

```java
Path path = Paths.get("C:/work/sample.txt");

try (BufferedReader reader = Files.newBufferedReader (path, StandardCharsets.UTF_8)) {
    for (Stirng line; (line = reader.readLine()) != null;) {
        System.out.println(line);
    }
} catch (IOException ex) {
    System.err.println(ex);
}
```

**텍스트 파일 기록하기**

```java
Path path = Paths.get("C:/work/sample.txt");

try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
    writer.append("test");
    writer.newLine();
    writer.append("test2");
} catch (IOException ex) {
    System.err.println(ex);
}
```

**Stream API를 사용해서 파일 읽어오기**

```
Path path = Paths.get("C:/work/sample.txt");

try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
    reader.lines();
        .forEach(System.out::println);
} catch (IOException ex) {
    System.err.println(ex);
}
```

#### 속성 파일 

다른 시스템의 IP 주소나 로그인 사용자 이름 등의 접속 설정, 동작에 필요한 디렉터리와 파일의 경로 설정 등을 대체외 외부 정의화가 필요하다. 그 이유는 동작 환경에 따라 변겨오디는 일이 많기 때문

- 메시지나 화면의 메뉴와 같은 문자열을 외부 정의화하여 변경하기 쉽게 하기
- 시스템을 사용하는 국가의 언어 환경에 따라 문자열을 한국어, 영어 등 다른 언어로 전환하여 표시할 수 있도록 한다. 이것을 `국제화 대응`이라고 함

예를 들어 mail의 속성파일은 다음과 같이 작성함

vim ./mail.properties

```txt
system.mail.address = league3235@gmail.com
system.mail.enable = true
system.mail.errormessage=Cannot send email.
```

읽기

```java
Path path = Paths.get("mail.properties");
try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
    Properties properties = new Properties();
    Properties.load(reader);

    String address = properties.getProperty("system.mail.address");
    Syste.out.println(address);
} catch (IOException ex) {
}
```

### Date와 Calendar

프로그램 안에서 날짜와 시간을 취급하기 위한 클래스로 `java.util.Date` 클래스와 `java.util.Calendar` 클래스 두 종류가 존재하며 용도에 따라 구분해야 한다.

또한 자바 8에서는 `Date and Time API`가 추가되어 날짜와 시간 조작이 더욱 쉬워졌다.

```java
Date now = new Date();
System.out.println(now);

Date date = new Date(5000);  // 1970년 1월 1일 오전0시 (GMT)로 부터 5,000밀리초 결과한 시간
System.out.println(date)
```

## 기본형과 참조형

**기본형의 값 전달**

```java
public class CallByValueSample {
    public static void main(String[] args) {
        int value = 1;
        callByValue(value);
        System.out.println("호출자:" + value);
    }

    public static void callByValue(int value) {
        value++;
        System.out.println("수신자:" + value);
    }
}
```

```
수신자: 2
호출자: 1
```

기본현의 값을 전달하는 경우는 수신자에서 값을 변경해도 호출자에 영향을 주지않는다.

**참조형의 값 전달**

```java

public class Entity {
    public int value;
}

public class CallByReferenceSample {
    public static void main(String... args) {
        Entity entity = new Entity();
        entity.value = 1;
        callByReference(entity);
        System.out.println("호출자:" + value);
    } 

    public static void callByReference(Entity entity) {
        entity.value++;                
        System.out.println("수신자:" + value);
    }
}
```

```
수신자: 2
호출자: 2
```

참조형은 객체에 대해 조작을 하기에 호출자에 반영된다.

**불변(immutable) 객체 클래스**

값을 변경할 수 없는 클래스 

- Integer 등의 래퍼 클래스
- String 클래스
- Date and Time API

example

```java
String text1 = "This is an apple";
Stirng text2 = text1.replace("apple", "orange");
```

text1의 값은 변하지 않는다.

**값이 변하는(mutable) 클래스**

- StringBuilder
- AutomicInteger

example
```java
StringBuilder text = new StringBuilder("This is ");
text.append("an apple.");
```

```
this is an apple
```

`immutable class`를 선호하는 이유는 안정감을 주기 때문이다.

그러나 `immutable class`의 경우 객체가 대량으로 생성되기 때문에 속도에 영향을 준다.

앞전에 설명했던 String과 StringBuilder의 속도차이는 이점으로 생기는 것이다.


## 가시성을 적절히 설정하여 버그가 적은 프로그램 만들기

자바의 변수와 메서드를 사용할 수 있는 범위를 `가시성`이라고 한다. 가시성을 적절하게 설정함으로써 잘못된 사용을 줄이거나 확장성을 높게 할 수 있다.

|가시성|설명|
|------|-------------------|
|public|모든 클래스로부터 이용할 수 있다.|
|protected|서브클래스, 동일 패키지의 클래스가 이용할 수 있다.|
|package private|동일 패키지의 클래스로부터 이용할 수 있다.|
|private|자신의 클래스만 이용할 수 있다.|

**public -> protecte -> package private -> private 순으로 사용 가능한 범위가 좁아져 간다.**

좁은 가시성을 사용하는 이유는, 생각지도 못한 클래스에서 호출되지 않게 도와준다.
- 원칙적으로 가장 범위가 좁은 가시성으로 한다.
  - 클래스에서 선언하는 필드는 private로 한다.
  - 외부에서 액세스하는 메서드에만 public으로 한다.

- 확장성을 높이기 위해 protected로 한다.

`원칙은 private` 라고 설명했지만 모두 다 private하면 사용하기 어렵게된다. 예를 들어 기능확장을 하고 싶은 경우에 private 메서드로 하면 상속도 변경도 할 수 없다. 따라서 확장할 가능성이 있는 메서드는 protected로 하여 미래를 위한 확장성을 높여둔다.

- 테스트 용이성을 높이기 위해 protected하기

## 객체의 라이프 사이클

1. 로컬 변수

변수를 선언한 곳에서 생성되어 블록이 종료한 시점에서 폐기된다.

2. 인스턴스 변수

클래스의 필드로 선언된 변수, 부모 객체를 생성할때 생성되며 부모 객체가 가비지 컬렉션 될때 함께 삭제된다.

3. 클래스 변수

클래스 변수는 static 필드로 선언된 변수다. 자바의 변수 중 가장 긴 라이프 사이클을 갖느다.
클래스 로드 시에 생성되어 클래스가 언로드되면 소멸된다. 


**라이프 사이클의 좋은 사례**

- 라이프 사이클을 짧게 하여 사고를 방지

라이프 사이클이 길면 길수록 의도하지 않게 값이 변경될 가능성이 커짐, 따라서 라이프 사이클을 짧게한다.

- 라이프 사이클을 길게 하여 성능을 높이기

라이프 사이클을 짧게하면 수명이 짧은 객체가 많이 만들어져 그만큼 가비지 컬렉션의 발생 횟수도 증가한다.

그러나 라이프 사이클이 긴 객체가 너무 많아지면 오히려 GC가 늘어날 수 있기 때문에 어떤 객체의라이프 사이클을 늘릴지 검토가 필요하다.

유틸리티 클래스

```java
public class StringUtils {
    // static은 붙이지 않는다.
    public boolean isEmpty(String text) {
        return (text == null || text.length() == 0);
    }
}
```

```java
public class MainService{
    private static StringUtils stringUtils = new StringUtils();

    public void execute(String text) {
        if(stringUtils.isEmpty(text)) {
        }
    }
}
```

### 다형성을 실현하기 위한 메커니즘

인터페이스와 추상 클래스는 모두 다형성(Polymorphism)이라는 개념을 실현하기 위한 기능이다.

java.util.ArrayList 클래스와 java.util.LinkedList 클래스가 비슷한 List의 조작을 다른 이름의 메서드로 갖고 있다면 프로그래머는 그 차이를 파악해야한다.

```java
List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.add(10);
System.out.println(list);
```

```java
List<Integer> lsit = new LinkedList<>();
list.add(1);
list.add(2);
list.add(3);
System.out.println(list);
```



**인터페이스와 추상 클래스의 성질**

| 종류 | 설명 |
|------|--------------------|
| 인터페이스 | 인스턴스 변수를 가질 수 없다. 상수를 가질 수 있다. |
| 추상 클래스 | abstract 메서드를 선언할 수 있다. 추상 클래스 자체는 인스턴스를 생성할 수 없다. 그외에는 클래스와 같다. |

**인터페이스의 성질**

설계자 관점에서 인터페이스는 `특성`의 정의라고 할 수 있다.
인터페이스를 구현함으로써 동일한 특성을 가진 클래스를 여러 개 만들 수 있다.
한편, 구현자 관점에서는 인터페이스는 `클래스에 대한 액세스를 제한하는 제약`

- 인터페이스의 원래의 이용 목적이 아니다
- 상수 인터페이스 필요하지 않은 경우 변경이 쉽지 않다
- 이용하지 않는 상수까지도 상수 인터페이스의 구현 클래스가 보관하게 된다

**추상 클래스의 성질**

설계자 관점에서 추상 클래스는 클래스를 추상화한 것, 여러 클래스에서 동일한 부분을 슈퍼클래스로 잘라내어 추상화해, 공통화한것이다.

- 인터페이스는 `정의`에 사용
- 추상 클래스는 `뼈대`나 `공통 처리`에 사용

```java
public interface UserManagementService {
    void register(User user);
    List<UserDto> list();
    void delete(Integer userId);
}
```

```java
public abstract class AbstractUserManagementService implements UserManagementService {
    protected UserDto convertFrom(User user) {
    }
}

public class HttpUserManagementService extends AbstractUserManagementService {
    public List<UserDto> list() {
    }
}

public class DatabaseUserManagementService extends AbstractUserManagementService {
    public List<UserDto> list() {
    }
}
```

인터페이스 부분은 한번 더 정독하기 

## 스레드 세이프

**프로세스**

`컴퓨터에서 연속적으로 실행되고 있는 컴퓨터 프로그램` 프로세스는 하드 디스크에 설치되어 있는 프로그램을 메모리상에 실행중인 작업이다. 

**멀티 스레드**

여러 작업을 동시에 수행하는 방식을 멀티 스레드라고 함
`프로세스 내에서 실행되는 여러 흐름의 단위`
기본적으로 프로세스당 최소 1개의 스레드를 가지고 있고 그것을 메인 스레드라고 한다. 

**멀티 스레드의 장점**

- 하나의 장시간을 요하는 작업 때문에 뒤에 있는 간단한 작업이 기다릴 필요가 없다.
- 태스크의 대기 시간을 효율적으로 활용할 수 있다.
- 대량의 태스크를 빨리 끝낼 수 있다.
CPU가 멀티 코어인 경우에도 프로그램을 단일 스레드로 움직이고 있으면 기껏해야 CPU 1코어 만큼의 계산밖에 해낼 수가 없다. 한편, 멀티스레드로 하여 여러 코어를 활용하면 Java VM이 스레드의 각 처리를 여러 프로세서/코어에 할당하여 시스템이 갖고있는 능력을 최대한 활용새 주므로 전체의 응답시간을 향상시킬 수 있다.

예를 들어 대량의 로그 데이터와 측정 데이터 등의 집계 결과를 얻고자 하는 경우 각 스레드별로 데이터를 분배하여 처리하고, 마지막에 그 결과를 통합함으로써 코어 수만큼 처리가 끝나는 시간을 단축할 수 있다.

- 되도록 각 스레드의 처리가 동시에 끝나도록 데이터를 분할한다.
- 스레드 간에 서로를 기다리게 하는 처리가 없어야 한다/적어야 한다.

**멀티 스레드의 단점**

- 메모리의 사용량이 증가한다

스레드가 증가하면 동시에 처리하는 메모리의 사용량도 증가한다. 또한 원래부터 스레드 자체를 관리하는데도 메모리는 소비된다. 스레드 수가 몇개정도라면 그다지 영향이 없을지도 모르겠지만 100개나 1000개씩 스레드를 마구 만들어 버리면 메모리 사용량이 문제가 될 수 있다.

- 처리량이 감소한다
- 동시성 특유의 문제가 발생한다
서로 데이터를 사용하다가 충돌이 일어날 가능성이 있다.
디버깅이 다소 까다로워진다.

교착상태가 발생하여 처리가 정지한다.

```
import java.util.ArrayList;
import java.util.List;

public class DeadLockSample {
    public static void main(String... args) {
        list<String> list1 = new ArrayList<>();
        list<String> list2 = new ArrayList<>();
        list1.add("list1-1");
        list2.add("list2-1");

        new Thread(new ResourceLocker(" 스레드A", list1, list2)).start();
        new Thread(new ResourceLocker(" 스레드B", list1, list2)).start();
    }
}
```


## ref
- https://jaepils.github.io/java/2018/06/27/java-time-Instant.html
- https://www.holaxprogramming.com/2014/02/12/java-list-interface/
- https://jamesdreaming.tistory.com/137
- https://icarus8050.tistory.com/10
- https://programmingnote.tistory.com/29
- https://heepie.me/32
- 자바 마스터북
- https://magi82.github.io/process-thread/



