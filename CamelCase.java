import java.lang.StringBuilder;

public class CamelCase {

    public static String toCamelCase(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!string.contains("-")) {

            String[] str = string.split("_");
            stringBuilder.append(str[0]);

            for (int i = 1; i < str.length; i++) {
                StringBuilder strBuilder = new StringBuilder();
                String[] str2 = str[i].split("");
                str2[0] = str2[0].toUpperCase();

                for (int j = 0; j < str2.length; j++) {
                    strBuilder.append(str2[j]);
                }

                stringBuilder.append(strBuilder.toString());
            }

            return stringBuilder.toString();
        }

        String[] str = string.split("-");
        stringBuilder.append(str[0]);

        for (int i = 1; i < str.length; i++) {
            StringBuilder strBuilder = new StringBuilder();
            String[] str2 = str[i].split("");
            str2[0] = str2[0].toUpperCase();

            for (int j = 0; j < str2.length; j++) {
                strBuilder.append(str2[j]);
            }

            stringBuilder.append(strBuilder.toString());
        }

        return stringBuilder.toString();
    }
}
