
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



