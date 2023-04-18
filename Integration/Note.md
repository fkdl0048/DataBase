# DataBase

## 데이터베이스란..?

데이터베이스는 여러개의 데이터를 효율적으로 관리하기 위한 시스템이다.

하나의 데이터베이스는 여러개의 테이블로 구성되어 있다.

### 데이터베이스의 구조

#### 스키마(Schema)

데이터베이스의 구조와 제약조건에 관한 전반적인 명세를 기술한 것이다.

#### 3-Level Architecture

데이터베이스는 3단계로 구성되어 있다.

- 외부 스키마(External Schema)
- 개념 스키마(Conceptual Schema)
- 내부 스키마(Internal Schema)

데이터베이스 하나를 세 단계로 나누고, 각 단계별로 다른 추상화를 제공하면 데이터베이스를 효율적으로 관리할 수 있다.

내부단계에서 외부단계로 갈수록 추상화 수준이 높아진다.

##### 외부 스키마(External Schema)

사용자가 데이터베이스를 사용하는데 필요한 데이터베이스의 구조와 제약조건을 정의한 것이다.

적절한 사람, 특수한 규율, 제약에 따라 공개하는 것  

개별 사용자 관점에서 데이터베이스를 이해하고 표현

##### 개념 스키마(Conceptual Schema)

데이터베이스의 전체적인 구조를 정의한 것이다.

어떤 타입이 들어가는 지

##### 내부 스키마(Internal Schema)

데이터베이스의 물리적인 구조를 정의한 것이다.

실제 데이터 값

#### 데이터의 독립성  

실제데이터는 물리적 저장 장치에 저장된 DB에만 존재하므로 사용자가 자신의 외부 스키마를 통해 원하는 데이터를 얻으려면 내부 스키마에 따라 저장된 DB에 접근해야 한다.  

스키마 사이의 대응관계를 사상 또는 매핑한다.  

DB를 3단계로 나누고 단계별 스키마를 유지하며 사상을 정의하는 이유는 데이터 독립성을 추구하기 위해서다.  

데이터 독립성은 하위 스키마를 변경하더라도 상위 스키마가 영향을 받지 않는 특성이다.  

외부 단계 `<->` 개념 단계 == 논리적 데이터 독립성

개념 단계 `<->` 내부 단계 == 물리적 데이터 독립성

##### 논리적 데이터 독립성  

개념 스키마가 변경되더라도 외부 스키마가 영향을 받지 않는 것

전체 DB의 논리적 구조가 변경되어도 관련된 업무/개념 사상 정보를 수정하면 사용자를 위한 외부 스키마는 변경되지 않는다.

##### 물리적 데이터 독립성

내부 스키마가 변경되더라도 개념 스키마가 영향을 받지 않는 것

결과적으로 외부 스키마도 영향을 받지 않는다.

물리적 데이터 독립성이 실현되면 DB의 저장 구조가 변경되어도 관련된 개념/내부 사상 정보만 적절히 수정하면 직접적으로 관련없는 DB의 논리적구조는 영향을 받지 않음

### 데이터베이스 언어의 종류

#### DDL (Data Definition Language)

데이터베이스의 구조를 정의하는 언어

#### DML (Data Manipulation Language)

데이터베이스의 데이터를 조작하는 언어

#### DQL (Data Query Language)

데이터베이스의 데이터를 검색하는 언어

#### DCL (Data Control Language)

데이터베이스의 권한을 관리하는 언어

## Relational Model

데이터 모델의 하위 개념

관계형 모델은 데이터베이스의 구조를 표현하는데 사용되는 모델이다.  

### 정의

