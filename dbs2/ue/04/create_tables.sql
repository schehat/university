DROP TABLE MovieGenre;
DROP TABLE Genre;
DROP TABLE MovieCharacter;
DROP TABLE Movie;
DROP TABLE Person;

DROP SEQUENCE genre_seq;
DROP SEQUENCE movie_seq;
DROP SEQUENCE person_seq;
DROP SEQUENCE mov_char_seq;

CREATE TABLE Genre (
    GenreID INTEGER,
    Genre VARCHAR(100),
    CONSTRAINT pk_genre PRIMARY KEY (GenreID)
);

CREATE TABLE Movie (
    MovieID INTEGER,
    Title VARCHAR(100),
    Year INTEGER,
    Type CHAR(1),
    CONSTRAINT pk_movie PRIMARY KEY (MovieID)
);

CREATE TABLE MovieGenre(
    GenreID INTEGER,
    MovieID INTEGER,
    CONSTRAINT fk_to_genre FOREIGN KEY (GenreID) REFERENCES Genre(GenreID),
    CONSTRAINT fk_to_movie FOREIGN KEY (MovieID) REFERENCES Movie(MovieID),
    CONSTRAINT pk_has_genre PRIMARY KEY (GenreID, MovieID)
);

CREATE TABLE Person (
    PersonID INTEGER,
    Name VARCHAR(100),
    Sex CHAR(1),
    CONSTRAINT pk_person PRIMARY KEY (PersonID)
);

CREATE TABLE MovieCharacter (
    MovCharID INTEGER,
    MovieID INTEGER,
    PersonID INTEGER,
    Character VARCHAR(100),
    Alias VARCHAR(100),
    Position INTEGER,
    CONSTRAINT fk_mov_char_to_movie FOREIGN KEY (MovieID) REFERENCES Movie(MovieID),
    CONSTRAINT fk_mov_char_to_person FOREIGN KEY (PersonID) REFERENCES Person(PersonID),
    CONSTRAINT pk_mov_char PRIMARY KEY (MovCharID)
);

CREATE SEQUENCE genre_seq;
CREATE SEQUENCE movie_seq;
CREATE SEQUENCE person_seq;
CREATE SEQUENCE mov_char_seq;

commit;

SELECT * FROM Genre;
SELECT * FROM hasGenre;
SELECT * FROM Movie;
SELECT * FROM MovieCharacter;
SELECT * FROM Person;