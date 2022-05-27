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

    @Value("${api.url}")
    private String url;

    @Value("${api.currency}")
    private String currency;

    public Course getCurrentCourseFromApi(String date) {
        date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy")).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        logger.debug("response URL: " + url + "?" + "currency=" + currency + "&date=" + date + "&format=json");
        Course course = restTemplate.getForObject(url + "?" + "currency=" + currency + "&date=" + date + "&format=json", Course.class);
        logger.debug("invocation getCurrentCourseFromApi method and get course: " + course);
        return course;
    }

    @Cacheable(value = "courses", key = "#date")
    public Course getCourse(String date) {
        return getCurrentCourseFromApi(date);
    }
}