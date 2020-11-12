

## maven vs gradle

gradle은 maven의 단점을 보완해준다고 한다.

#### 빌드 도구란 ?

- 소스코드를 컴파일, 테스트, 정적분석 등을 실히하여 실행 가능한 애플리케이션으로 자동 생성하는 프로그램
- 계속해서 늘어나는 라이브러리 자동 추가 및 관리
- 프로젝트를 진행하며 시간이 지남에 따라 라이브러리의 버전을 자동으로 동기화

**배경**

- 웹, 앱 프로그래밍 개발이 발전하며 어플을 개발함에 있어 필요한 라이브러리도 많아지게 되었고, 이 많은 라이브러리를 직접 다운받아서 추가하여 사용하는 방법도 있지만 많은 번거로움이 이따랐다. 이 때문에 발생한 것이 빌드 도구이다.

#### Ant

- XML 기반 빌드 스크립트를 개발
- 규칙이 없다
- 절차적이다 (명활한 빌드 절차 정의가 필요)
- 생명주기를 갖지 않아 각각의 target에 대한 의존관계와 작업을 정의해주어야 한다.
- 유연성이 높으나 프로젝트가 복잡해지는 경우 build 과정의 이해가 어렵다.
- xml, remote repository를 가져올 수 없다.
- 스크립트 재사용이 어렵다

#### maven

Apache의 이름 아래 2004년 출시
ant를 사용하던 개발자들의 불편함을 해소 + 부가기능 추가

- 빌드를 쉽게 (Making the build process easy)
- Pom.xml을 이용한 정형화된 빌드 시스템 (providing a uniform build system)
- 뛰어난 프로젝트 정보 제공 (Providing quality project information)
    - Change log document created directry from source control
    - Cross referenced sources
    - Mailing lists
    - Dependency list
    - Unit test reports including coverage
- 개발 가이드 라인 제공 (Providing guidelines for best practices development)
    - Keeping your test source code in a separate, but parallel source tree
    - Using test case naming conventions to locate and execute tests
    - Have test cases setup their environment and don’t rely on customizing the build for test preparation. 
- 새로운 기능을 쉽게 서치할 수 있고 업데이트 할 수 있음 (Allowing transparent migration to new features)
- 프로젝트에 필요한 모든 종속성(Dependency)를 리스트의 형태로 Maven에게 알려서 종속성을 관리한다.
- XML, Repository를 가져올 수 있다. => “Jar”, “Class Path”를 선언만 하면 직접 다운로드 할 필요가 없이 Repository에서 자동으로 필요한 라이브러리 파일을 불러와 준다.
- 라이브러리가 서로 종속할 경우 XML이 복잡해진다.
- 계층적인 데이터를 표현하기에는 좋지만, 플로우나 조건부 상황을 표현하기 어렵다.
- 편리하나 맞춤화된 로직 실행이 어렵다.

#### Gradle

Ant와 Maven의 장점을 모아 2012년 출시
Android OS의 빌드 도구로 채택됨 

- JVM 기반의 빌드 도구
- ant와 maven의 단점을 보완
- 오픈소스 기반의 build 자동화 도구
- groovy 기반 dsl로 작성한다
- 프로젝트 시작시 설정에 드는 시간을 절약할 수 있다.
- ant 처럼 유연한 범용 빌드 도구
- Maven을 사용할 수 있는 변환 가능 컨벤션 프레임워크
- 멀티 프로젝트에 사용하기 좋음
- Apache ivy에 기반한 강력한 의존성 관리
- Maven과 Ivy 레퍼지토리 완전 지원
- 원격 저장소나 pom, ivy 파일 없이 연결되는 의존성 관리 지원
- 그루비 문법 사용
- 빌드를 설명하는 풍부한 도메인 모델

#### Maven vs Gradle

Gradle이 시기적으로 늦게 나온만큼 사용성, 성능 등 비교적 뛰어난 스펙을 가지고 있음

Gradle이 Maven 보다 좋은점

- build라는 동적인 요소를 xml로 정의하기에는 어려운 부분이 많다
    - 설정 내용이 길어지고 가독성 떨어짐
    - 의존관계와 복잡한 프로젝트 설정하기에 부적절
    - 상속구조를 이용한 멀티 모듈 구현
    - 특정 설정을 소수의 모듈에서 공유하기 위해서는 부모 프로젝트를 생성하여 상속하게 해야함 (상속의 단점 생김)
- Gradle은 groovy를 사용하기 때문에, 동적인 빌드는 Groovy 스크립트로 플러그인을 호출하거나 직접 코드를 짜면 된다.
    -  Configuration Injection 방식을 사용해서 공통 모듈을 상속해서 사용하는 단점을 커버했다.
    - 설정 주입 시 프로젝트의 조건을 체크할 수 있어서 프로제트별로 주입되는 설정을 다르게 할 수 있다.

#### Groovy 실행원리

Groovy 소스는 컴파일하면 자바 크랠스가 만들어진다. 이것을 실행하기 위해서는 groovy.jar와 asm.jar 라이브러릴 파일이 필요하다.

**groovy 문법 요약**

- 동적 타입 바인디

```
def a = 20   // 값을 할당할 때 a 변수의 타입이 결정됨
a = “문자열”   // 다른 값을 할당하면 변수의 타입이 바뀜
b = “문자열”   // 변수 선언 시 def를 생략해도 됨
```

- 정적 타입 바인딩

```
int a = 20  // 변수 a는 int로 데이터형이 고정됨
a = “문자열”  // 문자열 값을 할당하면 오류 발생
```

- 문자열과 자동 형변환

```
String a = “문자열”  //  변수 a는 String으로 데이터 형이 고정됨
a = 20 // 정수 값 20이 문자열 “20”으로 자동 변환된 후 변수 a에 할당됨
```

자바 변순 선언

```
java.util.Date a = new java.util.Date()
Date b = new Date() // 기본으로 java.util 패키지 임포트됨
```

## ref
- https://bkim.tistory.com/13
- https://galid1.tistory.com/194
- https://k39335.tistory.com/75
