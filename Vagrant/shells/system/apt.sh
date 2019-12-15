#!/bin/bash

echo "------- shell apt -------"

apt-get update
apt-get remove --purge openjdk-* -y

echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections
add-apt-repository -y ppa:ts.sch.gr/ppa
apt-get update
apt-get install -y oracle-java8-installer rsync dsh htop git maven unzip openssh-server
