# aws-member-manager

aws연습을 위한 아~~~주 간단한 member 관리 서비스

# 개발환경
- IDE: IntelliJ IDEA

# 기술 스택
- Language: Java 17

# 빌드

빌드를 위해서는 JDK 17이 필요합니다.

이 명령어를 입력해 주세요
```
gradlew build
```

리눅스에서는 이렇게 해야 합니다.
```
./gradlew build
```

# 과제 증명 자료

### aws budget
![aws budget](readme/aws-budget.png)

### ec2 IP
혹시 안된다면 말씀드려주세요

13.125.10.173:8080

### Actuator Info 엔드포인트 URL

http://13.125.10.173:8080/actuator/info

```
{
  "team-name": "6조",
  "profiles": "prod",
  "build": {
    "artifact": "aws-member-manager",
    "name": "aws-member-manager",
    "time": "2026-02-02T23:47:21.480Z",
    "version": "0.0.2",
    "group": "com"
  }
}
```

### RDS 보안 그룹 스크린샷
![rds-security-group](readme/rds-security-group.png)

### Profile URL

http://13.125.10.173:8080/api/members/1/profile-image

로 요청했을때 받은 [profile 사진 URL](https://imprity-aws-member-manager-bucket-prod-profile.s3.ap-northeast-2.amazonaws.com/profiles/6871a980-19a4-4348-80d8-5d70cfb2a30f_derpy.jpg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjECgaDmFwLW5vcnRoZWFzdC0yIkgwRgIhANejt90Tr0e3YmzzFK1c1e0EbXkqgapOxAy9GRYOLUTLAiEA9Q8t2Ju5KkSuklIrtJtEXysLw8SKBBVwD%2FshlwGQ2tkq0wUI8f%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FARAAGgw2NDg2NzEyMjQwNjEiDINxoMOZ2v4O6%2F4tNyqnBdTyMUh%2FYqWCc5d6EvNuB%2B4E8utKCsdYKwR7Ju9gpGCqlBEpAth6tAxRlz5%2Bl7NQZQDZMDXVB4O5HmwtwO4ywCmSGjoyKxnJuB4tv5fEw4Ro6HJKcj5aZxz8OtzA7yNX%2FsRnfr7o2tmZCuVsHVI78WvCIE%2FHjz38ts4DpYok3u81SvVY3jlvcpHSUnzeUw2Tw%2FX%2F1gT%2BxMz%2Brc9npLJ91%2By9oFubyfZ7vcv91i%2B5rzyf3IwjU1NKVpfPCTrmFY6XUvSP5y2ZAohPtlMQ5g7%2B9PlXHbRAGjX2txuNyTfX1tFUh9bXdXSmXdLQU0Qg%2BXIcxOAFx8h7H5cW6KQBJ9jRD2%2BKC6EfIdn%2FrXmKGqd7T%2FJgffWmCeE12nUcSUy%2Fo%2BPCgOJ90PBQ38Av2o9Yh0o086hZl6tfYp3b9BMLbm5VZ1fhny8eOZD3%2BR7fIPCLA%2BgMwn6sdzS4Wb9ur0xWAgWRJ61HvnQ1bytEWHIctujop%2FArA7VuOKG1a7oR2xj4Wf93MxU%2BdpAmKOJuPO9OQaDQY3Ip%2BTGi1djybBMIeNQrCiZPj3SDT%2FKoptcmpHXy6aUkcCDFB14hjeOFr65%2FiN5w2ikPWKNXlY00b%2FeBsh69aua%2FjHpOg5hEHboHWrU4mnhshGVT0mtZbNYGLxflUT2HUx7cO8s4lSzVqAti8GhWpTKgt3rStGOa9sIwj%2FvwD271Pl0Y9ROAQ6tzodAG8jHxSWCU8pIZziywSV5HQ9iJpS0t%2FYTcnj%2FBLk5CZkyL20dhBAotpDXYQ5X4M3npL9YVYT7cvISeqTFpiJdRhqo1V7O9RwXfRXC4Von673iQ1Hm%2FGMdu34EuOQ1QnOnBPgkIkXtF%2FNtmblVxK2f0%2BLyXHDWbH7E1Me9%2BWmyHDbAE6p%2FrRhtAc8xucjcw%2BeqEzAY6sAF6UnE34xTnOLHlsvcHevypkfQu1OdRCn3s%2FtdRVcBkc6RH%2FIy5oYvdL8XWv0B3DWAzn2idPpv1s0wMNhlHJ%2BwBz8i9A1PFefXvziqOV%2FhJ6pa4BteZPGMwH0mlIfmehu%2Fdz15tx%2BCJ0MAOz1Vde0X0qPiFwlFVWLJjt6HC47pKcLjmRCnetEcE9i0Fgmdr%2F80Z3yrLpXt%2BPAHRFxNjCuWot7%2FqWrp%2BA71Y5OZ0i8V7LA%3D%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20260202T235023Z&X-Amz-SignedHeaders=host&X-Amz-Credential=ASIAZOB6RMD6VHZEYJO2%2F20260202%2Fap-northeast-2%2Fs3%2Faws4_request&X-Amz-Expires=604800&X-Amz-Signature=1a573ae6d519d42cbd4d9a2f7c55c6cca85405e2ad861a5e51de1b95c601fb91)

만료 기한은 2026 2월 9일 월요일 23:50:23 GMT+0900 (대한민국 표준시) 입니다.


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

