package io.github.ji0610.deadlinetracker.course;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courses;

    public CourseService(CourseRepository courses) {
        this.courses = courses;
    }

    @Transactional(readOnly = true)
    public List<CourseResponse> findAll() {
        return courses.findAll().stream()
                .map(CourseResponse::from)
                .toList();
    }
}
