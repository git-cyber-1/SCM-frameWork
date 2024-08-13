package com.comcast.scm.listenerUtility;

public class ForGit {
	    public static void main(String[] args) {
	        int[] arr = {12, 34, 54, 2, 3, 76, 98, 11};
	        int max = 0;
	        int secondMax = 0;

	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] > max) {
	                secondMax = max;
	                max = arr[i];
	            } else if (arr[i] > secondMax && arr[i]!= max) {
	                secondMax = arr[i];
	                System.out.println(arr[i]);
	            }
	        }

	       
	    }
	}
	
	



