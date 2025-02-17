FROM ubuntu:latest
LABEL authors="citadin"

ENTRYPOINT ["top", "-b"]