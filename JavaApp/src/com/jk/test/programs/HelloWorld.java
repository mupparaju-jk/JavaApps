package com.jk.test.programs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorld {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Helloworld");
		File file = new File("./src/resources/data-fie.txt");
		FileReader fr;
		SimpleDateFormat df = new SimpleDateFormat("yyyy/dd/MM");
		SimpleDateFormat fdf = new SimpleDateFormat("yyyy/MM/dd");
		File outFile = new File("out.txt");
		StringBuffer sf = new StringBuffer();
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(outFile);
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
				String data[] = line.split(",");
				String date = data[2];
//				System.out.println("Date is -->"+date);
				Date datetime = df.parse(date);
//				System.out.println(datetime);
				String finaldate = fdf.format(datetime);
//				System.out.println("final date -->"+finaldate);
				data[2] = finaldate;
				for (int i = 0; i < data.length; i++) {
					sf.append(data[i]+"|");
				}
				sf.append("\n");
				fw.write(sf.toString());
				fw.flush();
				sf = new StringBuffer();
			}

		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
