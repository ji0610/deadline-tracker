package io.github.ji0610.deadlinetracker.deadline;

import io.github.ji0610.deadlinetracker.course.Course;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "deadline")
public class Deadline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Instant dueAt;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String description;

    private Instant completedAt;

    @CreationTimestamp
    private Instant createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id")
    private Course course;

    protected Deadline() {
    }

    public Deadline(String title, Instant dueAt, Category category, String description, Course course) {
        this.title = title;
        this.dueAt = dueAt;
        this.category = category;
        this.description = description;
        this.course = course;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public Instant getDueAt() {
        return dueAt;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public Instant getCompletedAt() {
        return completedAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Course getCourse() {
        return course;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDueAt(Instant dueAt) {
        this.dueAt = dueAt;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompletedAt(Instant completedAt) {
        this.completedAt = completedAt;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
