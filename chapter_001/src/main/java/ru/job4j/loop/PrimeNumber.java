package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        for (int x=2;x<=finish;x++){
            /*int sqrt_round= (int)Math.floor(Math.sqrt(x));
            if (sqrt_round==1){
                ++count;
            }else{*/
                boolean flag=true;
                /*попробуйте упростить
                запускаете цикл от 2 до числа внешнего цикла и если  нашли делитель то меняете флаг и делаете брейк
                после цикла исходя из флага решаете увеличить счетчик или нет*/
                for (int y=2;y<=x;y++){
                    if (x%y!=0 ) {//если дошел до конца и не нашелся делитель
                        flag=false;
                        break;
                    }
                }
                if (flag==false){
                    ++count;
                }
                /*for (int y=2;y<=sqrt_round;y++){
                    if(x%y==0 && y<sqrt_round){
                        break;
                    }else {
                        if (x % y == 0) {
                            continue;
                        } else if (y < sqrt_round) {//ладно 2 а потом будет 3 и что ?
                            continue;
                        } else {
                            ++count;
                        }
                    }
                }*/
            }
        //}
        return count;
    }
}
