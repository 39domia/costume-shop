-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: cusshop1
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Ut nobis deleniti au','https://www.chuphinhsanpham.vn/wp-content/uploads/2016/08/nguoi-mau-chup-hinh-quang-cao-hcm.jpg','Sloane Lawson'),(2,'Voluptas aut dolor i','https://thietkeaolop.vn/image/catalog/anh-bai-viet/ao-lop-hologram-08.jpg','Jaquelyn Cash'),(3,'peka@mailinator.com','https://i.pinimg.com/736x/ae/a1/6a/aea16a7dad0515abf68de486a019723b.jpg','Alisa Ray'),(4,'lijozuqinu@mailinator.com','https://toplist.vn/images/800px/shop-thuan-anh-v-321724.jpg','Kyle Galloway'),(5,'qylomik@mailinator.com','https://file.hstatic.net/1000321597/file/do-the-thao-nam_23542f9c0fb0493d87ae52cd18bd2358_grande.jpg','Marshall Flores'),(6,'bolumybon@mailinator.com','https://file.hstatic.net/1000283001/file/94575311_675428526609743_1752827143349338112_n_result_1fba3d4319984e49a108346f22e6ee38_grande.jpg','Doris Rutledge'),(7,'Explicabo Adipisci ','https://dongphucphocang.com/wp-content/uploads/2019/09/9.%C4%90%E1%BB%93ng-ph%E1%BB%A5c-qu%C3%A1n-cafe-%C4%91%E1%BA%B9p-2.jpg','Madeline Osborne'),(8,'Quis fugit est vol','https://media.wikihoc.com/1808/quan-ao-fashion.jpg','Kasper Parrish'),(9,'Accusantium sed quas','https://tiengtrungcamxu.com/wp-content/uploads/2016/09/slide1.jpg','India Gilliam'),(10,'Aut rerum facilis no','https://i.pinimg.com/originals/b6/ab/62/b6ab62a700397eaf7ca0d3e1708751bb.jpg','Jason Ware'),(11,'Quia placeat doloru','https://vaithunmaymac.com/kcfinder/upload/images/vai-thun-da-ca-may-do-nu.jpg','Thane Leblanc'),(15,'Duis consequatur nih','https://top.chon.vn/wp-content/uploads/2019/08/shop-ban-do-the-thao-nu-1.jpg','Mikayla Frederick');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
INSERT INTO `orderdetail` VALUES (9,1792,2,20,4),(10,1884,2,20,2),(12,1548,3,22,6),(13,1032,2,23,6),(15,850,1,28,14),(16,2550,3,29,14),(17,1792,2,29,4),(18,942,1,30,2),(19,53,1,30,5),(20,2550,3,31,14),(21,516,1,32,6),(22,516,1,33,6);
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (20,'51 North Rocky Old Street','Iusto veniam qui ve','Campos Howard Inc','2021-04-04 04:08:15.932000',NULL,'winojuh@mailinator.com','MacKensie Richard','Ullam qui praesentiu','Debit Card/Credit Card','+1 (195) 376-4866',1,3676,44),(22,'51 Rocky Hague Court','Qui distinctio Dolo','Roach and Cross Co','2021-04-04 16:11:38.708000',NULL,'zolyxomabi@mailinator.com','Tanek Mejia','Et tempore possimus','Cash on delivery','+1 (383) 335-5791',1,2876,4),(23,'38 Green Clarendon Drive','Sed voluptatem Odit','Benson Mueller Plc','2021-04-05 00:08:52.728000',NULL,'nydiz@mailinator.com','Devin Slater','Molestias quis magni','Internet Banking','+1 (858) 778-7695',1,1032,6),(24,'768 Green Milton Freeway','Aspernatur natus con','Campbell and Randall Trading','2021-04-05 00:16:35.967000',NULL,'defekop@mailinator.com','Cade Pearson','Esse nostrud quis ma','Cash on delivery','+1 (617) 248-4096',1,1884,50),(25,'588 Rocky Clarendon Extension','Eos nisi ad ullamco','Bentley Fisher Inc','2021-04-05 02:42:23.442000',NULL,'tubi@mailinator.com','Regina Burch','Aliquam iusto volupt','Debit Card/Credit Card','+1 (189) 761-7987',1,3400,48),(26,'67 Fabien Drive','Aliqua Et pariatur','Powell Elliott Associates','2021-04-05 03:29:06.515000',NULL,'sazojycuz@mailinator.com','Tatyana Soto','Reiciendis necessita','Cash on delivery','+1 (793) 297-6337',1,850,35),(28,'35 Second Drive','Itaque labore aut do','Bush Austin Plc','2021-04-05 08:43:06.135000',NULL,'mymovewoxe@mailinator.com','Michelle Fleming','Temporibus nisi sunt','Cash on delivery','+1 (319) 417-2758',1,850,44),(29,'799 North Rocky Second Court','Doloribus voluptate ','Herring and Patton Inc','2021-04-05 08:43:59.041000',NULL,'vaqonyde@mailinator.com','Sasha Greene','Et est itaque veniam','Cash on delivery','+1 (634) 697-1229',1,4342,41),(30,'286 First Drive','Consequuntur consequ','Green Prince LLC','2021-04-05 09:45:45.903000',NULL,'suqicirov@mailinator.com','Omar Chan','Ut dolor dolorum qui','Cash on delivery','+1 (592) 554-6624',1,995,24),(31,'13 Fabien Drive','Porro sit officia es','Ingram Oneil Trading','2021-04-05 09:48:28.861000',NULL,'zuwolaky@mailinator.com','Reagan Anderson','Quisquam voluptatem ','Cash on delivery','+1 (374) 613-8384',1,2550,34),(32,'564 Fabien Street','Veritatis ipsum ull','Mullins and Blackwell Inc','2021-04-05 10:23:15.612000',NULL,'rufoxej@mailinator.com','Dexter Randolph','Est rerum temporibu','Cash on delivery','+1 (339) 235-7776',1,516,11),(33,'41 East Green Milton Court','Aut veniam dolore e','Sanders Stanton Trading','2021-04-05 10:29:20.644000',NULL,'duzoza@mailinator.com','Armand Delaney','Quo minim deserunt n','Cash on delivery','+1 (405) 581-7361',1,516,20);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Laborum Accusantium',_binary '','Odio fugiat nihil ne','Laboriosam laborios','http://dathangquangchau.com/wp-content/uploads/2016/06/h%C3%A0ng-cao-c%E1%BA%A5p-qc.jpg',NULL,'Sylvia Powell',19,2,'Enim dolorum non com','51','Voluptatem iusto te','Illum sit dolore u',1),(2,'Quo at Nam ex aperia',_binary '\0','Rerum non sint ab qu','Elit lorem vitae do','https://dathangtaobao.vn/wp-content/uploads/2019/08/nhap-si-quan-ao-trung-nien-trung-quoc.jpg','Architecto nostrud a','Heidi Chambers',942,3,'Eum inventore dicta ','Culpa laboris est ','Id cillum odit rerum','Consequatur blanditi',1),(3,'In do ipsum modi il',_binary '','Ratione earum simili','Proident delectus ','https://ann.com.vn/wp-content/uploads/o-dau-chuyen-si-quan-ao-hotgirl-cao-cap-gia-tan-goc-xuong-may-786-330.jpg','Esse deserunt placea','Xenos Walker',835,4,'Proident sint sed l','Lorem illo perferend','Voluptas quis vel ul','Aut ut ut natus duci',1),(4,'Nemo magni totam ver',_binary '\0','Aut esse esse fugit','Aut molestiae autem ','https://cf.shopee.vn/file/41be12ce2048099060af38c21c8cf9c0','Recusandae Ipsa qu','Donovan Rivas',896,2,'Cillum sint cupidit','Tempore qui commodi','Similique voluptas a','Et reiciendis neque ',1),(5,'Aut duis quos et dol',_binary '\0','Et qui quae id enim ','Aliquip eligendi vel','https://i.pinimg.com/236x/0f/a7/d1/0fa7d10665d6c4c5e0419aedb5f6848b--%C3%A1o-croptop-%C3%A1o-blu.jpg','Nisi eaque aute corr','Vance Russo',53,1,'Repudiandae libero m','Duis dolore optio a','A eos repellendus ','Quasi fugiat excepte',5),(6,'Aut ipsa vel adipis',_binary '\0','Ducimus inventore e','Officia vitae placea','https://sobyn.com/wp-content/uploads/2019/06/qu%E1%BA%A7n-%C3%A1o-dolce-gabbana-nam-m%C3%B9a-h%C3%A8-2019.jpg',NULL,'Roth Macdonald',516,5,'Itaque debitis eos ','','Dolor sequi minima a','Quia adipisci magnam',3),(7,'Cum sed amet illo n',_binary '','Omnis incidunt et d','Tempore natus minim','https://i.pinimg.com/236x/0f/a7/d1/0fa7d10665d6c4c5e0419aedb5f6848b--%C3%A1o-croptop-%C3%A1o-blu.jpg','Iure mollitia aliqui','Lareina Houston',858,4,'Vel excepturi fugiat','Duis corrupti unde ','Aut doloribus sit ni','Voluptas porro magna',4),(14,'Dignissimos maiores ',_binary '\0','Obcaecati voluptates','Quia tenetur facilis','https://ann.com.vn/wp-content/uploads/10854-clean-dam-vang-tang-2.png',NULL,'Stephen Ayala',850,2,'Sit culpa non modi ','','Dolor est lorem dist','Quidem inventore lab',2),(15,'Dolorum voluptate et',_binary '\0','In minus est eum nes','Velit minima veniam','https://studiovietnam.com/wp-content/uploads/2020/08/10-4.jpg','Id aut in cumque est','Brenna Young',702,2,'Non voluptatum dolor','Rerum fugiat volupta','Sit nihil delectus','Irure omnis elit mi',5),(16,'Sit non perferendis ',_binary '\0','Est voluptate quia q','Culpa voluptates qui','https://cdn.phunusuckhoe.vn/ctv_dhtham/auto/5_12_2019/quan-mau-be-mac-voi-ao-mau-gi-hoc-ngay-sao-viet-cach-dien-do-voi-chiec-quan-dang-cuc-hot-nay6-2019-12-06-08-52.jpg','Voluptas voluptas do','Donovan Copeland',8,3,'Culpa omnis fugiat ','Sit dolor quo nostr','Velit quis dolore co','Possimus qui quam o',9),(17,'Officiis excepturi q',_binary '\0','Ea consectetur in iu','In ducimus saepe ha','https://www.bdresearch.org/wp-content/uploads/2019/10/beige-la-mau-gi.jpg','In et sunt consectet','Phelan Frazier',402,4,'Nam aliqua Earum au','Quos at delectus de','Sed corrupti adipis','Ex voluptas aspernat',2),(18,'Delectus dicta nihi',_binary '\0','Magnam sint veniam','Consequatur at labor','https://aristino.com/Data/upload/images/News/phong-cach-aristino/loat-anh-chung-minh-he-dan-ong-cu-dien-so-mi-trang-aristino-se-auto-hoa-nam-than_content_1.jpg','Error dolore dolore ','Amir Spencer',47,3,'Exercitationem aut e','Expedita voluptatum ','Libero in voluptatem','Consequatur nihil q',3),(19,'Velit est exercita',_binary '\0','Id et eaque et vel ','Duis error dicta opt','https://cdn.vuahanghieu.com/unsafe/0x0/left/top/smart/filters:quality(90)/https://admin.vuahanghieu.com/upload/news/content/2020/03/goi-y-ao-so-mi-den-nen-mac-voi-quan-mau-gi-1-jpg-1585372725-28032020121845.jpg','Nostrud obcaecati au','Driscoll Jones',901,3,'Exercitationem est i','Dolor non amet sint','Incidunt voluptates','Sequi sed dolor quia',3),(20,'Magnam elit volupta',_binary '\0','Quam at exercitation','Voluptatem aute id ','https://storage.googleapis.com/cdn.nhanh.vn/store/10103/artCT/62070/5_tips_phoi_do_cung_ao_so_mi_co_so_cho_co_nang_dam_me_thoi_trang_1.jpg','Labore maiores et ip','Harper Hurst',943,5,'Esse veniam adipis','Eveniet nihil moles','Laboriosam optio b','Ratione et dolores o',6),(21,'Consequuntur vel sun',_binary '\0','Consectetur dolorum','Molestiae vitae minu','https://ko-box.net/data/files/2020/09/23/3a43bea68c019b2cef35b3bbc1de6e5b.jpg',NULL,'Marsden Jimenez',567,2,'Ea velit excepteur ','','Consequatur Sed vel','Aut lorem temporibus',11),(22,'Commodo doloribus do',_binary '\0','Laborum commodo mole','Velit facilis et dol','https://aothudong.com/upload/product/atd-070/ao-hoodie-ni-nam-cao-cap.jpg',NULL,'Alice Hatfield',244,3,'Doloremque velit do','','Quae quia voluptas q','Est fugiat voluptat',1),(23,'Odio sed qui commodo',_binary '\0','Non laboris ullam ex','Dolores dolorem et f','https://static2.yan.vn/YanNews/2167221/201711/20171118-070532-1.jpg','Eos assumenda quis a','Alika Orr',826,3,'Dolore adipisci veli','Alias natus excepteu','Placeat distinctio','Et incidunt ipsum ',11),(24,'Et cupidatat molesti',_binary '\0','Asperiores amet rer','Dolorem atque nisi f','http://product.hstatic.net/1000205116/product/4a0398692628df768639_ef836832e5c841238c61378a02533e83_1024x1024.jpg','Rerum incididunt adi','Lucas Padilla',915,3,'Enim error voluptate','Aut incidunt quidem','Officiis elit repre','Dolor officiis et ni',8),(25,'Nostrum voluptates n',_binary '\0','Iste facilis ad pers','Quis officia dolorem','https://media.ex-cdn.com/EXP/media.yeugiadinh.vn/files/dinhtai/2019/12/17/quan-mau-be-mac-voi-ao-mau-gi-hoc-ngay-sao-viet-cach-dien-do-voi-chiec-quan-dang-cuc-hot-nay15-2019-12-06-08-52-2135114.jpg','Sequi excepturi est','Josephine Cabrera',429,2,'Exercitationem exerc','Cillum unde earum ar','Labore cupidatat inc','Atque officia ut off',3),(26,'Aut magnam est eos ',_binary '\0','Dolorum assumenda ni','Aliquam neque et lau','https://t7boutique.com/wp-content/uploads/2019/09/2cd32d962409c0579918.jpg','Irure reiciendis hic','Ebony Woods',57,2,'Velit laborum accusa','Perspiciatis alias ','Odio iste exercitati','Reprehenderit aut am',2),(27,'Sit sit molestias ',_binary '\0','Proident eveniet q','Incididunt quo quide','https://nhapsionline.com/wp-content/uploads/13636-viber-image-2020-10-26-08-07-32.png','Molestiae voluptate ','Latifah Rhodes',107,1,'Ullam quis quia sequ','Occaecat sint necess','Cupiditate beatae co','Et voluptas molestia',10),(28,'Deleniti sint quo n',_binary '\0','Iusto ullamco nemo a','Elit ipsa eveniet','https://bansithoitrang.net/wp-content/uploads/10417-clean-dam-trang-13.png','Sint perferendis ip','Miriam Benson',373,5,'Quam sed molestias q','Quam similique do ac','Consectetur nesciun','Excepteur labore eni',2),(29,'Quo eaque eos velit',_binary '\0','Mollit aliquam odio ','Et sequi molestiae a','http://www.remoingay.com/uploads/news/images/0603/1426823573585.jpg','Autem irure optio n','Arden Lynn',267,5,'Ullamco reprehenderi','Voluptas debitis sim','Quidem quis quaerat ','Voluptatibus minim v',5),(30,'Adipisicing labore c',_binary '\0','Veniam minus molest','Iusto sint voluptat','https://file.hstatic.net/1000197303/file/c_ha_tao_nen_mot_set_do_phu_hop_cho_nhung_co_nang_cong_so_anh_internet_4b9d9bba1ec146a4bf60bbc997409f8a.jpg','Sint sapiente et la','Xaviera Everett',166,5,'Aperiam in autem ut ','In ab qui rem et eni','Elit temporibus tem','Adipisci perspiciati',6),(31,'Incidunt aperiam qu',_binary '\0','Illum itaque deseru','Odio laudantium exc','http://dongphuchaianh.com/wp-content/uploads/2019/09/ao-lop-phan-quang-03.jpg',NULL,'Ifeoma Mayo',295,4,'Eveniet incidunt n','','Adipisci et beatae a','Voluptas fugiat dign',9),(32,'Aute modi ea qui et ',_binary '\0','Architecto recusanda','In asperiores invent','https://photo-cms-plo.zadn.vn/w800/Uploaded/2021/wopsvun/2021_04_02/ahauphuonganh23_pncz.jpg','In alias animi proi','Shad Rose',389,4,'Magni sint molestias','Expedita voluptatem','Ea ea velit soluta ','Aspernatur dolore ma',1),(33,'Dolorum rerum nisi a',_binary '\0','Molestias atque volu','Vel enim perferendis','https://znews-photo.zadn.vn/w660/Uploaded/pnbcuhbatgunb/2020_09_09/so_mi_nam_8.jpg','Et tenetur aliqua E','Ginger Simon',677,4,'Eos quasi irure cill','Dolor laboris aliqua','Nihil voluptate opti','Dignissimos obcaecat',2),(34,'Id beatae proident',_binary '\0','Aut ad aut qui offic','Adipisicing ea et qu','https://i.pinimg.com/236x/d4/36/c9/d436c9935e92213579ea4d7d1f5ace39.jpg','Ullamco nulla do per','Hayfa Moody',312,2,'Excepteur ea nostrud','Ex eveniet voluptat','Illum esse non moll','Incidunt molestiae ',4),(35,'Distinctio Rerum ad',_binary '\0','Neque debitis tempor','Esse veritatis repr','https://vpfashion.vn/wp-content/uploads/2019/09/ao-khoac-ni-nam-2-1-e1568590610978-500x568.jpg','Recusandae Excepteu','Kevin Ford',949,1,'Asperiores hic et la','Beatae est excepteur','Nulla animi duis ve','Aute molestiae rerum',4);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `products_tags`
--

