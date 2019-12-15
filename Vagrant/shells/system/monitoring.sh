#!/bin/bash

echo "------- shell monitoring -------"

cd /vagrant/files/resources
tar xf monitoring.tar
cd monitoring
sh install.sh

rm -rf /vagrant/files/resources/monitoring
