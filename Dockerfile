FROM ubuntu:latest
LABEL authors="angel"

ENTRYPOINT ["top", "-b"]