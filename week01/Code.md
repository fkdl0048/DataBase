```java
package org.dfpl.lecture.database.motivation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class P2 {

 @SuppressWarnings("unused")
 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new FileReader("d:\\grade.txt"));

  HashMap<String, HashSet<Integer>> map = new HashMap<String, HashSet<Integer>>();
  while (true) {
   String line = br.readLine();
   if (line == null)
    break;
   String[] arr = line.split("\\|");
   // jack|010-1234-5678|jwbyun@gmail.com|database|6|79
   String name = arr[0];
   String phone = arr[1];
   String email = arr[2];
   String subject = arr[3];
   Integer semester = Integer.parseInt(arr[4]);
   Integer grade = Integer.parseInt(arr[5]);
   if (!map.containsKey(name)) {
    HashSet<Integer> set = new HashSet<Integer>();
    set.add(grade);
    map.put(name, set);
   } else {
    HashSet<Integer> set = map.get(name);
    set.add(grade);
   }
  }


  System.out.println(map.entrySet().parallelStream().collect(Collectors.toMap(entry -> entry.getKey(),
    entry -> entry.getValue().parallelStream().mapToInt(e -> e).average().getAsDouble())));


  br.close();
 }


}

```

```java
package org.dfpl.lecture.database.motivation.s2023db1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


public class P3 {


 public static void main(String[] args) throws IOException {
  BufferedReader r = new BufferedReader(new FileReader("c:\\Users\\Sejong\\grade.txt"));


  // 사람과, 사람이 들은 과목들의 점수
  HashMap<String, ArrayList<Integer>> g = new HashMap<String, ArrayList<Integer>>();


  while (true) {
   String str = r.readLine();
   if (str == null)
    break;
   // System.out.println(str);
   String[] arr = str.split("\\|");


   String name = arr[0];
   int point = Integer.parseInt(arr[arr.length - 1]);


   // g에 name이 없다면, 새로운 arraylist를 만들고 그 안에 point를 넣는다.
   // g에 name이 있다면, 이미 생성되어 있는 arraylist를 가져와서 point를 추가한다.
   if (!g.containsKey(name)) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(point);
    g.put(name, list);
   } else {
    ArrayList<Integer> list = g.get(name);
    list.add(point);
   }
  }


  System.out.println(g);
  for (Entry<String, ArrayList<Integer>> entry : g.entrySet()) {
   double total = 0;
   int count = 0;
   for (Integer intVal : entry.getValue()) {
    total += intVal;
    count++;
   }
   System.out.println(entry.getKey() + " -> " + (total / count));
  }
 }
}

```

```java
package org.dfpl.lecture.database.motivation.s2023db1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class P2 {
 public static void main(String[] args) throws IOException {
  BufferedReader r = new BufferedReader(new FileReader("c:\\Users\\Sejong\\grade.txt"));
  while (true) {
   String str = r.readLine();
   if (str == null)
    break;
   // System.out.println(str);
   String[] arr = str.split("\\|");
   for (String elem : arr) {
    System.out.print(elem + ",");
   }
   System.out.println();
  }
 }
}

package org.dfpl.lecture.database.motivation.s2023db1;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class P1 {
 public static void main(String[] args) throws IOException {
//  jack|010-1234-5678|jwbyun@gmail.com|database|6|98
//  jack|010-1234-5678|jwbyun@gmail.com|database programming|7|96
  BufferedWriter w = new BufferedWriter(new FileWriter("c:\\Users\\Sejong\\grade.txt"));
  w.write("jack|010-1234-5678|jwbyun@gmail.com|database|6|98\n");
  w.write("jack|010-1234-5678|jwbyun@gmail.com|database programming|7|96");
  
  w.close();
 
 }
}

```

// 데이터의 진실성

```java
package org.dfpl.lecture.database.motivation;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;


public class P3 {


 @SuppressWarnings("unused")
 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new FileReader("d:\\database\\grade_integrity.txt"));


  HashMap<String, HashSet<Integer>> map = new HashMap<String, HashSet<Integer>>();
  while (true) {
   String line = br.readLine();
   if (line == null)
    break;
   String[] arr = line.split("\\|");
   // jack|010-1234-5678|jwbyun@gmail.com|database|6|79
   String name = arr[0];
   String phone = arr[1];
   String email = arr[2];
   String subject = arr[3];
   Integer semester = Integer.parseInt(arr[4]);
   Integer grade = Integer.parseInt(arr[5]);


   if (subject.equals("database") && semester != 5)
    continue;


   if (!map.containsKey(name)) {
    HashSet<Integer> set = new HashSet<Integer>();
    set.add(grade);
    map.put(name, set);
   } else {
    HashSet<Integer> set = map.get(name);
    set.add(grade);
   }
  }


  System.out.println(map.entrySet().parallelStream().collect(Collectors.toMap(entry -> entry.getKey(),
    entry -> entry.getValue().parallelStream().mapToInt(e -> e).average().getAsDouble())));


  br.close();
 }


}
```
