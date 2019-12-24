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
//Stream<Figure3T[]> stream1 = Arrays.stream(this.table);
//stream1.forEach(x -> Arrays.stream(x).forEach(y->System.out.println(y.toString())));
    public boolean isWinnerX() {
        List<Boolean> x = new ArrayList<Boolean>();
        boolean result = true;
        /*Arrays.stream(this.table).forEach(e -> Arrays.stream(e).forEach(y->{x.add(y.hasMarkX());}));
        IntStream.range(0, x.size()).
                .collect(Collectors.toList());
        System.out.println(x.toString());*/
        //stream1.forEach(x -> Arrays.stream(x).forEach(y->y.hasMarkX()));
        for (int i=0;i<this.table.length;i++) {
            for (int j=0;j<this.table[i].length;j++) {
                    result=result&this.table[i][j].hasMarkX();
            }
        }
        if (!result){
            result=true;
            for (int i=0;i<this.table.length;i++) {
                result=result&this.table[i][0].hasMarkX();
            }
        }
        if (!result){
            result=true;
            for (int i=0;i<this.table.length;i++) {
                result=result&this.table[i][i].hasMarkX();
            }
        }
        if (!result){
            result=true;
            for (int i=0;i<this.table.length;i++) {
                result=result&this.table[i][3-i].hasMarkX();
            }
        }
        return result;
    }
//проверяет есть ли в поле выигрышные комбинации для Нолика
    public boolean isWinnerO() {
        boolean result = true;
        for (int i=0;i<this.table.length;i++) {
            for (int j=0;j<this.table[i].length;j++) {
                result=result&this.table[i][j].hasMarkO();
            }
        }
        if (!result){
            result=true;
            for (int i=0;i<this.table.length;i++) {
                result=result&this.table[i][0].hasMarkO();
            }
        }
        if (!result){
            result=true;
            for (int i=0;i<this.table.length;i++) {
                result=result&this.table[i][i].hasMarkO();
            }
        }
        if (!result){
            result=true;
            for (int i=0;i<this.table.length;i++) {
                result=result&this.table[i][3-i].hasMarkO();
            }
        }
        return result;
    }
//проверяет, если ли пустые клетки для новых ходов
    public boolean hasGap() {
        return true;
    }
}
