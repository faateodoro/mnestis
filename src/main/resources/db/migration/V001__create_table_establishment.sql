CREATE TABLE Establishment (
    id INTEGER PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cnpj VARCHAR(14) NOT NULL,
    address VARCHAR(150) NOT NULL,
    phone VARCHAR(11) NOT NULL,
    motorcycleVacancy SMALLINT NOT NULL,
    carVacancy SMALLINT NOT NULL,
    createdAt TIMESTAMP NOT NULL
)