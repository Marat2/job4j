package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class ArrayChar {
    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean startsWith(String word, String prefix) {
        boolean result = true;
        char[] pref = prefix.toCharArray();
        char[] wrd = word.toCharArray();
        for (int x=0;x<pref.length;x++){
            if (pref[x]==wrd[x]) {
                continue;
            }else{
                result=false;
                break;
            }
        }
        return result;
    }
}
