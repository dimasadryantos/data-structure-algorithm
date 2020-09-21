=======JAVA PRACTICE=======

-the % operator returns the reminder of two numbers. For instance 10 % 3 is 1 BECAUSE 10 divided by 3 leaves a remainder of 1

-java System.out.printf (Function) can be used to formatted output

 Example :

 String str1 = "DIMAS";
 int int1 = 90;

 System.out.printf("%-15s %03d %n",str,int1);

 OUTPUT = DIMAS               090

 BLOGS : https://www.homeandlearn.co.uk/java/java_formatted_strings.html#:~:text=To%20get%20the%20left%2Djustified,except%20for%20the%20minus%20sign.


Java math POW :
the math POW is an built method java MATH class and is used to calculate the power of given number

the power of given number refers to how many times to multiple the number with it self

base = 2;
exponent = 4;

2^4 = 2*2*2*2 = 16

syntax :

public static double pow(double a,double b){
	return a^b;
}

Code example :

int int1 = (Int) Math.pow(5,4);

returns : 625


============Looping Pyramid===============

Patern 1 :

*
**
***
****
*****

Code :

int rows = 5;

for(int i = 1 ; i<=rows ; i++){

	for(int j=1 ; j<=i ; i++){
		System.out.print("*");
	}

	System.out.println("");
}


Patern 2 :

1
1 2
1 2 3
1 2 3 4
1 2 3 4 5

Code :

int rows = 5;

for(int i=1 ; i<=rows ; i++){

	for(int j=1 ; j<=i ;j++){
		System.out.print(j+" ");
	}
	System.out.println("")
}


Patern 3:

A
B B
C C C
D D D D
E E E E E


Code :

char startAlphabet='A';
char endAlphabet ='E';


for(int i=1; i<=endAlphabet-'A'+1;i++){

	for(int j=1;j<=i;j++){
		System.out.print(startAlphabet+" ");
	}

	startAlphabet++;
	System.out.println("");
}




Patern 4:

* * * * *
* * * *
* * *
* *
*


Code :

int rows = 5;

for(int i = 5 ; i >=1 ; i--){

	for(int j=1 ; j<=i ; i++){
		System.out.print("*");
	}

	System.out.println("");
}


Patern 5:
1 2 3 4 5
1 2 3 4
1 2 3
1 2
1

int rows=5;

for(int i=rows ; i >= 1; i--){

	for(int j=1; j<=i ; i++){
		System.out.print(j);
	}

	System.out.println(" ");
}

Patern 6 :

 		*
      * * *
    * * * * *
  * * * * * * *
* * * * * * * * *


Code :

int rows=5;
int stars=0;

for(int i=1;i<=rows;i++,stars=0){

	for(int j=1;j<= rows-i;j++){
		System.out.print("  ");
	}


	while(stars != i*2-1){
		System.out.print("* ");
		stars++;
	}

	System.out.println("");

}






Patern 7:

       *
      * *
     * * *
	* * * *
   * * * * *


int rows = 5;


for(int i=1 ; i<=rows ;i++){

	for(int j=1; j <= rows-i ; j++){
		System.out.print(" ");
	}

	for(int k=1; k<=i;k++){
		System.out.print("* ");
	}

	System.out.println("");
}


https://www.programiz.com/java-programming/examples/pyramid-pattern
https://www.java67.com/2015/10/how-to-print-pyramid-pattern-in-java-example.html


SHOPEE JOB PLATFORM ENGINEERING : SERVER DEVELOPER= https://careers.shopee.sg/job-detail/1248/


========HackerRank=======

1.find match number using Set (HashSet)

int n = 9;
int [] arr ={10, 20 ,20, 10 ,10, 30 ,50, 10 ,20};
int stock=0;
Set<Integer> colors= new HashSet();

for(int i<0;i<=n;i++){

	if(!colors.contains(arr[i])){

		colors.add(arr[i]);
	}else{
		stock++;
		colors.remove(arr[i]);
	}
}
System.out.println(stock);

Result = 3






===========Data Structure JAVA==============

1.Array :

-Array in java is bounded and you will get ArrayindexOutOfBoundException if youre working with invalid index
-Array in java homogeneous , you cannot store multiple types of objects in array like you can only store a String in String [] if you try store Integer you will get ArrayStoreException


1. Array one dimension (Vector)
2. Array two dimension (Matrix)
3. Array three dimension (3D Array)
4. ND Array


2.Linked List :

Similar to arrays in java Linked List is Linear(Berhubung/garis lurus) data Structure
Linked List element are not stored in contiguous(Berdampingan) location like Array they are Linked with each other using pointers

Each element in Linked list called node
Each Node in linked list contains two items:

1.Content of the element
2.Pointer / Address / Reference to the next node in the linkedlist



Note :

