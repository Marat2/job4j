package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class EndsWith {

    /**
     * Проверяет. что слово начинается с префикса.
     * @param post префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean endsWith(String word, String post) {
        boolean result = true;
        char[] pst = post.toCharArray();
        char[] wrd = word.toCharArray();
        for (int x = 0; x < pst.length; x++) {
            if (wrd[wrd.length - pst.length + x] != pst[x]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
