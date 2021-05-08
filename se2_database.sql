-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: mysql-27918-db.mysql-27918:27918
-- Thời gian đã tạo: Th5 04, 2021 lúc 02:41 PM
-- Phiên bản máy phục vụ: 8.0.22
-- Phiên bản PHP: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `se2_database`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `admin`
--

CREATE TABLE `admin` (
  `id` int NOT NULL,
  `username` varchar(90) DEFAULT NULL,
  `PASSWORD` varchar(90) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `admin`
--

INSERT INTO `admin` (`id`, `username`, `PASSWORD`) VALUES
(1, 'admin', 'admin'),
(4, 'admin2', 'admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `broardnew`
--

CREATE TABLE `broardnew` (
  `broadnew_id` int NOT NULL,
  `title` varchar(90) DEFAULT NULL,
  `content` text,
  `image_link` varchar(90) DEFAULT NULL,
  `author` varchar(60) DEFAULT NULL,
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `broardnew`
--

INSERT INTO `broardnew` (`broadnew_id`, `title`, `content`, `image_link`, `author`, `created`) VALUES
(2, 'Don\'t worry about watering your plants on summer days', 'Regular, correct watering of bonsai remains a top concern for bonsai lovers. Especially on summer days, you just forget to water for 2-3 days, the plant will have wilted or even died. Below we will suggest you a very scientific watering tip, do not worry about the soil is too wet or too dry and you will not worry about dead plants for a few weeks if you forget sprinklers.<br>\r\nWith this method, you can save time watering the plants, on a hot day more water will evaporate, cool weather, the amount of evaporated water will decrease and water will condense on the wall of the plastic bottle and slowly soak to the ground.', 'https://i.ibb.co/0m2gtQc/se21.jpg', 'Loi Dinh Van Quan', '2021-04-01 10:02:29'),
(6, 'The truth about the poison of Aroid Palm tree', 'Perhaps many people have heard or read that Aroid Palm tree is poisonous, even very poisonous, but it has the effect of filtering air and feng-shui so many people still buy and exhibit the tree on the desk. , living room. So exactly what is the poison of Aroid Palm tree? Please find out the details in the article below.<br>\r\n- Aroid Palm tree contains toxin calcium oxalate:<br>\r\nAccording to Associate Professor Tran Hong Cong - Department of Chemistry - University Of Science, there are many poisonous contain ornamental plants and among them Aroid Palm tree. In the stalk and leaves of Aroid Palm tree, there are crystals of calcium oxalate with the chemical formula CaC2O4 or Ca (COO) 2. This substance can irritate sensitive skin such as: mucous membrane of lips, tongue, mucous membrane in throat or eye conjunctiva if accidentally ingested or touched by plant secretions. However, his substance has an extremely good air filtration ability.<br>\r\n- Toxic level of Aroid Palm tree\r\nThe answer is that the Aroid Palm tree is poisonous, but it is at a very low level, and currently there has been no case of death due to accidentally eating Kim Tien.<br>\r\n- How to treat when contaminated with toxins of Aroid Palm\r\nUsually, only children get the toxin of the needle by playing with leaves, sticking to tree sap or swallowing leaves. The symptoms are when poisoned by the needle is usually a hangover, digestive disorders or a burning sensation in the mouth.<br>\r\nTo deal with plant toxins, you should quickly determine if your baby has been interactive with the tree, has to sap or swallowed leaves. If so, you should quickly rinse your child\'s mouth several times to reduce the amount of toxins that have been in contact with the body before and quickly take the child to the nearest hospital to solve it thoroughly.\r\nTo avoid unexpected situations, if you want to use Aroid Palm tree to decorate the house, it is should to keep it high above, out of reach of children.\r\n', 'https://i.ibb.co/BnNC5kv/se22.jpg', 'Ton Nu Tu Anh', '2021-04-01 10:15:24'),
(7, 'The effects and way to make vermicompost', 'Vermicompost, also known as redworm manure, the earthworm is the waste harvested after worms eat organic matter such as cow manure, pig manure, poultry manure, organic waste ... These organic substances. It is processed through the earthworm\'s digestive system and forms vermicompost.<br>\r\nVermicompost is very good for plants and safe, the fertilizer is suitable for all types of plants and can be used without any further treatment.<br>\r\n- 100% organic fertilizer, rich in nutrients very good for plants. The produce of the plant is completely clean and is not afraid of causing food poisoning.<br>\r\n- Harvest vermicompost can be used immediately without any further treatment. There is no need to compost like manure.<br>\r\n- Worm manure does not have an unpleasant odor like other fertilizers due to the treatment of the worm gut.<br>\r\n- Cinnamon vermicompost contains humus that can treat harmful fungi and toxins in the soil, helping to protect the roots of plants.<br>\r\n- The fertilizer has a neutral pH and humic acid compounds, so vermicompost has the ability to neutralize pH, stabilize the pH, avoid the pH imbalance in the soil during the improper use of chemical fertilizers. causing the soil to become acidic, reducing crop yields.<br>\r\n- Vermicompost increases soil water-holding capacity because vermicompost has a cubic shape, which are clusters of minerals that combine in a way that they can resist erosion and impact as well as their ability to retain water. parts that make the soil loose and retain moisture for a long time.<br>\r\n- Way to make vermicompost\r\nAccording to the ratio of a layer of soil, give 1 layer of organic waste. If there is vermicompost, it is advisable to add a little because there are often many worm eggs in the manure. Add in ingredients containing carbon. Then add the worms. Finally, put the lid on the foam bin.<br>\r\n Cow manure is very good food for worms. If you have cow dung, be sure to add it. You should use fresh cow manure, dissolve it with water and pour it into the worms to eat, leaving fresh manure can directly affect the composting results. Do not use treated cow dung.\r\nNote: Worms live in a humid environment. Therefore, the vermicompost mixture must always be kept moist. If it dries, it can cause the worms to die. Keeping the worm manure box moist will help the worms grow quickly.<br>\r\nAfter a month of composting, it was observed that the manure was brown, loose and odorless, and there were many worms that we\'re able to fertilize trees.', 'https://i.ibb.co/cCb0xL0/se23.jpg', 'Loi Dinh Van Quan', '2021-04-01 10:16:26'),
(8, 'How to take care of the succulent', 'The interesting thing and also the difficult thing is to maintain the life for Sen Da. If you are a tree buyer, there are two factors that you will affect on the tree that greatly affects the survival of the stone lotus: water and light.<br>\r\nsucculent originates from Mexico in one of the hot and dry countries, so the plants that can live well here are those that can store water in the leaves and stems, and ice lotus is one of the types. so. Water is not too necessary for the stone lotus but still has to be enough for it to sustain life and develop, however, if the lotus is lived in a humid field for 4-5 days, the stone lotus will gradually deteriorate from its roots and begins to shed all the leaves.<br>\r\n- Watering way:<br>\r\nAdjusting the amount of water is always not an easy problem with the ice shower. For dry air, hot weather in summer, it can be 1/2 times a week, while cold weather, humid, winter every 2 weeks. Usually, it will be a week with just watering once.<br>\r\n- Light:<br>\r\nLight is the most essential part of the succulent. So you should leave it in a place with a lot of sunlight, especially in the early morning and evening light, the best light is to let the outdoor plants have a roof, net to cover about 30%. If it is a tree you leave in the office without light, take it out to the sun once every 2-3 days about 8 hours.\r\n', 'https://i.ibb.co/cDkb5vM/se24.jpg', 'Loi Dinh Van Quan', '2021-04-01 10:17:30'),
(9, 'How to take care of bonsai in office', 'One of the things that many people are most concerned about after owning a bonsai in the office, a feng shui tree or a desktop tree is how to take care of it. So how to take care of office plants? In order for the plant to grow well, the leaves are always green and fresh, what are the common mistakes that cause the plant to die? If you are interested in that then please follow the article below.<br>\r\n- Water<br>\r\nNormally, if you leave the tree outside in the sun and wind, you can water every day, every day water the plants to first wash away the dust on the leaves to help plants more photosynthesis, more ventilation, and often watering and In the early morning or late afternoon, avoid watering in the middle of the afternoon, the hot sun can easily cause heat shock and death. But usually, trees are stored in an office environment, with air conditioning, or indoors with little sun, lack of wind, so the water has a low evaporation rate, the soil keeps moisture for a long time. So you should only water 1 week / 2 times each time enough moisture is 1/2 of the soil. Only water at the base of the leaves, if dirty, use a wet cloth.<br>\r\n- Land<br>\r\nPre-planted soil in ordinary trees is good soil with a lot of humus to ensure good growth for the plant within 3-6 months. If you see yellow leaves due to lack of nutrients for a long time, you can add soil, humus, replace the soil for plants or simply buy nitrogen, a fertilizer that dissolves slowly, so the stump is fine.<br>\r\n- Light<br>\r\nLiving in a dimly lit environment, but the color of the leaves will be less dark and green, so on the weekend you should leave the tree on the porch so that the tree can be exposed to the sun and wind outdoors, even not best or to trees near a window where light is shining.<br>\r\n- Location<br>\r\nThe location of the tree is very important to greatly affect the development and survival of office plants and indoor plants. The best location for the plant is a cool place with light sunlight.\r\n', 'https://i.ibb.co/SBN2Rj3/se25.jpg', 'Ton Nu Tu Anh', '2021-04-01 10:18:40'),
(11, 'Take care of aquatic plants', 'The advantage of aquatic plants is that it is clean and does not take much care. We only need to pay attention to the beginning, the moment when the tree changes its habitat.<br>\r\n- Location<br>\r\nPlants should be placed in a well-ventilated place, under electric light or with light sunlight in the early morning and late afternoon. Avoid leaving the plant under intense sunlight, where the heat is radiated, such as in an air conditioner, behind the computer\'s CPU ... The location of the tree is quite important in taking care of aquatic plants that you need to pay attention to.\r\n-	Water\r\nYou need to pay attention to the water of the aquatic plants, especially in the beginning if the water smells, you need to change the water always and remove the rotten roots. If you don\'t have time to notice, change the water once a week at the initial time. When changing the water, pour the water away, refill it many times to create air in the water, the plants will develop better roots<br>\r\n- Notice:<br>\r\nDo not leave the plants with sun windows because plants are usually in a water tank, hot sunlight plus shining through the glass and glass bottle makes the water hot and easy to kill the plants.\r\nDo not leave water in the bottle cloudy and smells strange, it is necessary to change the water as soon as you see the phenomenon<br>\r\nShould pour water over the roots, not flood the trunk, because only the roots can absorb water, the trunk cannot absorb water.', 'https://i.ibb.co/N3QHX4j/se26.jpg', 'Loi Dinh Van Quan', '2021-04-01 10:27:51');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

CREATE TABLE `cart` (
  `cart_id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `product_name` text NOT NULL,
  `p_price` float NOT NULL,
  `p_image` text NOT NULL,
  `quantity` int DEFAULT NULL,
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `cart`
--

INSERT INTO `cart` (`cart_id`, `user_id`, `product_id`, `product_name`, `p_price`, `p_image`, `quantity`, `created`) VALUES
(16, 6, 2, ' Succulent ', 8, ' https://i.ibb.co/8xRvMsM/succulent-3.jpg', 1, '2021-04-19 03:16:20'),
(17, 1, 1, 'Cactus', 9, ' https://i.ibb.co/TmXWhVC/xuong-rong-2.jpg ', 2, '2021-04-19 15:19:04');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `catalog`
--

CREATE TABLE `catalog` (
  `catalog_id` int NOT NULL,
  `NAME` varchar(90) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `catalog`
--

INSERT INTO `catalog` (`catalog_id`, `NAME`) VALUES
(1, 'Plants'),
(2, 'Pots'),
(3, 'Accessories'),
(4, 'Decorations');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `discount`
--

CREATE TABLE `discount` (
  `discount_id` int NOT NULL,
  `NAME` varchar(90) DEFAULT NULL,
  `description` text,
  `minPayment` float DEFAULT NULL,
  `percentage` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `discount`
--

INSERT INTO `discount` (`discount_id`, `NAME`, `description`, `minPayment`, `percentage`) VALUES
(1, 'Free Ship', 'Reduce total ship fee by 10%', 5, 10),
(2, 'Paypal', 'Voucher 20% for user when user paypal for payment', 5, 20);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ordered`
--

CREATE TABLE `ordered` (
  `ordered_id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  `cart_ids` text NOT NULL,
  `total_payment` float DEFAULT NULL,
  `shipping_address` text NOT NULL,
  `STATUS` enum('approved','rejected','pending') CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `ordered`
--

INSERT INTO `ordered` (`ordered_id`, `user_id`, `cart_ids`, `total_payment`, `shipping_address`, `STATUS`, `created`) VALUES
(2, 1, ' Dumb Cane , Dumb Cane ,IKEA VATTENKRASSE WATERING CAN', 26.5, '1 Main St,San Jose,CA', 'approved', '2021-04-01 02:12:31'),
(3, 1, ' Palour palm , Palour palm ,IKEA BOTANISK GARDENING BAG', 69, '1 Main St,San Jose,CA', 'approved', '2021-04-01 02:34:50');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `product_id` int NOT NULL,
  `catalog_id` int DEFAULT NULL,
  `NAME` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `price` float DEFAULT NULL,
  `STATUS` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `description` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `discount` float DEFAULT NULL,
  `image_link` text,
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`product_id`, `catalog_id`, `NAME`, `price`, `STATUS`, `description`, `discount`, `image_link`, `created`) VALUES
(1, 4, 'Cactus', 9, '1', 'A cactus is a member of the plant family Cactaceae. The word \"cactus\"\r\n derives, through Latin, from the Ancient Greek \"kaktos\", a name originally used by Theophrastus for \r\na spiny plant whose identity is not certain. Cacti occur in a wide range of shapes and sizes.Cactus plants are \r\nable to thrive in dry climates because they store water in their stems. Cactus is also an ornamental tree and \r\nis popular in displaying and beautifying office spaces, living rooms or shops, hotels, coffee shops ...\r\nCacti also has a very good ability to absorb toxic gases', 0, ' https://i.ibb.co/TmXWhVC/xuong-rong-2.jpg ', '2021-03-09 03:42:16'),
(2, 1, ' Succulent ', 8, 'AVAILABLE', ' Succulent plants may store water in various structures, such as leaves and \r\nstems. ... Succulents are often grown as ornamental plants because of their striking and unusual appearance. \r\nAbout 60 different plant families contain succulents. Succulent is also an ornamental tree and is popular in \r\ndisplaying and beautifying office spaces, living rooms or shops, hotels, coffee shop', 0, ' https://i.ibb.co/8xRvMsM/succulent-3.jpg', '2021-03-09 03:42:16'),
(3, 1, 'palm-tree ', 13, 'AVAILABLE', ' Palm trees are among the best indoor air-improving plants. Brushes \r\nhelp clean the air from chemicals like ammonia and avoid insects. Plants also have the ability to reduce heavy \r\nmetals in the air. With fancy green leaves, the birthday brush creates a very good highlight in the room. \r\nThe Japanese Palm is one of the most beautiful ornamental plants. You can use it for the desk, the railing, \r\nthe living room table', 0, ' https://i.ibb.co/9T0Gg0g/c-y-c-nh-t-3.jpg ', '2021-03-09 03:42:16'),
(5, 4, 'IKEA VATTENKRASSE WATERING CAN', 10, 'AVAILABLE', 'Buying just any uninteresting watering can isn’t a great way to show the world how serious you are about the upkeep of your houseplants. It’s also not a great way to enhance your home’s overall aesthetic. Since you’ll want to knock out both of these birds with a single stone, IKEA has introduced the VATTENKRASSE — a watering peripheral fit for the Swedish furniture store’s most stylish followers. It’s crafted from galvanized and stainless steel and boasts a formidable polyester powder coating to keep it looking great, regardless of your daily watering cycle.', 0, 'https://i.ibb.co/WcBKMpS/IKEA-VATTENKRASSE-Watering-Can.jpg', '2021-03-30 08:47:37'),
(6, 4, 'CB2 SAIC WATERING CARAFE', 15, 'AVAILABLE', 'A product of the Designed Objects curriculum at the School of the Art Institute of Chicago (SAIC), CB2’s aesthetically-pleasing Watering Carafe pairs elements of modernity and luxurious stoneware staples, creating something that’s a more akin to art, than anything else. Although the carafe boasts a lavish white glaze and a sculpted body, its also been formulated to provide your foliage with the perfect amount of sustenance. Whether or not you’d want to utilize it in that manner, on the other hand, is something that’s specific to each individual situation.', 0, 'https://i.ibb.co/9W0STkw/CB2-Saic-Watering-Carafe.jpg', '2021-03-30 08:47:37'),
(7, 4, 'CRATE AND BARREL BLACK GLASS PLANT MISTER', 28, 'AVAILABLE', 'If you’re looking for something a bit more formal and chic, the Crate and Barrel Black Glass Plant Mister is for you. Not only does this unique device take on a mid-century-inspired appearance, but it’s also entirely capable, drawing from decades of trusted use to keep your ferns and orchids alive and well. Since it boasts a faceted black glass architecture and a hand-polished brass top, the eight-ounce wonder is sure to blend right into your home’s equally-decorated gardening areas — and if there’s one thing we know, it’s that great design often goes unnoticed.', 0, 'https://i.ibb.co/kcGP74t/West-Elm-Modern-Spout-Watering-Can.jpg', '2021-03-30 08:47:37'),
(8, 4, 'WEST ELM MODERN SPOUT WATERING CAN', 80, 'AVAILABLE', 'Buying just any uninteresting watering can isn’t a great way to show the world how serious you are about the upkeep of your houseplants. It’s also not a great way to enhance your home’s overall aesthetic. Since you’ll want to knock out both of these birds with a single stone, IKEA has introduced the VATTENKRASSE — a watering peripheral fit for the Swedish furniture store’s most stylish followers. It’s crafted from galvanized and stainless steel and boasts a formidable polyester powder coating to keep it looking great, regardless of your daily watering cycle.', 0, 'https://i.ibb.co/WcBKMpS/IKEA-VATTENKRASSE-Watering-Can.jpg', '2021-03-30 08:47:37'),
(9, 4, 'IKEA BOTANISK GARDENING BAG', 20, 'AVAILABLE', 'If you’re an avid planter, you’ve likely become well-acquainted with the process of introducing new foliage to your home or garden. Oftentimes, transporting a plant from one area to the next can cause a headache, especially if you’re not prepared. That’s where IKEA’s BOTANISK Gardening Bag comes into play. Not only does this unique, waterproof bag help you to transfer your plants from one pot to the other, but it’s also a perfect, storage-worthy tote that can earn you some extra time between reintroduction. As an added bonus, you can utilize it for other things whenever there’s not a shrub, fern, or smaller tree inside.', 0, 'https://i.ibb.co/1TXLfsV/IKEA-BOTANISK-Gardening-Bag.jpg', '2021-03-30 08:47:37'),
(10, 4, 'GREENAHOLICS MEDIUM PLANT POT', 24, 'AVAILABLE', 'Trying to find an aesthetically-pleasing design piece that will put your medium-sized plants on display for the world to see? Your search has come to an end, courtesy of Greenholics’ Medium Plant Pot. This compact accessory boasts a size that’s suitable for succulents bonsai, cactus, snake plants, and seedlings, and features a high-quality ceramic, surrounding by a baked kaolin glaze. There’s even a drainage hole (complemented by a tight-sealing removable plug) in case you over water.', 0, 'https://i.ibb.co/6tdPFKb/Greenaholics-Medium-Plant-Pot.jpg', '2021-03-30 08:47:37'),
(11, 4, 'ANTHROPOLOGIE BOLO HANGING PLANTER', 30, 'AVAILABLE', 'Ground-savvy planters are all good and well, but if you’re looking for a captivating way to display your favorite plants, hanging, or otherwise, the Anthropologie Bolo Planter is the perfect medium. Its modern aesthetic will complement your home’s distinct design choices, thanks to its ceramic, brass, and rope construction. Just keep in mind that you’ll need to find an area suitable for use; not every room or outdoor area is outfitted with a beam that can handle the weight of soil and a full-grown plant.', 0, 'https://i.ibb.co/6tdPFKb/Greenaholics-Medium-Plant-Pot.jpg', '2021-03-30 08:47:37'),
(12, 4, 'MOMA DESIGN SELF WATERING POT', 34, 'AVAILABLE', 'MoMa Design’s Self-Watering Wet Pot is a genius offering that draws inspiration from its fabled Swedish counterpart. Each compact offering boasts a terracotta planter housed within a hand-blown glass enclosure. As a result, the accessory’s unique design allows the plant to absorb water through the planter’s terracotta walls, resulting in an easy, intuitive alternative to traditional planting and watering methods. As long as your indoor/outdoor area stays above frost-point, everything from mini cacti, to full-grown azaleas should thrive within.', 0, 'https://i.ibb.co/K254n7B/Mo-Ma-Design-Self-Watering-Pot.jpg', '2021-03-30 08:47:37'),
(13, 4, 'THE SILL LIVE ZZ PLANT + CERAMIC PLANTER', 220, 'AVAILABLE', 'Sometimes, plant owners just want to make a statement. Luckily, The Sill’s Live ZZ Plant + Delores Ceramic Planter makes the procurement of an eye-catching interior accent as intuitive as ever. This thick and waxy green succulent is both hard-wearing and adaptive, allowing it to survive with minimal upkeep, and thrive in areas with low to medium light shed. Since there’s no need to re-pot, it’s also an attractive choice for those who are looking to purchase a handful, giving them the opportunity to outfit any room in the home with their own greenery, without much fuss.', 0, 'https://i.ibb.co/KW9jH46/The-Sill-Live-ZZ-Plant-plus-Ceramic-Planter.jpg', '2021-03-30 08:47:38'),
(14, 4, 'Wire Water Me Plant Marker', 9.69, 'AVAILABLE', 'Do you forget to water your plants? Never forget again with these stylish water me plant markers! These toppers make great gifts for plant lovers, or a perfect addition to your plant collection! Ideal for both inside and outside plants as they are made from aluminium wire! Standard size is roughly 14cm wide by around 22cm high. If you have something else in mind, just drop me a message and I’ll be sure to accommodate!', 0, 'https://i.ibb.co/B6MDHNW/Wire-Water-Me-Plant-Marker.jpg', '2021-03-30 08:47:38'),
(15, 4, 'Cloud Planter', 24.22, 'AVAILABLE', 'He design of the Cloud Planter is very unique. It will make your trailing plants look like rain! It’s perfect for trailing baby plants, small cacti and succulents. You can hang it or place it on a surface - works either way! The planter fits the most common small size of plastic pots (5.5cm)', 0, 'https://i.ibb.co/KxbCjdw/cloud-planter.jpg', '2021-03-30 08:47:38'),
(16, 4, 'Eucalyptus Wall Hanger', 32, 'AVAILABLE', 'This gorgeous eucalyptus wall hanger is a permanent piece made with fresh eucalyptus. It dries just like this, and will start as a lovely essential oil-emitting boho wall-hanging, and then it will dry, and be a lovely boho piece of wall-décor. This makes an excellent gift!', 0, 'https://i.ibb.co/sbHWJN6/Eucalyptus-Wall-Hanger.jpg', '2021-03-30 08:47:38'),
(17, 4, 'Glitter Flower Vase', 40, 'AVAILABLE', 'This past weekend I made these glitter vases for a couple people and I love them… I love them so much that they might be hard to give away. This DIY glitter flower vase  is sparkly and so pretty and perfect for showing off your flowers.', 0, 'https://i.ibb.co/cTjpWgk/Glitter-Flower-Vase.png', '2021-03-30 08:47:38'),
(83, 1, ' Palour palm ', 7.5, 'AVAILABLE', ' Palour palm is a small shrub, about 20-200 cm in height. \r\nPalour palm has leaf-like leaves, double leaves like areca leaves. Leaves are long, pointed, dark green, \r\nsoft and glossy, smooth, with well-defined veins. Minor brooch areca leaf grows sparsely from the main stem. \r\nThe leaf sheaths and areca stems are in harmony with each other to create a harmonious, eye-catching, lively \r\nand vibrant beauty.', 0, ' https://i.ibb.co/MVY6LCb/Palour-palm-cau-tieu-tram-1.jpg', '2021-03-30 08:59:41'),
(84, 1, ' Dumb Cane ', 9.5, 'AVAILABLE', ' The Dumb Cane plant is a strong species that will thrive in \r\nany light conditions other than direct sunlight. Its easy to care for style and resilience to neglect \r\nmake it a wonderful house plant......\r\nThis native to the West Indies will flower in the right conditions, but these flowers are unimpressive. \r\nThe beauty of the dumb cane plant comes from the unique pattern found on every leaf.', 1, ' https://i.ibb.co/bKj1k2S/Van-nien-thanh-2.jpg', '2021-03-30 08:59:41'),
(85, 1, ' Peace Lily ', 11, 'AVAILABLE', ' Peace lilies are sturdy plants with glossy, dark green oval \r\nleaves that narrow to a point. The leaves rise directly from the soil. These plants also periodically produce \r\nlightly fragrant white flowers that resemble calla lilies. The long-lasting flowers start out pale green and \r\nslowly turn creamy white as they open. Peace lilies have many benefits like: It Purifies Air, It Beautifies Your Room, \r\nPrevents Mildew Formation,… It is a best choice for your house.', 0.5, ' https://i.ibb.co/vzdN4Fm/cay-lan-y-1.jpg', '2021-03-30 08:59:41'),
(86, 1, ' Boot Lily ', 20, 'AVAILABLE', ' To talk about the hydrangea plants, it is impossible not to \r\nmention the yew tree. Yew tree is a woody species that lives along rivers and lakes and has good wood quality. \r\nLocated at the crossroads between soil and water, the tree has both the hardness and strength of the cedar without \r\nlack of the flexibility and sophistication of the water. They are small shrubs, slender trees with many branches \r\nextending out, leaning against each other. Thuy Tung leaves are dark green, with small triangles arranged closely \r\ntogether, looking very beautiful. Nowadays, they are popular species of phir for making indoor plants, decorating \r\nclassrooms, bedrooms, and working rooms.', 0, ' https://i.ibb.co/Y2Cnw3q/cay-thuy-tung-1.jpg ', '2021-03-30 08:59:41'),
(87, 1, ' Kaleidoscope ', 15, 'AVAILABLE', ' The kaleidoscope has another NAME as the natural tree. Small-sized \r\ntrees have eye-catching colors, so they are very popular for orNAMEntal purposes. The kaleidoscope has a very good \r\nair filtration ability, so indoor plants are both beautiful and help fresh air. The kaleidoscope is red in color, \r\nso it is very suitable for people with fire. This is a plant that brings good luck and good luck to humans. \r\nPlanting water buds indoors will attract fortune and make growers have many advantages in life.', 0, ' https://i.ibb.co/m58kjK4/c-y-v-n-l-c-2.jpg ', '2021-03-30 08:59:41'),
(88, 1, ' Sansevieria trifasciata ', 7.5, 'AVAILABLE', ' Sansevieria trifasciata  is always at the top of the list of air \r\npurifiers. The leaves of the tiger\'s tongue tree are long, with yellow lines spreading evenly across the leaves like \r\nthe pattern on the tiger\'s fur, so the tree is called the tiger\'s tongue. Sansevieria trifasciata  is considered to be \r\na very good detachment tree. The tree has yellow veins with the color of the soil, so it is very suitable for the \r\nlandlord and is quite popular today.', 0, ' https://i.ibb.co/WfHw8V4/cay-luoi-ho-2.jpg ', '2021-03-30 08:59:42'),
(89, 1, ' Aroid Palm  ', 9.5, 'AVAILABLE', ' Sansevieria trifasciata  is always at the top of the list of air purifiers.\r\n The leaves of the tiger\'s tongue tree are long, with yellow lines spreading evenly across the leaves like the pattern on \r\nthe tiger\'s fur, so the tree is called the tiger\'s tongue. Sansevieria trifasciata  is considered to be a very good \r\ndetachment tree. The tree has yellow veins with the color of the soil, so it is very suitable for the landlord and is \r\nquite popular today.', 0, ' https://i.ibb.co/vJzfMkb/cay-kim-tien-2.jpg ', '2021-03-30 08:59:42'),
(90, 1, ' Eastern  ', 25, 'AVAILABLE', ' Eastern is a tall and beautiful bonsai with a beauty from the base to the top.\r\n On the tree, there are fresh, smooth xnah foliage that represent strong hope and confidence. The tree has a sense of \r\noriginality and charm and shows the luxury of the owner when planting a tree happily in the garden. Each time you mention \r\nthe tree of happiness, people will feel peaceful and warm inside.', 0.5, ' https://i.ibb.co/ZSdC5wQ/cay-hanh-phuc-1.jpg ', '2021-03-30 08:59:42'),
(91, 1, 'Baby Rubber Plant ', 15, 'AVAILABLE', ' Baby Rubber Plant has high applicability in today\'s life. \r\nThe cool green color of the large leaves increases the ability to clean the air, absorb pollutants such as formaldehyde, \r\ncarbondioxide, ... The thick thick leaves absorb harmful rays from the equipment. Electronic and feels like stretch for \r\npeople or stress, have to work a lot. In addition, the tree is also a meaningful gift for loved ones with the meaning \r\nof wishing health, well-being and happiness. With the NAME \"immortality\", the tree represents longevity, connection, \r\nfortune and luck. So when there is a longevity tree in your home or work area, it will bring you many good things.', 0, ' https://i.ibb.co/fC64rBy/Cay-truong-sinh-1.jpg ', '2021-03-30 08:59:42'),
(92, 1, ' Spider Plant ', 6, 'AVAILABLE', ' Spider plants are always capable of photosynthesis under minimal light. \r\nIt quickly absorbs toxins from the air such as Carbon monoxide, Formaldehyde, gasoline and Styrene. In addition, \r\nit can convert carcinogenic gases in the air such as formic aldehydes into sugars and ammonium acids. \r\nA small pot of plants is enough to clean the air in a 200m2 space.', 0.5, ' https://i.ibb.co/x7ss9zm/C-y-d-y-nh-n.jpg ', '2021-03-30 08:59:42'),
(93, 1, ' Laurel tree ', 17, 'AVAILABLE', ' Laurel tree is a perennial, fragrant shrub originating in the countries \r\nof the Mediterranean, suitable in humid and shady lands. For a long time, people still considered the pink laurel as \r\na symbol of \"glory and victory\". Native to the subtropical land, this plant is suitable for humid air, shade, \r\nand warm water. They absorb the moisture in the air, creating an open environment.', 0, ' https://i.ibb.co/QkcCZfj/C-y-Nguy-t-Qu.jpg ', '2021-03-30 08:59:42'),
(94, 1, ' Lucky Tree ', 28, 'AVAILABLE', ' The NAME makes this flower special. And this is also one of the \r\nfeng-shui species that quite a lot of people choose to put in their family\'s living room. The Lucky tree has a \r\ncool shape, the stem is plentiful and soft, strong. Most of the people choose the tree of fortune according to \r\nthe feng-shui concept because it helps them bring a lot of fortune, wealth, and wealth.', 0, ' https://i.ibb.co/CtMrDyH/C-y-t-i-l-c.jpg ', '2021-03-30 08:59:42'),
(110, 2, 'pot1', 15, 'AVAILABLE', 'size 10x10x15 color red', 0, 'https://i.ibb.co/4PZqqLd/1.jpg', '2021-03-30 09:08:06'),
(111, 2, 'pot2', 15, 'AVAILABLE', 'size 10x10x15 color grey', 0, 'https://i.ibb.co/3shhgR3/2.png', '2021-03-30 09:08:06'),
(112, 2, 'pot3', 13, 'AVAILABLE', 'size 8x8x20 color grey', 0, 'https://i.ibb.co/P5bkch8/3.jpg', '2021-03-30 09:08:06'),
(113, 2, 'pot4', 17, 'AVAILABLE', 'size 12x12x10 color red', 0, 'https://i.ibb.co/CnQJ9N2/4.jpg', '2021-03-30 09:08:06'),
(114, 2, 'pot5', 20, 'AVAILABLE', 'size 112x12x15 color brown', 0, 'https://i.ibb.co/FHy51qy/5.jpg', '2021-03-30 09:08:06'),
(115, 2, 'pot6', 10, 'AVAILABLE', 'size 10x10x12 color red', 0, 'https://i.ibb.co/h8rNB6D/6.jpg', '2021-03-30 09:08:06'),
(116, 2, 'pot7', 15, 'AVAILABLE', 'size 15x15x7 color pink', 0, 'https://i.ibb.co/stC3rMj/7.jpg', '2021-03-30 09:08:06'),
(117, 2, 'pot8', 10, 'AVAILABLE', 'size 8x8x15 color orange', 0, 'https://i.ibb.co/N9LZ1wb/8.jpg', '2021-03-30 09:08:06'),
(118, 2, 'pot9', 15, 'AVAILABLE', 'size 10x10x20 color black', 0, 'https://i.ibb.co/4pBQjwL/9.jpg', '2021-03-30 09:08:06'),
(119, 2, 'pot10', 20, 'AVAILABLE', 'size 11x11x16 color orange', 0, 'https://i.ibb.co/X5SvWw7/10.jpg', '2021-03-30 09:08:07'),
(120, 2, 'pot11', 10, 'AVAILABLE', 'size 10x10x17 color brown', 0, 'https://i.ibb.co/2srBjHF/11.jpg', '2021-03-30 09:08:07'),
(121, 2, 'pot12', 14, 'AVAILABLE', 'size 9x9x17 color red', 0, 'https://i.ibb.co/zFxVDz6/12.jpg', '2021-03-30 09:08:07'),
(122, 2, 'pot13', 19, 'AVAILABLE', 'size 10x10x13 color brown', 0, 'https://i.ibb.co/Xtj2hpj/13.jpg', '2021-03-30 09:08:07'),
(123, 2, 'pot14', 20, 'AVAILABLE', 'size 10x10x18 color orange', 0, 'https://i.ibb.co/BVZnhwd/14.jpg', '2021-03-30 09:08:07'),
(124, 2, 'pot15', 15, 'AVAILABLE', 'size 12x12x16 color black', 0, 'https://i.ibb.co/wc4t6cJ/15.jpg', '2021-03-30 09:08:07'),
(125, 2, 'pot16', 18, 'AVAILABLE', 'size 9x9x11 color green', 0, 'https://i.ibb.co/N7ysCvh/16.jpg', '2021-03-30 09:08:07'),
(126, 2, 'pot17', 22, 'AVAILABLE', 'size 13x13x17 color black', 0, 'https://i.ibb.co/G74KfbD/17.jpg', '2021-03-30 09:08:07'),
(127, 2, 'pot18', 20, 'AVAILABLE', 'size 10x10x14 color white', 0, 'https://i.ibb.co/zPB8n82/18.jpg', '2021-03-30 09:08:07'),
(128, 2, 'pot19', 25, 'AVAILABLE', 'size 10x10x18 color white', 0, 'https://i.ibb.co/HdCVTRG/19.jpg', '2021-03-30 09:08:07'),
(129, 2, 'pot20', 14, 'AVAILABLE', 'size 8x8x15 color orange', 0, 'https://i.ibb.co/HdmLJNp/20.jpg', '2021-03-30 09:08:07'),
(130, 2, 'pot21', 25, 'AVAILABLE', 'size 10x10x20 color white', 0, 'https://i.ibb.co/rZZ2hpv/21.jpg', '2021-03-30 09:08:07'),
(131, 2, 'pot22', 12, 'AVAILABLE', 'size 8x8x14 color black', 0, 'https://i.ibb.co/M7z2jkB/22.jpg', '2021-03-30 09:08:07'),
(132, 2, 'pot23', 14, 'AVAILABLE', 'size 8x8x12 color green', 0, 'https://i.ibb.co/L6TTNsS/23.jpg', '2021-03-30 09:08:07'),
(133, 2, 'pot24', 15, 'AVAILABLE', 'size 9x9x12 color pink', 0, 'https://i.ibb.co/KmZ8PPH/24.jpg', '2021-03-30 09:08:07'),
(134, 2, 'pot25', 18, 'AVAILABLE', 'size 9x9x15 color yellow', 0, 'https://i.ibb.co/6yVpGXQ/25.jpg', '2021-03-30 09:08:07'),
(135, 3, 'Crystal soil', 3.5, 'AVAILABLE', 'Crystal soil, also known as flower pearl seed is artificial soil, made from tree resin, when soaked in water it has the ability to increase the size of water very well, the surface has tiny particles that the eye normally invisible but water and air do so through, and plant roots absorb water from it.\r\nAfter soaking in water for about 5-7 hours it is likely to grow from 100 -200 times the original size, you should put it in a glass, a glass pot will be very beautiful, glitter, transparent, colorful. Used as a substitute for ordinary soil to grow plants, water-loving flowers, easy to grow or to arrange flowers, decorate ... both beautiful and clean, and without watering, after a while these pearl soil particles gradually shrink. Due to dehydration, you just take the seed and soak it in water, it will enlarge and put back into the pot.\r\nUsage of crystalline soil:\r\n1. Put some crystal soil in the soaking tub.\r\n2. For a lot of water, let soak for 5-7 h, if not enough water the seeds will not reach the largest size.\r\n3. After you have enlarged, put the soil in the pot, depending on the color scheme.\r\n4. Flowers and plants after buying, discard all the land.\r\n5. Rinse the roots under the tap water. Take care to avoid damaging the root system.\r\n6. If necessary, the plant can be soaked in water for several hours to clean the soil. Cut out the roots that are too long.\r\n7. Gently place the plant in the pot.\r\n8. And now you have a flower pot, a luxurious glass pot potted plant made of glass soil.\r\nNotes when planting plants in crystal soil pots:\r\n1. Newly grown plants in crystalline soil may grow slowly, as it takes time to adapt to new environments.\r\n2. It is best to use clean water, purified water, the cleaner the water the higher the water absorption capacity of the soil.\r\n3. Add water as the seeds shrink, shrinking to almost half in size.\r\n4. If the soil becomes dirty or has an unpleasant odor, rinse it off with water.\r\n5. If needed, you can water the root balm solution more water.\r\n', 0, 'https://farm8.staticflickr.com/7366/13790384115_6a0152c464_b.jpg', '2021-03-30 09:13:16'),
(136, 3, 'colored sand', 2, 'AVAILABLE', 'Choose tempera material mixed with water or use a dry mix with sand. They are non-toxic, super economical, and washable with water. That is why this color paint is often used in preschools as well as elementary schools. To make your own custom colors try mixing different colors of dry tempera together.\r\nGlass potted plants contain colored sand that seems to bring a beautiful little garden to life.', 0, 'https://farm1.staticflickr.com/394/18674978731_d067bf37f0_b.jpg', '2021-03-30 09:13:16'),
(137, 3, 'TG2 stones', 2.5, 'AVAILABLE', 'A house with four walls with inanimate objects, though beautiful, is not as popular as before. The current home designs are mostly oriented towards comfort and relaxation for the occupants. To do that, trees are indispensable. Green trees are a simple and elegant dotted feature that brightens the living space of the house. To have a beautiful landscape, just green trees is not enough. Decorative pebbles will also be used and will be an effective tool to solve the problem of harmony in interior space.\r\n\r\nFor green trees, gravel plays the role of decoration of the pot, covering the soil layer below, preventing the dust from flying, keeping the soil, protecting the soil and keeping the plants moist. Pebbles also neutralize colors in the house, helping to create harmony, bringing sophistication, courtesy and elegance to the space.', 0, 'https://c2.staticflickr.com/8/7679/26796064210_5e75b6ec16_c.jpg', '2021-03-30 09:13:16'),
(138, 3, 'blue stones', 2.5, 'AVAILABLE', 'A house with four walls with inanimate objects, though beautiful, is not as popular as before. The current home designs are mostly oriented towards comfort and relaxation for the occupants. To do that, trees are indispensable. Green trees are a simple and elegant dotted feature that brightens the living space of the house. To have a beautiful landscape, just green trees is not enough. Decorative pebbles will also be used and will be an effective tool to solve the problem of harmony in interior space.\r\n\r\nFor green trees, gravel plays the role of decoration of the pot, covering the soil layer below, preventing the dust from flying, keeping the soil, protecting the soil and keeping the plants moist. Pebbles also neutralize colors in the house, helping to create harmony, bringing sophistication, courtesy and elegance to the space.', 0, 'https://c1.staticflickr.com/5/4363/35637742564_c3649de5e2_b.jpg', '2021-03-30 09:13:16'),
(139, 3, 'nature white stones', 2.5, 'AVAILABLE', 'For green trees, gravel plays the role of decoration of the pot, covering the soil layer below, preventing the dust from flying, keeping the soil, protecting the soil and keeping the plants moist. Pebbles also neutralize colors in the house, helping to create harmony, bringing sophistication, courtesy and elegance to the space.\r\nNatural glossy white pebbles have the size from 20 - 100mm. The pebbles are about the size of a jackfruit seed, a lemon, an egg, or a mango. The gravel has a natural glossy white color, the more polished the dry pebble. This is a high quality gravel imported from India by Vietnam Pottery Stone, the packing specification is 50kg / bag. This gravel is suitable for decoration of medium to large bonsai pots.', 0, 'https://farm9.staticflickr.com/8863/18067277133_e58ba1ae1b_b.jpg', '2021-03-30 09:13:16'),
(140, 3, 'Plastic pebbles', 2.5, 'AVAILABLE', 'There are many types of pebbles for decoration. With different types, there will be different sizes and colors. Depending on the size of the pot, the color of the pot, the color of the pot area or the overall tone of the house, you can choose the right gravel.\r\nAre you seeing that your glass vase looks so monotonous?\r\nYour aquarium needs to be more adorned?\r\nYour home\'s landscape lacks color?\r\nThe shop introduces you to artificial crystal stone beads to help you have more options to create a highlight for the interior space\r\n\r\nProduct information:\r\n- Artificial crystal stone beads - plastic pebbles\r\n- Plastic material\r\n- Size pellets: about 18x25mm\r\n- Design a multi-angled crystal shape that helps reflect colors beautifully\r\n- Color: transparent, multicolored\r\n- The set comes in a bag of 100 capsules / color\r\nCrystalline rock is used in some slime samples\r\nPlastic pebbles will be a great choice to decorate your mini aquarium, miniatures, or plant pot or flower vase for your work place.', 0, 'https://farm9.staticflickr.com/8888/18683195932_95a922bdd7_b.jpg', '2021-03-30 09:13:16'),
(141, 3, 'glass pebbles', 2.5, 'AVAILABLE', 'Pebbles are made from high quality glass and covered with a mist, high aesthetic and imported from abroad.\r\nUses: to cover small landscape, decorate pots of plants, fish tanks ...\r\nColor: ORANGE - GREEN - BLUE - GREEN - BLUE - WHITE - COFFEE\r\nSize: 25 ~ 15 mm\r\nWeight: 500g / 1 bag', 0, 'https://farm8.staticflickr.com/7434/13790385305_bcdf8c55fe_b.jpg', '2021-03-30 09:13:16'),
(142, 3, 'colored pebbles', 2.5, 'AVAILABLE', 'If the combination of pots and plants has created a wonderful beauty, now with decorative pebbles of many different colors, large and small, this beauty will be raised to new heights.\r\n\r\nTechnical information\r\n\r\nSize of each stone: 1-1.5cm\r\nWeight: 500gr bag\r\nColor: white, orange, yellow ...\r\nUses\r\n\r\nDecorate the surface of the pot, help create an aesthetic appearance for the pot\r\nWhen watering, do not splash the soil, fertilizer out, keep cleaning around the pots\r\nThere are many colors suitable for par, age, and preferences\r\nNote\r\n\r\nPebbles after a period of use will become discolored, due to water, feces or dirt, so the gravel should be changed after about 1-2 weeks, or take the pebbles out of the basin, scrub, dry and then put back in the basin\r\nShould not put stones too thick, causing unnecessary weight pots', 0, 'https://farm1.staticflickr.com/346/18661628716_137b1d0232_b.jpg', '2021-03-30 09:13:16'),
(143, 3, 'sea snail', 4, 'AVAILABLE', 'After the sea snail is harvested, one can design the shell to attract viewers, both strange and unique. Those who regularly play air trees, collecting snail shells is a unique idea. In the air tree jar, you can add a few shells and shells to decorate your jar more vividly.\r\n\r\ndecorative snail vial\r\n\r\nAt Glass Vases and flowers decorated according to customer requirements, when you have a problem with not knowing how to decorate the space to match the space where you live or the office, we can advise and decorate so that your eyes are not too cumbersome and not too ostentatious', 0, 'https://farm4.staticflickr.com/3840/15171329758_6a022a4026_b.jpg', '2021-03-30 09:13:16'),
(144, 3, 'Mosses', 4, 'AVAILABLE', 'Mosses are plants that grow from spores instead of seeds. Moss grows naturally in most of the temperate regions of the world. Although grown in moist soils, moss can grow on solid surfaces, and is often found on bark, rocks or other solid places. Therefore, moss is ideal for garden design, creating a fresh green patch for all gardens or used as surface mulch instead of grass.\r\n\r\nSome applications from moss in decoration such as:\r\n\r\nUsed as interior terrarium miniatures, desktop miniatures\r\nDesign green wall with floating moss, make moss wall in interior, garden\r\nMoss covering bonsai, small landscape, create a highlight for the miniature landscape\r\nMoss planting in small landscape hills, creating a green landscape, fresh and fresh\r\nCreative moss wall murals\r\nPut moss in the aquarium, garden stone, ... to help the landscape more natural and wild', 0, 'https://c1.staticflickr.com/9/8681/28486895205_b08b01c54d_c.jpg', '2021-03-30 09:13:16'),
(145, 3, 'Terrarium basket', 4, 'AVAILABLE', 'Please note that the above price is for a whole basket and there is no tree.\r\nThe product has 4 sizes listed below, please read carefully before buying\r\n\r\nS: Basket mouth diameter 18cm, middle diameter 22cm Height 20 cm\r\n  M: Basket mouth diameter 24cm, middle diameter 27cm, height 23cm\r\n  L: Basket mouth diameter 24cm, middle diameter 31cm, height 27cm\r\nXL: Basket mouth diameter 35cm, middle diameter 31cm, height 27cm\r\n\r\nDue to the handmade up size may deviate from 1-3cm please sympathize\r\nThe product is specialized in planting trees and storing home decorations.\r\nActual color may be slightly different from the photo because of different lighting conditions, please read it carefully before buying.', 0, 'https://c2.staticflickr.com/8/7601/27070555515_8748b9d0bd_c.jpg', '2021-03-30 09:13:16'),
(146, 3, 'hanger', 4, 'AVAILABLE', 'The hanger is made of sturdy iron, with anti-rust powder coating\r\nColor: black\r\nSize: diameter 22 cm, height 12 cm\r\nHanging round flower pots hanging from balconies, balustrades or windows brings the beauty of flowers to your eye, creating a cool green space that filters the air but is full of flowers.\r\nThe hanger is made of sturdy iron, with anti-rust powder coating\r\nColor: black\r\nSize: diameter 22 cm, height 12 cm\r\n', 0, 'https://farm1.staticflickr.com/368/19237678039_c4ef38926f_b.jpg', '2021-03-30 09:13:16'),
(147, 3, 'small trees', 1, 'AVAILABLE', 'Sometimes having the most ordinary things turn out to be the best if we know how to be creative and apply the dexterity of our hands. Let\'s come up with the unique idea of using dry branches for decoration\r\n- The product includes: 1 tree including the root as shown in the picture\r\n\r\n- Color: As shown\r\n\r\n- Material: Wood, natural tree branches, treated\r\n\r\n- Product size: Trees are from 1,2-1,5dm depending on random trees\r\n\r\n- Packing: Wrapped glass: 4x4x150c - Weight: 1500gr\r\n', 0, 'https://farm4.staticflickr.com/3917/18357397254_2c10821685_b.jpg', '2021-03-30 09:13:16'),
(148, 3, 'Cute statue', 1.2, 'AVAILABLE', 'Cute statue\r\nPlayful cute statue decorated with a desktop decorative mini-scene with a large pig-like the picture (not including trees and accessories)\r\n• Size ~ 3x5cm\r\n• Weight: 0.1kg\r\n•	Plastic material\r\n•	Made in Viet Nam\r\n• Color: Many colors\r\n• Used to decorate the table, decorate miniatures, car toys, car statues, decorate bonsai pots, desktop plants, as souven\r\n', 0, 'https://c1.staticflickr.com/5/4428/36418603565_8ebc15fb00_b.jpg', '2021-03-30 09:13:16'),
(149, 3, 'plastic fence', 4.5, 'AVAILABLE', 'The assembled plastic fence has a total length of 1.6m\r\nSet of 6 plastic fence panels, each sheet is 27cm long and 20cm high\r\nUsed to decorate around a garden tree or a Christmas tree\r\nThe assembled plastic fence has a total length of 1.6m\r\n\r\nSet of 6 plastic fence panels, each sheet is 27cm long and 20cm high', 0, 'https://salt.tikicdn.com/ts/tmp/50/3e/58/ef2fcf9b7d1cb749bd0aff2aa4eb6d05.JPG', '2021-03-30 09:13:16');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `review`
--

CREATE TABLE `review` (
  `review_id` int NOT NULL,
  `product_id` int DEFAULT NULL,
  `NAME` varchar(90) DEFAULT NULL,
  `email` varchar(90) DEFAULT NULL,
  `content` text,
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `review`
--

INSERT INTO `review` (`review_id`, `product_id`, `NAME`, `email`, `content`, `created`) VALUES
(1, 1, 'Dinh Van A', 'vana123@gmail.com', 'so beauty &#9829;', '2021-03-23 18:14:57'),
(2, 17, 'Tran', 'hangtt261099@gmail.com', 'beautiful', '2021-04-15 10:31:24');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `user_id` int NOT NULL,
  `first_name` varchar(90) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `last_name` varchar(90) NOT NULL,
  `email` varchar(90) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `dob` varchar(90) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `PASSWORD` varchar(90) DEFAULT NULL,
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`user_id`, `first_name`, `last_name`, `email`, `phone`, `dob`, `PASSWORD`, `created`) VALUES
(1, 'Dinh', 'Van A', 'vana123@gmail.com', '0123456789', '1911-01-10', 'abc123', '2021-03-09 03:14:24'),
(2, 'Nguyen', 'Van B', 'vanb456@gmail.com', '0987456322', '1992-02-12', 'abc123', '2021-03-09 03:14:24'),
(5, 'Hang', 'Tran', 'hangtt261099@gmail.com', '0328478442', '1999-10-26', 'Hang2610@', '2021-04-15 10:10:37'),
(6, 'Hang', 'Tran', 'hangtt20@gmail.com', '0123456789', '2021-01-01', 'hahalala', '2021-04-15 13:42:54'),
(7, 'trang', 'pham', 'phamtrang124@gmail.com', '0336650087', '1999-01-19', 'hello', '2021-05-04 14:16:02'),
(8, 'trang', 'pham', 'phamtrang124@gmail.com', '0336650087', '1999-01-19', 'hello', '2021-05-04 14:19:58');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `broardnew`
--
ALTER TABLE `broardnew`
  ADD PRIMARY KEY (`broadnew_id`);

--
-- Chỉ mục cho bảng `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cart_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Chỉ mục cho bảng `catalog`
--
ALTER TABLE `catalog`
  ADD PRIMARY KEY (`catalog_id`);

--
-- Chỉ mục cho bảng `discount`
--
ALTER TABLE `discount`
  ADD PRIMARY KEY (`discount_id`);

--
-- Chỉ mục cho bảng `ordered`
--
ALTER TABLE `ordered`
  ADD PRIMARY KEY (`ordered_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `catalog_id` (`catalog_id`);

--
-- Chỉ mục cho bảng `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`review_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `broardnew`
--
ALTER TABLE `broardnew`
  MODIFY `broadnew_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `cart`
--
ALTER TABLE `cart`
  MODIFY `cart_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `catalog`
--
ALTER TABLE `catalog`
  MODIFY `catalog_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `discount`
--
ALTER TABLE `discount`
  MODIFY `discount_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `ordered`
--
ALTER TABLE `ordered`
  MODIFY `ordered_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=150;

--
-- AUTO_INCREMENT cho bảng `review`
--
ALTER TABLE `review`
  MODIFY `review_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);

--
-- Các ràng buộc cho bảng `ordered`
--
ALTER TABLE `ordered`
  ADD CONSTRAINT `ordered_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`catalog_id`) REFERENCES `catalog` (`catalog_id`);

--
-- Các ràng buộc cho bảng `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `review_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
