package may18th;

public class StrStr {
  public int strStr(String haystack, String needle) {
//    if (needle.length() == 0) {
//      return 0;
//    }
//    int index = -1;
//    int pointer = 0;
//    for (int i = 0; i < haystack.length(); i++) {
//      if (haystack.charAt(i) == needle.charAt(pointer)) {
//        if (pointer == 0) {
//          index = i;
//        }
//
//        if (++pointer == needle.length()) {
//          return index;
//        }
//
//      } else {
//        index = -1;
//        pointer = 0;
//      }
//
//    }
//    return pointer == needle.length() ? index : -1;
    return haystack.indexOf(needle);
  }
}
