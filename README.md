# aws-member-manager

# application.local

개발을 할때 테스팅을 위해 개인적인 설정을 적용하고 싶은 경우가 많습니다.
그런 용도로 .gitignore에 

- application-local.properties
- application-local.yml

추가되어 있습니다.

이 설정을 적용한채 구동 하고 싶다면 이 명령어를 쓰세요

```
gradlew bootRun --args="--spring.config.additional-location=file:.\\application-local.yml"
```

IntelliJ 에서 실행 옵션을 어떻게 바꾸는지는 [여기](https://www.jetbrains.com/help/idea/run-debug-configuration-spring-boot.html#spring-boot)를 참고해 주세요.

아래는 application-local.yml 예시 입니다.

``` yaml
spring:
  profiles:
    active: local

  # DB 관련
  datasource:
    url: jdbc:h2:mem:test
    username: sa
    password:
    driver-class-name: org.h2.Driver

  jpa:
    hibernate:
      ddl-auto: create

    show-sql: true

    properties:
      hibernate:
        format_sql: true

# actuator 관련
management:
  endpoints:
    web:
      exposure:
        include:
          - health
          - info

  endpoint:
    health:
      show-details: always
```

# formatter

포맷팅은 아래 명령어를 통해 할 수 있습니다.

```
gradlew spotlessApply
```

IntelliJ에서는 [Spotless Applier](https://plugins.jetbrains.com/plugin/22455-spotless-applier)는 plugin을 통해 할 수 있습니다.

## git convention

- FEAT:     feature 추가
- FIX:      버그 수정
- REFACTOR: refactoring
- MISC:     기타

