


## 백기선님과 함께하는 라이브 코딩

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

## JVM이란 무엇인가

ref

- http://www.itworld.co.kr/news/110837
- 자바 마스터 북 (http://www.yes24.com/Product/Goods/58960335)
- https://asfirstalways.tistory.com/158

자바 가상 머신(Java Virtual Machine, JVM)은 시스템 메모리를 관리하면서 자바 기반 애플리케이션을 위해 이식 가능한 실행 환경을 제공한다.

java virtual machine의 줄임말이며 Java Byte Code를 OS에 맞게 해석 해주는 역할을 합니다. Java Compiler는 .java 파일을 .class 라는 java byte code로 변환 시켜 준다. byte code는 기계어가 아니기 때문에 바로 os에서 바로 실행되지 않는다. 이때 jvm은 os가 bytecode를 이해할 수 있도록 해석 해준다. 하지만 jvm의 해석을 거치기 때문에 c언어와 같은 네이티브 언어에 비해 속도가 느렸지만 JIT(Just In Time) 컴파일러를 구현해 이점을 극복했다. 
Byte Code 는 JVM 위에서 os상관없이 실행된다. 이런점이 java의 가장 크나 장점이라고 할 수 있다. os에 종속적이지 않고 Java 파일 하나만 만들면 어느 디바이스든 JVM 위에서 실행 할 수 있다. JVM은 크게 Class Loader, Runtime Data Areas, Excution Engine, Garbage Collector 4가지로 구성되어 있다.


![jvm구조](https://media.vlpt.us/images/hono2030/post/21adf2f3-f155-4e50-bdb6-5e8b1675129c/image.png)

출처 : https://media.vlpt.us/images/hono2030/post/21adf2f3-f155-4e50-bdb6-5e8b1675129c/image.png


`class loader`

runtime 시점에 클래스를 로딩하게 해주며 클래스의 인스턴스를 생성하면 클래스 로더를 통해 메모리에 로드하게 된다.

`runtime data areas`

Jvm이 프로그램을 수행하기 위해 os로 부터 별도로 할당 받은 메모리 공간을 말하며, runtime data areas는 크게 5가지 영역으로 나눌 수 있다.

`execution engine`

load된 class의 bytecode를 실행하는 runtime module이 바로 execution engine이다. class loader를 통해 jvm 내의 runtime data areas에 배치된 바이트 코드는 execution engine에 의해 실행된다. 

`Garbage Collector`

Garbage Collector(GC)는 Heap 메모리 영역에 생성된 객체들 중에 참조되지 않은 객체들을 제거하는 역할을 한다. GC의 동작시간은 일정하게 정해져 있지 않기 때문에 언제 객체를 정리할지는 알 수 없다. 즉 바로 참조가 없어지자마자 작동하는 것이 아니라는 것이다. 또한 GC를 수행하는 동안 GC Thread를 제외한 다른 모든 Thread는 일시정지상태가 된다.

특히, Full GC가 일어나는 수초간 모든 Thread가 정지한다면 심각한 장애로 이어질 수 있다.


최초 JVM이 나왔을때 Interpreter(한 줄씩 해석하고 실행) 이였기 때문에 속도가 느리다는 단점이 있었지만 JIT compiler (just in time) 방식을 통해 이 점을 보완해왔다. JIT는 bytecode를 어셈블러 같은 nativecode로 바꿔서 실행이 빠르지만 역시 변환하는데 비용이 발생한다. 이 같은 이유 때문에 jvm은 모든 코드를 jit compiler 방식으로 실행하지 않고 interpreter 방식을 사용하다 일정 기준이 넘어가면 jit compiler 방식으로 실행한다.

