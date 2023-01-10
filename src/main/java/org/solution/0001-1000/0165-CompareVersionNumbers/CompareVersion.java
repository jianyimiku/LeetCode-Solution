
@SuppressWarnings("all")
public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        int var1 = 0;
        int var2 = 0;
        int var3 = 0;
        int var4 = 0;
        int m = version1.length();
        int n = version2.length();
        while (var1 < m && var2 < n) {
            // 移动var3到第一个'.'或者到了结尾
            while (var3 < m && version1.charAt(var3) != '.') {
                var3++;
            }

            while (var4 < n && version2.charAt(var4) != '.') {
                var4++;
            }

            int res = compare(version1.substring(var1, var3), version2.substring(var2, var4));

            if (res == 1 || res == -1) {
                return res;
            }

            var3++;
            var4++;
            var1 = var3;
            var2 = var4;
        }

        while (var1 < m) {
            if (version1.charAt(var1) > '0') {
                return 1;
            }
            var1++;
        }

        while (var2 < n) {
            if (version2.charAt(var2) > '0') {
                return -1;
            }
            var2++;
        }

        return 0;
    }

    /**
     * 比较var1 var2大小
     *
     * @param var1
     * @param var2
     * @return
     */
    private int compare(String var1, String var2) {
        return Integer.compare(Integer.parseInt(var1), Integer.parseInt(var2));
    }


    public static void main(String[] args) {
        CompareVersion version = new CompareVersion();
        System.out.println(version.compareVersion("0.1", "1.1"));
    }
}