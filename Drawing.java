import turtle.Turtle;

/*
 * Assignment number 3
 * File Name Computations.java
 * Omri Gotlieb
 * Student ID : 302671136
 * Email : omrigotlieb@gmail.com
 */

public class Drawing {

	/*
	 * This code draws an hexagon.
	 */
	public static void main(String[] args) {

		// Creates a turtle object and names it t.
		Turtle t = new Turtle();
		int n = 100;
		t.tailDown();

		// Draw a triangle and with a loop complete an Hexagon.
		for (int i = 0; i < 6; i++) {
			t.tailDown();
			t.moveForward(n);
			t.turnRight(120);
			t.moveForward(n);
			t.turnRight(120);
			t.moveForward(n);
			t.turnRight(60);

		}
		t.hide();
	}
}
