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

## SQL - DDL

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

데이터베이스를 생성할 때 인코딩을 지정하지 않으면 기본적으로 utf8이 설정되기 때문에 한글이 깨지는 경우가 발생한다.

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

#### 데이터베이스 삭제(없으면 넘어가기)

```sql
DROP DATABASE IF EXISTS [데이터베이스명];
```

없다면 warning이 발생한다.

### 데이터베이스 목록 조회

```sql
SHOW DATABASES;
```

### 데이터베이스 선택

```sql
USE [데이터베이스명];
```

### 테이블 생성

![image](https://user-images.githubusercontent.com/84510455/232663122-1f6c0beb-d847-4def-943f-2e4525280159.png)


```sql
CREATE TABLE [테이블명] (
    [컬럼명] [데이터타입] [옵션],
    [컬럼명] [데이터타입] [옵션],
    ...
);
```

나눠서 입력
```sql
MariaDB [db]> create table customer2(
    -> customer varchar(50),
    -> customer_street varchar(50),
    -> customer_city varchar(50),
    -> latitude varchar(50),
    -> longitude varchar(50),
    -> last_update varchar(50)
    -> );
```

한줄 입력
```sql
MariaDB [db]> create table loan (loan_number varchar(50), branch_name varchar(50), amount varchar(50));
```

다른 데이터 타입  
```sql
create or replace table customer2 (customer varchar(50), customer_street varchar(50), customer_city double, longitude double, last_update date);
```

### 테이블 삭제

![image](https://user-images.githubusercontent.com/84510455/232663222-9e7768ff-a814-4a23-a764-b79d1c24ef03.png)

```sql
DROP TABLE [테이블명];
```

```sql
drop table customer2;
```

```sql
 drop table if exists customer2;
```

### 테이블 수정

> Alter table

![image](https://user-images.githubusercontent.com/84510455/232664275-8481fa62-12d4-424d-a169-8fa1e30156ee.png)

#### 테이블 이름 변경

```sql
alter table customer2 rename column customer to customer_name;
```

#### 테이블 컬럼 추가

```sql
alter table customer2 add column (geopoint POINT);
```

#### 테이블 컬럼 삭제

```sql
ALTER TABLE [테이블명] DROP [컬럼명];
```

```sql
ALTER TABLE customer DROP customer_city;

alter table customer2 drop column if exists longitude;
```

*column 옵션*

#### 테이블 컬럼 이름 변경

```sql
ALTER TABLE [테이블명] CHANGE [기존 컬럼명] [변경할 컬럼명] [데이터타입] [옵션];
```

```sql
ALTER TABLE customer CHANGE customer_city city varchar(50);
```

#### 테이블 컬럼 타입 변경

```sql
ALTER TABLE [테이블명] MODIFY [컬럼명] [데이터타입] [옵션];
```

```sql
ALTER TABLE customer MODIFY city double;
alter table customer2 modify customer_street varchar(10);
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

```sql
select * from customer;
```

`*`안에 컬럼명을 넣으면 해당 컬럼만 조회한다.

```sql
select customer, customer_street from customer;
```

## SQL - DML

```sql
create table grade (id integer, name varchar(10), attendance double, midterm double, assignment double, final double);
```

테스트용

### 데이터 삽입

![image](https://user-images.githubusercontent.com/84510455/232666379-daca2999-d46a-488a-867e-a558f3c08e74.png)

```sql
INSERT INTO [테이블명] VALUES (값1, 값2, ...);
```

```sql
insert into grade values(615453, 'J.B.', 10, 30, 30, 30);
```

```sql
insert into grade values(615453, 'J.B.', 10, 30, 30, 30), (615454, 'J.B.', 10, 30, 30, 30);
```

한번에 두개 이상의 튜플을 삽입가능..

### 데이터 삭제

![image](https://user-images.githubusercontent.com/84510455/232667492-7cdc5792-6222-4075-a183-dc08e9d83e1a.png)

```sql
DELETE FROM [테이블명];
```

```sql
delete from grade;
```

### 데이터 수정

![image](https://user-images.githubusercontent.com/84510455/232668043-550ce541-e6ae-40db-8ea3-895e4dc00f93.png)

*테스트 Relation*  
```sql
create or replace table grade (id integer, name varchar(10), attendance double, midterm double, assignment double, final double);

insert into grade values (615453, 'J.B', 10, 30, 30, 30), (2, 'A', 5, 15, 15, 15);
```

데이터를 업데이트 하기 위해 새로운 애트리뷰트를 추가

```sql
alter table grade add column (total double);
```

*값은 null로 들어감*  

```sql
update grade set total=attendance+midterm+assignment+final;
```

![image](https://user-images.githubusercontent.com/84510455/232669548-e270b0c6-a83d-4fb5-978c-8d8ac2eb50f3.png)

* 언제 마지막으로 업데이트했는지 추가

date 타입이 데이터 형식 추가

```sql
alter table grade add column (last_update date);
```

update문을 통해 last_update에 현재 날짜를 넣어줌

```sql
update grade set last_update=CURDATE();
```

*CURDATE() 현재 날짜 반환 함수*

## SQL - Built-in Functions

### string functions

> 문자열 관련 빌트인 함수

```sql
Create table a (stringValue VARCHAR(50));

insert into a values('jack'), ('123'), ('MariaDB');

// 문자열 길이
select character_length(stringValue) from a;

// 아스키 코드 변환
select char(77,97,114,105,97,68,66);

// 문자열을 결합
select concat(id,'.',name,'.',attendance,'.',midterm) from grade;

select concat_ws(',', id, name, attendance, midterm) from grade;

// 대소문자 변환
select stringValue, Lower(stringValue), Upper(stringValue) from a;

// 공백 제거
select v ,trim(v), character_length(trim(v)) from b;

// 문자열 일부 반환
select v, substring(v, 1, 2) from b;

// 문자열 일부 대체
select replace(v, '-', ',') from b;

// 문자열에서 특정 문자열의 위치 반환 (없으면 0)
select v, instr(v, '2') from b;

// 문자열 비교
select v, strcmp(v, 'p') from b;

// 문자열을 다른 데이터 타입으로 변환
select cast(substring(v, 2, Character_length(v)) as integer) from b;
select cast(substring(v, 2, Character_length(v)) as integer) > 400000 from b;
```

* CHARACTER_LENGTH() 문자열의 길이를 반환  
* CHAR() 아스키코드를 문자로 반환  
* CONCAT() 문자열을 연결하여 반환  
* CONCAT_WS() 문자열을 연결하여 반환하며, 구분자를 지정할 수 있음
* LOWER() 문자열을 소문자로 변환
* UPPER() 문자열을 대문자로 변환
* TRIM() 문자열의 공백을 제거
* SUBSTRING() 문자열의 일부를 반환
* REPLACE() 문자열의 일부를 다른 문자열로 대체
* INSTR() 문자열에서 특정 문자열의 위치를 반환
* STRCMP() 문자열을 비교하여 0, 1, -1을 반환
* CAST() 문자열을 다른 데이터 타입으로 변환


![image](https://user-images.githubusercontent.com/84510455/232689167-be7ac2d1-a684-4633-93a0-60bc3b344e01.png)

![image](https://user-images.githubusercontent.com/84510455/232691758-3212f0ce-a0bb-47c4-ae2a-3183d29d0c39.png)

![image](https://user-images.githubusercontent.com/84510455/232693206-837c8e18-e281-4ee3-910b-b15bda712f79.png)

### date & time functions

> 날짜/시간 관련 빌트인 함수


```sql

// 현재 날짜
select curdate();

// 현재 시간
select curtime();

// interval을 사용하여 시간 계산
select curdate(), curdate() - interval 20 year;

// 시간대 변환
select curdate(), curtime(), convert_tz(curdate(), '+09:00', '+00:00');

// UNIX_TIMESTAMP() 날짜를 초로 변환
select FROM_UNIXTIME(UNIX_TIMESTAMP(CURDATE()));

// 날짜 변환
select dayofweek(curdate()), dayofMonth(curdate()), month(curdate());

// 날짜 형식 변환
select STR_TO_DATE('March 30 2023', '%M %e %Y');   

// 날짜 형식 변환
select DATE_FORMAT('2021-03-30', '%Y-%m-%d');
```

* CURDATE() 현재 날짜를 반환
* CURTIME() 현재 시간을 반환
* CONVERT_TZ() 시간을 다른 시간대로 변환
* UNIX_TIMESTAMP() 날짜를 초로 변환
* FROM_UNIXTIME() 초를 날짜로 변환
* DAYOFWEEK() 요일을 반환
* DAYOFMONTH() 일을 반환
* DAYOFYEAR() 년도의 일을 반환
* MONTH() 월을 반환
* STR_TO_DATE() 문자열을 날짜로 변환 

![image](https://user-images.githubusercontent.com/84510455/232697956-fa92afd0-2802-407f-ac55-9e27d6702d43.png)

![image](https://user-images.githubusercontent.com/84510455/232700399-abfa5b23-70c7-4879-8e7d-d17bdd74b650.png)

![image](https://user-images.githubusercontent.com/84510455/232705906-95ddc15a-89e8-49de-8e27-d97b55e729cb.png)

### Aggregate functions

> 집계 관련 빌트인 함수

```sql
// 테스트 테이블
create or replace table a (v int);

// 값 넣기
insert into a values (30), (40), (50), (60), (25);

// 평균, 최대, 최소, 합, 개수
select avg(v), max(v), min(v), sum(v), count(v) from a;

// 중복 제거 개수
select count(v), count(distinct v) from a;
```

* AVG() 평균을 반환
* COUNT() 행의 개수를 반환
* COUNT(DISTINCT) 중복을 제거한 행의 개수를 반환
* MAX() 최대값을 반환
* MIN() 최소값을 반환
* SUM() 합을 반환
* STD() 표준편차를 반환

### Numeric functions

> 수학 관련 빌트인 함수

```sql
// 제곱
select pow(5,3 ) * 4;

// 내림
select floor(35.55);

// 랜덤 난수 생성 (5~15)
select floor(rand() * 11 + 5);
```

* 사칙연산 가능
* ()사용
* pow
* sort
* FLOOR() 내림
* CEILING() 올림
* RAND() 난수 생성

### Control flow functions

> 제어 흐름 관련 빌트인 함수

```sql
// CASE OPERATOR
select case when v >= 80 then 'A' when v >= 60 then 'P' else 'F' END from a;

//IF FUNCTION
select if(v >= 60, 'PASS', 'FAIL') from a;
```

* CASE WHEN THEN END 조건문

### Encryption, Hashing and Compression Functions

> 암호화, 해싱, 압축 관련 빌트인 함수

```sql
// 데이터 해싱
select sha2(v, 256) from b;

// 데이터 암호화
insert into grade values ('jack', password('1234'));

// 데이터 인코딩 디코딩
select encode('4321', 'my_code');

select decode(encode('4321', 'my_code'), 'your_code'); // 실패

select decode(encode('4321', 'my_code'), 'my_code'); // 성공

// 데이터 압축
select compress('Hello DB'); 

// 데이터 압축 해제
select uncompress(compress('Hello DB'));
```

* SHA2() 문자열을 SHA2 해시로 변환
* PASSWORD() 문자열을 암호화
* ENCODE() 문자열을 암호화
* DECODE() 암호화된 문자열을 복호화
* COMPRESS() 문자열을 압축
* UNCOMPRESS() 압축된 문자열을 복원

![image](https://user-images.githubusercontent.com/84510455/232781644-eb71477f-0b56-4662-821f-70543d36f90c.png)

![image](https://user-images.githubusercontent.com/84510455/232782316-ad29c5ab-4829-4290-8a45-aec46d83484f.png)

![image](https://user-images.githubusercontent.com/84510455/232783058-542f2b6b-7e44-481a-b103-d07686f894e7.png)

### geographic functions

> 지리 관련 빌트인 함수

```sql
// point 데이터 타입 테이블 생성
create or replace table point (point point);

// point 데이터 타입 테이블에 값 넣기
insert into point values (point(20, 10), point(10, 20), point(20, 20));

// point 데이터 타입 테이블 조회
select astext(point) from point;

// x, y 좌표 조회
select astext(point), x(point), y(point) from point;

// 두 좌표간 거리 계산
select st_distance(point, point(100,100)) from point;
```

* POINT() 좌표를 생성
* ASTEXT() 좌표를 문자열로 변환
* X() 좌표의 x값을 반환
* Y() 좌표의 y값을 반환
* ST_DISTANCE() 두 좌표간 거리를 반환

![image](https://user-images.githubusercontent.com/84510455/232786128-510afb42-58d7-4665-ac9b-8f6fb532e4e2.png)

### JSON functions

> JSON 관련 빌트인 함수

```sql
// json 데이터 타입 테이블 생성
create table test (a json);

// json 데이터 타입 테이블에 값 넣기
insert into status values (432156, 'kildong', '{"temperature" : 36.5, "humidty" : 60.0}');

// json 데이터 값 테이블 조회 (없으면 null)
select json_value(sensing_values, '$.temperature') from status;

// json 데이터 타입 테이블 조회 (없으면 null)
select json_type(json_value(sensing_values, '$.temperature')) from status;

// json 데이터 값 존재 여부 확인
select json_exists(sensing_values, '$.step') from status;

// json 데이터 값 상세 정보 확인
select json_detailed(sensing_values) from status;

// json 데이터 키 목록 확인
select sensing_values ,json_keys(sensing_values) from status;

// json 데이터 타입으로 변환
select json_objectagg(id, name) from status;
```

* JSON_VALUE() JSON 문자열에서 특정 경로의 값을 반환
* JSON_TYPE() JSON 문자열에서 특정 경로의 데이터 타입을 반환
* JSON_EXISTS() JSON 문자열에서 특정 경로의 값이 존재하는지 확인
* JSON_DETAIL() JSON 문자열에서 특정 경로의 값의 상세 정보를 반환
* JSON_KEYS() JSON 문자열에서 특정 경로의 키 목록을 반환
* JSON_LENGTH() JSON 문자열에서 특정 경로의 값의 개수를 반환
* JSON_OBJECTAGG() JSON 문자열을 생성
* JSON_ARRAYAGG() JSON 배열을 생성

![image](https://user-images.githubusercontent.com/84510455/232812959-a685089c-006e-4401-9633-605324fc3bae.png)

![image](https://user-images.githubusercontent.com/84510455/232818289-6d89ea3d-1273-42c4-a683-2582137b0652.png)

![image](https://user-images.githubusercontent.com/84510455/232818951-ec27face-d92e-41e3-9e50-b831b4a79c82.png)

![image](https://user-images.githubusercontent.com/84510455/232820219-36356b8e-1317-4190-8264-1303cb91e61d.png)

![image](https://user-images.githubusercontent.com/84510455/232821006-032b3ae7-f397-482c-a2b6-3319b794767f.png)

![image](https://user-images.githubusercontent.com/84510455/232822164-51c5ab02-5f98-4b5d-850f-aeaf360d01bc.png)

## SQL - DDL(Integrity Constraints)

### not null

> null 값을 허용하지 않는다.

```sql
// not null 제약 조건을 가진 테이블 생성
create or replace table account (account_number varchar(50), branch_name varchar(50), balance int not null);

insert into account values('A-102', 'Downtown', null); // 에러
```

![image](https://user-images.githubusercontent.com/84510455/232825497-d41e1020-5831-41a4-8119-4b3aca7f81ff.png)

### unique

> 중복된 값을 허용하지 않는다.

```sql
// unique 제약 조건을 가진 테이블 생성
create or replace table account (account_number varchar(50), branch_name varchar(50) unique, balance int not null);

insert into account values('A-102', 'Downtown', 123);
insert into account values('A-102', 'Downtown', 123); // 에러
```

### check

> 특정 조건을 만족하는 값만 허용한다.

```sql
// check 제약 조건을 가진 테이블 생성
create or replace table account (account_number char(10) null, branch_name varchar(50), balance int not null, check(balance >= 0));

insert into account values('A', 'B', -3);
ERROR 4025 (23000): CONSTRAINT `CONSTRAINT_1` failed for `db`.`account`

// enum형식만 지정
create or replace table student (name varchar(50) not null, student_id varchar(50), degree_level varchar(50), primary key (student_id), check(degree_level in ('Bachelors', 'Masters', 'Doctorate')));

insert into student values ('a', 'b', 'c');
ERROR 4025 (23000): CONSTRAINT `CONSTRAINT_1` failed for `db`.`student`
insert into student values ('a', 'b', 'Bachelors');
Query OK, 1 row affected (0.001 sec)
```

### primary key

> null 값을 허용하지 않고 중복된 값을 허용하지 않는다.

```sql
// primary key 제약 조건을 가진 테이블 생성
create or replace table student(student_identifier varchar(50), citizen_identifier varchar(50), student_name varchar(50), department varchar(50), primary key (student_identifier));
```

### foreign key

> 다른 테이블의 특정 컬럼을 참조하는 컬럼

```sql
CREATE OR REPLACE TABLE person (citizen_identifier VARCHAR(50), age INTEGER, address VARCHAR(50), PRIMARY KEY (citizen_identifier));

CREATE OR REPLACE TABLE student (student_identifier VARCHAR(50), citizen_identifier VARCHAR(50), student_name VARCHAR(50),​department VARCHAR(50),PRIMARY KEY (student_identifier),FOREIGN KEY (citizen_identifier) REFERENCES person (citizen_identifier));
```

## SQL - Query

### projection

![image](https://user-images.githubusercontent.com/84510455/232831302-42d7d8aa-d4bb-46e3-ae5d-0f80aec20ce5.png)

```sql
CREATE OR REPLACE TABLE loan (loan_number VARCHAR(50), branch_name VARCHAR(50), amount DOUBLE,PRIMARY KEY (loan_number));

​INSERT INTO loan VALUES ('L-11', 'Round Hill', 900), ('L-14', 'Downtown', 1500), ('L-15', 'Perryridge', 1500), ('L-16', 'Perryridge', 1300), ('L-17', 'Downtown', 1000);

select branch_name from loan; // 기본적으로 all이기 때문에 중복 허용

or

select loan.branch_name from loan;

select distinct branch_name from loan; // 중복 제거

select loan_number, branch_name from loan;

select loan.loan_number distincct from loan;
```

![image](https://user-images.githubusercontent.com/84510455/232832174-dfe50224-2a66-40c5-ad0c-e4ed8a8cf611.png)

++ 만약 해당 애트리뷰트가 candidate key라면 distinct를 사용하지 않아도 된다.

![image](https://user-images.githubusercontent.com/84510455/232834357-e4ad7972-07e5-48f2-9151-fb4c98b7d606.png)

### alias

> 컬럼 이름을 임시로 변경

```sql
select MIN(amount) as amount from loan;

select MIN(amount) as min_amount, MAX(amount) as max_amount from loan;

select MIN(amount) as 'amount space test' from loan; // 공백은 문자열 처리
```

![image](https://user-images.githubusercontent.com/84510455/232833457-8e13bcef-47ad-4173-a5bc-80835a54096b.png)

### where(시그마)

> 특정 조건을 만족하는 튜플만 선택

*시그마를 사용하기 위해선 where절을 사용해야 한다.*

```sql
select * from loan where branch_name = "Perryridge";

select * from loan where branch_name = "Perryridge" AND amount > 1400;

select * from loan2 where month(date);

select * from loan2 where Year(date)= 2020 -1;

select * from loan2 where branch_name = "Perryridge" and amount < 1400;

select loan_number from loan2 where dayofmonth(date)=29; 
// loan_number가 primary key여야 한다.
```

![image](https://user-images.githubusercontent.com/84510455/232836544-d2df7edf-d15a-4fc4-af45-b0c1651a1811.png)

### like

> 문자열을 비교할 때 사용

* % : 0개 이상의 문자열
* _ : 1개의 문자열

```sql
select * from loan2 where loan_number like 'L_1_';

select * from loan2 where date like "%-03-%" OR date like "%-08-%";

select * from loan2 where branch_name like '%Hill';
```

![image](https://user-images.githubusercontent.com/84510455/232842943-d8d98518-8381-40d3-844b-370eb558dbf7.png)


### UNION

> 두 개의 테이블을 합친다.(합집합)

```sql
// 테스트 용 테이블
CREATE OR REPLACE TABLE borrower (customer_name VARCHAR(50), loan_number VARCHAR(50));

INSERT INTO borrower VALUES ('Adams', 'L-16'),('Curry','L-93'),('Hayes','L-15'),('Jackson','L-14'),('Jones','L-17'),('Smith','L-11'),('Smith','L-23'),('Williams','L-17');

CREATE OR REPLACE TABLE depositor (customer_name VARCHAR(50), account_number VARCHAR(50));

INSERT INTO depositor VALUES ('Hayes', 'A-102'), ('Johnson', 'A-101'), ('Johnson', 'A-201'), ('Jones', 'A-217'), ('Lindsay', 'A-222'), ('Smith', 'A-215'), ('Turner', 'A-305');

// 디폴트로 distinct가 적용되어 있다. 전부 합치려면 union all을 사용한다.
select customer_name from borrower union select customer_name from depositor;
```

![image](https://user-images.githubusercontent.com/84510455/232931135-8c7ec288-5be0-4761-a4a8-6be4dbe4384d.png)

### INTERSECT

> 두 개의 테이블의 교집합을 구한다.

```sql
select customer_name from borrower intersect select customer_name from depositor;
```

### EXCEPT

> 두 개의 테이블의 차집합을 구한다.

```sql
select customer_name from borrower except  select customer_name from depositor;
```

* table의 순서가 바뀌면 결과도 달라진다.

### ORDER BY

> 튜플을 정렬한다.

```sql
CREATE OR REPLACE TABLE loan2 (loan_number VARCHAR(50), branch_name VARCHAR(50), amount DOUBLE, date DATE);

INSERT INTO loan2 VALUES ('L-11', 'Round Hill', 900, '2019-03-29'), ('L-14', 'Downtown', 1500, '2019-03-30'), ('L-15', 'Perryridge', 1500, '2019-08-02');

INSERT INTO loan2 VALUES ('L-16', 'Perryridge', 1300, '2019-09-05'), ('L-17', 'Downtown', 1000, '2020-01-13'), ('L-23', 'Redwood', 2000, '2020-02-01'), ('L-93', 'Mianus', 500, '2021-03-02');

// 오름차순
select loan_number, date from loan2 order by date asc;

// 내림차순
select loan_number, date from loan2 order by date desc;

// 월을 기준으로 오름차순 정렬
select loan_number, date from loan2 order by MONTH(date) asc;

// 순서대로 월, 년, 일을 기준으로 내림차순 정렬
select loan_number, date from loan2 order by month(date) desc, year(date) desc, day(date) desc;
```

![image](https://user-images.githubusercontent.com/84510455/232935266-8f2d50ca-bbd0-464b-a184-d60726d04f7a.png)

### LIMIT

> 튜플의 개수를 제한한다.

```sql
// 2개만 출력
select * from loan2 limit 2;

// 정렬된 값에서 1개만 출력
select loan_number, date from loan2 order by month(date) desc, year(date) desc, day(date) desc limit 1;

// 정렬된 값에서 1개를 건너뛰고 1개만 출력 즉, 두번 쨰
select loan_number, date from loan2 order by month(date) desc, year(date) desc, day(date) desc limit 1, 1;

create or replace table a(a int);

insert into a values(1), (2), (3), (4), (5), (6), (7), (8), (9);

select * from a limit 4, 4; // 페이지 구하기..
```

### GROUP BY

> 특정 속성을 기준으로 그룹을 만들고, 그룹별로 집계함수를 적용한다.

```sql
// 전체 합
select sum(salary) from pt_works;

// 각 branch_name 별 합
select sum(salary) from pt_works group by branch_name;

select branch_name, sum(salary) from pt_works group by branch_name;

// 평균 값
select branch_name, avg(salary) from pt_works group by branch_name;

// 평균 값이 2000 이상인 것만 출력
select branch_name, avg(salary) from pt_works group by branch_name having avg(salary) > 2000;

// branch_name이 두개 이상인 것만 출력
select avg(salary) from pt_works group by branch_name having count(*) > 1;
```

**그룹의 경우엔 where가 아닌 having을 사용한다.**

![image](https://user-images.githubusercontent.com/84510455/232937952-ded8f052-9955-44d1-9912-3628858e6fea.png)

### JOIN

> 두 개 이상의 테이블을 연결하여 튜플을 검색한다.

```sql
CREATE OR REPLACE TABLE loan (loan_number VARCHAR(50), branch_name VARCHAR(50), amount DOUBLE,PRIMARY KEY (loan_number));

INSERT INTO loan VALUES ('L-11', 'Round Hill', 900), ('L-14', 'Downtown', 1500), ('L-15', 'Perryridge', 1500), ('L-16', 'Perryridge', 1300), ('L-17', 'Downtown', 1000);

// JOIN
select * from borrower join loan;

select customer_name from loan join borrower where branch_name = "Perryridge" and borrower.loan_number = loan.loan_number;

// 가장 큰 값 찾기
select balance from account except (select a1.balance from account as a1, account as a2 where a1.balance < a2.balance);

// 테스트 테이블
CREATE OR REPLACE TABLE customer (customer VARCHAR(50), customer_street VARCHAR(50), customer_city VARCHAR(50),PRIMARY KEY (customer));
```

가장 큰 값은 빌트인 max를 써도 되고 위 처럼 cartisian product를 사용해서 가장 크지 않은 값들의 집합을 차집합하여 구할 수 있다.

![image](https://user-images.githubusercontent.com/84510455/232940055-026f6ef7-e7d9-4b3d-b051-a2b3ce6c8901.png)

#### NATURAL JOIN

> 두 테이블의 공통 속성을 기준으로 튜플을 검색한다.

```sql
// 공통된 loan.number를 기준으로 join.. 하지만 복잡함
select * from loan, borrower where loan.loan_number = borrower.loan_number;

// NATURAL JOIN 사용
select * from loan Natural join borrower;
```

![image](https://user-images.githubusercontent.com/84510455/232947051-e1ecd172-b277-4e6e-aca5-67f1596e9bc5.png)

#### Theta JOIN

> 조건을 만족하는 튜플을 검색한다.

customer_name과 customer의 값이 같지만 join을 하면 공통된 속성이 없기 때문에 cartisian product가 된다.

따라서 theta join을 사용하여 조건을 만족하는 튜플을 검색한다.

```sql
select * from customer join depositor on customer.customer = depositor.customer_name;

select * from customer join depositor where customer.customer = depositor.customer_name;
```

둘다 동일한 기능을 함

on은 좀 더 명확

#### Outer JOIN

```sql
CREATE TABLE employee (employee_name VARCHAR(50), street VARCHAR(50), city VARCHAR(50));

INSERT INTO employee VALUES ('Coyote', 'Toon', 'Hollywoord'), ('Rabbit', 'Tunnel', 'Carrotville'), ('Smith', 'Revolver', 'Death Valley'), ('Williams', 'Seaview', 'Seattle');

CREATE TABLE ft_works (employee_name VARCHAR(50), branch_name VARCHAR(50), salary INTEGER);

INSERT INTO ft_works VALUES ('Coyote', 'Mesa', 1500), ('Rabbit', 'Mesa', 1300), ('Gates', 'Redmond', 5300), ('Williams', 'Redmond', 1500);

// left outer join
select * from employee left outer join ft_works on employee.employee_name = ft_works.employee_name;

// natural left outer join
select * from employee natural left outer join ft_works;

// natural right left outer join
select * from employee natural left outer join ft_works union select * from employee natural right outer join ft_works;
```

![image](https://user-images.githubusercontent.com/84510455/232949195-13818887-ba9b-4e9a-8e93-b219f4254849.png)

![image](https://user-images.githubusercontent.com/84510455/232949410-c8f667f8-d4f2-4e5b-b6e9-2b0e13b813a7.png) 

![image](https://user-images.githubusercontent.com/84510455/232949777-42c1fcd4-2d3d-4004-ab97-cd1eb4581da4.png)
### As

> 테이블의 이름을 바꾸거나, 컬럼의 이름을 바꾼다.

```sql
select * from account as a1, account as a2;

select customer from customer join (select customer_street, customer_city from customer where customer = "Smith") as smith_address where customer.customer_street = smith_address.customer_street and customer.customer_city = smith_address.customer_city;
```

### Select - DML + DQL

> insert로 select결과를 넣을 수 있다.

```sql
INSERT INTO table(column1, column2, column3, …) SELECT column1, column2, column3, … FROM table WHERE condition;

// 자기 자신을 넣기 ++ Primary key가 있으면 안됨
insert into loan select * from loan;

// amount가 1000보다 큰 것만 넣기
insert into loan select * from loan where amount > 1000;
```

### Delete - DML

```sql
// amount가 null인 것을 삭제
delete from loan where amount is null;
```

*null에 대한 eqpul은 `is`로 체크*

## SQL - Subquery

![image](https://user-images.githubusercontent.com/84510455/232952661-caf271ec-14af-41d3-a096-5850219b7a78.png)


* scalar subquery : 하나의 값만 반환하는 subquery
* multi column subquery : 여러개의 열이 반환되는 subquery
* multi row subquery : 여러개의 행이 반환되는 subquery

```sql
// scalar subquery
select sum(balance) from account where branch_name = (select branch_name from loan where loan_number='L-14');

// multi column subquery
select * from staff where (name, age) = (select name, age from customer where name='Valerius' and age=61);

// multi row subquery
select customer_name from borrower where loan_number in (select loan_number from loan where branch_name="Perryridge");

// multi row and multi column subquery
select customer from customer where (customer_street, customer_city) in (select customer_street, customer_city from customer where customer = "Hayes");
```

* multi row subquery의 경우 in을 사용한다.(반복)

*`=` 대신 in을 사용해도 된다.*

### Subquery: In

> subquery의 결과가 in의 값과 같은지 비교한다.

```sql
// multi row and multi column subquery
select customer from customer where (customer_street, customer_city) in (select customer_street, customer_city from customer where customer = "Hayes");
```

### Subquery: Any, All

> subquery의 결과 중 하나라도 조건을 만족하면 true

```sql
​CREATE TABLE A (point INTEGER);CREATE TABLE B (point INTEGER);
INSERT INTO A VALUES (89),(50),(60),(65),(85);
INSERT INTO B VALUES (99),(30),(50),(60),(75);

select * from b where point > all(select * from a);
select * from b where point > any(select * from a);

// 다른 풀이
select * from a where a.point < all(select max(point) from b);
```

* any: 하나라도 만족하면 true
* all: 모두 만족해야 true

### Subquery: Exists

> subquery의 결과가 존재하면 true

```sql
select * from depositor where exists (select * from borrower where depositor.customer_name = borrower.customer_name);
```

### Subquery: **from**

> subquery의 결과를 from에 넣어서 사용한다.

```sql
select * from (select * from loan) as t;
// 같은 식
select * from loan;

// 데이블의 학생당 평균 계산
select name, avg(score) as avg_score from student2 group by name;

// 학생들의 평균 점수 계산
select avg(avg_score) from (select name, avg(score) as avg_score from student2 group by name) as t;
```

서브쿼리에 from절 기능을 사용하려면 **as**를 사용해야 한다.

## View

![image](https://user-images.githubusercontent.com/84510455/232975647-9a488378-42cb-46d3-b8ae-768b3c44aa04.png)

```sql
create view loanX as select * from loan where amount >= 1400;

select * from loanx;

create view loanP (branch_name, sum_amount) as select branch_name, sum(amount) as sum_amount from loan group by branch_name;
```

### View - expansion

```sql
drop view if exists loanX;
```

## Privilege

