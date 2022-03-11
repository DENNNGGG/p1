package P1;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class p1 {
	Coordinate[][] coordsArray3;
	public static void main(String[] args) {
		Scanner scanner;
		ArrayList<String> coords = new ArrayList<String>();
		File f = new File("easymap");
		
		try {
			//code that might throw a special error
			scanner = new Scanner(f);
			int rows = scanner.nextInt();
			int cols = scanner.nextInt();
			int rooms = scanner.nextInt();
			int count = 0;
			//take in cols and # of rooms
			scanner.nextLine(); // move scanner to next line
			System.out.println(rows + " " + cols + " " + rooms);
			while (scanner.hasNextLine()) {
				
				String line = scanner.nextLine();
				for (int i = 0; i < cols; i++) {
					System.out.println(line.charAt(i) + " " + count + " " + i);
					coords.add(line.charAt(i) + " " + count + " " + i);

				}
				count++;
				if (line.length() == 0) {
					break;
				}
				



			}
			
			File g = new File("coordmapv3");
			scanner = new Scanner(g);
			int rows2 = scanner.nextInt();
			int cols2 = scanner.nextInt();
			int rooms2 = scanner.nextInt();
			int counters = 0;
			scanner.nextLine(); 
			System.out.println(rows2 + " " + cols2 + " " + rooms2);
			Coordinate[][] coordsArray = new Coordinate[rows][cols];


			while (scanner.hasNextLine()) {
				
				String line = scanner.nextLine();
				System.out.print(line.charAt(0));
				counters++;

				if (counters % cols2 == 0) {
					System.out.print("\n");

				}

				
				if (line.length() == 0) {
					break;
				}
				
			
				Coordinate phatass = new Coordinate(coords, 1);
		//		Coordinate[][] coordsArray = new Coordinate[rows][cols];
				
				int counter = 0;
			
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						coordsArray[i][j] = new Coordinate(coords, (counter));
						counter++;
					}
				}
				
	
	
				
				
			//	System.out.println(coordsArray[1][3].getType());
			//	System.out.println(phatass.getCol());
			//	for (int i = 0; i < rows; i++) {
			//		for (int j = 0; j < cols; j++) {
			//			System.out.print(coordsArray[i][j].getRow() + " ");
			//			System.out.print(coordsArray[i][j].getCol() + " ");
			//			System.out.print(coordsArray[i][j].getType());
			//			System.out.println('\n');
			//		}
			//	}
				//use charat to grab elements of the map for a given row
			}
			findPath sdfasf = new findPath();
			sdfasf.pathFind(coordsArray); 
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
