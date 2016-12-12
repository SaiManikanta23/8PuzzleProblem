Name: Sai Manikanta Godavarthi
WSU ID: J989E647
Artificial Intelligence Programming Assignment I
Eight puzzle Problem / N-puzzle Problem

I have tried both 8-puzzle and N-puzzle problem and in N-puzzle problem the goal state is fixed with blanck at the end of N-Matrix

Steps for Execution of 8-puzzle problem:

This is a python script with inputs provided in the code and can be updated according to the requirement.

Execution : 
>>> python MySolution.py


Steps for changing Goal State and Initital State.

1. The goal state and Initial state can be given values randomly from 0-8 seperated by commas and 0 being the blanck
2. The program requests the goal state and the goal state can be entered as "[values seperated by commas and 0 is blank]". For example 
if we want goal state is of the form 

1 2 3
4 5 6
7 8 0

then give the value of the goal state as "[1,2,3,4,5,6,7,8,0]"

4. similiarly if we want to update the intial state then update the value of initial_state can be entered as "[values seperated by commas and 0 is blank]". For example if the goal state
if we want intial state is of the form 

1 2 3
4 0 5
6 7 8

then give the value as "[1,2,3,4,0,5,6,7,8]"

5.According to the input the program executes and displays the steps taken to reach the goal state from intial state displaying each of the steps as output;
based on the input values provided the time for execution varies.

