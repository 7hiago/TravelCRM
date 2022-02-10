package org.laba2.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.laba2.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CourseService {

    private static final Logger logger = LogManager.getLogger(CourseService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${bankAPI.url}")
    private String url;

    @Value("${bankAPI.value}")
    private String value;

    public Course getCurrentCourseFromApi(String exchangedate) {
        exchangedate = LocalDate.parse(exchangedate, DateTimeFormatter.ofPattern("dd.MM.yyyy")).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        Course[] course = restTemplate.getForObject(url + value + "&date=" + exchangedate + "&json", Course[].class);
        logger.debug("invocation getCurrentCourseFromApi method and get course: " + course[0].toString());
        return course[0];
    }

    @Cacheable(value = "courses", key = "#exchangedate")
    public Course getCourse(String exchangedate) {
        return getCurrentCourseFromApi(exchangedate);
    }
}