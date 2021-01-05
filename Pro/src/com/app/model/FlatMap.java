package com.app.model;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FlatMap {

	public static void main(String[] args) {
		try {
			long noOfWords=Files.lines(Paths.get("C:/Users/vg19434/Desktop/excempl.txt"))
					.flatMap(l->Arrays.stream(l.split(" +"))).distinct().count();
			System.out.println("NoOf lines in the documents   "+noOfWords);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			long noOfWords=Files.(Paths.get("C:/Users/vg19434/Desktop/excempl.txt"))
					.flatMap(l->Arrays.stream(l.split(" +"))).distinct().count();
			System.out.println("NoOf lines in the documents   "+noOfWords);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
