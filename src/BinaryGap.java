import java.util.Arrays;

public class BinaryGap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("testing");
//		System.out.println(findBinaryGap(133342));
		int[] input = {1,2,3,4};
		System.out.println(rotateRight(input, 3));
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
