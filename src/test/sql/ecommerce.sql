-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 10 Août 2015 à 16:35
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

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

DROP TABLE IF EXISTS `adresse`;
DROP TABLE IF EXISTS `commande_client`;
DROP TABLE IF EXISTS `commande_produits`;
DROP TABLE IF EXISTS `facture`;
DROP TABLE IF EXISTS `produit`;
DROP TABLE IF EXISTS `stock`;
DROP TABLE IF EXISTS `personne`;

CREATE TABLE IF NOT EXISTS `adresse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) DEFAULT NULL,
  `rue` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `client` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_36b8tnc4349u8ao0ikrtqu8l6` (`client`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `adresse`
--

INSERT INTO `adresse` (`id`, `numero`, `rue`, `ville`, `client`) VALUES
(1, 21, 'sdfsdf', 'sdfsdf', 1);

-- --------------------------------------------------------

--
-- Structure de la table `commande_client`
--

CREATE TABLE IF NOT EXISTS `commande_client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `etat` varchar(255) DEFAULT NULL,
  `client` int(11) DEFAULT NULL,
  `facture` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t4g3urlfvjrlqv7dyqtb6yexp` (`client`),
  KEY `FK_i4bkwbbi77x1bxrf0pnxdjbmm` (`facture`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `commande_client`
--

INSERT INTO `commande_client` (`id`, `etat`, `client`, `facture`) VALUES
(1, 'en cours', 1, NULL);

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
(0, 1, 1, 1);

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`type_personne`, `id`, `login`, `nom`, `password`, `prenom`) VALUES
('U', 1, 'aze@aze', 'aze', 'azeaze', 'aze');

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`id`, `caracteritique`, `categorie`, `image`, `libelle`, `prix`) VALUES
(1, 'beau vélo', 'vélo', NULL, 'vélo bleu', 125);

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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
