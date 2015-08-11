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
(24, 17, 'rue des cerisiers', 'Nantes', 15);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE IF NOT EXISTS `produit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `caracteritique` varchar(255) DEFAULT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `prix` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`id`, `libelle`, `caracteritique`, `categorie`, `image`, `prix`) VALUES
(1, 'Truc High-Tech', 'Il sert à rien mais il est cool', 'High-Tech', 'http://lorempixel.com/200/200/technics', 100),
(2, 'Moto', 'Elle a 2 roues et un guidon', 'Vehicule', 'http://lorempixel.com/200/200/transport', 2999.99),
(3, 'Chat', 'Très affectueux', 'Animaux de compagnie', 'http://lorempixel.com/200/200/cats', 9.99),
(4, 'Kebab', 'Viande de qualité, frites de qualité', 'Alimentation', 'http://lorempixel.com/200/200/food', 9.99),
(5, 'Batte de baseball', 'A peu servi', 'Sports', 'http://lorempixel.com/200/200/sports', 99.99),
(6, 'Truc High-Tech', 'Il sert à rien mais il est cool', 'High-Tech', 'http://lorempixel.com/200/200/technics', 100),
(7, 'Moto', 'Elle a 2 roues et un guidon', 'Vehicule', 'http://lorempixel.com/200/200/transport', 2999.99),
(8, 'Chat', 'Très affectueux', 'Animaux de compagnie', 'http://lorempixel.com/200/200/cats', 9.99),
(9, 'Kebab', 'Viande de qualité, frites de qualité', 'Alimentation', 'http://lorempixel.com/200/200/food', 9.99),
(10, 'Batte de baseball', 'A peu servi', 'Sports', 'http://lorempixel.com/200/200/sports', 99.99),
(11, 'Truc High-Tech', 'Il sert à rien mais il est cool', 'High-Tech', 'http://lorempixel.com/200/200/technics', 100),
(12, 'Moto', 'Elle a 2 roues et un guidon', 'Vehicule', 'http://lorempixel.com/200/200/transport', 2999.99),
(13, 'Chat', 'Très affectueux', 'Animaux de compagnie', 'http://lorempixel.com/200/200/cats', 9.99),
(14, 'Kebab', 'Viande de qualité, frites de qualité', 'Alimentation', 'http://lorempixel.com/200/200/food', 9.99),
(15, 'Batte de baseball', 'A peu servi', 'Sports', 'http://lorempixel.com/200/200/sports', 99.99);

-- --------------------------------------------------------

--
-- Structure de la table `commande_client`
--

CREATE TABLE IF NOT EXISTS `commande_client` (
  `id` int(11) NOT NULL,
  `etat` varchar(255) DEFAULT NULL,
  `client` int(11) DEFAULT NULL,
  `facture` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t4g3urlfvjrlqv7dyqtb6yexp` (`client`),
  KEY `FK_i4bkwbbi77x1bxrf0pnxdjbmm` (`facture`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `commande_client`
--

INSERT INTO `commande_client` (`id`, `etat`, `client`, `facture`) VALUES
  (1, "Terminée", 1, 1),
  (2, "Terminée", 2, 2),
  (3, "Terminée", 3, 3),
  (4, "En cours", 3, 4),
  (5, "En cours", 4, 5),
  (6, "Terminée", 9, 6),
  (7, "Terminée", 7, 7),
  (8, "Annulée", 7, 8),
  (9, "Terminée", 9, 9),
  (10, "Terminée", 11, 10),
  (11, "Terminée", 3, 11),
  (12, "Terminée", 13, 12),
  (13, "Terminée", 8, 13),
  (14, "En cours", 8, 14),
  (15, "En cours", 15, 15);

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

INSERT INTO `facture` (`id`, `date`, `modepaiement`, `adresselivraison`, `adressefacturation`, `commande_client`) VALUES
(1, '1970-01-01', 'Par CB', 1, 21, 1),
(2, '1971-01-01', 'Par CB', 2, 2, 2),
(3, '1972-01-01', 'Par CB', 3, 3, 3),
(4, '1973-01-01', 'Par CB', 3, 3, 4),
(5, '1974-01-01', 'Par CB', 4, 4, 5),
(6, '1975-01-01', 'Par CB', 9, 9, 6),
(7, '2000-01-01', 'Par CB', 7, 7, 7),
(8, '2001-01-01', 'Par CB', 7, 7, 8),
(9, '2002-01-01', 'Par CB', 9, 9, 9),
(10, '2003-01-01', 'Par CB', 11, 11, 10),
(11, '2004-01-01', 'Par CB', 3, 3, 11),
(12, '2005-01-01', 'Par CB', 13, 13, 12),
(13, '2006-01-01', 'Par CB', 8, 8, 13),
(14, '2007-01-01', 'Par CB', 8, 8, 14),
(15, '2008-01-01', 'Par CB', 15, 24, 15);

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
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`, `login`, `password`, `TYPE_PERSONNE`) VALUES
(1, 'OFFREDO', 'Simon', 'login', 'pwd', 'U'),
(2, 'GUILLOTEAU', 'Nathan', 'loginDeNathan', 'pwdDeNathan', 'U'),
(3, 'LEBON', 'Jonathan', 'loginDeJo', 'pwdDeJo', 'U'),
(4, 'MACHAUX', 'Frederic', 'loginDeFred', 'pwdDeFred', 'U'),
(5, 'STRATEUR', 'Admini', 'loginAdmin', 'pwdAdmin', 'A'),
(6, 'ADMINISTRATEUR', 'Un-Autre', 'loginAutreAdmin', 'pwdAutreAdmin', 'A'),
(7, 'FARAU', 'Romain', 'loginRomain', 'pwdRomain', 'U'),
(8, 'KLEIN', 'Pauline', 'loginPauline', 'pwdPauline', 'U'),
(9, 'USER1', 'User1', 'loginUser1', 'pwdUser1', 'U'),
(10, 'USER2', 'User2', 'loginUser2', 'pwdUser2', 'U'),
(11, 'USER3', 'User3', 'loginUser3', 'pwdUser3', 'U'),
(12, 'USER4', 'User4', 'loginUser4', 'pwdUser4', 'U'),
(13, 'USER5', 'User5', 'loginUser5', 'pwdUser5', 'U'),
(14, 'USER6', 'User6', 'loginUser6', 'pwdUser6', 'U'),
(15, 'USER7', 'User7', 'loginUser7', 'pwdUser7', 'U'),
(16, 'USER8', 'User8', 'loginUser8', 'pwdUser8', 'U'),
(17, 'USER9', 'User9', 'loginUser9', 'pwdUser9', 'U'),
(18, 'USER10', 'User10', 'loginUser10', 'pwdUser10', 'U'),
(19, 'USER11', 'User11', 'loginUser11', 'pwdUser11', 'U'),
(20, 'USER12', 'User12', 'loginUser12', 'pwdUser12', 'U');

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
