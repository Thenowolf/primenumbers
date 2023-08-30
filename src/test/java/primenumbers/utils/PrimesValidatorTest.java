package primenumbers.utils;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import primenumbers.utils.PrimesValidator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PrimesValidatorTest {

	private PrimesValidator validator;
	private long number;
	private boolean result;
	private Class<? extends Exception> exception;
	
	public PrimesValidatorTest(long number, boolean result, Class<? extends Exception> exception){
		this.number = number;
		this.result = result;
		this.exception = exception;
	}
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Before
	public void setUp() {
		validator = new PrimesValidator();
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> numbers() {
		return Arrays.asList(new Object[][] {
			{ 5742, false, null },
			{ 211, true, null },
			{ 524287, true, null },
			{ 7581466577L, true, null },
			{ 8054411649902370509L, true, null },
			{ 4864621469650257567L, false, null },
			{ 0, false, null },
			{ -142, false, null },
			{ 1, true, null },
			{ 2, true, null },
			{ 3, true, null }
		});
	} 
	
	@Test
	public void test() {
		if(exception != null) {
			exceptionRule.expect(exception);
		}
		assertEquals(result, validator.isPrime(number));
	}
}
