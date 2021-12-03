# Homework 4 (Programming)

Please remember that to submit the assignment you will need to go to the Education drop down menu and select assignment complete. Once you have marked the assignment as complete you will not be able to edit it again. You may use up to 48 late hours on this assignment.

If you submitted your assignment accidentally and need to reopen it, post a **private** message on Ed Discussion, including your UNI, with the tag “codio.”

Make sure to format and comment your code carefully and correctly based on the style we've been using in class.

## Problem 1 - 20 points

A year with 366 days is called a leap year. Leap years are necessary to keep the calendar synchronized with the sun because the earth revolves around the sun once every 365.25 days. Actually, the figure is not entirely precise, and for all dates after 1582 the *Gregorian correction* applies. Usually years that are divisible by 4 are leap years, for example 1996. However, years that are divisible by 100 (for example, 1900) are not leap years, but years that are divisible by 400 are leap years (for example, 2000). Write a program that asks the user for a year and computes whether the year is a leap year.  Provide a class Year with a method *isLeapYear*. Use a single if statement and Boolean operators.

I have provided templates for a class Year and a test class LeapYearTester on Codio. You must use the template and you must not alter the test class.

## Problem 2 - 30 points

The Drunkard's (Random) Walk. Imagine you live on an infinite grid of streets where locations are represented as integer pairs (avenue,street). Negative numbers are okay in this example. Now consider a drunkard that randomly picks one of four directions at an intersection and then stumbles to the next intersection doing the same and so on. Write a class Drunkard to simulate this behavior given the drunkard's initial position. Your Drunkard class should have as instance variables the drunkard's current avenue (x location) and current street (y location). Your class should have a method called step( ) that moves the drunkard to the next randomly chosen adjacent intersection. Your class should have another method called fastForward(int steps) that takes an integer as a parameter (call it steps) and moves the drunkard steps intersections from his current location. Your class should have a method getLocation( ) that returns a String indicating the drunkard's current location. Finally your class should have a method called howFar( ) that reports the drunkards distance in blocks from where he started calculated using the Manhattan distance metric.

You will find a test class called DrunkardTester on Codio. Your Drunkard class must work with the test class provided without modification. You must NOT alter the test class.

I've also placed a completely empty Drunkard.java file for you to fill out.

Note that the definition of Manhattan distance is: 

"The distance between two points in a grid based on a strictly horizontal and/or vertical path (that is, along the grid lines), as opposed to the diagonal or "as the crow flies" distance. The Manhattan distance is the simple sum of the horizontal and vertical components, whereas the diagonal distance might be computed by applying the Pythagorean theorem."