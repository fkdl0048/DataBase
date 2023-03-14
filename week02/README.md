# DataBase week01

## 03/14  

### data Independence

- data independence

3장 27페이지 3계층 구조의 데이터 독립성 (시험에 나와요)

- key 내용 시험에 나와요

### Relational Model

행과 열이 있다.

| student(id) | Name | Semester |
|:---:|:---:|:---:|
| 100 | Jack | 3 |
| 200 | James | 6 |
| 300 | Jane | 9 |

표 전체를 Relation이라고 한다. (Relation Instance + Relation Schema)

Relation Instance: 표의 데이터

Relation Schema: 표의 애트리뷰트

Attribute: Degree = 3(애트리뷰트의 수)

Tuple: Cardinality = 3(튜플의 수)

*튜플 표시 방법*

> t -> (100, Jack, 3)

### Relation (a.k.a Table) 표시 방법

Relation Sche는 첫 글자는 대문자로 표시

Relation Instance는 튜플의 집합..  

### Relation

#### 애트리뷰트 (Attribute)

튜플의 구성요소

#### Degree

애트리뷰트의 수

#### 도메인 (Domain)

애트리뷰트가 가지 수 있는 값의 집합

ex) 학번은 0~9999까지의 정수 (정규표현식으로 나타냄)

#### Tuple

튜플은 애트리뷰트의 값들의 순서쌍

실제 값

#### Cardinality

튜플의 수

#### 예제

```
student_schema = {id, name, semester}
instantiates the following tuples
(100, "jack", 3)
(200, "james", 6)
(300, "jane", 9)
```

### Relational model의 특징

1. 튜플은 다 독립적인 개체이다. (유니크)
2. 튜플에는 순서가 없다.
3. 어떠한 애트리뷰트도 순서가 없다.
4. 도메인은 개념적으로 분리되면 안된다.(atomic)

### key

"튜플은 유니크하다" 이것에 대한 근거가 `key`

딕셔너리의 key와 동일한 개념

데이터 테이블에서 데이터의 유일성을 보장하는 필드

> ex) 학번, 주민번호, id 등등

#### Super Key

그 자체로 유니크한데 더 큰 개념(미니멀 하지 않음)

#### Candidate Key

Super Key 중에서 미니멀한 것

#### Primary Key

Candidate Key 중에서 선택한 것

#### Foreign Key

다른 테이블의 Primary Key를 참조하는 것

* Refernetial Integrity constraint: Foreign Key가 Primary Key를 참조하고 있음을 보장하는 것

### 정규표현식

따로 조사

## 03/16
