#!/bin/bash

echo "-------- grep_run --------"

#hadoop jar /usr/local/hadoop/share/hadoop/mapreduce/hadoop-mapreduce-examples-2.6.4.jar grep input/hadoop output 'dfs[a-z]+'
#hadoop jar /vagrant/hadoopex.jar input\hadoop output


#hadoop jar /user/vagrant/hadoopex.jar /user/vagrant/input1 output


#hadoop jar hadoopex.jar /user/vagrant/input1 output

hadoop jar hadoopex.jar /user/vagrant/input/hadoop/input.txt output