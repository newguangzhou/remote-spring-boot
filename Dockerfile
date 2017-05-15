FROM
 ubuntu:14.04

USER
 root

RUN
 apt-get install -y
 apache2

EXPOSE
 9700