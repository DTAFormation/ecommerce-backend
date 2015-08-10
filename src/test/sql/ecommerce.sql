-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 10 Août 2015 à 13:47
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `ecommerce`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--
DROP TABLE `adresse`;
DROP TABLE `commande`;
DROP TABLE `commande_produit`;
DROP TABLE `facture`;
DROP TABLE `stock`;
DROP TABLE `produit`;
DROP TABLE `personne`;


CREATE TABLE IF NOT EXISTS `adresse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  `rue` varchar(55) NOT NULL,
  `ville` varchar(55) NOT NULL,
  `client` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=93 ;

--
-- Contenu de la table `adresse`
--

INSERT INTO `adresse` (`id`, `numero`, `rue`, `ville`, `client`) VALUES
(87, 6, 'rue athenas', 'Nantes', 88),
(88, 1, 'rue capitaine corhumel', 'Nantes', 88),
(89, 6, 'rue athenas', 'Nantes', 89),
(90, 1, 'rue capitaine corhumel', 'Nantes', 89),
(91, 6, 'rue athenas', 'Nantes', 90),
(92, 1, 'rue capitaine corhumel', 'Nantes', 90);

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client` int(11) NOT NULL,
  `etat` varchar(55) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=39 ;

--
-- Contenu de la table `commande`
--

INSERT INTO `commande` (`id`, `client`, `etat`) VALUES
(36, 88, 'en cours'),
(37, 89, 'en cours'),
(38, 90, 'en cours');

-- --------------------------------------------------------

--
-- Structure de la table `commande_produit`
--

CREATE TABLE IF NOT EXISTS `commande_produit` (
  `commande` int(11) NOT NULL,
  `produit` int(11) NOT NULL,
  PRIMARY KEY (`commande`,`produit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `commande_produit`
--

INSERT INTO `commande_produit` (`commande`, `produit`) VALUES
(36, 39),
(37, 40),
(38, 41);

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE IF NOT EXISTS `facture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `modepaiement` varchar(55) NOT NULL,
  `adresselivraison` int(11) NOT NULL,
  `adressefacturation` int(11) NOT NULL,
  `commande` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Contenu de la table `facture`
--

INSERT INTO `facture` (`id`, `date`, `modepaiement`, `adresselivraison`, `adressefacturation`, `commande`) VALUES
(22, '1970-01-01', 'Par CB', 87, 88, 36),
(23, '1970-01-01', 'Par CB', 89, 90, 37),
(24, '1970-01-01', 'Par CB', 91, 92, 38);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE IF NOT EXISTS `personne` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(55) NOT NULL,
  `prenom` varchar(55) NOT NULL,
  `login` varchar(55) NOT NULL,
  `password` varchar(55) NOT NULL,
  `TYPE_PERSONNE` varchar(31) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=101 ;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`, `login`, `password`, `TYPE_PERSONNE`) VALUES
(87, 'modif', 'test', 'truc', 'machin', 'U'),
(88, 'GUILLOTEAU', 'Nathan', 'login', 'login', 'U'),
(89, 'GUILLOTEAU', 'Nathan', 'login', 'login', 'U'),
(90, 'GUILLOTEAU', 'Nathan', 'login', 'login', 'U'),
(93, 'Admin test', 'Test', 'loginAdmin', 'PwdAdmin', 'A'),
(94, 'Admin test', 'Test', 'loginAdmin', 'PwdAdmin', 'A'),
(95, 'Admin test', 'Test', 'loginAdmin', 'PwdAdmin', 'A'),
(96, 'Admin test', 'Test', 'loginAdmin', 'PwdAdmin', 'A'),
(97, 'Sans sss test modif', 'Test', 'loginAdmin', 'PwdAdmin', 'A');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE IF NOT EXISTS `produit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(55) NOT NULL,
  `caracteritique` text NOT NULL,
  `categorie` varchar(55) NOT NULL,
  `image` varchar(55) NOT NULL,
  `prix` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=42 ;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`id`, `libelle`, `caracteritique`, `categorie`, `image`, `prix`) VALUES
(39, 'Velo', 'Il roule', 'Vehicule', 'url/image', 4),
(40, 'Velo', 'Il roule', 'Vehicule', 'url/image', 4),
(41, 'Velo', 'Il roule', 'Vehicule', 'url/image', 4);

-- --------------------------------------------------------

--
-- Structure de la table `stock`
--

CREATE TABLE IF NOT EXISTS `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prod` int(11) NOT NULL,
  `qte` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Contenu de la table `stock`
--

INSERT INTO `stock` (`id`, `prod`, `qte`) VALUES
(13, 39, 4),
(14, 40, 4),
(15, 41, 4);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
