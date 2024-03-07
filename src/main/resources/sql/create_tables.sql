-- Table: locations
CREATE TABLE IF NOT EXISTS locations
(
    id      BIGSERIAL PRIMARY KEY,
    country VARCHAR(255) NOT NULL,
    region  VARCHAR(255) NOT NULL,
    city    VARCHAR(255) NOT NULL,
    street  VARCHAR(255) NOT NULL
);

-- Table: jobs
CREATE TABLE IF NOT EXISTS jobs
(
    id                   BIGSERIAL PRIMARY KEY,
    name                 VARCHAR(255) NOT NULL,
    start_date           DATE         NOT NULL,
    end_date             DATE         NOT NULL,
    schedule_description VARCHAR(255) NOT NULL,
    job_description      VARCHAR(255) NOT NULL,
    image                VARCHAR(255) NOT NULL,
    job_location_id      BIGINT       NOT NULL,
    CONSTRAINT fk_job_location FOREIGN KEY (job_location_id) REFERENCES locations (id)
);

-- Table: users
CREATE TABLE IF NOT EXISTS users
(
    id               BIGSERIAL PRIMARY KEY,
    name             VARCHAR(255) NOT NULL,
    surname          VARCHAR(255) NOT NULL,
    email            VARCHAR(255) NOT NULL,
    number           VARCHAR(255) NOT NULL,
    age              INTEGER      NOT NULL,
    occupation       VARCHAR(255) NOT NULL,
    image            VARCHAR(255) NOT NULL,
    description      VARCHAR(255) NOT NULL,
    rating           INTEGER      NOT NULL,
    password         VARCHAR(255) NOT NULL,
    user_location_id BIGINT       NOT NULL,
    CONSTRAINT fk_user_location FOREIGN KEY (user_location_id) REFERENCES locations (id)
);

-- Table: roles
CREATE TABLE IF NOT EXISTS roles
(
    id   BIGSERIAL PRIMARY KEY,
    role VARCHAR(255) NOT NULL
);

-- Table: completed_jobs
CREATE TABLE IF NOT EXISTS completed_jobs
(
    id                BIGSERIAL PRIMARY KEY,
    completed_user_id BIGINT NOT NULL,
    completed_job_id  BIGINT NOT NULL,
    CONSTRAINT fk_user_completed FOREIGN KEY (completed_user_id) REFERENCES users (id),
    CONSTRAINT fk_job_completed FOREIGN KEY (completed_job_id) REFERENCES jobs (id)
);

-- Table: favorite_jobs
CREATE TABLE IF NOT EXISTS favorite_jobs
(
    id               BIGSERIAL PRIMARY KEY,
    favorite_user_id BIGINT NOT NULL,
    favorite_job_id  BIGINT NOT NULL,
    CONSTRAINT fk_user_favorite FOREIGN KEY (favorite_user_id) REFERENCES users (id),
    CONSTRAINT fk_job_favorite FOREIGN KEY (favorite_job_id) REFERENCES jobs (id)
);

-- Table: opinions
CREATE TABLE IF NOT EXISTS opinions
(
    id      BIGSERIAL PRIMARY KEY,
    rating  INTEGER      NOT NULL,
    text    VARCHAR(255) NOT NULL,
    user_id BIGINT       NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id)
);

-- Table: offered_jobs
CREATE TABLE IF NOT EXISTS offered_jobs
(
    id              BIGSERIAL PRIMARY KEY,
    offered_user_id BIGINT NOT NULL,
    offered_job_id  BIGINT NOT NULL,
    CONSTRAINT fk_user_offered FOREIGN KEY (offered_user_id) REFERENCES users (id),
    CONSTRAINT fk_job_offered FOREIGN KEY (offered_job_id) REFERENCES jobs (id)
);

-- Table: user_roles
CREATE TABLE IF NOT EXISTS user_roles
(
    id      BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    CONSTRAINT fk_user_role FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_role_user FOREIGN KEY (role_id) REFERENCES roles (id)
);
