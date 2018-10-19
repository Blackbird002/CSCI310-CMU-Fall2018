# CSCI310-CMU-Fall2018
Repository for CSCI 310 Java @ CMU

## Welcome to Riad Shash (Ray's) CSCI 310 - Java Code Repository Dr. MacEvoy!
<br>

## Assignment#1 is in the Assignment1 (Kattis Problem) folder
Link to repository: https://github.com/Blackbird002/CSCI310-CMU-Fall2018/tree/master/Assignment1
<br>

## Assignment#2 is in the CustomerWaitSimulator folder
Link to respository: https://github.com/Blackbird002/CSCI310-CMU-Fall2018/tree/master/CustomerWaitSimulator/src

**Idea:**
Every time I am in the grocery store, I often think about how much time we spend waiting in line  My idea was to create a grocery store simulation. I generate customer objects  (20 in this case, it  can be changed) and assign each one a randomly generated processing time (in seconds simulated by CPU ticks). 
Before the simulation starts, the generated customers are put int a big queue called checkOutCustomers. Then once the simulation starts, customers go to either Reg1, Reg2, or Reg3 cash register queues depending on which one is available. I set it so that each queue line is size 5 max. The customers get put into the cash registers queues by checking if Reg1, Reg2 and finally Reg3 are less than 5. Customers that are on top of the queue get their processing time decremented. Meanwhile, everyone’s wait time gets incremented every CPU tick. Once a customer is done being processed, (processing time is 0) they get popped out of the queue and added to the checkedOutCustomers linkedList. The simulation ends when all the customers are out of the checkOutCustomers queue, Reg1, Reg2, Reg3 cash register queues and all of them are in checkedOutCustomers. 

**Testing the Customer class:**
<br>
<img src="/CustomerWaitSimulator/CustomerClassTests.PNG">

**Testing the WaitSimulator class:**
<br>
<img src="/CustomerWaitSimulator/WaitSimulatorClassTests.PNG">

## Assignment#3 is in the CustomerWaitSimulator folder
Link to respository: https://github.com/Blackbird002/CSCI310-CMU-Fall2018/tree/master/Assignment3/src



