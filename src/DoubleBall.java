import java.util.ArrayList;
import java.util.Random;

/**
 * 双色球随机算法类
 * 
 * @author zhengyi.wzy
 * 
 */
public class DoubleBall {
    public static void main(String args[]) {
        // 获取红球
        ArrayList<Integer> redBalls = getBalls(1, 33, 6);

        // 获取蓝球
        ArrayList<Integer> buleBalls = getBalls(1, 16, 1);

        // 打印输出
        System.out.println("本期双色球中奖号码为：" + redBalls + ", " + buleBalls);
    }

    private static ArrayList<Integer> getBalls(int min, int max, int size) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> stores = new ArrayList<Integer>();
        for (int i = min; i <= max; i++) {
            stores.add(i);
        }

        for (int i = 0; i < size; i++) {
            int index = getRandomIndex(stores.size() - i);
            result.add(stores.get(index));
            swapNumbers(stores, index, stores.size() - i - 1);
        }

        return result;
    }

    private static int getRandomIndex(int max) {
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt(max);
    }

    private static void swapNumbers(ArrayList<Integer> stores, int index, int last) {
        int tmp = stores.get(index);
        stores.set(index, stores.get(last));
        stores.set(last, tmp);
    }
}
