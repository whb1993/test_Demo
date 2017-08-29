package study.unit.algorithm.Test;

/**
 * Created by wanghongbin on 2017/8/25 19:58.
 * 阿里笔试题目
 * 2000 长宽高  最小箱子数
 */
import java.util.Scanner;
public class 阿里笔试题 {
/** 请完成下面这个process函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int [] length = new  int[3];
        int itemNum = 0;
        int max;
        int V ;
        Model[] items;
            length[0] = scanner.nextInt();
            length[1] = scanner.nextInt();
            length[2] = scanner.nextInt();
            V = length[0]*length[1]*length[2];
            max =  length[0]> length[1]? length[0]:length[1];
            max =  max> length[2]? max:length[2];
            itemNum = scanner.nextInt();
            items = new Model[itemNum];
            for(int i=0; i<itemNum; i++){
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                items[i] = item;
            }
        

            int num = 1;
        int money = 0;
        int allV=0;
        for (int i = 0; i < itemNum; i++) {
            if(items[i].price>2000) System.out.println(-1);
            if(items[i].length>max||items[i].width>max||items[i].height>max) System.out.println(-1);
            money +=items[i].price;
            allV+=items[i].V;
            if(money>2000||allV>V){
               num++;
               money = items[i].price;
                allV=items[i].V;
            }
        }
        System.out.println(num);
    }
    static class Model{
        int price;
        int length;
        int width;
        int height;
        int V = length*width*height;
    }

}
