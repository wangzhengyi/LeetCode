import java.util.Scanner;

public class IntegerToRoman {
    public static void main(String[] args) {
        int num;
        Scanner cin = new Scanner(System.in);
        
        while (cin.hasNext()) {
            num = cin.nextInt();
            
            String str = intToRoman(num);
            System.out.println(str);
        }
        
        cin.close();
    }
    
    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        char[] roman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        
        int digit, base = 1000;
        
        for (int i = roman.length + 1; i >= 0 && num > 0; i -= 2, base /= 10) {
            digit = num / base;
            
            
            if (digit == 0) {
                continue;
            } else if (digit <= 3) {
                for (int j = 0; j < digit; j ++) {
                    result.append(roman[i - 2]);
                }
            } else if (digit == 4) {
                result.append(roman[i - 2]);
                result.append(roman[i - 1]);
            } else if (digit <= 8) {
                result.append(roman[i- 1]);
                for (int j = digit - 5; j > 0; j --) {
                    result.append(roman[i - 2]);
                }
            } else if (digit == 9) {
                result.append(roman[i - 2]);
                result.append(roman[i]);
            }
            
            num = num % base;
        }
        
        
        return result.toString();
    }
    
}
