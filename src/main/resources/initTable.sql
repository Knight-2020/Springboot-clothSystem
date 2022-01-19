create table `user` (
    `username` varchar(255),
    `password` varchar(255),
    `role` varchar(255),
    `height` varchar(255),
    `weight` varchar(255),
    `bra` varchar(255),
    `yao` varchar(255),
    `ass` varchar(255),
    `id` int(11) AUTO_INCREMENT PRIMARY KEY,
    `create_at` datetime,
    `update_at` datetime
);

create table `type` (
    `name` varchar(255),
    `id` int(11) AUTO_INCREMENT PRIMARY KEY,
    `create_at` datetime,
    `update_at` datetime
);

create table `cloth` (
    `name` varchar(255),
    `type_id` int(11),
    `image` varchar(255),
    `id` int(11) AUTO_INCREMENT PRIMARY KEY,
    `create_at` datetime,
    `update_at` datetime
);

create table `suit` (
    `name` varchar(255),
    `cloth_ids` varchar(255),
    `cloth_images` varchar(5000),
    `id` int(11) AUTO_INCREMENT PRIMARY KEY,
    `create_at` datetime,
    `update_at` datetime
);

create table `role` (
    `id` int(11) AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(255),
    `description` varchar(255),
    `create_at` datetime,
    `update_at` datetime
);

create table `menu` (
    `id` int(11) AUTO_INCREMENT PRIMARY KEY,
    `parent_id` int(11),
    `name` varchar(255),
    `icon` varchar(255),
    `role` varchar(255),
    `href` varchar(255),
    `create_at` datetime,
    `update_at` datetime
);

create table `permission` (
    `id` int(11) AUTO_INCREMENT PRIMARY KEY,
    `role` varchar(255),
    `model` varchar(255),
    `operation` varchar(255),
    `create_at` datetime,
    `update_at` datetime
);



