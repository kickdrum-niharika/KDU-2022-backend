public class Lines
{

    float slope;
    float y_intercept;
    Lines(float m,float c)
    {
        slope = m;
        y_intercept = c;
    }



    void checkParallel(float m,float c)throws ParallelLinesException
    {
        if(m==this.slope)
        {
            throw new ParallelLinesException("THE LINES ARE PARALLEL!!!");
        }
        else
        {
            findIntersection(m,c);
        }
    }

    private void findIntersection(float m, float c)
    {
        float intersection_X = (c - this.y_intercept) / (m - this.slope);

        float intersection_Y = slope* intersection_X + y_intercept;
        System.out.println("Point of intersection : ("+intersection_X+","+intersection_Y+")");
    }


}

