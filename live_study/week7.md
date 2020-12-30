## 학습할 것 (필수)
- package 키워드
- import 키워드
- 클래스패스
- CLASSPATH 환경변수
- -classpath 옵션
- 접근지시자

## package 키워드

### 패키지(package)린?

자바에서 패키지(package)란 클래스와 인터페이스의 집합을 의미한다
이렇게 서로 관련이 있는 클래스나 인터페이스를 함께 묶음으로써 파일을 효율적으로 관리할 수 있게 된다. 또한, 협업 시 서로 작업한 클래스 사이에서 발생할 수 있는 이름 충돌 문제까지도 패키지를 이용하면 피할 수 있다.

자바에서 패키지(package)는 물리적으로 하나의 디렉터리를 의미한다.
따라서 하나의 패키지에 속한 클래스나 인터페이스 파일은 모두 해당 패키지 이름의 디렉터리에 포함되어 있다.

이러한 패키지는 다른 패키지를 포함할 수 있으며, 이때 디렉터리의 계층 구조는 점(.)으로 구분된다.

```
자바에서 패키지는 중첩되지 않는다. 예를 들어 java.util과 java.util.regex 패키지는 서로 관련이 없다. 각각에는 독립된 클래스 묶음이 들어 있다.
```

## 패키지 사용

자바 소스 파일에서 이 파일의 클래스나 클래스들이 속하는 패키지는 `package`라는 키워드와 함께 지정된다. 이 키워드는 일반적으로 소스 파일에서 처음 오는 키워드이다. 하나의 패키지 선언을 소스 파일에 선언할때엔느 다음과 같이 할 수 있다.

자바 소스 파일 안의 패키지 클래스들을 사용하려면 `import` 선언과 함께 패키지로부터 클래스들을 가져오는 것이 편리하다.

```java
package java.awt.event;
```

`java.awt.event`로 부터 모든 클래스를 가져온다.

```java
package java.awt.event.*;
```


### ref
- http://www.tcpschool.com/java/java_usingClass_package
- https://ko.wikipedia.org/wiki/%EC%9E%90%EB%B0%94_%ED%8C%A8%ED%82%A4%EC%A7%80
- https://thebook.io/006985/ch02/05/01/


## import 키워드

소스코드를 작성할 때 다른 패키지의 클래스를 사용할때는 패키지명이 포함된 이름을 사용하여야한다. 하지만, 매번 패키지명을 붙여서 작성하기란 여간 불편한일이 아닐것이다. 클래스의 코드를 작성하기 전에 import 문으로 사용하고자 하는 클래스의 패키지를 미리 명시해주면 소스코드에 사용되는 클래스 이름에서 패키지명은 생략할 수 있다.

import 문의 역할은 컴파일러에게 소스파일에 사용된 클래스의 패키지에 대한 정보를 제공하는 것이다. 컴파일시에 컴파일러는 import문을 통해 소스파일에 사용된 클래스들의 패키지를 알아낸다음, 모든 클래스이름 앞에 패키지명을 붙여준다.

### import문 선언 방법

```java
import packagename.classname;
```
or
```java
import packagename.*;
```

import문을 여러 번 사용하는 대신 '패키지명.*'을 이용해서 지정된 패키지에 속하는 모든 클래스를 패키지명 없이 사용할 수 있다.

### import 사용

위의 패키지 package java.awt.event에서 `ActionEvent` 클래스만 가져온다.

```java
import java.awt.event.ActionEvent;
```

추가적으로 해당 import 선언뒤에 단순한 클래스 이름을 사용하여 `ActionEvent`클래스를 참조할 수 있다.

```java
import java.awt.event.ActionEvent;

ActionEvent myEvent = new ActionEvent();
```

클래스들은 import 선언 없이 직접사용할 수 있다.

```java
java.awt.event.ActionEvent myEvent = new java.awt.event.ActionEvent();
```

java.lang 패키지는 import 문을 사용하지않고도 사용 가능하다.

### ref
- https://ko.wikipedia.org/wiki/%EC%9E%90%EB%B0%94_%ED%8C%A8%ED%82%A4%EC%A7%80
- https://choiwonwoo.tistory.com/entry/Java-%EA%B8%B0%EC%B4%88-Package-vs-Import%EB%9E%80


### 클래스 패스(Class Path)와 환경변수

클래스패스란 말 그대로 클래스를 찾기 위한 경로이다.
 
