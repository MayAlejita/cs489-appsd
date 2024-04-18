package edu.miu.cs489.arrayreversor;

import edu.miu.cs489.arrayreversor.service.ArrayFlattenerService;

import java.util.Arrays;
import java.util.Collections;

import java.util.List;

public class ArrayReversor {

    private ArrayFlattenerService arrayFlattenerService;

    public ArrayReversor(ArrayFlattenerService arrayFlattenerService) {this.arrayFlattenerService = arrayFlattenerService;}

    public static void main(String[] args) {
        Integer [] e1 = {1,3};
        Integer [] e2 = {0};
        Integer [] e3 = {4,5,9};
        Integer [][] a_in = new Integer[][]{e1,e2,e3};

        ArrayFlattenerService arrayFlattenerService1 = input -> new Integer[]{1,3,0,4,5,9};
        ArrayReversor a = new ArrayReversor(arrayFlattenerService1);
        System.out.println(List.of(a.reverseArray(a_in)));
    }

    public Integer [] reverseArray(Integer [][] input){
        if(input == null) return null;

        Integer [] arrayFlatten = arrayFlattenerService.flattenArray(input);
        List<Integer> reversed = Arrays.asList(arrayFlatten);
        Collections.reverse(Arrays.asList(arrayFlatten));
        return reversed.toArray(Integer[]::new);
    }
}
