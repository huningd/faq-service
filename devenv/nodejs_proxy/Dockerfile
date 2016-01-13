# Pull base image.
FROM node:5-onbuild

#Args
ARG user
ARG uid
ARG gid
ARG proxy

# Config Proxy
ENV http_proxy $proxy
ENV https_proxy $proxy
RUN npm config set proxy $proxy
RUN npm config set https-proxy $proxy
RUN npm config set registry http://registry.npmjs.org/

# Add local User
RUN addgroup -gid $gid $user
RUN (adduser --system --uid=$uid --gid $gid \
        --home /home/$user --shell /bin/bash $user)

COPY .bowerrc /root/
COPY .tsdrc /root/
COPY .npmrc /root/

RUN npm install -g bower grunt-cli tsd

# Define working directory.
WORKDIR /data

# Define default command.
CMD ["bash"]
