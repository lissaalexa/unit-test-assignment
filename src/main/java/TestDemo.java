import java.util.Random;

public class TestDemo {

//Instance method (not static) named addPositive with 2 int parameters and return an int
public int addPositive(int a, int b) {
	//checks if both parameters are positive (greater than 0)
	if (a > 0 && b > 0) {
		//if both parameters are positive, return their sum of the parameters
		return a + b;
		} else {
			//if either parameter is 0 or negative, it throws an IllegalArgumentException with the message
			throw new IllegalArgumentException ("Both parameters must be positive!");
		}
	}

public int randomNumberSquared1() {
	//this method obtains a random int between 1 and 10 and then returns the square of the number
	Random random = new Random();
	  return random.nextInt(10) + 1;
	}
	int randomNumberSquared() {
		//Call the getRandomInt() method to get a random integer
		int randomInt = getRandomInt();
		return randomInt * randomInt;
	}

public int getRandomInt() {
	//Call the getRandomInt() method to get a random integer
	Random random = new Random();
		return random.nextInt(10) + 1;
	}
}
