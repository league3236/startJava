
## ref

- https://findstar.pe.kr/2019/01/20/install-openjdk-by-homebrew/


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


