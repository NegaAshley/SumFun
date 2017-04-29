package Unit;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProcessMove_GlassBox {
	
	UntimedGame ug = UntimedGame.getInstance();
	
	/**
	 * Test removal of tiles adjacent to tile in the middle of board (tile not on any edge or corner)
	 */
	@Test
	public void testRemoveMiddle() {
		
		System.out.println("Test 14");
		
		int x = 4;
		int y = 4;
		
		ug.getGameBoard().emptyBoard();
		ug.getGameBoard().fillBoard();
		ug.getGameBoard().printArray();
		TileModel t = ug.getGameBoard().getTile(x, y);
		ug.removeAdjacentTiles(t);
		ug.getGameBoard().printArray();
		
		assertEquals("", -1, t.getNorth().getValue()); //North tile
		assertEquals("", -1, t.getNorthEast().getValue()); //North east
		assertEquals("", -1, t.getEast().getValue()); //East
		assertEquals("", -1, t.getSouthEast().getValue()); //South east
		assertEquals("", -1, t.getSouth().getValue()); //South
		assertEquals("", -1, t.getSouthWest().getValue()); //South west
		assertEquals("", -1, t.getWest().getValue()); //West
		assertEquals("", -1, t.getNorthWest().getValue()); //North west
	}

	/**
	 * Test removal of tiles adjacent to tile on the top non-corner edge
	 */
	@Test
	public void testRemoveTop() {
		
		System.out.println("Test 14");
		
		int x = 0;
		int y = 4;
		
		ug.getGameBoard().emptyBoard();
		ug.getGameBoard().fillBoard();
		ug.getGameBoard().printArray();
		TileModel t = ug.getGameBoard().getTile(x, y);
		ug.removeAdjacentTiles(t);
		ug.getGameBoard().printArray();
		
		assertEquals("", null, t.getNorth()); //North tile
		assertEquals("", null, t.getNorthEast()); //North east
		assertEquals("", -1, t.getEast().getValue()); //East
		assertEquals("", -1, t.getSouthEast().getValue()); //South east
		assertEquals("", -1, t.getSouth().getValue()); //South
		assertEquals("", -1, t.getSouthWest().getValue()); //South west
		assertEquals("", -1, t.getWest().getValue()); //West
		assertEquals("", null, t.getNorthWest()); //North west
	}
	
	/**
	 * Test removal of tiles adjacent to tile on the top left corner
	 */
	@Test
	public void testRemoveTopLeft() {
		
		System.out.println("Test 15");
		
		int x = 0;
		int y = 0;
		
		ug.getGameBoard().emptyBoard();
		ug.getGameBoard().fillBoard();
		ug.getGameBoard().printArray();
		TileModel t = ug.getGameBoard().getTile(x, y);
		ug.removeAdjacentTiles(t);
		ug.getGameBoard().printArray();
		
		assertEquals("", null, t.getNorth()); //North tile
		assertEquals("", null, t.getNorthEast()); //North east
		assertEquals("", -1, t.getEast().getValue()); //East
		assertEquals("", -1, t.getSouthEast().getValue()); //South east
		assertEquals("", -1, t.getSouth().getValue()); //South
		assertEquals("", null, t.getSouthWest()); //South west
		assertEquals("", null, t.getWest()); //West
		assertEquals("", null, t.getNorthWest()); //North west
	}
	
	/**
	 * Test removal of tiles adjacent to tile on the top right corner
	 */
	@Test
	public void testRemoveTopRight() {
		
		System.out.println("Test 16");
		
		int x = 0;
		int y = 8;
		
		ug.getGameBoard().emptyBoard();
		ug.getGameBoard().fillBoard();
		ug.getGameBoard().printArray();
		TileModel t = ug.getGameBoard().getTile(x, y);
		ug.removeAdjacentTiles(t);
		ug.getGameBoard().printArray();
		
		assertEquals("", null, t.getNorth()); //North tile
		assertEquals("", null, t.getNorthEast()); //North east
		assertEquals("", null, t.getEast()); //East
		assertEquals("", null, t.getSouthEast()); //South east
		assertEquals("", -1, t.getSouth().getValue()); //South
		assertEquals("", -1, t.getSouthWest().getValue()); //South west
		assertEquals("", -1, t.getWest().getValue()); //West
		assertEquals("", null, t.getNorthWest()); //North west

	}
	
	/**
	 * Test removal of tiles adjacent to tile on the right non-corner edge
	 */
	@Test
	public void testRemoveRight() {
		
		System.out.println("Test 17");
		
		int x = 4;
		int y = 8;
		
		ug.getGameBoard().emptyBoard();
		ug.getGameBoard().fillBoard();
		ug.getGameBoard().printArray();
		TileModel t = ug.getGameBoard().getTile(x, y);
		ug.removeAdjacentTiles(t);
		ug.getGameBoard().printArray();
		
		assertEquals("", -1, t.getNorth().getValue()); //North tile
		assertEquals("", null, t.getNorthEast()); //North east
		assertEquals("", null, t.getEast()); //East
		assertEquals("", null, t.getSouthEast()); //South east
		assertEquals("", -1, t.getSouth().getValue()); //South
		assertEquals("", -1, t.getSouthWest().getValue()); //South west
		assertEquals("", -1, t.getWest().getValue()); //West
		assertEquals("", -1, t.getNorthWest().getValue()); //North west
	}
	
	/**
	 * Test removal of tiles adjacent to tile on the bottom right corner
	 */
	@Test
	public void testRemoveBottomRight() {
		
		System.out.println("Test 18");
		
		int x = 8;
		int y = 8;
		
		ug.getGameBoard().emptyBoard();
		ug.getGameBoard().fillBoard();
		ug.getGameBoard().printArray();
		TileModel t = ug.getGameBoard().getTile(x, y);
		ug.removeAdjacentTiles(t);
		ug.getGameBoard().printArray();
		
		assertEquals("", -1, t.getNorth().getValue()); //North tile
		assertEquals("", null, t.getNorthEast()); //North east
		assertEquals("", null, t.getEast()); //East
		assertEquals("", null, t.getSouthEast()); //South east
		assertEquals("", null, t.getSouth()); //South
		assertEquals("", null, t.getSouthWest()); //South west
		assertEquals("", -1, t.getWest().getValue()); //West
		assertEquals("", -1, t.getNorthWest().getValue()); //North west
	}
	
	/**
	 * Test removal of tiles adjacent to tile on the bottom non-corner edge
	 */
	@Test
	public void testRemoveBottom() {
		
		System.out.println("Test 19");
		
		int x = 8;
		int y = 4;
		
		ug.getGameBoard().emptyBoard();
		ug.getGameBoard().fillBoard();
		ug.getGameBoard().printArray();
		TileModel t = ug.getGameBoard().getTile(x, y);
		ug.removeAdjacentTiles(t);
		ug.getGameBoard().printArray();
		
		assertEquals("", -1, t.getNorth().getValue()); //North tile
		assertEquals("", -1, t.getNorthEast().getValue()); //North east
		assertEquals("", -1, t.getEast().getValue()); //East
		assertEquals("", null, t.getSouthEast()); //South east
		assertEquals("", null, t.getSouth()); //South
		assertEquals("", null, t.getSouthWest()); //South west
		assertEquals("", -1, t.getWest().getValue()); //West
		assertEquals("", -1, t.getNorthWest().getValue()); //North west
	}
	
	/**
	 * Test removal of tiles adjacent to tile on the bottom left corner 
	 */
	@Test
	public void testRemoveBottomLeft() {
		
		System.out.println("Test 20");
		
		int x = 8;
		int y = 0;
		
		ug.getGameBoard().emptyBoard();
		ug.getGameBoard().fillBoard();
		ug.getGameBoard().printArray();
		TileModel t = ug.getGameBoard().getTile(x, y);
		ug.removeAdjacentTiles(t);
		ug.getGameBoard().printArray();
		
		assertEquals("", -1, t.getNorth().getValue()); //North tile
		assertEquals("", -1, t.getNorthEast().getValue()); //North east
		assertEquals("", -1, t.getEast().getValue()); //East
		assertEquals("", null, t.getSouthEast()); //South east
		assertEquals("", null, t.getSouth()); //South
		assertEquals("", null, t.getSouthWest()); //South west
		assertEquals("", null, t.getWest()); //West
		assertEquals("", null, t.getNorthWest()); //North west
	}
	
	/**
	 * Test removal of tiles adjacent to tile on the top non-corner edge
	 */
	@Test
	public void testRemoveLeft() {
		
		System.out.println("Test 21");
		
		int x = 4;
		int y = 0;
		
		ug.getGameBoard().emptyBoard();
		ug.getGameBoard().fillBoard();
		ug.getGameBoard().printArray();
		TileModel t = ug.getGameBoard().getTile(x, y);
		ug.removeAdjacentTiles(t);
		ug.getGameBoard().printArray();
		
		assertEquals("", -1, t.getNorth().getValue()); //North tile
		assertEquals("", -1, t.getNorthEast().getValue()); //North east
		assertEquals("", -1, t.getEast().getValue()); //East
		assertEquals("", -1, t.getSouthEast().getValue()); //South east
		assertEquals("", -1, t.getSouth().getValue()); //South
		assertEquals("", null, t.getSouthWest()); //South west
		assertEquals("", null, t.getWest()); //West
		assertEquals("", null, t.getNorthWest()); //North west
	}
	
	
	/**
	 * Test path A C E F H K
	 * A tile is placed, has more than 3 adjacent tiles, has the correct value for removal, and clears the game board
	 */
	@Test
	public void testACEFHK() {
		
		System.out.println("Test 2");
		ug.createNewGameBoard();
		ug.setGameWon(false);
		ug.getGameBoard().emptyBoard();
		ug.getGameBoard().seedBoard(5);
		ug.getGameBoard().printArray();
		ug.setScore(0);
		ug.processMove(0, 0, 5);
		ug.getGameBoard().printArray();
		assertEquals("", -1, ug.getGameBoard().getTile(0, 0).getValue()); //Tile added should be immediately removed, resulting in -1
		assertEquals("", true, ug.getGameWon()); //Game should be won
		assertEquals("", false, ug.getIsActive()); //Game should no longer be active
		assertEquals("", 30, ug.getPoints()); //Points should be 30 for three tiles removed
		System.out.println("");
		
	}//end testACEFHK
	
//	@Test
	/**
	 * Test path A C E F I L
	 * A tile is placed, has more than 3 adjacent tiles, has the correct value for removal, and fills the game board
	 * Test should fail since the board can never be full if tiles are removed after a placement
	 */
	public void testACEFIL() {
		
		System.out.println("Test 3");
		ug.createNewGameBoard();
		ug.setGameWon(false);
		ug.getGameBoard().fillBoard();
		ug.getGameBoard().seedBoard(5);
		ug.getGameBoard().printArray();
		ug.setScore(0);
		ug.processMove(0, 0, 5);
		ug.getGameBoard().printArray();
		assertEquals("", -1, ug.getGameBoard().getTile(0, 0).getValue()); //Tile added should be immediately removed, resulting in -1
		assertEquals("", false, ug.getGameWon()); //Game should not be won
		assertEquals("", false, ug.getIsActive()); //Game should not still be active
		assertEquals("", 30, ug.getPoints()); //Points should be 30 for three tiles removed
		System.out.println("");
		
	}
	
	@Test
	/**
	 * Test path A C E F J
	 * A tile is placed, has more than 3 adjacent tiles, has the correct value for removal, and neither empties nor clears game board
	 */
	public void testACEFJ() {
		
		System.out.println("Test 4");
		ug.createNewGameBoard();
		ug.setGameWon(false);
		ug.getGameBoard().emptyBoard();
		ug.getGameBoard().partiallyFillBoard();
		ug.getGameBoard().seedBoard(5);
		ug.getGameBoard().printArray();
		ug.setScore(0);
		ug.processMove(0, 0, 5);
		ug.getGameBoard().printArray();
		assertEquals("", -1, ug.getGameBoard().getTile(0, 0).getValue()); //Tile added should be immediately removed, resulting in -1
		assertEquals("", false, ug.getGameWon()); //Game should not be won
		assertEquals("", true, ug.getIsActive()); //Game should still be active
		assertEquals("", 30, ug.getPoints()); //Points should be 30 for three tiles removed
		System.out.println("");
		
	}
	
//	@Test
	/**
	 * Test path A C G H K
	 * A tile is placed, has more more than 3 adjacent tiles, does not have the correct value for removal, and clears the game board
	 * Test should fail since removal does not occur, and hence the board cannot be cleared
	 */
	public void testACGHK() {
		
		System.out.println("Test 5");
		ug.createNewGameBoard();
		ug.setGameWon(false);
		ug.getGameBoard().emptyBoard();
		ug.getGameBoard().seedBoard(6);
		ug.getGameBoard().printArray();
		ug.setScore(0);
		ug.processMove(0, 0, 6);
		ug.getGameBoard().printArray();
		assertEquals("", 6, ug.getGameBoard().getTile(0, 0).getValue());
		assertEquals("", true, ug.getGameWon()); //Game should  be won
		assertEquals("", false, ug.getIsActive()); //Game should not still be active
		assertEquals("", 0, ug.getPoints()); //Points should be 0 
		System.out.println("");
		
	}
	
	@Test
	/**
	 * Test path A C G I L
	 * A tile is placed, has more than 3 adjacent tiles, does not have the correct value for removal, and fills the game board
	 */
	public void testACGIL() {
		
		System.out.println("Test 6");
		ug.createNewGameBoard();
		ug.setGameWon(false);
		ug.getGameBoard().emptyBoard();
		ug.getGameBoard().fillBoard();
		ug.getGameBoard().seedBoard(6);
		ug.getGameBoard().printArray();
		ug.setScore(0);
		ug.processMove(0, 0, 6);
		ug.getGameBoard().printArray();
		assertEquals("", 6, ug.getGameBoard().getTile(0, 0).getValue());
		assertEquals("", false, ug.getGameWon()); //Game should not be won
		assertEquals("", false, ug.getIsActive()); //Game should not still be active
		assertEquals("", 0, ug.getPoints()); //Points should be 0 
		System.out.println("");
		
	}
	
	@Test
	/**
	 * Test path A C G J
	 * A tile is placed, has more than 3 adjacent tiles, does not have the correct value for removal, neither fills nor empties board
	 */
	public void testACGJ() {
		
		System.out.println("Test 7");
		ug.createNewGameBoard();
		ug.setGameWon(false);
		ug.getGameBoard().emptyBoard();
		ug.getGameBoard().partiallyFillBoard();
		ug.getGameBoard().seedBoard(6);
		ug.getGameBoard().printArray();
		ug.setScore(0);
		ug.processMove(0, 0, 6);
		ug.getGameBoard().printArray();
		assertEquals("", 6, ug.getGameBoard().getTile(0, 0).getValue());
		assertEquals("", false, ug.getGameWon()); //Game should not be won
		assertEquals("", true, ug.getIsActive()); //Game should  still be active
		assertEquals("", 0, ug.getPoints()); //Points should be 0 
		System.out.println("");
		
	}
	
	@Test
	/**
	 * Test path B D E F H K
	 * A tile is placed, does not have more than 3 adjacent tiles, has the correct value for removal, and empties game board
	 */
	public void testBDEFHK() {
		
		System.out.println("Test 8");
		ug.createNewGameBoard();
		ug.setGameWon(false);
		ug.getGameBoard().emptyBoard();
		ug.getGameBoard().seedBoardNoScore(5);
		ug.getGameBoard().printArray();
		ug.setScore(0);
		ug.processMove(0, 0, 0);
		ug.getGameBoard().printArray();
		assertEquals("", -1, ug.getGameBoard().getTile(0, 0).getValue());
		assertEquals("", true, ug.getGameWon()); //Game should be won
		assertEquals("", false, ug.getIsActive()); //Game should not still be active
		assertEquals("", 0, ug.getPoints()); //Points should be 0 
		System.out.println("");
		
	}
	
//	@Test
	/**
	 * Test path B D E F I L
	 * A tile is placed, does not have more than 3 adjacent tiles, has the correct value for removal, fills game board
	 * Test should fail since removal occurs, therefore the game board cannot be filled
	 */
	public void testBDEFIL() {
		
		System.out.println("Test 9");
		ug.createNewGameBoard();
		ug.setGameWon(false);
		ug.getGameBoard().fillBoard();
		ug.getGameBoard().seedBoardNoScore(5);
		ug.getGameBoard().printArray();
		ug.setScore(0);
		ug.processMove(0, 0, 7);
		ug.getGameBoard().printArray();
		assertEquals("", -1, ug.getGameBoard().getTile(0, 0).getValue());
		assertEquals("", false, ug.getGameWon()); //Game should not be won
		assertEquals("", false, ug.getIsActive()); //Game should not still be active
		assertEquals("", 0, ug.getPoints()); //Points should be 0 
		System.out.println("");
		
	}
	
	@Test
	/**
	 * Test path B D E F J
	 * A tile is placed, does not have more than 3 adjacent tiles, has the correct value for removal, neither empties nor fills board
	 */
	public void testBDEFJ() {
		
		System.out.println("Test 10");
		ug.createNewGameBoard();
		ug.setGameWon(false);
		ug.getGameBoard().emptyBoard();
		ug.getGameBoard().partiallyFillBoard();
		ug.getGameBoard().seedBoardNoScore(5);
		ug.getGameBoard().printArray();
		ug.setScore(0);
		ug.processMove(0, 0, 0);
		ug.getGameBoard().printArray();
		assertEquals("", -1, ug.getGameBoard().getTile(0, 0).getValue());
		assertEquals("", false, ug.getGameWon()); //Game should not be won
		assertEquals("", true, ug.getIsActive()); //Game should still be active
		assertEquals("", 0, ug.getPoints()); //Points should be 0 
		System.out.println("");
		
	}
	
//	@Test
	/**
	 * Test path B D G H K
	 * A tile is placed, does not have more than 3 adjacent tiles, does not have the correct value for removal, empties board
	 * Test should fail since removal does not occur, therefore board cannot be empty
	 */
	public void testBDGHK() {
		
		System.out.println("Test 11");
		ug.createNewGameBoard();
		ug.setGameWon(false);
		ug.getGameBoard().emptyBoard();
		ug.getGameBoard().seedBoardNoScore(5);
		ug.getGameBoard().printArray();
		ug.setScore(0);
		ug.processMove(0, 0, 5);
		ug.getGameBoard().printArray();
		assertEquals("", 5, ug.getGameBoard().getTile(0, 0).getValue());
		assertEquals("", true, ug.getGameWon()); //Game should be won
		assertEquals("", false, ug.getIsActive()); //Game should not still be active
		assertEquals("", 0, ug.getPoints()); //Points should be 0 
		System.out.println("");
		
	}
	
	@Test
	/**
	 * Test path B D G I L
	 * A tile is placed, does not have more than 3 adjacent tiles, does not have correct value for removal, fills board
	 */
	public void testBDGIL() {
		
		System.out.println("Test 12");
		ug.createNewGameBoard();
		ug.setGameWon(false);
		ug.getGameBoard().fillBoard();
		ug.getGameBoard().seedBoardNoScore(5);
		ug.getGameBoard().printArray();
		ug.setScore(0);
		ug.processMove(0, 0, 5);
		ug.getGameBoard().printArray();
		assertEquals("", 5, ug.getGameBoard().getTile(0, 0).getValue());
		assertEquals("", false, ug.getGameWon()); //Game should not be won
		assertEquals("", false, ug.getIsActive()); //Game should not still be active
		assertEquals("", 0, ug.getPoints()); //Points should be 0 
		System.out.println("");
		
	}
	
	@Test
	/**
	 * Test path BDGJ
	 * A tile is placed, does not have more than three adjacent tiles, does not have correct value for removal, neither empties nor fills board
	 */
	public void testBDGJ() {
		
		System.out.println("Test 13");
		ug.createNewGameBoard();
		ug.setGameWon(false);
		ug.getGameBoard().partiallyFillBoard();
		ug.getGameBoard().seedBoardNoScore(5);
		ug.getGameBoard().printArray();
		ug.setScore(0);
		ug.processMove(0, 0, 5);
		ug.getGameBoard().printArray();
		assertEquals("", 5, ug.getGameBoard().getTile(0, 0).getValue());
		assertEquals("", false, ug.getGameWon()); //Game should not be won
		assertEquals("", true, ug.getIsActive()); //Game should not still be active
		assertEquals("", 0, ug.getPoints()); //Points should be 0 
		System.out.println("");
		
	}

}
