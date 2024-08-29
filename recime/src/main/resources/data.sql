INSERT INTO engagement 
(engagement_id, last_engagement, like_count, share_count, comment_count)
VALUES 
(1, '2024-08-25', 150, 20, 30),
(2, '2024-08-23', 300, 50, 10),
(3, '2024-08-24', 500, 60, 20),
(4, '2024-08-24', 550, 15, 15),
(5, '2024-07-24', 320, 20, 10),
(6, '2024-07-22', 60, 10, 5),
(7, '2024-03-01', 420, 4, 20),
(8, '2024-01-24', 1500, 160, 120),
(9, '2023-12-24', 2500, 400, 500),
(10, '2024-08-25', 10, 5, 2);

INSERT INTO recipes
(recipe_id, recipe_name, recipe_owner, 
view_count, date_created, engagement_id, 
image_url, difficulty)
VALUES
(1, 'CHICKEN BURGER', 'Arnold', 1000, '2024-05-25', 1, 
'https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg',
'EASY'),
(2, 'BAKED SUSHI', 'Rebecca', 400, '2024-03-25', 2, 
'https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg',
'EASY'),
(3, 'BEEF LASAGNA', 'Giovanni', 900, '2024-04-25', 3, 
'https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg',
'MEDIUM'),
(4, 'TUNA ROLL', 'Angelica', 1200, '2024-04-25', 4, 
'https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg',
'HARD'),
(5, 'CHICKEN STEW', 'Karen', 1300, '2024-06-25', 5, 
'https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg',
'HARD'),
(6, 'TOFU SALAD', 'Charlie', 2000, '2024-06-25', 6, 
'https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg',
'MEDIUM'),
(7, 'BAKED EGGPLANT', 'Joseph', 3000, '2024-02-25', 7, 
'https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg',
'MEDIUM'),
(8, 'RATATOUILLE', 'Remy', 6000, '2024-01-01', 8, 
'https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg',
'HARD'),
(9, 'PAD THAI', 'Jerry', 3000, '2023-08-25', 9, 
'https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg',
'HARD'),
(10, 'SEAFOOD PASTA', 'Arthur', 60, '2024-07-25', 10, 
'https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg',
'EASY');