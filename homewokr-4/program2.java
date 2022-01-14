import java.lang.Math;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class program2
{
    public static void main(String args[])
    {
        Random random = new Random();
        List<Long> randomNumbersList = random.longs( 10000 ).boxed().collect( Collectors.toList() );
        long timetakenForEach = measureForEach(randomNumbersList);
        long timetakenStream = measureStream(randomNumbersList);
        long timetakenParallelStream = measureParallelStream(randomNumbersList);
        System.out.println("Time Taken by:\nforeach:"+timetakenForEach);
        System.out.println("Stream: "+timetakenStream);
        System.out.println("Parallel Stream: "+timetakenParallelStream);

    }

    private static long measureParallelStream(List<Long> randomNumbers)
    {
        long startTime = System.currentTimeMillis();
        randomNumbers.parallelStream().forEach(i->increment(i,Integer.toUnsignedLong(10)));
        randomNumbers.parallelStream().forEach(i->System.out.println(i));
        long stopTime = System.currentTimeMillis();
        return stopTime-startTime;

    }

    private static long measureStream(List<Long> randomNumbers)
    {
        long startTime = System.currentTimeMillis();
        randomNumbers.stream().forEach(i->increment(i,Integer.toUnsignedLong(10)));
        randomNumbers.stream().forEach(i->System.out.println(i));
        long stopTime = System.currentTimeMillis();
        return stopTime-startTime;

    }
    private static Long increment(Long num, Long incrementBy)
    {
        return num+incrementBy;
    }
    private static long measureForEach(List<Long> randomNumbers)
    {
        long startTime = System.currentTimeMillis();
        System.out.println("Adding 10 and printing using for each loop");
        for (Long i:randomNumbers)
        {
            i+=10;
            System.out.println(i);
        }
        long stopTime = System.currentTimeMillis();
        return stopTime-startTime;

    }
}
