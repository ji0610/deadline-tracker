CREATE TABLE course (
    id         bigint       GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name       text         NOT NULL,
    acronym    text         NOT NULL UNIQUE,
    created_at timestamptz  NOT NULL DEFAULT now()
);

CREATE TABLE deadline (
    id            bigint       GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title         text         NOT NULL,
    due_at        timestamptz  NOT NULL,
    category      text         NOT NULL CHECK (category IN ('homework', 'exam', 'project', 'quiz', 'other')),
    description   text,
    completed_at  timestamptz,
    created_at    timestamptz  NOT NULL DEFAULT now(),
    course_id     bigint       NOT NULL REFERENCES course (id) ON DELETE CASCADE
);

CREATE INDEX deadline_course_id_idx ON deadline (course_id);
