#!/bin/bash

echo "-------- hdfs_put_input --------"

hdfs dfsadmin -safemode leave

hdfs dfs -rm -r -f /user/vagrant/output
	#hdfs dfs -put /usr/local/hadoop/etc/hadoop/ input
hdfs dfs -put -f /vagrant/moje/data.txt input.txt



#hdfs dfs -put -f /vagrant/hadoopex.jar hadoopex.jar


