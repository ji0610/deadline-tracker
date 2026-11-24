# Data model

Description of data model for the deadline tracker. 

### course
| column     | type        | constraints              | notes |
|------------|-------------|--------------------------|-------|
| id         | bigint      | PK, generated            |       |
| name       | text        | NOT NULL                 |       |
| acronym    | text        | NOT NULL, UNIQUE         | handle upper / lower case | 
| created_at | timestamptz | NOT NULL, default now()  |       |

### deadline
| column       | type        | constraints                          | notes |
|--------------|-------------|--------------------------------------|-------|
| id           | bigint      | PK, generated                        |       |
| title        | text        | NOT NULL                             |       |
| due_at       | timestamptz | NOT NULL                             |       |
| category     | text        | NOT NULL, CHECK (category IN ('HOMEWORK', 'EXAM', 'PROJECT', 'QUIZ', 'OTHER')) |       |
| description  | text        |                                      |optional|
| completed_at | timestamptz |                                      | if done -> timestamptz, otherwise nullable |
| created_at   | timestamptz | NOT NULL, default now()              |       |
| course_id    | bigint      | NOT NULL, FK -> course(id), ON DELETE CASCADE | one course has multiple deadlines|

## Decisions

- Using timestamptz for due date types, because it stores the exact moment in time, regardless of the time zone. 
- Acronym for the course has to be unique and will be saved in uppercase.
- All fields are required except for deadline description and completed_at, which is NULL by default.
- For completed_at, instead of basic boolean we use a timestamptz, which allows to record the time of completion, together with the option of it being NULL, which means that it's uncompleted.
- When deleting the course, if there are any existing deadlines connected to it, you will be warned about their upcoming deletion. If confirmed, they will get erased.
- For deadline type (category), we're using a fixed list of options including "other", where you can further explain in description.
- Category values are stored in uppercase (`HOMEWORK`, …) so they match the Java enum constant names, which JPA stores with `EnumType.STRING`. Changed from lowercase in migration V2.

## Future ideas

- Courses could be archived instead of deleted
