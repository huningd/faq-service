# Pull base image.
FROM node:5-onbuild

#Args
ARG user
ARG uid
ARG gid

# Add local User
RUN addgroup -gid $gid $user
RUN (adduser --system --uid=$uid --gid $gid \
        --home /home/$user --shell /bin/bash $user)

RUN npm install -g bower grunt-cli tsd

# Define working directory.
WORKDIR /data

# Define default command.
CMD ["bash"]
