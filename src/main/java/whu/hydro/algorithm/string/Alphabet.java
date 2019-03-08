package whu.hydro.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Alphabet
 * @Description TODO
 * @Author 86187
 * @Date 2019/3/8 19:21
 * @Version 1.0
 */
public class Alphabet {

    char[] str;
    Map cache;
    Alphabet(String s) {
        cache = new HashMap();
        int i = 0;
        for (char key:s.toCharArray()) {
            if (!cache.containsKey(key)) {
                cache.put(key,i++);
            }
        }
        str = new char[cache.size()];
        for (Object key: cache.keySet()) {
            str[(int)cache.get(key)] = (char)key;
        }
    }
    char toChar(int index) {
        return str[index];
    }

    int toIndex(char c) {
        return (int)cache.get(c);
    }

    boolean contains(char c) {
        return cache.containsKey(c);
    }

    int R() {
        return str.length;
    }

    int lgR() {
        return  0;
    }
}
