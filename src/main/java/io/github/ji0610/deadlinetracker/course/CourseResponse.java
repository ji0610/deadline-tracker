package io.github.ji0610.deadlinetracker.course;

import java.time.Instant;

public record CourseResponse(Long id, String name, String acronym, Instant createdAt) {
    static CourseResponse from(Course course) {
        return new CourseResponse(course.getId(), course.getName(), course.getAcronym(), course.getCreatedAt());
    }
}
