CREATE TABLE IF NOT EXISTS engagement(

    engagement_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    last_engagement DATE,
    like_count INTEGER,
    share_count INTEGER,
    comment_count INTEGER
);

CREATE TABLE IF NOT EXISTS recipes(
    recipe_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    recipe_name VARCHAR(255),
    date_created DATE,
    recipe_owner VARCHAR(255),
    view_count INTEGER,
    image_url VARCHAR(255),
    difficulty VARCHAR(255),
    engagement_id BIGINT,
    FOREIGN KEY (engagement_id) REFERENCES engagement(engagement_id)
);
