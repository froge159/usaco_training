import static java.lang.System.*;
import java.util.Scanner;


public class ClickBait {
	public static void main(String args[]) 
	{
		Scanner input = new Scanner(in);
		
		int circleX, circleY, circleWidth;
		int upperX, upperY, rectangleWidth, rectangleLength;
		int x,y;
		boolean isCircle, isRectangle;
		
		out.println("Enter in x-coordinate of circle:");
		circleX = input.nextInt();
		out.println("Enter in y-coordinate of circle:");
		circleY = input.nextInt();
		out.println("Enter in width of circle:");
		circleWidth = input.nextInt();
		out.println("Enter in x-coordinate of rectangle:");
		upperX = input.nextInt();
		out.println("Enter in y-coordinate of rectangle:");
		upperY = input.nextInt();
		out.println("Enter in width of rectangle:");
		rectangleWidth = input.nextInt();
		out.println("Enter in height of rectangle:");
		rectangleLength = input.nextInt();
		out.println("Enter x-coordinate of mouse click:");
		x = input.nextInt();
		out.println("Enter y-coordinate of mouse click:");
		y = input.nextInt();
		isCircle = checkCircle(circleX, circleY, circleWidth, x, y);
		isRectangle = checkRect(upperX, upperY, rectangleWidth, rectangleLength, x, y);
		printResult(isCircle, isRectangle);
	}
	static boolean checkCircle(int circleX, int circleY, int circleWidth, int x, int y) {
	    double r = circleWidth / 2;
	    double xp = (circleX + circleWidth) / 2; double yp = (circleY - circleWidth) / 2;
	    if (Math.sqrt(Math.pow(Math.abs(xp - x), 2) + Math.pow(Math.abs(yp - y), 2)) <= r) {
	        return true;
	    }
	    return false;
	}
	static boolean checkRect(int upperX, int upperY, int rectangleWidth,int rectangleLength, int x, int y) {
	    if (upperX <= x && x <= upperX + rectangleWidth && upperY - rectangleLength <= y && y <= upperY) {
	        return true;
	    }
	    return false;
	}
	static void printResult(boolean isCircle, boolean isRectangle) {
	    if (isCircle && !isRectangle) System.out.println("circle");
	    else if (!isCircle && isRectangle) System.out.println("rectangle");
	    else if (!isCircle && !isRectangle) System.out.println("neither");
	}
	
	
}
