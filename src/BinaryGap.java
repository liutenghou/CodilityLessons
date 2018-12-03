
public class BinaryGap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("testing");
		System.out.println(findBinaryGap(133342));
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
