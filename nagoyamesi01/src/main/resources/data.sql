--restaurant
INSERT IGNORE INTO restaurants (id, name, image_name, description, opening_time, closing_time, lowest_price, highest_price, postal_code, address, phone_number, category_id, closed_days) VALUES 
(1,'和の味亭', 'restaurant07.jpg', '美味しい料理が楽しめるレストランです。', '10:00', '22:00', 1000, 5000, '123-4567', '名古屋市中区1-1-1', '090-1234-5678', 1, '水曜日'),
(2,'グリルダイニング・セレナ', 'restaurant04.jpg', '落ち着いた雰囲気のレストランです。', '08:00', '21:00', 800, 4500, '123-4568', '名古屋市中区2-2-2', '090-1234-5679', 2, '水曜日'),
(3,'ファミリー・ハウス', 'restaurant01.jpg', '家族連れにおすすめです。', '10:00', '23:00', 1200, 6000, '123-4569', '名古屋市東区3-3-3', '090-1234-5680', 4, '水曜日'),
(4,'中華の極み', 'restaurant010.jpg', '素晴らしい料理が楽しめます。', '11:00', '22:30', 900, 5200, '123-4570', '名古屋市西区4-4-4', '090-1234-5681', 3, '水曜日'),
(5,'グルメ・ラウンジ', 'restaurant013.jpg', '高級感あふれるダイニングです。', '10:30', '21:00', 1500, 7000, '123-4571', '名古屋市南区5-5-5', '090-1234-5682', 7, '水曜日'),
(6,'ペスカ', 'restaurant012.jpg', '伝統的な味が楽しめます。', '07:00', '20:00', 700, 3000, '123-4572', '名古屋市北区6-6-6', '090-1234-5683', 6, '水曜日'),
(7,'和風美味亭', 'restaurant07.jpg', 'モダンな日本料理が魅力です。', '12:00', '22:00', 1800, 8000, '123-4573', '名古屋市熱田区7-7-7', '090-1234-5684', 1, '水曜日'),
(8,'ラーメン横丁', 'restaurant09.jpg', 'ラーメンで有名なお店です。', '10:30', '21:30', 850, 3500, '123-4574', '名古屋市昭和区8-8-8', '090-1234-5685', 9, '水曜日'),
(9,'バースト・オブ・フレーバー', 'restaurant014.jpg', 'ランチに最適な場所です。', '11:00', '23:00', 950, 4000, '123-4575', '名古屋市天白区9-9-9', '090-1234-5686', 12, '水曜日'),
(10,'シェフズ・アトリエ', 'restaurant015.jpg', 'シェフが賞を受賞したレストランです。', '08:00', '21:00', 2000, 9000, '123-4576', '名古屋市名東区10-10-10', '090-1234-5687', 13, '水曜日'),
(11,'鮨風', 'restaurant016.jpg', '新鮮な魚介類が楽しめるお店です。', '10:00', '22:00', 1300, 5500, '123-4577', '名古屋市緑区11-11-11', '090-1234-5688', 5, '水曜日'),
(12,'アモーレ・トラットリア', 'restaurant012.jpg', 'ワインに合う料理が豊富です。', '11:00', '22:30', 1400, 6000, '123-4578', '名古屋市守山区12-12-12', '090-1234-5689', 6, '水曜日'),
(13,'ブレック', 'restaurant017.jpg', '朝食メニューが充実しています。', '07:00', '14:00', 600, 2000, '123-4579', '名古屋市瑞穂区13-13-13', '090-1234-5690', 11, '水曜日'),
(14,'酒と肴の里', 'restaurant08.jpg', '地元食材を使った料理が特徴です。', '10:30', '22:00', 900, 5000, '123-4580', '名古屋市港区14-14-14', '090-1234-5691', 10, '水曜日'),
(15,'韓国料理石炭', 'restaurant018.jpg', '予約必須の人気店です。', '09:00', '21:30', 1200, 6500, '123-4581', '名古屋市中村区15-15-15', '090-1234-5692', 14, '水曜日'),
(16,'タージ', 'restaurant019.jpg', 'ランチがお得なレストランです。', '11:00', '23:00', 850, 4000, '123-4582', '名古屋市中区16-16-16', '090-1234-5693', 16, '水曜日'),
(17,'月光', 'restaurant020.jpg', '開放感のある店内で食事が楽しめます。', '12:00', '21:00', 1600, 7200, '123-4583', '名古屋市東区17-17-17', '090-1234-5694', 19, '水曜日'),
(18,'カリーデリ', 'restaurant06.jpg', 'テイクアウトメニューが充実しています。', '09:00', '20:30', 700, 3500, '123-4584', '名古屋市西区18-18-18', '090-1234-5695', 8, '水曜日'),
(19,'スイートメモリー', 'restaurant02.jpg', 'バリアフリー対応のスイーツ店です。', '10:30', '22:30', 950, 4500, '123-4585', '名古屋市南区19-19-19', '090-1234-5696', 18, '水曜日'),
(20,'スイートペット', 'restaurant02.jpg', 'ペット同伴可能なお店です。', '08:30', '21:00', 1200, 6000, '123-4586', '名古屋市北区20-20-20', '090-1234-5697', 18, '水曜日'),
(21,'テラシア', 'restaurant017.jpg', '屋外テラス席が魅力です。', '09:00', '22:00', 1000, 5200, '123-4587', '名古屋市熱田区21-21-21', '090-1234-5698', 11, '水曜日'),
(22,'イタリアン・チャーム', 'restaurant012.jpg', '地元で人気のイタリアンレストランです。', '11:00', '23:00', 1300, 7000, '123-4588', '名古屋市昭和区22-22-22', '090-1234-5699', 6, '水曜日'),
(23,'カジュアルス', 'restaurant014.jpg', 'カジュアルな雰囲気で楽しめます。', '10:00', '21:00', 900, 4500, '123-4589', '名古屋市天白区23-23-23', '090-1234-5700', 12, '水曜日'),
(24,'カフェ・チー', 'restaurant017.jpg', 'おしゃれなカフェ風のレストランです。', '09:30', '22:00', 800, 4000, '123-4590', '名古屋市名東区24-24-24', '090-1234-5701', 11, '水曜日'),
(25,'和洋ダイニングみゆき', 'restaurant021.jpg', '和洋折衷のメニューが楽しめます。', '12:00', '22:00', 1100, 5500, '123-4591', '名古屋市緑区25-25-25', '090-1234-5702', 1, '水曜日'),
(26,'ベジタリアン・リトリート', 'restaurant015.jpg', 'ベジタリアンメニューが充実しています。', '11:00', '21:30', 900, 4200, '123-4592', '名古屋市守山区26-26-26', '090-1234-5703', 13, '水曜日'),
(27,'オリエンタル洋食堂', 'restaurant04.jpg', '地元産の野菜をふんだんに使っています。', '10:30', '22:00', 850, 4800, '123-4593', '名古屋市瑞穂区27-27-27', '090-1234-5704', 2, '水曜日'),
(28, 'フレッシュスムージー', 'restaurant022.jpg', '新鮮なサラダとスムージーが自慢のお店です。', '09:00', '20:00', 800, 4000, '123-4587', '名古屋市中区28-28-28', '090-1234-5700', 11, '水曜日'),
(29, 'コージー', 'restaurant017.jpg', '落ち着いたカフェ風レストランです。', '10:00', '21:00', 1000, 4500, '123-4588', '名古屋市中区29-29-29', '090-1234-5701', 11, '水曜日'),
(30, 'パタヤ・ディッシュ', 'restaurant05.jpg', 'シーフードメニューが豊富なお店です。', '11:00', '22:00', 1500, 6000, '123-4589', '名古屋市東区30-30-30', '090-1234-5702', 15, '水曜日'),
(31, 'ミートキングダム', 'restaurant01.jpg', 'ファミリー向けの広い店内が特徴です。', '09:30', '21:00', 1200, 5500, '123-4590', '名古屋市西区31-31-31', '090-1234-5703', 4, '水曜日'),
(32, 'エル・カリベ', 'restaurant011.jpg', '創作料理が楽しめるレストランです。', '12:00', '22:00', 1300, 6500, '123-4591', '名古屋市南区32-32-32', '090-1234-5704', 17, '水曜日'),
(33, '香味苑', 'restaurant010.jpg', 'スパイシーな料理が人気の店です。', '10:00', '21:00', 1400, 7000, '123-4592', '名古屋市北区33-33-33', '090-1234-5705', 3, '水曜日'),
(34, 'カフェ・ラ・エルミタージュ', 'restaurant017.jpg', 'ランチメニューが豊富なカフェです。', '09:00', '15:00', 900, 3500, '123-4593', '名古屋市熱田区34-34-34', '090-1234-5706', 1, '水曜日'),
(35, '鳥の蔵', 'restaurant03.jpg', 'クラフトビールと共に楽しめるレストラン。', '16:00', '23:00', 1200, 5000, '123-4594', '名古屋市昭和区35-35-35', '090-1234-5707', 20, '水曜日'),
(36, 'サムイ・セレナーデ', 'restaurant05.jpg', 'アジアンテイストの料理が楽しめます。', '10:00', '22:00', 1300, 6000, '123-4595', '名古屋市天白区36-36-36', '090-1234-5708', 15, '水曜日'),
(37, 'バーガーブリス', 'restaurant014.jpg', 'こだわりのハンバーガーが人気です。', '11:00', '23:00', 1500, 7000, '123-4596', '名古屋市名東区37-37-37', '090-1234-5709', 12, '水曜日'),
(38, 'ナチュラルカフェ', 'restaurant015.jpg', '自然派料理が楽しめるカフェレストラン。', '09:00', '20:00', 1000, 5000, '123-4597', '名古屋市緑区38-38-38', '090-1234-5710', 13, '水曜日'),
(39, 'カフェ・モカ・ミスト', 'restaurant017.jpg', '人気のデザートが豊富なカフェです。', '10:00', '22:00', 900, 4000, '123-4598', '名古屋市守山区39-39-39', '090-1234-5711', 18, '水曜日'),
(40, 'アーバンナイト', 'restaurant020.jpg', 'おしゃれな内装でデートにも最適です。', '12:00', '22:00', 1200, 6000, '123-4599', '名古屋市瑞穂区40-40-40', '090-1234-5712', 19, '水曜日'),
(41, 'ルナ・ロッサ', 'restaurant012.jpg', '地元の食材を使ったイタリアンです。', '09:30', '21:00', 1100, 5500, '123-4600', '名古屋市中村区41-41-41', '090-1234-5713', 6, '水曜日'),
(42, '翠竹軒', 'restaurant010.jpg', 'ファミリー向けの広々としたレストラン。', '10:00', '22:00', 1400, 6000, '123-4601', '名古屋市中区42-42-42', '090-1234-5714', 3, '水曜日'),
(43, 'ラ・パラディーサ', 'restaurant011.jpg', 'エスニック料理が楽しめるお店。', '11:00', '23:00', 1300, 7000, '123-4602', '名古屋市西区43-43-43', '090-1234-5715', 17, '水曜日'),
(44, 'ビストリ・エス', 'restaurant013.jpg', 'ビストロスタイルのレストランです。', '12:00', '22:00', 1600, 7500, '123-4603', '名古屋市南区44-44-44', '090-1234-5716', 7, '水曜日'),
(45, 'バー・シエスタ', 'restaurant020.jpg', '夜景が楽しめるバーです。', '17:00', '23:00', 2000, 8000, '123-4604', '名古屋市北区45-45-45', '090-1234-5717', 19, '水曜日'),
(46, '楽酒庵', 'restaurant08.jpg', 'アットホームな雰囲気のレストラン。', '09:00', '21:00', 1000, 5000, '123-4605', '名古屋市熱田区46-46-46', '090-1234-5718', 10, '水曜日'),
(47, 'グローバル・ビュッフェ', 'restaurant04.jpg', '各国の料理が楽しめるビュッフェスタイル。', '10:00', '22:00', 1500, 6000, '123-4606', '名古屋市昭和区47-47-47', '090-1234-5719', 21, '水曜日'),
(48, 'スイーツ・ラボ', 'restaurant02.jpg', '創作スイーツが豊富なカフェ。', '11:00', '20:00', 800, 3500, '123-4607', '名古屋市天白区48-48-48', '090-1234-5720', 18, '水曜日'),
(49, 'ドリンクヘブン', 'restaurant022.jpg', '豊富なドリンクメニューが自慢のお店。', '12:00', '22:00', 900, 4500, '123-4608', '名古屋市名東区49-49-49', '090-1234-5721', 21, '水曜日'),
(50, 'リラックス', 'restaurant017.jpg', '落ち着いた雰囲気でゆっくり過ごせるカフェ。', '10:00', '20:00', 1000, 4000, '123-4609', '名古屋市緑区50-50-50', '090-1234-5722', 11, '水曜日');

