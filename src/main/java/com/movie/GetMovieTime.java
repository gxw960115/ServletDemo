package com.movie;

import com.movie.util.VideoUtil;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GetMovieTime {

    public static void main(String[] args) throws IOException {
        System.out.println("请输入您想要查询的路径：");
        Scanner sc = new Scanner(System.in);
        String pathname = sc.nextLine();
//        String pathname = "E:\\aDrive\\Downloads\\2、版本控制Git\\01-版本控制Git";
//        String pathname = "E:\\aDrive\\Downloads\\1、Maven从基础到高级应用\\视频-Maven\\day1视频\\视频";
//        String pathname = "E:\\aDrive\\Downloads\\1、Maven从基础到高级应用\\视频-Maven\\day2视频\\视频";
        File file = new File(pathname);
        System.out.println("查询结果如下：");
        System.out.println("共 " + file.list().length + " 个视频");
        String list = "";
        long result = 0;
        for (String s : file.list()) {
//            System.out.println(s);
            String path = file.getCanonicalPath();
            long res = VideoUtil.getDuration(path + "\\" + s);
//            System.out.println(res);
            result += res;
            list += s + " \n";
        }
        long m = result / 60;
        long m1 = m % 60;
        long h = m / 60;

        System.out.println("分别是：\n" +list.substring(0,list.length()-1));
        System.out.println("播放时长共 " + h + " 小时 " + m1 + " 分钟 " + result % 60 + " 秒");
        System.out.println();
        System.out.println();
    }

}
