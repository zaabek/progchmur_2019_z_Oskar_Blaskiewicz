package com.umermansoor;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
import org.apache.hadoop.io.Text;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


public class EarthquakeReducer extends
        Reducer<Text, DoubleWritable, Text, DoubleWritable> 
{

    @Override
    public void reduce(Text key, Iterable<DoubleWritable> values, 
            Context context) throws IOException, InterruptedException {
        char palec = key.toString().charAt(0);
       // System.out.println(palec);
       // System.out.println("raz");
        double odchylenie_standardowe = 0;
        double[] dlugosci = new double [20];
        int i = 0;
        double srednia = 0;
        for (DoubleWritable value : values) {
            dlugosci[i] = value.get();
            srednia += dlugosci[i];
            i = i +1;
        }
        int max = i;
        srednia = srednia/max;

        for (i =0 ; i<max ; i++)
        {
            odchylenie_standardowe += (srednia - dlugosci[i]) * (srednia - dlugosci[i]);
        }
        odchylenie_standardowe =odchylenie_standardowe/max;

        //System.out.println(sqrt(odchylenie_standardowe));
        Text a = new Text (String.valueOf(palec));
        context.write(key, new DoubleWritable(sqrt(odchylenie_standardowe)));
    }
}