LOCK TABLES `products_tags` WRITE;
/*!40000 ALTER TABLE `products_tags` DISABLE KEYS */;
/*!40000 ALTER TABLE `products_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `province`
--

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;
INSERT INTO `province` VALUES (1,'Thành phố Hà Nội'),(2,'Tỉnh Hà Giang'),(3,'Tỉnh Cao Bằng'),(4,'Tỉnh Bắc Kạn'),(5,'Tỉnh Tuyên Quang'),(6,'Tỉnh Lào Cai'),(7,'Tỉnh Điện Biên'),(8,'Tỉnh Lai Châu'),(9,'Tỉnh Sơn La'),(10,'Tỉnh Yên Bái'),(11,'Tỉnh Hoà Bình'),(12,'Tỉnh Thái Nguyên'),(13,'Tỉnh Lạng Sơn'),(14,'Tỉnh Quảng Ninh'),(15,'Tỉnh Bắc Giang'),(16,'Tỉnh Phú Thọ'),(17,'Tỉnh Vĩnh Phúc'),(18,'Tỉnh Bắc Ninh'),(19,'Tỉnh Hải Dương'),(20,'Thành phố Hải Phòng'),(21,'Tỉnh Hưng Yên'),(22,'Tỉnh Thái Bình'),(23,'Tỉnh Hà Nam'),(24,'Tỉnh Nam Định'),(25,'Tỉnh Ninh Bình'),(26,'Tỉnh Thanh Hóa'),(27,'Tỉnh Nghệ An'),(28,'Tỉnh Hà Tĩnh'),(29,'Tỉnh Quảng Bình'),(30,'Tỉnh Quảng Trị'),(31,'Tỉnh Thừa Thiên Huế'),(32,'Thành phố Đà Nẵng'),(33,'Tỉnh Quảng Nam'),(34,'Tỉnh Quảng Ngãi'),(35,'Tỉnh Bình Định'),(36,'Tỉnh Phú Yên'),(37,'Tỉnh Khánh Hòa'),(38,'Tỉnh Ninh Thuận'),(39,'Tỉnh Bình Thuận'),(40,'Tỉnh Kon Tum'),(41,'Tỉnh Gia Lai'),(42,'Tỉnh Đắk Lắk'),(43,'Tỉnh Đắk Nông'),(44,'Tỉnh Lâm Đồng'),(45,'Tỉnh Bình Phước'),(46,'Tỉnh Tây Ninh'),(47,'Tỉnh Bình Dương'),(48,'Tỉnh Đồng Nai'),(49,'Tỉnh Bà Rịa - Vũng Tàu'),(50,'Thành phố Hồ Chí Minh'),(51,'Tỉnh Long An'),(52,'Tỉnh Tiền Giang'),(53,'Tỉnh Bến Tre'),(54,'Tỉnh Trà Vinh'),(55,'Tỉnh Vĩnh Long'),(56,'Tỉnh Đồng Tháp'),(57,'Tỉnh An Giang'),(58,'Tỉnh Kiên Giang'),(59,'Thành phố Cần Thơ'),(60,'Tỉnh Hậu Giang'),(61,'Tỉnh Sóc Trăng'),(62,'Tỉnh Bạc Liêu'),(63,'Tỉnh Cà Mau');
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'Jemima George'),(2,'Jemima George'),(3,'Charles Randolph'),(4,'Colette Duran'),(5,'Cameron Henry'),(7,'Pearl Fisher');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin','admin@admin.com','admin1','yagoo ava.jpg','$2a$10$KMO0zVFnzeXem7tPj3aaFOuIPSVZPqiP2N0hXF7J3BNREG78TT2L.','admin'),(2,'Et est cupiditate in','Illum ut occaecat c','admin2@admin.com','Teegan Landry','thang ava.jpg','$2a$10$YyNL2mWYeXwgTbBfmQijseCn0KlJ4GbQGYRxgf.0FsEYofMsAem2y','user');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'cusshop1'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-05 14:40:33
