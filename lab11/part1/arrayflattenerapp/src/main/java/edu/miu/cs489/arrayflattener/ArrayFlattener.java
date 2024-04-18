package edu.miu.cs489.arrayflattener;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArrayFlattener {

    public static void main(String[] args) {
        Integer [] e1 = {1,3};
        Integer [] e2 = {0};
        Integer [] e3 = {4,5,9};
        Integer [][] a_in = new Integer[][]{e1,e2,e3};

        ArrayFlattener a = new ArrayFlattener();
        System.out.println(List.of(a.flattenArray(a_in)));
    }

    public Integer [] flattenArray(Integer [][] input){
        if(input == null) return null;
        return Arrays.stream(input)
                .flatMap(Stream::of)
                .toArray(Integer[]::new);
    }
}
