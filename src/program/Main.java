package program;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Path: ");
		String path = sc.nextLine();
		String[] amigos = new String[] {"Neymar", "Batman", "Goku"};
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true)))
		{
			for(String friends: amigos) {
				bw.write(friends);
				bw.newLine();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		


	}
}
