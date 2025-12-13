package _04_Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class Snake {
	public static final Color SNAKE_COLOR = Color.BLUE;
	public static final int BODY_SIZE = 50;

	private SnakeSegment head;
	private ArrayList<SnakeSegment> snake;

	private Direction currentDirection;

	private boolean canMove = true;

	public Snake(Location location) {
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE);
		snake.add(head);
		currentDirection = Direction.RIGHT;
	}

	public void feed() {
		snake.add(new SnakeSegment(snake.get(0).getLocation(), BODY_SIZE));
	}

	public Location getHeadLocation() {
		return head.getLocation();
	}

	public void update() {

		/*
		 * Create variables for the next X and Y location of the snake's head.
		 * Initialize them to the current X and Y locations.
		 */
		int currentX = head.getLocation().getX();
		int currentY = head.getLocation().getY();
		int nextX = currentX;
		int nextY = currentY;
		/*
		 * Use a switch statement to check on the currentDirection of the snake and
		 * calculate the head's next x and y position. Depending on the direction, the
		 * variables you created may increase or decrease by 1.
		 */
		switch (currentDirection) {
		case UP:
			nextY = nextY - 1;
			break;
		case DOWN:
			nextY = nextY + 1;
			break;
		case LEFT:
			nextX = nextX - 1;
			break;
		case RIGHT:
			nextX = nextX + 1;
			break;
		}
		/*
		 * NEEDS WORK Change the Location of each SnakeSegment in your snake ArrayList to the
		 * Location of the segment in front of it.
		 * 
		 * Use a loop starting at the end of the ArrayList and stop before the head of
		 * the snake (index 0) or you will go out of bounds.
		 */
		for (int i = snake.size() - 1; i > 0; i--) {
			//snake segment and setting it to the segment in front(i-1 because backwards)
			snake.set(i, snake.get(i - 1));
		}
		/*
		 * Create a new Location object and initialize it with the values calculated in
		 * the first step. Then set the head's location equal to the new location.
		 */
		Location newLocation = new Location(nextX, nextY);
		head.setLocation(newLocation);
		// Set the canMove member variable to true.
		canMove = true;
	}

	public void setDirection(Direction direction) {

		/*
		 * If the passed in direction is not the opposite direction of currentDirection
		 * and canMove is true, set currentDirection to the passed in direction and
		 * canMove to false
		 * 
		 * Hint: Use the isNotOppositeDirection method.
		 */
		if (isNotOppositeDirection(direction) && canMove) {
			currentDirection = direction;
			canMove = false;
		}
	}

	private boolean isNotOppositeDirection(Direction direction) {

		/*
		 * Complete the method so it returns true if the passed in direction is not the
		 * opposite direction of currentDirection.
		 * 
		 * For example, if currentDirection is UP and the passed in direction is DOWN
		 * this method should return false.
		 */
		switch (currentDirection) {
		case UP:
			return direction != Direction.DOWN;
		case DOWN:
			return direction != Direction.UP;
		case RIGHT:
			return direction != Direction.LEFT;
		case LEFT:
			return direction != Direction.RIGHT;
		default:
			return true;
		}
	}

	public void resetLocation() {

		// Clear the snake.
		snake.clear();
		/*
		 * Create a new Location object for the head at SnakeGame.WIDTH / 2,
		 * SnakeGame.HEIGHT / 2.
		 */
		Location start = new Location(SnakeGame.WIDTH / 2, SnakeGame.HEIGHT / 2);
		/*
		 * Set the head member variable equal to a new SnakeSegment object. Use the
		 * Location created in step 2 for the Location and the BODY_SIZE constant for
		 * the size.
		 */
		head = new SnakeSegment(start, BODY_SIZE);
		// Add the head to the snake.
		snake.add(head);

	}

	public boolean isOutOfBounds() {
		/*
		 * Complete the method so it returns true if the head of the snake is outside of
		 * the window and false otherwise.
		 */
		int headX = head.getLocation().getX();
		int headY = head.getLocation().getY();
		if (headX < 0 && headX >= SnakeGame.WINDOW_WIDTH) {
			return true;
		}
		if (headY < 0 && headY >= SnakeGame.WINDOW_HEIGHT) {
			return true;
		}
		return false;
	}

	public boolean isHeadCollidingWithBody() {

		/*
		 * Complete the method so it returns true if the head is located in the same
		 * location as any other body segment.
		 */
		for (int i = 1; i < snake.size(); i++) {
			if (snake.get(i).getLocation().equals(getHeadLocation())) {
				return true;
			}
		}
		return false;
	}

	public boolean isLocationOnSnake(Location loc) {

		/*
		 * Complete the method so it returns true if the passed in location is located
		 * on the snake.
		 */
		for (int i = snake.size(); i < 0; i--) {
			if (snake.get(i).getLocation().equals(loc)) {
				return true;
			}
		}
		return false;
	}

	public void draw(Graphics g) {
		for (SnakeSegment s : snake) {
			s.draw(g);
		}
	}
}