`자바 VM이 클래스 파일을 찾는 경로`
자바에서 클래스패스의 의미도 똑같다. JVM이 프로그램을 실행할 때, 클래스파일을 찾는데 기준이 되는 파일 경로를 말하는 것이다. 소스코드(.Java로 끝나는 파일)를 컴파일하면 소스코드가 `바이트 코드` (바이너리 형태의 .class 파일) 로 변환된다. java runtime(java 또는 jre)으로 이 .class 파일을 찾으면 첫 번째로 찾은 파일을 사용한다.

classpath를 지정할 수 있는 두가지 방법이 있다. 하나는 환경 변수 CLASSPATH를 사용하는 방법이고, 하나는 java runtime에 -classpath 플래그를 사용하는 방법이다. 

class가 무엇이고 해당 class를 java가 어떻게 참조하는지에 대한 기본적인 설명은 생활코딩 강의에서 좀 더 자세히 확인할 수 있었다.

https://opentutorials.org/course/1223/5527

나는 해당 강의를 보면서 java는 굳이 javac라는 빌드 과정을 내부적으로 같고있지 않는가? 라는 의문점을 같게 되었고 해당 대답은 아래에서 찾을 수 있었다.

https://blog.wanzargen.me/10

이유는 다음과 같다.

```
VM(자바 실행 프로그램)이 이렇게 얻어진 byte code (.class 파일)을 실행할 때에는 컴파일 과정에서 진행한 일들을 진행하지 않고 말 그대로 실행만 한다.

때문에 소스코드보다 이해가 쉽기 때문에 속도가 더 빠를 뿐만 아니라, 매번 소스코드 문법을 검사하는 등 불필요한 작업을 생략할 수 있어서 효율적이다.
```

### 환경변수란 무언인가?

`환경변수는 운영체제가 참조하는 변수이다.`

운영체제 안의 기본적인 명령어는 컴퓨터가 이해할 수있지만 새로 추가되는 프로그램 또는 자바 플랫폼은 컴퓨터가 어떤식으로 실행해야 할까??

자바 개발로 나온 .java파일을 .class로 컴파일 하기 위해서 자바 컴파일러인 javac.exe를 실행하고 싶은 경우를 생각하면 된다.

초기에 환경변수를 세팅하지 않으면 다음과 같은 에러가 출력될것이다.

**'javac'는 내부 또는 외부 명령, 실행할수있는 프로그램이 아닙니다.**

javac라는 명령어를 운영체제가 찾을 수 없기때문인데, 이 때 운영체제가 찾을 수 있게 설정해주는 것이 환경변수이다.

운영체제는 다음과 같은 행동을 통하여 위치를 잡게된다.

1. javac 입력 후 엔터를 누른다.
2. 운영체제는 javac라는 내부 명령어가 있는지 검사한다.
3. 없는 경우 Path 환경변수를 검색한다.
4. Path에 설정된 경로들(; 세미콜론으로 구분)을 모두 검사한다.
5. javac.exe를 발견하면 실행한다.

좀 더 자세한 내용은 아래에서 확인 가능하다.
https://dololak.tistory.com/20

### classpath에 사용할 수 있는 값

classpath는 콜론(:)으로 구분된 디렉토리 및 파일 목록이다.
아래의 세가지 유형의 파일과 디렉토리를 classpath에 지정할 수 있다.

- /export/home/username/java/classes와 같은 디렉토리
- myclasses.zip과 같은 zip 파일
- myclases.jar와 같은 jar(자바 아카이브) 파일

예를 들어 세가지 유형을 모두 사용하면 다음과 같이 지정할 수 있다.

```
/export/home/username/java/classes:/export/home/username/java/classes/util.zip:/export/home/username/java/classes/checkers.jar
```

### 클래스 path를 어떻게 사용하는가?

이에 관련해서는 코딩하는 오징어님이 설명을 잘해주셨다.
https://effectivesquid.tistory.com/entry/%EC%9E%90%EB%B0%94-%ED%81%B4%EB%9E%98%EC%8A%A4%ED%8C%A8%EC%8A%A4classpath%EB%9E%80

다음과 같이 classpath를 지정할 수 있다. 즉, 환경 변수에 등록하는 방법이다.

```
export CLASSPATH = ${PATH}
```

해당 클래스 패스에 좀더 추가를 하기 위해서는 :로 묶어준다.

