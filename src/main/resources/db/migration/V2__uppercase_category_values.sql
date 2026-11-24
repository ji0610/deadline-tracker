ALTER TABLE deadline DROP CONSTRAINT deadline_category_check;

ALTER TABLE deadline ADD CONSTRAINT deadline_category_check 
CHECK (category IN ('HOMEWORK', 'EXAM',  'PROJECT', 'QUIZ', 'OTHER'));

