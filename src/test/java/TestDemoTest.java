import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoTest {
	private TestDemo testDemo;
	
	@BeforeEach
	//The setUp method is annotated with @BeforeEach and is executed before each test method
	//it initializes the testDemo field by creating a new instance of the TestDemo class
	void setUp() {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	//marks the assertThatTwoPositiveNumbersAreAddedCorrectly method as a parameterized test
	//this method is executed multiple times with different sets of arguments
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		//method takes 4 parameters and verifies the behaviour of the addPositive method in the TestDemo class
		if(!expectException) {
			  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
			  //if it is false, assert that when TestDemo.addPositive is called with values a and b, that the result
			  //is the same as the parameter expected
			} else {
				//else statement asserts that when the expectException is true, the testDemo.addPositive(a, b) method
				//throws an IllegalArgumentException exception
				assertThatThrownBy(() -> 
			    testDemo.addPositive(a, b))
			        .isInstanceOf(IllegalArgumentException.class);
			}
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy (new TestDemo());
		doReturn(5).when(mockDemo).getRandomInt();
		//creates a spy object of the TestDemo class named mockDemo using Mockito.spy method
		//always returns 5
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
		//asserts fiveSquared = 25
	}
	
	//The argumentsForAddPositive method returns a Stream of <Arguments> which contains various parameter sets
	private static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				//each Arguments.of() call represents a set of arguments for testing
					//the values correspond to the parameters a, b, expected, and expectException
					//in the assertThatTwoPositiveNumbersAreAddedCorrectly method
				Arguments.of(2, 4, 6, false),
				Arguments.of(-2, 3, 0, true),
				Arguments.of(0, 5, 0, true),
				Arguments.of(6, -4, 0, true),
				//Additional test cases
				Arguments.of(5, 5, 10, false),
				Arguments.of(0, 0, 0, true),
				Arguments.of(-5, -10, 0, true)
		);
	}
}
