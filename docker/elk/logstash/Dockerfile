FROM logstash:5.2.1
EXPOSE 9600
RUN logstash-plugin install logstash-filter-geoip
RUN logstash-plugin install logstash-filter-dissect
RUN mkdir /input /output
VOLUME /input /output
ADD ./config/logstash.yml /usr/share/logstash/config/logstash.yml
COPY ./pipeline/logstash-test.conf /pipeline/
CMD [ "-f", "/pipeline/logstash-test.conf" ]
