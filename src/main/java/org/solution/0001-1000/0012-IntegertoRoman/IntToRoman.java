@SuppressWarnings("all")
public class IntToRoman {
    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] nums = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        while (num > 0) {
            for (int i = nums.length - 1; i >= 0; ) {
                if (num - nums[i] >= 0) {
                    num -= nums[i];
                    stringBuilder.append(roman(nums[i]));
                } else {
                    i--;
                }
            }
        }
        return stringBuilder.toString();
    }


    public String roman(int num) {
        return switch (num) {
            case 1 -> "I";
            case 4 -> "IV";
            case 5 -> "V";
            case 9 -> "IX";
            case 10 -> "X";
            case 40 -> "XL";
            case 50 -> "L";
            case 90 -> "XC";
            case 100 -> "C";
            case 400 -> "CD";
            case 500 -> "D";
            case 900 -> "CM";
            case 1000 -> "M";
            default -> throw new IllegalStateException("Unexpected value: " + num);
        };
    }

    public static void main(String[] args) {
        IntToRoman roman = new IntToRoman();
        System.out.println(roman.intToRoman(1994));
    }
}