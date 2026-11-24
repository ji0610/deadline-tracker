package io.github.ji0610.deadlinetracker.course;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<CourseResponse> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CourseResponse get(@PathVariable Long id) {
        return service.findById(id);
    }

}
