public class NextPermutation {
    public static void nextPermutation(int[] num) {
        // special case
        if (num == null || num.length <= 1) {
            return;
        }

        // find the partition number which violate the increase trend
        int partition, swapLoc;
        for (partition = num.length - 1; partition - 1 >= 0; partition--) {
            if (num[partition - 1] < num[partition]) {
                break;
            }
        }

        partition -= 1;

        // find the first digit which large than Partition number
        if (partition >= 0) {
            for (swapLoc = num.length - 1; swapLoc > partition; swapLoc--) {
                if (num[swapLoc] > num[partition]) {
                    break;
                }
            }

            // swap partition number and change number
            int tmp = num[partition];
            num[partition] = num[swapLoc];
            num[swapLoc] = tmp;
        }

        // reverse all the digit on the right of partition index
        for (int i = partition + 1, j = num.length - 1; i < j; i++, j--) {
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
        }
    }
}
