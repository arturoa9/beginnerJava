package evaluation;
import java.util.*;
import java.io.*;

/*
 * write a java program that finds the closest palindrome given an int by the user
 * this program finds the next greater and lesser palindrome from a user input and then compares them
 * to find the next closest int and returns it
 */
public class secondEval {

	public static void main(String[] args) {
		
		Scanner sca = new Scanner(System.in);//start scanner
		
		int pal = sca.nextInt();//scan user input
				
		int upPali = findPaliUP(pal);//send input to method to check the closest palindrome going up or adding
		int downPali = findPaliDown(pal);//send input to method to check the closest palindrome going down or subtracting
		
		int answer = compareInts(upPali, downPali, pal);//compare the ints to see which is the closest to user input
		
		System.out.println(answer);//print answer
	}

	/*
	 * method to check if a given int is a palindrome
	 */
	public static boolean isPali (int num) 
	{
		boolean boo = true;//initiate boolean to return
		String s = Integer.toString(num);//convert the int to a String
		char [] cArr = s.toCharArray();//Convert String to char array to iterate
		

		for (int i = 0; i < (cArr.length)/2;i++) //for loop to iterate through the array and compare values
		{
			if(cArr[i] != cArr[(cArr.length-1)-i]) 
			{
				boo = false;//if one value does not match the other value change boolean to false
			}
		}	
		return boo;//return boolean
	}
	
	/*
	 * method to check the next palindrome going up or adding from the user input
	 */
	public static int findPaliUP (int i) 
	{
		
		int answer = i;
		
		if (isPali(answer)) //base case, if the int is a palindrome return the int
		{
			return answer;
		}
		return (findPaliUP(answer+=1));//else recursively add 1 to the number and check if it is a palindrome
		
	}
	
	/*
	 * method to check the next palindrome going down or subtracting from the user input
	 */
	public static int findPaliDown (int i) 
	{
		
		int answer = i;
		
		if (isPali(answer)) //base case, if the number is a palindrome return that number
		{
			return answer;
		}
		return (findPaliDown(answer-=1));//else recursively subtract one and iterate to find the next palidrome
		
	}
	
	/*
	 * method to check the difference between the two closest palindromes.
	 * returns the number with the smallest difference between it and the user input
	 */
	public static int compareInts(int numPlus, int numMinus, int num) 
	{
		int difference1 = numPlus - num;//find the difference of the next greater palindrome 
		int difference2 = num - numMinus;// find the difference of the next lesser palindrome
		
		if (difference2 > difference1) 
		{
			return numPlus;//return the next greatest palindrome if the difference from it to the input is less than the difference to the lesser palindrome
		}
		else
			return numMinus;//return the next lesser palindrome if the difference from it to the input is less than the difference to the greater palindrome		
	}
	
	

}