```
export CLASSPATH=${PATH}:/export/home/username:/export/home/username
```

### -classpath 옵션

위에서 -classpath 플래그 를 사용하는 방법도 있다고 했는데 어떻게 사용할까?

아래 자세한 내용이 나타나 있다.
https://howtodoinjava.com/java-examples/set-classpath-command-line/

`-classpath` or `-cp`를 사용하여 command line에서 지정 가능하다.

예를 봐보자
```/bin/bash
$ java -cp .;c:/jars demo-application.jar
```

위와 같이 jar가 있는 위치를 classpath로 지정하여 java 프로그램을 실행시킬 수 있다.

### 클래스패스 초기화?

클래스 패스 초기화는 아래의 명령어로 할 수 있다.

```/bin/bash
$ set CLASSPATH=
```

### ref
- https://effectivesquid.tistory.com/entry/%EC%9E%90%EB%B0%94-%ED%81%B4%EB%9E%98%EC%8A%A4%ED%8C%A8%EC%8A%A4classpath%EB%9E%80
- https://goateedev.tistory.com/169
- https://opentutorials.org/course/1223/5527


## Java 접근지시자

접근 지시자는 클래스 내에서 멤버의 접근을 제한하는 역할을 한다.

그렇다면 접근지시자는 왜 필요할까 ?? 나는 접근지시자가 필요한 이유는 자바의 캡슐화(Encapsulation)의 필요성으로 보고있다. 캡슐화의 목적은 정보(자원)을 외부로부터 보호하기 위하여 만들어진 개념인데, 각 접근 제어 지시자가 클래스, 인스턴스 변수, 인스턴스 메소드 앞에 존재함으로써 접근을 제어하여 데이터를 보호할 수 있기 때문이다. 

접근 지시자는 아래와 같이 존재한다.

- public : 모든 접근을 허용, 어떤한 클래스가 접근을 하든 모두 허용
- protected : 상속받은 클래스 또는 같은 패키지에서만 접근 가능
- default : 기본 제한자로써 아무것도 붙지 않고, 자신 클래스 내부와 같은 패키지내에서만 접근이 가능
- private : 외부에서 접근이 불가능하며 같은 클래스 내에서만 접근이 가능

접근 영영은 아래와 같다.

**public > protected > default > private**

좀 더 편하게 설명하기 위해서 표로 나타내보겠다.

|한정자|클래스 내부|동일 패키지|하위 클래스 |그 외의 영역 |
|------|---|---|---|---|
|public|O|O|O|O|
|protected|O|O|O|X|
|default|O|O|X|X|
|private|O|X|X|X|

자 이제 좀 더 자세히 알아보도록 하자

### Public 지시자

public 지시자로 정의가 되어있다면 이는 위치에 상관 없이 어디서든 해당 클래스의 인스턴스를 생성할 수 있다는 뜻이다.

```java
public class A {
    ~ code
}
```

즉, public 지시 자를 이용해 클래스를 정의하면 같은 패키지가 아니더라도 어디서든 인스턴스 생성이 가능하다

예시를 보자.

```java
package package1;

public class A {
    public void Hello() {
        System.out.println("Hello");
    }
}
```

위의 A 클래스에 대한 인스턴스를 생성이 가능하다.

```java
package package2;

public class B {
    public void Hello(package1.A a) {
        A.Hello(); // 호출 가능
    }
}
```


### default 지시자

public 없이 클래스를 정의하면 자동을 default 지시자가 적용이 된다.

이렇게되면 같은 패키지내에서만 인스턴스 생성이 가능하다.

아래의 예시를 보자

```java
package package1;

public class A {
    public void Hello() {
        System.out.println("Hello");
    }
    void Bye() {
        System.out.println("Bye");
    }
}
```

위의 A 클래스에 대한 인스턴스를 생성이 가능하다.

```java
package package2;

public class B {
    public void Hello(package1.A a) {
        A.Hello(); // 호출 가능
        A.Bye(); // 호출이 불가능하다.
    }
}
```

위와 같이 패키지가 다르면 default 지시자의 경우 다른 패키지에서 접근이 불가능하다는 점이 있다.





### ref 
- https://luyin.tistory.com/232
- https://blog.hexabrain.net/119
- https://yms2047.tistory.com/entry/%EC%BA%A1%EC%8A%90%ED%99%94%EB%9E%80
- https://travelbeeee.tistory.com/438