6. For the given example in the Assignment question paper the code enters infinite loop and get struck in between. 
i.e. if given input has sum of odd number.(i.e., for example the given input is 4, 2, 5, 3, blank, 1, 6, 7, 8
the sum is caluculated as the numbers that are less than it's value place on the right gives the value, in the above 
data 4 has value 3 because the number that are less than 4 which places on the right they are 3 for 2 it's 1, 5 it's 2 
3 it's 1, blank we won't caluculate for 1,6,7,8 the value is zero. Adding all this values which is 3+1+2+1=7 give odd 
value(7) therefore, for this example the solution doesn't exits. If sum of these is even then solution exits, for example 
data is 1, 2, 3, 4, 0(blanck), 5, 6, 7, 8 the sum of these is even and solution exits

Example output and program execution:::


>>> python MySolution.py

================== RESTART: D:\FinalSolution\MySolution.py ==================

Enter the goal state values in []  seperated by commas; 0 being the blank:::[0,1,2,3,4,5,6,7,8]
Enter the intial state values in []  seperated by commas; 0 being the blank:::[1,2,3,4,5,6,0,7,8]

Step 0 : None
1 2 3
4 5 6
0 7 8

Step 1 : right
1 2 3
4 5 6
7 0 8

Step 2 : up
1 2 3
4 0 6
7 5 8

Step 3 : right
1 2 3
4 6 0
7 5 8

Step 4 : up
1 2 0
4 6 3
7 5 8

Step 5 : left
1 0 2
4 6 3
7 5 8

Step 6 : left
0 1 2
4 6 3
7 5 8

Step 7 : down
4 1 2
0 6 3
7 5 8

Step 8 : right
4 1 2
6 0 3
7 5 8

Step 9 : right
4 1 2
6 3 0
7 5 8

Step 10 : up
4 1 0
6 3 2
7 5 8

Step 11 : left
4 0 1
6 3 2
7 5 8

Step 12 : down
4 3 1
6 0 2
7 5 8

Step 13 : down
4 3 1
6 5 2
7 0 8

Step 14 : left
4 3 1
6 5 2
0 7 8

Step 15 : up
4 3 1
0 5 2
6 7 8

Step 16 : up
0 3 1
4 5 2
6 7 8

Step 17 : right
3 0 1
4 5 2
6 7 8

Step 18 : right
3 1 0
4 5 2
6 7 8

Step 19 : down
3 1 2
4 5 0
6 7 8

Step 20 : left
3 1 2
4 0 5
6 7 8

Step 21 : left
3 1 2
0 4 5
6 7 8

Step 22 : up
0 1 2
3 4 5
6 7 8

Steps for Executing N-Puzzle problem:

The N-puzzle problem takes the input of any size and display the result accordingly.The goal state is fixed with blanck at the end and the remaining values arranged
accordignly. This is a python language code.

Steps for Execution:

1. The Initial state can be given values randomly from 0-8 seperated by commas and 0 being the blanck and each line values arranged seperately in '()' as shown below

 For example: if we want our input to be of the form
4 6 0
5 2 3
1 7 8

then the input for the program is given as

((4,6,0), (5,2,3), (1,7,8))

Few examples are provided at the top of program and can be seen when executed.



5.According to the input the program executes and displays the steps taken to reach the goal state from intial state displaying each of the steps as output;
based on the input values provided the time for execution varies.

6. For the given example in the Assignment question paper the code enters infinite loop and get struck in between. 
i.e. if given input has sum of odd number.(i.e., for example the given input is 4, 2, 5, 3, blank, 1, 6, 7, 8
the sum is caluculated as the numbers that are less than it's value place on the right gives the value, in the above 
data 4 has value 3 because the number that are less than 4 which places on the right they are 3 for 2 it's 1, 5 it's 2 
3 it's 1, blank we won't caluculate for 1,6,7,8 the value is zero. Adding all this values which is 3+1+2+1=7 give odd 
value(7) therefore, for this example the solution doesn't exits. If sum of these is even then solution exits, for example 
data is 1, 2, 3, 4, 0(blanck), 5, 6, 7, 8 the sum of these is even and solution exits

Example output and program execution:::


>>> python NPuzzleAiMysolution.py

Result:

>>> ============== RESTART: D:\FinalSolution\NPuzzleAiMysolution.py ==============
Example values :::: ((4,6,0), (5,2,3), (1,7,8))
Example values :::: ((8,0,5), (1,7,2), (6,4,3))
Example values :::: ((10,5,1,3), (7,11,2,12), (13,9,8,4), (6,15,0,14))
Enter the initial state values in ()  seperated by commas and 1 line values in (), second line values in()..; 0 being the blank::: example ((8,0,5), (1,7,2), (6,4,3)): please remember that the goal state for this code is getting blanck at the last position and is fixed:::    ((10,5,1,3), (7,11,2,12), (13,9,8,4), (6,15,0,14))
Starting grid:
(10, 5, 1, 3)
(7, 11, 2, 12)
(13, 9, 8, 4)
(6, 15, 0, 14)

Move 1 into place. In 10 moves
(1, 0, 2, 3)
(10, 7, 5, 12)
(13, 11, 9, 4)
(6, 15, 8, 14)

Move 2 into place. In 1 moves
(1, 2, 0, 3)
(10, 7, 5, 12)
(13, 11, 9, 4)
(6, 15, 8, 14)

Move 3 into place. In 1 moves
(1, 2, 3, 0)
(10, 7, 5, 12)
(13, 11, 9, 4)
(6, 15, 8, 14)

Move 4 into place. In 9 moves
(1, 2, 3, 4)
(10, 7, 5, 0)
(13, 11, 12, 9)
(6, 15, 8, 14)

Move 5 into place. In 10 moves
(1, 2, 3, 4)
(5, 0, 11, 9)
(10, 13, 7, 12)
(6, 15, 8, 14)

Move 6 into place. In 11 moves
(1, 2, 3, 4)
(5, 6, 13, 9)
(15, 0, 11, 12)
(10, 8, 7, 14)

Move 7 into place. In 7 moves
(1, 2, 3, 4)
(5, 6, 7, 13)
(15, 11, 0, 9)
(10, 8, 14, 12)

Move 8 into place. In 15 moves
(1, 2, 3, 4)
(5, 6, 7, 8)
(15, 14, 9, 0)
(10, 11, 12, 13)

Move 9 into place. In 21 moves
(1, 2, 3, 4)
(5, 6, 7, 8)
(9, 10, 14, 12)
(13, 0, 15, 11)

Move 10 into place. In 15 moves
(1, 2, 3, 4)
(5, 6, 7, 8)
(9, 10, 12, 15)
(13, 14, 0, 11)

Move 11 into place. In 5 moves
(1, 2, 3, 4)
(5, 6, 7, 8)
(9, 10, 11, 12)
(13, 14, 15, 0)

Move 12 into place. In 2 moves
(1, 2, 3, 4)
(5, 6, 7, 8)
(9, 10, 11, 12)
(13, 14, 15, 0)

>>> 

