package study.unit.algorithm.校招笔试题汇总.搜狐;

import java.util.Scanner;

/**
 * Created by wanghongbin on 2017/9/17 19:57.
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] name = line.split("/");
        int numBack=0;
        int numFile=0;
        String [] fileName= new String[name.length];
        for (int i = 1; i < name.length; i++) {

            if(name[i].equals("..")){numBack++;continue;}
            if(name[i].equals(".")){continue;}
            fileName[numFile++]=name[i];
        }
        String out = name[0]+"/"+fileName[numBack++];
        if(numBack!=numFile){
            for (int i = numBack; i < numFile ; i++) {
                out=out+"/"+fileName[i];
            }
        }


        System.out.println(out);
    }
}
