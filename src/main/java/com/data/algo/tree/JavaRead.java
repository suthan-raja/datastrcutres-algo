package com.data.algo.tree;

import org.springframework.core.io.FileSystemResource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaRead {

    public static void main(String[] args) throws IOException {

        String filePath = new FileSystemResource("").getFile().getAbsolutePath();

        List<String> list = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader( filePath + "\\mas.txt"))) {
            BufferedReader file2 = new BufferedReader(new FileReader(filePath + "\\interviewer.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
               list.add(line);
            }

            String lk ;

            while ((lk = file2.readLine()) != null) {
                list2.add(lk);
            }


            System.out.println(list.size());
            System.out.println(list2.size());

        }

//      List<String>
        Set<String> swew  = list.stream()
                .filter(s -> list2.stream().noneMatch(sk -> Objects.equals(s, sk))).collect(Collectors.toSet());

//        System.out.println(c);

        System.out.println(swew.size());

        FileWriter fileWriter = new FileWriter("bot2.txt");
//        while(!swew.isEmpty()){
            fileWriter.write(String.join("\n", swew) + "\n");
//        }
//        fileWriter.write(swew.toString());
        fileWriter.close();


    }
}