![image](https://user-images.githubusercontent.com/84510455/232472439-aa6fdaa4-d5e7-4855-ae44-c397f9f20abf.png)

Relation: 테이블이라고 생각하면 되고 해당 사진의 모든 것을 의미

Relation Schema와 Relation Instance로 구성되어 있다.

#### Relation Schema

Relation의 구조를 정의한 것이다.

이러한 각각의 요소를 Attribute라고 한다.

이러한 Attribute의 개수를 Degree라고 한다.

사진은 3개의 Attribute를 가지고 있으므로 Degree는 3이다.

요소를 구성하는 값의 종류를 Domain이라고 한다.

#### Relation Instance

Relation의 구조에 따라 실제로 존재하는 데이터의 집합이다.

각각의 값들을 Tuple이라고 한다.

Tuple의 개수를 Cardinality라고 한다.

사진은 4개의 Tuple을 가지고 있으므로 Cardinality는 4이다.

즉, 튜플의 집합이 Relation Instance이다.

### 특징  

1. Relation안에 있는 tuple은 Unique하다.
2. Relation안에 있는 tuple은 순서가 없다.
3. Relation안에 attribute는 순서가 없다.
4. domain은 atomic하다.

atomic: 더 이상 분해할 수 없는 최소 단위

즉, 해당 attribute의 값이 분리가 가능하다면 그건 Relation이 아니다.

### Key

key는 Relation의 tuple을 유일하게 식별할 수 있는 attribute의 집합이다.

Relation 자체로도 tuple을 유일하게 식별할 수 있지만, attribute의 집합으로도 tuple을 유일하게 식별할 수 있다.

#### super key

key보다 더 큰 개념으로, key를 포함하는 개념이다.

#### candidate key

key의 후보로, key가 될 수 있는 attribute의 집합이다.

minimal한 super key를 candidate key라고 한다.

#### primary key

candidate key 중에서 하나를 선택하여 key로 사용하는 것이다.

#### alternate key

candidate key 중에서 primary key를 제외한 나머지 key를 alternate key라고 한다.

선택되지 못한 키

#### foreign key

다른 Relation의 primary key를 참조하는 attribute의 집합이다.

## Relational Algebra

Relation을 다루는 연산자들의 집합이다.

### 연산자

#### Selection

> 예제

$$ ^\sigma branch\_name = "perryridge"(loan) $$

> 문법

$$ ^\sigma predicate(relation) $$

predicate: 조건

조건에는 attribute, constant, 연산자가 들어갈 수 있다.

\>, =, !=, <= 등등

$$ ^\sigma amount > 1200(loan) $$

![image](https://user-images.githubusercontent.com/84510455/232634505-5ae78dcc-c655-4c33-bc2f-e03e4c9f2401.png)

#### Projection

> 예제

$$ ^\pi branch\_name(loan) $$

> 문법

$$ ^\pi attribute1, attribute2...(relation) $$

해당 하는 애트리뷰트만 출력한다.

**Projection은 중복을 제거한다.**

![image](https://user-images.githubusercontent.com/84510455/232634626-f2174469-7c5b-4ea5-a6fd-b5056e1fdc51.png)

#### Nested

> 예제

$$ ^\pi loan\_number(^\sigma amount > 1200(loan)) $$

이런식으로 반환값이 Relation인 연산자를 중첩해서 사용할 수 있다.

![image](https://user-images.githubusercontent.com/84510455/232634643-6f09cc36-77af-4b27-9fac-29fc7c3f344d.png)

#### Union

> 예제

$$ ^\pi branch\_name(borrower) \cup ^\pi branch\_name(depositor) $$

> 문법

$$ (relation1)\cup(relation2) $$

두 Relation의 합집합을 반환한다.

**degree가 같아야 한다.**

애트리뷰트의 도메인도 같아야 한다.

마찬가지로 중복을 제거한다.

#### Intersection

> 예제

$$ ^\pi branch\_name(borrower) \cap ^\pi branch\_name(depositor) $$

> 문법

$$ (relation1)\cap(relation2) $$

두 Relation의 교집합을 반환한다.

#### Difference

> 예제

$$ ^\pi branch\_name(borrower) - ^\pi branch\_name(depositor) $$

> 문법

$$ (relation1)-(relation2) $$

relation1에서 relation2를 뺀 차집합을 반환한다.

서로 위치가 바뀌면 결과값도 바뀐다.

#### Cartesian Product

> 예제

$$ ^\pi branch\_name(borrower) \times ^\pi branch\_name(depositor) $$

> 문법

$$ (relation1)\times(relation2) $$

두 Relation의 Cartesian Product를 반환한다.

즉, 곱하기..

relation1의 tuple a에 대해서 relation2의 모든 tuple을 곱한다.  

즉, relation1의 tuple의 개수 * relation2의 tuple의 개수 만큼 tuple이 생성된다.

애트리뷰트의 경우는 relation1의 모든 애트리뷰트와 relation2의 모든 애트리뷰트를 합친다.

일치하는 key를 찾기 위해서 사용한다. (기본 데이터베이스 속성)  

#### Rename

> 문법

$$ \rho new\_relation\_name(original\_relation) $$

* 예제 1

relation의 이름을 바꾼다.

이를 사용한 예제로 Relation의 튜플의 애트리뷰트의 최대값을 구하는 예제

$$ \pi _{a1.balance}(\sigma _{a1.balance < a2.balance} (\rho_{a1}(account) \times \rho_{a2}(account)))$$

즉 가장 큰 값을 제외한 나머지 프로젝션을 구하고 해당 Relation을 차집합하여 구한다.

$$ \pi _{balance}(account) - \pi _{a1.balance}(\sigma _{a1.balance < a2.balance} (\rho_{a1}(account) \times \rho_{a2}(account))) $$

* 예제 2

마찬가지로 이름을 변경하고 cartesian product를 하여 원하는 값을 추출해낼 수 있도록 한다.

#### Join

> 문법

$$ (relation1)\bowtie(relation2) $$

두 Relation을 조인한다.

두 Relation의 애트리뷰트의 도메인이 같아야 한다.

*nuatural join*

$$ \pi _{branch\_name(\sigma _{customer_city="Harrison"(customer)} \bowtie depositor \bowtie account)} $$

#### Theta Join

> 문법

$$ (relation1)\bowtie_{\theta}(relation2) = \sigma_{\theta}(relation_1 \times relation_2)$$

#### Division

> 문법

$$ (relation1) \div (relation2) $$

![image](https://user-images.githubusercontent.com/84510455/232633002-147ad888-f030-4d89-ac6d-85a958daeda6.png)

![image](https://user-images.githubusercontent.com/84510455/232635108-b88df32d-97b0-4612-9974-604f5cc7e8ed.png)

#### Generalized Projection

> 문법

$$ \pi_{F1, F2 ... AS name(Relation)}$$

#### Aggregation Function

> 문법

![image](https://user-images.githubusercontent.com/84510455/232636490-68571d67-9680-45f9-accd-453ceae977d7.png)

$$ g_{sum(salary)}(pt\_works) $$

여기서 그룹을 지어서 그룹별로 aggregation function을 적용할 수 있다.

$$_{branch_name}g_{sum(salary)}(pt\_works) $$

![image](https://user-images.githubusercontent.com/84510455/232637199-5fb18db4-f48b-4425-9e3a-cd4634fa39d8.png)

#### Outer Join

매칭이 안되더라도 출력하고 싶을 때 사용한다.

*null*

> 문법

![image](https://user-images.githubusercontent.com/84510455/232638462-4e05bdf2-7ccc-40e8-8f5d-03672864b436.png)

Left인지 Right인지 조건을 잘 보고 사용할 것

Full Outer Join은 은 둘다 조건을 적용

#### Outer Union  

> 문법

$$ r \cup^+ s $$

![image](https://user-images.githubusercontent.com/84510455/232638777-7bf33ae9-44c1-4994-8398-262390a010c4.png)

#### Null Value

![image](https://user-images.githubusercontent.com/84510455/232639418-3efdcb5f-c20d-4dee-9616-db88c4df039c.png)

* SELECT 연산은 똑같이 진행한다.  

$$ \sigma_{p}(r) $$

자체가 Relation의 모든 튜플을 p의 조건으로 검사한다.

null일 경우 제외..

* JOIN 연산은 null값을 삭제한다.

* PROJECT 연산은 중복이 제거 되기 때문에 Null값이 하나만 남는다.

*Null값이 중복이 있다면..*

* AGGREGATION 연산은 null값을 제외하고 진행한다.

#### DML 예제

##### DELETION  

> 문법

$$ r \rightarrow r - E $$

r에서 E를 삭제한다.

> 예제

$$ depositor \rightarrow depositor - \sigma_{customer_name = "Smith"(depositor)} $$

*Smith튜플만 제거한 릴레이션 반환*

$$ loan \rightarrow loan - \sigma_{amount \ge 1000 \land amount \le 1300}(loan) $$

*전체 loan에서 amount가 1000과 1300사이의 값만 찾기*


![image](https://user-images.githubusercontent.com/84510455/232641109-4763b073-7760-4788-bef3-6202c9272b89.png)

"Brooklyn"만 지우는 예제인데 nutural join을 사용하여 Relation을 연결하고 Selection을 사용하여 "Brooklyn"튜플만 조회한다.  

Projection을 사용하여 삭제할 Relation에 맞는 Degree, Domain을 가진 Relation을 만들어 Deletion을 진행한다.

##### INSERTION

> 문법

$$ r \rightarrow r \cup E $$

r에 E를 추가한다.

> 예제

$$ account \rightarrow account \cup \{(A-973, "Perryidge", 1200)\} $$

![image](https://user-images.githubusercontent.com/84510455/232643766-d69e0b75-acb5-4879-92cf-d7e05ba197a1.png)

가장 먼저 Relation을 Join하여 Perryidge만 Selection을 한다. (r1)

projection을 통해 필요한 Degree, Domain을 가진 Relation을 만든다. (r2)

r2에 Cartesian Product을 통해 200을 추가한다.

해당 Relation을 account에 추가한다.

depositor에는 r1을 Projection하여 추가한다.

$$ r1 \rightarrow \sigma _{branch\_name = "Perryidge"}(borrower \Join loan) $$
$$ r2 \rightarrow \pi _{loan_number, branch_name}(r1) $$
$$ account \rightarrow account \cup (r_2 \times {(200)}) $$
$$ depositor \rightarrow depositor \cup \pi _{customer_name, loan_number}(r1) $$

##### UPDATE

Generalized Projection을 사용해서 계산한다.

> 문법

$$ r \rightarrow \pi _{F_1, F_2, ...F_n}(r) $$

> 예제

Relation의 balance를 5% 증가시킨다.

$$ account \rightarrow \pi _{account_number, branch_name, balance * 1.05 as balance}(account) $$

![image](https://user-images.githubusercontent.com/84510455/232645636-c25cf58a-3267-4eb5-839d-ecd4012642ee.png)

## SQL

Structured Query Language

### 데이터베이스 생성

![image](https://user-images.githubusercontent.com/84510455/232649037-5335434e-7ca7-4a15-8ff0-6018f1b04d3a.png)

```sql
CREATE DATABASE [데이터베이스명];
```

#### 데이터베이스 생성(있으면 삭제하고 재생성)

```sql
CREATE OR REPLACE DATABASE [데이터베이스명];
```

#### 데이터베이스 생성(있으면 넘어가기)

```sql
CREATE DATABASE IF NOT EXISTS [데이터베이스명];
```

*SHOW WARNINGS; 으로 예외 조회*

#### Create speciftion

```sql
CREATE DATABASE [데이터베이스명] CHARACTER SET [인코딩] COLLATE [콜레이션];
```

```sql
 CREATE OR REPLACE DATABASE db
    -> CHARACTER SET = 'euckr'
    -> COLLATE = 'euckr_Korean_ci';
```

#### Comment

```sql
CREATE DATABASE [데이터베이스명] COMMENT = '데이터베이스 설명';
```

```sql
MariaDB [(none)]> CREATE OR REPLACE DATABASE db
    -> COMMENT = 'Welcome to database';
```

### 데이터베이스 삭제

```sql
DROP DATABASE [데이터베이스명];
```

### 데이터베이스 목록 조회

```sql
SHOW DATABASES;
```

### 데이터베이스 선택

```sql
USE [데이터베이스명];
```

### 테이블 생성

```sql
CREATE TABLE [테이블명] (
    [컬럼명] [데이터타입] [옵션],
    [컬럼명] [데이터타입] [옵션],
    ...
);
```

### 테이블 삭제

```sql
DROP TABLE [테이블명];
```

### 테이블 목록 조회

```sql
SHOW TABLES;
```

### 테이블 구조 조회

```sql
DESC [테이블명];
```

### 테이블 데이터 조회

```sql
SELECT * FROM [테이블명];
```

