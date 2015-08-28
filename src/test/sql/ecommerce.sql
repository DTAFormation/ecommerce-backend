-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 11 Août 2015 à 09:21
-- Version du serveur :  5.6.15-log
-- Version de PHP :  5.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `ecommerceds`
--

--
-- Drop des tables existantes
--
DROP TABLE IF EXISTS `adresse`;
DROP TABLE IF EXISTS `commande_client`;
DROP TABLE IF EXISTS `commande_produits`;
DROP TABLE IF EXISTS `facture`;
DROP TABLE IF EXISTS `stock`;
DROP TABLE IF EXISTS `produit`;
DROP TABLE IF EXISTS `personne`;

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE IF NOT EXISTS `adresse` (
  `id` int(11) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `rue` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `client` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_36b8tnc4349u8ao0ikrtqu8l6` (`client`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `adresse`
--

INSERT INTO `adresse` (`id`, `numero`, `rue`, `ville`, `client`) VALUES
(1, 6, 'rue athenas', 'Nantes', 1),
(2, 1, 'rue capitaine corhumel', 'Nantes', 2),
(3, 6, 'rue athenas', 'Nantes', 3),
(4, 1, 'rue capitaine corhumel', 'Nantes', 4),
(5, 6, 'rue athenas', 'Nantes', 5),
(6, 1, 'rue capitaine corhumel', 'Nantes', 6),
(7, 6, 'rue athenas', 'Nantes', 7),
(8, 1, 'rue capitaine corhumel', 'Nantes', 8),
(9, 6, 'rue athenas', 'Nantes', 9),
(10, 1, 'rue capitaine corhumel', 'Nantes', 10),
(11, 6, 'rue athenas', 'Nantes', 11),
(12, 1, 'rue capitaine corhumel', 'Nantes', 12),
(13, 6, 'rue athenas', 'Nantes', 13),
(14, 1, 'rue capitaine corhumel', 'Nantes', 14),
(15, 6, 'rue athenas', 'Nantes', 15),
(16, 1, 'rue capitaine corhumel', 'Nantes', 16),
(17, 6, 'rue athenas', 'Nantes', 17),
(18, 1, 'rue capitaine corhumel', 'Nantes', 18),
(19, 6, 'rue athenas', 'Nantes', 19),
(20, 1, 'rue capitaine corhumel', 'Nantes', 20),
(21, 17, 'rue des cerisiers', 'Nantes', 1),
(22, 17, 'rue des cerisiers', 'Nantes', 5),
(23, 17, 'rue des cerisiers', 'Nantes', 10),
(24, 17, 'rue des cerisiers', 'Nantes', 15),
(25, 666, 'rue du diable', 'Enfer', 21);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE IF NOT EXISTS `produit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `caracteristique` varchar(255) DEFAULT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `prix` float DEFAULT NULL,
  `actif` boolean DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`id`, `libelle`, `caracteristique`, `categorie`, `image`, `prix`, `actif`) VALUES
(1, 'Truc High-Tech', 'Il sert à rien mais il est cool', 'High-Tech', 'http://lorempixel.com/200/200/technics', 100, true),
(2, 'Moto', 'Elle a 2 roues et un guidon', 'Vehicule', 'http://lorempixel.com/200/200/transport', 2999.99, true),
(3, 'Chat', 'Très affectueux', 'Animaux de compagnie', 'http://lorempixel.com/200/200/cats', 9.99, true),
(4, 'Kebab', 'Viande de qualité, frites de qualité', 'Alimentation', 'http://lorempixel.com/200/200/food', 9.99, true),
(5, 'Batte de baseball', 'A peu servi', 'Sports', 'http://lorempixel.com/200/200/sports', 99.99, true),
(6, 'Truc High-Tech', 'Il sert à rien mais il est cool', 'High-Tech', 'http://lorempixel.com/200/200/technics/1', 100, true),
(7, 'Moto', 'Elle a 2 roues et un guidon', 'Vehicule', 'http://lorempixel.com/200/200/transport/1', 2999.99, true),
(8, 'Chat', 'Très affectueux', 'Animaux de compagnie', 'http://lorempixel.com/200/200/cats/1', 9.99, true),
(9, 'Kebab', 'Viande de qualité, frites de qualité', 'Alimentation', 'http://lorempixel.com/200/200/food/1', 9.99, true),
(10, 'Batte de baseball', 'A peu servi', 'Sports', 'http://lorempixel.com/200/200/sports/1', 99.99, true),
(11, 'Truc High-Tech', 'Il sert à rien mais il est cool', 'High-Tech', 'http://lorempixel.com/200/200/technics/2', 100, true),
(12, 'Moto', 'Elle a 2 roues et un guidon', 'Vehicule', 'http://lorempixel.com/200/200/transport/2', 2999.99, true),
(13, 'Chat', 'Très affectueux', 'Animaux de compagnie', 'http://lorempixel.com/200/200/cats/2', 9.99, true),
(14, 'Kebab', 'Viande de qualité, frites de qualité', 'Alimentation', 'http://lorempixel.com/200/200/food/2', 9.99, true),
(15, 'Batte de baseball', 'A peu servi', 'Sports', 'http://lorempixel.com/200/200/sports/2', 99.99, true),
(16, 'Chat Psychedelique', 'Très agressif pout les yeux', 'Animaux de compagnie', 'http://i2.wp.com/h16free.com/wp-content/uploads/2015/05/psychedelic-cat.gif', 9999.99, true),
(17, 'Nyan cat vegeta', 'ne pas manger', 'Animaux de compagnie', 'http://img2.wikia.nocookie.net/__cb20121227151943/dragonball/images/e/e2/Vegeta_nyan_cat.gif', 0.99, true);

