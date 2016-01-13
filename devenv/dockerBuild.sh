#!/usr/bin/env bash
gid=`id $USER -g`
if [ "$http_proxy" ]; then
    echo Build dockerfile with proxy setttings
    sed -e 's@\${proxy}@'"$http_proxy"'@' .npmrc > ./nodejs_proxy/.npmrc
    sed -e 's@\${proxy}@'"$http_proxy"'@' ./.bowerrc > ./nodejs_proxy/.bowerrc
    sed -e 's@\${proxy}@'"$http_proxy"'@' ./.tsdrc > ./nodejs_proxy/.tsdrc
#    docker build --build-arg uid=$UID --build-arg user=$USER --build-arg gid=$gid  --build-arg proxy=$http_proxy -t devenv nodejs_proxy/
else
    echo Build dockerfile without proxy setttings
#    docker build --build-arg uid=$UID --build-arg user=$USER --build-arg gid=$gid -t devenv nodejs/
fi

