package com.yangyi.code;

public class StringUtils {

    /**
     * Delete any character in a given {@code String}.
     *
     * @param inString the original {@code String}
     * @param charsToDelete a set of characters to delete. E.g. "az\n" will delete 'a's, 'z's and new lines.
     * @return the resulting {@code String}
     */
    public static String deleteAny(String inString, String charsToDelete) {
        if (!hasLength(inString) || !hasLength(charsToDelete)) {
            return inString;
        }

        StringBuilder sb = new StringBuilder(inString.length());
        for (int i = 0; i < inString.length(); i++) {
            char c = inString.charAt(i);
            if (charsToDelete.indexOf(c) == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }

    public static boolean hasLength(StringUtils str) {
        return hasLength((CharSequence) str);
    }


    public String delete(String inString, String delete) {
        if (!hasLength(inString) || !hasLength(delete)) {
            return inString;
        }

        StringBuilder sb = new StringBuilder(inString.length());

        for (int i = 0; i < inString.length(); i++) {
            char c = inString.charAt(i);
            if (delete.indexOf(c) == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
