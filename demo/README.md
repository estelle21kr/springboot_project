# 🌐 Spring Board - 커뮤니티 게시판 프로젝트

> Spring Boot 3.4와 MyBatis를 활용한 **풀스택 커뮤니티 게시판** 웹 애플리케이션

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.12-green?style=flat-square&logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=flat-square&logo=mysql)
![License](https://img.shields.io/badge/License-MIT-blueviolet?style=flat-square)

---

## 📋 목차

- [프로젝트 개요](#-프로젝트-개요)
- [주요 기능](#-주요-기능)
- [기술 스택](#-기술-스택)
- [프로젝트 구조](#-프로젝트-구조)
- [설치 및 실행](#-설치-및-실행)
- [데이터베이스 설정](#-데이터베이스-설정)
- [API 엔드포인트](#-api-엔드포인트)
- [화면 구성](#-화면-구성)
- [코드 구조](#-코드-구조)
- [보안 기능](#-보안-기능)
- [향후 계획](#-향후-계획)
- [기여 가이드](#-기여-가이드)
- [라이선스](#-라이선스)

---

## 🎯 프로젝트 개요

**Spring Board**는 Spring Boot 기반의 **모던한 커뮤니티 게시판** 플랫폼입니다. 사용자 인증, 게시글 관리, 댓글, 파일 업로드 등 커뮤니티 운영에 필요한 **핵심 기능**을 모두 포함하고 있습니다.

### 목표
- ✅ Spring Boot 실무 경험 습득
- ✅ Spring Security를 통한 안전한 인증 시스템 구축
- ✅ MyBatis 기반 효율적인 데이터 접근 계층 설계
- ✅ Thymeleaf를 활용한 동적 웹페이지 구현
- ✅ RESTful API 설계 원칙 준수

---

## ✨ 주요 기능

### 🔐 사용자 관리
- 회원가입 / 로그인 / 로그아웃
- Spring Security 기반 인증 및 권한 관리 (USER, ADMIN)
- 비밀번호 암호화 저장
- 사용자 정보 수정 및 삭제

### 📝 게시판 기능
- 게시글 **CRUD** (생성, 읽기, 수정, 삭제)
- 게시글 목록 조회 (페이징 처리)
- 검색 기능 (제목, 작성자별 검색)
- 조회수 자동 증가
- 게시글 상세 조회

### 💬 댓글 시스템
- 게시글별 댓글 작성/삭제
- 댓글 개수 실시간 집계
- 타임스탬프 표시

### 📁 파일 관리
- 게시글에 이미지/문서 첨부
- 파일 UUID 기반 관리
- 파일 개수 자동 집계
- 파일 다운로드 지원

### 📊 페이징 시스템
- 대량의 게시글 효율적 관리
- 한 페이지당 10개 게시글 표시
- 동적 페이지 네비게이션
- 총 페이지 개수 자동 계산

---

## 🛠 기술 스택

### Backend
| 기술 | 버전 | 설명 |
|------|------|------|
| **Java** | 17 | 프로그래밍 언어 |
| **Spring Boot** | 3.4.12 | 백엔드 프레임워크 |
| **Spring Security** | 6.x | 인증/권한 관리 |
| **MyBatis** | 3.0.5 | ORM 프레임워크 |
| **Lombok** | - | 보일러플레이트 코드 제거 |
| **MySQL** | 8.0+ | 관계형 데이터베이스 |

### Frontend
| 기술 | 설명 |
|------|------|
| **Thymeleaf** | 서버사이드 템플릿 엔진 |
| **Thymeleaf Layout Dialect** | 레이아웃 재사용 |
| **Bootstrap 5** | CSS 프레임워크 |
| **JavaScript (Vanilla)** | 클라이언트 로직 |
| **HTML5 / CSS3** | 마크업 및 스타일 |

### Build & Deployment
| 기술 | 설명 |
|------|------|
| **Gradle** | 빌드 자동화 도구 |
| **Gradle Wrapper** | 버전 관리 |

---

## 📁 프로젝트 구조

```
spring-board/
├── src/main/
│   ├── java/com/example/demo/
│   │   ├── config/
│   │   │   ├── DatabaseConfig.java        # MyBatis 설정
│   │   │   └── SecurityConfig.java        # Spring Security 설정
│   │   ├── controller/
│   │   │   ├── BoardController.java       # 게시판 요청 처리
│   │   │   └── UserController.java        # 사용자 요청 처리
│   │   ├── domain/
│   │   │   ├── BoardVO.java              # 게시글 VO
│   │   │   ├── UserVO.java               # 사용자 VO
│   │   │   ├── AuthVO.java               # 권한 VO
│   │   │   └── PagingVO.java             # 페이징 VO
│   │   ├── handler/
│   │   │   └── PagingHandler.java        # 페이징 로직
│   │   ├── repository/
│   │   │   ├── BoardDAO.java             # 게시판 DB 접근
│   │   │   └── UserDAO.java              # 사용자 DB 접근
│   │   ├── service/
│   │   │   ├── BoardService.java         # 게시판 인터페이스
│   │   │   ├── BoardServiceImpl.java      # 게시판 구현
│   │   │   ├── UserService.java          # 사용자 인터페이스
│   │   │   └── UserServiceImpl.java       # 사용자 구현
│   │   ├── security/
│   │   │   ├── AuthUser.java             # 인증 사용자 객체
│   │   │   └── CustomUserService.java    # 사용자 상세 서비스
│   │   └── DemoApplication.java          # 애플리케이션 진입점
│   └── resources/
│       ├── mappers/
│       │   ├── boardMapper.xml           # 게시판 SQL
│       │   └── userMapper.xml            # 사용자 SQL
│       ├── static/
│       │   ├── images/                   # 이미지 리소스
│       │   └── js/
│       │       └── boardModify.js        # JavaScript
│       ├── templates/
│       │   ├── board/
│       │   │   ├── list.html             # 게시글 목록
│       │   │   ├── detail.html           # 게시글 상세
│       │   │   └── register.html         # 게시글 등록
│       │   ├── user/
│       │   │   ├── login.html            # 로그인
│       │   │   ├── signup.html           # 회원가입
│       │   │   ├── modify.html           # 회원 수정
│       │   │   └── list.html             # 사용자 목록
│       │   ├── fragments/
│       │   │   ├── header.html           # 헤더 (Fragment)
│       │   │   └── footer.html           # 푸터 (Fragment)
│       │   ├── layout/
│       │   │   └── layout.html           # 기본 레이아웃
│       │   └── index.html                # 홈페이지
│       ├── application.properties        # 애플리케이션 설정
│       └── sql.txt                       # DB 초기화 스크립트
└── build.gradle                          # Gradle 빌드 설정
```

---

## ⚙️ 설치 및 실행

### 사전 요구사항
- **Java 17** 이상
- **MySQL 8.0** 이상
- **Git**

### 1️⃣ 저장소 클론
```bash
git clone https://github.com/yourusername/spring-board.git
cd spring-board
```

### 2️⃣ MySQL 데이터베이스 설정
```bash
# MySQL 접속
mysql -u root -p

# 데이터베이스 및 사용자 생성
CREATE DATABASE springdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'springuser'@'localhost' IDENTIFIED BY 'mysql';
GRANT ALL PRIVILEGES ON springdb.* TO 'springuser'@'localhost';
FLUSH PRIVILEGES;

# 테이블 생성 (src/main/resources/sql.txt 참고)
USE springdb;
-- sql.txt 내용을 복사하여 실행
```

### 3️⃣ 애플리케이션 설정
`src/main/resources/application.properties` 확인:
```properties
spring.datasource.username=springuser
spring.datasource.password=mysql
spring.datasource.jdbc-url=jdbc:mysql://localhost:3306/springdb
```

### 4️⃣ 빌드 및 실행
```bash
# Gradle을 사용한 빌드
./gradlew build

# 애플리케이션 실행
./gradlew bootRun

# 또는 JAR 파일로 실행
java -jar build/libs/demo-0.0.1-SNAPSHOT.jar
```

### 5️⃣ 브라우저 접속
```
http://localhost:8088
```

---

## 🗄️ 데이터베이스 설정

### 주요 테이블 구조

**board 테이블** (게시글)
```sql
CREATE TABLE board (
  bno BIGINT NOT NULL AUTO_INCREMENT,
  title VARCHAR(200) NOT NULL,
  writer VARCHAR(200) NOT NULL,
  content TEXT,
  is_del VARCHAR(5) DEFAULT 'N',
  reg_date DATETIME DEFAULT NOW(),
  read_count INT DEFAULT 0,
  cmt_qty INT DEFAULT 0,
  file_qty INT DEFAULT 0,
  PRIMARY KEY(bno)
);
```

**user 테이블** (사용자)
```sql
CREATE TABLE user (
  email VARCHAR(256) PRIMARY KEY,
  pwd VARCHAR(256) NOT NULL,
  nick_name VARCHAR(200),
  reg_date DATETIME DEFAULT NOW(),
  last_login DATETIME DEFAULT NOW()
);
```

**auth 테이블** (권한)
```sql
CREATE TABLE auth (
  id BIGINT AUTO_INCREMENT,
  email VARCHAR(256) NOT NULL,
  auth VARCHAR(256) NOT NULL,  -- ROLE_USER, ROLE_ADMIN
  PRIMARY KEY(id)
);
```

**comment 테이블** (댓글)
```sql
CREATE TABLE comment (
  cno BIGINT AUTO_INCREMENT,
  bno BIGINT NOT NULL,
  writer VARCHAR(200) NOT NULL,
  content TEXT,
  reg_date DATETIME DEFAULT NOW(),
  PRIMARY KEY(cno)
);
```

**file 테이블** (파일)
```sql
CREATE TABLE file (
  uuid VARCHAR(256) PRIMARY KEY,
  save_dir VARCHAR(256) NOT NULL,
  file_name VARCHAR(256) NOT NULL,
  file_type TINYINT(1) DEFAULT 0,
  bno BIGINT NOT NULL,
  file_size BIGINT,
  reg_date DATETIME DEFAULT NOW()
);
```

---

## 🔌 API 엔드포인트

### 🏠 홈페이지
| Method | Endpoint | 설명 |
|--------|----------|------|
| GET | `/` | 홈페이지 |

### 📝 게시판 API
| Method | Endpoint | 설명 |
|--------|----------|------|
| GET | `/board/list` | 게시글 목록 (페이징) |
| GET | `/board/detail?bno={id}` | 게시글 상세 조회 |
| GET | `/board/register` | 게시글 등록 폼 |
| POST | `/board/register` | 게시글 등록 처리 |
| POST | `/board/modify` | 게시글 수정 |
| GET | `/board/remove?bno={id}` | 게시글 삭제 |

### 👤 사용자 API
| Method | Endpoint | 설명 |
|--------|----------|------|
| GET | `/user/login` | 로그인 페이지 |
| POST | `/user/login` | 로그인 처리 (Spring Security) |
| GET | `/user/signup` | 회원가입 페이지 |
| POST | `/user/signup` | 회원가입 처리 |
| GET | `/user/list` | 사용자 목록 (ADMIN) |
| POST | `/user/modify` | 사용자 정보 수정 |
| GET | `/user/remove` | 사용자 삭제 |
| GET | `/logout` | 로그아웃 |

---

## 🖼️ 화면 구성

### 홈페이지
- 프로젝트 소개
- 주요 기능 카드
- 사용자별 상태 표시 (로그인/비로그인)
- 통계 정보 (게시글, 사용자 수)

### 게시판 목록
- 게시글 목록 (페이징)
- 검색 기능
- 게시글 클릭 시 상세 페이지 이동
- 글 작성 버튼 (로그인 필수)

### 게시글 상세
- 게시글 내용 및 댓글
- 파일 목록 및 다운로드
- 수정/삭제 버튼 (작성자 또는 ADMIN만 가능)
- 댓글 작성 (로그인 필수)

### 로그인/회원가입
- 이메일 기반 회원가입
- 비밀번호 확인
- 로그인 폼 (Spring Security)

---

## 🏗️ 코드 구조

### 아키텍처 다이어그램

```
┌─────────────┐
│   Browser   │  (HTTP 요청/응답)
└──────┬──────┘
       │
┌──────▼──────────────────┐
│   Thymeleaf Template    │  (HTML 렌더링)
│   (View Layer)          │
└──────┬──────────────────┘
       │
┌──────▼──────────────────┐
│   @Controller           │  (요청 라우팅)
│   BoardController       │
│   UserController        │
└──────┬──────────────────┘
       │
┌──────▼──────────────────┐
│   Service Interface     │  (비즈니스 로직)
│   BoardService          │
│   UserService           │
└──────┬──────────────────┘
       │
┌──────▼──────────────────┐
│   ServiceImpl            │  (구현체)
│   BoardServiceImpl       │
│   UserServiceImpl        │
└──────┬──────────────────┘
       │
┌──────▼──────────────────┐
│   @Repository DAO       │  (DB 접근)
│   BoardDAO              │
│   UserDAO               │
└──────┬──────────────────┘
       │
┌──────▼──────────────────┐
│   MyBatis Mapper XML    │  (SQL 매핑)
│   boardMapper.xml       │
│   userMapper.xml        │
└──────┬──────────────────┘
       │
┌──────▼──────────────────┐
│   MySQL Database        │  (데이터 저장)
│   springdb              │
└─────────────────────────┘
```

### 계층별 역할

| 계층 | 클래스 | 책임 |
|------|--------|------|
| **Controller** | BoardController, UserController | 요청 수신 및 라우팅 |
| **Service** | BoardServiceImpl, UserServiceImpl | 비즈니스 로직 처리 |
| **Repository** | BoardDAO, UserDAO | 데이터베이스 접근 |
| **Domain** | BoardVO, UserVO | 데이터 모델 |
| **Security** | CustomUserService, AuthUser | 사용자 인증/권한 |
| **View** | Thymeleaf Templates | 사용자 인터페이스 |

---

## 🔒 보안 기능

### Spring Security 적용
- ✅ **로그인 인증**: 이메일 + 비밀번호 기반
- ✅ **역할 기반 접근 제어 (RBAC)**: ROLE_USER, ROLE_ADMIN
- ✅ **CSRF 보호**: Form 기반 POST 요청 보호
- ✅ **권한 관리**: 관리자 전용 기능 제어

### 비밀번호 보안
```java
// BCryptPasswordEncoder를 통한 암호화
passwordEncoder.encode(plainPassword) → hashedPassword
```

### 세션 관리
- HttpSession 기반 세션 관리
- 로그인 후 세션에 인증 정보 저장
- 로그아웃 시 세션 무효화

### URL 접근 제어
```java
// SecurityConfig에서 경로별 권한 설정
.authorizeHttpRequests(authorize -> authorize
    .requestMatchers("/user/admin/**").hasRole("ADMIN")
    .requestMatchers("/board/**").authenticated()
    .requestMatchers("/", "/user/login", "/user/signup").permitAll()
)
```

---

## 🚀 향후 계획 (Roadmap)

### Phase 1: 기본 기능 완성 ✅
- [x] 게시판 CRUD
- [x] 사용자 인증/인가
- [x] 댓글 시스템
- [x] 파일 업로드

### Phase 2: 고급 기능 (진행 중)
- [ ] 검색 및 필터링 강화
- [ ] 좋아요 기능
- [ ] 북마크 시스템
- [ ] 사용자 프로필 이미지

### Phase 3: 성능 최적화
- [ ] 데이터베이스 인덱싱
- [ ] 캐싱 (Redis)
- [ ] API 응답 최적화
- [ ] N+1 쿼리 해결

### Phase 4: 고급 기능
- [ ] REST API 제공 (@RestController)
- [ ] WebSocket 실시간 알림
- [ ] ElasticSearch 통합
- [ ] Docker 컨테이너화

### Phase 5: DevOps
- [ ] CI/CD 파이프라인 (GitHub Actions)
- [ ] 자동화 테스트 (JUnit 5, Mockito)
- [ ] API 문서화 (Swagger/SpringDoc)
- [ ] 배포 자동화

---

## 🤝 기여 가이드

프로젝트에 기여해주실 분들을 환영합니다! 다음 단계를 따라주세요:

### 1. Fork & Clone
```bash
git clone https://github.com/yourusername/spring-board.git
cd spring-board
```

### 2. 브랜치 생성
```bash
git checkout -b feature/your-feature-name
```

### 3. 코드 작성 및 커밋
```bash
git add .
git commit -m "feat: 새로운 기능 설명"
```

### 4. Push & Pull Request
```bash
git push origin feature/your-feature-name
```

### 코드 스타일 가이드
- **Java**: Google Java Style Guide 준수
- **변수명**: camelCase (예: `userName`, `boardTitle`)
- **상수명**: UPPER_SNAKE_CASE
- **클래스명**: PascalCase
- **메서드명**: camelCase (동사로 시작)

### 커밋 메시지 규칙
```
feat: 새로운 기능 추가
fix: 버그 수정
docs: 문서 수정
style: 코드 포맷팅
refactor: 코드 리팩토링
test: 테스트 추가
chore: 빌드 또는 의존성 변경
```

---

## 📝 라이선스

이 프로젝트는 **MIT 라이선스** 하에서 배포됩니다. 자유롭게 사용, 수정, 배포할 수 있습니다.

### 라이선스 전문
```
MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
```

---

## 📚 참고 자료

- [Spring Boot 공식 문서](https://spring.io/projects/spring-boot)
- [Spring Security 가이드](https://spring.io/projects/spring-security)
- [MyBatis 공식 문서](https://mybatis.org/)
- [Thymeleaf 가이드](https://www.thymeleaf.org/)
- [MySQL 문서](https://dev.mysql.com/doc/)

---

## 💬 문의 및 피드백

문제가 발생했거나 기능 요청이 있으신가요?

- **이슈 등록**: [Issues 페이지](https://github.com/yourusername/spring-board/issues)
- **이메일**: your-email@example.com

---

## 👨‍💻 개발자

**Spring Board** 프로젝트는 Spring Boot 학습 목적으로 개발되었습니다.

---

## 🙏 감사의 말

이 프로젝트를 참고로 한 모든 오픈소스 라이브러리와 커뮤니티에 감사합니다.

---

<div align="center">

**만들어진 날짜**: 2025년 12월  
**마지막 업데이트**: 2025년 12월 19일

⭐ 이 프로젝트가 도움이 되었다면 별(⭐)을 눌러주세요!

</div>