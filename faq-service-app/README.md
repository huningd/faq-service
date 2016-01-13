# faq-service-app
## Install
Install Node.JS (Debian and Ubuntu based Linux distributions) 
```shell
curl -sL https://deb.nodesource.com/setup_5.x | sudo -E bash -
sudo apt-get install -y nodejs
```
Install npm, bower, grunt-cli and tsd
```shell
npm install npm -g
npm install -g bower
npm install -g grunt-cli
npm install -g tsd
```
## Build
```shell
npm install
bower install
tsd install
grunt
```

## Hints
add new tools with:
```Bash
npm install --save grunt
```

add new dependencies with:
```shell
bower install --save alertifyjs
```
Add new type definitions with:
```shell
tsd install alertify --save
```
Query for type definitions with:
```shell
tsd query alertify
```


## Build with Docker
The folder devenv contains a Node.js build environment as docker images. Simple run the script dockerBuild.sh. This script set ups a docker images named devenv with npm, tsd, grunt and bower. It also configures the proxy settings if the http_proxy environment variable is set. 
Additional this folder contains some scripts to easily build a JavaScript project, execute bower or grunt. If you like to use this scripts copy them into the project root folder and make them executable.

## Informations
http://tinyurl.com/AngularTodayTomorrow
https://angularu.com/VideoSession/2015sf/dan-and-john-bringing-their-view-on-the-latest-in-angular
