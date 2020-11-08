


## 백기선님과 함께하는 라이브 스터디

1주차 과제

`목표`

자바 소스 파일(.java)을 JVM으로 실행하는 과정 이해하기.

`학습할 것`

- JVM이란 무엇인가
- 컴파일 하는 방법
- 실행하는 방법
- 바이트코드란 무엇인가
- JIT 컴파일러란 무엇이며 어떻게 동작하는지
- JVM 구성 요소
- JDK와 JRE의 차이

**아래 내용은 블로그 및 인터넷, 서적을 보고 클론 타이핑하며 작성하였습니다.**

## JVM이란 무엇인가

ref

- http://www.itworld.co.kr/news/110837
- 자바 마스터 북 (http://www.yes24.com/Product/Goods/58960335)
- https://asfirstalways.tistory.com/158

자바 가상 머신(Java Virtual Machine, JVM)은 시스템 메모리를 관리하면서 자바 기반 애플리케이션을 위해 이식 가능한 실행 환경을 제공한다.

java virtual machine의 줄임말이며 Java Byte Code를 OS에 맞게 해석 해주는 역할을 합니다. Java Compiler는 .java 파일을 .class 라는 java byte code로 변환 시켜 준다. byte code는 기계어가 아니기 때문에 바로 os에서 바로 실행되지 않는다. 이때 jvm은 os가 bytecode를 이해할 수 있도록 해석 해준다. 하지만 jvm의 해석을 거치기 때문에 c언어와 같은 네이티브 언어에 비해 속도가 느렸지만 JIT(Just In Time) 컴파일러를 구현해 이점을 극복했다. 
Byte Code 는 JVM 위에서 os상관없이 실행된다. 이런점이 java의 가장 크나 장점이라고 할 수 있다. os에 종속적이지 않고 Java 파일 하나만 만들면 어느 디바이스든 JVM 위에서 실행 할 수 있다. JVM은 크게 Class Loader, Runtime Data Areas, Excution Engine, Garbage Collector 4가지로 구성되어 있다.

## 컴파일 하는 방법

ref

- https://superblo.tistory.com/entry/%EC%BB%A4%EB%A7%A8%EB%93%9Ccmd%EC%97%90%EC%84%9C-%EC%9E%90%EB%B0%94-%EC%BB%B4%ED%8C%8C%EC%9D%BC%ED%95%98%EA%B8%B0-%EB%B0%8F-%EC%8B%A4%ED%96%89-%EB%B0%A9%EB%B2%95
- https://aljjabaegi.tistory.com/387

#### cmd에서 자바 컴파일 하기

class 파일 만들기

```
$ javac main.java
```

파일 실행 

```
$ java main
```

#### 자바 컴파일 과정

개발자들이 ide나 terminal 환경에서 .java 파일을 생성한다. 그리고 build라는 작업을통해 .class 파일을 생성하게 된다.

이것은 아직 컴퓨터가 읽을 수 없는 자바 바이트코드(반기계어) 이다.

![java compile](https://t1.daumcdn.net/cfile/tistory/995DA63D5AE9701B34)

출처 : https://t1.daumcdn.net/cfile/tistory/995DA63D5AE9701B34

이렇게 생성된 자바 바이트 코드 (.class)는 클래스 로더에 의해서 JVM 내로 로드 되고, 실행 엔진에 의해 기계어로 해석되어 메모리 상(Runtime Data Area)에 배치되게 된다. 

실행엔진에는 Interpreter와 JIT(Just-In-Time) Compiler가 있다.
Interpreter는 바이트 코드를 한줄씩 읽기 때문에 실행이 느린 단점이 있다.

이러한 단점을 보완하기 위해 나온것이 JIT Compiler이다. 
인터프리터 방식으로 실행하다가 적절한 시점에 바이트 코드 전체를 컴파일 하고 더이상 인터프리팅 하지 않고 해당 코드를 직접 실행하는 것이다. JIT Compiler에 의해 해석된 코드는 캐시에 보관하기 때문에 한 번 컴파일 된 후에는 빠르게 수행하는 장점이 있다. 

하지만 인터프리팅 방식보다는 훨씬 오래 걸리므로 한번만 실행하면 되는 코드는 인터프리팅하는것이 유리하다.

- interpreter

자바 바이트 코드를 한줄 씩 실행, 여러번 실행하는 환경에서는 다소 느림

- JIT Compiler

Interpreter의 단점을 보완, 전체 바이트 코드를 컴파일, 캐시 사용으로 한번 컴파일하면 다음에는 빠르게 수행

## 실행하는 방법

[eclipse](https://post.naver.com/viewer/postView.nhn?volumeNo=24616660&memberNo=42458017)

[intellij](https://whitepaek.tistory.com/10)

## 바이트코드란 무엇인가

ref

- https://medium.com/@kimddub/java-jvm%EA%B3%BC-%EB%B0%94%EC%9D%B4%ED%8A%B8%EC%BD%94%EB%93%9C-bytecode-da9f269c8ce9
- https://ko.wikipedia.org/wiki/%EB%B0%94%EC%9D%B4%ED%8A%B8%EC%BD%94%EB%93%9C
- https://medium.com/@js230023/%EC%9E%90%EB%B0%94-jvm%EA%B3%BC-%EB%B0%94%EC%9D%B4%ED%8A%B8-%EC%BD%94%EB%93%9C-4e754ee02490

바이트코드(Bytecode, portable code, p-code)는 특정 하드웨어가 아닌 가상 컴퓨터에서 돌아가는 실행 프로그램을 위한 이진 표현법이다. 하드웨어가 아닌 소프트웨어에 의해 처리되기 때문에 보통 기계어 보다 더 추상적이다.

JVM이 사용자가 작성한 .java 소스 코드 파일을 운영체제에 실행 가능한 명령어 집합 파일로 컴파일 하는 과정 중에서 필요한 코드

- JVM이 이해할 수 있는 언어로 변환된 자바 소스코드를 의미
- 자바 컴파일러에 의해 변환되는 코드의 명령어의 크기가 1byte라서 자바 바이트 코드라고 불림
- 자바 바이트 코드는 자바 가상 머신만 설치되어 있다면 어느 운영체제에서도 실행 가능

### JIT 컴파일러란 무엇이며 어떻게 동작하는 지

ref

- https://ko.wikipedia.org/wiki/JIT_%EC%BB%B4%ED%8C%8C%EC%9D%BC
- https://m.blog.naver.com/ki630808/221844888233
- https://medium.com/@ahn428/java-jit-%EC%BB%B4%ED%8C%8C%EC%9D%BC%EB%9F%AC-c7d068e29f45

JIT 컴파일 (just-in-time-compilation) 또는 동적 번역(dynamic translation)은 프로그램을 실제 실행하는 시점에 기계어로 번역하는 컴파일 기법이다.

전통적인 입장에서 컴퓨터 프로그램을 만드는 방법은 두가지가 있는데, 인터프리트 방식과 정적 컴파일 방식으로 나눌 수 있다. 이 중 인터프리트 방식은 실행 중 프로그래밍 언어를 읽어가면서 해당 기능에 대응하는 기계어 코드를 실행하며, 반면 정적 컴파일을 실행하기 전에 프로그램 코드를 기계어로 번역한다.

JIT 컴파일러는 두가지의 방식을 혼합한 방식으로 생각할 수 있는데, 실행 시점에서 인터프리트 방식으로 기계어 코드를 생성하면서 그 코드를 캐싱하여, 같은 함수가 여러 분 불릴 때 매번 기계어 코드를 생성하는 것을 방지한다.

최근에 자바 가상 머신과 .NET, V8(node)에서는 JIT 컴파일을 지원한다. 즉, 자바 컴파일러가 자바 프로그램 코드를 바이트 코드로 변환한 다음, 실제 바이트 코드를 실행하는 시점에서 자바 가상 머신이 바이트 코드를 JIT 컴파일을 통해 기계어로 번역한다.

다른 컴파일 유형과는 달리, JIT 컴파일러의 주요 정의 특성은 프로그램이 시작되고 코드를 컴파일한 후에 JIT 컴파일러를 실행한다는 것이다.


HelloLeaguecat.java 소스 코드를 생성했다고 가정하자

1. HelloLeaguecat.java 소스 코드를 작성

2. javac.exe(Java 컴파일러)가 바이트 코드 (HelloLeaguecat.class)로 변환해준다.

3. 그리고 JVM에서 각 운영체제에 맞는 기계어로 번역해 전달한다.

![jit1](https://miro.medium.com/max/1400/1*VFo0CC-chzvqJk6sls6ukQ.png)

출처 : https://miro.medium.com/max/1400/1*VFo0CC-chzvqJk6sls6ukQ.png

그림을 보면 JIT 컴파일러는 JRE 안에 존재한다. (JRE는 JDK에 포함되고 JVM안에도 JIT이 존재한다.)

즉,  JIT 컴파일러는 같은 코드를 매번 해석하지 않고 실행할 때 컴파일을 하면서 해당 코드를 캐싱해버린다. 이후엔, 바뀐 부분만 컴파일 하고 나머지는 캐싱된 코드를 사용한다. 인터프리터의 속도를 개선 가능하다.

위에서 이미 작성했던 비교 내용이다.

- interpreter

자바 바이트 코드를 한줄 씩 실행, 여러번 실행하는 환경에서는 다소 느림

- JIT Compiler

Interpreter의 단점을 보완, 전체 바이트 코드를 컴파일, 캐시 사용으로 한번 컴파일하면 다음에는 빠르게 수행

#### JIT 동작 방식

![jit2](https://media.geeksforgeeks.org/wp-content/uploads/CommonArticleDesign20-min-1.png)

출처 : https://www.geeksforgeeks.org/just-in-time-compiler/

java는 객체 지향 지향 접근 방식을 따른다, 결과적으로 클래스로, JVM에 의해 실행되는 byte code로 구성되게 된다.

- 런타임에서 JVM은 클래스 파일을 로드하고 각각 적절한 계산이 수행된다. 인터프리터시 java 응용 프로그램이 느린 경향이 있다.

- JIT 컴파일은 런타임에 바이트 코드를 원시 기계 코드로 컴파일 시켜 Java 프로그램의 성능을 향상 시킨다.

- JIT 컴파일러는 메서드 호출 내내 활성화 된다. 이때, 컴파일된 메서드의 경우 다이랙트로 호출하게되는데, 이론적으로 컴파일에 프로세서 시간이나 메모리 사용이 필요하지 않다면 native compiler와 java 컴파일러의 속도는 동일하다


## JVM 구성 요소


![jvm구조](https://media.vlpt.us/images/hono2030/post/21adf2f3-f155-4e50-bdb6-5e8b1675129c/image.png)

출처 : https://media.vlpt.us/images/hono2030/post/21adf2f3-f155-4e50-bdb6-5e8b1675129c/image.png


- class loader

runtime 시점에 클래스를 로딩하게 해주며 클래스의 인스턴스를 생성하면 클래스 로더를 통해 메모리에 로드하게 된다.

- runtime data areas

Jvm이 프로그램을 수행하기 위해 os로 부터 별도로 할당 받은 메모리 공간을 말하며, runtime data areas는 크게 5가지 영역으로 나눌 수 있다.

- execution engine

load된 class의 bytecode를 실행하는 runtime module이 바로 execution engine이다. class loader를 통해 jvm 내의 runtime data areas에 배치된 바이트 코드는 execution engine에 의해 실행된다. 

- Garbage Collector

Garbage Collector(GC)는 Heap 메모리 영역에 생성된 객체들 중에 참조되지 않은 객체들을 제거하는 역할을 한다. GC의 동작시간은 일정하게 정해져 있지 않기 때문에 언제 객체를 정리할지는 알 수 없다. 즉 바로 참조가 없어지자마자 작동하는 것이 아니라는 것이다. 또한 GC를 수행하는 동안 GC Thread를 제외한 다른 모든 Thread는 일시정지상태가 된다.

특히, Full GC가 일어나는 수초간 모든 Thread가 정지한다면 심각한 장애로 이어질 수 있다.


최초 JVM이 나왔을때 Interpreter(한 줄씩 해석하고 실행) 이였기 때문에 속도가 느리다는 단점이 있었지만 JIT compiler (just in time) 방식을 통해 이 점을 보완해왔다. JIT는 bytecode를 어셈블러 같은 nativecode로 바꿔서 실행이 빠르지만 역시 변환하는데 비용이 발생한다. 이 같은 이유 때문에 jvm은 모든 코드를 jit compiler 방식으로 실행하지 않고 interpreter 방식을 사용하다 일정 기준이 넘어가면 jit compiler 방식으로 실행한다.

## JDK와 JRE 차이

ref
- 자바 마스터북

#### 자바의 세가지 에디션

1. Java SE(Standard Edition) Java vm과 표준 api 등을 정리한 가장 표준적인 버전이다. PC나 서버 등에서 동작하는 애플리케이션을 개발 및 실행하는 경우에 사용한다.
2. Java EE(Enterprise Edition) 웹 서비스나 서버 간 통신, 메일 송신 등 서버 애플리케이션에 필요한 기능이 많이 포함되어 있다.
3. Java ME(Micro Edition) 가전제품과 휴대전화 등의 임베디드 시스템용의 애플리케이션을 개발하기 위한 에디션이다. Java SE에 비해 사용할 수 있는 기능이 한정되어 있지만 필요한 리소스(CPU나 메모리 등)가 적게 들어 임베디드 시스템 등에서도 잘 동작한다.   또한 자바는 실행 환경 (JRE) 및 개발 환경 (JDK)의 두가지로 나누어져 있다.

#### JDK와 JRE

A. Jre(Java Runtime Environment)

자바 애플리케이션의 실행 환경이다. 이미 컴파일된 자바 애플리케이션의 모듈(JAR 파일과 클래스 파일 등)을 이용하여 실행할 수 있다.

B. JDK(Java Development Kit)

자바 애플리케이션의 개발 환경이다. 실행 환경뿐만 아니라 소스 파일의 컴파일러 및 디버거 등 자바 애플리케이션을 개발하기 위한 도구가 포함되어 있다.

애플리케이션을 JRE가 있으면 작동시킬 수 있다. 단,  운영할때 디버깅 및 분석 등을 하고자 하는 경우에는 jdk에 들어있는 도구가 필요하다. 따라서 서버 등의 운영 환경에 설치하는 경우에도 JRE보다는 JDK를 선택하는 것이 좋은 경우도 있다.

#### 느낀점

저는 개발자가 되고픈 엔지니어입니다. 근래 개발자가 되고싶어 스터디를 하고있는 것을 알고 있던 주변 개발자들 추천으로 해당 스터디를 진행하게 되었습니다.

놀라웠던 점은 동시에 여러분이 해당 youtube 영상 링크를 보내주시며 같이해보자고 권유해주셨고, 헛산게 아니구나 라는 생각을 하게되었습니다 :) 

자바에 대해서는 많이 부족하지만 천천히 차근차근 공부해보도록 하겠습니다.