package program;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		print("Enter folder path:");
		String strPath = sc.nextLine();
		File path = new File(strPath);
		File[] folders = path.listFiles(File::isDirectory);
		print("Folders: ");
		for(File x:folders) {
			System.out.println(x);
		}
		File[] files = path.listFiles(File::isFile);
		print("Files: ");
		for(File f: files) {
			System.out.println(f);
		}
		boolean success = new File(strPath + "\\subdir").mkdir();
		System.out.println(success);
	}
	
	public static void print(String string) {
		System.out.println(string);
	}

}
