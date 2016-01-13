#!/usr/bin/env bash
image=devenv
gid=`id $USER -g`
docker run -it --rm -v "$PWD":/usr/src/myapp -w /usr/src/myapp $image bower --allow-root "$@"
docker run -it --rm -v "$PWD":/usr/src/myapp -w /usr/src/myapp $image chown -R $UID:$gid ./