-- --------------------------------------------------------

--
-- Structure de la table `commande_client`
--

CREATE TABLE IF NOT EXISTS `commande_client` (
  `id` int(11) NOT NULL,
  `etat` varchar(255) NOT NULL,
  `client` int(11) NOT NULL,
  `facture` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t4g3urlfvjrlqv7dyqtb6yexp` (`client`),
  KEY `FK_i4bkwbbi77x1bxrf0pnxdjbmm` (`facture`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `commande_client`
--

INSERT INTO `commande_client` (`id`, `etat`, `client`, `facture`) VALUES
  (1, "TR", 1, 1),
  (2, "TR", 2, 2),
  (3, "TR", 3, 3),
  (4, "EC", 3, 4),
  (5, "EC", 4, 5),
  (6, "TR", 9, 6),
  (7, "TR", 7, 7),
  (8, "AN", 7, 8),
  (9, "TR", 9, 9),
  (10, "TR", 11, 10),
  (11, "TR", 3, 11),
  (12, "TR", 13, 12),
  (13, "TR", 8, 13),
  (14, "EC", 8, 14),
  (15, "EC", 15, 15);

-- --------------------------------------------------------

--
-- Structure de la table `commande_produits`
--

CREATE TABLE IF NOT EXISTS `commande_produits` (
  `id` int(11) NOT NULL,
  `quantite` int(11) DEFAULT NULL,
  `produit` int(11) DEFAULT NULL,
  `commande_client` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rep7jckdgga7pmsfqrqlarouo` (`produit`),
  KEY `FK_htwgujvxcc9artiwme1s3fw0c` (`commande_client`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `commande_produits`
--

INSERT INTO `commande_produits` (`id`, `quantite`, `produit`, `commande_client`) VALUES
(1, 2, 4, 1),
(2, 1, 2, 1),
(3, 3, 1, 2),
(4, 2, 2, 3),
(5, 1, 9, 4),
(6, 3, 12, 4),
(7, 1, 6, 5),
(8, 2, 3, 6),
(9, 5, 9, 7),
(10, 1, 12, 8),
(11, 4, 5, 8),
(12, 3, 6, 9),
(13, 2, 5, 10),
(14, 1, 6, 11),
(15, 4, 6, 12),
(16, 4, 14, 13),
(17, 4, 2, 14),
(18, 4, 8, 15);


-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE IF NOT EXISTS `facture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `modepaiement` varchar(255) DEFAULT NULL,
  `montant` float (11) DEFAULT NULL,
  `adressefacturation` int(11) DEFAULT NULL,
  `adresselivraison` int(11) DEFAULT NULL,
  `commande_client` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ilt50sov3o16ehpn4ckgt08do` (`adressefacturation`),
  KEY `FK_bt86xk42muci5i072vesiyxjh` (`adresselivraison`),
  KEY `FK_fd9xc33bdvb29v6kssset4cup` (`commande_client`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `facture`
--

INSERT INTO `facture` (`id`, `date`, `modepaiement`, `montant`, `adresselivraison`, `adressefacturation`, `commande_client`) VALUES
(1, '2015-01-01', 'Par CB',0, 1, 21, 1),
(2, '2015-01-01', 'Par CB',0, 2, 2, 2),
(3, '2015-01-01', 'Par CB',0, 3, 3, 3),
(4, '2015-05-01', 'Par CB',0, 3, 3, 4),
(5, '2015-03-01', 'Par CB',0, 4, 4, 5),
(6, '2015-04-01', 'Par CB',0, 9, 9, 6),
(7, '2015-06-01', 'Par CB',0, 7, 7, 7),
(8, '2015-08-01', 'Par CB',0, 7, 7, 8),
(9, '2015-02-01', 'Par CB',0, 9, 9, 9),
(10, '2015-02-01', 'Par CB',0, 11, 11, 10),
(11, '2015-06-01', 'Par CB',0, 3, 3, 11),
(12, '2015-07-01', 'Par CB',0, 13, 13, 12),
(13, '2015-07-01', 'Par CB',0, 8, 8, 13),
(14, '2015-04-01', 'Par CB',0, 8, 8, 14),
(15, '2015-08-01', 'Par CB',0, 15, 24, 15);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE IF NOT EXISTS `personne` (
  `type_personne` varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `actif` boolean DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`id`, `actif`, `nom`, `prenom`, `login`, `password`, `TYPE_PERSONNE`) VALUES
(1, true, 'OFFREDO', 'Simon', 'login', 'pwd', 'U'),
(2, true, 'GUILLOTEAU', 'Nathan', 'loginDeNathan', 'pwdDeNathan', 'U'),
(3, true, 'LEBON', 'Jonathan', 'loginDeJo', 'pwdDeJo', 'U'),
(4, true, 'MACHAUX', 'Frederic', 'loginDeFred', 'pwdDeFred', 'U'),
(5, true, 'STRATEUR', 'Admini', 'loginAdmin', 'pwdAdmin', 'A'),
(6, true, 'ADMINISTRATEUR', 'Un-Autre', 'loginAutreAdmin', 'pwdAutreAdmin', 'A'),
(7, true, 'FARAU', 'Romain', 'loginRomain', 'pwdRomain', 'U'),
(8, true, 'KLEIN', 'Pauline', 'loginPauline', 'pwdPauline', 'U'),
(9, true, 'USER1', 'User1', 'loginUser1', 'pwdUser1', 'U'),
(10, true, 'USER2', 'User2', 'loginUser2', 'pwdUser2', 'U'),
(11, true, 'USER3', 'User3', 'loginUser3', 'pwdUser3', 'U'),
(12, true, 'USER4', 'User4', 'loginUser4', 'pwdUser4', 'U'),
(13, true, 'USER5', 'User5', 'loginUser5', 'pwdUser5', 'U'),
(14, true, 'USER6', 'User6', 'loginUser6', 'pwdUser6', 'U'),
(15, true, 'USER7', 'User7', 'loginUser7', 'pwdUser7', 'U'),
(16, true, 'USER8', 'User8', 'loginUser8', 'pwdUser8', 'U'),
(17, true, 'USER9', 'User9', 'loginUser9', 'pwdUser9', 'U'),
(18, true, 'USER10', 'User10', 'loginUser10', 'pwdUser10', 'U'),
(19, true, 'USER11', 'User11', 'loginUser11', 'pwdUser11', 'U'),
(20, true, 'USER12', 'User12', 'loginUser12', 'pwdUser12', 'U'),
(21, true, 'aaa', 'bbb', 'aaa@yopmail.com', 'c1c2c3', 'U'),
(22, true, 'admin', 'istrateur', 'admin@yopmail.com', 'c1c2c3', 'A');

-- --------------------------------------------------------

--
-- Structure de la table `stock`
--

CREATE TABLE IF NOT EXISTS `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qte` int(11) DEFAULT NULL,
  `prod` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_3wmkcdc4uc27yycyxy49ouuqf` (`prod`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `produit`
--

INSERT INTO `stock` (`id`, `qte`, `prod`) VALUES
(1, 50, 1),
(2, 25, 2),
(3, 10, 3),
(4, 17, 4),
(5, 22, 5),
(6, 15, 6),
(7, 45, 7),
(8, 17, 8),
(9, 22, 9),
(10, 35, 10),
(11, 12, 11),
(12, 14, 12),
(13, 68, 13),
(14, 16, 14),
(15, 28, 15);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
