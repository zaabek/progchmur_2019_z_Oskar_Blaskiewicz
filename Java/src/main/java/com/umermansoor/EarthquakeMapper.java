package com.umermansoor;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


/**
 * This is the main Mapper class. 
 * 
 * @author umermansoor
 */
public class EarthquakeMapper extends 
        Mapper<LongWritable, Text, Text, DoubleWritable> 
{

    @Override
    public void map(LongWritable key, Text value, Context context) throws 
            IOException, InterruptedException {
    double[] dlugosci = new double [5];
    String palec = null;
    String osoba = null;

    try {
        Object obj = new JSONParser().parse(value.toString());
        JSONObject jo = (JSONObject) obj;
       // System.out.println(jo);

        Object obj1 = new JSONParser().parse(jo.get("features2D").toString());
        JSONObject palce = (JSONObject) obj1;

        dlugosci[0] =  new Double(palce.get("first").toString()).doubleValue();
        dlugosci[1] =  new Double(palce.get("second").toString()).doubleValue();
        dlugosci[2] =  new Double(palce.get("third").toString()).doubleValue();
        dlugosci[3] =  new Double(palce.get("fourth").toString()).doubleValue();
        dlugosci[4] =  new Double(palce.get("fifth").toString()).doubleValue();

        palec = (String) jo.get("side");
        osoba = jo.get("series").toString();

    } catch (ParseException e) {
        e.printStackTrace();
    }
        context.write(new Text(palec + "_" + osoba + "_" + "1"), new DoubleWritable(dlugosci[0]));
        context.write(new Text(palec + "_" + osoba + "_" + "2"), new DoubleWritable(dlugosci[1]));
        context.write(new Text(palec + "_" + osoba + "_" + "3"), new DoubleWritable(dlugosci[2]));
        context.write(new Text(palec + "_" + osoba + "_" + "4"), new DoubleWritable(dlugosci[3]));
        context.write(new Text(palec + "_" + osoba + "_" + "5"), new DoubleWritable(dlugosci[4]));


//    context.write(new Text(String.valueOf(palec)+key), new DoubleWritable(dlugosci[0]));
//    context.write(new Text(String.valueOf(palec)+key), new DoubleWritable(dlugosci[1]));
//    context.write(new Text(String.valueOf(palec)+key), new DoubleWritable(dlugosci[2]));
//    context.write(new Text(String.valueOf(palec)+key), new DoubleWritable(dlugosci[3]));
//    context.write(new Text(String.valueOf(palec)+key), new DoubleWritable(dlugosci[4]));
}
}