1.Head of the LinkedList only contain the address of the first alement of the list
2.The last element of LinkedList contains null(because it is the end of the list so it doesn't point to anything!)

Why do we need linked list ?


Arrays have certain limitations such as :

1.Size of the Array fixed
2.Array elemnts need contiguous(Berdampingan) memory locations to store their values
3.Inserting an element in Array is performance wise expensive , we have to shift several elements to make a space for the new element


These limitations are handled in the LinkedList :

1.Linkedlist Allows dynamic memory allocation,which means memory allocation is done at the runtime by the compiler
2.LinkedList elements don't need contiguous memory locations
3.Insert and Delete operation in the LinkedList are not performance wise expensive ,because linked list does'nt require element shifting


LinkedList Example Of Adding Elements :

LinkedList list = list.LinkedList();
	list.add("Steve");
	list.add("Carl");
	list.add("Raj");

	list.addFisrt("Negan");
	list.addLast("Rick");
	list.add(2,"Glenn");

	Iterator<String> iterator=list.iterator();

	while(iterator.hasNext()){
		System.out.println(iterator.next());
	}

Result  :

Negan
Steve
Glenn
Carl
Raj
Rick


LinkedList Example Of Remove ElementsL

LinkedList<String> list=new Linkedlist<>();

list.add("Steve");
list.add("Carl");
list.add("Raj");
list.add("Negan");
list.add("Rick");

list.removeFirst();
list.removeLast();

Iterator<String> iterator=list.iterator();
while(iterator.hasNext()){
	System.out.print(iterator.next()+"");
}
Result :
Carl,Raj,Negan


list.remove(1);

Iterator<String> iterator=list.iterator();
while(iterator.hasNext()){
	System.out.print(iterator.next()+" ");
}


Article about LinkedList : https://beginnersbook.com/2013/12/linkedlist-in-java-with-example/

whats the different ArrayList & LinkedList ?

-Arraylist better for storing and accessing Data
-LinkedList better for manipulating data


POPULAR QUESTION ABOUT DATA STRUCTURE AND ALGORITHM :

https://www.java67.com/2018/05/top-75-programming-interview-questions-answers.html

Article : https://javarevisited.blogspot.com/2013/03/top-15-data-structures-algorithm-interview-questions-answers-java-programming.html

1.How to find middle element of linked list in one pass?






===========Reverse String===============


Using String buffer:

String str ="Sony is going to introduce Internet TV soon";
String reverseStr =new StringBuffer(str).reverse().toString();


Swap String :

String a="Hello";
String b="World";

a=a+b;

b=a.subString(0,a.length()-b.length());
a=a.subString(b.length());

=========Deep knowlage of Data Structure==========
https://blog.pramp.com/how-to-succeed-in-data-structures-and-algorithms-interview-2ad1a28041b6

-know the strength's and weeakness
-how they compare to each other
-understand big O notation
-know the major sorting algorithm

========Udemy Data Structure=======

what is a data Structure ?
	-Organize and Stores data
	-Each Has strength and weeakness



what is an algorithm ?

	-Steps you have to preform to complite the task
	-Algorithms is not an implementations
Big-O notation


=====Data Structures=====
1.Arrays
2.List
3.Stack
4.Queues (di baca = qius)
5.HashTable
6.Trees
7.Heaps
8.Sets

=====Algorithms=====
1.Search Algorithms
2.Sort Algorithms
3.Recrusion


===Big O notations====
what is big O notations ? is the language we use for talking about how long an algorithm takes to run
- Big O notation is the language we use to describe the complexcity of an algorithm

Big O

O(1) = Constant
O(Log n) = Logarithmic
O(n) = Linear
O(nlogn) = n log-star n
O(n2) =  quadratic


example :

O(1) Constant this means that the input array could be 1 item or 1000 items but the function would still just require one STEP

O(n) Linear this means that if the array has 10 items i have to print 10 times,if it has 1000 items i have to print 1000 times

O(n2) Quadratic this means if the array has 10 items i have to print 100 times,if it has 1000 items i have to print 1000.000



https://medium.com/karuna-sehgal/a-simplified-explanation-of-the-big-o-notation-82523585e835


==========Array=============
1.Contiguous block in memory
Arrays cannot be Resize
Arrays has static length

2.Every element occupies(Menempati) the same amount of the space in memory
example : if we create int [] arrayInt=new Array[7]; (this all will store to type Int memory(4bytes))
if we working with object what store in variable is an object Reference

3.if an arrays starts at memory address x,and the size of each element in the array is Y we can caluculate the memroy address of the
	element by using the following expression: x + i * y

4.if we know the index of an element,the time to retrieve the element will be the same no matter where it is in the array

====Bubble sort performance=====

Bubble short mensorting dengan cara memindahkan element yg berdampingan di banding kan dengan yg mana yg lebih besar (int)

logic :
-loop dari kanan kekiri
-loop bedasarkan loop di atas
-compare jika index i > dari pada i+1
-swap index kiri ke kanan dan kanan ke kiri

1.In-place algorithm = secara logical memindahkan the array tanpa harus membuat array lagi untuk mensorting,ketika di memory akan in-place algorithm

2.O(n2) Time complexcity - quadratic

3.it will take 100 steps to sort 10 items,10000 steps to sort 100 items

4.Algorithms degrades quickly

5.stable algorithm


====Stable & Unstable Sort Algorithms====
Stable : Algoritma pengurutan yg stabil mempertahankan urutan relative dari element yg sama
Unstable : Algoritma pengurutan yg stabil namun ketika ada value yg sama kemungkinan posisi nya akan berubah

Article : https://www.baeldung.com/cs/stable-sorting-algorithms#:~:text=Stability%20in%20Sorting%20Algorithms&text=Stable%20sorting%20algorithms%20preserve%20the,elements%20relative%20to%20one%20another.


======Selection Sort======

Selecttion Sort mencari element yg terbesar dengan cara di bandingkan lalu di swap ke paling akhir

logic :
1.looping dari kanan ke kiri
2.loop bedasarkan jumlah loop di atas
3.bandingkan dengan variable  largest
4.lalu save largest index
5.swap

1.in place algorithm

2.O(n2) Time complexcity - quadratic

3.it will take 100 steps to short 10 items,1000 steps to sort 100 items

4.doesn't require as much swaping as bubble sort

5.Unstable algorithm


=====Insertion Sort=======

1.looping dari kiri ke kanan start index 1
2.store ke variable newElement
3.loop validasi & apakah i-1 > newElement jika true
4.pindahkan dari kiri ke kanan i-1 ke index i (i value sudah ke save di new element)5
5.beres loop i berkurang jadi 0
6.dan newElement akan menempati index nya i setelah loop kedua


1.in place algorithm

2.O(n2) Time complexcity - Quadratic

3.it will take 100 steps to short 10 items,1000 steps to sort 100 items

4.Stable algorithm

this implementation start from 1 because assuming that index 0 is already sorted

weakness = Insertion sort is quadratic algorithm but jika sequance value sudah di hampir ter sorting then insertion sort running almost linear time O(n)
because tidak perlu melalukan banyak shifting,think about if most value already sorted dan hanya beberapa yg butuh shifting maka insertion akan
memakan waktu sorting one by one

======Shell Sort=====

a computes science release if we cut down (mengurangi) jumlah shifting maka insertion sorting will run alot faster

*Shell sort logic :
array=7
1.loop di mulai dengan index gap=array.length / 2 = 3 lalu di loop ke dua akan di increment gap / 2 =1
2.loop kedua start dari j=gap dan loop array.length
3.save newElement dari j yaitu gap
4.declare j=i
5.while loop condition j >= gap && j-1 > newElement pindahkan dari kiri ke kanan index j-1 akan menempati index j
6.kurangi index j dengan gap untuk menyiapkan index newElement
7.input new array ke index j yg sudah di calculate di atas

shell sort adalah variasi dari Insertion Sort

how does Shell sort work ?? Inserion sort memilih element yg akan di isert menggunakan 1 gap(space),Shell sort start with larger Gap value
the goal to reduce amount of shifting

-As the algorithm progresses(sedang berjalan)the gap is reduced
-Last gap value is always 1 (when the gap is 1 we doing insertion sort)
-Array akan lebih ter sorting sbelum melakukan insertion sort

what do we use for the gap value?
one common sequances use Knuth Sequance , gap is also called interval

the way calculate the gap can influance time complexcity


1.shell sort in place algorithm

2.difficult to nail down the time complexcity because it will depend on the gap ,Worst case O(n2) but it can perform much better than that

3.Doesn't require as much as shifting as insertion sort,so it usually perform better

4,Unstable algorithm


Shell sort implementation and how to reduce the gap
 -we'll base out gap on the arrays length,we will initialize the gap(interfal) to array.length / 2
 -on Each iteration we'll devide the gap value by 2 to get the next step gap value
 -for our array,the gap will be initialized to 3
 -on the next iteration it will be 1 insertion sort

 NOTES : Practice Shell short to bubble short



=======Recursion=========

-Recursion adalah function yg memanggil diri nya sendiri
-Recursion is a process in which function call it self


when should i use recursion ?
-Recursion is made for solving problem that can be broken down into smaller
-ketika menggunakan iterative loop akan menghasilkan banyak line dan sulit di baca maka recursion is solution
-


Factorial Algorithm

1.if num is equal to 0,the factorial is 1.Stop we have the result. otherwise...

2.set multiplier to 1

3.set factorial to 1

4.while multiplier is not equal to num ,do step 5 and 5

5.multiply factorial by multiplier and asign the result to factorial

6.add 1 to multiplier

7.Stop ,the result is factorial


Notes :
-Setiap recursion ada kondisi untuk berhenti (Base condition)
-Setiap recursion akan store ke stack and waiting to be executed
-Setiap recursion akan menghitung mundur contoh input 5 lalu 5 akan waiting 4,3,2,1 maka 1 akan sysout terlebih dahulu
-Setiap recursion posible akan stack StackOverflowError ketika melebihi kapasitas stack dan tidak melewati Base condition
-Setiap recursion akan memakan stack memory namun secara coding akan lebih simple & mudah di mengertio (tetap ada proses di belakang yg harus di ketahui)


 Article :
 -https://medium.com/better-programming/when-to-loop-when-to-recurse-b786ad8977de
 -https://www.programiz.com/java-programming/recursion-
 -https://www.w3schools.com/java/java_recursion.asp



 ===========Merge Sort====================

 Merge sort is sorting technique based on divide and conquer technique
 with worst case time complexcity being O (n log n),it is one of the most respected algorithm

 Merge sort first divide the array into equal halves and then combine them in a sorted manner


*Merge Sort

-Devide and conquer algorithm
-Usualy implemented using Recursive algorithm (Recomended)
-Two phases : spliting and merging
-Spliting phase leads to faster sorting during the merging phases
-Spliting is logical we don't create new Arrays


******.Splitting Phase

1.Start with unsorted Array
2.Divide the array into two arrays,which are unsorted
  the first array is the left array , and the second array is the right array
3.Split the left and the right arrays into two arrays each
4.Keep spliting untill all the arrays have only one element each - these arrays are sorted


*****Spliting example

20,35,-15,7,55,1,-22

Start = 0 , end = 7 (array.length)

midPoint=(Start + End)/2 =3

Element 0 to 2 will go to the left
Element 3 to 6 will go to the right


	20,35,-15,7,55,1,-22


 20,35,-15			7,55,1,-22


20   35,-15         7,55     1,-22

	35    -15     7   55    1   -22


Desc :

First split Left / Right :
Start = 0 , End = 7
midPoint =(0 + 7)/2 = 3
Result : 20,35,-15 -  7,55,1,-22

Second Split Left 	:
Start = 0 , End =3
midPoint = (0 + 3)/2 = 1
Result : 20  -   35 ,-15

Third Split Left :
Start = 1 , End = 3
midPoint = (1 + 3)/2=2
Result = 35    -15





NOTES : Every time we do the merge we actually sort

NOTES : Because of recursion we are going to handle entire left side before the right

NOTES : We merge dari bawah

NOTES : End is always greater one than the last valid index



*****.Merging Phase
1.Merge every left/right pair of sibling arrays into a sorted array
2.After the first merge,we will have a bunch of 2 elements sorted arrays
3.then merge those sorted arrays (left/right siblings) to end up with a bunch of 4-element sorted arrays
4.repeat until you have single sorted array
5.Not in-place. uses temporary arrays


******Merge Notes
1.first round to merge that have siblings 20 does'nt have siblings


******Merge Process

1.We merge sibling left and right arrays
2.We create temporary array to hold all the elements in the arrays we are merging
3.We set i to first index of the left array & j to the first index of the right array
4.We Compare , Left [i] to Right[j]  :

if the left is smaller we copy it into temp array and increment i by 1
if right is smaller we copy it into temp array and increment j by 1

5.We repeat this process until elements in two arrays have been process
6.Temporary array contains the merge values in sorted order
6.we then copy this temporary array back to the original input array , at the correct positions
7.after the copy position x - z will be sorted in the original Array


******Conclution Merge Sort========

1.Not an in-place algorithm (We use temporary array to merge sibling arrays)
2.O(n log n =logaritmik algorithm) We're repeatedly dividing the array in half during spliting phase
3.Stable Algorithms = because when we do the merging we check apakah element di sebelah kanan lebih besar dari sebelah kiri jika tidak maka jika sama maka elements
sebelah kiri akan ke temp array paling pertama ,karna itu ketika ada duplicate item itu akan ber urut seusai tempat awal



====System.copyArray====
System.copyArray() method copies an array from the specified source array

public static void arrayCopy(Object src,int intSrc,Object dest,int destPos,int length)

1. src = this is the source array
2. srcPos = this is starting position in the source array
3. dest = this is the destination array
4. desPos = this is the starting position in the destination data
5. length = this is the number of array to be copied

this method does not return any value


=======Quick Sort=========

1.Divide and conquer algorithm
2.Recursive algorithm
3.Uses two element to partition the array into two parts
4.
- Elements < Pivot to its left ,
- Elements > Pivot to its right

5.Pivot will then be in its correct position


Quick sort conclution :

1.in place algorithm

2.O(n log n)- base 2. we are repeatedly partitioning the array into two halves

3.Unstable Algorithm

Notes : the choice of pivot can have an effect on the time complexcity.
depending on the data thats being sorted


====Counting Sort=========

What is Counting Sort ? :
		-In computer science counting sort is algorithm for sorting a collection of objects according to  keys that all small integers

-Makes Assumption about the data
-Doesn't use comparisons
-Counts the number of occurrences of each value
-Only works with non-negative discrete values
-Values must be within a specific range
-Counting sort can't sort string,floating point numbers

Notes : not using counting sort with one million(bigger number)

Counting Sort Conclution

1.Not in-place Algorithm because we use new array
2.Counting Sort is best use when the range of values you have is around the same range of input array
3.O(n) Linear Time, can achieve this because we are making assumptions about the data we are sorting
4.Unstable algorithms ,if we want to be stable we have to do some extra steps



========Radix Sort=============
What is radix sort  ?
		Radix sort is integer sorting algorithm that sorts data with integer keys by grouping the keys
		by individual digits that share the same significant position and value.


-Makes assumption about the data, in this case the assumption that it makes ,is that the data has the same radix and width
 The radix is the number of unque digits or values in this case characters that a numbering system or an alphabet has
 Example :
 *The radix for decimal system is 10 ,because there are 10 possible digits in the decimal system (Zero To Nine)
 *The radix for binary system is 2,because we use 2 digits in the binary system , zero and one
 *The radix for alphabet system is 26
 number 1234 has width 4
 string hello has width 5

we can use radix sort to sort Integers,string the decimal point is not the digit so we cant sort floating point numbers

-Because of this the data must be Integers or String
-Sort based on each individual digit or letter position
-Start at the rightmost position
-Must use a stable algorithm at each stage

*Radix Sort Conclution
1.Counting sort is often used as the sort algorithm for radix sort,-must stable counting sort
2.O(n) = Linear ,can achive this because we are making assumptions about data we are sorting
3.Even so,it often run slower than O(n log n) algorithms because of the overhead involved
4.in-place depends on which sort algorithm you use
5.Stable Algorithm

Radix sort step algorithm

1.sort base on width exmplae
123,234,233,343,434 sorting dari belakang lalu maju 1 dan selanjut nya (gunakan stable counting sort agar value tersorting)
2.do counting sort as usual
3.sum the previous counts(adjust the count)
		https://www.geeksforgeeks.org/counting-sort/

4.create temp array
5.loop dari kanan ke kiri
7.countArr - 1 =indexTempArray
8.kurangin tempArray

		====Radix sort===

		logical

		1.looping width start from 0 int[] radixArray = {4725, 4586, 1330, 8792, 1594, 5729}; result akan mendapat kan angka ter akhir lalu di counting sort
		cara getDigit value / Math.pow(radix,positions) % radix ; = 4725 / 10(pangkat angka dari posisi yaitu 0) di mod 10

		2.radix index 0 = 1,0,1,0,1,1,1,0,0,1

		3.jumlah kan countArray dengan value yg sebelum nya

		cara penjumlahan nya

		for(int i = 1 ; i < radix ; i++){
		countArray[i] += countArray[j-1]
		}

		result : 1,1,2,2,3,4,5,5,5,6


		sorting dari angka paling belakang di pindah ke temp array dengan cara temp=getDigit misalkan 3 maka hasil getDigit ini akan menyesuaikan dengan
		index countArray , di index 3 pada count array adalah  2 lalu count array di kurangi 1 hasil ini yg akan menjadi posisi hasil sorting dari input misalkan

		temp=--countArray(getDigit(2))=1 = input[3]


		cara pemindahan hasil sorting ke temp array :
		sorting dari kiri ke kanan agar menghasil kan sorting yg stabil

		*siapkan space untuk temp
		int [] temp= new int[input];

		for(int tempIndex = input-1 ; tempIndex > 0 ; tempIndex--){
		temp[--countArray[getDigit(position,input[tempIndex],radix)]] = input[tempIndex];
		}

		dari code di atas data dari input dengan index dari tempIndex akan menyesuaikan dan menempati hasil dari return digit yg mencari index pada countArray lalu countArray di kurang 1

		4.pindahkan temp index ke original index

		numItems = input.length;
		for(int j = 0;j < numItems ;j++){
		input[j]=temp[j];
		}


		Article : https://www.geeksforgeeks.org/counting-sort/



==============List=================

list is not concrete data structure its an abstract data type ?

		*Abstract data type
		-Does not dictate how the data is organized : Arrays telling us how the data has to be stored,List are more conceptual idea
		-List Dictates the operation you can perform on the data set
		-Concrete data structure is usually concrete class
		-Abstract data type is usually an interface
		-Abstract data type is more about behaviour and what operation you can do
		-in java concrete data structure is usually a class
		-When it comes to an abstract data types normally those are interface 


-Array List
-Linked List
-Vector

-Array list
		a resizeable array implementation of the list interface ,meaning that the data in the list is being stored in array
		and this array called the backing array.
		if we know the potition on an item in the list accesing it will be efficient in fact it will be one or constant time
		because we know that if we have the index of the item that we want so accesing the array is O of one

		when it comes to arraylist its important to understand the difference between size and capacity
		-capacity is the maximum number of items that the list can hold before its gonna have to be resized the backing array
		-the size is the number of items that are actually in the list
		Example :
		so if you create an arrayList with a capacity of 20 and you add 3 items to it then the capacity is 20 and the size is three
		if you don't pass capacity default is 10


		why don't we just use an array ?
		because arrayList has bunch of method that let you work with the List Items and so the code to do this has been writen for you
		also array list implements the list interface , you can swap to another type of list
		without too much disruption of the existing code

		ArrayList contains() untuk mengecek apakah ada items
		(default akan false jika tidak ada EQUAL atau sama dengan dan harus implement equal method di model bisa menggunakan intellij "generate")
		defaul akan mengecek apakah ada same instance
		jika ingin meng implement equal method di intellj harus implement hashcode ,untuk menseting nya biar kan default dan ceklis field

		ArrayList indexOf() this mehotd will look up an data in the list and tell us what index

		Arraylist contains() and indexOf() are only as good as the search method algorithm being used to search the array

		ArrayList remove() because we are dealing with an array in the background Remove can be expensive,
		because elements after the one we removed have to be shifted down one position

		ArrayList Conclution
		-good for random access if you have the index
		-good for iterating over the items in the list
		-it's not so good for inserting items into the list in any position other than the end
		-it's not so good for deletion,removal
		-and its not so good for accessing an item in the list when you don't have an index

-Vector
		Vector class is essentially a thread safe
		Vector in jdk since the begining 1.0 before ArrayList =1.2
		Vector is thread safe meaning its ok to use from different threads without synchronice the code but Arraylist is not
		if you use ArrayList with multiple threads and one or more of those threads is writing to the ArrayList
		by adding,deleting setting or changing object in the list then you could run into a conflict, you could have threading conflicts
		so in that case you want to use Vector than ArrayList
		so if you need thread safe to use Vector if you don't use ArrayList
		use vector class if you need synchronisation

-Linked List
		Linked list is data structure,its a sequential list of objects arrays are not involved
		in a linked list each item in the list is aware of another item in the list because each item in the list
		Contains a link to the next item in the list now this is different from arrays and list that are backed by Arrays
		With an array each item in the list is completely unaware of other items in the array
		But Items in a linked list know each item comes after them and that means we have to store some extra information with each item
		when we have an array of integer we just have to store value in each position
		But when it comes to a linked list we have to store the integer value and we have to store a refrence to the next integer in the list
		and the last item in the list always points to null ,because nothing comes after it

		data menamupung field dan next field(will be type of node) because each node pointe to the nodes comes after it
		so for a linked list,the only thing you have to store is a reference to the head (or the first node in the list)
		and from that you can get to every item in the list

		what we have to do to insert an item into this list ?
		lets say we wanted to insert "Bill" well the first thing we gonna to do :
		1.Create a new node "Bill"
		2.Assign "Jane" to the next "Bill"
		3.Assign Head to "Bill"
		4.Will be O(1) time complexity

		Advantages of linked list :
		If you insert of items at the front of the list you can do it in constant time complexity because the step you have to do
			don't depends on the number of items in the list

		how about deleting?
		when we do deletetion we return the node that we deleted
		so first we gonna assign bill to temp variable called removedNode,then what we do wanna do?
		all we gonna do move head to jane,because for linked list the only sort of information
		that we are holding is the head field


		Each item in the list is called a node
		the first item in the list is the HEAD of the list

		Conclution :
		Linkedlist they differ from arrays
		as long as youre inserting and deleting from the front of the list
		the insertion and deletion done in constant time because no shifting involved
		and this type of list is called singly linked list because we have one link between every node
		when you work with singly linked list you want to insert and delete items at the front of the list
		because you only have a refrence to the head of the list so if you want to insert and delete items anywhere else
			you have to started head and you ve got traverse entire list to find what you looking for




-Linked List Implementation	Notes :
		*In java by contains a link we mean that it store the object reference of the next node
		*If we ant make linkedlist (not using in JDK) make it specific to the type of data you're dealing with
		*the Only reason use generic is if youre going to write a class that going to be released publicly so that many applications are going to use it
		*Default value at the end of linked list is null
		*Singly Linked list is best use when you want to insert and remove items from the front of the list
		*The other things to note is ,is that a linked list can continue to grow without having to be resized
		*Remember with Arrays once array is full if we wanna add items to it we have to resize the array
		*Disadvantage to linked list is you have to store that extra field with every value
		*if memory very tight that could be one disadvantage to using linked list even you only adding and deleting items from the front
		*whether to use linked list or array will depend on application want to do if it wants to do bunch random accesses linked list
				would be bad choice cause you have to be traversing the list ,to get to want to access
		*But if you want to load a bunch of data into the list that could be good choice for linked list





-Double Linked List :
				*With Double Linked List we have node we have head we have a tail and each node in the list point to the next item in the list
				and to previous item in the list.
				*And this time if we want to insert or remove a node from the end of the list we can do it in constant time
				Because we have reference to the tail of the list
				*The Advantage of using double linked list is , you can work with the node at the front of the list or the node at end of the list
				in constant time
				*if you want to work at the middle we have same problem with singly linked list,youre gonna have treverse
				*if work on linked list you mainnly focus on front of the list (HEAD),or Double linked list at the tail of the list

-Linked List JDK :
	LinkedList is not Synchronise if you want to use LinkedList Instance from multiple threads,you will have to synchronise
				the calls to any of LinkedList Methods

				NOTES :
				-LinkedList add method adds an item to the end of the list(it adds at the tail) or you can use addLast (same add item at the end/tail)
				-If you want to add to the front use addFirst method
				-If you call remove() it will remove the first

				Important Point Here :
				is that if you wanna use a Linkedlist in java,you can use LinkedList class as long as you don't mind the extra memory overhead
				due to the next previous field
				LinkedList at the jdk is data structure its not backed anything different with ArrayList its backed with array
				if you're going to need lot of nodes and memory is tight,you might want to consider another type data structure

		Another Type Of LinkedList called Circular LinkedList and this is a variation on the Singly LinkedList
		and in this variation the last node doesn't point to NULL Instead ,it loops back and points to the head of the list
		and One Advantage to this : is that you can traverse the entire list starting at any node




-Stack

	Instead of dictating how we store the items stacks dictate what operations we can do on the items,
		Stack is known as an abstract data type

1.Stack Abstract Data Type
2.LIFO ,last in firsy out
3.Push - adds an item as the top item on the stack
4.Pop - Removes the top item on the stack
5.Peek - Gets the top item on the stack without popping it(We can get the items without remove it)
6.Ideal backing data structure = LinkedList

	The last item element that you add to a stack , is always first item that you can remove from the stack
		and so thats known as LIFO (That means no Random Acces,Because you only ever allowed to removed last item)
Time Complexity :
1.O(1) for push pop and peek when using a linked list
2.If you use an array,then push is O(n) ,becaused the array may have to be resized
3.If you know maximum number of items that will ever be on the stack,an array can be good choice
4.If memory tight array might be good choice
5.Linked list is ideal

-Implementing Stack with Array
		-Arrays are great for random access,Do we need random access for stack ?
		Well No! because we are only working with top item in the stack
		-The other things about array,they are fixed size
		they are not dynamic.
		-So for using array for the back we are going to initialize size for the array
		-If we try to push something on the stack when the array is full then
		that obviously not going to work
		-Remember Top Is alaways contains the index of the next available position
		in the array


-Stack in JDK
 		-in the documentation is saying that instead of using the stack class
		we should use a class that implements the Deque interface
		-Deque can back with Array but we have to worry about resize the array then better to use
		 LinkedList because LinkedList implement Deques
		-If we use the LinkedList directly as a stack,somebody might come along
				perhaps a new developer,whos not familiar what we doing and start calling other method
				like add,indexOf stuff like that and we don't want that happen
				we want a class behave like a stack so you can only call push,pop and peek
		-ListIterator : this iterator traverses the list from head to tail and LinkedList
				implementation of stack the top item is always at the head
		-Time Complexity pop,push and peek is 0(1) Constant

Stacks Challange

	-Whats Palindrome ? palindrome is string that reads the sameway backwards as it does forwards
				for example "RaceCar" is palindrome (Bisa di baca di depan dbisa di baca di belakang)


-Queues
	Queues are abstract data type just like stacks,so they don't dicate you how to store
		the data,but they do decribe the way that you can access the data

		1.Queues ,Abstract data type
		2.Queues , Fist In First Out
		3.Queues , Add an also called ENQUEUE - ADD Item to the end of the queue
		4.Queues , Remove also called DEQUEUE - Remove the item at the front of the queue
		5.Queues , Peek get the item at the front of the queue, but don't remove it

		Notes :
		Just like stacks we use other data structures to implemenet them




-Queues Circular
		What is the difference linear queue and circular queue ?
		the main difference between linear queue and circular queue is that :
		-Linear queue arranges data in sequential order one after the other
		-Circular Queue arranges data similiar to circle by conecting the last element back to the first element

Example :
		Case we add two employee and then we remove one
		we add one we remove one add one remove one, and we keep alternating like that
		because in that case we never have more than two employees on the queue
		and so if we've created a queue of length 10 the queue should never need to be resized
		because we alaways have fewer employees,will that be the case ?

		ketika kita melakukan case delete add di atas
		memang hanya 2 employees saja yg di tampung di queue
		namun ketika kita add baru namun length sudah di 4 maka employee baru akan
		menambah length jadi 5 se hingga membutuh kan resize pada array
		namun masih ada space ksong pada array yg di atas length 4, seperti 1,2,3
		bayangkan jika array kita banyak maka akan men resize
		solusi nya gunakan queue circle  seperti contoh di bawah


	0.Jane
	1.John
	2.     (back)
	3.mike (front)
	4.bill

		then copy like this :

    0.Mike
	1.Bill
	2.Jane
	3.John
	4.     (Back)

-Queues JDK

	-ArrayBlockingQueue = this is bounded blocking queue does'nt resize the array, if thread tries to add an element
		into this queue it will block until some other thread has come along taken an element out of the queue
		oftern this type of queue is used in producer consumer scenario
		Example :
		-Message are being passed over network from a producer to consumer the producer or the sender adds message
		to the queue and the consumer or reciever will remove messages to the queue
		-If the producer,the sender tries to add message to queue and the queue was full its gonna block,until the reciever removed a message
		from the queue
	-Deque : Support insertion and removal at both end




===============Hash Table
		-Hash table is abstract data type like stack and queues

		Hash Tables :
		1.Abstract data type
		2.Provide access to data using keys
		3.Key doesn't have to be integer
		4.Consist of key/value pairs-data types don't have to match
		5.Optimized for retrieval(When you know the key)
		6.Associative array is one type of hash table

		Hashing
		1.Maps keys of any data type to an Integer
		2.Hash function map key to int
		3.in java , hash function is Object.hashCode()
		4.Collision occurs when more than one value has the same hashed value

		Notes :
		under the covers those keys are being converted to Integers
		One common way of backing hash table to use an array
		-to convert the keys to integers you hash the key and this is a process known as hashing
		-now in java hash function is hash cove and the object class has a hash code method
		-now it's possible that the hasing method may produce the same integer for more than one value
				and when that happens,it's known as Collision

		Load Factor
		1.Tell us how full a hash table is
		2.Load factor = # total items / capacity = size / capacity
		3.Load factor use to decide when to resize the array backing tha hash table
		4.Don't want load factor too low (lots of empty space)
		5.Don't want load factor too high (will increase the likelihood of collisions)
		6.Can play a role in determaining the time complexity for retrieval

		Explaination :

				-So lets say we are backing the hash table with an array the load factor will tell us how full the array is
				and we can get that by dividing the number of items by the capacity which is essentially,the size over capacity
				so if we had an array of 10 backing our hash table
				and we have five employees currently in hash table
				the load factor would be 0.5 so that tell us that our array is half full

				-So load factor is used to decide , when to resize the array backing the hashtable (Array as example)

				-we don't want load factor is too low because that means there's lots of empty space right
				i mean ,if your load factor is point 1 it means that only 10% of our array is occupied

				-but we don't want to be too high,because that will increase the likelihood collisions
				if most of the array is full,and you keep adding items your going to get collisions eventualy
				becasue you basically hasing the keys to a range of values


		-Add to hash table backed by an array
				1.Provide a key / value pair
				2.Use Hash function to hash the key to an int value
				3.Store the value at the hashed key value - this is the index into the array
		-Retrieve a value from hash table
				1.Provide the key
				2.Use the same hash function to hash the key to an int value
				3.Retrieve the value stored at the hashed keuy value

-Hash Table Array Implementation
				Hash table exist to provide speedy retrieval of data and we acomplish that by taking key

-Strategy to handle collisions
	1.the first one is called open addressing so with open addressing what we do , is if we put an employee into the table
		and we found out that there's already an employee at the slot where we wanna put the new employee
		then we look for another position in the array

		we are going to use whats called Linear Probing with Linear probing when we discover that a position
		for a hash key value that already occupied we increment hash value by one and then we check
		the resulting index

		so its called Linear Probing because each time we increment the index we're doing it in a linear fashion
		and every increment of the index is called probe

		Probing works if the position at the hashed value for the key
		is already occupied you keep incremental the index until you find empty spot

		and as you can see handling collisions,complicated things and it also affects performance
		if we have to use probing if there is a collisions then adding an item into
		the hash table is no longer constant time the worst case is linear,because its
		posible that we might have to search the entire table before we hit the last empty spot

Notes Linear Probing :

		When we use linear probing which mean we're incrementing the index we are checking by one
		we always end up putting the item in the first available position after the hashedkey value
		so lets say our hashkey value is five and we find out five is full
		so increment five to one and we got six if six full seven increment to eight and eight is
		empty "If any of those position five,six," +
		"seven had been empty then we would have put the employee into that position we would't have made" +
		"into position eight" so when we use linear probing we always end up putting the item in the first
		available position, so when get the item back so providing the key we are going tu use linear Probing
		again if we hit null value before we have found the item we are looking for
		we can be certain that the item is not in the table


-One variation is quadratic probing when you use quadratic probing instead
		of incrementing the hashed value by one , you increment it by some
		constant squared
		for example you start out by incrementing the hash value by one squared
		and then you increment it by two squared and then three squared et cetera.

=======Chaining
		we looked second strategy for dealing with collisions
		when we use chaining instead of storing the value directly
		into the array , each array position contains a LinkedList
		and so for our example, instead of storing the employees or stored Employee Instances
		we would store LinkedList and if we go add an Employee and the key that we use
		has hashed value that collides with the hashed value for another key well thats ok
		because at that position in the array theres a linked list and linked list don't have
		any boundaries they're  not bounded by size and we can just go ahead and add that
		second employee into the linked list at that array position so we never have the concept
		of oops ,sorry this array position is already filled and so we don't  have to worry
		about incrementing indices and all that stuff

		now of cource the drawback is there linkedlist at every position and so when you go to retrieve
		or delete an item you have to search the linkedList to find the item with the key
		you're interested in

		but if you have good hashing function and you have good load factor then these linkedlist
		will typically be short

		Using linkedlist makes the implementation easier because there's always room at the hashed
		location,but does't mean that chaining is better than Linear Probing
		in fact on average ,linear probing perform better than chaining does
		it just means that the implementation is little bit simpler


		so what do you think the time complexcity ?
		in the worst case all the instances would have the same hashed value
		and so lets say you had this really bad hashing function and it didnt matter
		what you gave it every single key hashed the value three that means every single item
		is going to be put in linkedlist at position three and so you want to retrieve something
		you potentially have to traverse every single item in hash table and so
		the worst case of chaining is linear time when you go to retrieve something but the key here
		no puh itending is the hashing algorithm

=======Hashtable and the JDK
		Explanation Map: now it says here a map cannot contain duplicate keys
		each key can map at most to one value now what this means is , it does not mean that there cannot
		be collisions,it's not talking about the hash values in our case, if we were to add
		an employee with key smith and then we added another employee and we also use the key smith
		the first employee that we added would be replaced by the second employee
		and hash table did not handle that kind of collisions
		-But our implementations, the two that we did for linear probing and chaining in the simple one
		they are not robust implementations , i mean if you were going to use those hashtable in real world
		application , then we would have a lot more work a lot to do i mean we are not handling resizing
		or anything like that,that's what this mean here "a map cannot contain duplicate keys"

		Explanation Hashmap :
		Hashmap implementation permits null values in the null key ? it says that is provides constant time
		for the basic operations.
		if it has to resize the array and do rehashing then you are not gonna get constant time
		the initial capacity and the load factor in Hashmap ,you can set the load factor you want ?
		that means when the load factor is exceeded the hashtable is resized the default 75
		the implementations is not synchronised ,what is synchronised? so if you wanna use for multiple threads
		they suggest that you wrap it using the collections.synchronizedMap method

		-putIfAbsent method = the putIfAbsent method will only insert new value if the value before has not been used
		-getOrDefault = method that lets you specify default value ,getOrdefault method returns if its null return this value

		-One of the Subclass of hashmap is linkedHashMap = Hash table and linked list implementation of the map interface
			now this does not mean that this implementation is backed by linkedlist
		-hashmap is array implementation
		-HashTable ,this is different with hashMap first of all you can't add null key or values hashMap allow null key and null
		values,so if you use hashtable everything got to be non null
		the second different is this is scynchronised


=======Bucket Sort
		Bucket Sort :
		1.Uses Hashing
		2.Make Assumptions about the data,like radix and counting sort
		3.Because it makes assumptions ,can sort in O(n) time
		4.Perform best when hashed values of items being sorted are evenly distributed, so there are not many collisions

		so when it comes in bucket sort we are hashing the values that we are sorting so there is no concept of keys and values
		the important thing when it becomes to bucket sort is the values that we are sorting are hashed
		how does it work?
		1.Distribute the items into buckets based on their hashed values(scatterring phase)
		2.Sort the item in each bucket
		3.Merge the buckets - can just concatenate them (gathering phase)


		A generalization of counting sort ,because if you remember counting sort we went through the values and then we distributed the values
		into the counting array and then in the final phase we just traversed the counting array and for ach value we copied how many we had back
		into the original array

		and so bucket sort is doing something similiar execept its distributing the items based on their hashed values and then it has to sort
		the items each bucket but then it goes over the buckets and copies them back into original array

		one important thing here :

		the values in the bucket x must be greater than the values in bucket x-1 and less than the values in bucket X +1

		this means that the hash function we use must meet this requirement

		===Bucket Sort Time Complexity
		1.Not in place Algorithm
		2.Stability will depend sort algorithm use to sort buckets - ideally,you want stable sort
		3.To achive O(n) must have only one item per bucket
		4.Insertion Sort is often used to sort the buckets,because it is fast when the number of item is small


		=====Bucket sort=====
		1.Create Bucket
		2.Hashed the value scattering phase
		3.Sort
		4.Copy value


		Remember to this to work values in buckets in that are in lower position in the array have to be smaller than values in higher in bucket position
		in the array



==========Search Algorithm=========
		Well search algorithm will find a value in a data structure
		you can use them to search linked list and other data structure
		the is one search algorithm that perform really well and so we are going to
		look at lenear search algorithm and then we are going to look at binary search algorithm

		Linear search = Incrementing index by one (you're basically just incrementing the index by one in lenear fashion you go from the beginning
		of the array to the end of the array and you're gonna either find the item you're looking for or you're going to hit the end of array)

		Time Complexity O(n),the worst case is that we are going to be looking for the very last item in the array
		which means we have to traverse the entire array which means it's going to take us in steps to get to that last item


===================Binary Search=================
		Binary search is pretty much the standard search algorithm but and there is a huge but, this is really important
		it Requires that data that it's searching be sorted ,and so you can only use Binary Search Algorithm on data has been sorted
		so if you want to use a search in array and an array has not been sorted then you're gonna have to sort this array first
		then you can use any of the sort algorithms that we have looked at the sort array and then you run the binary search
		on the sorted array.

		and that goes for any data structure,i mean if you wanna use Binary Search on linkedList then you have to sort
		the values in that link list.

		now if you know your application is going to be using binary search to do alot of searches
		then what you might consider doing is inserting items into whatever data structure you are using
		so that they are always in sorted order,so rather than sorting the array or whatever you are using
		every single time you wanna run a binary search if  you know you are going to be lot of searches
		then it might be better to just always make sure that the values in the data structure are always sorted

		ok what is Binary Search ?
		Well the way it works and we will use an array as example is that it chooses the element in the midle of the array
		and it compares it against the search value,Now if the element in the middle of the the array equals we are done right?
		because we found the value we looking for !
		now if it does not equal the search value then we have more work to do!
		So if the element is greater than the search value then we are gonna search the left half of the array
		and the reason for that is that the values are sorted
		and lets say the middle of the array is at index five and so we compare the value against the elemented
		index five well if that element is greater than search value then we know that the value we are searching for
		has to be in indeces zero to four,because the data is sorted
		and so the value at index five is greater than the value we are searching for that means that the values
		from indexes six up to the end of the array are gonna be greater than the one we are looking for
		so we need to search the left half of the array ,that where the values that are less than the middle element are located
		on the other hand if the middle element is less than the value that we are looking for then we wanna search the right half
		of the array

		and so thats binary search it basically starts out by dividing the array down the middle and then it always
		looks at the middle element and then depending on what the comparison result is less than greater than or equal to
		we have either finished or we are then only gonna focus on the right side or left side and then we run some repeat
		so middle element , and then only left side

		Conclusion :
		1.At Some point there will be only one element in partition you are checking,but it does not have to get that point
		2.Can be implemented recursively
		3.O(log n) keep dividing the array in half

========================Trees
		-now some people say trees are data structure and others say they are abstract data types
		-Trees dictate how organise the data
		-Unlike Arrays,LinkedList,stack and queues which are linear data structures trees are hierarhical data structre
		-top most node is called root of the tree
		-the elements that are directly un-der an element are called its children
		-the elements with no children are called leaves

		what is a tree ?
		well a tree is a hierarchical data structure
		every circle in the tree called a Node
		node can have children
		each node can have one and only one parent
		there is special node in every tree called the root (the root Node does not have a parent)
		every tree can have one and only root node

		why tree ?
		trees are ideal when things can contain other things
		-when you have a situation where items can contain other items or there is hierarchical relationship
		such that items can descend from other items trees are a good data structure to use
		-a leaf node has no children
		-if you have a tree with only one node in it ,its called singleton tree and of course in that case
		the only node would be the root
		-the arrow pointing to the child called Edge
		-A Path is the sequence of nodes required to go from one node to another
		-One important characteristic of trees is that you can not have cyclic paths
		and so we can not have a path the crosses a node more than ones
		-Now the depth of a node is the number of edges from the node to the root
		and so the root will always have a depth of zero because there are no edges on the path from the root to the root obviously
		-the height of node is the number of edges on the longest path from the node to a leaf
		-so when we figuring out Depth we start at the node and we work up to the root,and we say how many edges does it take
		-but when we talking about the height ,we are looking at what is the longest path from the node down to e leaf
		-depth calculating up the tree and counting the number of edges to the root
		-height we start at the node try figure out how many child (leaf)

		example of tree
		-java class extend
		-root file on the computer

========Binary Tree ===========
	So a Binary Tree is a tree in which every node has zero,one or two children and thats why its called binary tree
		because the maximum number of children a node can have it two

		-Binary tree is complete if every level execept the last level,has two children (Complete tree)
		-Full binary tree is complate tree as well but with full binary tree every node other than the leaves has to have two children

		* Binary Search Tree *
		1.Can perform insertions,deletions and retrievals in O(logn) Time
		2.The left child always has a smaller value than its parent
		3.The Right child always has a larger value than its parent
		4.This means everyhitng to the left of the root is less than the value of the root
			and everything to the right of the root is greater than the value of the root
		5.Because of that we can do binary search

		How about duplicate values in binary Search tree?
		-well there are a couple of approaches to this,some implementations just say they are not allowed
		-if you want to allow them one way to handle them is to always store duplicates either in the left subtree
		or the right subtree you have to choose one and stick with it!
		-a third approach is to have counter with each node ? and so rather than adding a separate node for duplicate value

		how would we build this tree?
		what insertion did we do to get this tree?
		now the order in which you insert the nodes is gonna influence how the tree ultimately looks

		important characteristic of to note for binary tree is you can get minimun value in the tree
		just by following the left edges
		if you want the maximum edges you do the same thing with the edges on the right

		ideally when you building binary search tree you try to keep the tree as balanced as posible
		that means that the heights of the left subtree and the right subtree do not difference by much

		AVL Trees ?
		red-black Trees ?

		to build a binary tree we are going to need to insert nodes
		and the we are gonna do it :
		if you come to insert a node if the tree is empty then the node
		becomes the root and we are done, if the tree is not empty
		we gonna compare the value we are inserting agains the root node
		if its less than the root node we are going to go to the left
		if its greater than the root node we are going to the right

	=====	traversal tree
		-Level - visit node on each level
		-Pre-order - visit the root of every sub tree first
		-Post-Order - visit the root of every sub tree last
		-In-Order - visit left child then root then right child


		-Level Traversal(this not used very often) start to level zero and then level one we move from left to right
		and then we go to level two and we move from left to right and we go to three
		and we move from left to right

		-Pre Order Traversal we always visit the root of a subtree first
		and then go to child from the left if there is no child go back to root last visited and go visit to the right (always start from the smallest)

		-in Order Traversal we completely visit the left side and start from the bottom left (smalest value) left child comes first
		in order data sorted

		-post order in post order the root goes last and so you visit the entire left subtree for a node and then the entire right sub tree for the node










Interview Review from the internet (Shopee)
		https://forthright48.com/interview-with-shopee-garena/
		https://www.glassdoor.sg/Interview/Shopee-Interview-Questions-E1263091.htm?filter.jobTitleExact=Software+Engineer%2C+Backend
		SEO : interview software engineer at shopee

		white board interview use : https://codebunk.com/b/7661100151143/
		https://beginnersbook.com/2017/09/java-program-to-reverse-words-in-a-string/#:~:text=Example%3A%20Program%20to%20reverse%20every,using%20a%20reverse%20for%20loop.


New English Vocabulary :

1.Discrete = berlainan
2.Inclusive = Termasuk
3.Traverse = Melintasi / melewati
4.figure out = mencaritau,memahami
5.Indices = Indeks
6.Substracting = pengurangan
7.Least = Paling Sedikit
8.Occupy = Menempati
9.Contiguouse = Berdekatan
10.Dictate = Mendikte
11.Oblivious = Terlupa
12.Examine = Memeriksa,Menguji,Membahas
13.Descend = Turun,Menuruni




english teacher : https://www.italki.com/teacher/3245298#readmore


Intellij hot key : https://www.jetbrains.com/help/rider/Keymaps_Comparison_Mac.html#top


=====Java Notes======

when to use for loop and while loop?

-you used use for loop when you know how many times the loop should run
-if you want to break the loop based on condition other than number its time it runs you should use while loop

-stack is memory to maintain method in app
-stacks are lifo (last in Firts Out) Objects meaning that the last item that was added to the top of the stack is the first one to be removed
from the stack
-Characters are actualy are numeric values
-ASCII a=97 b=98 ber urut sampai dengan Z , A=65 B=66  ber urut sampai Z
-charAt() returns the character at the specified index in String
 example :
				String hello ="Hello";
				char c=hello.charAt(0);
				resutl : H























