#!/usr/bin/env bash
image=devenv
gid=`id $USER -g`
docker run -it --rm -v "$PWD":/usr/src/myapp -w /usr/src/myapp $image /bin/bash -c "npm install && bower install -s --allow-root"
docker run -it --rm -v "$PWD":/usr/src/myapp -w /usr/src/myapp $image /bin/bash -c "grunt"
#All files was generated as user root. Hence change owner to local user.
docker run -it --rm -v "$PWD":/usr/src/myapp -w /usr/src/myapp $image chown -R $UID:$gid ./