--category
INSERT IGNORE INTO categories(id, name) VALUES (1, '和食');
INSERT IGNORE INTO categories(id, name) VALUES(2,'洋食');
INSERT IGNORE INTO categories (id, name) VALUES(3,'中華');
INSERT IGNORE INTO categories (id, name) VALUES(4,'焼肉');
INSERT IGNORE INTO categories (id, name) VALUES(5,'寿司');
INSERT IGNORE INTO categories (id, name) VALUES(6,'イタリアン');
INSERT IGNORE INTO categories (id, name) VALUES(7,'フレンチ');
INSERT IGNORE INTO categories (id, name) VALUES(8,'カレー');
INSERT IGNORE INTO categories (id, name) VALUES(9,'ラーメン');
INSERT IGNORE INTO categories (id, name) VALUES(10,'居酒屋');
INSERT IGNORE INTO categories (id, name) VALUES(11,'カフェ');
INSERT IGNORE INTO categories (id, name) VALUES(12,'ファストフード');
INSERT IGNORE INTO categories (id, name) VALUES(13,'ベジタリアン');
INSERT IGNORE INTO categories (id, name) VALUES(14,'韓国料理');
INSERT IGNORE INTO categories (id, name) VALUES(15,'タイ料理');
INSERT IGNORE INTO categories (id, name) VALUES(16,'インド料理');
INSERT IGNORE INTO categories (id, name) VALUES(17,'メキシカン');
INSERT IGNORE INTO categories (id, name) VALUES(18,'スイーツ');
INSERT IGNORE INTO categories (id, name) VALUES(19,'バー');
INSERT IGNORE INTO categories (id, name) VALUES(20,'焼き鳥');
INSERT IGNORE INTO categories (id, name) VALUES(21,'その他');

