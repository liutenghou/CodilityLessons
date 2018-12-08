import java.util.Arrays;

public class CodilityPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("testing");
//		System.out.println(findBinaryGap(133342));
		int[] input = {1,2,3,4};
//		System.out.println(rotateRight(input, 3));
		int[] input2 = {2};
//		System.out.println(permMissingElem(input2));
		int[] input3 = {2,3,4};
		System.out.println(daysOfWeek("Wed", 12));
		
	}
	
	//find day of week that is K days after S day of week
	static String daysOfWeek(String S, int K) {
		
		String returnDay = S;
		
		java.util.Map<String, Integer> dateIndexMap = new java.util.HashMap<String, Integer>();
		dateIndexMap.put("Mon", 0);
		dateIndexMap.put("Tue", 1);
		dateIndexMap.put("Wed", 2);
		dateIndexMap.put("Thu", 3);
		dateIndexMap.put("Fri", 4);
		dateIndexMap.put("Sat", 5);
		dateIndexMap.put("Sun", 6);
		
		java.util.Map<Integer, String> intIndexMap = new java.util.HashMap<Integer, String>();
		intIndexMap.put(0, "Mon");
		intIndexMap.put(1, "Tue");
		intIndexMap.put(2, "Wed");
		intIndexMap.put(3, "Thu");
		intIndexMap.put(4, "Fri");
		intIndexMap.put(5, "Sat");
		intIndexMap.put(6, "Sun");
		
		//edge case
		if(!dateIndexMap.containsKey(S)) {
			return returnDay;
		}
		if(K < 1) {
			return returnDay;
		}
		
		//get the start
		
		int dayOfWeek = (K + dateIndexMap.get(S)) % 7;
		returnDay = intIndexMap.get(dayOfWeek);
		
		return returnDay;
		
	}
	
	static int smallestPossibleInteger(int[] A) {
		//edge cases
		if(A == null || A.length == 0) {
			return 1;
		}
		
		int smallestInt = 1;
		
		java.util.Arrays.sort(A);
		
		for(int i=0; i<A.length; i++) {
			int num = A[i];
			if(num < 1) {
				continue;
			}
			
			if(num == smallestInt-1) { //duplicate
				continue;
			}
			
			if(num == smallestInt) {
				smallestInt++;
				continue;
			}else {
				break;
			}
		}
		return smallestInt;
	}
	
	static int permMissingElem(int[] a) {
		int missingNo = 0;
		int aSize = a.length;
		//edge cases
		if(aSize < 1 || a == null) {
			return 1;
		}
		int[] allA = new int[aSize + 2];
		for(int i=0; i<aSize; i++) {
			int val = a[i];
			allA[val] = val;
		}
		System.out.println("new array: " + java.util.Arrays.toString(allA));
		
		missingNo = 1;
		for(int i=1; i<allA.length; i++) {
			if(allA[i] == 0) {
				break;
			}else {
				missingNo++;
			}
		}
		return missingNo;
	}
	
	static int[] rotateRight(int[] preRotateArray, int timesToRotate) {
		
		//check edgecase
		if(preRotateArray == null) {
			return preRotateArray;
		}
		if(timesToRotate < 1) {
			return preRotateArray;
		}
		
		int sizeOfArray = preRotateArray.length;
		//check edgecase
		if(sizeOfArray == 1 || sizeOfArray == 0) {
			return preRotateArray;
		}
		
		int lastElement = preRotateArray[sizeOfArray-1];
		System.out.println("lastElement: " + lastElement);
		int[] rotatedArray = new int[sizeOfArray];
		
		for(int i=0; i<timesToRotate; i++) {
			rotatedArray[0] = lastElement;
			System.out.println("preRotateArray: " + Arrays.toString(preRotateArray));
			System.out.println("rotatedArray: " + Arrays.toString(rotatedArray));
			for(int j=1; j<sizeOfArray; j++) {
				rotatedArray[j] = preRotateArray[j-1];
			}
			
			lastElement = rotatedArray[sizeOfArray-1];
			System.out.println("lastElement: " + lastElement);
			preRotateArray = rotatedArray.clone();  
			
		}
		
		return rotatedArray;
	}

	static int findBinaryGap(int decimalNumber) {
		int mask = 1;

		// keep track
		boolean touchedOnce = false;
		int biggestGap = 0;
		int latestGap = 0;

		for (int i = 0; i < 32; i++) {
			int isOne = decimalNumber & mask;

			if (isOne == 1) {
				if (touchedOnce) {
					if(biggestGap < latestGap) {
						biggestGap = latestGap;
					}
					latestGap = 0;
				} else {
					touchedOnce = true;
				}
			} else { // is zero
				if (touchedOnce) {
					latestGap++;
				}
			}

			// move over
			decimalNumber = decimalNumber >> 1;
		}
		return biggestGap;
	}

}
