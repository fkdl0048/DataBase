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

### 유니온

유니온은 두 개의 테이블을 합치는 것

degree가 같아야하고 어트리뷰트의 도메인도 같아야 한다.  

집합의 역할

$$ \pi customer\_name(borrower) \cap customer\_name(depositor) $$

*교집합*

$$ \pi customer\_name(borrower) \cup customer\_name(depositor) $$

### Carteian Product

테이블을 곱하는 것

$$ borrower \times depositor $$

즉, 각각의 cadinality를 곱한 것 7*8 = 56

```text
12
34
*
ab
cd
ef
```

```text
12ab
12cd
12ef
34ab
34cd
34ef
```

cartinal product는 원하는 값을 찾기 위해 테이블을 합치고 필요한 값을 계산한다.

### Rename

테이블의 이름을 바꾸는 것

$$ \rho renamed\_relation(original\_relation) $$

가장 큰 수를 찾는 예제..

### join

공통된 애트리뷰트만 조합해줌.

곱하기보단 같거나 작을 수 있음

공통된 애트리뷰트가 없으면 곱하기와 같음

같은 애트리뷰트를 곱하자..

### division

$$ relation_1 \div relation_2 $$

연관된 애트리뷰트는 소거하고 겹치는 degree를 가져온다.