--roles
INSERT IGNORE INTO roles (id, name) VALUES (1, 'ROLE_GENERAL');
INSERT IGNORE INTO roles (id, name) VALUES (2, 'ROLE_PREMIUM');
INSERT IGNORE INTO roles (id, name) VALUES (3, 'ROLE_ADMIN');

-- users
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (1, '侍 太郎',  'taro.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 2, true);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES(2, '侍 花子', 'hanako.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 3, true);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (3, '侍 義勝', 'yoshikatsu.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 1, true);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (4, '侍 幸美', 'sachimi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (5, '侍 雅', 'miyabi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (6, '侍 正保','masayasu.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (7, '侍 真由美', 'mayumi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (8, '侍 安民', 'yasutami.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (9, '侍 章緒', 'akio.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (10, '侍 祐子', 'yuko.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (11, '侍 秋美', 'akimi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (12, '侍 信平', 'shinpei.samurai@example.com', 'password', 1, false);

--reservations
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_date, reservation_time, number_of_people) VALUES 
(1, 1, 1, '2024-10-01', '18:00', 2),
(2, 1, 2, '2024-10-02', '19:00', 4),
(3, 1, 3, '2024-10-03', '17:00', 3),
(4, 1, 4, '2024-10-04', '20:00', 5),
(5, 1, 5, '2024-10-05', '16:00', 2),
(6, 1, 6, '2024-10-06', '11:00', 1),
(7, 1, 7, '2024-10-07', '12:00', 4),
(8, 1, 8, '2024-10-08', '13:00', 3),
(9, 1, 9, '2024-10-09', '15:00', 2),
(10, 1, 10, '2024-10-10', '14:00', 2);

--reviews
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, rating, content) VALUES 
(1, 1, 1, 5, '素晴らしい料理とサービス！'),
(2, 1, 2, 4, '雰囲気が良かったが、少し高かった。'),
(3, 1, 3, 3, '普通の料理だが、サービスは良かった。'),
(4, 1, 4, 5, '素晴らしい体験でした！'),
(5, 1, 5, 2, '料理が冷たかった。'),
(6, 1, 6, 4, '全体的には良かったが、量をもう少し増やしてほしい。'),
(7, 1, 7, 3, '雰囲気は良いが、料理は改善の余地あり。'),
(8, 1, 8, 5, '食事がとても気に入りました！'),
(9, 1, 9, 4, '価格に見合った良い料理。'),
(10, 1, 10, 5, '素晴らしいダイニング体験！強くお勧めします。'),
(11, 1, 11, 2, 'がっかりしました。お金の価値はないです。'),
(12, 1, 12, 4, 'フレンドリーなスタッフと美味しい料理。');

--favorites
INSERT IGNORE INTO reviews (id, restaurant_id, user_id) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 4, 1),
(5, 5, 1),
(6, 6, 1),
(7, 7, 1),
(8, 8, 1),
(9, 9, 1),
(10, 10, 1),
(11, 11, 1);

--subscription
INSERT IGNORE INTO  subscription (id, user_id, stripe_customer_id, stripe_subscription_id) VALUES
(1, 1,'cus_R3JXL05UplXf30', 'sub_1QBCujIN3pSzdAqcqpphJ3Ft');

