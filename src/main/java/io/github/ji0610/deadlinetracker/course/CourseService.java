package io.github.ji0610.deadlinetracker.course;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    private Course getOrThrow(Long id) {
        Optional<Course> maybeCourse = courses.findById(id);
        if (maybeCourse.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course " + id + " not found");
        }
        return maybeCourse.get();
    }

    @Transactional(readOnly = true)
    public CourseResponse findById(Long id) {
        Course course = getOrThrow(id);
        return CourseResponse.from(course);
    }

}
