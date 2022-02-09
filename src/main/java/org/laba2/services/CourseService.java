package org.laba2.services;

import org.laba2.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CourseService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${bankAPI.url}")
    private String url;

    @Value("${bankAPI.value}")
    private String value;

    private Course course;

    public Course getCurrentCourse() {
        Course[] course = restTemplate.getForObject(url + value + "&json", Course[].class);
        return course[0];
    }

    public float getRate() {
        return course.getRate();
    }

    public void updateRate() {
        course = getCurrentCourse();
    }
}