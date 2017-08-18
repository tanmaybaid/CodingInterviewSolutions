package com.tb.coins;

public class SubstringCheck {
  public static void main(String[] args) {
    final String str1 = "india";
    final String str2 = "in";

    final boolean isSubstring = isSubstring(str1, str2);
    System.out.printf("Is '%s' substring of '%s'? %s", str1, str2, isSubstring);
  }

  private static boolean isSubstring(final String str1, final String str2) {
    if ((str1 == null) || (str2 == null) || (str1.isEmpty()) || (str2.isEmpty())) {
      return true;
    }

    if (str1.length() < str2.length()) {
      return false;
    }

    int count = 0;
    for (int i = 0; i < str1.length(); i++) {
      if (str1.charAt(i) == str2.charAt(count)) {
        count++;
      } else if (count > 0) {
        count = 0;
        i--;
      }

      if (count == str2.length()) {
        return true;
      }
    }

    return false;
  }
}
