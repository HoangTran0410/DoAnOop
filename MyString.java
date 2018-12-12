
package DoAnOop;

public class MyString {
    
    static String toUpperCaseFirstLetter_AllWord(String strs) {
        String result = "";
        String[] parts = strs.split(" ");
        
        for(int i = 0; i < parts.length; i++) {
            result += toUpperCaseFirstLetter(parts[i]) + (i==parts.length-1?"":" ");
        }
        return result;
    }
    
    static String toUpperCaseFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
