package job4j.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }
//проверяет есть ли в поле выигрышные комбинации для Крестика
    public boolean isWinnerX() {
        return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0) || this.fillBy(Figure3T::hasMarkX, 0, 1, 1, 0) || fillBy(Figure3T::hasMarkX, 0, 2, 1, 0) ||//строки
                 this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1) || this.fillBy(Figure3T::hasMarkX, 1, 0, 0, 1) || fillBy(Figure3T::hasMarkX, 2, 0, 0, 1) ||//столбцы
                 this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 1) || this.fillBy(Figure3T::hasMarkX, this.table.length - 1, 0, -1, 1);
    }
//проверяет есть ли в поле выигрышные комбинации для Нолика
    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0) || this.fillBy(Figure3T::hasMarkO, 0, 1, 1, 0) || fillBy(Figure3T::hasMarkO, 0, 2, 1, 0) ||
                this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1) || this.fillBy(Figure3T::hasMarkO, 1, 0, 0, 1) || fillBy(Figure3T::hasMarkO, 2, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 1) || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1);
    }
    public boolean fillBy(Predicate<Figure3T> pred, int startX, int startY, int deltaX, int deltaY){
        boolean result = true;
        for (int i=0;i!=this.table.length;i++){
            Figure3T cell = table[startX][startY];
            startX+=deltaX;
            startY+=deltaY;
            if (!pred.test(cell)){
                result = false;
                break;
            }
        }
        return result;
    }
//проверяет, если ли пустые клетки для новых ходов
    public boolean hasGap() {
        return true;
    }
}
