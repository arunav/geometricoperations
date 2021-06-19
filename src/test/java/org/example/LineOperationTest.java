package org.example;

import org.example.exception.InvalidInputException;
import org.example.pojo.Point;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class LineOperationTest {

    @InjectMocks
    private LineOperations lineOperations;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void lineByMeansOfTwoPointsTest(){
        Point pointDetails = new Point();
        pointDetails.setX1(3);
        pointDetails.setX2(2);
        pointDetails.setY1(2);
        pointDetails.setY2(6);
       String line =  lineOperations.lineByMeansOfTwoPoints(pointDetails);
       assertNotNull(line);
       assertEquals(line,"4X+1Y =14");

    }

    @Test
    public void lineByMeansOfTwoPointsTestWithNULLValues(){
        Point pointDetails = null;
        String line =  lineOperations.lineByMeansOfTwoPoints(pointDetails);
        assertNull(line);
       }

       @Test
       public void lineByMeansOfGradientAndYInterceptTest() throws InvalidInputException {
        String response = lineOperations.lineByMeansOfGradientAndYIntercept(3,4);
        assertNotNull(response);
        assertEquals(response,"Y =3x +4");

       }

    @Test(expected = InvalidInputException.class)
    public void lineByMeansOfGradientAndYInterceptTestWithNULLValues() throws InvalidInputException {
        String response = lineOperations.lineByMeansOfGradientAndYIntercept(null,4);

    }

    @Test
    public void findConditionForParallelOfTwoLinesTest(){
        Boolean response = lineOperations.findConditionForParallelOfTwoLines(3,3);
        assertTrue(response);
        assertEquals(response,Boolean.TRUE);

    }
    @Test
    public void findConditionForParallelOfTwoLinesTestFailureScenario(){
        Boolean response = lineOperations.findConditionForParallelOfTwoLines(3,4);
        assertFalse(response);
        assertEquals(response,Boolean.FALSE);

    }
    @Test
    public void findConditioOfPerpenducularityOfLinesTest() throws InvalidInputException {
        Boolean response = lineOperations.findConditioOfPerpenducularityOfLines(1,-1);
        assertTrue(response);
        assertEquals(response,Boolean.TRUE);

    }

    @Test
    public void findConditioOfPerpenducularityOfLinesTestFailureScenario() throws InvalidInputException {
        Boolean response = lineOperations.findConditioOfPerpenducularityOfLines(3,-1);
        assertFalse(response);
        assertEquals(response,Boolean.FALSE);

    }

    @Test
    public void findConditionOfIncidenceOfTwoLinesTest() throws InvalidInputException {
        Boolean response = lineOperations.findConditionOfIncidenceOfTwoLines(3,-1);
        assertTrue(response);
        assertEquals(response,Boolean.TRUE);

    }
    @Test
    public void findConditionOfIncidenceOfTwoLinesTestFailureScenario() throws InvalidInputException {
        Boolean response = lineOperations.findConditionOfIncidenceOfTwoLines(3,3);
        assertFalse(response);
        assertEquals(response,Boolean.FALSE);

    }
    @Test(expected = InvalidInputException.class)
    public void findConditionOfIncidenceOfTwoLinesTestFailureScenarioTest() throws InvalidInputException {
         lineOperations.findConditionOfIncidenceOfTwoLines(null,null);

    }


}
