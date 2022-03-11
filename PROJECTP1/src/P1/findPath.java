package P1;
import java.util.ArrayList;
import java.util.Queue;
public class findPath {
	ArrayList<Coordinate> enqueue = new ArrayList<Coordinate>();
	ArrayList<Coordinate> dequeue = new ArrayList<Coordinate>();
	String[][] mapsolve;
	Coordinate KirbyLocation;
	Coordinate CakeLocation;
	int KirbyArrayIndex;
	int CakeArrayIndex;
	int KirbyX, KirbyY;
	int CakeX, CakeY;
	Coordinate enqueuer;
	boolean cakeCheck = false;
	
	public void pathFind(Coordinate[][] mapXD) { // find Kirby's current location
		for (int i = 0; i < mapXD.length; i++) {
			for (int j = 0; j < mapXD[0].length; j++) {
				if (mapXD[i][j].getType().equals("K")) {
					KirbyLocation = mapXD[i][j]; // for some reason, I'm having x = row and y = col
					KirbyX = i;
					KirbyY = j;
					mapXD[i][j].setVisited(true);
				}
			}
		}
		for (int i = 0; i < mapXD.length; i++) { // find the cake
			for (int j = 0; j < mapXD[0].length; j++) {
				if (mapXD[i][j].getType().equals("C")) {
					CakeLocation = mapXD[i][j]; // for some reason, I'm having x = row and y = col
					CakeX = i;
					CakeY = j;
				}
			}
		}
		
		if (KirbyLocation == null) {
			System.out.println("The cake is a friggin lie grr.");
		}
		
		enqueue.add(KirbyLocation);
		
		while (enqueue.size() > 0) { // I'm getting an out of bounds error somewhere here
			enqueuer = enqueue.get(0);
			dequeue.add(enqueue.remove(0));
			int enqueuerX = enqueuer.getRow(), enqueuerY = enqueuer.getCol();

			if ((enqueuerX - 1) >= 0 && (mapXD[enqueuerX - 1][enqueuerY].getType().equals(".") || mapXD[enqueuerX - 1][enqueuerY].getType().equals("C")) && mapXD[enqueuerX - 1][enqueuerY].getVisited() == false) { // first round of enqueueing 
				if (mapXD[enqueuerX - 1][enqueuerY].getType().equals("C")) {
					enqueue.add(mapXD[enqueuerX - 1][enqueuerY]);
					cakeCheck = true;
					break;
				}
				enqueue.add(mapXD[enqueuerX - 1][enqueuerY]);
				mapXD[enqueuerX - 1][enqueuerY].setVisited(true);
			}
			if ((enqueuerX + 1) < mapXD.length && (mapXD[enqueuerX + 1][enqueuerY].getType().equals(".") || mapXD[enqueuerX + 1][enqueuerY].getType().equals("C")) && mapXD[enqueuerX + 1][enqueuerY].getVisited() == false) {
				if (mapXD[enqueuerX + 1][enqueuerY].getType().equals("C")) {
					enqueue.add(mapXD[enqueuerX + 1][enqueuerY]);
					cakeCheck = true; 
					break;
				}
				enqueue.add(mapXD[enqueuerX + 1][enqueuerY]);
				mapXD[enqueuerX + 1][enqueuerY].setVisited(true);
			}
			if ((enqueuerY + 1) < mapXD[0].length && (mapXD[enqueuerX][enqueuerY + 1].getType().equals(".") || mapXD[enqueuerX][enqueuerY + 1].getType().equals("C")) && mapXD[enqueuerX][enqueuerY + 1].getVisited() == false) {
				if (mapXD[enqueuerX][enqueuerY + 1].getType().equals("C")) {
					enqueue.add(mapXD[enqueuerX][enqueuerY + 1]);
					cakeCheck = true;
					break;
				}
				enqueue.add(mapXD[enqueuerX][enqueuerY + 1]);
				mapXD[enqueuerX][enqueuerY + 1].setVisited(true);
			}
			if ((enqueuerY - 1) >= 0 && (mapXD[enqueuerX][enqueuerY - 1].getType().equals(".") || mapXD[enqueuerX][enqueuerY - 1].getType().equals("C")) && mapXD[enqueuerX][enqueuerY - 1].getVisited() == false) {
				if (mapXD[enqueuerX][enqueuerY - 1].getType().equals("C")) {
					enqueue.add(mapXD[enqueuerX][enqueuerY - 1]);
					cakeCheck = true;
					break;
				}
				enqueue.add(mapXD[enqueuerX][enqueuerY - 1]);
				mapXD[enqueuerX][enqueuerY - 1].setVisited(true);
			}
			
		}
		
		for (int i = 0; i < dequeue.size(); i++) {
			System.out.print(dequeue.get(i).getType() + " ");
			System.out.print(dequeue.get(i).getRow() + " ");
			System.out.print(dequeue.get(i).getCol());
			System.out.print("\n");

		}
		System.out.println("LOL");
		Coordinate phatass2 = dequeue.get(dequeue.size() - 1);
		mapXD[dequeue.get(dequeue.size() - 1).getRow()][dequeue.get(dequeue.size() - 1).getCol()].setType("+");
		for (int i = dequeue.size() - 1; i > 0; i--) {
			if ((dequeue.get(i).getRow() == (phatass2.getRow())) && ((dequeue.get(i).getCol() == (phatass2.getCol() + 1)))) {
				System.out.print(dequeue.get(i).getType() + " ");
				System.out.print(dequeue.get(i).getRow() + " ");
				System.out.print(dequeue.get(i).getCol());
				System.out.print("\n");
				phatass2 = dequeue.get(i);
				mapXD[dequeue.get(i).getRow()][dequeue.get(i).getCol()].setType("+");

			}
			if (dequeue.get(i).getRow() == (phatass2.getRow()) && (dequeue.get(i).getCol() == (phatass2.getCol() - 1))) {
				System.out.print(dequeue.get(i).getType() + " ");
				System.out.print(dequeue.get(i).getRow() + " ");
				System.out.print(dequeue.get(i).getCol());
				System.out.print("\n");
				phatass2 = dequeue.get(i);
				mapXD[dequeue.get(i).getRow()][dequeue.get(i).getCol()].setType("+");

			}
			if ((dequeue.get(i).getRow() == (phatass2.getRow() - 1)) && (dequeue.get(i).getCol() == (phatass2.getCol()))) {
				System.out.print(dequeue.get(i).getType() + " ");
				System.out.print(dequeue.get(i).getRow() + " ");
				System.out.print(dequeue.get(i).getCol());
				System.out.print("\n");
				phatass2 = dequeue.get(i);
				mapXD[dequeue.get(i).getRow()][dequeue.get(i).getCol()].setType("+");

			} 
			if ((dequeue.get(i).getRow() == (phatass2.getRow() + 1)) && (dequeue.get(i).getCol() == (phatass2.getCol()))) {
				System.out.print(dequeue.get(i).getType() + " ");
				System.out.print(dequeue.get(i).getRow() + " ");
				System.out.print(dequeue.get(i).getCol());
				System.out.print("\n");
				phatass2 = dequeue.get(i);
				mapXD[dequeue.get(i).getRow()][dequeue.get(i).getCol()].setType("+");
			} 
			
			
		}
		System.out.println("LOL");
		for (int j = 0; j < mapXD.length; j++) {
			System.out.println();
			for (int k = 0; k < mapXD[0].length; k++) {
				System.out.print(mapXD[j][k].getType());
			}
		}
	}
	
}
