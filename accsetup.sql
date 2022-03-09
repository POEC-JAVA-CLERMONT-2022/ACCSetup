-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 09 mars 2022 à 14:22
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `accsetup`
--

-- --------------------------------------------------------

--
-- Structure de la table `car`
--

DROP TABLE IF EXISTS `car`;
CREATE TABLE IF NOT EXISTS `car` (
  `carID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identifiant technique de la voiture',
  `carNAME` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Nom de la voiture',
  PRIMARY KEY (`carID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Table de référence des voitures';

--
-- Déchargement des données de la table `car`
--

INSERT INTO `car` (`carID`, `carNAME`) VALUES
(1, 'a'),
(2, '');

-- --------------------------------------------------------

--
-- Structure de la table `session`
--

DROP TABLE IF EXISTS `session`;
CREATE TABLE IF NOT EXISTS `session` (
  `sessionID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identifiant technique de la session',
  `sessionUSER` int(11) NOT NULL COMMENT 'Identifiant technique de l''utilisateur (join table USER)',
  `sessionCAR` int(11) NOT NULL COMMENT 'Identifiant technique de la voiture (join table CAR)',
  `sessionTRACK` int(11) NOT NULL COMMENT 'Identifiant technique du circuit (join table TRACK)',
  `sessionNAME` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Nom de la session',
  `sessionDATE` datetime NOT NULL COMMENT 'Date et heure de la session (insérée automatiquement)',
  PRIMARY KEY (`sessionID`),
  KEY `sessionUSER` (`sessionUSER`),
  KEY `sessionCAR` (`sessionCAR`),
  KEY `sessionTRACK` (`sessionTRACK`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Table de sauvegarde des sessions de l''utilisateur';

-- --------------------------------------------------------

--
-- Structure de la table `setup`
--

DROP TABLE IF EXISTS `setup`;
CREATE TABLE IF NOT EXISTS `setup` (
  `setupID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identifiant technique du réglage',
  `setupSESSION` int(11) NOT NULL COMMENT 'identifiant de référence de la session',
  `setupUSER` int(11) NOT NULL COMMENT 'identifiant de référence de l''utilisateur',
  `setupCAR` int(11) NOT NULL COMMENT 'identifiant de référence de la voiture',
  `setupTRACK` int(11) NOT NULL COMMENT 'identifiant de référence du circuit',
  `setupDATE` datetime NOT NULL COMMENT 'Date du réglage en référence à la session',
  `setupSESSIONID` int(1) DEFAULT NULL COMMENT 'Identifiant technique du réglage lié à la session (premier setup utilisé, deuxième setup utilisé...)',
  `setupFLPSI` decimal(3,1) DEFAULT NULL COMMENT 'Pression du pneu avant gauche en Psi.',
  `setupFRPSI` decimal(3,1) DEFAULT NULL COMMENT 'Pression du pneu avant droit en Psi.',
  `setupRLPSI` decimal(3,1) DEFAULT NULL COMMENT 'Pression du pneu arrière gauche en Psi.',
  `setupRRPSI` decimal(3,1) DEFAULT NULL COMMENT 'Pression du pneu arrière droit en Psi.',
  `setupFLTOE` decimal(3,2) DEFAULT NULL COMMENT 'Pincement du pneu avant gauche en degrés.',
  `setupFRTOE` decimal(3,2) DEFAULT NULL COMMENT 'Pincement du pneu avant droit en degrés.',
  `setupRLTOE` decimal(3,2) DEFAULT NULL COMMENT 'Pincement du pneu arrière gauche en degrés.',
  `setupRRTOE` decimal(3,2) DEFAULT NULL COMMENT 'Pincement du pneu arrière droit en degrés.',
  `setupFLCAMBER` decimal(2,1) DEFAULT NULL COMMENT 'Carrossage du pneu avant gauche en degrés.',
  `setupFRCAMBER` decimal(2,1) DEFAULT NULL COMMENT 'Carrossage du pneu avant droit en degrés.',
  `setupRLCAMBER` decimal(2,1) DEFAULT NULL COMMENT 'Carrossage du pneu arrière gauche en degrés.',
  `setupRRCAMBER` decimal(2,1) DEFAULT NULL COMMENT 'Carrossage du pneu arrière droit en degrés.',
  `setupFLCASTER` decimal(3,1) DEFAULT NULL COMMENT 'Angle d''incidence de la suspension avant gauche en degrés',
  `setupFRCASTER` decimal(3,1) DEFAULT NULL COMMENT 'Angle d''incidence de la suspension avant droite en degrés',
  `setupSTART` time DEFAULT NULL COMMENT 'Heure de début du roulage',
  `setupEND` time DEFAULT NULL COMMENT 'Heure de fin du roulage',
  `setupDESC` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Description du réglage',
  PRIMARY KEY (`setupID`),
  KEY `setupCAR` (`setupCAR`),
  KEY `setupSESSION` (`setupSESSION`),
  KEY `setupTRACK` (`setupTRACK`),
  KEY `setupUSER` (`setupUSER`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Table de données fonctionnelles des réglages de voiture';

-- --------------------------------------------------------

--
-- Structure de la table `setupcondition`
--

DROP TABLE IF EXISTS `setupcondition`;
CREATE TABLE IF NOT EXISTS `setupcondition` (
  `setupID` int(11) NOT NULL,
  `trackconditionID` int(11) NOT NULL,
  KEY `setupID` (`setupID`),
  KEY `trackconditionID` (`trackconditionID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Table de liaison entre setup et condition';

-- --------------------------------------------------------

--
-- Structure de la table `setupweather`
--

DROP TABLE IF EXISTS `setupweather`;
CREATE TABLE IF NOT EXISTS `setupweather` (
  `setupID` int(11) NOT NULL COMMENT 'Identifiant de setup',
  `weatherID` int(11) NOT NULL COMMENT 'Identifiant de condition météo',
  KEY `setupID` (`setupID`),
  KEY `weatherID` (`weatherID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Table de liaison entre setup et météo';

-- --------------------------------------------------------

--
-- Structure de la table `track`
--

DROP TABLE IF EXISTS `track`;
CREATE TABLE IF NOT EXISTS `track` (
  `trackID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identifiant technique de la piste',
  `trackNAME` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Nom de la piste',
  PRIMARY KEY (`trackID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Table de référence des circuits';

-- --------------------------------------------------------

--
-- Structure de la table `trackcondition`
--

DROP TABLE IF EXISTS `trackcondition`;
CREATE TABLE IF NOT EXISTS `trackcondition` (
  `trackconditionID` int(11) NOT NULL COMMENT 'Identifiant technique de la condition de piste',
  `trackconditionNAME` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Condition de piste',
  PRIMARY KEY (`trackconditionID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Table de référence des conditions de piste';

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identifiant technique de l''utilisateur',
  `userNAME` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Nom de l''utilisateur',
  `userPASSWORD` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Mot de passe de l''utilisateur, chiffré selon l''algorithme SHA1',
  PRIMARY KEY (`userID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Table des données de connexion utilisateur';

-- --------------------------------------------------------

--
-- Structure de la table `weather`
--

DROP TABLE IF EXISTS `weather`;
CREATE TABLE IF NOT EXISTS `weather` (
  `weatherID` int(11) NOT NULL COMMENT 'Identifiant technique de météo',
  `weatherNAME` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Condition météo',
  PRIMARY KEY (`weatherID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Table de référence des conditions météo';
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
