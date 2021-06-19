package org.example;

import org.example.exception.InvalidInputException;
import org.example.pojo.Line;
import org.example.pojo.Point;

import java.util.Objects;

public class LineOperations {

    int a =0 , b =0,c=0;

    /**
     * Given method is used to define the line equation when you have given two points
     * inputs are point1= (x1,y1) and point2=(x2,y2)
     * According to line any line can be represented as ax+by =c
     * If the points satisfy the above line equation then it should be
     * ax1+by1=c
     * ax2+by2=c
     * a= y2-y1,b=x1-x2,c=ax1+by1
     * @param pointsDetails
     * @return
     */
    public String lineByMeansOfTwoPoints(Point pointsDetails) {
       String lineEquation  = null;
        try {
        if(pointsDetails!=null) {
            Line line = new Line();
            a = pointsDetails.getY2() - pointsDetails.getY1();
            b = pointsDetails.getX1() - pointsDetails.getX2();
            c = a * pointsDetails.getX1() + b * pointsDetails.getY1();
            line.setA(a);
            line.setB(b);
            line.setIntercept(c);
            lineEquation = line.toString();
        }
       }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return lineEquation;
    }

    /**Given method is used to get line equation
     * when u have slope and intercept with you
     * The formula is y=mx+c and here m is gradient and c is Y interceptor
     * @param gradient
     * @param intercept
     * @return String
     */
    public String lineByMeansOfGradientAndYIntercept(Integer gradient, Integer intercept) throws InvalidInputException {
        String lineEquation = null;
       if(gradient!=null && intercept!=null) {
           lineEquation = new StringBuilder().append("Y =").append(gradient).append("x +").append(intercept).toString();
       }
       else{
           throw new InvalidInputException("Please eneter proper gradient and intercept values");
       }
        return lineEquation;
    }

    /**
     * Givem method is used to findCondition whether two lines are parallel or not
     * @Condition for the lines to be parallel in terms of their slopes m1=m2
     * m1&m2 are slopes
     * @return
     */
    public boolean findConditionForParallelOfTwoLines(Integer m1,Integer m2){

        if(m1.equals(m2)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * This method is used to find perpenducularity of two lines
     * When two lines are interseting with 90 degree angle then we can say tose lines are perpenducular lines
     * @return
     */
    public boolean findConditioOfPerpenducularityOfLines(Integer m1,Integer m2) throws InvalidInputException {

        if (m1 != null && m2 != null) {
            if (Objects.equals(m1 * m2, -1)) {
                return Boolean.TRUE;
            }
        }
        else {
            throw new InvalidInputException("Slopes of two lines are null-Please pass valid values");
        }
        return Boolean.FALSE;
    }

    /**
     * Given method is used to find the incidense of two lines.
     * The condition is if two lines slopes are not equal the those lines will intersect at any of the point.
     * @param m1
     * @param m2
     * @return
     */
    public boolean findConditionOfIncidenceOfTwoLines(Integer m1,Integer m2) throws InvalidInputException {
        if (m1 != null && m2 != null) {
            if (!m1.equals(m2)) {
                return Boolean.TRUE;
            }
        }
        else {
            throw new InvalidInputException("Slopes of two lines are null-Please pass valid values");
        }
        return Boolean.FALSE;
    }
}
