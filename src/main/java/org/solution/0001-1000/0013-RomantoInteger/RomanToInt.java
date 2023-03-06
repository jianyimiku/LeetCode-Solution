@SuppressWarnings("all")
class RomanToInt {
    public int romanToInt(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if ((romanInt(chars[i + 1]) / romanInt(chars[i]) == 5) ||
                    romanInt(chars[i + 1]) / romanInt(chars[i]) == 10) {
                count -= romanInt(chars[i]);
            } else {
                count += romanInt(chars[i]);
            }
        }
        count += romanInt(chars[chars.length - 1]);
        return count;
    }


    public int romanInt(Character c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> {
                throw new RuntimeException("Error");
            }
        };
    }


    public static void main(String[] args) {
        RomanToInt toInt = new RomanToInt();
        System.out.println(toInt.romanToInt("MCMXCIV"));
    }
}