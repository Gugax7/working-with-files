package program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file path: ");
		String path = sc.nextLine();
		List<Product> product = new ArrayList<>();
		File sourceFile = new File(path); //catalog the ex.csv as a program with path "path"
		String sourceFolderStr = sourceFile.getParent(); //Set where goes folder "out"
		boolean success = new File(sourceFolderStr + "\\out").mkdir();//create "out" folder in path "sourceFolder + \\out" and return a boolean result
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";
		try(BufferedReader bf = new BufferedReader(new FileReader(path))){
			String line = bf.readLine();
			
			while(line != null) {
				System.out.println(line);
				String[] props = line.split(",");
				String name = props[0];
				Double price = Double.parseDouble(props[1]);
				Integer amount = Integer.parseInt(props[2]);
				product.add(new Product(name, price, amount));
				line = bf.readLine();
				
				/*readLine() basically
				read a line and go to the next, 
				in just one method, so we need to have cautions*/
			}
			//if buffered writer don't find any archive, it create a new with the path
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){
				for(Product item: product) {
				bw.write(item.getName() + "," + String.format("%.2f", item.total()));
				bw.newLine();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}


	}
}
