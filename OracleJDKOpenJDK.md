## ref 

- https://www.lpcinc.co.kr/blog/java-%EC%9C%A0%EB%A3%8C-%EB%85%BC%EC%9F%81-oracle-jdk%EC%99%80-openjdk%EC%9D%98-%EC%B0%A8%EC%9D%B4-%EC%A0%95%EB%A6%AC


## Oracle JDK와 OpenJDK

- Java 애플리케이션을 실행하기 위해서는 JVM이 필요하고 컴파일하기 위해서는 JDK가 필요하다. 일반적으로 JDK를 설치하면 JVM(Hotspot이라고도 표현, Java 기술의 핵심)도 함께 설치된다.

- JDK는 2개 버전으로 나뉜다. 하나는 폐쇄적인 상업 코드 기반의 `Oracle JDK`이고 하나는 오픈 소스 기반의 `OpenJDK` 이다.

- 둘 간의 큰 차이라면 Oracle JDK는 OpenJDK에는 없는 재산권이 걸린 플러그인을 제공한다. 해당 플러그인은 Oracle이 재산권을 보유하고 있다. (보자 정확히 설명하면 Oracle이 인수하여 없어진 Sum Microsystems 시절의 유산이다.)

- Oracle JDK에 존재하고 OpenJDK에는 없는 대표적 기능으로 글꼴 라이브러리와 Java Web Start가 있다. 사용자의 웹 브라우저에서 자바 애플릿을 실행하려면 필요한 기능이다. 서버 애플리케이션 개발에는 쓰이지 않는 기능들이다.

- 제공되는 기능적 차이 외에 Java 6 시대에는 분명히 OpenJDK가 OracleJDK 보다 성능이나 안정성이 크게 떨어졌다. 하지만 오늘날에는 OracleJDK만이 제공하는 일부 라이브러리를 제외하고는 차이가 없다.

## Oracle JDK는 무료인가?

- Java의 무료 논쟁은 2011년 오라클이 소유권을 가지면서 시작되었다. 일단 명확히 해야할 점은 Java라는 프로그래밍 언어 자체는 GPL 라이센스로 무료이다. 그렇지 않다면 오늘날 Java가 시장지배적인 언어가 되지 못했을 것이다. 중요한 부분은 Java로 작성한 프로그램을 컴파일(JDK)하고 실행(JVM) 시키는데 있다.

- JDK와 JVM을 제공하는 `OpenJDK`은 GPL v2 with the Classpath Exception 라이센스로 무료이다.

- 문제는 `Oracle JDK`이다. 결론부터 이야기하면 Oracle JDK는 사용 목적에 따라 무료일수도 유료일수도 있다. 먼저 Oracle JDK(Java SE)의 구성 요소를 살펴보면 아래와 같다.

```
1. JDK 
2. JRE(JVM)
3. JavaFX SDK
4. JavaFX Runtime
5. JRockit JDK
```

- Oracle JDK는 BCL(Oracle Binary Code License) 라이센스로 위 기능을 일반적인 목적의 컴퓨팅(General Purpose Computing) 에만 사용시 무료라고 밝히고 이다.

일반적인 목적의 컴퓨팅이란 무엇일까? 오라클은 데스크탑, 노트북, 스마트폰, 태블릿 등에서 사용이 이에 해당한다고 설명하고 있다. 즉, 개발환경에서는 상요에 있어 아무 문제가 없다.

- 일반적이지 않은 목적의 컴퓨팅(Non-General Purpose Computing)은 별도의 라이센스비를 지불해야 하는 유료 과금 대상이 된다. 오라클은 특정 기능 만을 위해 작동하는 시스템 및 솔루션에서의 사용이 이에 해당한다고 설명하고 있다.
이 부분의 애매한 표현 때문에 대부부의 상업 프로젝트를 진행하는 회사 들은 OpenJDK를 사용한다.

## Oracle JDK의 유료 구독형 라이센스 전환

- Oracle JDK 바이너리에 적용되던 BCL 라이센스가 2018년 7월 부로 `Java SE Subscription`라는 이름의 년 단위 유료 구독형 라이센스로 새롭게 개편되었다.

- 새로운 라이센스는 서버 및 클라우드 인스턴스의 경우 프로세서 당 월 25달러를, 데스크탑 2.5 달러를 요구한다. 대량구매 및 2년, 3년 장기 구독에 따른 할인이 제공된다.

- 구독한 라이센스 기간이 종료되면 사용자는 사용 권리를 잃어버린다. 라이센스를 갱신하거나 다른 무료 OpenJDK 바이너리로 전환해야한다. (GPL 라이센스 기반의 OpenJDK 소스 코드는 LTS 지원 없이 6개월마다 새로운 버전이 공개된다.)

- 새로운 라이센스는 2018년 9월 출시 예정인 Oracle JDK 11 바이너리부터 적용된다. 또한, 오직 라이센스 구독자 만이 LTS 업데이트 지원을 받을 수 있다. (다음 LTS 지원 버전의 출시는 3년 뒤로 Oracle JDK 17이 된다.)

- 기존 Oracle JDK 8 바이너리의 경우 2019년 1월 이후 업데이트부터 라이센스 구독을 요구한다.

- 새로운 라이센스에서도 비상업적인 용도에 한해서는 이전과 같은 무료 사용이 가능하다.

## OpenJDK는 운영 환경에 부적합한가?

 - 결론부터 이야기하면 TCK 인증을 받은 OpenJDK 기반의 빌드 버전을 사용하면 운영 환경에 아무런 문제가 없다.

- JAVA SE 7 부터 모든 JDK는 OpenJDK 레퍼런스 소스 코드를 기반으로 제작된다. (Java SE 6 버전의 OpenJDK는 백포트 방식으로 구현되어 성능 저하 이슈가 존재한다.) OpenJDK는 자바 스펙을 명시한 JSR 336, JSR 337를 빠짐없이 완전히 구현한 구현체이다.

- 오라클이 아닌 서드파티 업체가 OpenJDK를 기반으로 공인된 JDK를 제작하여 배포하려면 오라클의 유료 라이센스인 `OCTLA`에 가입해야 한다. 현재 전세계에 19개 업체가 가입되어 있다.  이 업체들이 OpenJDK 기반의 자체 빌드를 배포하려면 오라클의 엄격한 `TCK` 인증을 통과해야바이너리로 빌드하여 배포하는 대표적인 업체로는 한다. 수만가지의 테스트를 단 하나라도 통과하지 못하면 인증되지 않는다.

- OpenJDK를 멀티 플랫폼 바이너리로 빌드하여 배포하는 대표적인 업체로는 `Azul Sytems` 가 있다. 개발 환경과 운영환경 모두 Oracle JDK의 대안으로 좋은 평가를 받고 있다.

## OpenJDK 구현체 

- OpenJDK의 명세는 JCP(오라클, IBM, SAP 등으로 구성)에 의해서 결정된다.
 OpenJDK는 결정된 스펙(Java SE 7: JSR 336, Java SE 8:JSR 337)을 구현한 레퍼런스 소스코드이다. 많은 상업 JVM 벤더들이 이 OpenJDK를 완벽히 준수하는 구현체로 인정된다. Oracle JDK 또한 Java SE 7 부터 이 OpenJDK를 기반으로 앞서 설명한 추가 요소를 담아 배포한다.

 - 트위터는 OpenJDK를 자사에 맞게 튜닝한 Twitter-JDK 위에서 자사의 서비스를 운영한다.

 - `Azul Systems` (미국 소재의 Java Runtime 제작 전문 회사)는 `Zulu`라는 OpenJDK 기반 빌드에 부가 기능을 추가한 Windows, Linux, Mac OS X 바이너리를 무료로 제공한다. 이 회사는 서버 부하에 최적화된 `Zing` 이라는 JVM을 판매한다. 엔터프라이즈 시장에서 Oracle JDK의 대안으로는 현재 독보적 위치에 있다. 테스트에서 Oracle JDK 보다 성능이 좋았다는 사례도 있다.  실제로 고성능을 요구하는 Cassandra 노드들은 Zing 기반으로 운영된다.
  

## mac에 jdk 여러 버전 설치

ref

- https://jojoldu.tistory.com/329
- https://nesoy.github.io/articles/2019-07/jenv

jenv란?

- 다양한 java version을 하나의 컴퓨터에서 사용하는 상황에서는 매우 복잡함이 있다.
- python의 pyenv가 있듯이 java의 version을 관리하는 도구

gcc 설치

gcc란 ? GNU 컴파일러 모음. 개발에 되어 널리 쓰이고 있는 컴파일러

```
$ brew install gcc
```

jenv 설치

```
$ brew install jenv
```

.zshrc에 추가하기

```
```
